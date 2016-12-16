package com.ptb.zeus.web.basic.controller;


import com.ptb.zeus.exception.UserException;
import com.ptb.zeus.web.exception.UserWebExpection;
import com.ptb.zeus.web.response.BaseResponse;

import org.apache.catalina.connector.ClientAbortException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Created by eric on 16/5/20.
 */
public class BaseRestController extends BaseController {
	static Logger logger = LoggerFactory.getLogger(BaseRestController.class);

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Object exp(Exception ex) {
		if (ex instanceof HttpMessageNotReadableException) {
			logger.warn(ex.getMessage(), ex);
			return BaseResponse.NormalResponse;
		}

		if (ex instanceof ClientAbortException) {
			return BaseResponse.NormalResponse;
		}

		if (ex instanceof UserWebExpection) {
			UserWebExpection zeusException = (UserWebExpection) ex;
			return zeusException.getResponse();
		} else if (ex instanceof UserException) {
			UserException ex1 = (UserException) ex;
			BaseResponse<Object> objectBaseResponse = new BaseResponse<>();
			objectBaseResponse.setCode(ex1.getErrorCode());
			objectBaseResponse.setMessage(ex1.getMessage());
			return objectBaseResponse;
		} else {
			logger.error(ex.getMessage(), ex);
			return new BaseResponse<>(UserException.InerError.getErrorCode(), UserException.InerError.getErrorMessage(), null);
		}
	}

	/*检查注解参数*/
	public void checkParams(BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {
			throw new UserWebExpection(bindingResult.getFieldError().getDefaultMessage(), UserException.ArgError.getErrorCode());
		}
	}

	protected  HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	protected HttpServletResponse getResponse() {
		return ((ServletWebRequest)RequestContextHolder.getRequestAttributes()).getResponse();
	}

	protected  HttpSession getSession() {
		return getRequest().getSession();
	}

}
