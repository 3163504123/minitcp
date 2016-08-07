package com.ptb.zeus.common.utils.monitor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by MyThinkpad on 2016/3/14.
 */

public class TimeFormatUtils {

    public static long HalfHourAfterNow(long time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String sTime = simpleDateFormat.format(new Date(time));
        long second = Long.valueOf(sTime.substring(14,16));
        if(second < 30){
            try {
                second = simpleDateFormat.parse(new StringBuilder(sTime).replace(14,16, "30").toString()).getTime();
            } catch (Exception e) {
                e.printStackTrace();
                second = -1;
            }
        }else{
            simpleDateFormat.applyPattern("yyyy-MM-dd HH");
            try {
                second = simpleDateFormat.parse(simpleDateFormat.format(new Date(time))).getTime() + 1 * 60 * 60 * 1000;
            } catch (Exception e) {
                e.printStackTrace();
                second = -1;
            }
        }
        return second;
    }

    /**
     *
     * @param time
     * @return success if now time is 2016-03-14 11:11:11 return timestamp of 2016-03-14 11:00:00
     *         or else return -1
     */
    public static long HalfHourBeforeNow(long time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date timeDate = new Date(time);
        String sTime = simpleDateFormat.format(timeDate);
        long second = Long.valueOf(sTime.substring(14,16));
        if(second < 30){
            try {
                simpleDateFormat.applyPattern("yyyy-MM-dd HH");
                second = simpleDateFormat.parse(simpleDateFormat.format(timeDate)).getTime();
            } catch (Exception e) {
                e.printStackTrace();
                second = -1;
            }
        }else{
            try {
                second = simpleDateFormat.parse(new StringBuilder(sTime).replace(14,16, "30").toString()).getTime();
            } catch (Exception e) {
                e.printStackTrace();
                second = -1;
            }
        }
        return second;
    }

    public static long HourBefore(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH");
        Date timeDate = new Date(System.currentTimeMillis());
        String sTime = simpleDateFormat.format(timeDate);
        long lastHour = 0L;
        try {
            lastHour = simpleDateFormat.parse(sTime).getTime() - 60*60*1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return lastHour;
    }

    public static long YesterdayLastHour(long time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date timeDate = new Date(time);
        String sTime = simpleDateFormat.format(timeDate);
        long yesterday = 0L;
        try {
            yesterday = simpleDateFormat.parse(sTime).getTime() - 60*60*1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return yesterday;
    }

    public static long TodayMorning(long time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date timeDate = new Date(time);
        String sTime = simpleDateFormat.format(timeDate);
        long yesterday = 0L;
        try {
            yesterday = simpleDateFormat.parse(sTime).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return yesterday;
    }

    public static long YesterdayLastHour(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date timeDate = new Date(System.currentTimeMillis());
        String sTime = simpleDateFormat.format(timeDate);
        long yesterday = 0L;
        try {
            yesterday = simpleDateFormat.parse(sTime).getTime() - 60*60*1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return yesterday;
    }
}
