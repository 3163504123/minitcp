package com.ptb.zeus.common.web.bean.request.user;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * 修改密码
 *
 * @author lenovo
 */
public class ReqUpdatePassword {

    @Size(min = 6,max = 25,message = "用户密码长度为6-25个字符")
    @NotBlank(message = "老密码不能为空")
    private String oldPassword;

    @Size(min = 6,max = 25,message = "用户密码长度为6-25个字符")
    @NotBlank(message = "新密码不能为空")
    private String newPassword;


    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }


}
