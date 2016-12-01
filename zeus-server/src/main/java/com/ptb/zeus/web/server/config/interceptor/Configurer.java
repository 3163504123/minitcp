package com.ptb.zeus.web.server.config.interceptor;

import com.ptb.zeus.web.server.interceptor.MyInterceptorTest;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/12/1
 * @version 1.0.0
 * @description 类的功能
 */
@Configuration
public class Configurer extends WebMvcConfigurerAdapter {
	@Override
	public void addInterceptors(
			InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterceptorTest()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}
}
