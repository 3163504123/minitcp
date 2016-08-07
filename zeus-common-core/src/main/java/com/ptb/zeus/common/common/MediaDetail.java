package com.ptb.zeus.common.common;


import com.ptb.zeus.common.utils.Constant;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by eric on 16/5/24.
 */
public class MediaDetail {
    public static final String ZAN = "zan";
    public static final String READ = "read";
    public static final String SPREAD = "spread";
    public static final String COMMENT = "comment";

    String qrcode;
    String pMid;  //媒体ID
    int collection;  //是否收藏
    String mediaName;   //媒体名称
    String mediaImage;  //媒体头像
    long addTime;   //添加时间
    int isAuth;    //是否认证
    String authInfo;   //认证信息
    int fansNum;   //粉丝数
    String growRate;  //增长率
    String zanGrowRate; //赞数增长率
    String readGrowRate; //阅读数增长率
    String spreadGrowRate; //转发数增长率
    String commentGrowRate; //评论数增长率
    int type;  //平台类型
    String brief;
    List<String> tags;   //用户标签
    int pubNum;        //发布次数
    int pubArticle;      //发布文章数
    int avgSpread;       //平均转发数
    int avgComment;    //平均评论数
    int avgZan;       //平均点赞数
    int isOriginal;  //是否原创
    int originalNum;
    String mediaId;  //weixinID
    int totalZan;   //总赞数
    int swjrArticle;  //十万+文章数
    int hlavGread;    //头条平均阅读数
    int hlavgZan;      //头条平均点赞数
    List<PointNum> headReadNums;
    List<PointNum> secondReadNums;
    List<PointNum> thirdReadNums;
    List<PointNum> totalCommentNums;
    List<PointNum> totalZanNums;
    List<PointNum> totalSpreadNums;
    List<MediaHotWords> mediaHotWord;  //媒体热词排名
    int colllectedUserNum;
    Contact contact;

    public MediaDetail() {
        this.totalZan = -1;   //总赞数
        this.swjrArticle = -1;  //十万+文章数
        this.hlavGread = -1;    //头条平均阅读数
        this.hlavgZan = -1;      //头条平均点赞数
        this.pubNum = -1;        //发布次数
        this.pubArticle = -1;      //发布文章数
        this.avgSpread = -1;       //平均转发数
        this.avgComment = -1;    //平均评论数
        this.avgZan = -1;       //平均点赞数
        this.fansNum = -1;   //粉丝数
        this.originalNum = -1;
        this.headReadNums = asList();
        this.secondReadNums = asList();
        this.thirdReadNums = asList();
        this.totalCommentNums = asList();
        this.totalZanNums = asList();
        this.totalSpreadNums = asList();
        this.mediaHotWord = asList();
    }

    public List<MediaHotWords> getMediaHotWord() {
        return mediaHotWord;
    }

    public void setMediaHotWord(List<MediaHotWords> mediaHotWord) {
        this.mediaHotWord = mediaHotWord;
    }

    public String getZanGrowRate() {
        return zanGrowRate;
    }

    public void setZanGrowRate(String zanGrowRate) {
        this.zanGrowRate = zanGrowRate;
    }

    public String getReadGrowRate() {
        return readGrowRate;
    }

    public void setReadGrowRate(String readGrowRate) {
        this.readGrowRate = readGrowRate;
    }

    public String getSpreadGrowRate() {
        return spreadGrowRate;
    }

    public void setSpreadGrowRate(String spreadGrowRate) {
        this.spreadGrowRate = spreadGrowRate;
    }

    public String getCommentGrowRate() {
        return commentGrowRate;
    }

    public void setCommentGrowRate(String commentGrowRate) {
        this.commentGrowRate = commentGrowRate;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public int getOriginalNum() {
        return originalNum;
    }

    public void setOriginalNum(int originalNum) {
        this.originalNum = originalNum;
    }

    public String getGrowRate() {
        return growRate;
    }

    public void setGrowRate(String growRate) {
        this.growRate = growRate;
    }

    public int getColllectedUserNum() {
        return colllectedUserNum;
    }

    public void setColllectedUserNum(int colllectedUserNum) {
        this.colllectedUserNum = colllectedUserNum;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public long getAddTime() {
        return addTime;
    }

    public void setAddTime(long addTime) {
        this.addTime = addTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public String getpMid() {
        return pMid;
    }

    public void setpMid(String pMid) {
        this.pMid = pMid;
    }

    public int getCollection() {
        return collection;
    }

    public void setCollection(int collection) {
        this.collection = collection;
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

    public void setMediaImageDefault(){
        this.mediaImage = Constant.MEDIA_CDN_DEFAULT_IMG;
    }

    public int getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(int isAuth) {
        this.isAuth = isAuth;
    }

    public String getAuthInfo() {
        return authInfo;
    }

    public void setAuthInfo(String authInfo) {
        this.authInfo = authInfo;
    }

    public int getFansNum() {
        return fansNum;
    }

    public void setFansNum(int fansNum) {
        this.fansNum = fansNum;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public int getPubNum() {
        return pubNum;
    }

    public void setPubNum(int pubNum) {
        this.pubNum = pubNum;
    }

    public int getPubArticle() {
        return pubArticle;
    }

    public void setPubArticle(int pubArticle) {
        this.pubArticle = pubArticle;
    }

    public int getAvgSpread() {
        return avgSpread;
    }

    public void setAvgSpread(int avgSpread) {
        this.avgSpread = avgSpread;
    }

    public int getAvgComment() {
        return avgComment;
    }

    public void setAvgComment(int avgComment) {
        this.avgComment = avgComment;
    }

    public int getAvgZan() {
        return avgZan;
    }

    public void setAvgZan(int avgZan) {
        this.avgZan = avgZan;
    }

    public int getIsOriginal() {
        return isOriginal;
    }

    public void setIsOriginal(int isOriginal) {
        this.isOriginal = isOriginal;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public int getTotalZan() {
        return totalZan;
    }

    public void setTotalZan(int totalZan) {
        this.totalZan = totalZan;
    }

    public int getSwjrArticle() {
        return swjrArticle;
    }

    public void setSwjrArticle(int swjrArticle) {
        this.swjrArticle = swjrArticle;
    }

    public int getHlavGread() {
        return hlavGread;
    }

    public void setHlavGread(int hlavGread) {
        this.hlavGread = hlavGread;
    }

    public int getHlavgZan() {
        return hlavgZan;
    }

    public void setHlavgZan(int hlavgZan) {
        this.hlavgZan = hlavgZan;
    }

    public List<PointNum> getHeadReadNums() {
        return headReadNums;
    }

    public void setHeadReadNums(List<PointNum> headReadNums) {
        this.headReadNums = headReadNums;
    }

    public List<PointNum> getSecondReadNums() {
        return secondReadNums;
    }

    public void setSecondReadNums(List<PointNum> secondReadNums) {
        this.secondReadNums = secondReadNums;
    }

    public List<PointNum> getThirdReadNums() {
        return thirdReadNums;
    }

    public void setThirdReadNums(List<PointNum> thirdReadNums) {
        this.thirdReadNums = thirdReadNums;
    }

    public List<PointNum> getTotalCommentNums() {
        return totalCommentNums;
    }

    public void setTotalCommentNums(List<PointNum> totalCommentNums) {
        this.totalCommentNums = totalCommentNums;
    }

    public List<PointNum> getTotalZanNums() {
        return totalZanNums;
    }

    public void setTotalZanNums(List<PointNum> totalZanNums) {
        this.totalZanNums = totalZanNums;
    }

    public List<PointNum> getTotalSpreadNums() {
        return totalSpreadNums;
    }

    public void setTotalSpreadNums(List<PointNum> totalSpreadNums) {
        this.totalSpreadNums = totalSpreadNums;
    }

    public static class Contact {
        String name;
        String phone;
        String email;
        String price;

        public Contact() {
        }

        public Contact(String name, String phone, String email, String price) {
            this.name = name;
            this.phone = phone;
            this.email = email;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }
}
