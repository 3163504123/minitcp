package com.ptb.zeus.service.main.impl;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ptb.zeus.common.core.mapper.main.MProductMapper;
import com.ptb.zeus.common.core.mapper.main.MToolMapper;
import com.ptb.zeus.common.core.mapper.user.TbUserMapper;
import com.ptb.zeus.common.core.model.main.MProduct;
import com.ptb.zeus.common.core.model.main.MTool;
import com.ptb.zeus.common.core.model.user.TbUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 *
 * MTool 表数据服务层接口实现类
 *
 */
@Service
public class MToolServiceImpl extends SuperServiceImpl<MToolMapper, MTool> implements com.ptb.zeus.service.main.IMToolService {

	@Autowired
	TbUserMapper userMapper;

	@Autowired
	MToolMapper mToolMapper;

	@Autowired
	MProductMapper productMapper;

	@Override
	@Transactional
	public void testJXA() {
		userMapper.insert(new TbUser("123","123","123","123"));
		MTool mTool = new MTool();
		mTool.setName("test");
		mToolMapper.insert(mTool);
		throw new RuntimeException();
	}

	@Override
	public List<MProduct> selectProductsByToolID(
			Integer toolID) {
		return productMapper.selectByProductContent(toolID);
	}

	@Override
	@Cacheable(value = "default",key = "#page.current + ':' + #page.size")
	public Page<MTool> selectAllByPage(
			Page<MTool> page) {
		return this.selectPage(page,new EntityWrapper<>());
	}

}