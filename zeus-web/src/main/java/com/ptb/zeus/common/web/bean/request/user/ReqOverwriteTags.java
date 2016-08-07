package com.ptb.zeus.common.web.bean.request.user;

import com.ptb.zeus.common.web.bean.request.base.ReqPmidType;

import java.util.List;

import javax.validation.constraints.NotNull;

public class ReqOverwriteTags extends ReqPmidType {
    @NotNull(message = "标签集不能为空")
    private List<String> tags;

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tag) {
        this.tags = tag;
    }
}
