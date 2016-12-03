package com.ptb.zeus.web.server.config.security;

import com.ptb.zeus.common.core.model.user.TbUser;
import com.ptb.zeus.service.user.ITbUserService;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

/**
 * Created by eric on 16/10/8.
 */
@Component
public class SpringSecutiryUserDetailsServiceImpl implements UserDetailsService {
	@Resource
	ITbUserService iTbUserService;

	@Override
	public UserDetails loadUserByUsername(
			String s) throws UsernameNotFoundException {
		List<TbUser> tbUsers = iTbUserService.getUserByIdentiy(s);
		if (tbUsers == null || tbUsers.size() == 0) {
			throw new UsernameNotFoundException("不存在的用户名");
		}
		TbUser tbUser = tbUsers.get(0);
		boolean isEnable = tbUser.getState() == 1;

		User user = new User(tbUser.getUname(), tbUser.getPassword(), isEnable, true, true, true, Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
		return user;
	}
}
