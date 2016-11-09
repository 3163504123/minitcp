package com.ptb.zeus.common.core.repository;

import com.alibaba.fastjson.JSON;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.ptb.zeus.common.core.model.main.MProxy;
import com.ptb.zeus.common.core.utils.MongoUtils;

import org.bson.Document;

import java.util.LinkedList;
import java.util.List;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/9
 * @version 1.0.0
 * @description 类的功能
 */
public class ProxyMongoRespository {

	String tbName = "freeProxy";
	String database = "minitcp";

	private MongoCollection<Document> coll() {
		return MongoUtils.i().getDatabase(database).getCollection(tbName);
	}
	public List<MProxy> select(MProxy mProxy, int offset, int limit) {
		Document parse = Document.parse(JSON.toJSONString(mProxy));
		FindIterable<Document> documents = coll().find(parse);
		if(limit > 200) {
			limit = 200;
		}
		FindIterable<Document> docs= documents.skip(offset).limit(limit);
		List<MProxy> list = new LinkedList<>();
		for (Document doc : docs) {
				list.add(JSON.parseObject(doc.toJson(),MProxy.class));
		}
		return list;
	}

}
