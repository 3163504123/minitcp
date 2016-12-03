package com.ptb.zeus.exception;

public class UserException extends RuntimeException {

	public static final UserException ArgError = new UserException("参数错误", 10000);
	public static final UserException InerError = new UserException("系统内部错误",10500);
	public static final UserException NoExistVaildCodeError = new UserException("验证码失效，请重新发送", 10600);
	public static final UserException UsernameOrPhoneExist = new UserException("手机号或用户名已注册", 10601);
	public static final UserException ErrorImgVcode = new UserException("错误的图片验证码", 11000);
	public static final UserException NoExistUserError = new UserException("用户不存在", 10602);
	public static final UserException NoServiceAuthError = new UserException("无效的KEY或权限已到期",10700);
	public static final UserException LoginUndefineError = new UserException("登陆失败请重试",10700);
	public static final UserException SwitchingIPError = new UserException("正在切换IP，请稍后", 10602);
	int errorCode;
	String errorMessage;

	public UserException(String message, int errorCode) {
		super(message);
		this.errorMessage = message;
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
