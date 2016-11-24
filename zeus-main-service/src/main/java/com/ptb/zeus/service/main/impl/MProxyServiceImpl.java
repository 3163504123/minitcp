package com.ptb.zeus.service.main.impl;

import com.ptb.zeus.common.core.mapper.main.MUserServiceMapper;
import com.ptb.zeus.common.core.model.main.MProxy;
import com.ptb.zeus.common.core.model.main.MUserService;
import com.ptb.zeus.common.core.repository.ProxyMongoRespository;
import com.ptb.zeus.common.core.repository.ProxyRespository;
import com.ptb.zeus.exception.UserException;
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
	ProxyRespository proxyRespository;
	MUserServiceMapper userServiceMapper;

	public MProxyServiceImpl() {
		proxyRespository = new ProxyMongoRespository();
	}

	@Override
	public List<MProxy> getFreeProxys(int size, MProxy mProxy) {
		return proxyRespository.getFreeProxy(size, mProxy);
	}

	@Override
	public List<MProxy> getGoodProxys(
			String serviceID, int size, MProxy mProxy) {
		//todo 根据KEY判断是否有使用该服务的权限
		MUserService mUserService = userServiceMapper.selectOne(new MUserService(serviceID));
		if(false) {
			throw  UserException.NoServiceAuthError;
		}
		return proxyRespository.getGoodProxys(size,mProxy);
	}

	@Override
	public List<MProxy> getPerfectProxys(String serviceID, int size) {
		//todo 根据KEY判断是否有使用该服务的权限
		MUserService mUserService = userServiceMapper.selectOne(new MUserService(serviceID));
		if(false) {
			throw  UserException.NoServiceAuthError;
		}
		return proxyRespository.getPerfectProxy(size);
	}

	@Override
	public MProxy getDynamicProxys(String serviceID) {
		//先检验该服务是否有效
		//有效，则通过serviceID，拿到数据库中拿到对应的IP
		proxyRespository.getDynamicProxy(serviceID);
		return null;
	}

	@Override
	public void changeDynamicProxy(String key) {
		proxyRespository.changeDynamicProxy(key);
	}
}
