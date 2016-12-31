package com.ptb.zeus.common.core.repository.impl;

import com.alibaba.fastjson.JSON;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.ptb.zeus.common.core.model.news.MNews;
import com.ptb.zeus.common.core.repository.MNewsRespository;
import com.ptb.zeus.common.core.utils.MongoUtils;

import org.apache.commons.codec.digest.DigestUtils;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/12/31
 * @version 1.0.0
 * @description 类的功能
 */
@Component
public class MNewsRespositoryImpl implements MNewsRespository {
	private static Logger logger = LoggerFactory.getLogger(MNewsRespositoryImpl.class);

	String tbName = "news";
	String database = "minitcp";

	private MongoCollection<Document> coll() {
		return MongoUtils.i().getDatabase(database).
				getCollection(tbName);
	}

	public Document toDocument(Object object) {
		return Document.parse(JSON.toJSONString(object));
	}

	public <T> T toObject(Document doc, Class<T> t) {
		return JSON.parseObject(JSON.toJSONString(doc), t);
	}


	MongoCollection<Document> cMNews = coll();

	@Override
	public List<MNews> getMNewssByTs(long st, int limit) {
		FindIterable<Document> postTime = cMNews.find(Filters.lt("postTime", st)).sort(Sorts.descending("postTime")).limit(limit);
		List<MNews> mNewses = new LinkedList<>();
		for (Document document : postTime) {
			mNewses.add(toObject(document, MNews.class));
		}
		return mNewses;
	}

	@Override
	public void addMNews(MNews blog) {
		blog.setId(DigestUtils.sha1Hex(blog.getSourceUrl()));
		Document document = toDocument(blog);
		document.put("_id", blog.getId());
		cMNews.insertOne(document);
	}

	@Override
	public void delMNewsById(String blogId) {
		cMNews.deleteOne(Filters.eq("_id", blogId));
	}

	@Override
	public MNews getMNewsById(String blogId) {
		Document doc = cMNews.find(Filters.eq("_id", blogId)).first();
		return toObject(doc, MNews.class);
	}
}
