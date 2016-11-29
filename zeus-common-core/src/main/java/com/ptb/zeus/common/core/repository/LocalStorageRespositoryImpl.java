package com.ptb.zeus.common.core.repository;

import com.ptb.zeus.config.ConfigUtil;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/27
 * @version 1.0.0
 * @description 类的功能
 */
public class LocalStorageRespositoryImpl implements StoreRespository {
	String tbName = "file";
	String database = "fileTest";

/*	private MongoDatabase db() {
		return MongoUtils.i().getDatabase("fileTest");
	}

	private void upload(){
		GridFSBucket gridFSBucket = GridFSBuckets.create(db());
		try {
			InputStream streamToUploadFrom = new FileInputStream(new File("/Users/eric/wk/self/java/zeus-parent/zeus-parent.iml"));
			GridFSUploadOptions gridFSUploadOptions = new GridFSUploadOptions()
					.chunkSizeBytes(1024)
					.metadata(new Document("type", "presentation"));
			ObjectId fileId = gridFSBucket.uploadFromStream("mongodb-tutorial", streamToUploadFrom, gridFSUploadOptions);
			System.out.println(fileId);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		LocalStoreRespositoryImpl mongoRespository = new LocalStoreRespositoryImpl();
		mongoRespository.test();
	}*/

	private String localFileStoragePrefix;

	public LocalStorageRespositoryImpl() {
		localFileStoragePrefix = ConfigUtil.getConf().getString("com.zeus.upload.file.path.prefix");
	}

	@Override
	public String saveFile(String fileType, String filename, InputStream inputStream) {
		try {
			String pathFileName = String.format("%s/%d_%s", fileType, System.currentTimeMillis(), filename);
			String fullPathFilename = String.format("%s/%s",localFileStoragePrefix,pathFileName);
			FileUtils.forceMkdirParent(new File(fullPathFilename));
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(
					fullPathFilename)));
			IOUtils.copyLarge(inputStream, stream);
			stream.close();
			return pathFileName;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public InputStream getFileInputStream(String pathFileName) throws FileNotFoundException {
		String fullFilePathName = String.format("%s/%s", localFileStoragePrefix, pathFileName);
		return new FileInputStream(fullFilePathName);
	}
}
