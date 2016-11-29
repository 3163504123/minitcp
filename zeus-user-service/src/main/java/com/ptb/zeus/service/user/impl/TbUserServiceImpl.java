package com.ptb.zeus.service.user.impl;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ptb.zeus.common.core.mapper.user.TbUserMapper;
import com.ptb.zeus.common.core.model.user.TbUser;
import com.ptb.zeus.exception.UserException;
import com.ptb.zeus.service.user.ITbUserService;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * TbUser 表数据服务层接口实现类
 *
 */
@Service
public class TbUserServiceImpl extends SuperServiceImpl<TbUserMapper, TbUser> implements ITbUserService {


	@Override
	public List<TbUser> getUserByIdentiy(String s) {
		return selectList(new EntityWrapper<TbUser>().where("uname = {0}", s).or("phone = {0}", s));
	}

	@Override
	public boolean insert(TbUser entity) {
		List<TbUser> tbUsers = this.selectList(new EntityWrapper<TbUser>().where("uname", entity.getNickName()).or("phone", entity.getPhone()));
		if (tbUsers.size() > 0) {
			throw UserException.UsernameOrPhoneExist;
		}
		return super.insert(entity);
	}
}