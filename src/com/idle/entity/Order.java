package com.idle.entity;

import java.sql.Date;

/**
 * @author caochenjie
 * @date 2017年5月07日 下午6:29:06
 */

public class Order {
	private int id;
	private Products product;
	private Users user;//下单用户
	private int method;// 是否见面交易，
	private Date begindate;
	private Date enddate;

	@Override
	public String toString() {
		return "Order [id=" + id + ", product=" + product + ", user=" + user
				+ ", method=" + method + ", begindate=" + begindate
				+ ", enddate=" + enddate + "]";
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public int getMethod() {
		return method;
	}

	public void setMethod(int method) {
		this.method = method;
	}

	public Date getBegindate() {
		return begindate;
	}

	public void setBegindate(Date begindate) {
		this.begindate = begindate;
	}

	public Order(int id, Products product, Users user, int method,
			Date begindate, Date enddate) {
		super();
		this.id = id;
		this.product = product;
		this.user = user;
		this.method = method;
		this.begindate = begindate;
		this.enddate = enddate;
	}

	public Order() {
	}

	public Order(Products product, Users user, int method) {
		this.product = product;
		this.user = user;
		this.method = method;
	}

	public Order(int id, Products product, Users user, int method) {
		super();
		this.id = id;
		this.product = product;
		this.user = user;
		this.method = method;
	}

	public Order(int id) {
		this.id = id;
	}

}
