package com.ptb.zeus.common.web.bean.request.user;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 用户注册
 *
 * @author lenovo
 */
public class ReqRegister {
    @Pattern(regexp = "1[0-9]{10}", message = "手机号输入有误，请重新输入")
    @NotBlank(message = "手机号不能为空")
    private String phone;

    @Size(min = 6, max = 25, message = "密码应为6-25个字符")
    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "验证码不能为空")
    @Size(min = 1, max = 10, message = "验证码不能超过10位")
    private String validateCode;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
