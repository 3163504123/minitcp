package com.ptb.zeus.common.core.exception;

public class UserException extends RuntimeException {

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
