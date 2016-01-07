package com.pojo;

public class Position {
	private int poid;
	private String poname;

	public int getPoid() {
		return poid;
	}

	public void setPoid(int poid) {
		this.poid = poid;
	}

	public String getPoname() {
		return poname;
	}

	public void setPoname(String poname) {
		this.poname = poname;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.poname;
	}
}
