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

    private String username;
    private String password;
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

    public MyLoginBody(String username, String password, String code, String uuid)
    {
        this.username = username;
        this.password = password;
        this.code = code;
        this.uuid = uuid;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
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
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", code='" + code + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
