package com.scheduler.spring.scheduling;

public class MailingDetails {
	
	private String fromMailAddress;
	private String fromMailPassword;
	private String toMailAddress1;

	public String getFromMailAddress() {
		return fromMailAddress;
	}

	public void setFromMailAddress(String fromMailAddress) {
		this.fromMailAddress = fromMailAddress;
	}

	public String getFromMailPassword() {
		return fromMailPassword;
	}

	public void setFromMailPassword(String fromMailPassword) {
		this.fromMailPassword = fromMailPassword;
	}

	public String getToMailAddress1() {
		return toMailAddress1;
	}

	public void setToMailAddress1(String toMailAddress1) {
		this.toMailAddress1 = toMailAddress1;
	}

}
