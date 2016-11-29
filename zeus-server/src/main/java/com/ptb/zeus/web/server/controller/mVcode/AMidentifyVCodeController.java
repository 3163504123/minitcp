package com.ptb.zeus.web.server.controller.mVcode;

import com.ptb.zeus.service.main.MIdentifyVCodeService;
import com.ptb.zeus.service.main.StorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/13
 * @version 1.0.0
 * @description 类的功能
 */
@Controller
@RequestMapping("/api/ivcode")
public class AMidentifyVCodeController {

	@Autowired
	StorageService storageService;

	@Autowired
	MIdentifyVCodeService mIdentifyVCodeService;

	@Value("${com.zeus.identity.img.max.size}")
	private int uploadIMGMaxSize;

	@Value("${com.zeus.static.resource.url.prefix}")
	String urlPrefix;


	@RequestMapping("get")
	public String doIdentify() {
		return null;
	}

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String uploadPage() {
		return "/upload/file";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public String handleFileUpload(@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty() && file.getSize() < uploadIMGMaxSize) {
			try {
				String uuid = storageService.saveFile("vcodeImage", file.getOriginalFilename(), file.getInputStream());
				System.out.println(String.format("%s/%s",urlPrefix,uuid));
				return uuid;
			} catch (IOException e) {
				return "";
			}
		}
		return "";
	}
}
