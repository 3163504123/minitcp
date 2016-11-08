package com.ptb.zeus.common.core.mapper;

import com.ptb.zeus.common.core.mapper.user.TbUserMapper;
import com.ptb.zeus.common.core.model.user.TbUser;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;

/**
 * Created by eric on 16/9/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/core/spring.xml")
public class UserMapperTest {
	@Autowired
	TbUserMapper tbUserMapper;

	@Test
	public void test() {
		TbUser tbUser1 = new TbUser();
		tbUser1.setNickName("12312312");
		tbUser1.setRemark("2312312");
		tbUser1.setUname("ddddd");
		int insert = tbUserMapper.insert(tbUser1);
		System.out.println("dddd"+insert);
		HashMap<String,Object> objectObjectHashMap = new HashMap<>();
		objectObjectHashMap.put("1","1");
		List<TbUser> tbUsers = tbUserMapper.selectByMap(objectObjectHashMap);

		for (TbUser tbUser : tbUsers) {
			System.out.println(tbUser.getId());
		}
	}

}