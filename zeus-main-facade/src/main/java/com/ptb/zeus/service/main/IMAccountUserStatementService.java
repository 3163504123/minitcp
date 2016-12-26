package com.ptb.zeus.service.main;

import com.baomidou.framework.service.ISuperService;
import com.baomidou.mybatisplus.plugins.Page;
import com.ptb.zeus.common.core.model.main.MAccountUser;
import com.ptb.zeus.common.core.model.main.MAccountUserStatement;

import java.util.Date;

/**
 *
 * MAccountUserStatement 表数据服务层接口
 *
 */
public interface IMAccountUserStatementService extends ISuperService<MAccountUserStatement> {
	Page<MAccountUserStatement> selectPage(
			Page<MAccountUserStatement> page, MAccountUser mAccountUser, Date startDate,
			Date stopDate);
}