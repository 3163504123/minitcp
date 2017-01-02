package com.ptb.zeus.tool;

import com.ptb.zeus.common.core.model.news.BlogLink;
import com.ptb.zeus.common.core.model.news.MNews;
import com.ptb.zeus.common.core.utils.HttpUtil;
import com.ptb.zeus.common.core.utils.RegexUtils;
import com.ptb.zeus.service.main.INewsService;

import org.apache.http.client.fluent.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/12/31
 * @version 1.0.0
 * @description 类的功能
 */
public class NewsTool {
	private static Logger logger = LoggerFactory.getLogger(NewsTool.class);

	static Pattern bizRegex = Pattern.compile(".*var appuin = \"([^\"]*)\".*");
	static Pattern headImgRegex = Pattern.compile(".*hd_head_img : \"([^\"]*)\".*");
	static Pattern originalLinkRegex = Pattern.compile(".*var msg_source_url = \'([^\']*)\'.*", Pattern.DOTALL);
	static Pattern coverImgRegex = Pattern.compile(".*var msg_cdn_url = \"([^\\?\"]*)\".*");

	static public List<String> getHotArticleFromSogou() {
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


	static INewsService iNewsService;

	public static void getNewNews(INewsService bean) {
		iNewsService = bean;

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


	public static void addByBlogLink(BlogLink blogLink) {

		try {
			Content content = HttpUtil.getPageByPcClient(blogLink.getUrl());
			WxArticle wxArticle = parsePage(content.asString());
			wxArticle.setArticleUrl(blogLink.getUrl());
			if(wxArticle != null) {
				MNews mNews = convertWxArticleToNews(wxArticle);
				iNewsService.addNews(mNews);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}


	public static WxArticle parsePage(String pageSource) {
		Document html = Jsoup.parse(pageSource);
		String title = html.select(".rich_media_title").first().text();
		String nickName = html.select(".profile_nickname").text();
		String author = html.select("#post-user").text();
		String content = html.select("#page-content").html();
		String wxid = html.select(".profile_inner>p:nth-of-type(1)>.profile_meta_value").text().toString();
		String brief = html.select(".profile_inner>p:nth-of-type(2)>.profile_meta_value").text().toString();
		//String postDate = html.select("#post-date").text();
		long postTime = 0;
		String biz = "";
		String headImgUrl = "";
		//原文链接
		String sourceLink = "";
		//原创标志
		String originalTag = html.select("#copyright_logo").text().toString();
		boolean isOrinal = originalTag.trim().equals("原创");
		//封面图
		String coverImgUrl = "";

		Elements scripts = html.select("script[type*=\"text/javascript\"]");
		List<Element> scriptList = scripts.parallelStream().filter(script -> script.toString().contains("var appuin =")).collect(Collectors.toList());
		if (!scriptList.isEmpty()) {
			String text = scriptList.get(0).toString();
			Matcher matcher = bizRegex.matcher(text);
			if (matcher.find() && matcher.groupCount() > 0) {
				biz = matcher.group(1);
			}

			Matcher matcher1 = headImgRegex.matcher(text);
			if (matcher1.find() && matcher1.groupCount() > 0) {
				headImgUrl = matcher1.group(1);
			}
			String sub = RegexUtils.sub(".*var ct = \"([^\"]*)\";.*", text, 0);
			if (sub != null) {
				postTime = Long.parseLong(sub);
			}
			if (wxid == null || wxid.length() == 0) {
				wxid = RegexUtils.sub(".*var user_name = \"([^\"]*)\";.*", text, 0);
			}
			Matcher matcher2 = originalLinkRegex.matcher(text);
			if (matcher2.find() && matcher2.groupCount() > 0) {
				sourceLink = matcher2.group(1);
			}
			Matcher matcher3 = coverImgRegex.matcher(text);
			if (matcher3.find() && matcher3.groupCount() > 0) {
				coverImgUrl = matcher3.group(1);
			}
		}

		WxArticle article = new WxArticle(title, nickName, content, wxid, brief, postTime, biz, headImgUrl, author);
		article.setRawPage(pageSource);
		article.setSourceLink(sourceLink);
		article.setOriginal(isOrinal);
		article.setCoverImgUrl(coverImgUrl);
		return article;
	}

	public static MNews convertWxArticleToNews(WxArticle wxArticle) {
		MNews blog = new MNews();
		blog.setContent(wxArticle.getContent());
		blog.setPostTime(wxArticle.getPostTime());
		blog.setTitle(wxArticle.getTitle());
		blog.setAuthor(wxArticle.getAuthor());
		blog.setSource(wxArticle.getNickName());
		blog.setSourceUrl(wxArticle.getArticleUrl());
		blog.setConverPlan(wxArticle.getCoverImgUrl());
		blog.setRawPage(wxArticle.getRawPage());
		return blog;
	}


	public static void main(String[] args) {
		NewsTool newsTool = new NewsTool();
		List<String> hotArticleFromSogou = newsTool.getHotArticleFromSogou();
		hotArticleFromSogou.forEach(k -> {
			try {
				addByBlogLink(new BlogLink(k, 0));
			} catch (Exception e) {
				logger.warn(String.format("add article url %s error", k));
			}

		});

	}
}
