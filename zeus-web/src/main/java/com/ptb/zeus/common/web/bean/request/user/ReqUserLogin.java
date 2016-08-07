package com.ptb.zeus.common.web.bean.request.user;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * 用户登录
 *
 * @author lenovo
 */
public class ReqUserLogin {

    @NotBlank(message = "用户名不能为空")
    @Size(min=6,max=30,message="用户名不能太长,已超过30个字符")
    private String username;


    @Size(min=6,max=25,message="用户密码长度为6-25个字符")
    @NotBlank(message = "密码不能为空")
    private String password;


    private boolean isRemember = false;

    public ReqUserLogin() {
    }

    public ReqUserLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isRemember() {
        return isRemember;
    }

    public void setRemember(boolean remember) {
        isRemember = remember;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
