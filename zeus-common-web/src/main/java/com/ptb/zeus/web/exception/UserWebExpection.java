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


	public static final UserWebExpection ArgError = new UserWebExpection("参数错误", 10000);
	public static final UserWebExpection InerError = new UserWebExpection("系统内部错误",10500);
	public static final UserWebExpection NoExistVaildCodeError = new UserWebExpection("验证码失效，请重新发送", 10600);
	public static final UserWebExpection UsernameOrPhoneExist = new UserWebExpection("手机号或用户名已注册", 10601);
	public static final UserWebExpection ErrorImgVcode = new UserWebExpection("错误的图片验证码", 11000);
	public static final UserWebExpection NoExistUserError = new UserWebExpection("用户不存在", 10602);

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
