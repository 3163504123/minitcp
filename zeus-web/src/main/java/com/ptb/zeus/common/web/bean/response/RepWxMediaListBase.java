package com.ptb.zeus.common.web.bean.response;

import com.ptb.zeus.common.common.MediaDetail;
import com.ptb.zeus.common.common.MediaListInfo;
import com.ptb.zeus.common.common.WxMediaInfo;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.stream.Collectors;

/**
 * \微信媒体搜索
 *
 * @author lenovo
 */
public class RepWxMediaListBase extends MediaListInfo {
    private int totalNum;
    private List<WxMediaInfo> list;

    public RepWxMediaListBase(Pair<Integer, List<MediaDetail>> mediaDetails) {
        this.totalNum = mediaDetails.getKey();
        List<WxMediaInfo> weixin = mediaDetails.getRight().stream().map(mediaDetail -> {
            WxMediaInfo wxMediaInfo = new WxMediaInfo();
            wxMediaInfo.setAuthInfo(mediaDetail.getAuthInfo());
            wxMediaInfo.setCollection(mediaDetail.getCollection());
            wxMediaInfo.setIsAuth(mediaDetail.getIsAuth());
            wxMediaInfo.setMediaId(mediaDetail.getMediaId());
            wxMediaInfo.setMediaImage(mediaDetail.getMediaImage());
            wxMediaInfo.setMediaName(mediaDetail.getMediaName());
            wxMediaInfo.setType(1);
            wxMediaInfo.setpMid(mediaDetail.getpMid());
            wxMediaInfo.setBrief(mediaDetail.getBrief());
            wxMediaInfo.setAddTime(mediaDetail.getAddTime());
            return wxMediaInfo;
        }).collect(Collectors.toList());
        list = weixin;
    }

    public RepWxMediaListBase() {

    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public List<WxMediaInfo> getList() {
        return list;
    }

    public void setList(List<WxMediaInfo> list) {
        this.list = list;
    }
}
