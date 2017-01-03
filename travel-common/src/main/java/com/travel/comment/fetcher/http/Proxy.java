package com.travel.comment.fetcher.http;

import java.util.Calendar;

public class Proxy {
	public Proxy(){}
	public Proxy(String ip,int port){
		long currTs = Calendar.getInstance().getTimeInMillis();
		this.ip = ip;
		this.port = port;
		this.validateTs = currTs;
		this.isBad = false;
	}
	private String ip;
	private int port;
	private long validateTs;
	private boolean isBad;
	private int sleepMinute;
	
	public String getIp() {
		return ip;
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
	public long getValidateTs() {
		return validateTs;
	}
	public void setValidateTs(long validateTs) {
		this.validateTs = validateTs;
	}
	public boolean isBad() {
		return isBad;
	}
	public void setBad(boolean isBad) {
		this.isBad = isBad;
	}
	public int getSleepMinute() {
		return sleepMinute;
	}
	public void setSleepMinute(int sleepMinute) {
		this.sleepMinute = sleepMinute;
	}
}
