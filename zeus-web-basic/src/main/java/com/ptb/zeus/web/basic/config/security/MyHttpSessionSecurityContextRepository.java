package com.ptb.zeus.web.basic.config.security;


import com.ptb.zeus.common.core.utils.security.security.TokenUtils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/12/11
 * @version 1.0.0
 * @description 类的功能
 */
@Component
public class MyHttpSessionSecurityContextRepository extends HttpSessionSecurityContextRepository {

	@Autowired
	SpringSecutiryUserDetailsServiceImpl springSecutiryUserDetailsService;

	public MyHttpSessionSecurityContextRepository() {
		super();
	}

	@Override
	public SecurityContext loadContext(
			HttpRequestResponseHolder requestResponseHolder) {
		String uuid = requestResponseHolder.getRequest().getHeader("uuid");
		SecurityContext securityContext = new SecurityContextImpl();
		if (uuid != null) {
			Authentication auth = springSecutiryUserDetailsService.getAuth(Math.toIntExact(TokenUtils.decode(uuid).getUid()));
			securityContext.setAuthentication(auth);
			return securityContext;
		}
		return super.loadContext(requestResponseHolder);
	}

	@Override
	public void saveContext(
			SecurityContext context, HttpServletRequest request, HttpServletResponse response) {
		super.saveContext(context, request, response);
	}

	@Override
	public boolean containsContext(HttpServletRequest request) {

		String uuid = request.getHeader("uuid");
		if (StringUtils.isNoneBlank(uuid)) {
			return true;
		}
		return super.containsContext(request);
	}
}
