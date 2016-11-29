package com.ptb.zeus.web.server.controller.user;

import com.baomidou.framework.service.ISuperService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.cage.Cage;
import com.github.cage.GCage;
import com.ptb.zeus.common.core.model.user.TbUser;
import com.ptb.zeus.common.core.utils.PasswordUtils;
import com.ptb.zeus.exception.UserException;
import com.ptb.zeus.service.main.IMMobileMsgService;
import com.ptb.zeus.service.user.ITbUserService;
import com.ptb.zeus.web.response.BaseResponse;
import com.ptb.zeus.web.server.controller.mBase.BaseRestCRUDRestController;
import com.ptb.zeus.web.server.request.ChangePasswordReqeust;
import com.ptb.zeus.web.server.request.LoginReqeust;
import com.ptb.zeus.web.server.request.PhoneRegisterRequest;
import com.ptb.zeus.web.server.request.SendRegVCodeRequest;
import com.ptb.zeus.web.utils.SessionConstant;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by eric on 16/8/19.
 */
@RequestMapping("api/u")
@RestController
public class AUserController extends BaseRestCRUDRestController<Integer, TbUser> {
	@Resource(name = "myAuthenticationManagerBean")
	AuthenticationManager authenticationManager;

	@Resource
	ITbUserService iTbUserService;


	@Resource
	IMMobileMsgService iMMobileMsgService;


	String SESSION_IMGCODE = SessionConstant.E_SESSION_IMGCODE.name();
	String SESSION_PHONECODE = SessionConstant.E_SESSION_PHONECODE.name();
	String SESSION_PHONENUMBER = SessionConstant.E_SESSION_PHONENUM.name();


	@RequestMapping("sendVCode")
	public BaseResponse sendVaildCode(
			@Valid SendRegVCodeRequest sendRegVCodeRequest, BindingResult bindingResult,
			HttpSession httpSession) {
		checkParams(bindingResult);
		String regVCode = httpSession.getAttribute(SESSION_IMGCODE).toString();
		if (regVCode.equalsIgnoreCase(sendRegVCodeRequest.getImageVcode())) {
			String vcode = RandomStringUtils.random(6, false, true);
			iMMobileMsgService.sendRegMessage(sendRegVCodeRequest.getPhone(), vcode);
			httpSession.removeAttribute(SESSION_IMGCODE);
			httpSession.setAttribute(SESSION_PHONECODE, vcode);
			return BaseResponse.NormalResponse;
		} else {
			throw UserException.ErrorImgVcode;
		}
	}


	@RequestMapping("getImageVcode")
	public void getImageVcode(HttpServletResponse resp, HttpSession httpSession) {
		Cage cage = new GCage();
		resp.setContentType("image/" + cage.getFormat());
		resp.setHeader("Cache-Control", "no-cache, no-store");
		resp.setHeader("Pragma", "no-cache");
		long time = System.currentTimeMillis();
		resp.setDateHeader("Last-Modified", time);
		resp.setDateHeader("Date", time);
		resp.setDateHeader("Expires", time);
		cage.getTokenGenerator().next();
		String s = RandomStringUtils.randomAlphanumeric(6);
		httpSession.setAttribute(SESSION_IMGCODE, s);
		try {
			cage.draw(s, resp.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				resp.getOutputStream().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	@RequestMapping("changePassword")
	public BaseResponse changePassword(
			@Valid ChangePasswordReqeust changePasswordReqeust, BindingResult bindingResult,
			HttpSession httpSession) {
		checkParams(bindingResult);
		String sessionPhone = httpSession.getAttribute(SESSION_PHONECODE).toString();
		String sessionVcode = httpSession.getAttribute(SESSION_PHONENUMBER).toString();
		if (StringUtils.isBlank(sessionVcode) || StringUtils.isBlank(sessionPhone) || sessionVcode.equals(changePasswordReqeust.getPhoneCode()) || sessionPhone.equals(changePasswordReqeust.getP())) {
			throw UserException.NoExistVaildCodeError;
		}

		if (sessionVcode.equals(changePasswordReqeust.getNpass()) && sessionPhone.equals(changePasswordReqeust.getP())) {
			String password = PasswordUtils.encode(changePasswordReqeust.getNpass());
			String phone = changePasswordReqeust.getP();

			List<TbUser> tbUsers = iTbUserService.selectList(new EntityWrapper<TbUser>().where("phone", phone));

			if (tbUsers.size() == 0) {
				throw UserException.NoExistUserError;
			} else {
				TbUser tbUser = tbUsers.get(0);
				tbUser.setPassword(password);
				iTbUserService.updateById(tbUser);
				httpSession.removeAttribute(SESSION_PHONECODE);
				httpSession.removeAttribute(SESSION_PHONENUMBER);
				return BaseResponse.NormalResponse;
			}
		} else {
			throw UserException.NoExistVaildCodeError;
		}
	}

	@RequestMapping("reg")
	public BaseResponse register(
			@Valid PhoneRegisterRequest request, BindingResult bindingResult,
			HttpSession httpSession) {
		checkParams(bindingResult);
		String sessionPhone = httpSession.getAttribute(SESSION_PHONECODE).toString();
		String sessionVcode = httpSession.getAttribute(SESSION_PHONENUMBER).toString();
		if (StringUtils.isBlank(sessionVcode) || StringUtils.isBlank(sessionPhone) || sessionVcode.equals(request.getV()) || sessionPhone.equals(request.getP())) {
			throw UserException.NoExistVaildCodeError;
		}

		if (sessionVcode.equals(request.getV()) && sessionPhone.equals(request.getP())) {
			TbUser tbUser = new TbUser(request.getU(), request.getP(), request.getP(), PasswordUtils.encode(request.getW()));
			iTbUserService.insert(tbUser);
			httpSession.removeAttribute(SESSION_PHONECODE);
			httpSession.removeAttribute(SESSION_PHONENUMBER);
			return BaseResponse.NormalResponse;
		} else {
			throw UserException.NoExistVaildCodeError;
		}
	}


	@RequestMapping("login")
	@ResponseBody
	public String login(
			SecurityContextHolderAwareRequestWrapper request, LoginReqeust loginReqeust,
			HttpSession httpsession) {
		try {
			if (!SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
				request.login(loginReqeust.getName(), loginReqeust.getPass());
				List<TbUser> user = iTbUserService.getUserByIdentiy(loginReqeust.getName());
				if (user.size() > 0) {
					request.getSession().setAttribute(SessionConstant.E_SESSION_USERID.name(), user.get(0).getId());
				}
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
