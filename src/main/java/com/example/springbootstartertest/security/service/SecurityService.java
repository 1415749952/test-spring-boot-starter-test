package com.example.springbootstartertest.security.service;

import com.reststyle.security.model.SecurityRole;
import com.reststyle.security.model.SecurityUser;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @version 1.0
 * @author: TheFei
 * @Date: 2021-03-26
 * @Time: 20:59
 */
public interface SecurityService
{
    SecurityUser selectUserByUserName(String username);

    List<SecurityRole> selectSecurityRoleByUserId(SecurityUser user);

    List<String> selectPermissionByUserId(SecurityUser securityUser);

}
