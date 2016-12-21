package com.ptb.zeus.web.basic.controller;

import com.baomidou.framework.service.IService;
import com.ptb.zeus.web.response.BaseResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;

/**
 * Created by eric on 16/10/9.
 */
public abstract class BaseRestCRUDRestController<R,U extends Serializable> extends ListRestController<R,U>  {
	protected abstract IService<R,U> getBasicService();

	@RequestMapping("add")
	@ResponseBody
	public BaseResponse addEntity(R r) {
		getBasicService().insert(r);
		return BaseResponse.NormalResponse;
	}



	@RequestMapping(value = "update")
	@ResponseBody
	public Object editEntity(R r) {
		getBasicService().updateById(r);
		return BaseResponse.NormalResponse;
	}

	@RequestMapping("del")
	@ResponseBody
	public BaseResponse delEntity(U id) {
		getBasicService().deleteById(id);
		return BaseResponse.NormalResponse;
	}
}

