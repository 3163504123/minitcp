package com.ptb.zeus.service.main.impl;

import org.springframework.stereotype.Service;

import com.ptb.zeus.common.core.mapper.main.MProductMapper;
import com.ptb.zeus.common.core.model.main.MProduct;
import com.ptb.zeus.service.main.IMProductService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * MProduct 表数据服务层接口实现类
 *
 */
@Service
public class MProductServiceImpl extends SuperServiceImpl<MProductMapper, MProduct> implements IMProductService {


}