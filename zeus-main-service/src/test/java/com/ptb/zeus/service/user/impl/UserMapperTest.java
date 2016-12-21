package com.ptb.zeus.service.user.impl;

import com.ptb.zeus.service.main.IMToolService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by eric on 16/9/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/core/spring.xml")
public class UserMapperTest {

	@Autowired
	IMToolService imToolService;

	@Test
	public void test() {
		imToolService.testJXA();
	}

}