package com.tiger.javase.map;

public class ObjKey {
	private int id;
	private int old;
	private String name;

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		if (this.id != ((ObjKey) obj).id)
			return false;
		return true;
	}

	public int hashCode() {
		final int ii = 8;
		final int jj = 10;
		return ii * jj + this.id;
	}

	public int getId() {
		return id;
	}

	public ObjKey(final int id, int old, String name) {
		super();
		this.id = id;
		this.old = old;
		this.name = name;
	}

	public int getOld() {
		return old;
	}

	public void setOld(int old) {
		this.old = old;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
