package com.ptb.zeus.common.web.bean.request.user;

/**
 * Created by MyThinkpad on 2016/7/19.
 */
public class ReqSharePermission {
    private int remark;
    private int price;
    private String url;

    public ReqSharePermission(){
        this.remark = -1;
        this.price = -1;
    }

    public ReqSharePermission(int remark, int price){
        this.remark = remark;
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getRemark() {
        return remark;
    }

    public void setRemark(int remark) {
        this.remark = remark;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}