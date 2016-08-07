package com.ptb.zeus.common.web.bean.response;

/**
 * Created by eric on 16/5/30.
 */
public class RepUserInfo {
    private String username;
    private String phone;
    private String email;
    private String headImg;
    private String companyAddress;
    private long userId;

    public RepUserInfo(String username, String phone, String email, String portraits, String companyaddress, long id) {
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.headImg = portraits;
        this.companyAddress = companyaddress;
        this.userId = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
