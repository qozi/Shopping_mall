package com.pojo;

public class Factory {
	private int fid;
	private String fname;
	private String fphone;

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFphone() {
		return fphone;
	}

	public void setFphone(String fphone) {
		this.fphone = fphone;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.fname;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.fid;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Factory) {
			Factory factory = (Factory) obj;
			if (factory.fid == this.fid) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
