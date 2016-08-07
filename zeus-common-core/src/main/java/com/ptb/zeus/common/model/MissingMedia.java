package com.ptb.zeus.common.model;

import java.util.Date;

public class MissingMedia extends BaseEntity{

    private Integer serachUserid;

    private String serachKey;

    private Date serachTime;

    private Integer type;


    public Integer getSerachUserid() {
        return serachUserid;
    }

    public void setSerachUserid(Integer serachUserid) {
        this.serachUserid = serachUserid;
    }

    public String getSerachKey() {
        return serachKey;
    }

    public void setSerachKey(String serachKey) {
        this.serachKey = serachKey == null ? null : serachKey.trim();
    }

    public Date getSerachTime() {
        return serachTime;
    }

    public void setSerachTime(Date serachTime) {
        this.serachTime = serachTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}