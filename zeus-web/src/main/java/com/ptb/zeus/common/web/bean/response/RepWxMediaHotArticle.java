package com.ptb.zeus.common.web.bean.response;

import com.ptb.zeus.common.common.WxMediaHotArticleBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 微信媒体热文
 * @author lenovo
 *
 */
public class RepWxMediaHotArticle {

	private int totalNum;
	private List<WxMediaHotArticleBean> list;
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public List<WxMediaHotArticleBean> getList() {
		return list;
	}
	public void setList(List<WxMediaHotArticleBean> list) {
		this.list = list;
	}


	static int totalWxHotArticle = 40;
	public static RepWxMediaHotArticle getDefult(int start, int end){
		RepWxMediaHotArticle ra = new RepWxMediaHotArticle();
		ra.setTotalNum(totalWxHotArticle);

		if(start >= totalWxHotArticle){
			ra.setList(new ArrayList<>());
			return ra;
		}

		List<WxMediaHotArticleBean> list = new ArrayList<>();
		WxMediaHotArticleBean wxb = new WxMediaHotArticleBean();
		wxb.setpMid("MTE3MzE4MTAyMQ==");
		wxb.setTitle("今天苹果40岁了！乔布斯的那些成功秘诀现在依旧适用！");
		wxb.setMediaName("TechWeb");
		wxb.setPubTime(System.currentTimeMillis() - 24*60*60*1000);
		wxb.setUrl("http://mp.weixin.qq.com/s?__biz=MTE3MzE4MTAyMQ==&mid=403427490&idx=1&sn=b5a21e4ea3f6843f4662ef4fcb83af54#rd");
		wxb.setIsOriginal(1);
		wxb.setCoverPlan("http://wx.qlogo.cn/mmhead/Q3auHgzwzM6TXlfzBM0R9QAzOJ1EWMlRjyLBXo6mfoEaLhVNQFZYPw/0");
		wxb.setReadNum(9800);
		wxb.setZanNum(6700);
		for(int i = start;i < end && i < totalWxHotArticle;i++) {
			list.add(wxb);
		}
		ra.setList(list);
		return ra;
	}
	

}
