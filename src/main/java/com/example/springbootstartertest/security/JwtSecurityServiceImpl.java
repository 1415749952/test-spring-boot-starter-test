package com.example.springbootstartertest.security;

import com.example.springbootstartertest.service.SecurityService;
import com.reststyle.redis.utils.RedisUtils;
import com.reststyle.security.model.SecurityAuthority;
import com.reststyle.security.model.SecurityRole;
import com.reststyle.security.model.SecurityUser;
import com.reststyle.security.model.login.AccountInfo;
import com.reststyle.security.support.JwtSecurityService;
import com.reststyle.security.utils.SecurityUtils;
import com.reststyle.springutils.utils.JacksonUtils;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @version 1.0
 * @author: TheFei
 * @Date: 2022-06-15
 * @Time: 13:48
 */
@Component
public class JwtSecurityServiceImpl implements JwtSecurityService
{
    @Autowired
    private SecurityService securityService;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public AccountInfo checkLoginInfo(InputStream loginBody)
    {
        MyLoginBody body = JacksonUtils.json2Object(loginBody, MyLoginBody.class);
        //校验登录信息
        if (null == body)
        {
            throw new BadCredentialsException("登录信息输入为空");
        }
        if (StringUtils.isBlank(body.getUsername()))
        {
            throw new BadCredentialsException("用户名为空");
        }
        if (StringUtils.isBlank(body.getPassword()))
        {
            throw new BadCredentialsException("密码为空");
        }
        if (StringUtils.isBlank(body.getCode()))
        {
            throw new BadCredentialsException("验证码为空");
        }
        if (StringUtils.isBlank(body.getUuid()))
        {
            throw new BadCredentialsException("定位验证码UUID为空");
        }
        //校验验证码

        return new AccountInfo(body.getUsername(), body.getPassword());
    }

    @Override
    public SecurityUser login(Authentication authentication)
    {
        // 获取表单输入中返回的用户名
        String username = (String) authentication.getPrincipal();
        // 获取表单中输入的密码
        String password = (String) authentication.getCredentials();
        SecurityUser securityUser = this.loadUserByUsername(username);
        // 我们还要判断密码是否正确，这里我们的密码使用BCryptPasswordEncoder进行加密的
        if (!SecurityUtils.matchesPassword(password, securityUser.getPassword()))
        {
            throw new BadCredentialsException("密码不正确");
        }
        return securityUser;
    }


    @Override
    public void logout()
    {
        //推出登录时要做的操作，如记录登出日志
    }

    @Override
    public SecurityUser checkToken(Claims claims)
    {
        // 获取用户名
        String username = claims.getSubject();
        //token版本
        String revision = claims.get("revision")
                                .toString();
        SecurityUser securityUser = this.loadUserByUsername(username);
        // 我们还要判断token是否是更改密码前，后者是退出登陆后
        if (!revision.equals(securityUser.getRevision()
                                         .toString()))
        {
            throw new BadCredentialsException("更改密码后,或者退出登录后token失效");
        }
        return securityUser;
    }

    @Override
    public SecurityUser loadUserByUsername(String username) throws UsernameNotFoundException
    {
        // 查询用户是否存在
        SecurityUser user = securityService.selectUserByUserName(username);
        if (null == user)
        {
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        }
        if (!user.isEnabled())
        {
            throw new BadCredentialsException("对不起，您的账号：" + username + " 已被停用");
        }
        if (!user.isAccountNonLocked())
        {
            throw new BadCredentialsException("对不起，您的账号：" + username + " 已被锁定");
        }
        if (!user.isAccountNonExpired())
        {
            throw new BadCredentialsException("对不起，您的账号：" + username + " 已过期");
        }
        if (!user.isCredentialsNonExpired())
        {
            throw new BadCredentialsException("对不起，您的账号：" + username + " 凭证已过期");
        }
        // 角色集合
        Set<SecurityAuthority> authorities = new HashSet<>();
        // 查询用户角色
        List<SecurityRole> securityRoles = securityService.selectSecurityRoleByUserId(user);
        user.setSecurityRoles(securityRoles);

        List<String> permissions = securityService.selectPermissionByUserId(user);
        for (String permission : permissions)
        {
            authorities.add(new SecurityAuthority(permission));
        }
        user.setAuthorities(authorities);
        return user;
    }
}
