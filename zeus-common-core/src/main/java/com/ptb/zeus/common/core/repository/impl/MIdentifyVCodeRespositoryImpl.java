package com.ptb.zeus.common.core.repository.impl;

import com.alibaba.fastjson.JSON;
import com.ptb.zeus.common.core.model.main.IdentifyVCodeResult;
import com.ptb.zeus.common.core.repository.MIdentifyVCodeRespository;
import com.ptb.zeus.common.core.utils.identiyVCode.ChaoJiYing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/12/30
 * @version 1.0.0
 * @description 类的功能
 */
@Component
public class MIdentifyVCodeRespositoryImpl implements MIdentifyVCodeRespository {

	@Value("${chaojiying.username}")
	String chaojiyingUsername;

	@Value("${chaojiying.password}")
	String chaojiyingPassword;

	@Value("${chaojiying.codeType}")
	String codeType;

	@Override
	public IdentifyVCodeResult regnize(InputStream fileInputStream) {
		String s = ChaoJiYing.PostPic(chaojiyingUsername, chaojiyingPassword, codeType, "5000", "5", "0", "haha", fileInputStream);
		return JSON.parseObject(s,IdentifyVCodeResult.class);
	}

}
