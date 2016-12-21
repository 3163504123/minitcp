package com.ptb.zeus.common.core.mapper.user;

import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.ptb.zeus.common.core.model.user.TbRole;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * TbRole 表数据库控制层接口
 *
 */
@Component
public interface TbRoleMapper extends AutoMapper<TbRole> {

	List<TbRole> selectByUID(@Param("id") Integer id);
}