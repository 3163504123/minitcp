package com.ptb.zeus.common.core.mapper.main;

import com.ptb.zeus.common.core.model.main.MUserService;
import com.baomidou.mybatisplus.mapper.AutoMapper;

import org.apache.ibatis.annotations.Param;

/**
 *
 * MUserService 表数据库控制层接口
 *
 */
public interface MUserServiceMapper extends AutoMapper<MUserService> {


	void incCostNum(@Param("serviceID") long serviceID, @Param("costNum") int costNum);
}