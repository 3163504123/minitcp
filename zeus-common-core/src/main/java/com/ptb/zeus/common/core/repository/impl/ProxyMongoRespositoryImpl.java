package com.ptb.zeus.common.core.repository.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.ptb.zeus.common.core.model.main.MProxy;
import com.ptb.zeus.common.core.model.main.ProxyFilter;
import com.ptb.zeus.common.core.repository.ProxyRespository;
import com.ptb.zeus.common.core.utils.MongoUtils;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.client.fluent.Request;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/9
 * @version 1.0.0
 * @description 类的功能
 */
@Component
public class ProxyMongoRespositoryImpl implements ProxyRespository {
	static Logger logger = LoggerFactory.getLogger(ProxyMongoRespositoryImpl.class);

	String tbName = "freeProxy";
	String database = "minitcp";
	static ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

	enum E_PROXY_TYPE{
		E_PROXY_TYPE_FREE,
		E_PROXY_TYPE_GOOD,
		E_PROXY_TYPE_PERFECT,
		E_PROXY_TYPE_DYNAMIC,
	}

	public ProxyMongoRespositoryImpl() {

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
		coll().updateOne(Filters.eq("_id", id), new Document().append("$set",new Document("checkTime", System.currentTimeMillis())));
	}


	public synchronized void   checkAndDelInvalidProxy(int threadNum, boolean isAsync) {

		FindIterable<Document> documents = coll().find(Filters.lt("checkTime",System.currentTimeMillis()- TimeUnit.MINUTES.toMillis(5)));
		for (Document document : documents) {
			String host = document.getString("ip");
			Integer port = document.getInteger("port");
			executorService.submit(() -> {
				if (isGoodProxy(host, port)) {
					logger.info("check filter {}:{} {} {} [good]", Arrays.asList(host, port, document.getString("type"), document.getString("anonymity")).toArray());
					updateCheckTime(host);
				} else {
					logger.info("check filter {}:{} [bad]", host, port);
					del(host);
				}
			});
		}
		if(!isAsync) {
			while(true) {
				if(executorService.getActiveCount() == 0) {
					break;
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("正在进行检查代理可用型");
			}
		}
	}

	@Override
	public void genNewProxy() {
		saveNewProxyFromGOUBANJIA();
	}

	@Override
	public List<MProxy> getFreeProxy(
			int size, ProxyFilter mProxy) {
		return selectProxys(E_PROXY_TYPE.E_PROXY_TYPE_FREE,mProxy,size);
	}

	@Override
	public List<MProxy> getGoodProxys(int size, ProxyFilter mProxy) {
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
					logger.info("add filter [{}:{}]", mProxy.getIp(), mProxy.getPort());
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


	public List<MProxy> selectProxys(E_PROXY_TYPE type, ProxyFilter filter, int limit) {
		List<MProxy> list = new LinkedList<>();
		FindIterable<Document> documents = null;
		List<Bson> filters = new LinkedList<Bson>();
		if(filter != null) {
			if (filter.getAnonymity() != null && filter.getAnonymity().size() > 0) {
				filters.add(Filters.in("anonymity", filter.getAnonymity()));
			}

			if (filter.getType() != null && filter.getType().size() > 0) {
				filters.add(Filters.in("type", filter.getType()));
			}

			if (filter.getPort() != null && filter.getPort().size() > 0) {
				filters.add(Filters.in("port", filter.getPort()));
			}

			if (StringUtils.isNoneBlank(filter.getCountry())) {
				if(filter.getCountry().equals("外国")) {
					filters.add(Filters.not(Filters.eq("country","中国")));
				}else{
					filters.add(Filters.eq("country","中国"));
				}
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

}
