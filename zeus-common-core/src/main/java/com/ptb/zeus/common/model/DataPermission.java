package com.ptb.zeus.common.model;


import javax.persistence.Table;

@Table(name = "data_permission")
public class DataPermission extends BaseEntity{

    private boolean sTag;

    private boolean scName;

    private boolean scEmail;

    private boolean scPhone;

    private boolean scPrice;

    private Long userId;

    public DataPermission(){}

    public DataPermission(long userId){
        this.userId = userId;
    }

    public Boolean getsTag() {
        return sTag;
    }

    public void setsTag(Boolean sTag) {
        this.sTag = sTag;
    }

    public Boolean getScName() {
        return scName;
    }

    public void setScName(Boolean scName) {
        this.scName = scName;
    }

    public Boolean getScEmail() {
        return scEmail;
    }

    public void setScEmail(Boolean scEmail) {
        this.scEmail = scEmail;
    }

    public Boolean getScPhone() {
        return scPhone;
    }

    public void setScPhone(Boolean scPhone) {
        this.scPhone = scPhone;
    }

    public Boolean getScPrice() {
        return scPrice;
    }

    public void setScPrice(Boolean scPrice) {
        this.scPrice = scPrice;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}