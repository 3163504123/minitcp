package com.ptb.zeus.web.controller;


import com.ptb.zeus.web.exception.UserWebExpection;
import com.ptb.zeus.web.response.BaseResponse;

import org.apache.catalina.connector.ClientAbortException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by eric on 16/5/20.
 */
public class BaseController {
	static Logger logger = LoggerFactory.getLogger(BaseController.class);

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Object exp(Exception ex) {
		if (ex instanceof HttpMessageNotReadableException) {
			logger.warn(ex.getMessage(), ex);
			UserWebExpection.ArgError.getResponse();
		}

		if (ex instanceof ClientAbortException) {
			return BaseResponse.NormalResponse;
		}
		if (ex instanceof UserWebExpection) {
			UserWebExpection zeusException = (UserWebExpection) ex;
			return zeusException.getResponse();
		} else {
			logger.error(ex.getMessage(), ex);
			return UserWebExpection.InerError.getResponse().setMessage(ex.getMessage());
		}
	}

	public void checkParams(BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {
			throw new UserWebExpection(bindingResult.getFieldError().getDefaultMessage(), UserWebExpection.ArgError.getErrorCode());
		}
	}
}
