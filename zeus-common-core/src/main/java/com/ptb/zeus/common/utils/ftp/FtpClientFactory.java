package com.ptb.zeus.common.utils.ftp;


import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.pool.PoolableObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by MyThinkpad on 2016/6/24.
 */
public class FtpClientFactory implements PoolableObjectFactory<FTPClient> {
    private static Logger logger = LoggerFactory.getLogger(FtpClientFactory.class);

    private  FTPClientConfigure config;


    //给工厂传入一个参数对象，方便配置FTPClient的相关参数
    public FtpClientFactory(FTPClientConfigure config){
        this.config=config;
    }

    public FTPClient makeObject()throws Exception {
        int retryTimes = config.getRetryTimes();
        FTPClient ftpClient = null;
        while (retryTimes-- > 0){
            ftpClient = realMakeObject();
            if(null == ftpClient)
                logger.warn(String.format("The %d connection remote FTP server", config.getRetryTimes() - retryTimes));
            else
                break;
        }
        return ftpClient;
    }

    /* (non-Javadoc)
    * @see org.apache.commons.pool.PoolableObjectFactory#makeObject()
    */
    private FTPClient realMakeObject() throws Exception {
        FTPClient ftpClient = new FTPClient();
        ftpClient.setConnectTimeout(config.getClientTimeout());
        try {
            ftpClient.connect(config.getHost(), config.getPort());
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                logger.warn("FTPServer refused connection");
                return null;
            }
            boolean result = ftpClient.login(config.getUsername(), config.getPassword());
            if (!result) {
                logger.warn("FTPServer authfailed!!!");
                return null;
            }
            ftpClient.setKeepAlive(config.isKeepAlive());
            //ftpClient.setControlKeepAliveReplyTimeout(300);
            //ftpClient.setControlKeepAliveTimeout();
            ftpClient.setFileType(config.getTransferFileType());
            ftpClient.setBufferSize(1024);
            ftpClient.setControlEncoding(config.getEncoding());
            if (config.getPassiveMode().equals("true")) {
                ftpClient.enterLocalPassiveMode();
            }
        } catch (IOException e) {
            e.printStackTrace();
            ftpClient = null;
        }
        return ftpClient;
    }

    /* (non-Javadoc)
    * @see org.apache.commons.pool.PoolableObjectFactory#destroyObject(java.lang.Object)
    */
    public void destroyObject(FTPClient ftpClient) throws Exception {
        try {
            if (ftpClient != null && ftpClient.isConnected()) {
                ftpClient.logout();
            }
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            // 注意,一定要在finally代码中断开连接，否则会导致占用ftp连接情况
            try {
                ftpClient.disconnect();
            } catch (IOException io) {
                io.printStackTrace();
            }
        }
    }

    /* (non-Javadoc)
    * @see org.apache.commons.pool.PoolableObjectFactory#validateObject(java.lang.Object)
    */
    public boolean validateObject(FTPClient ftpClient) {
        try {
            return ftpClient.sendNoOp();
        } catch (IOException e) {
            throw new RuntimeException("Failed to validate client: " + e, e);
        }
    }

    public void activateObject(FTPClient ftpClient) throws Exception {
    }

    public void passivateObject(FTPClient ftpClient) throws Exception {

    }

}
