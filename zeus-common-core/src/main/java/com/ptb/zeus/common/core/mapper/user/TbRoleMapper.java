package com.ptb.zeus.common.core.mapper.user;

import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.ptb.zeus.common.core.model.user.TbRole;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * TbRole 表数据库控制层接口
 *
 */
@Component
public interface TbRoleMapper extends AutoMapper<TbRole> {

	@Select("select a.* from tb_role a join tb_user_role b on b.user_id = #{id}")
	List<TbRole> selectByUID(@Param("id") Integer id);
}