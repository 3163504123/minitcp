package com.ptb.zeus.common.web.bean.response;

/**
 * Created by eric on 16/6/13.
 */
public class RepIsExistUser {
    boolean isExsitedUser;
    public RepIsExistUser(Boolean isExisted) {
        this.isExsitedUser = isExisted;
    }

    public boolean isExsitedUser() {
        return isExsitedUser;
    }

    public void setExsitedUser(boolean exsitedUser) {
        isExsitedUser = exsitedUser;
    }
}
