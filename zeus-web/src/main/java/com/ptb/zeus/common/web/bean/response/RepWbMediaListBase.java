package com.ptb.zeus.common.web.bean.response;

import com.ptb.zeus.common.common.MediaDetail;
import com.ptb.zeus.common.common.MediaListInfo;
import com.ptb.zeus.common.common.WbMediaInfo;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * \微博媒体搜索
 *
 * @author lenovo
 */
public class RepWbMediaListBase extends MediaListInfo {
    public static RepWbMediaListBase Null = new RepWbMediaListBase(0, new ArrayList<>());
    private int totalNum;
    private List<WbMediaInfo> list;

    public RepWbMediaListBase(Pair<Integer, List<MediaDetail>> wbresult) {
        this.totalNum = wbresult.getKey();
        List<WbMediaInfo> weibos = wbresult.getRight().stream().map(mediaDetail -> {
            WbMediaInfo wbMediaInfo = new WbMediaInfo();
            wbMediaInfo.setAuthInfo(mediaDetail.getAuthInfo());
            wbMediaInfo.setCollection(mediaDetail.getCollection());
            wbMediaInfo.setIsAuth(mediaDetail.getIsAuth());
            wbMediaInfo.setMediaId(mediaDetail.getMediaId());
            wbMediaInfo.setMediaImage(mediaDetail.getMediaImage());
            wbMediaInfo.setMediaName(mediaDetail.getMediaName());
            wbMediaInfo.setBrief(mediaDetail.getBrief());
            wbMediaInfo.setType(2);
            wbMediaInfo.setpMid(mediaDetail.getpMid());
            wbMediaInfo.setAddTime(mediaDetail.getAddTime());
            return wbMediaInfo;
        }).collect(Collectors.toList());
        this.list = weibos;
    }

    public RepWbMediaListBase(int total, ArrayList<WbMediaInfo> repWbMediaListBases) {
        this.totalNum = total;
        this.list = repWbMediaListBases;
    }

    public RepWbMediaListBase() {
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public List<WbMediaInfo> getList() {
        return list;
    }

    public void setList(List<WbMediaInfo> list) {
        this.list = list;
    }
}
