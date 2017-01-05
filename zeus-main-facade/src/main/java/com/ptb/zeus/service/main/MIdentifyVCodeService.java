package com.ptb.zeus.service.main;

import com.ptb.zeus.common.core.model.main.IdentifyVCodeResult;
import com.ptb.zeus.common.core.model.main.ReginizeHiistory;

import java.io.InputStream;
import java.util.List;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/15
 * @version 1.0.0
 * @description 类的功能
 */
public interface MIdentifyVCodeService {

	IdentifyVCodeResult regnize(String originalFilename, InputStream inputStream, String key);

	List<ReginizeHiistory> selecltIdentifyVCodeHistory(int page, int rows, long uid);
}
