package com.ptb.zeus.common.web.bean.response;


import com.ptb.zeus.common.common.MediaSet;
import com.ptb.zeus.common.model.User;
import com.ptb.zeus.common.web.utils.ConvertUtil;

/**
 * Created by eric on 16/5/28.
 */
public class RepShareMediaList {
    String shareNickname;
    Long shareUserId;
    String shareUserHeadImage;
    RepWxMediaListBase weixin;
    RepWbMediaListBase weibo;

    public RepShareMediaList(User user, MediaSet wbMediaList, MediaSet wxMediaList) {
        this.shareNickname = user.getUsername();
        this.shareUserId = user.getId();
        this.shareUserHeadImage = user.getPortraitsUrl();
        this.weixin = ConvertUtil.convertMediaSetToWxMediaListInfo(wxMediaList);
        this.weibo = ConvertUtil.convertMediaSetToWbMediaListInfo(wbMediaList);
    }

    public String getShareUserHeadImage() {
        return shareUserHeadImage;
    }

    public void setShareUserHeadImage(String shareUserHeadImage) {
        this.shareUserHeadImage = shareUserHeadImage;
    }

    public String getShareNickname() {
        return shareNickname;
    }

    public void setShareNickname(String shareNickname) {
        this.shareNickname = shareNickname;
    }

    public Long getShareUserId() {
        return shareUserId;
    }

    public void setShareUserId(Long shareUserId) {
        this.shareUserId = shareUserId;
    }

    public RepWxMediaListBase getWeixin() {
        return weixin;
    }

    public void setWeixin(RepWxMediaListBase weixin) {
        this.weixin = weixin;
    }

    public RepWbMediaListBase getWeibo() {
        return weibo;
    }

    public void setWeibo(RepWbMediaListBase weibo) {
        this.weibo = weibo;
    }
}
