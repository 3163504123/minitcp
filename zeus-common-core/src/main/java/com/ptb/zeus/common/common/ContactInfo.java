package com.ptb.zeus.common.common;

import javax.validation.constraints.NotNull;

/**
 * Created by MyThinkpad on 2016/6/28.
 */

public class ContactInfo{

    @NotNull(message = "联系人姓名不能为空")
    private String name;
    @NotNull(message = "联系人电话不能为空")
    private String phone;
    @NotNull(message = "联系人eamil不能为空")
    private String email;
    @NotNull(message = "联系人报价不能为空")
    private String price;

    public ContactInfo(String name, String phone, String email, String price){
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.price = price;
    }

    public ContactInfo(){}

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
