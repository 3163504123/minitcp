package com.ptb.zeus.common.web.bean.request.user;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * Created by eric on 16/5/22.
 */
public class ReqSendVCode {

    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^[1][0-9]{10}$",message="手机号输入有误，请重新输入")
    String phone;
    
    public ReqSendVCode() {
    }

    public ReqSendVCode(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
