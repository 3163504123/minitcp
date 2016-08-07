package com.ptb.zeus.common.web.bean.request.common;

import com.ptb.zeus.common.web.bean.request.base.BaseRequest;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Administrator on 2016/7/27 0027.
 */
public class ReqActionUrl<T> {
    @NotBlank(message = "url不能为空")
    String url;
    String method;
    BaseRequest<T> body;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public BaseRequest<T> getBody() {
        return body;
    }

    public void setBody(BaseRequest<T> body) {
        this.body = body;
    }
}
