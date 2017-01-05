package com.ptb.zeus.service.main.impl;

import com.alibaba.fastjson.JSON;
import com.ptb.zeus.common.core.mapper.main.MUserServiceMapper;
import com.ptb.zeus.common.core.model.main.IdentifyVCodeResult;
import com.ptb.zeus.common.core.model.main.MUserService;
import com.ptb.zeus.common.core.model.main.ReginizeHiistory;
import com.ptb.zeus.common.core.repository.MIdentifyVCodeHistoryRespository;
import com.ptb.zeus.common.core.repository.MIdentifyVCodeRespository;
import com.ptb.zeus.common.core.repository.StoreRespository;
import com.ptb.zeus.common.core.utils.UserServiceUtils;
import com.ptb.zeus.common.core.utils.business.ProductUtil;
import com.ptb.zeus.exception.UserException;
import com.ptb.zeus.service.main.MIdentifyVCodeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

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


	@Resource(name = "mongoStorageRespositoryImpl")
	StoreRespository storeRespository;

	@Autowired
	MIdentifyVCodeRespository identifyVCodeRespository;


	@Autowired
	MIdentifyVCodeHistoryRespository mIdentifyVCodeHistoryRespository;

	@Autowired
	MUserServiceMapper userServiceMapper;

	@Value("#{com.zeus.static.resource.url.prefix}")
	String resoucceUrlPrefix;

	@Override
	@Transactional
	public IdentifyVCodeResult regnize(
			String originalFilename, InputStream inputStream, String key) {
		//检测服务有效型
		MUserService mUserService = userServiceMapper.selectOne(new MUserService(key));
		if (UserServiceUtils.isOK(mUserService, ProductUtil.CODE_VCODE_GENERAL)) {
			//先把文件存储到本地
			String uuid = storeRespository.saveFile("vcodeImage", originalFilename, inputStream);

			//再进行识别操作
			try {
				//识别次数加1
				userServiceMapper.incCostNum(mUserService.getId(),1);

				IdentifyVCodeResult regnize = identifyVCodeRespository.regnize(storeRespository.getFileInputStream(uuid));
				if (logger.isInfoEnabled()) {
					logger.info("%s:::%s:::%s", mUserService.getUid(), mUserService.getSkey(), JSON.toJSONString(regnize));
				}




				//记录识别信息
				mIdentifyVCodeHistoryRespository.addIdentifyVCodeHistory(new ReginizeHiistory(
						mUserService.getUid(),
				        regnize.getPic_str(),
						uuid,
				        mUserService.getSkey(),
				        regnize.getErr_str(),
				        regnize.getErr_no()
				));

				return regnize;
			} catch (Exception e) {
				throw UserException.IdentifyVCodeImageUploadError;
			}
		}
		throw UserException.NoServiceAuthError;
	}

	@Override
	public List<ReginizeHiistory> selecltIdentifyVCodeHistory(
			int page, int rows, long uid) {
		return mIdentifyVCodeHistoryRespository.selecltIdentifyVCodeHistory(page,rows,uid);
	}

}
