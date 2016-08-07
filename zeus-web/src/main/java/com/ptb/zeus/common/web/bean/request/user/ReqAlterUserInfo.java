package com.ptb.zeus.common.web.bean.request.user;


import com.ptb.zeus.common.utils.LittleUtils;

/**
 * Created by MyThinkpad on 2016/7/27.
 */
public class ReqAlterUserInfo {

    private String address;
    private String nickname;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean legalNickName(){
        return LittleUtils.strLength1(this.nickname) <= 30;
    }

    public boolean legalAddress(){
        return LittleUtils.strLength1(this.address) <= 60;
    }
}
