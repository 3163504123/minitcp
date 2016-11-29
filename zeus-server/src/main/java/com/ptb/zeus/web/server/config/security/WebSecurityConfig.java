package com.ptb.zeus.web.server.config.security;

import com.ptb.zeus.common.core.utils.PasswordUtils;
import com.ptb.zeus.web.server.config.security.entrypoint.MyAuthenticationEntryPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by eric on 16/8/28.
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void configure(
			HttpSecurity http) throws Exception {
		//需要校验权限的部分

		http.authorizeRequests().
				antMatchers("/**","/api/user/getUserByIdentiy"
						,"/api/user/logout","/","/static/**").
				permitAll();
/*				.anyRequest().authenticated();*/
		http.httpBasic().authenticationEntryPoint(new MyAuthenticationEntryPoint());
		http.csrf().disable();
		http.headers().frameOptions().sameOrigin();

		//退出的相关配置
		http.logout().logoutSuccessHandler(new LogoutSuccessHandler() {
			@Override
			public void onLogoutSuccess(
					HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
					Authentication authentication) throws IOException, ServletException {
				System.out.println("i'm getUserByIdentiy out");
				httpServletResponse.getWriter().write("i'm getUserByIdentiy out");
			}
		}).logoutUrl("/u/logout").invalidateHttpSession(true);
	}

	@Override
	protected void configure(
			AuthenticationManagerBuilder auth) throws Exception {

		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		auth.authenticationProvider(daoAuthenticationProvider);
	}

	@Bean(name = "myAuthenticationManagerBean")
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

/*	@Bean*/
	public PasswordEncoder passwordEncoder() {
		return PasswordUtils.getPasswordEncoder();
	}

}
