package com.ptb.zeus.common.web.bean.response;

public class RepHomePage {

    private RepHomeWxData weixin;
    private RepHomeWbData weibo;

    public RepHomeWxData getWeixin() {
        return weixin;
    }

    public void setWeixin(RepHomeWxData weixin) {
        this.weixin = weixin;
    }

    public RepHomeWbData getWeibo() {
        return weibo;
    }

    public void setWeibo(RepHomeWbData weibo) {
        this.weibo = weibo;
    }

}
