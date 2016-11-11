package com.ptb.zeus.web.exception;


import com.ptb.zeus.web.response.BaseResponse;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/11
 * @version 1.0.0
 * @description 类的功能
 */
public class UserWebExpection extends RuntimeException{


	public static final UserWebExpection ArgError = new UserWebExpection("参数错误", 1000);
	public static final UserWebExpection InerError = new UserWebExpection("系统内部错误", 500);

	int errorCode;
	String errorMessage;
	BaseResponse response;

	public UserWebExpection(String message, int errorCode) {
		super(message);
		this.errorMessage = message;
		this.errorCode = errorCode;
		this.response = new BaseResponse(errorCode, message, null);
	}

	public BaseResponse getResponse() {
		return response;
	}

	public UserWebExpection setResponse(BaseResponse response) {
		this.response = response;
		return this;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public UserWebExpection setErrorCode(int errorCode) {
		this.errorCode = errorCode;
		return this;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public UserWebExpection setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}

}
