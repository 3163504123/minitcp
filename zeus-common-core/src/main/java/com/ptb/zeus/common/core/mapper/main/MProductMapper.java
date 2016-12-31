package com.ptb.zeus.common.core.mapper.main;

import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.ptb.zeus.common.core.model.main.MProduct;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * MProduct 表数据库控制层接口
 *
 */
@Repository
public interface MProductMapper extends AutoMapper<MProduct> {



	List<MProduct> selectByProductContent(@Param("toolID") Integer toolID);
}