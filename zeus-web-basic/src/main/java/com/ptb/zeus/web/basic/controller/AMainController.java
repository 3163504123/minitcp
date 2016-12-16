package com.ptb.zeus.web.basic.controller;

import com.ptb.zeus.service.main.StorageService;
import com.ptb.zeus.web.response.BaseResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by eric on 16/10/9.
 */
@RestController
public class AMainController {
	@Value("${com.zeus.upload.file.max.size}")
	Integer fileSize;

	@Value("${com.zeus.static.resource.url.prefix}")
	String urlPrefix;

	@Autowired
	StorageService storageService;

	@RequestMapping("/upload")
	@ResponseBody
	public Object handleFileUpload(@RequestParam("file1") MultipartFile file, String fileType) {
		if(fileType == null) {
			fileType = "default";
		}
		if (!file.isEmpty() && file.getSize() < fileSize && !fileType.contains("/")) {
			try {
				String s = storageService.saveFile(fileType, file.getOriginalFilename(), file.getInputStream());
				String format = String.format("%s/%s", urlPrefix, s);
				return new BaseResponse<String>(format);
			} catch (IOException e) {
				return "";
			}
		}
		return "";
	}
}
