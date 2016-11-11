package com.ptb.zeus.web.server.controller.user;

import com.baomidou.framework.service.ISuperService;
import com.ptb.zeus.common.core.model.user.TbUser;
import com.ptb.zeus.service.user.ITbUserService;
import com.ptb.zeus.web.server.controller.BaseRestCRUDController;
import com.ptb.zeus.web.server.request.PhoneRegisterRequest;
import com.ptb.zeus.web.server.service.CacheService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 * Created by eric on 16/8/19.
 */
@RequestMapping("api/u")
@RestController
public class AUserCRUDController extends BaseRestCRUDController<TbUser> {
	@Resource(name = "myAuthenticationManagerBean")
	AuthenticationManager authenticationManager;

	@Resource
	ITbUserService iTbUserService;

	@Autowired
	CacheService cacheService;


	@RequestMapping("reg")
	public String register(PhoneRegisterRequest phoneRegisterRequest,HttpSession httpSession) {
		String sessionPhone = httpSession.getAttribute("regPhone").toString();
		String sessionVcode = httpSession.getAttribute("regVcode").toString();


		String password = tbUser.getPassword();

		if(httpSession.getAttribute("regVcode").equals(vcode)) {

		}
		return "";
	}

	@RequestMapping("login")
	@ResponseBody
	public String login(SecurityContextHolderAwareRequestWrapper request) {
		try {
			if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
				request.login("1", "3163504123");
			} else {
				return String.format("已登陆的用户");
			}
		} catch (ServletException e) {
			e.printStackTrace();
		}
		return String.format("登陆成功");
	}

	@RequestMapping("logout")
	@ResponseBody
	public String logout(SecurityContextHolderAwareRequestWrapper request) {
		try {
			request.logout();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		return String.format("logout");
	}

	@Override
	protected ISuperService<TbUser> getBasicService() {
		return iTbUserService;
	}
}
