package com.ptb.zeus.web.server.config.security;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ptb.zeus.common.core.model.user.TbUser;
import com.ptb.zeus.service.user.ITbUserService;
import com.ptb.zeus.web.exception.UserWebExpection;

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
		List<TbUser> tbUsers = iTbUserService.selectList(new EntityWrapper<TbUser>().where("uname = {0}", s).or("phone = {0}", s));

		if (tbUsers == null || tbUsers.size() == 0) {
			throw new UsernameNotFoundException("不存在的用户名", UserWebExpection.NoExistUserError);
		}
		TbUser tbUser = tbUsers.get(0);
		boolean isEnable = tbUser.getState() == 1;

		User user = new User(tbUser.getUname(), tbUser.getPassword(), isEnable, true, true, true, Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
		return user;
	}
}
