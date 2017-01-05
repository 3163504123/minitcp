package com.ptb.zeus.common.core.repository.impl;

import com.ptb.zeus.common.core.repository.StoreRespository;
import com.ptb.zeus.config.ConfigUtil;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
public class LocalStorageRespositoryImpl implements StoreRespository {
	String tbName = "file";
	String database = "fileTest";

	private String localFileStoragePrefix;

	public LocalStorageRespositoryImpl() {
		localFileStoragePrefix = ConfigUtil.getConf().getString("com.zeus.upload.file.path.prefix");
	}

	@Override
	public String saveFile(String fileType, String filename, InputStream inputStream) {
		try {
			String pathFileName = String.format("%s/%d_%s", fileType, System.currentTimeMillis(), filename);
			String fullPathFilename = String.format("%s/%s", localFileStoragePrefix, pathFileName);
			FileUtils.forceMkdirParent(new File(fullPathFilename));
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(fullPathFilename)));
			IOUtils.copyLarge(inputStream, stream);
			stream.close();
			return pathFileName;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public void getFileInputStream(
			String filename, OutputStream outputStream) throws IOException {
		String fullFilePathName = String.format("%s/%s", localFileStoragePrefix, filename);
		FileInputStream fileInputStream = new FileInputStream(fullFilePathName);
		long l = IOUtils.copyLarge(fileInputStream, outputStream);
	}

	@Override
	public InputStream getFileInputStream(String uuid) throws FileNotFoundException {
		String fullFilePathName = String.format("%s/%s", localFileStoragePrefix, uuid);
		FileInputStream fileInputStream = new FileInputStream(fullFilePathName);
		return fileInputStream;

	}
}
