package com.ptb.zeus.common.core.mapper.user;

import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.ptb.zeus.common.core.model.user.TbUser;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * TbUser 表数据库控制层接口
 */
@Component
public interface TbUserMapper extends AutoMapper<TbUser> {

	List<TbUser> selectDetail();

}