package com.ptb.zeus.common.common;


import com.alibaba.fastjson.JSON;

/**
 * Created by eric on 16/5/30.
 */
public class CacheVolidatecode {
    int retryCount;
    String vcode;
    String phone;

    public CacheVolidatecode(String phone, String vcode) {
        this.phone = phone;
        this.vcode = vcode;
        this.retryCount = 0;
    }

    public CacheVolidatecode() {
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
