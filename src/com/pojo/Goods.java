package com.pojo;

import java.sql.Date;

public class Goods {
	private int gid;
	private String gname;
	private String gkind;
	private int gnum;
	private String gdatein;
	private int gklong;
	private String gfrom;
	private int gcode;
	private Float gpricein;
	private Float gpriceout;

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

	public String getGkind() {
		return gkind;
	}

	public void setGkind(String gkind) {
		this.gkind = gkind;
	}

	public int getGnum() {
		return gnum;
	}

	public void setGnum(int gnum) {
		this.gnum = gnum;
	}

	public String getGdatein() {
		return gdatein;
	}

	public void setGdatein(String gdatein) {
		this.gdatein = gdatein;
	}

	public int getGklong() {
		return gklong;
	}

	public void setGklong(int gklong) {
		this.gklong = gklong;
	}

	public String getGfrom() {
		return gfrom;
	}

	public void setGfrom(String gfrom) {
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
