package com.ptb.zeus.common.model;

import java.util.Date;
import java.util.List;

/**
 * Created by MyThinkpad on 2016/5/31.
 */
public class MediaTagTime extends BaseEntity{
    private String pMid;

    private Long uid;

    private Date addTime;

    private String name;

    private String phone;

    private String email;

    private int type;

    private String price;

    private List<UserMediaTag> userMediaTags;

    public String getpMid() {
        return pMid;
    }

    public void setpMid(String pMid) {
        this.pMid = pMid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<UserMediaTag> getUserMediaTags() {
        return userMediaTags;
    }

    public void setUserMediaTags(List<UserMediaTag> userMediaTags) {
        this.userMediaTags = userMediaTags;
    }
}
