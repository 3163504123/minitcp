package com.ptb.zeus.service.main;

import com.baomidou.framework.service.ICommonService;
import com.ptb.zeus.common.core.model.main.MOrder;

/**
 *
 * MOrder 表数据服务层接口
 *
 */
public interface IMOrderService extends ICommonService<MOrder> {


	String createOrder(long uid, int productID, int num);

	void completeOrder(String orderID, long uid);

	void cancelOrder(long uid, String orderID);

}