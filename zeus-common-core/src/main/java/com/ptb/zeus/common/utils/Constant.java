package com.ptb.zeus.common.utils;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * Created by eric on 16/5/20.
 */
public class Constant {
    public final static String SESSION_USERNAME = "username";
    public final static String SESSION_USERID = "id";
    public final static String SESSION_NICKNAME = "username";
    public static final String SESSION_EMAIL = "email";
    public final static String SESSION_TYPE = "type";
    public static final String SESSION_TYPE_FINDPASSWORD = "find";
    public static final String SESSION_LASTACCESSTIME = "l";
    public static final String SESSION_TIMEOUT_SECOND = "t";
    public final static int M_T_WEIXIN = 1;
    public final static int M_T_WEIBO = 2;
    public final static int M_T_ALL = 0;
    public final static String HotArticle = "hot";
    public final static String RecentArticle = "recent";
    public final static int SESSION_DEFAULT_EXPIRE_SECOND = 8*3600;

    public static String USER_CDN_URL;
    public static long   USER_PORTRAIT_MAX_SIZE;
    public static String USER_CDN_DEFAULT_IMG;
    public static String MEDIA_CDN_DEFAULT_IMG;
    static {
        Configuration configuration = null;
        try {
            configuration = new PropertiesConfiguration("ptb.properties");
            USER_PORTRAIT_MAX_SIZE = configuration.getLong("zeus.server.user.portrait.size", 1048576L);
            USER_CDN_URL = configuration.getString("zeus.server.user.portrait.url", "http://www.pintuibao.cn/static/common/img/");
            USER_CDN_DEFAULT_IMG = configuration.getString("zeus.server.user.default.headimg", "http://www.pintuibao.cn/static/common/img/moren2.png");
            MEDIA_CDN_DEFAULT_IMG = configuration.getString("zeus.server.media.default.headimg", "http://www.pintuibao.cn/static/common/img/moren5.png");
        } catch (ConfigurationException e) {
            e.printStackTrace();
            System.out.println("****************** Init USER_CDN_URL Fail !!!!!! **********************");
        }
    }

    public static void main(String[] args) throws Exception {
        String s = PasswordHelper.decodeByDes("ltACiHjVjIkotGo4p6Jwkg==");
        System.out.println(s);
    }

}
