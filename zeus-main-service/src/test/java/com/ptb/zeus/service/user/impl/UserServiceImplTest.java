package com.ptb.zeus.service.user.impl;

import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

/**
 * Created by eric on 16/8/19.
 */
@ComponentScan(basePackages = {"com.ptb.zeus"})
public class UserServiceImplTest {
	public static void main(String[] args) throws IOException {
/*		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:META-INF/META-INF*//*.xml");
		context.start();
		System.out.println("服务已经启动...");
		System.in.read();*/
		com.alibaba.dubbo.container.Main.main(args);
	}

}