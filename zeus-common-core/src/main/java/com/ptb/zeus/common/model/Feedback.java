package com.ptb.zeus.common.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;

import javax.persistence.Table;

@Table(name = "feedback")
public class Feedback extends BaseEntity{

    private String contact;

    private String content;

    private Date addTime;

    private String type;

    public Feedback(String contact, String content, String type) {
        this.contact = contact;
        this.content = content;
        if(StringUtils.isBlank(type))
            this.type="default";
        else
            this.type = type;
        this.addTime = new Date();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}