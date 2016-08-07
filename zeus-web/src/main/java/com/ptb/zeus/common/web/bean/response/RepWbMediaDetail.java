package com.ptb.zeus.common.web.bean.response;

import com.ptb.zeus.common.common.PointNum;
import com.ptb.zeus.common.common.Tag;
import com.ptb.zeus.common.common.WbMediaInfo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 微博媒体资料
 *
 * @author lenovo
 */
public class RepWbMediaDetail extends RepMediaDetail {
    private WbMediaInfo mbInfo;
    private List<Tag> tags;
    private WbStatistics statistics;
    private List<PointNum> spread;
    private List<PointNum> zan;
    private List<PointNum> comment;

    public WbMediaInfo getMbInfo() {
        return mbInfo;
    }

    public void setMbInfo(WbMediaInfo mbInfo) {
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

    public WbStatistics getStatistics() {
        return statistics;
    }

    public void setStatistics(WbStatistics statistics) {
        this.statistics = statistics;
    }

    public List<PointNum> getSpread() {
        return spread;
    }

    public void setSpread(List<PointNum> spread) {
        this.spread = spread;
    }

    public List<PointNum> getZan() {
        return zan;
    }

    public void setZan(List<PointNum> zan) {
        this.zan = zan;
    }

    public List<PointNum> getComment() {
        return comment;
    }

    public void setComment(List<PointNum> comment) {
        this.comment = comment;
    }



    public static class WbStatistics {
        private long pubNum;
        private long pubArticle;
        private long avgSpread;
        private long avgComment;
        private long avgZan;
        private long originalNum;

        public long getPubNum() {
            return pubNum;
        }

        public void setPubNum(long pubNum) {
            this.pubNum = pubNum;
        }

        public long getPubArticle() {
            return pubArticle;
        }

        public void setPubArticle(long pubArticle) {
            this.pubArticle = pubArticle;
        }

        public long getAvgSpread() {
            return avgSpread;
        }

        public void setAvgSpread(long avgSpread) {
            this.avgSpread = avgSpread;
        }

        public long getAvgComment() {
            return avgComment;
        }

        public void setAvgComment(long avgComment) {
            this.avgComment = avgComment;
        }

        public long getAvgZan() {
            return avgZan;
        }

        public void setAvgZan(long avgZan) {
            this.avgZan = avgZan;
        }

        public long getOriginalNum() {
            return originalNum;
        }

        public void setOriginalNum(long originalNum) {
            this.originalNum = originalNum;
        }
    }


}
