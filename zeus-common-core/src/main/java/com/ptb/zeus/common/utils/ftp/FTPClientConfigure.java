package com.ptb.zeus.common.utils.ftp;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;

/**
 * Created by MyThinkpad on 2016/6/24.
 */
public class FTPClientConfigure {
    static Logger log = Logger.getLogger(FTPClientConfigure.class);
    private  String host;
    private  int port;
    private  String username;
    private  String password;
    private  String passiveMode;
    private  String encoding;
    private  int clientTimeout;
    private  int threadNum;
    private  int transferFileType;
    private  boolean renameUploaded;
    private  int retryTimes;
    private  String relativedir;
    private  boolean keepAlive;


    public FTPClientConfigure(){
        try {
            log.info("FTP配置文件载入开始");
            Configuration conf = new PropertiesConfiguration("ptb.properties");

            this.host = conf.getString("zeus.ftp.host");
            this.port = conf.getInt("zeus.ftp.port", 21);
            this.username = conf.getString("zeus.ftp.username");
            this.password = conf.getString("zeus.ftp.password");
            this.clientTimeout = conf.getInt("zeus.ftp.clientTimeout", 2000);
            this.passiveMode = conf.getString("zeus.ftp.passivemode", "true");
            this.transferFileType = conf.getInt("zeus.ftp.transferFileType", 2);
            this.encoding = conf.getString("zeus.ftp.encoding", "utf8");
            this.relativedir = conf.getString("zeus.ftp.relativedir", "./user/img/");
            this.threadNum = conf.getInt("zeus.ftp.threadNum", 5);
            this.retryTimes = conf.getInt("zeus.ftp.retryTimes", 2);
            this.keepAlive = conf.getBoolean("zeus.ftp.keepAlive", true);
            log.info("FTP配置文件载入完成");
            this.toString();
        } catch (ConfigurationException e) {
            e.printStackTrace();
            log.error("FTP配置文件读取失败");
        }
    }

    public int getRetryTimes() {
        return retryTimes;
    }

    public void setRetryTimes(int retryTimes) {
        this.retryTimes = retryTimes;
    }

    public boolean isRenameUploaded() {
        return renameUploaded;
    }

    public void setRenameUploaded(boolean renameUploaded) {
        this.renameUploaded = renameUploaded;
    }

    public int getTransferFileType() {
        return transferFileType;
    }

    public void setTransferFileType(int transferFileType) {
        this.transferFileType = transferFileType;
    }

    public int getThreadNum() {
        return threadNum;
    }

    public void setThreadNum(int threadNum) {
        this.threadNum = threadNum;
    }

    public int getClientTimeout() {
        return clientTimeout;
    }

    public void setClientTimeout(int clientTimeout) {
        this.clientTimeout = clientTimeout;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getPassiveMode() {
        return passiveMode;
    }

    public void setPassiveMode(String passiveMode) {
        this.passiveMode = passiveMode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public String toString() {
        return "FTPClientConfig [host=" + host + "\n port=" + port + "\n username=" + username + "\n password=" + password   + "\n passiveMode=" + passiveMode
                + "\n encoding=" + encoding + "\n clientTimeout=" + clientTimeout + "\n threadNum=" + threadNum + "\n transferFileType="
                + transferFileType + "\n renameUploaded=" + renameUploaded + "\n retryTimes=" + retryTimes + "]" ;
    }

    public String getRelativedir() {
        return relativedir;
    }

    public void setRelativedir(String relativedir) {
        this.relativedir = relativedir;
    }


    public boolean isKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
    }
}
