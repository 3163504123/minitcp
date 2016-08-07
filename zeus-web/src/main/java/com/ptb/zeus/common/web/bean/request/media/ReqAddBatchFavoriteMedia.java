package com.ptb.zeus.common.web.bean.request.media;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import java.util.List;

/**
 * Created by eric on 16/6/3.
 */
public class ReqAddBatchFavoriteMedia {
    @NotEmpty(message = "媒体ID不能为空")
    List<String> pMids;
    @Range(min = 1,max = 2,message = "平台类型不正确")
    int type;

    String key;

    public ReqAddBatchFavoriteMedia(List<String> strings, int type) {
        this.pMids = strings;
        this.type = type;
    }

    public ReqAddBatchFavoriteMedia() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getpMids() {
        return pMids;
    }

    public void setpMids(List<String> pMids) {
        this.pMids = pMids;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
