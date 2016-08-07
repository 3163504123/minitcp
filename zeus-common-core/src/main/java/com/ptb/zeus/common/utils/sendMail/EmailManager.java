package com.ptb.zeus.common.utils.sendMail;


import com.ptb.zeus.common.utils.sendMail.mail.SendMail;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by MyThinkpad on 2015/11/25.
 */
public class EmailManager implements Runnable {

    public static final Integer ACTIVATION = 0;
    public static final Integer EXPIRE = 1;
    public static final Integer FINDPASSWORD = 2;

    ConcurrentLinkedQueue<EmailBody> queue;

    public EmailManager() {
        queue = new ConcurrentLinkedQueue<EmailBody>();
        new Thread(this).start();
    }

    private boolean sendEmailAsync(EmailBody msg) {
        return queue.offer(msg);
    }

    public boolean setActivationEmailBody(String userName, String email, String url) {
        EmailBody body = new EmailBody(ACTIVATION);
        body.userName = userName;
        body.email = email;
        body.url = url;
        return sendEmailAsync(body);
    }

    public boolean setFindPasswordEmailBody(String userName, String email, String url) {
        EmailBody body = new EmailBody(FINDPASSWORD);
        body.userName = userName;
        body.email = email;
        body.url = url;
        return sendEmailAsync(body);
    }

    public boolean setExpireEmailBody(Map map) {
        EmailBody body = new EmailBody(EXPIRE);
        body.map = map;
        return sendEmailAsync(body);
    }

    @Override
    public void run() {
        while (true) {
            EmailBody body;
            boolean ret;
            if ((body = queue.poll()) != null) {

                if (ACTIVATION == body.type) {
                    long sTime = System.currentTimeMillis();
                    ret = SendMail.testMailTemplateActive(body.userName, body.email, body.url);
                    long eTime = System.currentTimeMillis();
                    System.out.println("testMailActive:" + new Date() + "---Take " + (eTime - sTime) / 1000.0 + "s second sresult:" + ret);
                } else if (EXPIRE == body.type) {
                    long sTime = System.currentTimeMillis();
                    ret = SendMail.testMailTemplateMonitorNoFile(body.map);
                    long eTime = System.currentTimeMillis();
                    System.out.println("testMailMonitor:" + new Date() + "---Take " + (eTime - sTime) / 1000.0 + "s second sresult:" + ret);
                } else if (FINDPASSWORD == body.type) {
                    long sTime = System.currentTimeMillis();
                    ret = SendMail.testMainTemplateFindPassword(body.userName, body.email, body.url);
                    long eTime = System.currentTimeMillis();
                    System.out.println("testMailFind:" + new Date() + "---Take " + (eTime - sTime) / 1000.0 + "s second sresult:" + ret);

                } else {
                    System.out.println("type not support");
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public class EmailBody {
        Integer type;
        public String userName;
        public String email;
        public String url;
        public Map map;

        public EmailBody(Integer type) {
            this.type = type;
        }
    }

}
