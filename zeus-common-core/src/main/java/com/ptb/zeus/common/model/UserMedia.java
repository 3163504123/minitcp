package com.ptb.zeus.common.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "user_media")
public class UserMedia extends BaseEntity {

    @Column(name = "p_mid")
    private String pMid;

    private Long uid;

    private Date addTime;

    private String name;

    private String phone;

    private String email;

    private int type;
    private String price;

    public void setType(int type) {
        this.type = type;
    }

    public UserMedia(Long uid, String pMid, int type) {
        this.uid = uid;
        this.pMid = pMid;
        this.type = type;
        this.addTime = new Date();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public UserMedia() {
        this.addTime = new Date();
    }

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
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}