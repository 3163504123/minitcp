package com.ptb.zeus.common.web.bean.request.common;

/**
 * 公共请求参数
 *
 * @author lenovo
 */
public class RepActionUrl<T> {
    String url;
    T body;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
