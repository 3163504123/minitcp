package com.ptb.zeus.web.server.config.security;

import com.ptb.zeus.common.core.model.TbUser;
import com.ptb.zeus.service.user.ITbUserService;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import javax.annotation.Resource;

/**
 * Created by eric on 16/10/8.
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	@Resource
	ITbUserService iTbUserService;

	@Override
	public UserDetails loadUserByUsername(
			String s) throws UsernameNotFoundException {
		TbUser tbUser = new TbUser();
		tbUser.setUName(s);
		TbUser queryedUser = iTbUserService.selectOne(tbUser);
		boolean isEnable= queryedUser.getState() == 1;

		User user = new User(queryedUser.getUName()
				, queryedUser.getPassword()
				, isEnable,true,true,true
				, Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
		return  user;
	}
}
