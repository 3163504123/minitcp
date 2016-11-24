package com.ptb.zeus.service.main.impl;

import com.ptb.zeus.common.core.model.main.MProxy;
import com.ptb.zeus.common.core.repository.ProxyMongoRespository;
import com.ptb.zeus.common.core.repository.ProxyRespository;
import com.ptb.zeus.service.main.IMProxyService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/9
 * @version 1.0.0
 * @description 代理的服务类，完成代理相关的逻辑
 */
public class MProxyServiceImpl implements IMProxyService {
	private static Logger logger = LoggerFactory.getLogger(MProxyServiceImpl.class);
	ProxyRespository respository;

	public MProxyServiceImpl() {
		respository = new ProxyMongoRespository();
	}

	public List<MProxy> selectValidHost(int limit) {
		return respository.selectValidHost(limit);
	}

	@Override
	public List<MProxy> getFreeProxys(int size, MProxy mProxy) {
		return respository.getProxyFromRawProxyLib(size,mProxy);
	}

	@Override
	public List<MProxy> getGoodProxys(
			String serviceID, int size, MProxy mProxy) {

		return null;

	}
	@Override
	public List<MProxy> getPerfectProxys(String serviceID, int size) {
		return null;
	}

	@Override
	public List<MProxy> dynamic(String serviceID, int size) {
		return null;
	}

	@Override
	public <T> T changeDynamicProxy(String key, int size) {
		return null;
	}
}
