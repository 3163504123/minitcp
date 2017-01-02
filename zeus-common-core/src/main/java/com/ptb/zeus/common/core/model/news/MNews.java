package com.ptb.zeus.common.core.model.news;

import java.util.Date;
import java.util.List;

/**
 * Created by eric on 16/7/4.
 */
public class MNews {
    String id;
    String title;
    String content;
    Long postTime;
    String rawPage;
    List<String> tags;
    private String author;
    private String source;
    private String sourceUrl;
    int type = 0;
    private String converPlan;

    public String getRawPage() {
        return rawPage;
    }

    public void setRawPage(String rawPage) {
        this.rawPage = rawPage;
    }

    public Long getPostTime() {
        return postTime;
    }

    public void setPostTime(Long postTime) {
        this.postTime = postTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", postTime=" + postTime +
                ", tags=" + tags +
                ", author='" + author + '\'' +
                ", source='" + source + '\'' +
                ", sourceUrl='" + sourceUrl + '\'' +
                '}';
    }

    public Date postTime() {

        return new Date(this.getPostTime()*1000);
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getConverPlan() {
        return converPlan;
    }

    public void setConverPlan(String converPlan) {
        this.converPlan = converPlan;
    }
}
