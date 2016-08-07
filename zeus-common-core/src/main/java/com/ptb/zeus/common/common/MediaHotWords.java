package com.ptb.zeus.common.common;

/**
 * Created by MengChen on 2016/7/19.
 */
public class MediaHotWords {

    private String hotword;
    private int score;

    public MediaHotWords(){

    }

    public MediaHotWords(String hotword,int score){
        this.hotword = hotword;
        this.score = score;
    }

    public String getHotword() {
        return hotword;
    }

    public void setHotword(String hotword) {
        this.hotword = hotword;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
