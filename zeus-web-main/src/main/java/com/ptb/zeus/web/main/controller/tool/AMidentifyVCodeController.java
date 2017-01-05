package com.ptb.zeus.web.main.controller.tool;

import com.ptb.zeus.common.core.model.main.IdentifyVCodeResult;
import com.ptb.zeus.common.core.model.main.ReginizeHiistory;
import com.ptb.zeus.exception.UserException;
import com.ptb.zeus.service.main.MIdentifyVCodeService;
import com.ptb.zeus.service.main.StorageService;
import com.ptb.zeus.web.basic.controller.BaseRestController;
import com.ptb.zeus.web.main.request.IdentifyVCodeServiceRequest;
import com.ptb.zeus.web.main.request.PageRequest;
import com.ptb.zeus.web.response.BaseResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/13
 * @version 1.0.0
 * @description 验证码识别接口
 */
@Controller
@RequestMapping("admin/api/ivcode")
public class AMidentifyVCodeController extends BaseRestController {

	@Autowired
	StorageService storageService;

	@Autowired
	MIdentifyVCodeService mIdentifyVCodeService;

	@Value("${com.zeus.identity.img.max.size}")
	private int uploadIMGMaxSize;

	@Value("${com.zeus.static.resource.url.prefix}")
	String urlPrefix;


	@RequestMapping(value = "reginize", method = RequestMethod.POST)
	@ResponseBody
	public Object reginize(@RequestParam("file") MultipartFile file, @Valid IdentifyVCodeServiceRequest request,
	                               BindingResult bindingResult,@RequestParam(value = "f",required = false,defaultValue = "0") int f) {
		checkParams(bindingResult);

		if (!file.isEmpty() && file.getSize() < uploadIMGMaxSize) {
			try {
				IdentifyVCodeResult result = mIdentifyVCodeService.regnize(file.getOriginalFilename(), file.getInputStream(), request.getKey());
				return convertIdentifyCodeResultToBaseResponse(result);
			} catch (IOException e) {
				throw UserException.IdentifyVCodeImageUploadError;
			}
		}else{
			throw UserException.UploadFileSizeOutError;
		}
	}


	@RequestMapping("history")
	@PreAuthorize(value = "!isAnonymous()")
	public Object reginizeHistory(PageRequest pageRequest) {
		List<ReginizeHiistory> historys = mIdentifyVCodeService.selecltIdentifyVCodeHistory(pageRequest.getPage(), pageRequest.getRows(), getToken().getUid());
		return new BaseResponse<>(historys);
	}


	private Object convertIdentifyCodeResultToBaseResponse(IdentifyVCodeResult result) {
		BaseResponse<Object> response = new BaseResponse<>();
		response.setCode(result.getErr_no());
		response.setSuccess(result.getErr_no() == 0);
		response.setData(result.getPic_str());
		response.setMessage(result.getErr_str());
		response.setMsg(result.getErr_str());
		response.setSystemDate(System.currentTimeMillis());
		return response;
	}
}
