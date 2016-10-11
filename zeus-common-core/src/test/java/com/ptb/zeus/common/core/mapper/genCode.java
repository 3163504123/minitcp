package com.ptb.zeus.common.core.mapper;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.ConfigGenerator;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * Created by eric on 16/9/27.
 */
public class genCode {
	public static void main(String[] args) {
		ConfigGenerator cg = new ConfigGenerator();

		// 配置 MySQL 连接
		cg.setDbDriverName("com.mysql.jdbc.Driver");
		cg.setDbUser("root");
		cg.setDbPassword("");
		cg.setDbUrl("jdbc:mysql://127.0.0.1:3306/templates?characterEncoding=utf8");

		// 配置包名

		cg.setEntityPackage("com.ptb.zeus.common.core.model");
		cg.setMapperPackage("com.ptb.zeus.common.core.mapper");
		cg.setServicePackage("com.ptb.zeus.common.core.service");
		cg.setXmlPackage("mapper");
		cg.setServiceImplPackage("com.ptb.zeus.common.core.service.impl");

/*		cg.setConfigIdType(ConfigIdType.LONG);*/
		cg.setIdType(IdType.AUTO);
		// 配置保存路径
		cg.setSaveDir("./generate");

		// 其他参数请根据上面的参数说明自行配置，当所有配置完善后，运行AutoGenerator.run()方法生成Code
		// 生成代码
		AutoGenerator.run(cg);

		Page page = new Page(1, 2);

	}
}
