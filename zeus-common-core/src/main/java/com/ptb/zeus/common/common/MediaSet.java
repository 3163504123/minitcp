package com.ptb.zeus.common.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyThinkpad on 2016/5/25.
 */
public class MediaSet {
    public static MediaSet Null = new MediaSet(0, new ArrayList<>());
    private int totalNum;
    private List<MediaDetail> mediaDetailList;

    public MediaSet(int totalNum, List<MediaDetail> mediaDetails) {
        this.totalNum = totalNum;
        this.mediaDetailList = mediaDetails;
    }

    public MediaSet() {

    }


    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public List<MediaDetail> getMediaDetailList() {
        return mediaDetailList;
    }

    public void setMediaDetailList(List<MediaDetail> mediaDetailList) {
        this.mediaDetailList = mediaDetailList;
    }
}
