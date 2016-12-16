package com.ptb.zeus.web.basic.controller;


import com.ptb.zeus.common.core.utils.security.security.Token;
import com.ptb.zeus.exception.UserException;
import com.ptb.zeus.web.exception.UserWebExpection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Created by eric on 16/5/20.
 */
public class BaseController {
	static Logger logger = LoggerFactory.getLogger(BaseController.class);

	/*检查注解参数*/
	public void checkParams(BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {
			throw new UserWebExpection(bindingResult.getFieldError().getDefaultMessage(), UserException.ArgError.getErrorCode());
		}
	}


	/**
	 * Gets request.
	 *
	 * @return the request
	 */
	protected HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	/**
	 * Gets response.
	 *
	 * @return the response
	 */
	protected HttpServletResponse getResponse() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
	}

	/**
	 * Gets session.
	 *
	 * @return the session
	 */
	protected HttpSession getSession() {
		return getRequest().getSession();
	}

	protected String getServletPath() {
		return getRequest().getServletPath();
	}

	protected String getBasePath() {
		return (String) getRequest().getAttribute("basePath");
	}

	protected Token getToken() {
		return (Token) getRequest().getAttribute("token");
	}
}
