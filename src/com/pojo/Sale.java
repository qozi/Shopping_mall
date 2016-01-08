package com.pojo;

import java.util.Date;

public class Sale {
	private int sid;
	private float sprice;
	private Date sdatetime;
	private int snum;
	private int sgid;
	private String sgname;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public float getSprice() {
		return sprice;
	}

	public void setSprice(float sprice) {
		this.sprice = sprice;
	}

	public Date getSdatetime() {
		return sdatetime;
	}

	public void setSdatetime(Date sdatetime) {
		this.sdatetime = sdatetime;
	}

	public int getSnum() {
		return snum;
	}

	public void setSnum(int snum) {
		this.snum = snum;
	}

	public int getSgid() {
		return sgid;
	}

	public void setSgid(int sgid) {
		this.sgid = sgid;
	}

	public String getSgname() {
		return sgname;
	}

	public void setSgname(String sgname) {
		this.sgname = sgname;
	}

}
