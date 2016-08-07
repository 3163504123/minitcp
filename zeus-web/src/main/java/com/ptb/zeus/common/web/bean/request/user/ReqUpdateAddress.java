package com.ptb.zeus.common.web.bean.request.user;


import com.ptb.zeus.common.utils.LittleUtils;

import javax.validation.constraints.NotNull;

/**
 * Created by eric on 16/5/27.
 */
public class ReqUpdateAddress {
    @NotNull(message = "更新地址不为空")
    String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean legalAddress(){
        return LittleUtils.strLength1(this.address) <= 60;
    }

}
