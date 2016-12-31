package com.ptb.zeus.common.core.mapper;

import com.ptb.zeus.common.core.repository.MIdentifyVCodeRespository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by eric on 16/9/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/core/spring.xml")
public class VedioMapperTest {
	@Autowired
	MIdentifyVCodeRespository identifyVCodeRespository;


}