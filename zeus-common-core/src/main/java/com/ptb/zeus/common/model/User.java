package com.ptb.zeus.common.model;


import com.ptb.zeus.common.utils.Constant;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;

import javax.persistence.Table;

@Table(name = "user")
public class User extends BaseEntity {
    private String username;

    private String password;

    private String state;

    private Date createTime;

    private String phone;

    private String email;

    private String companyaddress;

    private String portraits;

    public User(Long userId) {
        this.setId(userId);
    }

    public User(String username, String password, String state, Date createTime, String phone, String email, String companyaddress, String portraits) {
        this.username = username;
        this.password = password;
        this.state = state;
        this.createTime = createTime;
        this.phone = phone;
        this.email = email;
        this.companyaddress = companyaddress;
        this.portraits = portraits;
        super.setId(1L);
    }

    public enum E_STATE {
        active,
        inactive;
    }

    public static User defaultUser = new User("未登陆用户", "******", "******", new Date(), "******", "*******", "******", "******");

    public static User NewPhoneUser(String username, String email, String password) {
        User user = new User(email, password);
        user.setState(E_STATE.active.name());
        user.setUsername(username);
        user.createTime = new Date();
        return user;
    }

    public static User NewEmailUser(String username, String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setState(E_STATE.inactive.name());
        user.setUsername(username);
        user.createTime = new Date();
        return user;
    }


    public User() {
    }

    public User(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public String getCompanyaddress() {
        return companyaddress;
    }

    public void setCompanyaddress(String companyaddress) {
        this.companyaddress = companyaddress == null ? null : companyaddress.trim();
    }

    public String getPortraits() {
        return portraits;
    }

    public String getPortraitsUrl(){
        if (StringUtils.isBlank(portraits)) {
            return Constant.USER_CDN_DEFAULT_IMG;
        }else{
            return Constant.USER_CDN_URL + portraits;
        }
    }

    public void setPortraits(String portraits) {
        this.portraits = portraits == null ? null : portraits.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", state='" + state + '\'' +
                ", createTime=" + createTime +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", companyaddress='" + companyaddress + '\'' +
                ", portraits='" + portraits + '\'' +
                '}';
    }
}