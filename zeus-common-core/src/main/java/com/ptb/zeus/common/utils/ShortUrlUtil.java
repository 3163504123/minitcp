package com.ptb.zeus.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

/**
 * Created by MyThinkpad on 2016/7/6.
 */
public class ShortUrlUtil {

    private static Logger logger = Logger.getLogger(ShortUrlUtil.class);

    final static String SINA_URL = "http://jump.sinaapp.com/api.php?url_long=";
    final static String SINA_URL_KEY = "http://api.t.sina.com.cn/short_url/shorten.json?source=3271760578&url_long=";
    final static String SINA_URL_KEY_RETURN = "http://api.t.sina.com.cn/short_url/expand.json?source=3271760578&url_short=";
    final static String BAIDU_URL = "http://dwz.cn/create.php";
    final static String BAIDU_URL_RETURN = "http://dwz.cn/query.php";

    public static String generateShortUrl(String url){
        String ret = generateShortUrlBySina(url);
        if(null == ret) {
            ret = generateShortUrlByBd(url);
/*            if(null == ret)
                ret = generateShortUrlBySina1(url);*/
        }
        return ret;
    }

    public static String restoreShortUrl(String shortUrl){
        if(null == shortUrl) {
            logger.warn("restoreShortUrl receive null argument");
        }else if(shortUrl.trim().startsWith("http://t.cn/")){
            return restoreShortUrlBySina(shortUrl);
        }else if(shortUrl.trim().startsWith("http://dwz.cn/")){
            return restoreShortUrlByBd(shortUrl);
        }
        return shortUrl;
    }

    /**
     * Request: http://api.t.sina.com.cn/short_url/shorten.json?source=3271760578&url_long=
     * Response:
     * 1. {"request":"/short_url/shorten.json","error_code":"400","error":"40001:Error: param error, see doc for more info."}
     * 2. [{"url_short":"http://t.cn/RyhQ2V2","url_long":"http://www.baidu.com","type":39}]
     *
     * ***/
    public static String generateShortUrlBySina(String url){
        try {
            Response response = Request.Get(String.format("%s%s", SINA_URL_KEY, URLEncoder.encode(url, "utf-8"))).execute();
            JSONObject result = ((JSONObject) JSON.parseArray(response.returnContent().asString()).get(0));
            if(!result.containsKey("error"))
                return result.getString("url_short");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String restoreShortUrlBySina(String shortUrl){
        try {
            Response response = Request.Get(String.format("%s%s", SINA_URL_KEY_RETURN, shortUrl)).execute();
            JSONObject result = ((JSONObject)JSON.parseArray(response.returnContent().asString()).get(0));
            if(result.containsKey("url_long") && StringUtils.isNotBlank(result.getString("url_long"))) {
                return result.getString("url_long");
            }else
                logger.error(String.format("Sina restore %s Error return %s",shortUrl, result.toJSONString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * 【API地址】 http://jump.sinaapp.com/api.php
     *【请求方式】 GET/POST
     *【输入参数】 url_long（长网址）
     *【返回格式】 没有传递callback参数：JSON，有callback参数：JSONP
     *【返回字段】 result（1表示正常，0表示错误）、url_long、url_short、error（错误说明）
     *
     * */
    public static String generateShortUrlBySina1(String url){
        try {
            Response response = Request.Get(String.format("%s%s", SINA_URL, URLEncoder.encode(url, "utf-8"))).execute();
            JSONObject result = JSON.parseObject(response.returnContent().asString());
            if(1 == result.getInteger("result"))
                return result.getString("url_short");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /***
     * 生成短网址
     * 请求：向dwz.cn/create.php发送post请求，发送数据包括url=长网址
     * 返回：json格式的数据
     * status!=0 出错，查看err_msg获得错误信息（UTF-8编码）
     * 成功，返回生成的短网址 tinyurl字段
     *
     * 自定义短网址
     * 请求：向dwz.cn/create.php发送post请求，发送数据包括url=长网址&alias=自定义网址
     * 返回：json格式的数据
     * Status!=0 出错，查看err_msg获得错误信息（UTF-8编码）
     * 成功，返回生成的短网址 tinyurl字段
     * **/
    public static String generateShortUrlByBd(String url){
        try {
            Response response = Request.Post(BAIDU_URL).bodyForm(Form.form().add("url", url).build()).execute();
            JSONObject result = JSON.parseObject(response.returnContent().asString(Charset.forName("utf-8")));
            if(result.containsKey("status") && 0 == result.getInteger("status"))
                return result.getString("tinyurl");
            System.out.println(result.getString("err_msg"));
        }catch (UnsupportedEncodingException | ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /***
     * 显示原网址
     * 请求：向dwz.cn/query.php发送post请求，发送数据包括tinyurl=查询的短地址
     * 返回：json格式的数据
     * status!=0 出错，查看err_msg获得错误信息（UTF-8编码）
     * 成功，返回原网址 longurl字段
     *
     * */
    public static String restoreShortUrlByBd(String shortUrl){
        try {
            Response response = Request.Post(BAIDU_URL_RETURN).bodyForm(Form.form().add("tinyurl", shortUrl).build()).execute();
            JSONObject result = JSON.parseObject(response.returnContent().asString(Charset.forName("utf-8")));
            if(result.containsKey("status") && 0 == result.getInteger("status") && result.containsKey("longurl"))
                return result.getString("longurl");
            else
                logger.error(String.format("Baidu restore %s Error return %s", shortUrl, result.toJSONString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] argv){
        //String testUrl = "http://hera.pintuibao.cn/static/pc/mediaAdd.html?key=577dad043feb705f20d50c63";
        String testUrl = "http://www.baidu.com/";

        long start = 0;
        String shortUrl = null;

        start = System.currentTimeMillis();
        shortUrl = generateShortUrl(testUrl);
        if(null == shortUrl){
            System.out.println(testUrl);
        }else{
            System.out.println(shortUrl);
        }
        System.out.println("sina result:" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        shortUrl = generateShortUrlByBd(testUrl);
        if(null == shortUrl){
            System.out.println(testUrl);
        }else{
            System.out.println(shortUrl);
        }
        System.out.println("baidu result:" + (System.currentTimeMillis() - start));
    }
}