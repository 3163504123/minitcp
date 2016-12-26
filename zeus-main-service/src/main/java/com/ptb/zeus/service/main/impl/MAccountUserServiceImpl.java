package com.ptb.zeus.service.main.impl;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ptb.zeus.common.core.mapper.main.MAccountUserMapper;
import com.ptb.zeus.common.core.mapper.main.MAccountUserStatementMapper;
import com.ptb.zeus.common.core.model.main.MAccountUser;
import com.ptb.zeus.common.core.model.main.MAccountUserStatement;
import com.ptb.zeus.exception.UserException;
import com.ptb.zeus.service.main.IMAccountUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * MAccountUser 表数据服务层接口实现类
 */
@Service
public class MAccountUserServiceImpl extends SuperServiceImpl<MAccountUserMapper, MAccountUser> implements IMAccountUserService {


	@Autowired
	MAccountUserStatementMapper mAccountUserStatementMapper;

	@Override
	public MAccountUser getAccountByUserID(long uid) {
		MAccountUser mAccountUser = baseMapper.selectOne(new MAccountUser(uid));
		if (mAccountUser == null) {
			mAccountUser = MAccountUser.newAccount(uid);
			baseMapper.insert(mAccountUser);
		}
		;
		return mAccountUser;
	}


	@Transactional
	@Override
	public void recharge(MAccountUser acct, int point, String source, String desc) {
		if (acct == null) {
			throw UserException.NoExistUserError;
		}
		acct.setPoint(acct.getPoint() + point);
		baseMapper.updateSelectiveById(acct);
		mAccountUserStatementMapper.insert(new MAccountUserStatement(acct.getUid(), acct.getId(), point, source, desc));
	}

}