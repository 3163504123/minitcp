package com.ptb.zeus.common.core.repository;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/9
 * @version 1.0.0
 * @description 类的功能
 */
public interface StoreRespository {

	String saveFile(String fileType, String fileType1, InputStream inputStream);

	InputStream getFileInputStream(String pathFileName) throws FileNotFoundException;
}
