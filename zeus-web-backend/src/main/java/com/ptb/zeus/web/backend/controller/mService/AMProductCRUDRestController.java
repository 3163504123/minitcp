package com.ptb.zeus.web.backend.controller.mService;

import com.baomidou.framework.service.IService;
import com.ptb.zeus.common.core.model.main.MProduct;
import com.ptb.zeus.service.main.IMProductService;
import com.ptb.zeus.web.basic.controller.BaseRestCRUDRestController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by eric on 16/10/9.
 */
@Controller
@RequestMapping("admin/api/product")
public class AMProductCRUDRestController extends BaseRestCRUDRestController<MProduct, Long> {
	@Resource
	IMProductService productService;

	@Override
	protected IService<MProduct, Long> getBasicService() {
		return productService;
	}
}
