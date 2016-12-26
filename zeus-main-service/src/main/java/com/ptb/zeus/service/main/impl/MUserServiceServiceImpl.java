package com.ptb.zeus.service.main.impl;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.ptb.zeus.common.core.mapper.main.MAccountUserMapper;
import com.ptb.zeus.common.core.mapper.main.MAccountUserStatementMapper;
import com.ptb.zeus.common.core.mapper.main.MProductMapper;
import com.ptb.zeus.common.core.mapper.main.MUserServiceMapper;
import com.ptb.zeus.common.core.mapper.user.TbUserMapper;
import com.ptb.zeus.common.core.model.main.MAccountUser;
import com.ptb.zeus.common.core.model.main.MAccountUserStatement;
import com.ptb.zeus.common.core.model.main.MProduct;
import com.ptb.zeus.common.core.model.main.MUserService;
import com.ptb.zeus.common.core.utils.business.ProductUtil;
import com.ptb.zeus.exception.UserException;
import com.ptb.zeus.service.main.IMUserServiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.ptb.zeus.common.core.utils.business.ProductUtil.CODE_PRODUCT_SERVICE_TYPE_ENABLE;
import static com.ptb.zeus.common.core.utils.business.ProductUtil.CODE_PRODUCT_SERVICE_TYPE_TIME;
import static com.ptb.zeus.common.core.utils.business.ProductUtil.getServiceMethod;

/**
 * MUserService 表数据服务层接口实现类
 */
@Service
public class MUserServiceServiceImpl extends SuperServiceImpl<MUserServiceMapper, MUserService> implements IMUserServiceService {

	@Autowired
	MProductMapper mProductMapper;

	@Autowired
	MAccountUserMapper mAccountUserMapper;

	@Autowired
	MAccountUserStatementMapper mAccountUserStatementMapper;

	@Autowired
	TbUserMapper tbUserMapper;

	@Autowired
	MUserServiceMapper userServiceMapper;


	@Override
	@Transactional
	public void buyProductService(Long uid, Long productID) {
		//获得商品信息
		MProduct mProduct = mProductMapper.selectById(productID);
		if (mProduct == null) {
			throw UserException.NoExistProductError;
		}

		//查询用户账户信息
		MAccountUser mAccountUser = mAccountUserMapper.selectOne(new MAccountUser().setUid(uid));
		if (mAccountUser == null) {
			mAccountUser = MAccountUser.newAccount(uid);
			mAccountUserMapper.insert(mAccountUser);
		}

		//判断用户是否有能力购买该商品
		if (mAccountUser.getPoint() < mProduct.getPrice()) {
			throw UserException.NotEnoughPointError;
		}else{
			// 扣出账户金额
			mAccountUser.setPoint(mAccountUser.getPoint() - mProduct.getPrice());
			mAccountUserMapper.updateById(mAccountUser);
		}

		MUserService mUserService = null;
		// 生成该服务的服务KEY
		switch (ProductUtil.getServiceMethod(mProduct.getCode())) {
			case CODE_PRODUCT_SERVICE_TYPE_TIME:
				mUserService = new MUserService(mProduct.getCode(), ProductUtil.getServiceMethod(mProduct.getCode()), uid, mProduct.getDes(), ProductUtil.getTimeServiceSeconds(mProduct.getCode()));
				break;
			case CODE_PRODUCT_SERVICE_TYPE_ENABLE:
				mUserService = new MUserService(mProduct.getCode(), uid, getServiceMethod(mProduct.getCode()), mProduct.getDes());
				break;
			default:
				mUserService = new MUserService(mProduct.getCode(),
				                                getServiceMethod(mProduct.getCode()),
				                                uid,
				                                mProduct.getDes(),
				                                ProductUtil.getServiceCount(mProduct.getCode()));
				break;
		}

		//插入用户服务记录
		userServiceMapper.insert(mUserService);

		// 生成用户流水信息记录
		mAccountUserStatementMapper.insert(new MAccountUserStatement(
			uid,
		    mAccountUser.getId(),
		    mProduct.getPrice() * -1,
		    String.valueOf(mProduct.getCode()),
		    mProduct.getDes()
		));
	}
}