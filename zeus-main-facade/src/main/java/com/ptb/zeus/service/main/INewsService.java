package com.ptb.zeus.service.main;

import com.ptb.zeus.common.core.model.news.MNews;

import java.util.List;


/**
 * Created by eric on 16/7/4.
 */
public interface INewsService {

    public List<MNews> getNews(long ts, int limit);
    public MNews getNew(String blogId);

	void addNews(MNews mNews);
}
