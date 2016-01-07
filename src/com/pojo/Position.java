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

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.poid;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Position) {
			Position position = (Position) obj;
			if (position.poid == this.poid) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
