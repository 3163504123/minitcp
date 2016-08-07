package com.ptb.zeus.common.common;


import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by eric on 16/5/24.
 */
public class ArticleDetail {
    String pMid;  //媒体ID
    String mediaName;   //媒体名称
    String mediaImage;  //媒体头像
    String coverPlan;  //封面图片
    String url;          //url
    String title;        //标题
    String atype;        //文章类型
    long pubTime;         //发布时间
    int zanNum;      //点赞数
    int readNum;      //阅读数
    int spreadNum;  //转发数
    int commentNum;  //评论数
    int original;  //是否原创
    int isAuth;    //是否媒体是否认证;
    String autoInfo; //认证信息
    String fansNum; //粉丝数
    String brief; //媒体简介
    String mediaId;
    String articleType;
    static String imgUrlPath;


    static {
        try {
            Configuration conf = new PropertiesConfiguration("ptb.properties");
            imgUrlPath = conf.getString("zeus.server.img.url");
        } catch (ConfigurationException e) {
            throw new RuntimeException("图片资源URL读取失败");
        }


    }

    public String getArticleType() {

        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
        if(StringUtils.isNotBlank(this.coverPlan)) {
            return;
        }
        switch (articleType) {
            case "file":
            case "video":
            case "vote":
            case "article":
            case "movie":
            case "audio":
            case "book":
            case "topic":
            case "event":
                this.coverPlan = String.format("%s/%s@3x.png", imgUrlPath, articleType);
                break;
            default:
                this.coverPlan = String.format("%s/%s@3x.png", imgUrlPath, "article");
        }


    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getAutoInfo() {
        return autoInfo;
    }

    public void setAutoInfo(String autoInfo) {
        this.autoInfo = autoInfo;
    }

    public String getFansNum() {
        return fansNum;
    }

    public void setFansNum(String fansNum) {
        this.fansNum = fansNum;
    }

    public String getBrief() {

        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
        if (StringUtils.isNotBlank(brief)) {
            this.brief = StringEscapeUtils.unescapeHtml4(brief);
        }
    }

    public int getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(int isAuth) {
        this.isAuth = isAuth;
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

    public int getReadNum() {
        return readNum;
    }

    public void setReadNum(int readNum) {
        this.readNum = readNum;
    }

    public int getOriginal() {
        return original;
    }

    public void setOriginal(int original) {
        this.original = original;
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

    public String getMediaImage() {
        return mediaImage;
    }

    public void setMediaImage(String mediaImage) {
        this.mediaImage = mediaImage;
    }

    public String getCoverPlan() {
        return coverPlan;
    }

    public void setCoverPlan(String coverPlan) {
        this.coverPlan = coverPlan;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

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

    public String getAtype() {
        return atype;
    }

    public void setAtype(String atype) {
        this.atype = atype;
    }
}
