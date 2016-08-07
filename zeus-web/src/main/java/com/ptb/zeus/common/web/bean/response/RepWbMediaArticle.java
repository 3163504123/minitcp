package com.ptb.zeus.common.web.bean.response;

/**
 * 微博媒体文章
 *
 * @author lenovo
 */
public class RepWbMediaArticle {

    private int isAuth;
    private String brief;
    private String fansNum;
    private String pMid;
    private String mediaName;
    private long pubTime;
    private String title;
    private String coverPlan;
    private int spreadNum;
    private int commentNum;
    private int zanNum;
    private String url;

    public long getPubTime() {
        return pubTime;
    }

    public void setPubTime(long pubTime) {
        this.pubTime = pubTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverPlan() {
        return coverPlan;
    }

    public void setCoverPlan(String coverPlan) {
        this.coverPlan = coverPlan;
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

    public int getZanNum() {
        return zanNum;
    }

    public void setZanNum(int zanNum) {
        this.zanNum = zanNum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getpMid() {
        return pMid;
    }

    public void setpMid(String pMid) {
        this.pMid = pMid;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }


    public void setTltle(String title) {
        this.title = title;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public void setIsAuth(int isAuth) {
        this.isAuth = isAuth;
    }

    public void setFansNum(String fansNum) {
        this.fansNum = fansNum;
    }

    public int getIsAuth() {
        return isAuth;
    }

    public String getBrief() {
        return brief;
    }

    public String getFansNum() {
        return fansNum;
    }
}
