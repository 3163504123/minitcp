package com.ptb.zeus.common.web.bean.response;

/**
 * 微信/微博基于标签的媒体数
 *
 * @author lenovo
 */
public class RepUserMediaTags {

    private String id;
    private String name;
    private int num;






    public RepUserMediaTags(String tag, long count) {
        this.setId(tag);
        this.setName(tag);
        this.setNum(Math.toIntExact(count));
    }

    public RepUserMediaTags() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


}
