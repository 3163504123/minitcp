package com.ptb.zeus.common.model;

import java.util.Date;

import javax.persistence.Table;

@Table(name = "user_media_tag")
public class UserMediaTag extends BaseEntity {
    private Long id;

    private String tag;

    private Date addTime;

    private Long userMediaId;
    
    public UserMediaTag(){
    	
    }

    public UserMediaTag(long user_media_id, String t) {
        this.addTime = new Date();
        this.userMediaId = user_media_id;
        this.tag = t;
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

    public Long getUserMediaId() {
        return userMediaId;
    }

    public void setUserMediaId(Long userMediaId) {
        this.userMediaId = userMediaId;
    }
}