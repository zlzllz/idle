package com.idle.entity;

import java.sql.Date;

public class Note {

	private int id;
	private Users user;// 留言的人
	private Products Products;
	private Date notedate;
	private String content;

	@Override
	public String toString() {
		return "Note [id=" + id + ", user=" + user + ", Products=" + Products
				+ ", notedate=" + notedate + ", content=" + content + "]";
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

	public Products getProducts() {
		return Products;
	}

	public void setProducts(Products Products) {
		this.Products = Products;
	}

	public Date getNotedate() {
		return notedate;
	}

	public void setNotedate(Date notedate) {
		this.notedate = notedate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Note() {
	}

	public Note(int id, Users user, Products Products, Date notedate,
			String content) {
		super();
		this.id = id;
		this.user = user;
		this.Products = Products;
		this.notedate = notedate;
		this.content = content;
	}
	
	public Note(int id,Users user, Products Products,
			String content) {
		super();
		this.id = id;
		this.user = user;
		this.Products = Products;
		this.content = content;
	}

	public Note(Users user, Products Products, String content) {
		super();
		this.user = user;
		this.Products = Products;
		this.content = content;
	}

}
