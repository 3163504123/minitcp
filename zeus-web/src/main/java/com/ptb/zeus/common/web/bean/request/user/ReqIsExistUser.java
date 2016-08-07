package com.ptb.zeus.common.web.bean.request.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by eric on 16/6/13.
 */
public class ReqIsExistUser {
    @NotNull(message = "用户名不能为空")
    @Size(min=6,max=40,message="用户名不能太长,已超过30个字符")
    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
