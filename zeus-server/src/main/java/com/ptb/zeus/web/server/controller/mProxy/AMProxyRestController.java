package com.ptb.zeus.web.server.controller.mProxy;

import com.ptb.zeus.common.core.model.main.MProxy;
import com.ptb.zeus.service.main.IMProxyService;
import com.ptb.zeus.service.main.impl.MProxyServiceImpl;
import com.ptb.zeus.web.controller.BaseRestController;
import com.ptb.zeus.web.response.BaseResponse;
import com.ptb.zeus.web.server.request.ProxyServiceRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Am proxy controller.
 */
@RequestMapping("/api/proxy")
@RestController
public class AMProxyRestController extends BaseRestController {
	IMProxyService imProxyService = new MProxyServiceImpl();

	private static final int MAX_FREE_PROXY_NUM = 500; //请求返回的最大代理数量

	/**
	 * 免费代理获取
	 *
	 * @param mProxy the m proxy
	 * @param size   the size
	 * @return the object
	 */
	@RequestMapping("free/get")
	public Object freeProxy(MProxy mProxy, int size) {
		if (!SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			return new BaseResponse<>(imProxyService.getFreeProxys(20, mProxy));
		} else {
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
	public Object goodPrxoy(ProxyServiceRequest proxyServiceRequest, MProxy mProxy) {
		return new BaseResponse<>(imProxyService.getGoodProxys(proxyServiceRequest.getKey(), adjustProxyNum(proxyServiceRequest.getSize()), mProxy));
	}


	/**
	 * 得到万能代理地址
	 *
	 * @return the perfect proxys
	 */
	@RequestMapping("perfect/get")
	public Object getPerfectProxys(ProxyServiceRequest proxyServiceRequest) {
		return new BaseResponse<>(imProxyService.getPerfectProxys(proxyServiceRequest.getKey(), proxyServiceRequest.getSize()));
	}

	/**
	 * 获得动态代理
	 *
	 * @param proxyServiceRequest the proxy service request
	 * @return the dynamic proxys
	 */
	@RequestMapping("dynamic/get")
	public Object getDynamicProxys(ProxyServiceRequest proxyServiceRequest) {
		return new BaseResponse<>(imProxyService.dynamic(proxyServiceRequest.getKey(), proxyServiceRequest.getSize()));
	}

	/**
	 * 更新动态代理的IP
	 *
	 * @param proxyServiceRequest the proxy service request
	 * @return the object
	 */
	@RequestMapping("dynamic/change")
	public Object changeDynamicProxys(ProxyServiceRequest proxyServiceRequest) {
		return new BaseResponse<>(imProxyService.changeDynamicProxy(proxyServiceRequest.getKey(), proxyServiceRequest.getSize()));
	}

	/**
	 * 矫正用户输入最大的请求代理数，如过大，是调整为系统的最大请求值
	 *
	 * @return 返回代理的最大数量
	 */
	private int  adjustProxyNum(int userNeedNum) {
		return userNeedNum > MAX_FREE_PROXY_NUM ? MAX_FREE_PROXY_NUM : userNeedNum;
	}
}

