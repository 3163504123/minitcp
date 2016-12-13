package com.ptb.zeus.web.basic.controller;

import com.baomidou.framework.service.IService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ptb.zeus.web.controller.BaseRestController;
import com.ptb.zeus.web.response.BaseResponse;
import com.ptb.zeus.web.basic.request.PageRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by eric on 16/10/9.
 */
public abstract class BaseRestCRUDRestController<R,U> extends BaseRestController {
	protected abstract IService<R,U> getBasicService();

	@RequestMapping("add")
	@ResponseBody
	public BaseResponse addEntity(R r) {
		getBasicService().insert(r);
		return BaseResponse.NormalResponse;
	}

	@RequestMapping("list")
	@ResponseBody
	public List<R> getEntitys(PageRequest request, R r) {
		Page<R> page = new Page<R>(request.getPage(), request.getRows(), request.getSort());
		page.setAsc(request.isAsc());

		EntityWrapper<R> ew = new EntityWrapper(r);
		Page<R> tbUserPage = getBasicService().selectPage(page, ew);

		return tbUserPage.getRecords();
	}

	@RequestMapping(value = "update")
	@ResponseBody
	public Object editEntity(R r) {
		getBasicService().updateById(r);
		return BaseResponse.NormalResponse;
	}

	@RequestMapping("del")
	@ResponseBody
	public BaseResponse delEntity(U u) {
		getBasicService().deleteById(u);
		return BaseResponse.NormalResponse;
	}
}

