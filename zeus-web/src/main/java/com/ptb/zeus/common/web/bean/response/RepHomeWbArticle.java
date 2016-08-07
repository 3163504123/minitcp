package com.ptb.zeus.common.web.bean.response;

/**
 * Created by MyThinkpad on 2016/5/23.
 */
public class RepHomeWbArticle {
    private String pMid;
    private String url;
    private String title;
    private String mediaName;
    private int zanNum;
    private int spreadNum;
    private int commentNum;
    private long pubTime;
    private int isAuth;

    public String getpMid() {
        return pMid;
    }

    public void setpMid(String pMid) {
        this.pMid = pMid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public int getZanNum() {
        return zanNum;
    }

    public void setZanNum(int zanNum) {
        this.zanNum = zanNum;
    }

    public int getSpreadNum() {
        return spreadNum;
    }

    public void setSpreadNum(int spreadNum) {
        this.spreadNum = spreadNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public long getPubTime() {
        return pubTime;
    }

    public void setPubTime(long pubTime) {
        this.pubTime = pubTime;
    }

    public int getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(int isAuth) {
        this.isAuth = isAuth;
    }
}
