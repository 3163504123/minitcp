package com.ptb.zeus.service.main.impl;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ptb.zeus.common.core.mapper.main.MAccountUserStatementMapper;
import com.ptb.zeus.common.core.model.main.MAccountUser;
import com.ptb.zeus.common.core.model.main.MAccountUserStatement;
import com.ptb.zeus.service.main.IMAccountUserStatementService;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * MAccountUserStatement 表数据服务层接口实现类
 */
@Service
public class MAccountUserStatementServiceImpl extends SuperServiceImpl<MAccountUserStatementMapper, MAccountUserStatement> implements IMAccountUserStatementService {


	@Override
	public Page<MAccountUserStatement> selectPage(
			Page<MAccountUserStatement> page, MAccountUser mAccountUser, Date startDate,
			Date stopDate) {
		MAccountUserStatement mAccountUserStatement = new MAccountUserStatement(mAccountUser.getId());
		EntityWrapper<MAccountUserStatement>    entityWrapper = new EntityWrapper<>(mAccountUserStatement);
		if (startDate != null && stopDate != null) {
			entityWrapper.where("cTime >= {0} and cTime <= {1}", DateFormatUtils.format(startDate,"yyyy-MM-dd HH:mm:ss"), DateFormatUtils.format(stopDate,"yyyy-MM-dd HH:mm:ss"));
		}
		return this.selectPage(page, entityWrapper);
	}
}