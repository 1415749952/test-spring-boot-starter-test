package com.example.springbootstartertest.security;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @version 1.0
 * @author: TheFei
 * @Date: 2022-06-16
 * @Time: 15:28
 */
public class MyLoginBody
{

    private String name;
    private String psd;
    /**
     * 验证码
     */
    private String code;

    /**
     * 验证码的唯一标识
     */
    private String uuid;

    public MyLoginBody()
    {
    }

    public MyLoginBody(String name, String psd, String code, String uuid)
    {
        this.name = name;
        this.psd = psd;
        this.code = code;
        this.uuid = uuid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPsd()
    {
        return psd;
    }

    public void setPsd(String psd)
    {
        this.psd = psd;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getUuid()
    {
        return uuid;
    }

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    @Override
    public String toString()
    {
        return "MyLoginBody{" +
                "name='" + name + '\'' +
                ", psd='" + psd + '\'' +
                ", code='" + code + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
