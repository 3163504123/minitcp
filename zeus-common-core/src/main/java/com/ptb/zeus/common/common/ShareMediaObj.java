package com.ptb.zeus.common.common;

import java.util.List;

/**
 * Created by eric on 16/5/28.
 */
public class ShareMediaObj {

    private long uid;
    private String nickname;
    private List<String> pMids;
    private int type;
    private boolean remark;
    private boolean price;

    public ShareMediaObj() {
    }

    public ShareMediaObj(long uid, String nickname, List<String> pMids, int type) {
        this.uid = uid;
        this.nickname = nickname;
        this.pMids = pMids;
        this.type = type;
    }

    public boolean isRemark() {
        return remark;
    }

    public void setRemark(boolean remark) {
        this.remark = remark;
    }

    public boolean isPrice() {
        return price;
    }

    public void setPrice(boolean price) {
        this.price = price;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<String> getpMids() {
        return pMids;
    }

    public void setpMids(List<String> pMids) {
        this.pMids = pMids;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
