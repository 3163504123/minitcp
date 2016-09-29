package com.ptb.zeus.web.server.config;

import com.ptb.zeus.service.user.ITbUserService;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;

import javax.annotation.Resource;

/**
 * Created by eric on 16/8/28.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Resource
	ITbUserService iTbUserService;

	@Override
	protected void configure(
			HttpSecurity http) throws Exception {
	}

	@Override
	protected void configure(
			AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(new UserDetailsService() {
			SimpleGrantedAuthority auth2 = new SimpleGrantedAuthority("ROLE_ADMIN");

			@Override
			public UserDetails loadUserByUsername(
					String s) throws UsernameNotFoundException {
				System.out.println("ddd");
				return new User("eric.zhang", "eric", Arrays.asList(auth2));
			}
		});

	}
}
