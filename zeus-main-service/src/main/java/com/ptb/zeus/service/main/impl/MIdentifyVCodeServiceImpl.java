package com.ptb.zeus.service.main.impl;

import com.alibaba.fastjson.JSON;
import com.ptb.zeus.common.core.mapper.main.MUserServiceMapper;
import com.ptb.zeus.common.core.model.main.IdentifyVCodeResult;
import com.ptb.zeus.common.core.model.main.MUserService;
import com.ptb.zeus.common.core.repository.MIdentifyVCodeRespository;
import com.ptb.zeus.common.core.repository.StoreRespository;
import com.ptb.zeus.common.core.utils.UserServiceUtils;
import com.ptb.zeus.common.core.utils.business.ProductUtil;
import com.ptb.zeus.exception.UserException;
import com.ptb.zeus.service.main.MIdentifyVCodeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/15
 * @version 1.0.0
 * @description 验证码识别的主逻辑代码
 */
@Service
public class MIdentifyVCodeServiceImpl implements MIdentifyVCodeService {
	private static Logger logger = LoggerFactory.getLogger(MIdentifyVCodeServiceImpl.class);


	@Autowired
	StoreRespository storeRespository;

	@Autowired
	MIdentifyVCodeRespository identifyVCodeRespository;

	@Autowired
	MUserServiceMapper userServiceMapper;

	@Override
	public IdentifyVCodeResult regnize(
			String originalFilename, InputStream inputStream, String key) {
		//检测服务有效型
		MUserService mUserService = userServiceMapper.selectOne(new MUserService(key));
		if (UserServiceUtils.isOK(mUserService, ProductUtil.CODE_VCODE_GENERAL)) {
			//先把文件存储到本地
			String uuid = storeRespository.saveFile("vcodeImage", originalFilename, inputStream);

			//再进行识别操作
			try {
				IdentifyVCodeResult regnize = identifyVCodeRespository.regnize(storeRespository.getFileInputStream(uuid));
				if (logger.isInfoEnabled()) {
					logger.info("%s:::%s:::%s", mUserService.getUid(), mUserService.getSkey(), JSON.toJSONString(regnize));
				}
				userServiceMapper.incCostNum(mUserService.getId(),1);
			} catch (FileNotFoundException e) {
				throw UserException.IdentifyVCodeImageUploadError;
			}
		}
		throw UserException.NoServiceAuthError;
	}

}
