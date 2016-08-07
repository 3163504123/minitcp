package com.ptb.zeus.common.web.bean.response;

/**
 * Created by MyThinkpad on 2016/5/23.
 */
public class RepHomeWxBasic {
    private String pMid;
    private String mediaImage;
    private String mediaName;
    private int avgRead;
    private int isOriginal;
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

    public int getAvgRead() {
        return avgRead;
    }

    public void setAvgRead(int avgRead) {
        this.avgRead = avgRead;
    }

    public int getIsOriginal() {
        return isOriginal;
    }

    public void setIsOriginal(int isOriginal) {
        this.isOriginal = isOriginal;
    }

    public int getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(int isAuth) {
        this.isAuth = isAuth;
    }
}
