package com.ptb.zeus.common.web.bean.response;

import com.ptb.zeus.common.common.ContactInfo;
import com.ptb.zeus.common.common.MediaDetail;
import com.ptb.zeus.common.common.MediaSet;
import com.ptb.zeus.common.web.bean.request.user.ReqUserMediaList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 微信媒体列表
 *
 * @author lenovo
 */
public class RepWxMediaList {

    private int totalNum;
    private List<WxMediaListRep> list;

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public List<WxMediaListRep> getList() {
        return list;
    }

    public void setList(List<WxMediaListRep> list) {
        this.list = list;
    }

    public static RepWxMediaList getDefult() {
        RepWxMediaList rl = new RepWxMediaList();
        rl.setTotalNum(40);
        WxMediaListRep wx = new WxMediaListRep();
        List<WxMediaListRep> list = new ArrayList<>();
        wx.setIsAuth(1);
        wx.setMediaImage("http://wx.qlogo.cn/mmhead/Q3auHgzwzM7JFfLyQbMTJubQEzwzn41BQARR0oLicqXGhlpOTxCHIdw/0");
        wx.setMediaName("贴贴相册");
        wx.setType(1);
        wx.setpMid("572c2fc9a5d61d42cd9c8e46");
        wx.setReadNum(17000);
        wx.setZanNum(3000);
        for (int i = 0; i < 20; i++) {
            list.add(wx);
        }

        rl.setList(list);
        return rl;

    }

    public static RepWxMediaList toController(MediaSet mediaSet, ReqUserMediaList reqUserMediaList) {
        RepWxMediaList repWxMediaList = new RepWxMediaList();
        if (mediaSet.getMediaDetailList().isEmpty()) {
            repWxMediaList.setTotalNum(0);
            repWxMediaList.setList(new ArrayList<>());
        } else {
            List<WxMediaListRep> detailList = mediaSet.getMediaDetailList().stream().
                    sorted((a, b) -> {
                        return compareByKey(a, b, reqUserMediaList.getSortBy());
                    }).filter(item -> mediaFilter(item, reqUserMediaList)).
                    map(RepWxMediaList::detailToRepMediaListRep).
                    collect(Collectors.toList());
            repWxMediaList.setTotalNum(detailList.size());
            repWxMediaList.setList(detailList.stream().skip(reqUserMediaList.getStart()).limit(reqUserMediaList.getEnd() - reqUserMediaList.getStart()).collect(Collectors.toList()));
        }
        return repWxMediaList;
    }
    public static boolean mediaFilter(MediaDetail item, ReqUserMediaList reqUserMediaList){
        if(!item.getTags().containsAll(reqUserMediaList.getTagList()))
            return false;
        if( ((0 == reqUserMediaList.getNum().getReadStart() && Integer.MAX_VALUE == reqUserMediaList.getNum().getReadEnd())
                || (item.getHlavGread() >= reqUserMediaList.getNum().getReadStart() && item.getHlavGread() <= reqUserMediaList.getNum().getReadEnd()))
          && ( (0 == reqUserMediaList.getNum().getZanStart() && Integer.MAX_VALUE == reqUserMediaList.getNum().getZanEnd())
                || (item.getHlavgZan() >= reqUserMediaList.getNum().getZanStart() && item.getHlavgZan() <= reqUserMediaList.getNum().getZanEnd()))
          && reqUserMediaList.getStart() < reqUserMediaList.getEnd())
            return true;
        return false;
        //return mediaDetail.getTags().containsAll(reqUserMediaList.getTagList());
    }

    public static int compareByKey(MediaDetail a, MediaDetail b, int key) {
        if (0 == key) {

        } else if (1 == key)
            return (a.getHlavGread() == b.getHlavGread()) ? 0 : ((a.getHlavGread() - b.getHlavGread()) > 0) ? -1 : 1;
        else if (2 == key) {
            return (a.getHlavgZan() == b.getHlavgZan()) ? 0 : ((a.getHlavgZan() - b.getHlavgZan()) > 0) ? -1 : 1;
        }
        return (a.getAddTime() == b.getAddTime()) ? 0 : ((a.getAddTime() - b.getAddTime()) > 0) ? -1 : 1;
    }

    public static WxMediaListRep detailToRepMediaListRep(MediaDetail mediaDetail) {
        WxMediaListRep wx = new WxMediaListRep();
        wx.setIsAuth(mediaDetail.getIsAuth());
        wx.setMediaImage(mediaDetail.getMediaImage());
        wx.setMediaName(mediaDetail.getMediaName());
        wx.setType(mediaDetail.getType());
        wx.setpMid(mediaDetail.getpMid());
        wx.setReadNum(mediaDetail.getHlavGread());
        wx.setZanNum(mediaDetail.getHlavgZan());
        wx.setAddTime(mediaDetail.getAddTime());
        wx.setIsAuth(mediaDetail.getIsAuth());
        wx.setIsOriginal(mediaDetail.getIsOriginal());
        if(!(mediaDetail.getTags().size() == 1 && mediaDetail.getTags().get(0).equals("无标签")))
            wx.setTagList(mediaDetail.getTags());
        if(null != mediaDetail.getContact())
            wx.setContact(new ContactInfo(
                    mediaDetail.getContact().getName(),
                    mediaDetail.getContact().getPhone(),
                    mediaDetail.getContact().getEmail(),
                    mediaDetail.getContact().getPrice()));

        return wx;
    }

    public static class WxMediaListRep {

        private String pMid;
        private int type;
        private String mediaImage;
        private String mediaName;
        private int isAuth;
        private int readNum;
        private int zanNum;
        private long addTime;
        private int isOriginal;
        private List<String> tagList;
        private ContactInfo contact;

        public ContactInfo getContact() {
            return contact;
        }

        public void setContact(ContactInfo contact) {
            this.contact = contact;
        }

        public List<String> getTagList() {
            return tagList;
        }

        public void setTagList(List<String> tagList) {
            this.tagList = tagList;
        }

        public String getpMid() {
            return pMid;
        }

        public void setpMid(String pMid) {
            this.pMid = pMid;
        }

        public String getMediaImage() {
            return mediaImage;
        }

        public void setMediaImage(String mediaImage) {
            this.mediaImage = mediaImage;
        }

        public String getMediaName() {
            return mediaName;
        }

        public void setMediaName(String mediaName) {
            this.mediaName = mediaName;
        }

        public int getIsAuth() {
            return isAuth;
        }

        public void setIsAuth(int isAuth) {
            this.isAuth = isAuth;
        }

        public int getReadNum() {
            return readNum;
        }

        public void setReadNum(int readNum) {
            this.readNum = readNum;
        }

        public int getZanNum() {
            return zanNum;
        }

        public void setZanNum(int zanNum) {
            this.zanNum = zanNum;
        }


        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public long getAddTime() {
            return addTime;
        }

        public void setAddTime(long addTime) {
            this.addTime = addTime;
        }

        public int getIsOriginal() {
            return isOriginal;
        }

        public void setIsOriginal(int isOriginal) {
            this.isOriginal = isOriginal;
        }
    }
}