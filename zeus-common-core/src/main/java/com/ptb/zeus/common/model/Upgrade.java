package com.ptb.zeus.common.model;

import java.util.Date;

import javax.persistence.Table;


@Table(name = "upgrade")
public class Upgrade extends BaseEntity{

    private String title;

    private String des;

    private String version;

    private Integer isForce;

    private String url;

    private Integer plat;

    private Date addTime;

    private Long fileSize;
    
    public Upgrade(){
    	
    }

    public Upgrade(String title, String des, String version, Integer isForce, String url, Integer plat, Date addTime, Long fileSize) {
        this.title = title;
        this.des = des;
        this.version = version;
        this.isForce = isForce;
        this.url = url;
        this.plat = plat;
        this.addTime = addTime;
        this.fileSize = fileSize;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public Integer getIsForce() {
        return isForce;
    }

    public void setIsForce(Integer isForce) {
        this.isForce = isForce;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getPlat() {
        return plat;
    }

    public void setPlat(Integer plat) {
        this.plat = plat;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {

        this.addTime = addTime;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }
}