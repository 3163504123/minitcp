package com.ptb.zeus.service.main.impl;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.ptb.zeus.common.core.mapper.main.MOrderItemMapper;
import com.ptb.zeus.common.core.model.main.MOrderItem;
import com.ptb.zeus.service.main.IMOrderItemService;

import org.springframework.stereotype.Service;

/**
 *
 * MOrderItem 表数据服务层接口实现类
 *
 */
@Service
public class MOrderItemServiceImpl extends SuperServiceImpl<MOrderItemMapper, MOrderItem> implements IMOrderItemService {


}