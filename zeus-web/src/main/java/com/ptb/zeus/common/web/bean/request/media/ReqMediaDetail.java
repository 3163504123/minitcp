package com.ptb.zeus.common.web.bean.request.media;

import com.ptb.zeus.common.web.bean.request.base.ReqPmidType;

public class ReqMediaDetail extends ReqPmidType {
    private int index;
    private String key;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean report(){
        return null != key;
    }
}
