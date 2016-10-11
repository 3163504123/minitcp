package com.ptb.zeus.web.server.config.security.entrypoint;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
		@Override
		public void commence(
				HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
				AuthenticationException e) throws IOException, ServletException {
					httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
			httpServletResponse.getWriter().write("no auth");
		}
}