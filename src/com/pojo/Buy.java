package com.pojo;

import java.util.Date;

public class Buy {
	private int bid;
	private float bprice;
	private Date bdatetime;
	private int bnum;
	private int bgid;
	private String bgname;

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public float getBprice() {
		return bprice;
	}

	public void setBprice(float bprice) {
		this.bprice = bprice;
	}

	public Date getBdatetime() {
		return bdatetime;
	}

	public void setBdatetime(Date bdatetime) {
		this.bdatetime = bdatetime;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public int getBgid() {
		return bgid;
	}

	public void setBgid(int bgid) {
		this.bgid = bgid;
	}

	public String getBgname() {
		return bgname;
	}

	public void setBgname(String bgname) {
		this.bgname = bgname;
	}

}
