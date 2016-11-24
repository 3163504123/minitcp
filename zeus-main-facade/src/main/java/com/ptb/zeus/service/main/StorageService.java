package com.ptb.zeus.service.main;

import java.io.InputStream;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/15
 * @version 1.0.0
 * @description 类的功能
 */
public interface StorageService {
	String saveFile(String filename, InputStream inputStream);
}
