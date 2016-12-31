package com.ptb.zeus.web.main.controller.news;

import com.ptb.zeus.common.core.model.news.MNews;
import com.ptb.zeus.service.main.INewsService;
import com.ptb.zeus.web.basic.controller.BaseRestController;
import com.ptb.zeus.web.main.request.NewsReqeust;
import com.ptb.zeus.web.response.BaseResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by eric on 16/7/5.
 */
@Controller
@RequestMapping("/api/news")
public class ABlogController extends BaseRestController {
	@Autowired
	INewsService iNewsService;

	@RequestMapping("list")
	@ResponseBody
	public Object apiBlogList(NewsReqeust reqBlogList) {
		List<MNews> blogs = iNewsService.getNews(reqBlogList.getSt(), reqBlogList.getSize());
		return new BaseResponse<>(blogs);
	}

}
