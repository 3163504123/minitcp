package com.ptb.zeus.common.utils.ftp;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadImage {
	public static void download(String urlString, String filename) throws Exception {  
       URL url = new URL(urlString);  
       URLConnection con = url.openConnection();  
       con.setConnectTimeout(5*1000);  
       InputStream is = con.getInputStream();  
       FTPUtils.uploadFileToFTP(filename, is);
    }   
  
}  

