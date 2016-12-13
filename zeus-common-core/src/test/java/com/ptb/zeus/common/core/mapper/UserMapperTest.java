package com.ptb.zeus.common.core.mapper;

import com.ptb.zeus.common.core.mapper.user.TbRoleMapper;
import com.ptb.zeus.common.core.mapper.user.TbUserMapper;
import com.ptb.zeus.common.core.model.user.TbUser;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by eric on 16/9/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/core/spring.xml")
public class UserMapperTest {
	@Autowired
	TbRoleMapper tbRoleMapper;


	@Autowired
	TbUserMapper tbUserMapper;

	@Test
	public void test() {
		List<TbUser> tbUsers = tbUserMapper.selectDetail();
		System.out.println(tbUsers);
	}

}