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
	String connectTimeMs;
	String country;
	String ip;
	String port;
	String province;
	String type;
	long addTime;

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

	public String getConnectTimeMs() {
		return connectTimeMs;
	}

	public void setConnectTimeMs(String connectTimeMs) {
		this.connectTimeMs = connectTimeMs;
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

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
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
