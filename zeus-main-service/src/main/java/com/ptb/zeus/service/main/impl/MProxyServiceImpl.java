package com.ptb.zeus.service.main.impl;

import com.ptb.zeus.common.core.mapper.main.MProductMapper;
import com.ptb.zeus.common.core.mapper.main.MUserServiceMapper;
import com.ptb.zeus.common.core.model.main.MProxy;
import com.ptb.zeus.common.core.model.main.MUserService;
import com.ptb.zeus.common.core.repository.ProxyMongoRespository;
import com.ptb.zeus.common.core.repository.ProxyRespository;
import com.ptb.zeus.common.core.utils.business.ProductUtil;
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
	MProductMapper productMapper;

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
		if (mUserService.enabled() && ProductUtil.isGoodProxy(mUserService.getpId())) {
			return proxyRespository.getGoodProxys(size, mProxy);
		} else {
			throw UserException.NoServiceAuthError;
		}

	}

	@Override
	public List<MProxy> getPerfectProxys(String serviceID, int size) {
		//todo 根据KEY判断是否有使用该服务的权限
		MUserService mUserService = userServiceMapper.selectOne(new MUserService(serviceID));
		if (mUserService.enabled() && ProductUtil.isPerfectProxy(mUserService.getpId())) {
			return proxyRespository.getPerfectProxys(size);
		} else {
			throw UserException.NoServiceAuthError;
		}
	}

	@Override
	public MProxy getDynamicProxys(String serviceID) {
		//先检验该服务是否有效

		MUserService mUserService = userServiceMapper.selectOne(new MUserService(serviceID));
		if (mUserService.enabled() && ProductUtil.isDyNamicProxy(mUserService.getpId())) {
			//有效，则通过serviceID，拿到数据库中拿到对应的IP
			if (proxyRespository.getDynamicProxy(serviceID) == null) {
				//没拿到，可能是换IP导致，可分配一个临时动态IP
				List<MProxy> proxys = proxyRespository.getPerfectProxys(1);
				if (proxys.size() > 0) {
					return proxys.get(0);
				}else{
					throw UserException.SwitchingIPError;
				}
			}
		}
		throw UserException.NoServiceAuthError;
	}

	@Override
	public void getNews() {
		proxyRespository.genNewProxy();
	}

	@Override
	public void changeDynamicProxy(String key) {
		proxyRespository.changeDynamicProxy(key);
	}

	@Override
	public void checkPooledProxy(Integer threadNum) {
		proxyRespository.checkAndDelInvalidProxy(threadNum);
	}
}
