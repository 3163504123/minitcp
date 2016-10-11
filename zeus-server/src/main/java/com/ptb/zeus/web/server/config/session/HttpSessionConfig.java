package com.ptb.zeus.web.server.config.session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

/**
 * Created by eric on 16/8/28.
 */
/*@EnableRedisHttpSession*/
@Configuration
@EnableSpringHttpSession
public class HttpSessionConfig {

	/*	@Bean
		public JedisConnectionFactory connectionFactory() {
			return new JedisConnectionFactory(); // <2>
		}*/

		@Bean
		public HttpSessionStrategy httpSessionStrategy() {
			return new CookieHttpSessionStrategy(); // <3>
		}
}
