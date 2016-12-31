package com.ptb.zeus.common.core.repository;

import com.ptb.zeus.common.core.model.main.MProxy;
import com.ptb.zeus.common.core.model.main.ProxyFilter;

import java.util.List;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/9
 * @version 1.0.0
 * @description 类的功能
 */
public interface ProxyRespository {
	void add(MProxy mProxy) ;
	void del(String id);

	List<MProxy> getFreeProxy(int size, ProxyFilter mProxy);

	List<MProxy> getGoodProxys(int size, ProxyFilter mProxy);

	List<MProxy> getPerfectProxys(int size);

	void genNewProxy();
	void checkAndDelInvalidProxy(int threadNum, boolean isAsync);
	MProxy getDynamicProxy(String serviceID);

	void changeDynamicProxy(String key);
}
