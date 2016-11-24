package com.ptb.zeus.service.main.impl;

import org.springframework.stereotype.Service;

import com.ptb.zeus.common.core.mapper.main.MUserServiceMapper;
import com.ptb.zeus.common.core.model.main.MUserService;
import com.ptb.zeus.service.main.IMUserServiceService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * MUserService 表数据服务层接口实现类
 *
 */
@Service
public class MUserServiceServiceImpl extends SuperServiceImpl<MUserServiceMapper, MUserService> implements IMUserServiceService {


}