package com.ptb.zeus.common.web.bean.response;

/**
 * 系统升级bean
 *
 * @author lenovo
 */
public class RepUpgrade {
	/**
	 * 测试数据
	 * @return
	 */
	public static RepUpgrade getDefult(){
		RepUpgrade repUpgrade =new RepUpgrade();
		repUpgrade.setTitle("发现新版本");
		repUpgrade.setDes("1、新增xx功能2、优化xx体验");
		repUpgrade.setVersion("1.2.0");
		repUpgrade.setFileSize(5464551);
		repUpgrade.setUrl("htpp://xxx.xxx.xxx/xx.apk");
		return repUpgrade;
	}
	
    private String title;
    private String des;
    private String version;
    private int isForce;
    private long fileSize;
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getIsForce() {
        return isForce;
    }

    public void setIsForce(int isForce) {
        this.isForce = isForce;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
