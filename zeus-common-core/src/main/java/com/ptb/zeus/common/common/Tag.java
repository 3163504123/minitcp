package com.ptb.zeus.common.common;

/**
 * 标签
 *
 * @author lenovo
 */
public class Tag {
    private String id;
    private String name;

    public Tag(String k, String k1) {
        this.id = k;
        this.name = k;
    }

    public Tag() {

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


}
