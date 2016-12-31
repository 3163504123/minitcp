package com.ptb.zeus.web.main.controller.tool;

import com.ptb.zeus.common.core.model.main.MProxy;
import com.ptb.zeus.common.core.model.main.ProxyFilter;
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

import java.util.List;

import javax.validation.Valid;

/**
 * The type Am proxy controller.
 */
@RequestMapping("/api/proxy")
@RestController
public class AMProxyRestController extends BaseRestController {
	IMProxyService imProxyService = new MProxyServiceImpl();

	private static final int MAX_FREE_PROXY_NUM = 500; //请求返回的最大代理数量
	private static final int FormatText = 1;
	private static final int FormatTextDetail = 2;
	private static final int FormateNormal = 0;

	@RequestMapping("free/new")
	@ResponseBody
	public Object getNew() {
		imProxyService.getNews();
		return BaseResponse.NormalResponse;
	}

	@RequestMapping("free/check")
	@ResponseBody
	public Object check(
			@RequestParam(value = "t", required = false, defaultValue = "1") Integer threadNum) {
		imProxyService.checkPooledProxy(threadNum, true);
		return BaseResponse.NormalResponse;
	}

	/**
	 * 免费代理获取
	 *
	 * @param size the size
	 * @return the object
	 */
	@RequestMapping("free/get")
	@ResponseBody
	public Object freeProxy(
			ProxyFilter filter, Integer size,
			@RequestParam(value = "f", required = false, defaultValue = "0") int format) {
		List<MProxy> proxys;
		if (getToken() == null) {
			proxys = imProxyService.getFreeProxys(10, filter);
		} else {
			if (size == null) size = 10;
			proxys = imProxyService.getFreeProxys(adjustProxyNum(size), filter);
		}
		return formatResponse(proxys, format);
	}

	/**
	 * 获得后台进行筛选后的代理
	 *
	 * @param proxyServiceRequest the proxy service request
	 * @return the object
	 */
	@RequestMapping("good/get")
	public Object goodPrxoy(
			@Valid ProxyServiceRequest proxyServiceRequest, BindingResult bindingResult,
			ProxyFilter filter,
			@RequestParam(value = "f", required = false, defaultValue = "0") int format) {
		checkParams(bindingResult);
		List<MProxy> proxys = imProxyService.getGoodProxys(proxyServiceRequest.getKey(), adjustProxyNum(proxyServiceRequest.getSize()), filter);
		return formatResponse(proxys, format);
	}

	/**
	 * 得到万能代理地址
	 *
	 * @return the perfect proxys
	 */
	@RequestMapping("perfect/get")
	public Object getPerfectProxys(
			@Valid ProxyServiceRequest proxyServiceRequest, BindingResult bindingResult,@RequestParam(value = "f", required = false, defaultValue = "0") int format) {
		checkParams(bindingResult);
		List<MProxy> perfectProxys = imProxyService.getPerfectProxys(proxyServiceRequest.getKey(), proxyServiceRequest.getSize());
		return formatResponse(perfectProxys,format);
	}

/*
	*/
/**
	 * 获得动态代理
	 *
	 * @param proxyServiceRequest the proxy service request
	 * @return the getDynamicProxys proxys
	 *//*

	@RequestMapping("dynamic/get")
	public Object getDynamicProxys(ProxyServiceRequest proxyServiceRequest) {
		return new BaseResponse<>(imProxyService.getDynamicProxys(proxyServiceRequest.getKey()));
	}

	*/
/**
	 * 更新动态代理的IP
	 *
	 * @param proxyServiceRequest the proxy service request
	 * @return the object
	 *//*

	@RequestMapping("dynamic/change")
	public Object changeDynamicProxys(ProxyServiceRequest proxyServiceRequest) {
		imProxyService.changeDynamicProxy(proxyServiceRequest.getKey());
		return BaseResponse.NormalResponse;
	}
*/

	/**
	 * 矫正用户输入最大的请求代理数，如过大，是调整为系统的最大请求值
	 *
	 * @return 返回代理的最大数量
	 */
	private int adjustProxyNum(int userNeedNum) {
		return userNeedNum > MAX_FREE_PROXY_NUM ? MAX_FREE_PROXY_NUM : userNeedNum;
	}

	private Object formatResponse(List<MProxy> proxys, int format) {
		switch (format) {
			case FormatText:
				return proxys.stream().map(mProxy -> String.format("%s:%s", mProxy.getIp(), mProxy.getPort())).reduce("", (k1, k2) -> {
					if (k1.equals("")) {
						return k1 + k2;
					} else {
						return k1 + "," + k2;
					}
				});
			case FormatTextDetail:
				return proxys;
			default:
				return new BaseResponse<>(proxys);
		}
	}

}

