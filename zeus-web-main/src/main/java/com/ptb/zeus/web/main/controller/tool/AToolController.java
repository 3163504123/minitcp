package com.ptb.zeus.web.main.controller.tool;

import com.baomidou.framework.service.IService;
import com.ptb.zeus.common.core.model.main.MTool;
import com.ptb.zeus.exception.UserException;
import com.ptb.zeus.service.main.IMToolService;
import com.ptb.zeus.web.basic.controller.ListRestController;
import com.ptb.zeus.web.response.BaseResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 返回工具列表信息.
 */
@RequestMapping("/api/tool")
@RestController
public class AToolController extends ListRestController<MTool,Long> {

	@Autowired
	IMToolService imToolService;


	@RequestMapping("get")
	@ResponseBody
	public Object getEntity(@RequestParam(value = "id",required = false)  Integer id) {
		if(id == null) {
			throw UserException.ArgError;
		}
		MTool mTool = getBasicService().selectById(id);
		if(mTool == null) {
			throw  UserException.ArgError;
		}
		return new BaseResponse<>(getBasicService().selectById(id));
	}


	@RequestMapping("/product")
	@ResponseBody
	public Object getServiceProduct(@RequestParam(value = "id",required = false) Integer id) {
		if(id == null) {
			throw UserException.ArgError;
		}
		return new BaseResponse<>(imToolService.selectProductsByToolID(id));
	}

	@Override
	protected IService<MTool, Long> getBasicService() {
		return this.imToolService;
	}

}

