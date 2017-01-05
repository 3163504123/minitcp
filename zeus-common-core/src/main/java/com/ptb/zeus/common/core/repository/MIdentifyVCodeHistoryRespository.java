package com.ptb.zeus.common.core.repository;

import com.ptb.zeus.common.core.model.main.ReginizeHiistory;

import java.util.List;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2017/1/4
 * @version 1.0.0
 * @description 类的功能
 */
public interface MIdentifyVCodeHistoryRespository {
	List<ReginizeHiistory> selecltIdentifyVCodeHistory(int page, int rows, long uid);
	boolean addIdentifyVCodeHistory(ReginizeHiistory reginizeHiistory);
}
