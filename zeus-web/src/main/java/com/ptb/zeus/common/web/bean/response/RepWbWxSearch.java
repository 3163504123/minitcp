package com.ptb.zeus.common.web.bean.response;


import com.ptb.zeus.common.common.MediaListInfo;
import com.ptb.zeus.common.utils.Constant;
import com.ptb.zeus.common.web.exception.ZeusException;

/**
 * Created by eric on 16/5/24.
 */
public class RepWbWxSearch {

    private MediaListInfo weixin;
    private MediaListInfo weibo;


    public MediaListInfo getWeixin() {
        return weixin;
    }

    public void setWeixin(MediaListInfo weixin) {
        this.weixin = weixin;
    }

    public MediaListInfo getWeibo() {
        return weibo;
    }

    public void setWeibo(MediaListInfo weibo) {
        this.weibo = weibo;
    }

    public RepWbWxSearch(MediaListInfo repWxMediaListBase, MediaListInfo repWbMediaListBase) {
        this.weixin = repWxMediaListBase;
        this.weibo = repWbMediaListBase;
    }
    public RepWbWxSearch(MediaListInfo mediaInfo,int type) {
        switch (type) {
            case Constant.M_T_WEIBO:
                this.weibo = mediaInfo;
                break;
            case Constant.M_T_WEIXIN:
                this.weixin = mediaInfo;
                break;
            default:
                throw ZeusException.PlatformTypeInvaildError;
        }
    }
}
