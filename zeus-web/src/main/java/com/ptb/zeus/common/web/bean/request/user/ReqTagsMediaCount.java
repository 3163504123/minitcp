package com.ptb.zeus.common.web.bean.request.user;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import java.util.List;

/**
 * Created by eric on 16/5/29.
 */
public class ReqTagsMediaCount {

    @NotEmpty(message = "标签不能为空")
    List<String> tags;

    @Range(min = 1,max = 2,message = "平台类型不正确")
    int type;

    public ReqTagsMediaCount(List<String> tags, int type) {
        this.tags = tags;
        this.type = type;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ReqTagsMediaCount() {
    }
}
