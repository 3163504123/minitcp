package com.ptb.zeus.common.web.bean.request.user;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Created by eric on 16/6/7.
 */
public class ReqRegEmail {
    @Size(min = 6, max = 25, message = "密码应为6-25个字符")
    @NotBlank(message = "密码不能为空")
    private String password;

    @Email(message = "邮件格式不正确")
    @NotBlank(message = "邮箱不能为空")
    private String email;

    private String returnUrl;

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
