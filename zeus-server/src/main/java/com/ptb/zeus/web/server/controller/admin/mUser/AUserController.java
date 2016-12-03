package com.ptb.zeus.web.server.controller.admin.mUser;

import com.baomidou.framework.service.ISuperService;
import com.ptb.zeus.common.core.model.user.TbUser;
import com.ptb.zeus.service.main.IMMobileMsgService;
import com.ptb.zeus.service.user.ITbUserService;
import com.ptb.zeus.web.server.controller.admin.mBase.BaseRestCRUDRestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by eric on 16/8/19.
 */
@RequestMapping("admin/api/u")
@RestController
public class AUserController extends BaseRestCRUDRestController<Integer, TbUser> {
	@Resource
	ITbUserService iTbUserService;


	@Resource
	IMMobileMsgService iMMobileMsgService;


	@Override
	protected ISuperService<TbUser> getBasicService() {
		return iTbUserService;
	}
}
