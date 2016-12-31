package com.ptb.zeus.service.main;

import com.baomidou.framework.service.ISuperService;
import com.ptb.zeus.common.core.model.main.MProduct;
import com.ptb.zeus.common.core.model.main.MTool;

import java.util.List;

/**
 *
 * MTool 表数据服务层接口
 *
 */
public interface IMToolService extends ISuperService<MTool> {

	void testJXA();

	List<MProduct> selectProductsByToolID(Integer id);
}