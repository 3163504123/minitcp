package com.ptb.zeus.service.main;

import com.baomidou.framework.service.ISuperService;
import com.ptb.zeus.common.core.model.main.MAccountUser;

/**
 *
 * MAccountUser 表数据服务层接口
 *
 */
public interface IMAccountUserService extends ISuperService<MAccountUser> {


	void getAccountByUserID(long uid);
}