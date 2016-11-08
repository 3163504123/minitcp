package com.ptb.zeus.service.user.impl;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.ptb.zeus.common.core.mapper.user.TbPermissionMapper;
import com.ptb.zeus.common.core.model.user.TbPermission;
import com.ptb.zeus.service.user.ITbPermissionService;

import org.springframework.stereotype.Service;

/**
 *
 * TbPermission 表数据服务层接口实现类
 *
 */
@Service
public class TbPermissionServiceImpl extends SuperServiceImpl<TbPermissionMapper, TbPermission> implements ITbPermissionService {


}