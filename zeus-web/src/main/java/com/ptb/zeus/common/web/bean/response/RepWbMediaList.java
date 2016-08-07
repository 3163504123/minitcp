package com.ptb.zeus.common.web.bean.response;

import com.ptb.zeus.common.common.ContactInfo;
import com.ptb.zeus.common.common.MediaDetail;
import com.ptb.zeus.common.common.MediaSet;
import com.ptb.zeus.common.common.WbMediaListRep;
import com.ptb.zeus.common.web.bean.request.user.ReqUserMediaList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 微博媒体列表
 *
 * @author lenovo
 */
public class RepWbMediaList {

    private int totalNum;
    private List<WbMediaListRep> list;

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public List<WbMediaListRep> getList() {
        return list;
    }

    public void setList(List<WbMediaListRep> list) {
        this.list = list;
    }

    public static RepWbMediaList getDefult() {
        RepWbMediaList rl = new RepWbMediaList();
        WbMediaListRep wb = new WbMediaListRep();
        List<WbMediaListRep> list = new ArrayList<>();
        wb.setMediaName("新闻晨报");
        wb.setMediaImage("http://ww2.sinaimg.cn/orj480/736f0c7ejw1f3bl8jtnb3j20ho0a0jsb.jpg");
        wb.setIsAuth(1);
        wb.setType(2);
        wb.setpMid("5731b509a5d61d21d537e969");
        wb.setSpreadNum(889);
        wb.setZanNum(3890);
        for (int i = 0; i < 20; i++) {
            list.add(wb);
        }
        rl.setList(list);
        rl.setTotalNum(40);
        return rl;

    }

    public static RepWbMediaList toController(MediaSet mediaSet, ReqUserMediaList reqUserMediaList) {
        RepWbMediaList repWbMediaList = new RepWbMediaList();
        if (mediaSet.getMediaDetailList().isEmpty()) {
            repWbMediaList.setTotalNum(0);
            repWbMediaList.setList(new ArrayList<>());
        } else {
            List<WbMediaListRep> detailList = mediaSet.getMediaDetailList().stream().
                    sorted((a, b) -> {
                        return compareByKey(a, b, reqUserMediaList.getSortBy());
                    }).filter(item ->mediaFilter(item, reqUserMediaList)).
                    map(RepWbMediaList::detailToRepMediaListRep).collect(Collectors.toList());
            repWbMediaList.setTotalNum(detailList.size());
            repWbMediaList.setList(detailList.stream().skip(reqUserMediaList.getStart()).limit(reqUserMediaList.getEnd() - reqUserMediaList.getStart()).collect(Collectors.toList()));
        }
        return repWbMediaList;
    }

    public static boolean mediaFilter(MediaDetail item, ReqUserMediaList reqUserMediaList) {
        if(!item.getTags().containsAll(reqUserMediaList.getTagList()))
            return false;
        if( ((0 == reqUserMediaList.getNum().getSpreadStart() && Integer.MAX_VALUE == reqUserMediaList.getNum().getSpreadEnd())
                ||(item.getAvgSpread() >= reqUserMediaList.getNum().getSpreadStart() && item.getAvgSpread() <= reqUserMediaList.getNum().getSpreadEnd()))
            && ((0 == reqUserMediaList.getNum().getZanStart() && Integer.MAX_VALUE == reqUserMediaList.getNum().getZanEnd())
                ||(item.getAvgZan() >= reqUserMediaList.getNum().getZanStart() && item.getAvgZan() <= reqUserMediaList.getNum().getZanEnd()))
            && ((0 == reqUserMediaList.getNum().getCommentStart() && Integer.MAX_VALUE == reqUserMediaList.getNum().getCommentEnd())
                ||(item.getAvgComment() >= reqUserMediaList.getNum().getCommentStart() && item.getAvgComment() <= reqUserMediaList.getNum().getCommentEnd()))
            && ((0 == reqUserMediaList.getNum().getFanStart() && Integer.MAX_VALUE == reqUserMediaList.getNum().getFanEnd())
                ||(item.getFansNum() >= reqUserMediaList.getNum().getFanStart() && item.getFansNum() <= reqUserMediaList.getNum().getFanEnd()))
            && reqUserMediaList.getStart() < reqUserMediaList.getEnd())
            return true;
        return false;
        //return mediaDetail.getTags().containsAll(reqUserMediaList.getTagList());
    }

    public static int compareByKey(MediaDetail a, MediaDetail b, int key) {
        if (0 == key) {
            //添加时间排序
        } else if (1 == key)
            //粉丝数排序
            return (a.getFansNum() == b.getFansNum()) ? 0 : ((a.getFansNum() - b.getFansNum()) > 0) ? -1 : 1;
        else if (2 == key) {
            //篇均转发数
            return (a.getAvgSpread() == b.getAvgSpread()) ? 0 : ((a.getAvgSpread() - b.getAvgSpread()) > 0) ? -1 : 1;
        } else if (3 == key) {
            //篇均评论数
            return (a.getAvgComment() == b.getAvgComment()) ? 0 : ((a.getAvgComment() - b.getAvgComment()) > 0) ? -1 : 1;
        } else if (4 == key) {
            //篇均点赞数
            return (a.getAvgZan() == b.getAvgZan()) ? 0 : ((a.getAvgZan() - b.getAvgZan()) > 0) ? -1 : 1;
        }
        return (a.getAddTime() == b.getAddTime()) ? 0 : ((a.getAddTime() - b.getAddTime()) > 0) ? -1 : 1;
    }

    public static WbMediaListRep detailToRepMediaListRep(MediaDetail mediaDetail) {
        WbMediaListRep wb = new WbMediaListRep();
        wb.setIsAuth(mediaDetail.getIsAuth());
        wb.setMediaImage(mediaDetail.getMediaImage());
        wb.setMediaName(mediaDetail.getMediaName());
        wb.setType(mediaDetail.getType());
        wb.setpMid(mediaDetail.getpMid());
        wb.setSpreadNum(mediaDetail.getAvgSpread());
        wb.setZanNum(mediaDetail.getAvgZan());
        wb.setCommentNum(mediaDetail.getAvgComment());
        wb.setFansNum(mediaDetail.getFansNum());
        wb.setAddTime(mediaDetail.getAddTime());
        wb.setIsOriginal(mediaDetail.getIsOriginal());
        if(!(mediaDetail.getTags().size() == 1 && mediaDetail.getTags().get(0).equals("无标签")))
            wb.setTagList(mediaDetail.getTags());
        if(null != mediaDetail.getContact())
            wb.setContact(new ContactInfo(
                    mediaDetail.getContact().getName(),
                    mediaDetail.getContact().getPhone(),
                    mediaDetail.getContact().getEmail(),
                    mediaDetail.getContact().getPrice()));
        return wb;
    }
}
