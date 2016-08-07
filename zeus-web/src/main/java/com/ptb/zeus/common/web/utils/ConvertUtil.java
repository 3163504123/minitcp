package com.ptb.zeus.common.web.utils;

import com.ptb.gaia.service.entity.article.GWbArticle;
import com.ptb.gaia.service.entity.article.GWxArticle;
import com.ptb.gaia.service.entity.article.HotToken;
import com.ptb.gaia.service.entity.article.Point;
import com.ptb.gaia.service.entity.media.GWbMedia;
import com.ptb.gaia.service.entity.media.GWxMedia;
import com.ptb.uranus.spider.weibo.bean.WeiboAccount;
import com.ptb.uranus.spider.weibo.bean.WeiboSearchAccount;
import com.ptb.uranus.spider.weixin.bean.GsData;
import com.ptb.utils.string.RegexUtils;
import com.ptb.zeus.common.common.ArticleDetail;
import com.ptb.zeus.common.common.ArticleSet;
import com.ptb.zeus.common.common.ContactInfo;
import com.ptb.zeus.common.common.MediaDetail;
import com.ptb.zeus.common.common.MediaHotWords;
import com.ptb.zeus.common.common.MediaListInfo;
import com.ptb.zeus.common.common.MediaSet;
import com.ptb.zeus.common.common.PointNum;
import com.ptb.zeus.common.common.WbHotMedia;
import com.ptb.zeus.common.common.WbMediaHotArticleBean;
import com.ptb.zeus.common.common.WbMediaInfo;
import com.ptb.zeus.common.common.WxHotMedia;
import com.ptb.zeus.common.common.WxMediaHotArticleBean;
import com.ptb.zeus.common.common.WxMediaInfo;
import com.ptb.zeus.common.model.TagCount;
import com.ptb.zeus.common.model.Upgrade;
import com.ptb.zeus.common.model.UserMedia;
import com.ptb.zeus.common.model.UserTagCloud;
import com.ptb.zeus.common.utils.Constant;
import com.ptb.zeus.common.utils.PinyinApi;
import com.ptb.zeus.common.web.bean.request.media.RepTagsResult;
import com.ptb.zeus.common.utils.monitor.TimeFormatUtils;
import com.ptb.zeus.common.web.bean.response.RepHomeWbArticle;
import com.ptb.zeus.common.web.bean.response.RepHomeWbBasic;
import com.ptb.zeus.common.web.bean.response.RepHomeWxArticle;
import com.ptb.zeus.common.web.bean.response.RepHomeWxBasic;
import com.ptb.zeus.common.web.bean.response.RepTagCloud;
import com.ptb.zeus.common.web.bean.request.media.ReqMediaHotWords;
import com.ptb.zeus.common.web.bean.response.RepArticles;
import com.ptb.zeus.common.web.bean.response.RepHomePage;
import com.ptb.zeus.common.web.bean.response.RepHomeWbData;
import com.ptb.zeus.common.web.bean.response.RepHomeWbHotArticle;
import com.ptb.zeus.common.web.bean.response.RepHomeWbRank;
import com.ptb.zeus.common.web.bean.response.RepHomeWxData;
import com.ptb.zeus.common.web.bean.response.RepHomeWxHotArticle;
import com.ptb.zeus.common.web.bean.response.RepHomeWxRank;
import com.ptb.zeus.common.web.bean.response.RepMediaDetail;
import com.ptb.zeus.common.web.bean.response.RepMediaHotWords;
import com.ptb.zeus.common.web.bean.response.RepUpgrade;
import com.ptb.zeus.common.web.bean.response.RepUserMediaTags;
import com.ptb.zeus.common.web.bean.response.RepUserMediaTagsWeb;
import com.ptb.zeus.common.web.bean.response.RepWbHotMedia;
import com.ptb.zeus.common.web.bean.response.RepWbMediaArticle;
import com.ptb.zeus.common.web.bean.response.RepWbMediaDetail;
import com.ptb.zeus.common.web.bean.response.RepWbMediaHotArticle;
import com.ptb.zeus.common.web.bean.response.RepWbMediaListBase;
import com.ptb.zeus.common.web.bean.response.RepWbPotentialMedia;
import com.ptb.zeus.common.web.bean.response.RepWxHotMedia;
import com.ptb.zeus.common.web.bean.response.RepWxMediaArticle;
import com.ptb.zeus.common.web.bean.response.RepWxMediaDetail;
import com.ptb.zeus.common.web.bean.response.RepWxMediaHotArticle;
import com.ptb.zeus.common.web.bean.response.RepWxMediaListBase;
import com.ptb.zeus.common.web.bean.response.RepWxPotentialMedia;
import com.ptb.zeus.common.web.exception.ZeusException;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by eric on 16/5/26.
 */
public class ConvertUtil {

    static Logger logger = Logger.getLogger(ConvertUtil.class);

    static String DEFAULT_WX_IMAGE = "http://open.weixin.qq.com/qr/code/?username=";

    public static String defaultWxImage(String weixinid) {
        return String.format("%s%s", DEFAULT_WX_IMAGE, weixinid);
    }


    public static MediaListInfo convertMediaSetToReqMediaListInfo(MediaSet mediaSet, int type) {
        if (mediaSet == null) {
            return null;
        }
        switch (type) {
            case Constant.M_T_WEIBO:
                return convertMediaSetToWbMediaListInfo(mediaSet);
            case Constant.M_T_WEIXIN:
                return convertMediaSetToWxMediaListInfo(mediaSet);
            default:
                throw ZeusException.PlatformTypeInvaildError;
        }
    }

    /*   public static MediaDetail convertWeixinMediaBasicToMediaDetail(WeixinMediaBasic wmb) {
           MediaDetail mediaDetail = new MediaDetail();
           mediaDetail.setType(Constant.M_T_WEIXIN);
           mediaDetail.setpMid(wmb.getBiz());
           mediaDetail.setMediaId(wmb.getWeixinId());
           mediaDetail.setIsAuth(StringUtils.isBlank(wmb.getAuthentication()) ? 0 : 1);
           mediaDetail.setAuthInfo(wmb.getAuthentication());
           mediaDetail.setMediaName(wmb.getMediaName());
           mediaDetail.setQrcode(wmb.getHeadImg());
           mediaDetail.setBrief(wmb.getBrief());
           mediaDetail.setMediaImage(wmb.getHeadImg());
           mediaDetail.setpMid(wmb.getBiz());

           return mediaDetail;
       }

       public static MediaDetail convertWeiboMediaBasicToMediaDetail(WeiboMediaBasic w) {
           WeiboMediaBasic.WeiboMediaThird wmb = (WeiboMediaBasic.WeiboMediaThird) w;
           MediaDetail mediaDetail = new MediaDetail();
           mediaDetail.setAuthInfo(wmb.getAuthDescription());
           mediaDetail.setFansNum(wmb.getFans());
           mediaDetail.setMediaImage(wmb.getHeadImg());
           if (StringUtils.isBlank(wmb.getAuthType()) || Integer.valueOf(wmb.getAuthType()) == -1) {
               mediaDetail.setIsAuth(0);
           } else if (Integer.valueOf(wmb.getAuthType()) == 0) {
               mediaDetail.setIsAuth(1);
           } else if (Integer.valueOf(wmb.getAuthType()) == 0) {
               mediaDetail.setIsAuth(2);
           }
           mediaDetail.setMediaName(wmb.getMediaName());
           mediaDetail.setMediaId(wmb.getWeiboId());
           mediaDetail.setpMid(wmb.getWeiboId());
           mediaDetail.setType(Constant.M_T_WEIBO);
           mediaDetail.setBrief(wmb.getBrief());
           return mediaDetail;
       }
   */
    public static RepWxMediaListBase convertMediaSetToWxMediaListInfo(MediaSet wxMediaList) {
        if (wxMediaList == null || wxMediaList.getMediaDetailList().size() == 0 || wxMediaList.getMediaDetailList().get(0) == null) {
            return null;
        }

        RepWxMediaListBase resp = new RepWxMediaListBase();
        resp.setTotalNum(wxMediaList.getTotalNum());
        List<MediaDetail> mediaDetailList = wxMediaList.getMediaDetailList();
        if (mediaDetailList != null) {
            resp.setList(mediaDetailList.stream().map(mediaDetail -> convertMediaDetailToWxMediaInfo(mediaDetail)).collect(Collectors.toList()));
        } else {
            resp.setList(new ArrayList<>());
        }
        return resp;
    }


    public static RepWbMediaListBase convertMediaSetToWbMediaListInfo(MediaSet wbMediaList) {
        RepWbMediaListBase resp = new RepWbMediaListBase();
        if (wbMediaList == null || wbMediaList.getMediaDetailList().size() == 0 || wbMediaList.getMediaDetailList().get(0) == null) {
            return null;
        }
        resp.setTotalNum(wbMediaList.getTotalNum());
        List<MediaDetail> mediaDetailList = wbMediaList.getMediaDetailList();
        if (mediaDetailList != null) {
            resp.setList(mediaDetailList.stream().map(mediaDetail -> convertMediaDetailToWbMediaInfo(mediaDetail)).collect(Collectors.toList()));
        } else {
            resp.setList(new ArrayList<>());
        }
        return resp;
    }

    //mengchen
    public static RepMediaHotWords convertMediaDetailToRepMediaHotWords(MediaDetail mediaDetail) {
        RepMediaHotWords repMediaHotWords = new RepMediaHotWords();
        repMediaHotWords.setList(mediaDetail.getMediaHotWord());
        return repMediaHotWords;
    }

    public static WbMediaInfo convertMediaDetailToWbMediaInfo(MediaDetail mediaDetail) {
        WbMediaInfo wbMediaBase = new WbMediaInfo();
        wbMediaBase.setBrief(mediaDetail.getBrief());
        wbMediaBase.setAddTime(mediaDetail.getAddTime());
        wbMediaBase.setAuthInfo(mediaDetail.getAuthInfo());
        wbMediaBase.setCollection(mediaDetail.getCollection());
        wbMediaBase.setIsAuth(mediaDetail.getIsAuth());
        wbMediaBase.setMediaId(mediaDetail.getMediaId());
        wbMediaBase.setMediaImage(mediaDetail.getMediaImage());
        wbMediaBase.setpMid(mediaDetail.getpMid());
        wbMediaBase.setType(mediaDetail.getType());
        wbMediaBase.setMediaName(mediaDetail.getMediaName());
        wbMediaBase.setFansNum(mediaDetail.getFansNum());
        wbMediaBase.setIsOriginal(mediaDetail.getIsOriginal());
        wbMediaBase.setCollectedUserCount(mediaDetail.getColllectedUserNum());
        wbMediaBase.setContact(convertMediaDetailToContactInfo(mediaDetail));
        return wbMediaBase;
    }




    public static WxMediaInfo convertMediaDetailToWxMediaInfo(MediaDetail mediaDetail) {
        WxMediaInfo wxMediaInfo = new WxMediaInfo();
        wxMediaInfo.setBrief(mediaDetail.getBrief());
        wxMediaInfo.setAddTime(mediaDetail.getAddTime());
        wxMediaInfo.setAuthInfo(mediaDetail.getAuthInfo());
        wxMediaInfo.setCollection(mediaDetail.getCollection());
        wxMediaInfo.setIsAuth(mediaDetail.getIsAuth());
        wxMediaInfo.setMediaId(mediaDetail.getMediaId());
        wxMediaInfo.setMediaImage(mediaDetail.getMediaImage());
        wxMediaInfo.setQrCode(mediaDetail.getQrcode());
        wxMediaInfo.setpMid(mediaDetail.getpMid());
        wxMediaInfo.setType(mediaDetail.getType());
        wxMediaInfo.setMediaName(mediaDetail.getMediaName());
        wxMediaInfo.setIsOriginal(mediaDetail.getIsOriginal());
        wxMediaInfo.setCollectedUserCount(mediaDetail.getColllectedUserNum());
        wxMediaInfo.setContact(convertMediaDetailToContactInfo(mediaDetail));
        return wxMediaInfo;
    }


    public static RepMediaDetail convertMediaDetailToRepMediaDetail(MediaDetail md) {
        switch (md.getType()) {
            case Constant.M_T_WEIBO:
                return convertMediaDetailToReqWbMediaDetail(md);
            case Constant.M_T_WEIXIN:
                return convertMediaDetailToReqWxMediaDetail(md);
            default:
                throw ZeusException.PlatformTypeInvaildError;
        }
    }

    public static RepMediaDetail convertMediaDetailToReqWbMediaDetail(MediaDetail md) {
        RepWbMediaDetail wbMediaDetail = new RepWbMediaDetail();
        wbMediaDetail.setTags(md.getTags());
        wbMediaDetail.setComment(md.getTotalCommentNums());
        wbMediaDetail.setMbInfo(convertMediaDetailToWbMediaInfo(md));
        wbMediaDetail.setSpread(md.getTotalSpreadNums());
        wbMediaDetail.setZan(md.getTotalZanNums());
        wbMediaDetail.setStatistics(convertMediaDetailToWbStatistics(md));
        wbMediaDetail.setComment(md.getTotalCommentNums());
        wbMediaDetail.setSpread(md.getTotalSpreadNums());
        return wbMediaDetail;
    }

    private static ContactInfo convertMediaDetailToContactInfo(MediaDetail md) {
        if (md.getContact() != null) {
            ContactInfo contactInfo = new ContactInfo();
            contactInfo.setEmail(md.getContact().getEmail());
            contactInfo.setName(md.getContact().getName());
            contactInfo.setPhone(md.getContact().getPhone());
            contactInfo.setPrice(md.getContact().getPrice());
            return contactInfo;
        } else {
            return null;
        }
    }

    public static void convertUserMediaToMediaDetailContact(UserMedia userMedia, MediaDetail mediaDetail) {
        if (userMedia.getEmail() != null || userMedia.getName() != null || userMedia.getPhone() != null || userMedia.getPrice() != null) {
            MediaDetail.Contact contactInfo = new MediaDetail.Contact();
            contactInfo.setEmail(userMedia.getEmail());
            contactInfo.setName(userMedia.getName());
            contactInfo.setPhone(userMedia.getPhone());
            contactInfo.setPrice(userMedia.getPrice());
            mediaDetail.setContact(contactInfo);
        }
    }

    public static RepWbMediaDetail.WbStatistics convertMediaDetailToWbStatistics(MediaDetail md) {
        RepWbMediaDetail.WbStatistics wbStatistics = new RepWbMediaDetail.WbStatistics();
        wbStatistics.setAvgComment(md.getAvgComment());
        wbStatistics.setAvgSpread(md.getAvgSpread());
        wbStatistics.setAvgZan(md.getAvgZan());
        wbStatistics.setPubArticle(md.getPubArticle());
        wbStatistics.setPubNum(md.getPubNum());
        wbStatistics.setOriginalNum(md.getOriginalNum());
        return wbStatistics;
    }

    public static RepMediaDetail convertMediaDetailToReqWxMediaDetail(MediaDetail md) {
        RepWxMediaDetail wxMediaInfo = new RepWxMediaDetail();
        wxMediaInfo.setHlRead(md.getHeadReadNums());
        wxMediaInfo.setSdRead(md.getSecondReadNums());
        wxMediaInfo.setTdRead(md.getThirdReadNums());
        wxMediaInfo.setMbInfo(convertMediaDetailToWxMediaInfo(md));
        wxMediaInfo.setStatistics(convertMediaDetailToWxStatistics(md));
        wxMediaInfo.setTags(md.getTags());
        return wxMediaInfo;
    }

    public static RepWxMediaDetail.WxStatistics convertMediaDetailToWxStatistics(MediaDetail md) {

        RepWxMediaDetail.WxStatistics wxStatistics = new RepWxMediaDetail.WxStatistics();
        wxStatistics.setHlavGread(md.getHlavGread());
        wxStatistics.setHlavgZan(md.getHlavgZan());
        wxStatistics.setPubArticle(md.getPubArticle());
        wxStatistics.setPubNum(md.getPubNum());
        wxStatistics.setTotalZan(md.getTotalZan());
        wxStatistics.setSwjrArticle(md.getSwjrArticle());
        return wxStatistics;
    }

    public static List<PointNum> convertNumsToPointNums(long statisticTime, List<Integer> arrComments) {
        long l = TimeFormatUtils.TodayMorning(statisticTime) - 86400000 * 2;
        List<PointNum> pointNumList = new LinkedList<>();

        if (arrComments.size() == 7) {
            for (int i = arrComments.size() - 1; i >= 0; i--) {
                pointNumList.add(new PointNum(l - 86000000 * i, arrComments.get(i)));
            }
        } else {
            logger.error(String.format("convertNumsToPointNums statisticTime:%d current size:%d", statisticTime, arrComments.size()));
        }

        return pointNumList;
    }

    public static RepArticles convertArticleSetToRepMediaArticles(ArticleSet articleSet, int type) {
        switch (type) {
            case Constant.M_T_WEIBO:
                return convertArticleSetToRepWBArticles(articleSet);
            case Constant.M_T_WEIXIN:
                return convertArticleSetToRepWXArticles(articleSet);
            default:
                throw ZeusException.PlatformTypeInvaildError;
        }
    }

    public static RepArticles convertArticleSetToRepWXArticles(ArticleSet articleSet) {
        RepArticles<RepWxMediaArticle> ras = new RepArticles<>();
        ras.setTotalNum(articleSet.getTotal());
        List<RepWxMediaArticle> collect = articleSet.getArticleDetailList().stream().map(a -> {
            return convertArticleDetailToReqWxArticle(a);
        }).collect(Collectors.toList());
        ras.setList(collect);
        return ras;
    }

    public static RepWxMediaArticle convertArticleDetailToReqWxArticle(ArticleDetail a) {
        RepWxMediaArticle repWxMediaArticle = new RepWxMediaArticle();
        repWxMediaArticle.setCoverPlan(a.getCoverPlan());
        repWxMediaArticle.setMediaName(a.getMediaName());
        repWxMediaArticle.setpMid(a.getpMid());
        repWxMediaArticle.setPubTime(a.getPubTime());
        repWxMediaArticle.setReadNum(a.getReadNum());
        repWxMediaArticle.setZanNum(a.getZanNum());
        repWxMediaArticle.setTitle(a.getTitle());
        repWxMediaArticle.setUrl(a.getUrl());
        repWxMediaArticle.setBrief(a.getBrief());
        repWxMediaArticle.setIsAuth(a.getIsAuth());
        return repWxMediaArticle;
    }

    public static RepArticles convertArticleSetToRepWBArticles(ArticleSet articleSet) {
        RepArticles<RepWbMediaArticle> ras = new RepArticles<>();
        ras.setTotalNum(articleSet.getTotal());
        List<RepWbMediaArticle> collect = articleSet.getArticleDetailList().stream().map(a -> {
            return convertArticleDetailToReqWbArticle(a);
        }).collect(Collectors.toList());
        ras.setList(collect);
        return ras;
    }

    public static RepWbMediaArticle convertArticleDetailToReqWbArticle(ArticleDetail a) {
        RepWbMediaArticle repWbMediaArticle = new RepWbMediaArticle();
        repWbMediaArticle.setCoverPlan(a.getCoverPlan());
        repWbMediaArticle.setMediaName(a.getMediaName());
        repWbMediaArticle.setpMid(a.getpMid());
        repWbMediaArticle.setPubTime(a.getPubTime());
        repWbMediaArticle.setZanNum(a.getZanNum());
        repWbMediaArticle.setCommentNum(a.getCommentNum());
        repWbMediaArticle.setSpreadNum(a.getSpreadNum());
        repWbMediaArticle.setTltle(a.getTitle());
        repWbMediaArticle.setUrl(a.getUrl());
        repWbMediaArticle.setBrief(a.getBrief());
        repWbMediaArticle.setIsAuth(a.getIsAuth());
        repWbMediaArticle.setFansNum(a.getFansNum());
        return repWbMediaArticle;
    }

    public static List<RepUserMediaTags> convertTagCountToRepTagList(List<TagCount> userMediaTags) {
        return userMediaTags.stream().map(tagCount -> new RepUserMediaTags(tagCount.getTag(), tagCount.getCount())).collect(Collectors.toList());
    }

    public static RepUserMediaTagsWeb convertTagCountToRepTagListWeb(List<TagCount> userMediaTags) {
        RepUserMediaTagsWeb userMediaTagsWeb = new RepUserMediaTagsWeb();
        convertTagCountToRepTagList(userMediaTags).forEach(item -> tagListWebConvert(userMediaTagsWeb, item));
        return userMediaTagsWeb;
    }

    private static void tagListWebConvert(RepUserMediaTagsWeb repUserMediaTagsWeb, RepUserMediaTags repUserMediaTags) {
        if (repUserMediaTags.getName().equals("无标签")) {
            repUserMediaTagsWeb.setNoTagnum(repUserMediaTags.getNum());
        } else {
            repUserMediaTagsWeb.addTagLetter(repUserMediaTags.getName(), PinyinApi.getPinYinHeadChar(repUserMediaTags.getName()));
        }
    }

    public static MediaDetail convertGsDataToMediaDetail(GsData d) {
        MediaDetail mediaDetail = new MediaDetail();
        mediaDetail.setType(Constant.M_T_WEIXIN);
        mediaDetail.setBrief(d.getFunctionintroduce());
        mediaDetail.setMediaId(d.getWechatid());
        mediaDetail.setQrcode(d.getQrcodeurl());
        mediaDetail.setIsAuth(StringUtils.isNoneBlank(d.getAuthenticationInfo()) ? 1 : 0);
        mediaDetail.setMediaName(d.getWechatname());
        mediaDetail.setpMid(RegexUtils.sub(".*biz=([^&]*).*", d.getIncluded(), 0));
        mediaDetail.setMediaImage(d.getQrcodeurl());
        mediaDetail.setAuthInfo(d.getAuthenticationInfo());
        return mediaDetail;
    }

    public static MediaDetail convertWbAccountToMediaDetail(WeiboAccount weiboAccount) {
        MediaDetail mediaDetail = new MediaDetail();
        mediaDetail.setMediaId(weiboAccount.getWeiboID());
        mediaDetail.setType(Constant.M_T_WEIBO);
        mediaDetail.setBrief(weiboAccount.getDesc());
        mediaDetail.setpMid(weiboAccount.getWeiboID());
        mediaDetail.setMediaImage(weiboAccount.getHeadImg());
        mediaDetail.setAuthInfo(weiboAccount.getVerifiedReason());
        mediaDetail.setIsAuth(Integer.parseInt(weiboAccount.getVerifiedType()));
        mediaDetail.setMediaName(weiboAccount.getNickName());
        mediaDetail.setFansNum(weiboAccount.getFansNum());
        return mediaDetail;
    }

    public static MediaDetail convertWeiboSearchAccountToMediaDetai(WeiboSearchAccount wsa) {
        MediaDetail mediaDetail = new MediaDetail();
        mediaDetail.setAuthInfo(wsa.getCompany());
        mediaDetail.setFansNum(Integer.valueOf(wsa.getFans()));
        mediaDetail.setMediaImage(wsa.getHeadportrait());
        if (StringUtils.isBlank(wsa.getCompany())) {
            mediaDetail.setIsAuth(0);
        } else if (wsa.getVertifyType().contains("个人")) {
            mediaDetail.setIsAuth(1);
        } else {
            mediaDetail.setIsAuth(2);
        }
        mediaDetail.setMediaName(wsa.getAccount());
        mediaDetail.setMediaId(wsa.getWeiboId());
        mediaDetail.setpMid(wsa.getWeiboId());
        mediaDetail.setType(Constant.M_T_WEIBO);
        mediaDetail.setBrief(wsa.getIntroduction());
        return mediaDetail;
    }

    public static RepWxHotMedia convertWxMediaSetToRepWxHotMedia(MediaSet mediaSet, String type) {
        RepWxHotMedia repWxHotMedia = new RepWxHotMedia();
        repWxHotMedia.setTotalNum(mediaSet.getTotalNum());

        if (mediaSet.getMediaDetailList().isEmpty()) {
            repWxHotMedia.setList(new ArrayList<>());
        } else {
            List<WxHotMedia> list = new ArrayList<>();
            for (MediaDetail mediaDetail : mediaSet.getMediaDetailList()) {
                WxHotMedia wxHotMedia = new WxHotMedia();
                wxHotMedia.setNum(sortByType(type, mediaDetail));
                wxHotMedia.setpMid(mediaDetail.getpMid());
                wxHotMedia.setType(mediaDetail.getType());
                wxHotMedia.setMediaName(mediaDetail.getMediaName());
                wxHotMedia.setIsAuth(mediaDetail.getIsAuth());
                wxHotMedia.setMediaImage(mediaDetail.getMediaImage());
                list.add(wxHotMedia);
            }
            repWxHotMedia.setList(list);
        }

        return repWxHotMedia;
    }

    public static ReqMediaHotWords convertWxMediaDetailToReqMediaHotWords(MediaDetail mediaDetail) {

        return null;
    }




    public static RepWxMediaHotArticle convertWxMediaSetToRepWxMediaHotArticle(ArticleSet articleSet) {
        RepWxMediaHotArticle repWxMediaHotArticle = new RepWxMediaHotArticle();
        repWxMediaHotArticle.setTotalNum(articleSet.getTotal());

        if (articleSet.getArticleDetailList().isEmpty()) {
            repWxMediaHotArticle.setList(new ArrayList<>());
        } else {
            List<WxMediaHotArticleBean> list = new ArrayList<>();
            for (ArticleDetail articleDetail : articleSet.getArticleDetailList()) {
                WxMediaHotArticleBean wx = new WxMediaHotArticleBean();
                wx.setpMid(articleDetail.getpMid());
                wx.setTitle(articleDetail.getTitle());
                wx.setMediaName(articleDetail.getMediaName());
                wx.setPubTime(articleDetail.getPubTime());
                wx.setUrl(articleDetail.getUrl());
                wx.setIsOriginal(articleDetail.getOriginal());
                wx.setCoverPlan(articleDetail.getCoverPlan());
                wx.setReadNum(articleDetail.getReadNum());
                wx.setZanNum(articleDetail.getZanNum());
                wx.setIsAuth(articleDetail.getIsAuth());
                wx.setBrief(articleDetail.getBrief());
                wx.setMediaImg(articleDetail.getMediaImage());
                list.add(wx);
            }
            repWxMediaHotArticle.setList(list);
        }
        return repWxMediaHotArticle;
    }

    public static RepWxPotentialMedia convertWxMediaSetToRepWxPotentialMedia(MediaSet mediaSet, String type) {
        RepWxPotentialMedia repWxPotentialMedia = new RepWxPotentialMedia();
        repWxPotentialMedia.setTotalNum(mediaSet.getTotalNum());
        if (mediaSet.getMediaDetailList().isEmpty()) {
            repWxPotentialMedia.setList(new ArrayList<>());
        } else {
            List<RepWxPotentialMedia.WxPotentialMedia> wxPotentialMedias = new ArrayList<>();
            for (MediaDetail mediaDetail : mediaSet.getMediaDetailList()) {
                RepWxPotentialMedia.WxPotentialMedia wxPotentialMedia = new RepWxPotentialMedia.WxPotentialMedia();
                wxPotentialMedia.setIsAuth(mediaDetail.getIsAuth());
                wxPotentialMedia.setMediaName(mediaDetail.getMediaName());
                wxPotentialMedia.setMediaImage(mediaDetail.getMediaImage());
                wxPotentialMedia.setType(mediaDetail.getType());
                wxPotentialMedia.setpMid(mediaDetail.getpMid());
                wxPotentialMedia.setGrowthRate(sortGrowRateByType(type, mediaDetail));
                wxPotentialMedias.add(wxPotentialMedia);
            }
            repWxPotentialMedia.setList(wxPotentialMedias);
        }
        return repWxPotentialMedia;
    }

    public static RepWbMediaHotArticle convertWxMediaSetToRepWbMediaHotArticle(ArticleSet articleSet) {
        RepWbMediaHotArticle repWbMediaHotArticle = new RepWbMediaHotArticle();
        repWbMediaHotArticle.setTotalNum(articleSet.getTotal());
        if (articleSet.getArticleDetailList().isEmpty()) {
            repWbMediaHotArticle.setList(new ArrayList<>());
        } else {
            List<WbMediaHotArticleBean> list = new ArrayList<>();
            for (ArticleDetail articleDetail : articleSet.getArticleDetailList()) {
                WbMediaHotArticleBean wb = new WbMediaHotArticleBean();
                wb.setpMid(articleDetail.getpMid());
                wb.setUrl(articleDetail.getUrl());
                wb.setTitle(articleDetail.getTitle());
                wb.setMediaName(articleDetail.getMediaName());
                wb.setCoverPlan(articleDetail.getCoverPlan());
                wb.setPubTime(articleDetail.getPubTime());
                wb.setIsOriginal(articleDetail.getOriginal());
                wb.setZanNum(articleDetail.getZanNum());
                wb.setSpreadNum(articleDetail.getSpreadNum());
                wb.setCommentNum(articleDetail.getCommentNum());
                wb.setIsAuth(articleDetail.getIsAuth());
                wb.setMediaImg(articleDetail.getMediaImage());
                list.add(wb);

            }
            repWbMediaHotArticle.setList(list);
        }
        return repWbMediaHotArticle;
    }

    public static RepWbHotMedia convertWxMediaSetToRepWbHotMedia(MediaSet mediaSet, String type) {
        RepWbHotMedia repWbHotMedia = new RepWbHotMedia();
        repWbHotMedia.setTotalNum(mediaSet.getTotalNum());
        if (mediaSet.getMediaDetailList().isEmpty()) {
            repWbHotMedia.setList(new ArrayList<>());
        } else {
            List<WbHotMedia> wbHotMedias = new ArrayList<>();
            for (MediaDetail mediaDetail : mediaSet.getMediaDetailList()) {
                WbHotMedia wbHotMedia = new WbHotMedia();
                wbHotMedia.setMediaName(mediaDetail.getMediaName());
                wbHotMedia.setIsAuth(mediaDetail.getIsAuth());
                wbHotMedia.setMediaImage(mediaDetail.getMediaImage());
                wbHotMedia.setNum(sortByType(type, mediaDetail));
                wbHotMedia.setType(mediaDetail.getType());
                wbHotMedia.setpMid(mediaDetail.getpMid());
                wbHotMedias.add(wbHotMedia);
            }
            repWbHotMedia.setList(wbHotMedias);
        }
        return repWbHotMedia;
    }

    public static RepWbPotentialMedia convertWbMediaSetToRepWbPotentialMedia(MediaSet mediaSet, String type) {
        RepWbPotentialMedia repWbPotentialMedia = new RepWbPotentialMedia();
        repWbPotentialMedia.setTotalNum(mediaSet.getTotalNum());
        if (mediaSet.getMediaDetailList().isEmpty()) {
            repWbPotentialMedia.setList(new ArrayList<>());
        } else {
            List<RepWbPotentialMedia.WbPotentialMedia> wbPotentialMedias = new ArrayList<>();
            for (MediaDetail mediaDetail : mediaSet.getMediaDetailList()) {
                RepWbPotentialMedia.WbPotentialMedia wbPotentialMedia = new RepWbPotentialMedia.WbPotentialMedia();
                wbPotentialMedia.setMediaName(mediaDetail.getMediaName());
                wbPotentialMedia.setIsAuth(mediaDetail.getIsAuth());
                wbPotentialMedia.setMediaImage(mediaDetail.getMediaImage());
                wbPotentialMedia.setGrowthRate(sortGrowRateByType(type, mediaDetail));
                wbPotentialMedia.setType(mediaDetail.getType());
                wbPotentialMedia.setpMid(mediaDetail.getpMid());
                wbPotentialMedias.add(wbPotentialMedia);
            }
            repWbPotentialMedia.setList(wbPotentialMedias);
        }
        return repWbPotentialMedia;
    }

    public static RepHomePage convertWxMediaSetToRepHomePage(int wxMediaNum, int wbMediaNum, MediaSet wxMediaSet, ArticleSet wxArticleSet,
                                                             MediaSet wbMediaSet, ArticleSet wbArtcielSet) {
        RepHomePage repHomePage = new RepHomePage();
        //微信
        RepHomeWxData weixin = new RepHomeWxData();
        RepHomeWbData weibo = new RepHomeWbData();


        //微信媒体总数
        weixin.setMediaNum(wxMediaNum);

        //微信热媒列表
        RepHomeWxRank rankListwx = new RepHomeWxRank();
        rankListwx.setTotalNum(wxMediaSet.getTotalNum());

        List<RepHomeWxBasic> list = new ArrayList<>();
        for (MediaDetail mediaDetail : wxMediaSet.getMediaDetailList()) {
            RepHomeWxBasic r = new RepHomeWxBasic();
            r.setpMid(mediaDetail.getpMid());
            r.setMediaImage(mediaDetail.getMediaImage());
            r.setMediaName(mediaDetail.getMediaName());
            r.setAvgRead(mediaDetail.getHlavGread());
            r.setIsOriginal(mediaDetail.getIsOriginal());
            r.setIsAuth(mediaDetail.getIsAuth());
            list.add(r);
        }
        rankListwx.setList(list);


        //微信热文列表
        RepHomeWxHotArticle repHomeWxHotArticle = new RepHomeWxHotArticle();
        repHomeWxHotArticle.setTotalNum(wxArticleSet.getTotal());

        List<RepHomeWxArticle> articles = new ArrayList<>();
        for (ArticleDetail articleDetail : wxArticleSet.getArticleDetailList()) {
            RepHomeWxArticle repHomeWxArticle = new RepHomeWxArticle();
            repHomeWxArticle.setReadNum(articleDetail.getReadNum());
            repHomeWxArticle.setZanNum(articleDetail.getZanNum());
            repHomeWxArticle.setIsOriginal(articleDetail.getOriginal());
            repHomeWxArticle.setMediaName(articleDetail.getMediaName());
            repHomeWxArticle.setpMid(articleDetail.getpMid());
            repHomeWxArticle.setPubTime(articleDetail.getPubTime());
            repHomeWxArticle.setTitle(articleDetail.getTitle());
            repHomeWxArticle.setUrl(articleDetail.getUrl());
            repHomeWxArticle.setIsAuth(articleDetail.getIsAuth());
            articles.add(repHomeWxArticle);
        }
        repHomeWxHotArticle.setList(articles);

        weixin.setRankList(rankListwx);
        weixin.setHotArticle(repHomeWxHotArticle);
        //设置微信字段
        repHomePage.setWeixin(weixin);


        //微博媒体总数
        weibo.setMediaNum(wbMediaNum);

        //微博热媒列表
        RepHomeWbRank repHomeWbRank = new RepHomeWbRank();
        repHomeWbRank.setTotalNum(wbMediaSet.getTotalNum());

        List<RepHomeWbBasic> wbBasics = new ArrayList<>();
        for (MediaDetail mediaDetail : wbMediaSet.getMediaDetailList()) {
            RepHomeWbBasic wbBasic = new RepHomeWbBasic();
            wbBasic.setpMid(mediaDetail.getpMid());
            wbBasic.setAvgSpread(mediaDetail.getAvgSpread());
            wbBasic.setMediaImage(mediaDetail.getMediaImage());
            wbBasic.setMediaName(mediaDetail.getMediaName());
            wbBasic.setIsAuth(mediaDetail.getIsAuth());
            wbBasics.add(wbBasic);
        }
        repHomeWbRank.setList(wbBasics);

        //微博热文列表
        RepHomeWbHotArticle repHomeWbHotArticle = new RepHomeWbHotArticle();
        repHomeWbHotArticle.setTotalNum(wbArtcielSet.getTotal());

        List<RepHomeWbArticle> wbArticles = new ArrayList<>();
        for (ArticleDetail articleDetail : wbArtcielSet.getArticleDetailList()) {

            RepHomeWbArticle wbArticle = new RepHomeWbArticle();
            wbArticle.setMediaName(articleDetail.getMediaName());
            wbArticle.setpMid(articleDetail.getpMid());
            wbArticle.setPubTime(articleDetail.getPubTime());
            wbArticle.setTitle(articleDetail.getTitle());
            wbArticle.setUrl(articleDetail.getUrl());
            wbArticle.setCommentNum(articleDetail.getCommentNum());
            wbArticle.setSpreadNum(articleDetail.getSpreadNum());
            wbArticle.setZanNum(articleDetail.getZanNum());
            wbArticle.setIsAuth(articleDetail.getIsAuth());

            wbArticles.add(wbArticle);
        }
        repHomeWbHotArticle.setList(wbArticles);

        weibo.setHotArticle(repHomeWbHotArticle);
        weibo.setRankList(repHomeWbRank);


        repHomePage.setWeibo(weibo);
        return repHomePage;
    }


    public static int sortByType(String type, MediaDetail mediaDetail) {
        if (type.equals(MediaDetail.SPREAD)) {
            return mediaDetail.getAvgSpread();
        } else if (type.equals(MediaDetail.ZAN)) {
            if (mediaDetail.getType() == Constant.M_T_WEIXIN)
                return mediaDetail.getHlavgZan();
            else if (mediaDetail.getType() == Constant.M_T_WEIBO)
                return mediaDetail.getAvgZan();
        } else if (type.equals(MediaDetail.COMMENT)) {
            return mediaDetail.getAvgComment();
        } else if (type.equals(MediaDetail.READ)) {
            return mediaDetail.getHlavGread();
        }
        return -1;
    }

    public static RepUpgrade convertUpgradeToRepUpgrade(Upgrade upgradeByPlay) {
        RepUpgrade repUpgrade = new RepUpgrade();
        repUpgrade.setDes(upgradeByPlay.getDes());
        repUpgrade.setFileSize(upgradeByPlay.getFileSize());
        repUpgrade.setIsForce(upgradeByPlay.getIsForce());
        repUpgrade.setTitle(upgradeByPlay.getTitle());
        repUpgrade.setUrl(upgradeByPlay.getUrl());
        repUpgrade.setVersion(upgradeByPlay.getVersion());
        return repUpgrade;
    }

    public static RepTagsResult convertTagCountToRepTagsResult(List<TagCount> userMediaTags) {
        List<RepUserMediaTags> repUserMediaTagses = convertTagCountToRepTagList(userMediaTags);
        final int[] notagsNum = {0};
        List<RepUserMediaTags> tags = repUserMediaTagses.stream().filter(f -> {
            boolean isnotag = f.getName().equals("无标签");
            if (isnotag) {
                notagsNum[0] = f.getNum();
            }
            return !isnotag;
        }).collect(Collectors.toList());
        return new RepTagsResult(notagsNum[0], tags);
    }

    public static List<RepTagCloud> convertUserTagCloudToRepTagCloud(List<UserTagCloud> userTagClouds) {
        if (null == userTagClouds || userTagClouds.isEmpty())
            return null;
        return userTagClouds.stream().map(item -> {
            RepTagCloud repTagCloud = new RepTagCloud();
            repTagCloud.setLastType(item.getType());
            repTagCloud.setMediaImage(item.getPortrait());
            repTagCloud.setTag(item.getTag());
            repTagCloud.setWbNum(item.getWbNum());
            repTagCloud.setWxNum(item.getWxNum());
            return repTagCloud;
        }).collect(Collectors.toList());
    }

    public static MediaDetail convertGWxMediaToMediaDetail(GWxMedia wxMedia) {
        MediaDetail mediaDetail = new MediaDetail();
        mediaDetail.setType(Constant.M_T_WEIXIN);
        mediaDetail.setpMid(wxMedia.getPmid());
        mediaDetail.setMediaId(wxMedia.getWeixinId());
        mediaDetail.setIsAuth(wxMedia.getIsAuth());
        mediaDetail.setAuthInfo(wxMedia.getAuthInfo());
        mediaDetail.setMediaName(wxMedia.getMediaName());
        mediaDetail.setBrief(wxMedia.getBrief());
        if(StringUtils.isEmpty(wxMedia.getWeixinId())) {
            mediaDetail.setMediaImageDefault();
            mediaDetail.setQrcode(String.format("http://mp.weixin.qq.com/mp/qrcode?scene=10000004&size=400&__biz=%s", wxMedia.getPmid()));
        }else{
            mediaDetail.setMediaImage(wxMedia.getHeadImage());
            mediaDetail.setQrcode(wxMedia.getHeadImage());
        }

        mediaDetail.setIsOriginal(wxMedia.getIsOriginal());
        mediaDetail.setReadGrowRate(String.format("%+.2f", wxMedia.getAvgHeadReadRateInPeroid() * 100));
        mediaDetail.setZanGrowRate(String.format("%+.2f", wxMedia.getAvgHeadLikeRateInPeroid() * 100));
        Collections.reverse(wxMedia.getHeadReadPoints());
        Collections.reverse(wxMedia.getSecondReadPoints());
        Collections.reverse(wxMedia.getThirdReadPoints());

        mediaDetail.setSwjrArticle(wxMedia.getHotArticleNumInPeroid());
        mediaDetail.setHlavGread(wxMedia.getAvgHeadReadNumInPeroid());
        mediaDetail.setHlavgZan((wxMedia.getAvgHeadLikeNumInPeroid()));
        mediaDetail.setPubNum(wxMedia.getPubNumInPeroid());
        mediaDetail.setPubArticle(wxMedia.getPubArticleNumInPeroid());
        mediaDetail.setHeadReadNums(wxMedia.getHeadReadPoints().stream().map(ConvertUtil::convertGaiaPointToZeusPoint).collect(Collectors.toList()));
        mediaDetail.setSecondReadNums(wxMedia.getSecondReadPoints().stream().map(ConvertUtil::convertGaiaPointToZeusPoint).collect(Collectors.toList()));
        mediaDetail.setThirdReadNums(wxMedia.getThirdReadPoints().stream().map(ConvertUtil::convertGaiaPointToZeusPoint).collect(Collectors.toList()));
        mediaDetail.setTotalZan(wxMedia.getTotalLikeNumInPeroid());

        mediaDetail.setMediaHotWord(wxMedia.getMediaHotWords().stream().map(ConvertUtil::convertHotTokenToMediaHotWords).collect(Collectors.toList()));

        return mediaDetail;
    }

    public static PointNum convertGaiaPointToZeusPoint(Point point) {
        return new PointNum(point.getTime(), Math.toIntExact(point.getValue()));
    }


    public static MediaDetail convertGWbMediaToMediaDetail(GWbMedia wbMedia) {
        MediaDetail mediaDetail = new MediaDetail();

        mediaDetail.setType(Constant.M_T_WEIBO);
        mediaDetail.setpMid(wbMedia.getPmid());
        mediaDetail.setMediaId(wbMedia.getPmid());
        mediaDetail.setMediaName(wbMedia.getMediaName());
        mediaDetail.setMediaImage(wbMedia.getHeadImage());
        mediaDetail.setIsOriginal(wbMedia.getIsOriginal());
        mediaDetail.setIsAuth(wbMedia.getIsAuth());
        mediaDetail.setAuthInfo(wbMedia.getAuthInfo());
        mediaDetail.setFansNum(wbMedia.getFansNum());

        mediaDetail.setSpreadGrowRate(String.format("%+.2f", wbMedia.getAvgForwardRateInPeroid() * 100));
        mediaDetail.setCommentGrowRate(String.format("%+.2f", wbMedia.getAvgCommentRateInPeroid() * 100));
        mediaDetail.setZanGrowRate(String.format("%+.2f", wbMedia.getAvgLikeRateInPeroid() * 100));

        mediaDetail.setAvgZan(wbMedia.getAvgLikeNumInPeroid());
        mediaDetail.setAvgSpread(wbMedia.getAvgForwardNumInPeroid());
        mediaDetail.setAvgComment(wbMedia.getAvgCommentNumInPeroid());

        mediaDetail.setOriginalNum(wbMedia.getPubOriginalArticleNumInPeroid());
        mediaDetail.setPubNum(wbMedia.getPubNumInPeroid());
        mediaDetail.setPubArticle(wbMedia.getPubNumInPeroid());
        Collections.reverse(wbMedia.getTotalCommentPoints());
        mediaDetail.setTotalCommentNums(wbMedia.getTotalCommentPoints().stream().map(ConvertUtil::convertGaiaPointToZeusPoint).collect(Collectors.toList()));

        Collections.reverse(wbMedia.getTotalLikePoints());
        mediaDetail.setTotalZanNums(wbMedia.getTotalLikePoints().stream().map(ConvertUtil::convertGaiaPointToZeusPoint).collect(Collectors.toList()));

        Collections.reverse(wbMedia.getTotalForwardPoints());
        mediaDetail.setTotalSpreadNums(wbMedia.getTotalForwardPoints().stream().map(ConvertUtil::convertGaiaPointToZeusPoint).collect(Collectors.toList()));
        mediaDetail.setBrief(wbMedia.getBrief());

        mediaDetail.setMediaHotWord(wbMedia.getMediaHotWords().stream().map(ConvertUtil::convertHotTokenToMediaHotWords).collect(Collectors.toList()));

        return mediaDetail;
    }

    public static MediaHotWords convertHotTokenToMediaHotWords(HotToken hotToken) {
        return new MediaHotWords(hotToken.getToken(), Integer.valueOf(hotToken.getScore()));
    }

    public static List<MediaDetail> convertGWxMediasToMediaDetails(List<GWxMedia> medias) {
        return medias.stream().map(ConvertUtil::convertGWxMediaToMediaDetail).collect(Collectors.toList());
    }

    public static List<MediaDetail> convertGWbMediasToMediaDetails(List<GWbMedia> medias) {
        return medias.stream().map(ConvertUtil::convertGWbMediaToMediaDetail).collect(Collectors.toList());
    }


    public static ArticleDetail convertGWbArticleToWbArticle(GWbArticle gWbArticle, GWbMedia wbMedia) {
        ArticleDetail articleDetail = new ArticleDetail();

        articleDetail.setUrl(gWbArticle.getArticleUrl());

        articleDetail.setZanNum(gWbArticle.getLikeNum());
        articleDetail.setPubTime(gWbArticle.getPostTime());
        articleDetail.setpMid(gWbArticle.getPmid());
        articleDetail.setCommentNum(gWbArticle.getCommentNum());
        articleDetail.setSpreadNum(gWbArticle.getForwardNum());
        articleDetail.setBrief(gWbArticle.getTitle());
        articleDetail.setCoverPlan(gWbArticle.getCoverPlan());
        articleDetail.setArticleType(gWbArticle.getArticleType());
        if(null != gWbArticle.getCoverPlan() && (gWbArticle.getCoverPlan().contains("media_box") || gWbArticle.getCoverPlan().contains("feed_list_media_prev"))) {
            gWbArticle.setArticleType("movie");
            articleDetail.setCoverPlan(null);
            articleDetail.setArticleType(gWbArticle.getArticleType());
        }

        articleDetail.setIsAuth(wbMedia.getIsAuth());
        articleDetail.setMediaId(wbMedia.getPmid());
        String articleBrief = Jsoup.parseBodyFragment(gWbArticle.getContent()).text();
        articleBrief = (articleBrief == null) || (articleBrief.length() < 30) ? articleBrief : articleBrief.substring(0, 30);
        articleDetail.setTitle(articleBrief);
        articleDetail.setBrief(articleBrief);
        articleDetail.setIsAuth(wbMedia.getIsAuth());
        articleDetail.setOriginal(wbMedia.getIsOriginal());

        articleDetail.setMediaImage(wbMedia.getHeadImage());
        articleDetail.setFansNum(String.valueOf(wbMedia.getFansNum()));
        articleDetail.setMediaName(wbMedia.getMediaName());
        articleDetail.setAutoInfo(wbMedia.getAuthInfo());
        return articleDetail;

    }

    public static ArticleDetail convertGWxArticleToWxArticle(GWxArticle gWxArticle, GWxMedia wbMedia) {
        ArticleDetail articleDetail = new ArticleDetail();
        articleDetail.setUrl(gWxArticle.getArticleUrl());
        articleDetail.setTitle(gWxArticle.getTitle());
        articleDetail.setZanNum(gWxArticle.getLikeNum());
        articleDetail.setReadNum(gWxArticle.getReadNum());
        articleDetail.setPubTime(gWxArticle.getPostTime());
        articleDetail.setpMid(gWxArticle.getPmid());
        articleDetail.setCoverPlan(gWxArticle.getCoverPlan());
        articleDetail.setIsAuth(wbMedia.getIsAuth());
        articleDetail.setMediaId(wbMedia.getWeixinId());
        String articleBrief = Jsoup.parseBodyFragment(gWxArticle.getContent()).text();
        articleBrief = (articleBrief == null) || (articleBrief.length() < 30) ? articleBrief : articleBrief.substring(0, 30);
        articleDetail.setBrief(articleBrief);
        articleDetail.setIsAuth(wbMedia.getIsAuth());
        articleDetail.setOriginal(wbMedia.getIsOriginal());
        articleDetail.setMediaName(wbMedia.getMediaName());
        articleDetail.setMediaImage(wbMedia.getHeadImage());
        return articleDetail;
    }


    public static String sortGrowRateByType(String type, MediaDetail mediaDetail) {
        if (type.equals(MediaDetail.SPREAD)) {
            return mediaDetail.getSpreadGrowRate();
        } else if (type.equals(MediaDetail.ZAN)) {
            return mediaDetail.getZanGrowRate();
        } else if (type.equals(MediaDetail.COMMENT)) {
            return mediaDetail.getCommentGrowRate();
        } else if (type.equals(MediaDetail.READ)) {
            return mediaDetail.getReadGrowRate();
        }
        return null;
    }
}
