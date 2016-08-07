package com.ptb.zeus.common.utils.monitor;

/**
 * Created by MyThinkpad on 2015/12/15.
 */

public class ReturnCode {
    public static final int SUCCESS = 0;
    public static final int USERPASSERR   = 10001; //帐号密码错误
    public static final int USERNOTACTIVE = 10002; //未激活
    public static final int USERNOTREGIS  = 10003; //未注册
    public static final int USERNOTLOGIN  = 10004; //未登录
    public static final int USERNOAUTHOR  = 10005; //未认证
    public static final int USERISREGIST  = 10006; //已注册
    public static final int NICKNAMEREPAT = 10007; //昵称已存在


    public static final int MTMAXNUM      = 10100;  //达到最大任务数
    public static final int MTARGVERROR   = 10101;  //参数错误
    public static final int MTTASKNAMEERR = 10102;  //任务名错误
    public static final int MTTASKURLERR  = 10103;  //url地址非法

    public static final int MTSUMMARYERR  = 10300;  //概要获取失败
    public static final int MTWXDETAILERR = 10301;  //微信详情获取失败

    public static final int MEDIAADDREPAT = 10500;  //媒体重复添加

    public static final int SEARGVERROR   = 10200; //参数错误

    public static final int SYSTEMEXECPT  = 11000; //系统异常
    public static final int SYSARGVERROR  = 11001; //参数错误
}
