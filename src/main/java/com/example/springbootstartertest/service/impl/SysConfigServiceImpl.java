package com.example.springbootstartertest.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootstartertest.mapper.SysConfigMapper;
import com.example.springbootstartertest.model.table.SysConfig;
import com.example.springbootstartertest.service.SysConfigService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @version 1.0
 * @author: TheFei
 * @Date: 2022-06-22
 * @Time: 13:25
 */
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements SysConfigService
{

    @Override
    public void add()
    {
        SysConfig sysConfig = new SysConfig();
        sysConfig.setConfigId(111);
        sysConfig.setConfigName("1111");
        sysConfig.setConfigKey("111");
        sysConfig.setConfigValue("111");
        sysConfig.setConfigType("1");
        sysConfig.setCreateBy("11111");
        sysConfig.setCreateTime(new Date());
        sysConfig.setUpdateBy("");
        sysConfig.setUpdateTime(new Date());
        sysConfig.setRemark("");

        SysConfig sysConfig1 = new SysConfig();
        sysConfig1.setConfigId(222);
        sysConfig1.setConfigName("222");
        sysConfig1.setConfigKey("222");
        sysConfig1.setConfigValue("222");
        sysConfig1.setConfigType("2");
        sysConfig1.setCreateBy("222");
        sysConfig1.setCreateTime(new Date());
        sysConfig1.setUpdateBy("");
        sysConfig1.setUpdateTime(new Date());
        sysConfig1.setRemark("");
        List<SysConfig> list = new ArrayList<>();
        list.add(sysConfig);
        list.add(sysConfig1);

        this.saveBatch(list);

    }
}
