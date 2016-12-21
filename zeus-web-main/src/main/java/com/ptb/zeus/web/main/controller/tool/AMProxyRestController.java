package com.ptb.zeus.web.main.controller.tool;

import com.ptb.zeus.common.core.model.main.MProxy;
import com.ptb.zeus.service.main.IMProxyService;
import com.ptb.zeus.service.main.impl.MProxyServiceImpl;
import com.ptb.zeus.web.basic.controller.BaseRestController;
import com.ptb.zeus.web.main.request.ProxyServiceRequest;
import com.ptb.zeus.web.response.BaseResponse;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * The type Am proxy controller.
 */
@RequestMapping("/api/proxy")
@RestController
public class AMProxyRestController extends BaseRestController {
	IMProxyService imProxyService = new MProxyServiceImpl();

	private static final int MAX_FREE_PROXY_NUM = 500; //请求返回的最大代理数量

	@RequestMapping("free/new")
	@ResponseBody
	public Object getNew() {
		imProxyService.getNews();
		return BaseResponse.NormalResponse;
	}

	@RequestMapping("free/check")
	@ResponseBody
	public Object check(@RequestParam(value = "t",required = false,defaultValue = "1") Integer threadNum) {
		imProxyService.checkPooledProxy(threadNum);
		imProxyService.checkPooledProxy(threadNum);
		return BaseResponse.NormalResponse;
	}

	/**
	 * 免费代理获取
	 *
	 * @param mProxy the m proxy
	 * @param size   the size
	 * @return the object
	 */
	@RequestMapping("free/get")
	@ResponseBody
	public Object freeProxy(MProxy mProxy, Integer size) {
		if (getToken() == null) {
			return new BaseResponse<>(imProxyService.getFreeProxys(10, mProxy));
		} else {
			if(size == null) size = 10;
			return new BaseResponse<>(imProxyService.getFreeProxys(adjustProxyNum(size), mProxy));
		}
	}

	/**
	 * 获得后台进行筛选后的代理
	 *
	 * @param proxyServiceRequest the proxy service request
	 * @param mProxy              the m proxy
	 * @return the object
	 */
	@RequestMapping("good/get")
	public Object goodPrxoy(@Valid ProxyServiceRequest proxyServiceRequest,BindingResult bindingResult, MProxy mProxy) {
		checkParams(bindingResult);
		return new BaseResponse<>(imProxyService.getGoodProxys(proxyServiceRequest.getKey(), adjustProxyNum(proxyServiceRequest.getSize()), mProxy));
	}

	/**
	 * 得到万能代理地址
	 *
	 * @return the perfect proxys
	 */
	@RequestMapping("perfect/get")
	public Object getPerfectProxys(@Valid ProxyServiceRequest proxyServiceRequest, BindingResult bindingResult) {
		checkParams(bindingResult);
		return new BaseResponse<>(imProxyService.getPerfectProxys(proxyServiceRequest.getKey(), proxyServiceRequest.getSize()));
	}

	/**
	 * 获得动态代理
	 *
	 * @param proxyServiceRequest the proxy service request
	 * @return the getDynamicProxys proxys
	 */
	@RequestMapping("dynamic/get")
	public Object getDynamicProxys(ProxyServiceRequest proxyServiceRequest) {
		return new BaseResponse<>(imProxyService.getDynamicProxys(proxyServiceRequest.getKey()));
	}

	/**
	 * 更新动态代理的IP
	 *
	 * @param proxyServiceRequest the proxy service request
	 * @return the object
	 */
	@RequestMapping("dynamic/change")
	public Object changeDynamicProxys(ProxyServiceRequest proxyServiceRequest) {
		imProxyService.changeDynamicProxy(proxyServiceRequest.getKey());
		return BaseResponse.NormalResponse;
	}

	/**
	 * 矫正用户输入最大的请求代理数，如过大，是调整为系统的最大请求值
	 *
	 * @return 返回代理的最大数量
	 */
	private int adjustProxyNum(int userNeedNum) {
		return userNeedNum > MAX_FREE_PROXY_NUM ? MAX_FREE_PROXY_NUM : userNeedNum;
	}
}

