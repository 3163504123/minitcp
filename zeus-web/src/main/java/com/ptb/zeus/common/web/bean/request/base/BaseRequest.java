package com.ptb.zeus.common.web.bean.request.base;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 公共请求参数
 *
 * @author lenovo
 */
public class BaseRequest<T> {
    @NotNull(message = "设备ID参数错误", groups = CheckGroup1.class)
    private String deviceType;
    private String channelId;
    private String version;
    private String deviceNo;
    private String resolution;
    private String clientType;
    private String token;
    @Valid
    private T data;
    public BaseRequest(T t) {
        this.data = t;
        this.channelId = "10000";
        this.version = "1.0.0";
        this.deviceType = "android";
        this.deviceNo = "6546465465465";
        this.resolution = "720*1280";
        this.clientType = "ptb";
    }


    public BaseRequest() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public interface CheckGroup1 {

    }


}
