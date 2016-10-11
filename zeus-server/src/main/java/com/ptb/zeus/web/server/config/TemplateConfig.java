package com.ptb.zeus.web.server.config;

import org.springframework.context.annotation.Configuration;

/**
 * Created by eric on 16/10/9.
 */
@Configuration
public class TemplateConfig {

/*	@Bean
	// 现在这个class不再是layout的，所以要把对应的 ViewResolver改成对应的，由于没有
	// toolboxviewresolver，就用父类 veclotiyviewresoler
	public VelocityViewResolver velocityViewResolver(VelocityProperties properties) {
		VelocityViewResolver viewResolver = new VelocityViewResolver();
		viewResolver.setViewClass(VelocityLayoutToolboxView.class);
		properties.applyToViewResolver(viewResolver);// 设置默认属性，比如前缀和后缀
		return viewResolver;
	}*/


}
