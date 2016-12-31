package com.ptb.zeus.service.main.impl;

import com.baomidou.framework.service.impl.CommonServiceImpl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ptb.zeus.common.core.mapper.main.MAccountUserMapper;
import com.ptb.zeus.common.core.mapper.main.MAccountUserStatementMapper;
import com.ptb.zeus.common.core.mapper.main.MOrderItemMapper;
import com.ptb.zeus.common.core.mapper.main.MOrderMapper;
import com.ptb.zeus.common.core.mapper.main.MProductMapper;
import com.ptb.zeus.common.core.mapper.main.MUserServiceMapper;
import com.ptb.zeus.common.core.model.main.MAccountUser;
import com.ptb.zeus.common.core.model.main.MOrder;
import com.ptb.zeus.common.core.model.main.MOrderItem;
import com.ptb.zeus.common.core.model.main.MProduct;
import com.ptb.zeus.common.core.model.main.MUserService;
import com.ptb.zeus.common.core.utils.business.ProductUtil;
import com.ptb.zeus.exception.UserException;
import com.ptb.zeus.service.main.IMOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * MOrder 表数据服务层接口实现类
 */
@Service
public class MOrderServiceImpl extends CommonServiceImpl<MOrderMapper, MOrder> implements IMOrderService {

	@Autowired
	MOrderItemMapper mOrderItemMapper;
	@Autowired
	MProductMapper mProductMapper;

	@Autowired
	MAccountUserMapper mAccountUserMapper;

	@Autowired
	MAccountUserStatementMapper MAccountUserStatementMapper;

	@Autowired
	MUserServiceMapper mUserServiceMapper;

	@Override
	@Transactional
	public String createOrder(long uid, int productID, int num) {
		/*查询账户信息*/
		MAccountUser mAccountUser = getAccountByUID(uid);
		long accountID = mAccountUser.getId();

		/*查询商品信息*/
		MProduct mProduct = mProductMapper.selectById(productID);
		MOrder mOrder = MOrder.newOrder(accountID, mProduct.getPrice() * num);
		/*建立订单信息*/
		baseMapper.insert(mOrder);
		/*建立订单项信息*/
		MOrderItem mOrderItem = new MOrderItem(mOrder.getId(), mProduct.getPrice(), productID, num);
		mOrderItemMapper.insert(mOrderItem);
		return mOrder.getId();
	}


	@Override
	@Transactional
	public void completeOrder(String orderID, long uid) {
		MAccountUser mAccountUser = getAccountByUID(uid);

		long accountID = mAccountUser.getId();

		/*通过UID和订单ID查询订单，为什么要带上用户ID,为了防止其它用户支付某用户的订单*/
		MOrder mOrder = baseMapper.selectOne(new MOrder(accountID, orderID));
		if (mOrder == null) {
			throw UserException.NoExistOrderError;
		}

		/*查询该订单的所有待支付项*/
		List<MOrderItem> mOrderItems = mOrderItemMapper.selectList(new EntityWrapper<>(new MOrderItem(orderID)));


		//判断用户是否有能力购买该商品
		if (mAccountUser.getPoint() < mOrder.getAmount()) {
			throw UserException.NotEnoughPointError;
		} else {
			// 扣出账户金额
			mAccountUser.setPoint(mAccountUser.getPoint() - mOrder.getAmount());
			mAccountUserMapper.updateById(mAccountUser);
		}

		/*发货给购买房*/
		genProducts(accountID, mOrderItems);

		/*重新设置订单状态*/
		mOrder.setState(MOrder.ORDER_STATE_COMPLETE);
		baseMapper.updateById(mOrder);
	}

	@Override
	public void cancelOrder(long uid, String orderID) {
		MAccountUser mAccountUser = getAccountByUID(uid);

		/*通过UID和订单ID查询订单，为什么要带上用户ID,为了防止其它用户支付某用户的订单*/
		MOrder mOrder = baseMapper.selectOne(new MOrder(mAccountUser.getId(), orderID));
		if (mOrder == null) {
			throw UserException.NoExistOrderError;
		}
		mOrder.setState(MOrder.ORDER_STATE_CANCEL);
		baseMapper.updateById(mOrder);
	}

	private void genProducts(long uid, List<MOrderItem> mOrderItems) {
		ArrayList<MUserService> mUserServices = new ArrayList<>();
		for (MOrderItem mOrderItem : mOrderItems) {
			MProduct mProduct = mProductMapper.selectById(mOrderItem.getPId());
			mUserServices.add(ProductUtil.convertProductToMUserService(mProduct, uid, mOrderItem.getNumber()));
		}
		mUserServiceMapper.insertBatch(mUserServices);
	}

	private MAccountUser getAccountByUID(long uid) {
		/*查询用户账户ID*/
		MAccountUser mAccountUser = mAccountUserMapper.selectOne(new MAccountUser(uid));
		if (mAccountUser == null) {
			mAccountUserMapper.insert(MAccountUser.newAccount(uid));
		}
		return mAccountUser;
	}
}


