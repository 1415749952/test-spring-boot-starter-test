package com.example.springbootstartertest.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @version 1.0
 * @author: TheFei
 * @Date: 2022-06-16
 * @Time: 13:46
 */
@RestController
public class TestController
{
    @GetMapping("/web/test/a")
    public void  getname(){
        System.out.println("fwfjijfewoifwiufew9uefhww");
    }
    @GetMapping("/webApp/test/a")
    public void  getname1(){
        System.out.println("/webApp/test/a");
    }
    @GetMapping("/test/permission")
    @PreAuthorize("hasAuthority('system:user:list222')")
    public void testPermission()
    {
        System.out.println("/webApp/test/a");
    }
}
