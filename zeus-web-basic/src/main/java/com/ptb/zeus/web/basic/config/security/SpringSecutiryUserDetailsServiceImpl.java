package com.ptb.zeus.web.basic.config.security;

import com.ptb.zeus.common.core.model.user.TbRole;
import com.ptb.zeus.common.core.model.user.TbUser;
import com.ptb.zeus.service.user.ITbPermissionService;
import com.ptb.zeus.service.user.ITbRoleService;
import com.ptb.zeus.service.user.ITbUserService;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

/**
 * Created by eric on 16/10/8.
 */
@Component
public class SpringSecutiryUserDetailsServiceImpl implements UserDetailsService {
	@Resource
	ITbUserService iTbUserService;

	@Resource
	ITbRoleService iTbRoleService;

	@Resource
	ITbPermissionService iTbPermissionService;

	@Override
	public UserDetails loadUserByUsername(
			String s) throws UsernameNotFoundException {
		List<TbUser> tbUsers = iTbUserService.getUserByIdentiy(s);
		return getUserDetail(tbUsers.get(0));
	}

	public UserDetails loadUserByID(Integer id) {
		TbUser tbUser = iTbUserService.selectById(Long.valueOf(id));
		return getUserDetail(tbUser);
	}

	public Authentication getAuth(Integer id) {
		UserDetails userDetails = loadUserByID(id);
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
		token.setDetails(userDetails);
		return token;
	}

	private UserDetails getUserDetail(TbUser tbUser) {
		if (tbUser == null) {
			throw new UsernameNotFoundException("不存在的用户");
		}

		boolean isEnable = tbUser.getState() == 1; //是否是有效有用户

		//用户的角色
		List<TbRole> tbRoles = iTbRoleService.selectByUID(tbUser.getId());
		List<SimpleGrantedAuthority> roles = null;
		if (tbRoles == null || tbRoles.size() == 0) {
			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_ANONYMOUS"));
		} else {
			roles = tbRoles.stream().map((tbRole -> (new SimpleGrantedAuthority(tbRole.getRoleSign())))).collect(Collectors.toList());
		}

		User user = new User(tbUser.getUname(), tbUser.getPassword(), isEnable, true, true, true, roles);
		return user;
	}


}
