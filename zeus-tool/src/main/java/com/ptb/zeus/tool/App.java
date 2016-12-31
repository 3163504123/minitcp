package com.ptb.zeus.tool;

import com.ptb.zeus.service.main.IMProxyService;
import com.ptb.zeus.service.main.INewsService;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
@ComponentScan("com.ptb.zeus")
public class App {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:/META-INF/spring/core/spring.xml");


		CommandLineParser parser = new DefaultParser();
		Options options = new Options();
		options.addOption("h", "help", false, "显示帮助 ");
		options.addOption("news", true, "爬取SOGOU信息");
		options.addOption("fetchProxy", false, "获取最新代理");
		options.addOption("checkProxy", false, "检查代理有效性");

		CommandLine commandLine;
		HelpFormatter formatter = new HelpFormatter();
		try {
			commandLine = parser.parse(options, args);
		} catch (Exception e) {
			formatter.printHelp("usage:", options);
			return;
		}

		if (commandLine.hasOption('h')) {
			formatter.printHelp("usage:", options);
			System.exit(-1);
		}
		if(commandLine.hasOption("fetchProxy")) {
			ProxyTool.newProxy((IMProxyService) applicationContext.getBean(IMProxyService.class));
			System.exit(0);
		}

		if(commandLine.hasOption("checkProxy")) {
			ProxyTool.checkProxy((IMProxyService) applicationContext.getBean(IMProxyService.class));
			System.exit(0);
		}

		if(commandLine.hasOption("news")) {
			NewsTool.getNewNews(applicationContext.getBean(INewsService.class));
			System.exit(0);
		}

		formatter.printHelp("usage:", options);
		System.exit(-1);



	}

}
