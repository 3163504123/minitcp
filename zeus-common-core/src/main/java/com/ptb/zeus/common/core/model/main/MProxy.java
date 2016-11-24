package com.ptb.zeus.common.core.model.main;
import java.io.Serializable;

/**
 *
 * 
 *
 */
public class MProxy implements Serializable {
	String anonymity;
	String city;
	int connectTimeMs;
	String country;
	String ip;
	int port;
	String province;
	String type;
	long addTime;
	long checkTime;
	int isDy=0;


	public int getIsDy() {
		return isDy;
	}

	public void setIsDy(int isDy) {
		this.isDy = isDy;
	}

	public long getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(long checkTime) {
		this.checkTime = checkTime;
	}

	public int getConnectTimeMs() {
		return connectTimeMs;
	}

	public void setConnectTimeMs(int connectTimeMs) {
		this.connectTimeMs = connectTimeMs;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public long getAddTime() {
		return addTime;
	}

	public void setAddTime(long addTime) {
		this.addTime = addTime;
	}

	public String getAnonymity() {
		return anonymity;
	}

	public void setAnonymity(String anonymity) {
		this.anonymity = anonymity;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIp() {
		return ip;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
