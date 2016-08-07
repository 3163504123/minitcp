package com.ptb.zeus.common.web.bean.response;

/**
 * Created by MyThinkpad on 2016/5/23.
 */
public class RepHomeWbBasic {
    private String pMid;
    private String mediaImage;
    private String mediaName;
    private int avgSpread;
    private int isAuth;

    public String getpMid() {
        return pMid;
    }

    public void setpMid(String pMid) {
        this.pMid = pMid;
    }

    public String getMediaImage() {
        return mediaImage;
    }

    public void setMediaImage(String mediaImage) {
        this.mediaImage = mediaImage;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public int getAvgSpread() {
        return avgSpread;
    }

    public void setAvgSpread(int avgSpread) {
        this.avgSpread = avgSpread;
    }

    public int getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(int isAuth) {
        this.isAuth = isAuth;
    }
}
