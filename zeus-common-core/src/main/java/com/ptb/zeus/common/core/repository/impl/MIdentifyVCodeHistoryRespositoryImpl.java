package com.ptb.zeus.common.core.repository.impl;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.ptb.zeus.common.core.model.main.ReginizeHiistory;
import com.ptb.zeus.common.core.repository.MIdentifyVCodeHistoryRespository;
import com.ptb.zeus.common.core.utils.MongoUtils;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2017/1/4
 * @version 1.0.0
 * @description 类的功能
 */
@Component
public class MIdentifyVCodeHistoryRespositoryImpl extends AbstractMongoRespository implements MIdentifyVCodeHistoryRespository {
	private static Logger logger = LoggerFactory.getLogger(MIdentifyVCodeHistoryRespositoryImpl.class);


	String tbName = "identifyHistory";
	String database = "minitcp";

	@Value("#{com.zeus.static.resource.url.prefix}")
	String filePerfixPath ;

	private MongoCollection<Document> coll() {
		return MongoUtils.i().getDatabase(database).
				getCollection(tbName);
	}


	@Override
	protected MongoDatabase getDatabase() {
		return MongoUtils.i().getDatabase(database);
	}


	@Override
	public List<ReginizeHiistory> selecltIdentifyVCodeHistory(
			int page, int rows, long uid) {
		Bson filters = Filters.eq("uid", uid);
		FindIterable<Document> documents = coll().find(filters).skip(rows * (page - 1)).limit(rows);

		List<ReginizeHiistory> list = new ArrayList<>();
		for (Document document : documents) {
			ReginizeHiistory reginizeHiistory = toObject(document, ReginizeHiistory.class);
			reginizeHiistory.setImgUrl(String.format("%s/%s",filePerfixPath,reginizeHiistory.getImgUrl()));
		}
		return list;
	}

	@Override
	public boolean addIdentifyVCodeHistory(
			ReginizeHiistory reginizeHiistory) {
		Document document = toDocument(reginizeHiistory);
		coll().insertOne(document);
		return true;
	}


}
