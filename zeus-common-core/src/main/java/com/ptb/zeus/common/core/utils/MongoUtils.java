package com.ptb.zeus.common.core.utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import com.ptb.zeus.config.ConfigUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/10/27
 * @version 1.0.0
 * @description 类的功能
 */
public class MongoUtils {
	private static Logger logger = LoggerFactory.getLogger(MongoUtils.class);


	static Map<String, MongoClient> mongoClientMap = new HashMap<>();
	static MongoClient defaultClient;
	static Integer lock = new Integer(1);

	public static MongoClient i() {
		if(defaultClient == null) {
			synchronized (lock) {
				if (defaultClient == null) {
					String ip = ConfigUtil.getConf().getString("common.mongo.host");
					int port = ConfigUtil.getConf().getInt("common.mongo.port", 27017);
					addOtherInstance("default", ip, port, WriteConcern.ACKNOWLEDGED);
					defaultClient = mongoClientMap.get("default");
				}
			}
		}
		return defaultClient;
	}

	/**
	 * 请确认添加过对应名称的实例，再使用本方法
	 *
	 * @param name the name
	 * @return the mongo client
	 */
	public static MongoClient i(String name) {
		return mongoClientMap.get(name);
	}


	public static void addOtherInstance(String name, String host, int port,WriteConcern writeConcern) {
		MongoClientOptions.Builder options = new MongoClientOptions.Builder();
		options.connectionsPerHost(300);
		options.connectTimeout(30000);
		options.maxWaitTime(5000);
		options.socketTimeout(0);
		options.writeConcern(writeConcern);
		mongoClientMap.put(name, new MongoClient(new ServerAddress(host, port), options.build()));

	}

	public void closeConnection(String name) {
		if (mongoClientMap.get(name) != null) {
			mongoClientMap.get(name).close();
			mongoClientMap.remove(name);
		}
	}

	public void closeAllConnect() {
		mongoClientMap.forEach((k, v) -> {
			v.close();
		});
	}

}
