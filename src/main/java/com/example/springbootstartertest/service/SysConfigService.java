package com.example.springbootstartertest.service;

import com.example.springbootstartertest.model.table.SysConfig;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @version 1.0
 * @author: TheFei
 * @Date: 2022-06-22
 * @Time: 13:25
 */
public interface SysConfigService extends IService<SysConfig>
{
    void add();
}
