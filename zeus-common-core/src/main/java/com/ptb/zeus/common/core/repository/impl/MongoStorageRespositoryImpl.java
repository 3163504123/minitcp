package com.ptb.zeus.common.core.repository.impl;

import com.mongodb.client.MongoDatabase;
import com.ptb.zeus.common.core.repository.StoreRespository;
import com.ptb.zeus.common.core.utils.MongoUtils;

import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/27
 * @version 1.0.0
 * @description 类的功能
 */
@Component
public class MongoStorageRespositoryImpl extends AbstractMongoRespository implements StoreRespository {
	String tbName = "file";
	String database = "fileTest";

	public String saveFile(String fileType, String filename, InputStream inputStream) {
		return uploadFileToGridFS(filename,inputStream);
	}

	@Override
	public void getFileInputStream(String filename, OutputStream outputStream) throws FileNotFoundException {
		downloadFile(filename,outputStream);

	}

	@Override
	public InputStream getFileInputStream(String uuid) {
		return getDownloadInputStream(uuid);
	}

	@Override
	protected MongoDatabase getDatabase() {
		return MongoUtils.i().getDatabase("file");
	}
}
