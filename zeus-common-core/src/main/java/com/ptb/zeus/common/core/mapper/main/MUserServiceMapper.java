package com.ptb.zeus.common.core.mapper.main;

import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.ptb.zeus.common.core.model.main.MUserService;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * MUserService 表数据库控制层接口
 *
 */
@Repository
public interface MUserServiceMapper extends AutoMapper<MUserService> {

	void incCostNum(@Param("serviceID") long serviceID, @Param("costNum") int costNum);
}