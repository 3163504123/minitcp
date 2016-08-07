package com.ptb.zeus.common.web.bean.request.user;

import com.ptb.zeus.common.web.bean.request.base.ReqStartEnd;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Size;

/**
 * 微信媒体搜索
 *
 * @author lenovo
 */
public class ReqUserMediaSearch extends ReqStartEnd {

    @Size(min = 1, max = 200, message = "搜索符应为1-200字符")
    private String key;

    private boolean gzip;

    @Range(min = 0, max = 2, message = "平台类型不正确")
    private int type;

    public ReqUserMediaSearch(String key, boolean gzip, int type, int start, int end) {
        this.key = key;
        this.gzip = gzip;
        this.type = type;
        this.start = start;
        this.end = end;
    }

    public ReqUserMediaSearch() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isGzip() {
        return gzip;
    }

    public void setGzip(boolean gzip) {
        this.gzip = gzip;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
