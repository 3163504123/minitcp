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

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.client.fluent.Request;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
	static ExecutorService executorService = Executors.newFixedThreadPool(5);

	enum E_PROXY_TYPE{
		E_PROXY_TYPE_FREE,
		E_PROXY_TYPE_GOOD,
		E_PROXY_TYPE_PERFECT,
		E_PROXY_TYPE_DYNAMIC,
	}

	public ProxyMongoRespository() {

	}

	private MongoCollection<Document> coll() {
		return MongoUtils.i().getDatabase(database).getCollection(tbName);
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


	public synchronized void   checkAndDelInvalidProxy(int threadNum) {

		FindIterable<Document> documents = coll().find(Filters.lt("checkTime",System.currentTimeMillis()- TimeUnit.MINUTES.toMillis(5)));
		for (Document document : documents) {
			String host = document.getString("ip");
			Integer port = document.getInteger("port");
			executorService.submit(() -> {
				if (isGoodProxy(host, port)) {
					logger.info("check mProxy {}:{} {} {} [good]", Arrays.asList(host, port, document.getString("type"), document.getString("anonymity")).toArray());
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
	public List<MProxy> getFreeProxy(
			int size, MProxy mProxy) {
		return selectProxys(E_PROXY_TYPE.E_PROXY_TYPE_FREE,mProxy,size);
	}

	@Override
	public List<MProxy> getGoodProxys(int size, MProxy mProxy) {
		return selectProxys(E_PROXY_TYPE.E_PROXY_TYPE_GOOD,mProxy,size);
	}

	@Override
	public List<MProxy> getPerfectProxys(int size) {
		return selectProxys(E_PROXY_TYPE.E_PROXY_TYPE_PERFECT,null,size);
	}

	@Override
	public MProxy getDynamicProxy(String serviceID) {
		Document key = coll().find(new Document("key", serviceID)).first();
		if(key == null) {
			return null;
		}else{
			return JSON.parseObject(JSON.toJSONString(key), MProxy.class);
		}
	}

	@Override
	public void changeDynamicProxy(String key) {
		MProxy dynamicProxy = getDynamicProxy(key);
		//to change ip

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


	public List<MProxy> selectProxys(E_PROXY_TYPE type, MProxy mProxy,int limit) {
		List<MProxy> list = new LinkedList<>();
		FindIterable<Document> documents = null;
		List<Bson> filters = new LinkedList<Bson>();
		if(mProxy != null) {
			if (StringUtils.isNoneBlank(mProxy.getAnonymity())) {
				filters.add(Filters.eq("anonymity", mProxy.getAnonymity()));
			}

			if (StringUtils.isNoneBlank(mProxy.getProvince())) {
				filters.add(Filters.eq("province", mProxy.getProvince()));
			}

			if (StringUtils.isNoneBlank(mProxy.getCity())) {
				filters.add(Filters.eq("city", mProxy.getCity()));
			}

			if (StringUtils.isNoneBlank(mProxy.getType())) {
				filters.add(Filters.eq("type", mProxy.getType()));
			}

			if(StringUtils.isNoneBlank(mProxy.getKey())) {
				filters.add(Filters.eq("key", mProxy.getKey()));
			}
			if (mProxy.getPort() > 0) {
				filters.add(Filters.eq("port", mProxy.getPort()));
			}
		}
		switch (type) {
			case E_PROXY_TYPE_FREE:
				filters.add(Filters.ne("isDy", 1));
				documents = coll().find().
						sort(Sorts.descending("addTime")).filter(Filters.and(filters)).limit(limit);
				break;
			case E_PROXY_TYPE_GOOD:
				filters.add(Filters.ne("isDy", 1));
				documents = coll().find().
						sort(Sorts.descending("checkTime")).filter(Filters.and(filters)).limit(limit);
				break;
			case E_PROXY_TYPE_PERFECT:
				documents = coll().find().
						sort(Sorts.descending("checkTime")).filter(Filters.eq("isDy", 1)).limit(limit);
				break;
		}

		if(documents != null) {
			for (Document doc : documents) {
				list.add(JSON.parseObject(JSON.toJSONString(doc), MProxy.class));
			}
		}

		return list;
	}

	public static void main(String[] args) {
		ProxyMongoRespository proxyMongoRespository = new ProxyMongoRespository();
/*		proxyMongoRespository.saveNewProxyFromGOUBANJIA();*/
		proxyMongoRespository.checkAndDelInvalidProxy(5);
		MProxy mProxy = new MProxy();
		mProxy.setAnonymity("透明");
		mProxy.setType("http");
		List<MProxy> freeProxy = proxyMongoRespository.getGoodProxys(1,null);
		System.out.println(JSON.toJSONString(freeProxy));
	}
}
