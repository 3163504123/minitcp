package com.ptb.zeus.common.web.bean.request.user;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by eric on 16/6/8.
 */
public class ReqResetPassword {
    @NotEmpty(message = "密码不能为空")
    @Size(min=6,max=25,message="用户密码长度为6-25个字符")
    String newPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
