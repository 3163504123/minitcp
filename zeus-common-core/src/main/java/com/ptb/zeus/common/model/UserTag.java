package com.ptb.zeus.common.model;

import java.util.Date;

import javax.persistence.Table;

@Table(name = "user_tag")
public class UserTag extends BaseEntity {

    private Integer uid;

    private String tag;

    private Date addTime = new Date();

    public UserTag() {
    }

    public UserTag(Integer uid, String tag) {
        this.uid = uid;
        this.tag = tag;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}