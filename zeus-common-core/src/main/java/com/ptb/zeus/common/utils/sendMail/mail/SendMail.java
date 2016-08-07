package com.ptb.zeus.common.utils.sendMail.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by MyThinkpad on 2015/11/25.
 */
public class SendMail {
    private static Logger log = LoggerFactory.getLogger(SendMail.class);

    public static String getNowDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static boolean testMailTemplateActive(String userName, String email, String url) {
        String templateName = "NewActiveMail.ftl";
        Map<String, String> map = new HashMap<String, String>();
        //map.put("username", userName.split("@")[0]);
        map.put("refurl", url);
        map.put("realurl", url);
        //map.put("time", getNowDateShort());
        System.out.println(userName + " " + url);
        try {
            MailUtil.sendMailByTemplate(email, "注册验证邮件【品推宝】", map, templateName);
            return true;
        } catch (Exception e) {
            log.error(e.toString(), e);
        }
        return false;
    }


    public static boolean testMainTemplateFindPassword(String username, String email, String url) {
        String templateName = "NewFindPassMail.ftl";
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", username);
        map.put("refurl", url);
        map.put("realurl", url);
        System.out.println(username + " " + url);
        try {
            MailUtil.sendMailByTemplate(email, "找回密码验证邮件【品推宝】", map, templateName);
            return true;
        } catch (Exception e) {
            log.error(e.toString(), e);
        }
        return false;
    }

    public static boolean testMailTemplateMonitorNoFile(Map argMap) {
        String templateName = "NewMonitorTemplate.ftl";
        System.out.println(argMap.toString());
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", argMap.get("userName").toString().split("@")[0]);
        map.put("task", argMap.get("taskName").toString());
        String eDate = argMap.get("eTime").toString();
        //map.put("ey", eDate.substring(0, 4));
        map.put("em", eDate.substring(5, 7));
        map.put("ed", eDate.substring(8, 10));
        map.put("et", eDate.substring(11, 16));
        map.put("readNum", argMap.get("totalread").toString());
        map.put("zanNum", argMap.get("totalzan").toString());
        //map.put("time", getNowDateShort());
        try {
            if (argMap.containsKey("file"))
                MailUtil.sendMailAndFileByTemplate(argMap.get("email").toString(), "任务完成-通知", argMap.get("file").toString(), map, templateName);
            else
                MailUtil.sendMailByTemplate(argMap.get("email").toString(), "任务完成-通知", map, templateName);
            return true;
        } catch (Exception e) {
            log.error(e.toString(), e);
        }
        return false;
    }
}