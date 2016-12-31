package com.ptb.zeus.service.main.impl;

import com.ptb.zeus.common.core.model.news.MNews;
import com.ptb.zeus.common.core.repository.MNewsRespository;
import com.ptb.zeus.service.main.INewsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/12/31
 * @version 1.0.0
 * @description 类的功能
 */
@Component
public class INewsServiceImpl implements INewsService {
	private static Logger logger = LoggerFactory.getLogger(INewsServiceImpl.class);

	@Autowired
	MNewsRespository mNewsRespository;

	@Override
	public List<MNews> getNews(long ts, int limit) {
		return mNewsRespository.getMNewssByTs(ts,limit);
	}

	@Override
	public MNews getNew(String newsID) {
		return mNewsRespository.getMNewsById(newsID);
	}

	@Override
	public void addNews(MNews mNews) {
			//todo
	}


	public void delBlog(String blogId) {
		mNewsRespository.delMNewsById(blogId);
	}



/*

	@Scheduled(fixedRate = 3600000, initialDelay = 6000)
	public void importSogouArticle() {
		logger.info("start schedule");
		List<String> hotArticleFromSogou = getHotArticleFromSogou();
		hotArticleFromSogou.forEach(k -> {
			try {
				addByBlogLink(new BlogLink(k, 0));
			} catch (Exception e) {
				logger.warn(String.format("add article url %s error", k));
			}

		});
		logger.info("end schedule");
	}



	public List<String> getHotArticleFromSogou() {
		List<String> articles = new ArrayList<>();
		try {
			Document parse = Jsoup.parse(new URL("http://weixin.sogou.com/pcindex/pc/pc_9/pc_9.html"), 2000);
			Elements src = parse.select("a[href^=\"http://mp.weixin.qq.com/s\"]");
			List<String> urls = src.parallelStream().map(element -> {
				String url = element.attr("href");
				return url;
			}).distinct().collect(Collectors.toList());
			if (urls != null) {
				articles.addAll(urls);
			}
		} catch (Exception e) {
		}
		return articles;
	}


	public void addByBlogLink(BlogLink blogLink) {
		Optional<WxArticle> articleOptional = weixinSpider.getArticleByUrl(blogLink.getUrl());
		if (articleOptional.isPresent()) {
			blogDao.addBlog(MConvertUtils.convertWxArticleToBlog(articleOptional.get()));
		} else {
			throw ZeusException.BlogClawerWxArticleError;
		}
	}
*/


}
