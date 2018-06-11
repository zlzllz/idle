package com.idle.entity;

public class Express {
	private int id;
	private String ename;
	private double perprice;

	@Override
	public String toString() {
		return "Express [id=" + id + ", ename=" + ename + ", perprice="
				+ perprice + "]";
	}

	public Express() {
	}

	public Express(String ename, double perprice) {
		super();
		this.ename = ename;
		this.perprice = perprice;
	}

	public Express(int id, String ename, double perprice) {
		super();
		this.id = id;
		this.ename = ename;
		this.perprice = perprice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getPerprice() {
		return perprice;
	}

	public void setPerprice(double perprice) {
		this.perprice = perprice;
	}

}
