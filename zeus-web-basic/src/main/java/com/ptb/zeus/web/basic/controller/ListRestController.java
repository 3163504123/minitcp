package com.ptb.zeus.web.basic.controller;

import com.baomidou.framework.service.IService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ptb.zeus.web.basic.request.PageRequest;
import com.ptb.zeus.web.response.BaseResponse;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/12/17
 * @version 1.0.0
 * @description 类的功能
 */
public abstract class ListRestController<R,U> extends BaseRestController {
	protected abstract IService<R,U> getBasicService();

	@RequestMapping("list")
	@ResponseBody
	@Cacheable(value = "default")
	public Object getEntitys(PageRequest request, R r,
	                         @RequestParam(name = "f", defaultValue = "0") int f) {
		Page<R> page = new Page<R>(request.getPage(), request.getRows(), request.getSort());
		page.setAsc(request.isAsc());

		Page<R> tbUserPage = getBasicService().selectPage(page, new EntityWrapper(r));

		HashMap<Object, Object> map = new HashMap<>();
		map.put("rows",tbUserPage.getRecords());
		map.put("total",tbUserPage.getTotal());
		if(f == 1) {
			return new BaseResponse<>(map);
		}
		return map;
	}
}
