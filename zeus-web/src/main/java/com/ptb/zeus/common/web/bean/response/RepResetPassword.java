package com.ptb.zeus.common.web.bean.response;

/**
 * Created by eric on 16/6/8.
 */
public class RepResetPassword {
    String token;

    public RepResetPassword(String token) {
        this.token = token;
    }

    public RepResetPassword() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
