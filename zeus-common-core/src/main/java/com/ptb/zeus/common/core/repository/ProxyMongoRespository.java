package com.ptb.zeus.common.core.repository;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.ptb.zeus.common.core.model.main.MProxy;
import com.ptb.zeus.common.core.utils.MongoUtils;

import org.apache.http.HttpHost;
import org.apache.http.client.fluent.Request;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/9
 * @version 1.0.0
 * @description 类的功能
 */
public class ProxyMongoRespository implements ProxyRespository {
	static Logger logger = LoggerFactory.getLogger(ProxyMongoRespository.class);

	String tbName = "freeProxy";
	String database = "minitcp";

	private MongoCollection<Document> coll() {
		return MongoUtils.i().getDatabase(database).getCollection(tbName);
	}

	public List<MProxy> selectValidHost(int limit) {
		List<MProxy> list = new LinkedList<>();

		FindIterable<Document> documents = coll().find().sort(Sorts.descending("checkTime")).limit(limit);

		for (Document doc : documents) {
			list.add(JSON.parseObject(doc.toJson(), MProxy.class));
		}

		return list;
	}

	public void add(MProxy mProxy) {
		Document proxyDOC = Document.parse(JSON.toJSONString(mProxy));
		proxyDOC.put("_id", mProxy.getIp());
		proxyDOC.put("addTime", System.currentTimeMillis());
		coll().insertOne(proxyDOC);
	}

	public void del(String id) {
		coll().deleteOne(Filters.eq("_id", id));
	}

	/**
	 * 更新检查时间.
	 *
	 * @param id the id
	 */
	public void updateCheckTime(String id) {
		coll().updateOne(Filters.eq("_id", id), new Document("checkTime", System.currentTimeMillis()));
	}

	public void checkAndDelInvalidProxy(int threadNum) {
		ExecutorService executorService = Executors.newFixedThreadPool(threadNum);

		FindIterable<Document> documents = coll().find();
		for (Document document : documents) {
			String host = document.getString("ip");
			Integer port = document.getInteger("port");
			executorService.submit(() -> {
				if (isGoodProxy(host, port)) {
					logger.info("check mProxy {}:{} {} {} [good]", Arrays.asList(host, port,document.getString("type"),document.getString("anonymity")));
					updateCheckTime(host);
				} else {
					logger.info("check mProxy {}:{} [bad]", host, port);
					del(host);
				}
			});
		}
	}

	@Override
	public void genNewProxy() {
		saveNewProxyFromGOUBANJIA();
	}

	@Override
	public List<MProxy> getProxyFromRawProxyLib(
			int size, MProxy mProxy) {
		return null;
	}

	private void saveNewProxyFromGOUBANJIA() {
		//刷入新的代理
		String requestURL = "http://api.goubanjia.com/api/get.shtml?order=87e52437da10c3071804f3b6a3b4806a&num=100&carrier=0&protocol=0&an1=1&an2=2&an3=3&sp1=1&sp2=2&sp3=3&sort=1&system=1&distinct=0&rettype=0&seprator=%0D%0A&f_loc=1&f_anoy=1&f_speed=1";
		//删除数据库中老的过期代理
		try {

			JSONObject jsonObject = JSON.parseObject(Request.Get(requestURL).execute().returnContent().toString());
			JSONArray data = jsonObject.getJSONArray("data");

			for (int i = 0; i < data.size(); i++) {
				try {
					MProxy mProxy = data.getObject(i, MProxy.class);
					this.add(mProxy);
					logger.info("add mProxy [{}:{}]", mProxy.getIp(), mProxy.getPort());
				} catch (Exception e) {

				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Boolean isGoodProxy(String host, int port) {
		int statusCode = 0;
		try {
			statusCode = Request.Get("http://cdn.bootcss.com/moment.js/2.15.0/locale/es.js").
					viaProxy(new HttpHost(host, port)).connectTimeout(1000).socketTimeout(1000).execute().returnResponse().getStatusLine().getStatusCode();
			if (statusCode != 200) {
				return false;
			} else {
				return true;
			}
		} catch (IOException e) {
			return false;
		}
	}

	public static void main(String[] args) {
		ProxyMongoRespository proxyMongoRespository = new ProxyMongoRespository();
		proxyMongoRespository.saveNewProxyFromGOUBANJIA();
		proxyMongoRespository.checkAndDelInvalidProxy(5);
	}
}
