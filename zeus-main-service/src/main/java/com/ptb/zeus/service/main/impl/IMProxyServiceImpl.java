package com.ptb.zeus.service.main.impl;

import com.ptb.zeus.common.core.model.main.MProxy;
import com.ptb.zeus.common.core.repository.ProxyMongoRespository;
import com.ptb.zeus.service.main.IMProxyService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/9
 * @version 1.0.0
 * @description 类的功能
 */
public class IMProxyServiceImpl implements IMProxyService {
	private static Logger logger = LoggerFactory.getLogger(IMProxyServiceImpl.class);
	ProxyMongoRespository respository= new ProxyMongoRespository();

	public IMProxyServiceImpl() {

	}


	@Override
	public List<MProxy> select(
			MProxy mProxy, int offset, int limit) {
		return respository.select(mProxy,offset,limit);
	}
}
