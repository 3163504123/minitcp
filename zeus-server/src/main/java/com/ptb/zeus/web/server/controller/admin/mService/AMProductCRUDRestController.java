package com.ptb.zeus.web.server.controller.admin.mService;

import com.baomidou.framework.service.ISuperService;
import com.ptb.zeus.common.core.model.main.MProduct;
import com.ptb.zeus.service.main.IMProductService;
import com.ptb.zeus.web.server.controller.admin.mBase.BaseRestCRUDRestController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by eric on 16/10/9.
 */
@Controller
@RequestMapping("admin/api/product")
public class AMProductCRUDRestController extends BaseRestCRUDRestController<Integer, MProduct> {
	@Resource
	IMProductService productService;

	@Override
	protected ISuperService<MProduct> getBasicService() {
		return productService;
	}
}
