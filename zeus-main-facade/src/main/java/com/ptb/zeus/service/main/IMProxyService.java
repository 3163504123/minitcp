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

	List<MProxy> getFreeProxys(int size, MProxy mProxy);

	List<MProxy> getGoodProxys(String serviceID, int size, MProxy mProxy);

	List<MProxy> getPerfectProxys(String serviceID, int size);

	MProxy getDynamicProxys(String serviceID);

	void getNews();

	void changeDynamicProxy(String key);

	void checkPooledProxy(Integer threadNum);
}
