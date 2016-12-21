package com.ptb.zeus.service.user.impl;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ptb.zeus.common.core.mapper.main.MAccountUserMapper;
import com.ptb.zeus.common.core.mapper.user.TbUserMapper;
import com.ptb.zeus.common.core.model.main.MAccountUser;
import com.ptb.zeus.common.core.model.user.TbUser;
import com.ptb.zeus.exception.UserException;
import com.ptb.zeus.service.user.ITbUserService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TbUser 表数据服务层接口实现类
 */
@Service
public class TbUserServiceImpl extends SuperServiceImpl<TbUserMapper, TbUser> implements ITbUserService {

	MAccountUserMapper mAccountUserMapper;

	@Override
	public List<TbUser> getUserByIdentiy(String s) {
		return selectList(new EntityWrapper<TbUser>().where("uname = {0}", s).or("phone = {0}", s));
	}

	@Transactional
	public boolean register(TbUser entity) {
		List<TbUser> tbUsers = this.selectList(new EntityWrapper<TbUser>()
				                                       .where("uname = {0} or phone = {1}", entity.getNickName(), entity.getPhone()));
		if (tbUsers.size() > 0) {
			throw UserException.UsernameOrPhoneExist;
		}

		//判断是否插入新用户成功
		if(!super.insert(entity)) {
			throw UserException.NoRegistUserError;
		}else{
			//成功则创建对应账户
			return mAccountUserMapper.insert(MAccountUser.newAccount(entity.getId())) > 0;
		}

	}
}