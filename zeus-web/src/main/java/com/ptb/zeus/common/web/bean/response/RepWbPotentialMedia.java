package com.ptb.zeus.common.web.bean.response;

import java.util.List;

/**
 * 微博潜力榜单媒体
 *
 * @author lenovo
 */
public class RepWbPotentialMedia {
    private int totalNum;
    private List<WbPotentialMedia> list;

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public List<WbPotentialMedia> getList() {
        return list;
    }

    public void setList(List<WbPotentialMedia> list) {
        this.list = list;
    }

    public static class WbPotentialMedia {
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