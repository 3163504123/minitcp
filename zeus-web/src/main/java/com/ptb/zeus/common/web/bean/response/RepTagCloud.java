package com.ptb.zeus.common.web.bean.response;

/**
 * Created by MyThinkpad on 2016/6/27.
 */
public class RepTagCloud {
    private int wxNum;
    private int wbNum;
    private int lastType;
    private String tag;
    private String mediaImage;

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

    public int getLastType() {
        return lastType;
    }

    public void setLastType(int lastType) {
        this.lastType = lastType;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getMediaImage() {
        return mediaImage;
    }

    public void setMediaImage(String mediaImage) {
        this.mediaImage = mediaImage;
    }
}
