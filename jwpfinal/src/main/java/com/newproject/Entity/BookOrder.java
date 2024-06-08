package com.newproject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BookOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String fullname;
	private String address;
	private String mobno;
	private String emailid;
	private String date;
	private String totalbottle;
	private String provide ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTotalbottle() {
		return totalbottle;
	}

	public void setTotalbottle(String totalbottle) {
		this.totalbottle = totalbottle;
	}

	public String getProvide() {
		return provide;
	}

	public void setProvide(String provide) {
		this.provide = provide;
	}

	@Override
	public String toString() {
		return "BookOrder [id=" + id + ", fullname=" + fullname + ", address=" + address + ", mobno=" + mobno
				+ ", emailid=" + emailid + ", date=" + date + ", totalbottle=" + totalbottle + ", provide=" + provide
				+ "]";
	}

}
