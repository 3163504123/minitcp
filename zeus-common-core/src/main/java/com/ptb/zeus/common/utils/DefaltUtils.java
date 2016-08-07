package com.ptb.zeus.common.utils;

import com.ptb.zeus.common.common.ArticleDetail;
import com.ptb.zeus.common.common.ArticleSet;
import com.ptb.zeus.common.common.MediaDetail;
import com.ptb.zeus.common.common.MediaSet;
import com.ptb.zeus.common.common.PointNum;
import com.ptb.zeus.common.model.MediaTagTime;
import com.ptb.zeus.common.model.UserMediaTag;

import org.apache.commons.lang.math.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by eric on 16/5/29.
 */
public class DefaltUtils {
    public static ArticleDetail wxArticle() {
        ArticleDetail wx = new ArticleDetail();
        wx.setpMid("MTE3MzE4MTAyMQ==");
        wx.setTitle("今天苹果40岁了！乔布斯的那些成功秘诀现在依旧适用！");
        wx.setMediaName("TechWeb");
        wx.setPubTime(System.currentTimeMillis() - RandomUtils.nextInt(200000));
        wx.setUrl("http://mp.weixin.qq.com/s?__biz=MTE3MzE4MTAyMQ==&mid=403427490&idx=1&sn=b5a21e4ea3f6843f4662ef4fcb83af54#rd");
        wx.setOriginal(RandomUtils.nextInt(2));
        wx.setCoverPlan("http://wx.qlogo.cn/mmhead/Q3auHgzwzM6TXlfzBM0R9QAzOJ1EWMlRjyLBXo6mfoEaLhVNQFZYPw/0");
        wx.setReadNum(RandomUtils.nextInt(200000));
        wx.setZanNum(RandomUtils.nextInt(200000));
        wx.setIsAuth(RandomUtils.nextInt(3));
        wx.setMediaId("TechWeb");
        wx.setAutoInfo("千钧万博(北京)信息技术有限公司");
        wx.setBrief("echWeb专注于互联网消费领域，每日专业提供互联网产品、智能设备及互联网服务等方面的最新资讯。");
        return wx;
    }

    public static ArticleDetail wbArticle() {
        ArticleDetail wmb = new ArticleDetail();
        wmb.setpMid("1314608344");
        wmb.setUrl("http://m.weibo.cn/u/1314608344");
        wmb.setTitle("《新闻晨报》官方微博");
        wmb.setMediaName("《新闻晨报》官方微博");
        wmb.setCoverPlan("http://tva4.sinaimg.cn/crop.49.65.610.610.50/4e5b54d8jw8ev7lxmkc5nj20j60isq4r.jpg");
        wmb.setPubTime(System.currentTimeMillis() - RandomUtils.nextInt(200000));
        wmb.setOriginal(RandomUtils.nextInt(200000));
        wmb.setZanNum(RandomUtils.nextInt(200000));
        wmb.setSpreadNum(RandomUtils.nextInt(200000));
        wmb.setCommentNum(RandomUtils.nextInt(200000));
        wmb.setIsAuth(RandomUtils.nextInt(4));
        wmb.setMediaId("TechWeb");
        wmb.setAutoInfo("千钧万博(北京)信息技术有限公司");
        wmb.setBrief("echWeb专注于互联网消费领域，每日专业提供互联网产品、智能设备及互联网服务等方面的最新资讯。");
        return wmb;
    }

    public static MediaDetail getWxDefault() {
        MediaDetail mediaDetail = new MediaDetail();
        mediaDetail.setCollection(1);
        mediaDetail.setIsAuth(1);
        mediaDetail.setMediaImage("http://wx.qlogo.cn/mmhead/Q3auHgzwzM5Aw3sY9pemVgHNUs31MWb9BbxDCndW67OfCNmicT2m9kQ/0");
        mediaDetail.setType(Constant.M_T_WEIXIN);
        mediaDetail.setMediaName("直播生活");
        mediaDetail.setpMid("MzA5MDE2OTkxNw==");
        mediaDetail.setMediaId("zbsh02423900500");
        mediaDetail.setGrowRate("10");
        mediaDetail.setPubNum(10);
        mediaDetail.setPubArticle(100);
        mediaDetail.setAvgSpread(RandomUtils.nextInt(200000));
        mediaDetail.setAvgComment(RandomUtils.nextInt(200000));
        mediaDetail.setAvgZan(RandomUtils.nextInt(200000));
        mediaDetail.setIsOriginal(RandomUtils.nextInt(2));
        mediaDetail.setTotalZan(RandomUtils.nextInt(200000));
        mediaDetail.setHlavGread(RandomUtils.nextInt(200000));
        mediaDetail.setHlavgZan(RandomUtils.nextInt(200000));
        mediaDetail.setAddTime(new Date().getTime() + RandomUtils.nextInt(200000));
        mediaDetail.setAuthInfo("沈阳广播电视台");
        mediaDetail.setTags(Arrays.asList("标签1", "标签2", "标签3"));
        mediaDetail.setBrief("一档电视民生新闻栏目，一个百人新闻团队，一颗为人民服务的赤诚之心。在这里，我们和您分享发生在这座城市中离您最近的新闻资讯。");
        long time = new Date().getTime();
        long l = time - time % 86400 - 86400;
        List<PointNum> pointNumList = new LinkedList<>();

        for (int i = 0; i < 7; i++) {
            pointNumList.add(new PointNum(l - 8600 * i, RandomUtils.nextInt(10000)));
        }
        mediaDetail.setHeadReadNums(pointNumList);
        mediaDetail.setSecondReadNums(pointNumList);
        mediaDetail.setThirdReadNums(pointNumList);
        return mediaDetail;
    }

    public static MediaDetail getWbDefault() {
        MediaDetail mediaDetail = new MediaDetail();
        mediaDetail.setCollection(1);
        mediaDetail.setIsAuth(RandomUtils.nextInt(3));
        mediaDetail.setIsOriginal(RandomUtils.nextInt(2));
        mediaDetail.setMediaName("木木染_painter");
        mediaDetail.setMediaImage("http://tva4.sinaimg.cn/crop.0.0.1536.1536.180/0061IPgBjw8f35xhiyu1wj316o16owhc.jpg");
        mediaDetail.setFansNum(RandomUtils.nextInt(200000));
        mediaDetail.setType(Constant.M_T_WEIBO);
        mediaDetail.setpMid("5522256833");
        mediaDetail.setGrowRate("10");
        mediaDetail.setPubNum(10);
        mediaDetail.setPubArticle(100);
        mediaDetail.setAvgSpread(RandomUtils.nextInt(200000));
        mediaDetail.setAvgComment(RandomUtils.nextInt(200000));
        mediaDetail.setAvgZan(RandomUtils.nextInt(200000));
        mediaDetail.setTotalZan(RandomUtils.nextInt(200000));
        mediaDetail.setHlavGread(RandomUtils.nextInt(200000));
        mediaDetail.setHlavgZan(RandomUtils.nextInt(200000));
        mediaDetail.setAddTime(new Date().getTime() + RandomUtils.nextInt(200000));
        mediaDetail.setAuthInfo("上海宝姿化妆品有限公司");
        mediaDetail.setBrief("林染 大概会画画/CCS/DM/CG/AC/SAO/阳炎 本命樱狼 人蠢且懒");
        mediaDetail.setTags(Arrays.asList("标签1", "标签2", "标签3"));
        mediaDetail.setMediaId("5522256833");
        mediaDetail.setType(Constant.M_T_WEIBO);
        long time = new Date().getTime();
        long l = time - time % 86400 - 86400;
        List<PointNum> pointNumList = new LinkedList<>();

        for (int i = 0; i < 7; i++) {
            pointNumList.add(new PointNum(l - 8600 * i, RandomUtils.nextInt(10000)));
        }
        mediaDetail.setTotalZanNums(pointNumList);
        mediaDetail.setTotalCommentNums(pointNumList);
        mediaDetail.setTotalSpreadNums(pointNumList);
        return mediaDetail;
    }

    public static ArticleSet getWbArticleSet() {
        ArticleSet articleSet = new ArticleSet();
        articleSet.setTotal(100);
        List<ArticleDetail> articleDetails = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            articleDetails.add(wbArticle());
        }
        articleSet.setArticleDetailList(articleDetails);
        return articleSet;
    }

    public static ArticleSet getWbArticleSet(int start, int end) {
        ArticleSet articleSet = new ArticleSet();
        articleSet.setTotal(40);
        List<ArticleDetail> articleDetails = new ArrayList<>();
        for (int i = start; i < end && i < 40; i++) {
            articleDetails.add(wbArticle());
        }
        articleSet.setArticleDetailList(articleDetails);
        return articleSet;
    }

    public static ArticleSet getWxArticleSet() {
        ArticleSet articleSet = new ArticleSet();
        articleSet.setTotal(100);
        List<ArticleDetail> articleDetails = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            articleDetails.add(wxArticle());
        }
        articleSet.setArticleDetailList(articleDetails);
        return articleSet;
    }

    public static ArticleSet getWxArticleSet(int start, int end){
        ArticleSet articleSet = new ArticleSet();
        articleSet.setTotal(40);
        List<ArticleDetail> articleDetails = new ArrayList<>();
        for (int i = start; i < end && i < 40; i++) {
            articleDetails.add(wxArticle());
        }
        articleSet.setArticleDetailList(articleDetails);
        return articleSet;
    }

    public static MediaSet getWbMediaSet() {
        MediaSet mediaSet = new MediaSet();
        mediaSet.setTotalNum(100);
        List<MediaDetail> mediaSets = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            mediaSets.add(getWbDefault());
        }
        mediaSet.setMediaDetailList(mediaSets);
        return mediaSet;
    }

    public static MediaSet getWbMediaSet(int start, int end) {
        MediaSet mediaSet = new MediaSet();
        mediaSet.setTotalNum(40);
        List<MediaDetail> mediaSets = new ArrayList<>();
        for (int i = start; i < end && i < 40; i++) {
            mediaSets.add(getWbDefault());
        }
        mediaSet.setMediaDetailList(mediaSets);
        return mediaSet;
    }

    public static MediaSet getWxMediaSet() {
        MediaSet mediaSet = new MediaSet();
        mediaSet.setTotalNum(100);
        List<MediaDetail> mediaSets = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            mediaSets.add(getWxDefault());
        }
        mediaSet.setMediaDetailList(mediaSets);
        return mediaSet;
    }

    public static MediaSet getWxMediaSet(int start, int end) {
        MediaSet mediaSet = new MediaSet();
        mediaSet.setTotalNum(40);
        List<MediaDetail> mediaSets = new ArrayList<>();
        for (int i = start; i < end && i < 40; i++) {
            mediaSets.add(getWxDefault());
        }
        mediaSet.setMediaDetailList(mediaSets);
        return mediaSet;
    }

    public static List<MediaTagTime> getMediaTagTime(){
        List<MediaTagTime> mediaTagTimes = new ArrayList<>();
        for(int index = 0; index < 40; index++){
            MediaTagTime mediaTagTime = new MediaTagTime();
            mediaTagTime.setAddTime(new Date(System.currentTimeMillis() - RandomUtils.nextInt(200000)));
            mediaTagTime.setpMid(String.format("%d", index));
            List<UserMediaTag> userMediaTags = new ArrayList<>();
            if(RandomUtils.nextInt(2) == 0) {
                for (int ii = 0; ii < 4; ii++){
                    UserMediaTag userMediaTag = new UserMediaTag();
                    userMediaTag.setTag(index + "标签" + ii);
                    userMediaTags.add(userMediaTag);
                }
            }else{
                UserMediaTag userMediaTag = new UserMediaTag();
                userMediaTag.setId(0L);
                userMediaTags.add(userMediaTag);
            }
            mediaTagTime.setUserMediaTags(userMediaTags);
            mediaTagTimes.add(mediaTagTime);
        }
        return mediaTagTimes;
    }

}