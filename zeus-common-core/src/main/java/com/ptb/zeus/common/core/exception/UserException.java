package com.ptb.zeus.common.core.exception;

public class UserException extends RuntimeException {

	public static final UserException ArgError = new UserException("参数错误", 1000);
	public static final UserException InerError = new UserException("系统内部错误", 500);

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
