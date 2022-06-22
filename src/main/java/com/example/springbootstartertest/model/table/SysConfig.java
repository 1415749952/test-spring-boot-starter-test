package com.example.springbootstartertest.model.table;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @version 1.0
 * @author: TheFei
 * @Date: 2022-06-22
 * @Time: 13:25
 */

/**
 * 参数配置表
 */
@TableName(value = "sys_config")
public class SysConfig
{
    /**
     * 参数主键
     */
    @TableId(value = "config_id", type = IdType.INPUT)
    private Integer configId;

    /**
     * 参数名称
     */
    @TableField(value = "config_name")
    private String configName;

    /**
     * 参数键名
     */
    @TableField(value = "config_key")
    private String configKey;

    /**
     * 参数键值
     */
    @TableField(value = "config_value")
    private String configValue;

    /**
     * 系统内置（Y是 N否）
     */
    @TableField(value = "config_type")
    private String configType;

    /**
     * 创建者
     */
    @TableField(value = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新者
     */
    @TableField(value = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 获取参数主键
     *
     * @return config_id - 参数主键
     */
    public Integer getConfigId()
    {
        return configId;
    }

    /**
     * 设置参数主键
     *
     * @param configId 参数主键
     */
    public void setConfigId(Integer configId)
    {
        this.configId = configId;
    }

    /**
     * 获取参数名称
     *
     * @return config_name - 参数名称
     */
    public String getConfigName()
    {
        return configName;
    }

    /**
     * 设置参数名称
     *
     * @param configName 参数名称
     */
    public void setConfigName(String configName)
    {
        this.configName = configName;
    }

    /**
     * 获取参数键名
     *
     * @return config_key - 参数键名
     */
    public String getConfigKey()
    {
        return configKey;
    }

    /**
     * 设置参数键名
     *
     * @param configKey 参数键名
     */
    public void setConfigKey(String configKey)
    {
        this.configKey = configKey;
    }

    /**
     * 获取参数键值
     *
     * @return config_value - 参数键值
     */
    public String getConfigValue()
    {
        return configValue;
    }

    /**
     * 设置参数键值
     *
     * @param configValue 参数键值
     */
    public void setConfigValue(String configValue)
    {
        this.configValue = configValue;
    }

    /**
     * 获取系统内置（Y是 N否）
     *
     * @return config_type - 系统内置（Y是 N否）
     */
    public String getConfigType()
    {
        return configType;
    }

    /**
     * 设置系统内置（Y是 N否）
     *
     * @param configType 系统内置（Y是 N否）
     */
    public void setConfigType(String configType)
    {
        this.configType = configType;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreateBy()
    {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy)
    {
        this.createBy = createBy;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime()
    {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    /**
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public String getUpdateBy()
    {
        return updateBy;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy)
    {
        this.updateBy = updateBy;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime()
    {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark()
    {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark)
    {
        this.remark = remark;
    }
}