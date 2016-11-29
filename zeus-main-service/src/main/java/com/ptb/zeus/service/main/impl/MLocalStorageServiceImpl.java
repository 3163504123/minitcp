package com.ptb.zeus.service.main.impl;

import com.ptb.zeus.common.core.repository.LocalStorageRespositoryImpl;
import com.ptb.zeus.common.core.repository.StoreRespository;
import com.ptb.zeus.service.main.StorageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/15
 * @version 1.0.0
 * @description 类的功能
 */
@Component
public class MLocalStorageServiceImpl implements StorageService {
	private static Logger logger = LoggerFactory.getLogger(MLocalStorageServiceImpl.class);
	StoreRespository storeRespository = new LocalStorageRespositoryImpl();
	@Override
	public String saveFile(String fileType, String filename, InputStream inputStream) {
		return storeRespository.saveFile(fileType, filename, inputStream);
	}

	@Override
	public InputStream getFileInputStream(String pathFileName) throws FileNotFoundException {
		return storeRespository.getFileInputStream(pathFileName);
	}
}
