package com.ptb.zeus.common.core.repository;


import com.ptb.zeus.common.core.model.news.MNews;

import java.util.List;

/**
 * Created by eric on 16/7/5.
 */
public interface MNewsRespository {
    List<MNews> getMNewssByTs(long st, int limit);

    void addMNews(MNews blog);

    void delMNewsById(String blogId);

    MNews getMNewsById(String blogId);
}
