package com.ptb.zeus.service.main.impl;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.ptb.zeus.common.core.mapper.main.MAccountUserMapper;
import com.ptb.zeus.common.core.model.main.MAccountUser;
import com.ptb.zeus.service.main.IMAccountUserService;

import org.springframework.stereotype.Service;

/**
 *
 * MAccountUser 表数据服务层接口实现类
 *
 */
@Service
public class MAccountUserServiceImpl extends SuperServiceImpl<MAccountUserMapper, MAccountUser> implements IMAccountUserService {


	@Override
	public void getAccountByUserID(long uid) {
		baseMapper.selectOne(new MAccountUser(uid));

	}
}