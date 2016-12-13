package com.ptb.zeus.web.backend.controller.mUser;

import com.baomidou.framework.service.ISuperService;
import com.ptb.zeus.common.core.model.user.TbUser;
import com.ptb.zeus.service.main.IMMobileMsgService;
import com.ptb.zeus.service.user.ITbUserService;
import com.ptb.zeus.web.basic.controller.BaseRestCRUDRestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by eric on 16/8/19.
 */
@RequestMapping("admin/api/u")
@RestController
public class AUserController extends BaseRestCRUDRestController<TbUser,Long> {
	@Resource
	ITbUserService iTbUserService;


	@Resource
	IMMobileMsgService iMMobileMsgService;


	@Override
	protected ISuperService<TbUser> getBasicService() {
		return iTbUserService;
	}
}
