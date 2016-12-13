package com.ptb.zeus.web.main.controller.tool;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ptb.zeus.common.core.model.main.MTool;
import com.ptb.zeus.service.main.IMToolService;
import com.ptb.zeus.web.controller.BaseRestController;
import com.ptb.zeus.web.main.request.PageRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Am proxy controller.
 */
@RequestMapping("/api/tool")
@RestController
public class AToolController extends BaseRestController {

	@Autowired
	IMToolService imToolService;
	@RequestMapping("list")
	@ResponseBody
	public List<MTool> getEntitys(PageRequest request, MTool r,@RequestParam(value = "type",required = false) String type) {
		Page<MTool> page = new Page<MTool>(request.getPage(), request.getRows(), request.getSort());
		page.setAsc(request.isAsc());
		EntityWrapper<MTool> ew;
		if(type != null) {
			ew = new EntityWrapper(r).where("type like {0}", type);
		}else{
			ew = new EntityWrapper(r);
		}
		Page<MTool> tbUserPage = imToolService.selectPage(page, ew);
		return tbUserPage.getRecords();
	}
}

