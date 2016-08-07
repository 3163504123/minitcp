package com.ptb.zeus.common.web.bean.request.user;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * 找回密码
 *
 * @author lenovo
 */
public class ReqBackPassword {

    @Pattern(regexp = "1[0-9]{10}",message = "手机号输入有误，请重新输入" )
    @NotBlank(message = "手机号不能为空")
    private String phone;


    @NotBlank(message = "验证码不能为空")
    private String validateCode;

    @Pattern(regexp = "\\w{6,25}",message = "用户密码长度为6-25个字符")
    @NotBlank(message = "新密码不能为空")
    private String newPassword;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }


}
