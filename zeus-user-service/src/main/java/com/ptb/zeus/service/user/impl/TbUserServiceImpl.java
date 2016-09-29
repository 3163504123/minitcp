package com.ptb.zeus.service.user.impl;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.ptb.zeus.common.core.mapper.TbUserMapper;
import com.ptb.zeus.common.core.model.TbUser;
import com.ptb.zeus.service.user.ITbUserService;

import org.springframework.stereotype.Service;

/**
 *
 * TbUser 表数据服务层接口实现类
 *
 */
@Service
public class TbUserServiceImpl extends SuperServiceImpl<TbUserMapper, TbUser> implements ITbUserService {


}