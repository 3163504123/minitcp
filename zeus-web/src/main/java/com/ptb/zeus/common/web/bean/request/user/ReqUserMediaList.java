package com.ptb.zeus.common.web.bean.request.user;

import com.ptb.zeus.common.web.bean.request.base.ReqStartEnd;

import org.hibernate.validator.constraints.Range;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by eric on 16/5/23.
 */
public class ReqUserMediaList extends ReqStartEnd {

    @Range(min = 1, max = 2, message = "不支持此类型的平台")
    private int type = 1;

    @NotNull(message = "标签列表不能为空")
    private List<String> tagList;

    @NotNull(message = "过滤条件不能为空")
    @Valid
    private RangeCondition num;

    @Range(min = 0, max = 4, message = "排序维度标识应在0-4之间")
    private int sortBy;

    public ReqUserMediaList() {
        this.num = new RangeCondition();
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<String> getTagList() {
        return tagList;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    public RangeCondition getNum() {
        return num;
    }

    public void setNum(RangeCondition num) {
        this.num = num;
    }

    public int getSortBy() {
        return sortBy;
    }

    public void setSortBy(int sortBy) {

        this.sortBy = sortBy;
    }


    public static class RangeCondition {
        @Range(min = 0, message = "阅读数开始值应大于等于0")
        private long readStart = 0;

        @Range(min = 0, message = "转发数开始值应大于等于0")
        private long spreadStart = 0;
        @Range(min = 0, message = "评论数开始值应大于等于0")
        private long commentStart = 0;
        @Range(min = 0, message = "点赞数开始值应大于等于0")
        private long zanStart = 0;
        @Range(min = 0, message = "粉丝数开始值应大于等于0")
        private long fanStart = 0;
        @Range(min = 0, message = "转发数结束值应大于等于0")
        private long spreadEnd = Integer.MAX_VALUE;
        @Range(min = 0, message = "评论数结束值应大于等于0")
        private long commentEnd = Integer.MAX_VALUE;
        @Range(min = 0, message = "点赞数结束值应大于等于0")
        private long zanEnd = Integer.MAX_VALUE;
        @Range(min = 0, message = "粉丝数结束值应大于等于0")
        private long fanEnd = Integer.MAX_VALUE;
        @Range(min = 0, message = "阅读数结束值应大于等于0")
        private long readEnd = Integer.MAX_VALUE;

        public long getReadStart() {
            return readStart;
        }

        public void setReadStart(long readStart) {
            this.readStart = readStart;
        }

        public long getSpreadStart() {
            return spreadStart;
        }

        public void setSpreadStart(long spreadStart) {
            this.spreadStart = spreadStart;
        }

        public long getCommentStart() {
            return commentStart;
        }

        public void setCommentStart(long commentStart) {
            this.commentStart = commentStart;
        }

        public long getZanStart() {
            return zanStart;
        }

        public void setZanStart(long zanStart) {
            this.zanStart = zanStart;
        }

        public long getSpreadEnd() {
            return spreadEnd;
        }

        public void setSpreadEnd(long spreadEnd) {
            this.spreadEnd = spreadEnd;
        }

        public long getCommentEnd() {
            return commentEnd;
        }

        public void setCommentEnd(long commentEnd) {
            this.commentEnd = commentEnd;
        }

        public long getZanEnd() {
            return zanEnd;
        }

        public void setZanEnd(long zanEnd) {
            this.zanEnd = zanEnd;
        }

        public long getReadEnd() {
            return readEnd;
        }

        public void setReadEnd(long readEnd) {
            this.readEnd = readEnd;
        }

        public long getFanEnd() {
            return fanEnd;
        }

        public void setFanEnd(long fanEnd) {
            this.fanEnd = fanEnd;
        }

        public long getFanStart() {
            return fanStart;
        }

        public void setFanStart(long fanStart) {
            this.fanStart = fanStart;
        }
    }

}
