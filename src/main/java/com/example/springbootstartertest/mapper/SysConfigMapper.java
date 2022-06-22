package com.example.springbootstartertest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootstartertest.model.table.SysConfig;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @version 1.0
 * @author: TheFei
 * @Date: 2022-06-22
 * @Time: 13:25
 */
@Mapper
@Repository
public interface SysConfigMapper extends BaseMapper<SysConfig>
{
}