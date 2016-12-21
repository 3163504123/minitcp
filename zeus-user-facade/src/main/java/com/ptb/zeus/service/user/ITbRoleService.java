package com.ptb.zeus.service.user;

import com.ptb.zeus.common.core.model.user.TbRole;
import com.baomidou.framework.service.ISuperService;

import java.util.List;

/**
 *
 * TbRole 表数据服务层接口
 *
 */
public interface ITbRoleService extends ISuperService<TbRole> {

	List<TbRole> selectByUID(Long id);
}