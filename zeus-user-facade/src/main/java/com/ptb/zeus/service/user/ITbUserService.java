package com.ptb.zeus.service.user;


import com.baomidou.framework.service.ISuperService;
import com.ptb.zeus.common.core.model.user.TbUser;

import java.util.List;

/**
 *
 * TbUser 表数据服务层接口
 *
 */
public interface ITbUserService extends ISuperService<TbUser> {
	List<TbUser> getUserByIdentiy(String s);
}