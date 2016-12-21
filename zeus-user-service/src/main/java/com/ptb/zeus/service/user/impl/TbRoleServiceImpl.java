package com.ptb.zeus.service.user.impl;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.ptb.zeus.common.core.mapper.user.TbRoleMapper;
import com.ptb.zeus.common.core.model.user.TbRole;
import com.ptb.zeus.service.user.ITbRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * TbRole 表数据服务层接口实现类
 *
 */
@Service
public class TbRoleServiceImpl extends SuperServiceImpl<TbRoleMapper, TbRole> implements ITbRoleService {

	@Autowired
	TbRoleMapper tbRoleMapper;

	@Override
	public List<TbRole> selectByUID(Long id) {
		return tbRoleMapper.selectByUID(id);
	}
}