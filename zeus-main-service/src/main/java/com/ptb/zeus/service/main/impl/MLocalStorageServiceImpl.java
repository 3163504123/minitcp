package com.ptb.zeus.service.main.impl;

import com.alibaba.dubbo.common.utils.IOUtils;
import com.ptb.zeus.service.main.StorageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

	@Override
	public String saveFile(String filename, InputStream inputStream) {

		BufferedOutputStream stream = null;
		try {
			stream = new BufferedOutputStream(new FileOutputStream(new File(filename)));
			IOUtils.write(inputStream, stream);
			stream.close();
		} catch (IOException e) {
			logger.error(String.format("write file error filename %s", filename),e);
		}
		return filename;
	}
}
