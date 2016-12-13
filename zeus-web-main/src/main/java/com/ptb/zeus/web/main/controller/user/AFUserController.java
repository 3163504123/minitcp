package com.ptb.zeus.web.main.controller.user;

import com.github.cage.Cage;
import com.github.cage.GCage;
import com.ptb.zeus.common.core.model.user.TbUser;
import com.ptb.zeus.common.core.utils.PasswordUtils;
import com.ptb.zeus.common.core.utils.security.security.Token;
import com.ptb.zeus.common.core.utils.security.security.TokenUtils;
import com.ptb.zeus.exception.UserException;
import com.ptb.zeus.service.main.IMMobileMsgService;
import com.ptb.zeus.service.user.ITbUserService;
import com.ptb.zeus.web.controller.BaseRestController;
import com.ptb.zeus.web.response.BaseResponse;
import com.ptb.zeus.web.main.request.ChangePasswordReqeust;
import com.ptb.zeus.web.main.request.LoginReqeust;
import com.ptb.zeus.web.main.request.PhoneRegisterRequest;
import com.ptb.zeus.web.main.request.SendRegVCodeRequest;
import com.ptb.zeus.web.utils.SessionConstant;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.ptb.zeus.web.utils.SessionConstant.DEFAULT_UUID_EXPIRED_TIME;
import static com.ptb.zeus.web.utils.SessionConstant.E_SESSION_IMGVCODE;
import static com.ptb.zeus.web.utils.SessionConstant.E_SESSION_PHONENUM;
import static com.ptb.zeus.web.utils.SessionConstant.E_SESSION_PHONEVCODE;
import static com.ptb.zeus.web.utils.SessionConstant.KEY_UUID;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/26
 * @version 1.0.0
 * @description 用户相关的API
 */
@Controller
@RequestMapping("/api/u")
public class AFUserController extends BaseRestController {
	static Logger logger = LoggerFactory.getLogger(AFUserController.class);

	@Resource
	IMMobileMsgService iMMobileMsgService;

	@Resource
	ITbUserService iTbUserService;


	@RequestMapping("sendVCode")
	@ResponseBody
	public BaseResponse sendVaildCode(
			@Valid SendRegVCodeRequest sendRegVCodeRequest, BindingResult bindingResult,
			HttpSession httpSession) {
		checkParams(bindingResult);
		String regVCode = (String) httpSession.getAttribute(E_SESSION_IMGVCODE.name());
		if (regVCode.equalsIgnoreCase(sendRegVCodeRequest.getImageVcode())) {

			//生成验证码
			String vcode = RandomStringUtils.random(6, false, true);


			System.out.println(vcode);
			//发送短信
/*			iMMobileMsgService.sendRegisterSMS(sendRegVCodeRequest.getPhone(), vcode);*/

			//校验成功后，删除COOKIE中的图片验证码，并记录手机验证码
			httpSession.removeAttribute(E_SESSION_IMGVCODE.name());
			httpSession.setAttribute(E_SESSION_PHONEVCODE.name(), vcode);
			httpSession.setAttribute(E_SESSION_PHONENUM.name(), sendRegVCodeRequest.getPhone());
			return BaseResponse.NormalResponse;
		} else {
			throw UserException.ErrorImgVcode;
		}
	}


	@RequestMapping("imgVcode")
	public void genImgVcode(HttpServletResponse resp, HttpSession httpSession) {
		Cage cage = new GCage();
		resp.setContentType("image/" + cage.getFormat());
		resp.setHeader("Cache-Control", "no-cache, no-store");
		resp.setHeader("Pragma", "no-cache");
		long time = System.currentTimeMillis();
		resp.setDateHeader("Last-Modified", time);
		resp.setDateHeader("Date", time);
		resp.setDateHeader("Expires", time);
		cage.getTokenGenerator().next();
		String s = RandomStringUtils.randomAlphanumeric(4);
		httpSession.setAttribute(E_SESSION_IMGVCODE.name(), s);
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
	@ResponseBody
	public BaseResponse changePassword(
			@Valid ChangePasswordReqeust reqeust, BindingResult bindingResult,
			HttpSession httpSession) {

		checkParams(bindingResult);
		checkPhoneAndVcode(reqeust.getPh(), reqeust.getV(), httpSession);

		String password = PasswordUtils.encode(reqeust.getPs());
		String phone = reqeust.getPh();

		List<TbUser> tbUsers = iTbUserService.getUserByIdentiy(reqeust.getPh());

		if (tbUsers.size() == 0) {
			throw UserException.NoExistUserError;
		} else {
			TbUser tbUser = tbUsers.get(0);
			tbUser.setPassword(password);
			iTbUserService.updateById(tbUser);
			httpSession.removeAttribute(E_SESSION_PHONEVCODE.name());
			httpSession.removeAttribute(E_SESSION_PHONENUM.name());
			return BaseResponse.NormalResponse;
		}
	}


	@RequestMapping("reg")
	@ResponseBody
	public BaseResponse register(
			@Valid PhoneRegisterRequest request, BindingResult bindingResult,
			HttpSession httpSession) {
		checkParams(bindingResult);
		checkPhoneAndVcode(request.getPh(), request.getVcode(), httpSession);

		iTbUserService.insert(new TbUser(request.getUn(), request.getPh(), request.getPh(), PasswordUtils.encode(request.getPw())));

		/*删除上下文信息*/
		httpSession.removeAttribute(E_SESSION_PHONEVCODE.name());
		httpSession.removeAttribute(E_SESSION_PHONENUM.name());
		return BaseResponse.NormalResponse;
	}


	@RequestMapping("login")
	@ResponseBody
	public BaseResponse login(
			SecurityContextHolderAwareRequestWrapper request, LoginReqeust loginReqeust,
			HttpServletResponse resp, BindingResult bindingResult) {
		checkParams(bindingResult);
		try {
			//通过系统进行登陆操作
			List<TbUser> users = iTbUserService.getUserByIdentiy(loginReqeust.getName());

			request.logout();
			request.login(users.get(0).getUname(), loginReqeust.getPass());

			if (users.size() > 0) {
				TbUser user = users.get(0);
				//记录用户ID
				request.getSession().setAttribute(SessionConstant.E_SESSION_USERID.name(), user.getId());
				//添加访问密钥给客户端
				resp.addCookie(new Cookie(KEY_UUID, TokenUtils.encode(new Token(user.getId(), DEFAULT_UUID_EXPIRED_TIME))));
			}
		} catch (ServletException e) {
			e.printStackTrace();
			throw UserException.LoginUndefineError;
		}
		return BaseResponse.NormalResponse;
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

	private void checkPhoneAndVcode(String phone, String vcode, HttpSession httpSession) {
		String sessionPhone = httpSession.getAttribute(E_SESSION_PHONENUM.name()).toString();
		String sessionVcode = httpSession.getAttribute(E_SESSION_PHONEVCODE.name()).toString();

		if (StringUtils.isBlank(sessionVcode) || StringUtils.isBlank(sessionPhone)) {
			throw UserException.NoExistVaildCodeError;
		}

		if (!sessionVcode.equals(vcode) || !sessionPhone.equals(phone)) {
			throw UserException.NoExistVaildCodeError;
		}

	}

}
