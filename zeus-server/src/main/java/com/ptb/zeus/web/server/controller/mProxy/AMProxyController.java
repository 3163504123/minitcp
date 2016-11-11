package com.ptb.zeus.web.server.controller.mProxy;

import com.ptb.zeus.service.main.IMProxyService;
import com.ptb.zeus.service.main.impl.MProxyServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by eric on 16/10/9.
 */
@RequestMapping("/api/proxy")
@RestController
public class AMProxyController {
	IMProxyService imProxyService = new MProxyServiceImpl();


}

