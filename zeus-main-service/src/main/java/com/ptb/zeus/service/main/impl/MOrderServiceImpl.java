package com.ptb.zeus.service.main.impl;

import org.springframework.stereotype.Service;

import com.ptb.zeus.common.core.mapper.main.MOrderMapper;
import com.ptb.zeus.common.core.model.main.MOrder;
import com.ptb.zeus.service.main.IMOrderService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * MOrder 表数据服务层接口实现类
 *
 */
@Service
public class MOrderServiceImpl extends SuperServiceImpl<MOrderMapper, MOrder> implements IMOrderService {


}