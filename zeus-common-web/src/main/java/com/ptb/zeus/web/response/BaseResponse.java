package com.ptb.zeus.web.response;


/**
 * 响应结果返回通用bean
 *
 * @param <T>
 * @author lenovo
 */
public class BaseResponse<T> {

    private int code;
    private String message;
    private long systemDate;
    private T data;
    private String msg;
    private boolean success;

    public final static BaseResponse NormalResponse = new BaseResponse(0, "操作成功", "");
    public BaseResponse(int code, String message, T data) {
        this.code = code;
        this.success = code == 0 ;
        this.msg = msg;
        this.message = message;
        this.data = data;
        this.systemDate = System.currentTimeMillis();
    }


    public BaseResponse() {
    }


    public BaseResponse(T data) {

        this(0,"操作成功",data);
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public BaseResponse<T> setMessage(String message) {
        this.message = message;
		return this;
    }

    public long getSystemDate() {
        return System.currentTimeMillis();
    }

    public void setSystemDate(long systemDate) {
        this.systemDate = systemDate;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
