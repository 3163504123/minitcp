package com.ptb.zeus.common.model;

import java.util.Date;

/**
 * Created by MyThinkpad on 2016/7/28.
 */
public class SearchInfo {
    private int    index;
    private String key;
    private long   userId;
    private Date   time;
    private String pmid;
    private int    type;
    private String action;

    public final static String ADD_MEDIA = "addMedia";
    public final static String SEE_MEDIA = "seeMedia";


    public SearchInfo(){}

    public SearchInfo(long userId, String action, int index, String key, String pmid, int type){
        this.userId = userId;
        this.action = action;
        this.index  = index;
        this.key    = key;
        this.pmid   = pmid;
        this.type   = type;
        this.time   = new Date();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPmid() {
        return pmid;
    }

    public void setPmid(String pmid) {
        this.pmid = pmid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
