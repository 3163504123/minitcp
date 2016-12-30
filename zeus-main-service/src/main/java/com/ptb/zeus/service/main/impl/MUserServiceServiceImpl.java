package com.ptb.zeus.service.main.impl;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.ptb.zeus.common.core.mapper.main.MUserServiceMapper;
import com.ptb.zeus.common.core.model.main.MUserService;
import com.ptb.zeus.service.main.IMUserServiceService;

import org.springframework.stereotype.Service;

/**
 * MUserService 表数据服务层接口实现类
 */
@Service
public class MUserServiceServiceImpl extends SuperServiceImpl<MUserServiceMapper, MUserService> implements IMUserServiceService {
}