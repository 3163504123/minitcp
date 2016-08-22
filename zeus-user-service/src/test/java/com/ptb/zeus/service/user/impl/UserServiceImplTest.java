package com.ptb.zeus.service.user.impl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by eric on 16/8/19.
 */
public class UserServiceImplTest {
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/*.xml");
		context.start();
		System.out.println("服务已经启动...");
		System.in.read();
	}

}