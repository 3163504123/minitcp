package com.ptb.zeus.common.core.mapper;

import com.ptb.zeus.common.core.mapper.main.MToolMapper;
import com.ptb.zeus.common.core.mapper.main.MToolSetMapper;
import com.ptb.zeus.common.core.model.main.MTool;
import com.ptb.zeus.common.core.model.main.MToolSet;

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
public class VedioMapperTest {
	@Autowired
	MToolSetMapper mToolSetMapper;

	@Autowired
	MToolMapper mToolMapper;
	@Test
	public void test() {
		List<MToolSet> mToolSets = mToolSetMapper.selectList(null);
		System.out.println(mToolSets.size());
		List<MTool> mTools = mToolMapper.selectList(null);
		System.out.println(mTools.size());
	/*	List<MToolSet> mToolSets = mToolSetMapper.selectList(null);
		System.out.println(mToolSets.size());*/
	}

}