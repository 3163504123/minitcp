package com.ptb.zeus.web.basic.config.security;

import com.ptb.zeus.web.basic.config.security.entrypoint.MyAuthenticationEntryPoint;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by eric on 16/8/28.
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	MyHttpSessionSecurityContextRepository myHttpSessionSecurityContextRepository;

	@Override
	protected void configure(
			HttpSecurity http) throws Exception {
		//需要校验权限的部分

/*		http.authorizeRequests().anyRequest().authenticated();*/

		http.authorizeRequests().
				antMatchers("/*"
						,"/api/mUser/logout","/","/static*").
				permitAll().anyRequest().permitAll();

		http.httpBasic().authenticationEntryPoint(new MyAuthenticationEntryPoint());
		http.csrf().disable();
		http.headers().frameOptions().sameOrigin();

		http.securityContext().securityContextRepository(myHttpSessionSecurityContextRepository);
		//退出的相关配置
		http.logout().logoutSuccessHandler((httpServletRequest, httpServletResponse, authentication) -> {
			System.out.println("i'm getUserByIdentiy out");
			httpServletResponse.getWriter().write("i'm getUserByIdentiy out");
		}).logoutUrl("/u/logout").invalidateHttpSession(true);
	}

	@Override
	protected void configure(
			AuthenticationManagerBuilder auth) throws Exception {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(this.passwordEncoder());
		auth.authenticationProvider(daoAuthenticationProvider);
	}

	@Bean(name = "myAuthenticationManagerBean")
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder passwordEncoder = new PasswordEncoder() {
			@Override
			public String encode(CharSequence rawPassword) {
				return DigestUtils.md5Hex(String.valueOf(rawPassword));
			}

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return encode(rawPassword).equals(encodedPassword);
			}
		};

		return passwordEncoder;
	}

}