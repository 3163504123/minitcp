package com.ptb.zeus.common.model;

/**
 * Created by MyThinkpad on 2016/6/27.
 */
public class UserTagCloud extends TagCount {
    private int type;
    private int wxNum;
    private int wbNum;
    private String pMid;
    private String addTime;
    private String portrait;

    public int getWxNum() {
        return wxNum;
    }

    public void setWxNum(int wxNum) {
        this.wxNum = wxNum;
    }

    public int getWbNum() {
        return wbNum;
    }

    public void setWbNum(int wbNum) {
        this.wbNum = wbNum;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getpMid() {
        return pMid;
    }

    public void setpMid(String pMid) {
        this.pMid = pMid;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }
}
