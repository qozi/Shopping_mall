package com.pojo;

public class Kind {
	private int kid;
	private String kname;

	public int getKid() {
		return kid;
	}

	public void setKid(int kid) {
		this.kid = kid;
	}

	public String getKname() {
		return kname;
	}

	public void setKname(String kname) {
		this.kname = kname;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.kname;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.kid;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Kind) {
			Kind kind = (Kind) obj;
			if (kind.kid == this.kid) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
