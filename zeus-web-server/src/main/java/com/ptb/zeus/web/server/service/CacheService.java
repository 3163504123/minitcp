package com.ptb.zeus.web.server.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Created by eric on 16/10/9.
 */
@Component
public class CacheService {

	@Cacheable(value = "demo")
	public String echo() {
		System.out.println("i'm not cache");
		return "ok";
	}
}
