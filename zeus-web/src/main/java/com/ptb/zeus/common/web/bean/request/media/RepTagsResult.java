package com.ptb.zeus.common.web.bean.request.media;


import com.ptb.zeus.common.web.bean.response.RepUserMediaTags;

import java.util.List;

/**
 * Created by eric on 16/6/1.
 */
public class RepTagsResult {
    List<RepUserMediaTags> list;
    int noTagNum;

    public RepTagsResult(int i, List<RepUserMediaTags> tags) {
        this.noTagNum = i;
        this.list = tags;
    }

    public List<RepUserMediaTags> getList() {
        return list;
    }

    public void setList(List<RepUserMediaTags> list) {
        this.list = list;
    }

    public int getNoTagNum() {
        return noTagNum;
    }

    public void setNoTagNum(int noTagNum) {
        this.noTagNum = noTagNum;
    }
}
