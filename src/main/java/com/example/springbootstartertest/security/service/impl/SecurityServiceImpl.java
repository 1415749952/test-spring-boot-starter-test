package com.example.springbootstartertest.security.service.impl;

import com.example.springbootstartertest.security.mapper.SecurityMapper;
import com.example.springbootstartertest.security.service.SecurityService;
import com.reststyle.security.model.SecurityRole;
import com.reststyle.security.model.SecurityUser;
import com.reststyle.security.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @version 1.0
 * @author: TheFei
 * @Date: 2021-03-26
 * @Time: 20:59
 */
@Service
public class SecurityServiceImpl implements SecurityService
{
    @Autowired
    private SecurityMapper securityMapper;


    @Cacheable(value = "login", key = "'user:'+#username", unless = "#result==null")
    @Override
    public SecurityUser selectUserByUserName(String username)
    {
        return securityMapper.selectSecurityUserByUserName(username);
    }

    @Cacheable(value = "login", key = "'role:'+#user.getUsername()", unless = "#result?.size()<1")
    @Override
    public List<SecurityRole> selectSecurityRoleByUserId(SecurityUser user)
    {
        return securityMapper.selectSecurityRoleByUserId(user.getUserId());
    }


    @Cacheable(value = "login", key = "'permission:'+#user.getUsername()", unless = "#result?.size()<1")
    @Override
    public List<String> selectPermissionByUserId(SecurityUser user)
    {

        List<String> menuList;
        // 管理员拥有所有权限
        if (SecurityUtils.isAdmin(user))
        {
            menuList = securityMapper.selectAllMenu();
        }
        else
        {
            Set<Long> roleIds = Optional.ofNullable(user.getSecurityRoles()).orElse(new ArrayList<>()).stream().map(SecurityRole::getRoleId).collect(Collectors.toSet());
            menuList = securityMapper.selectMenuPermsByRoleIds(roleIds);
        }
        return menuList;
    }
}
