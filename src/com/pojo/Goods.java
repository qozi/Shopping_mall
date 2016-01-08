package com.pojo;

import java.util.Date;

public class Goods {
	private int gid;
	private String gname;
	private int gkind;
	private String gkindname;
	private int gnum;
	private Date gdatein;
	private int gklong;
	private int gfrom;
	private String gfromname;
	private int gcode;
	private Float gpricein;
	private Float gpriceout;

	public String getGkindname() {
		return gkindname;
	}

	public void setGkindname(String gkindname) {
		this.gkindname = gkindname;
	}

	public String getGfromname() {
		return gfromname;
	}

	public void setGfromname(String gfromname) {
		this.gfromname = gfromname;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public int getGkind() {
		return gkind;
	}

	public void setGkind(int gkind) {
		this.gkind = gkind;
	}

	public int getGnum() {
		return gnum;
	}

	public void setGnum(int gnum) {
		this.gnum = gnum;
	}

	public Date getGdatein() {
		return gdatein;
	}

	public void setGdatein(Date gdatein) {
		this.gdatein = gdatein;
	}

	public int getGklong() {
		return gklong;
	}

	public void setGklong(int gklong) {
		this.gklong = gklong;
	}

	public int getGfrom() {
		return gfrom;
	}

	public void setGfrom(int gfrom) {
		this.gfrom = gfrom;
	}

	public int getGcode() {
		return gcode;
	}

	public void setGcode(int gcode) {
		this.gcode = gcode;
	}

	public Float getGpricein() {
		return gpricein;
	}

	public void setGpricein(Float gpricein) {
		this.gpricein = gpricein;
	}

	public Float getGpriceout() {
		return gpriceout;
	}

	public void setGpriceout(Float gpriceout) {
		this.gpriceout = gpriceout;
	}
}
