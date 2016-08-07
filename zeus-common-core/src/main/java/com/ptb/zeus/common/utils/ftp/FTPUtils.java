package com.ptb.zeus.common.utils.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by MyThinkpad on 2016/6/26.
 */
public class FTPUtils {

    static Logger log = Logger.getLogger(FTPUtils.class);

    static FTPClientConfigure ftpClientConfigure;

    static{
        try {
            ftpClientConfigure = new FTPClientConfigure();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean uploadFileToFTP(String filename, InputStream inputStream){
        FTPClient ftpClient = new FTPClient();;
        boolean ret = false;
        try {
            ftpClient.setConnectTimeout(ftpClientConfigure.getClientTimeout());
            ftpClient.connect(ftpClientConfigure.getHost(), ftpClientConfigure.getPort());
            ftpClient.login(ftpClientConfigure.getUsername(), ftpClientConfigure.getPassword());
            ftpClient.setFileType(ftpClientConfigure.getTransferFileType());
            ftpClient.setBufferSize(1024);
            ftpClient.setControlEncoding(ftpClientConfigure.getEncoding());
            if (ftpClientConfigure.getPassiveMode().equals("true")) {
                ftpClient.enterLocalPassiveMode();
            }
            if (!ftpClient.changeWorkingDirectory(ftpClientConfigure.getRelativedir())) {
                        log.error("change dir to " + ftpClientConfigure.getRelativedir() + " fail");
                        throw new IOException("change dir to " + ftpClientConfigure.getRelativedir() + " fail");
            }
            ret = ftpClient.storeFile(filename, inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                log.error(String.format("ftpClient.disconnect %s", e.getMessage()));
            }
        }
        return ret;
    }
}
