package com.ptb.zeus.common.web.bean.request.user;


import com.ptb.zeus.common.utils.LittleUtils;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by eric on 16/5/22.
 */
public class ReqUpdateNickName {
    @NotBlank(message = "昵称不能为空")
    String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean legalNickName(){
        return LittleUtils.strLength1(this.nickname) <= 30;
    }
}
