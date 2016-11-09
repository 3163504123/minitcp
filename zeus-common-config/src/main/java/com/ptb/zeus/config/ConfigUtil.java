package com.ptb.zeus.config;


import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * Hello world!
 */
public class ConfigUtil {
	static Configuration conf;

	static {
		_loadClassPathConfig();
	}


	/**
	 * 获得CONFIG对象，这是当前的CONFIG，不会重新从文件系统中进行读取
	 *
	 * @return the conf
	 */
	public static Configuration getConf() {
		return conf;
	}

	/**
	 * 获得当前最新的配置,会重新加载文件系统的CONFIG
	 *
	 * @return the new conf
	 */
	public static Configuration getNewConf() {
		_loadClassPathConfig();
		return conf;
	}

	/**
	 *  从classpath中加载最新的配置文件
	 */
	private  static void _loadClassPathConfig() {
		try {
			conf = new PropertiesConfiguration("config.properties");
		} catch (Exception e) {
			throw new RuntimeException("Can't find fly.properties From classpath");
		}
	}
}
