package com.ptb.zeus.common.web.bean.request.user;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by eric on 16/6/7.
 */
public class ReqSendActiveEmail {
    @Email(message = "邮箱格式不正确")
    @NotBlank(message = "邮箱不能为空")
    String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
