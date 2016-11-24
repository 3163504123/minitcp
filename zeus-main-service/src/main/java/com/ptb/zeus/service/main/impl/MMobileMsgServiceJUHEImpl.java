package com.ptb.zeus.service.main.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ptb.zeus.exception.UserException;
import com.ptb.zeus.service.main.IMMobileMsgService;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import static sun.net.www.protocol.http.HttpURLConnection.userAgent;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/12
 * @version 1.0.0
 * @description 类的功能
 */
@Component
public class MMobileMsgServiceJUHEImpl implements IMMobileMsgService {
	private static Logger logger = LoggerFactory.getLogger(MMobileMsgServiceJUHEImpl.class);
	public static final String DEF_CHATSET = "UTF-8";
	public static final int DEF_CONN_TIMEOUT = 30000;
	public static final int DEF_READ_TIMEOUT = 30000;

	String CACHE_KEY="CACHE_SENDED_MSG_PHONE";
	CacheManager cacheManager;


	public MMobileMsgServiceJUHEImpl() {
		cacheManager = new CacheManager();
		cacheManager.addCache(new Cache(CACHE_KEY, 10000, false, false, 60, 60));
	}

	@Override
	public void sendRegMessage(String phone, String vcode) {
		Map<String, Object> objectObjectHashMap = new HashMap<>();
		objectObjectHashMap.put("#code#", vcode);
		objectObjectHashMap.put("#name#", phone);
		_send(phone, "23282", objectObjectHashMap);
	}

	@Override
	public void sendfindPasswordMessage(String phone, String vcode) {
		Map<String, Object> objectObjectHashMap = new HashMap<>();
		objectObjectHashMap.put("#code#", vcode);
		objectObjectHashMap.put("#name#", phone);
		_send(phone, "23282", objectObjectHashMap);
	}

	private void _send(String phone, String tplID, Map<String, Object> kvs) {

		if(cacheManager.getCache(CACHE_KEY).get(phone) != null) {
			throw  new UserException("短信不能频繁发送（间隔必须超过1分钟）", -1);
		}

		String result = null;
		String url = "http://v.juhe.cn/sms/send";//请求接口地址
		Map params = new HashMap();//请求参数
		params.put("mobile", phone);//接收短信的手机号码
		params.put("tpl_id", tplID);//短信模板ID，请参考个人中心短信模板设置
		params.put("tpl_value", urlencode(kvs));//变量名和变量值对。如果你的变量名或者变量值中带有#&=中的任意一个特殊符号，请先分别进行urlencode编码后再传递，<a href="http://www.juhe.cn/news/index/id/50" target="_blank">详细说明></a>
		params.put("key", "a899cda8e885b07a7b4615011780d2a4");//应用APPKEY(应用详细页查询)
		params.put("dtype", "json");//返回数据的格式,xml或json，默认json
		cacheManager.getCache(CACHE_KEY).put(new Element(phone,""));

		try {
			result = net(url, params, "GET");
			JSONObject object = JSON.parseObject(result);
			if (object.getInteger("error_code") == 0) {
				System.out.println(object.get("result"));
				logger.info("[sms] success phone [{}]",phone);
				cacheManager.getCache(CACHE_KEY).put(new Element(phone,""));
			} else {
				throw new UserException(object.getString("reason"),object.getInteger("error_code"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param strUrl 请求地址
	 * @param params 请求参数
	 * @param method 请求方法
	 * @return 网络请求字符串
	 */
	private static String net(String strUrl, Map params, String method) throws Exception {
		HttpURLConnection conn = null;
		BufferedReader reader = null;
		String rs = null;
		try {
			StringBuffer sb = new StringBuffer();
			if (method == null || method.equals("GET")) {
				strUrl = strUrl + "?" + urlencode(params);
			}
			URL url = new URL(strUrl);
			conn = (HttpURLConnection) url.openConnection();
			if (method == null || method.equals("GET")) {
				conn.setRequestMethod("GET");
			} else {
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
			}
			conn.setRequestProperty("User-agent", userAgent);
			conn.setUseCaches(false);
			conn.setConnectTimeout(DEF_CONN_TIMEOUT);
			conn.setReadTimeout(DEF_READ_TIMEOUT);
			conn.setInstanceFollowRedirects(false);
			conn.connect();
			if (params != null && method.equals("POST")) {
				try {
					DataOutputStream out = new DataOutputStream(conn.getOutputStream());
					out.writeBytes(urlencode(params));
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			InputStream is = conn.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sb.append(strRead);
			}
			rs = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
		return rs;
	}

	//将map型转为请求参数型
	public static String urlencode(Map<String, Object> data) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry i : data.entrySet()) {
			try {
				sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
