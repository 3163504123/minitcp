package com.ptb.zeus.common.web.bean.response;


import com.ptb.zeus.common.common.MediaDetail;
import com.ptb.zeus.common.common.MediaSet;
import com.ptb.zeus.common.utils.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * 微信媒体潜力榜单
 *
 * @author lenovo
 */
public class RepWxPotentialMedia {

    private int totalNum;
    private List<WxPotentialMedia> list;

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public List<WxPotentialMedia> getList() {
        return list;
    }

    public void setList(List<WxPotentialMedia> list) {
        this.list = list;
    }

    public static RepWxPotentialMedia getDefault(int start, int end) {
        RepWxPotentialMedia repWxPotentialMedia = new RepWxPotentialMedia();
        repWxPotentialMedia.setTotalNum(40);

        if (start >= 40) {
            repWxPotentialMedia.setList(new ArrayList<>());
            return repWxPotentialMedia;
        }


        List<WxPotentialMedia> wxPotentialMedias = new ArrayList<>();

        WxPotentialMedia wxPotentialMedia = new WxPotentialMedia();
        wxPotentialMedia.setIsAuth(0);
        wxPotentialMedia.setMediaName("龙游广电");
        wxPotentialMedia.setMediaImage("http://open.weixin.qq.com/qr/code/?username=zj_lyrt");
        wxPotentialMedia.setType(Constant.M_T_WEIXIN);
        wxPotentialMedia.setpMid("MzA5NzQ5OTE3NA==");
        wxPotentialMedia.setGrowthRate("200");
        for (int index = start; index < 40 && index < end; index++)
            wxPotentialMedias.add(wxPotentialMedia);
        repWxPotentialMedia.setList(wxPotentialMedias);

        return repWxPotentialMedia;
    }

    public static RepWxPotentialMedia toController(MediaSet mediaSet, String type) {
        RepWxPotentialMedia repWxPotentialMedia = new RepWxPotentialMedia();
        repWxPotentialMedia.setTotalNum(mediaSet.getTotalNum());
        if (mediaSet.getMediaDetailList().isEmpty()) {
            repWxPotentialMedia.setList(new ArrayList<>());
        } else {
            List<WxPotentialMedia> wxPotentialMedias = new ArrayList<>();
            for (MediaDetail mediaDetail : mediaSet.getMediaDetailList()) {
                WxPotentialMedia wxPotentialMedia = new WxPotentialMedia();
                wxPotentialMedia.setIsAuth(mediaDetail.getIsAuth());
                wxPotentialMedia.setMediaName(mediaDetail.getMediaName());
                wxPotentialMedia.setMediaImage(mediaDetail.getMediaImage());
                wxPotentialMedia.setType(mediaDetail.getType());
                wxPotentialMedia.setpMid(mediaDetail.getpMid());
                wxPotentialMedia.setGrowthRate(mediaDetail.getGrowRate());
                wxPotentialMedias.add(wxPotentialMedia);
            }
            repWxPotentialMedia.setList(wxPotentialMedias);
        }
        return repWxPotentialMedia;
    }

    public static class WxPotentialMedia {
        private String pMid;
        private int type;
        private String mediaImage;
        private String mediaName;
        private int isAuth;
        private String growthRate;

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

        public int getIsAuth() {
            return isAuth;
        }

        public void setIsAuth(int isAuth) {
            this.isAuth = isAuth;
        }

        public String getGrowthRate() {
            return growthRate;
        }

        public void setGrowthRate(String growthRate) {
            this.growthRate = growthRate;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }

}
