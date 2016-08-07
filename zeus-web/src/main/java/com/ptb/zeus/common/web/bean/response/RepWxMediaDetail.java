package com.ptb.zeus.common.web.bean.response;

import com.ptb.zeus.common.common.Tag;
import com.ptb.zeus.common.common.WxMediaInfo;
import com.ptb.zeus.common.common.PointNum;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 微信媒体资料信息
 *
 * @author lenovo
 */
public class RepWxMediaDetail extends RepMediaDetail {
    private WxMediaInfo mbInfo;
    private List<Tag> tags;
    private WxStatistics statistics;
    private List<PointNum> hlRead;
    private List<PointNum> sdRead;
    private List<PointNum> tdRead;


    public WxMediaInfo getMbInfo() {
        return mbInfo;
    }

    public void setMbInfo(WxMediaInfo mbInfo) {
        this.mbInfo = mbInfo;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        if (tags != null) {
            this.tags = tags.stream().map(s -> new Tag(s, s)).collect(Collectors.toList());
        }
    }

    public WxStatistics getStatistics() {
        return statistics;
    }

    public void setStatistics(WxStatistics statistics) {
        this.statistics = statistics;
    }

    public List<PointNum> getHlRead() {
        return hlRead;
    }

    public void setHlRead(List<PointNum> hlRead) {
        this.hlRead = hlRead;
    }

    public List<PointNum> getSdRead() {
        return sdRead;
    }

    public void setSdRead(List<PointNum> sdRead) {
        this.sdRead = sdRead;
    }

    public List<PointNum> getTdRead() {
        return tdRead;
    }

    public void setTdRead(List<PointNum> tdRead) {
        this.tdRead = tdRead;
    }

    public static class WxStatistics {
        private int pubNum;
        private int pubArticle;
        private int totalZan;
        private int swjrArticle;
        private int hlavGread;
        private int hlavgZan;

        public int getPubArticle() {
            return pubArticle;
        }

        public int getPubNum() {
            return pubNum;
        }

        public void setPubNum(int pubNum) {
            this.pubNum = pubNum;
        }

        public void setPubArticle(int pubArticle) {
            this.pubArticle = pubArticle;
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
    }

}
