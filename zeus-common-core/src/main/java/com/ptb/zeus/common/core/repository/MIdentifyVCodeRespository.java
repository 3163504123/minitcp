package com.ptb.zeus.common.core.repository;

import com.ptb.zeus.common.core.model.main.IdentifyVCodeResult;

import java.io.InputStream;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/12/30
 * @version 1.0.0
 * @description 类的功能
 */
public interface MIdentifyVCodeRespository {

	IdentifyVCodeResult regnize(InputStream fileInputStream);
}
