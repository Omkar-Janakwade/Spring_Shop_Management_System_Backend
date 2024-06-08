package com.newproject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class GetConnection {

	@Id
	private String fullname;
	private String password;
	private String address;
	private long mobno;
	private String emailid;
	private int dailybottle;
	private String startdate;
	private String totalbottle;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobno() {
		return mobno;
	}

	public void setMobno(long mobno) {
		this.mobno = mobno;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public int getDailybottle() {
		return dailybottle;
	}

	public void setDailybottle(int dailybottle) {
		this.dailybottle = dailybottle;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	

	public String getTotalbottle() {
		return totalbottle;
	}

	public void setTotalbottle(String totalbottle) {
		this.totalbottle = totalbottle;
	}

	@Override
	public String toString() {
		return "GetConnection [fullname=" + fullname + ", password=" + password + ", address=" + address + ", mobno="
				+ mobno + ", emailid=" + emailid + ", dailybottle=" + dailybottle + ", startdate=" + startdate
				+ ", totalbottle=" + totalbottle + "]";
	}

	

}
