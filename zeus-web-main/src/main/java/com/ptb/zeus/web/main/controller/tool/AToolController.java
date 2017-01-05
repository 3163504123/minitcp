package com.ptb.zeus.web.main.controller.tool;

import com.baomidou.mybatisplus.plugins.Page;
import com.ptb.zeus.common.core.model.main.MTool;
import com.ptb.zeus.exception.UserException;
import com.ptb.zeus.service.main.IMToolService;
import com.ptb.zeus.web.basic.controller.BaseRestController;
import com.ptb.zeus.web.basic.request.PageRequest;
import com.ptb.zeus.web.response.BaseResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 返回工具列表信息.
 */
@RequestMapping("/api/tool")
@RestController
public class AToolController extends BaseRestController {

	@Autowired
	IMToolService imToolService;


	@RequestMapping("get")
	@ResponseBody
	public Object getEntity(@RequestParam(value = "id",required = false)  Integer id) {
		if(id == null) {
			throw UserException.ArgError;
		}
		MTool mTool = imToolService.selectById(id);
		if(mTool == null) {
			throw  UserException.ArgError;
		}
		return new BaseResponse<>(imToolService.selectById(id));
	}


	@RequestMapping("/product")
	@ResponseBody
	public Object getServiceProduct(@RequestParam(value = "id",required = false) Integer id) {
		if(id == null) {
			throw UserException.ArgError;
		}
		return new BaseResponse<>(imToolService.selectProductsByToolID(id));
	}


	@RequestMapping("list")
	@ResponseBody
	public Object getEntitys(PageRequest request, MTool r,
	                         @RequestParam(name = "f", defaultValue = "0") int f) {
		Page<MTool> page = new Page<MTool>(request.getPage(), request.getRows(), request.getSort());
		page.setAsc(request.isAsc());

		Page<MTool> tbUserPage = imToolService.selectAllByPage(page);

		HashMap<Object, Object> map = new HashMap<>();
		map.put("rows",tbUserPage.getRecords());
		map.put("total",tbUserPage.getTotal());
		if(f == 1) {
			return new BaseResponse<>(map);
		}
		return map;
	}

}

