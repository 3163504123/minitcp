package com.ptb.zeus.common.web.bean.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyThinkpad on 2016/6/1.
 */
public class RepUserMediaTagsWeb {
    private List<TagLetter> tags;
    private int noTagnum;

    public RepUserMediaTagsWeb(){
        this.tags = new ArrayList<>();
        this.noTagnum = 0;
    }

    public List<TagLetter> getTags() {
        return tags;
    }

    public void setTags(List<TagLetter> tags) {
        this.tags = tags;
    }

    public int getNoTagnum() {
        return noTagnum;
    }

    public void setNoTagnum(int noTagnum) {
        this.noTagnum = noTagnum;
    }

    public void addTagLetter(String label, Character labelKey){
        this.tags.add(new TagLetter(label, labelKey));
    }

    public class TagLetter{
        public String label;
        public Character labelKey;

        public TagLetter(){}

        public TagLetter(String label, Character labelKey){
            this.label = label;
            this.labelKey = labelKey;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public Character getLabelKey() {
            return labelKey;
        }

        public void setLabelKey(Character labelKey) {
            this.labelKey = labelKey;
        }
    }

}