package com.ptb.zeus.service.main;

import com.ptb.zeus.common.core.model.main.MProxy;

import java.util.List;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/9
 * @version 1.0.0
 * @description 类的功能
 */
public interface IMProxyService {


	List<MProxy> selectValidHost(int limit);

	List<MProxy> getFreeProxys(int size, MProxy mProxy);

	List<MProxy> getGoodProxys(String serviceID, int size, MProxy mProxy);

	List<MProxy> getPerfectProxys(String serviceID, int size);

	List<MProxy> dynamic(String serviceID, int size);

	<T> T changeDynamicProxy(String key, int size);
}
