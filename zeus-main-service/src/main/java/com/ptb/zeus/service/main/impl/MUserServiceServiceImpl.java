package com.ptb.zeus.service.main.impl;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.ptb.zeus.common.core.mapper.main.MAccountUserMapper;
import com.ptb.zeus.common.core.mapper.main.MOrderMapper;
import com.ptb.zeus.common.core.mapper.main.MProductMapper;
import com.ptb.zeus.common.core.mapper.main.MUserServiceMapper;
import com.ptb.zeus.common.core.mapper.user.TbUserMapper;
import com.ptb.zeus.common.core.model.main.MAccountUser;
import com.ptb.zeus.common.core.model.main.MProduct;
import com.ptb.zeus.common.core.model.main.MUserService;
import com.ptb.zeus.exception.UserException;
import com.ptb.zeus.service.main.IMUserServiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * MUserService 表数据服务层接口实现类
 *
 */
@Service
public class MUserServiceServiceImpl extends SuperServiceImpl<MUserServiceMapper, MUserService> implements IMUserServiceService {

	@Autowired
	MProductMapper mProductMapper;
	@Autowired
	MOrderMapper mOrderMapper;
	@Autowired
	MAccountUserMapper mAccountUserMapper;
	@Autowired
	TbUserMapper tbUserMapper;



	@Override
	@Transactional(isolation = Isolation.REPEATABLE_READ)
	public void buyProductService(Integer uid, int productID) {
		//获得商品信息
		MProduct mProduct = mProductMapper.selectById(Long.valueOf(productID));
		if(mProduct == null) {
			throw UserException.NoExistProductError;
		}

		//查询用户账户信息
		MAccountUser mAccountUser = mAccountUserMapper.selectOne(new MAccountUser().setUid(uid));
		if(mAccountUser == null) {
			throw  UserException.NoExistAccountError;
		}

		//判断用户是否有能力购买该商品

		//有能力：
		// 扣出账户金额
		// 生成用户流水信息记录
		// 生成该服务的服务KEY
		// 生成订单信息，
		// 没能力返回出错信息


	}
}