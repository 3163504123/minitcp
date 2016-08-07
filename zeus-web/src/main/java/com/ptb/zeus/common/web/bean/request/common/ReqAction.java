package com.ptb.zeus.common.web.bean.request.common;

/**
 * Created by Administrator on 2016/7/26 0026.
 */
public class ReqAction<T> {
    int action;
    T body;

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
