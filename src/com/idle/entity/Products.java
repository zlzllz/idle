package com.idle.entity;

import java.sql.Date;

/**
 * @author yangluyu
 * @date 2017年5月12日 下午3:46:58
 */

public class Products {

	private int id;
	private Users user;
	private String pname;
	private String types;
	private double oldprice;
	private double currentprice;
	private String description;
	private String img;
	private Date releasedate;
	private int status;

	
	@Override
	public String toString() {
		return "Products [id=" + id + ", user=" + user + ", pname=" + pname
				+ ", types=" + types + ", oldprice=" + oldprice
				+ ", currentprice=" + currentprice + ", description="
				+ description + ", img=" + img + ", releasedate=" + releasedate
				+ ", status=" + status + "]";
	}

	public Products(int id, Users user, String pname, String types,
			double oldprice, double currentprice, String description,
			String img, Date releasedate, int status) {
		super();
		this.id = id;
		this.user = user;
		this.pname = pname;
		this.types = types;
		this.oldprice = oldprice;
		this.currentprice = currentprice;
		this.description = description;
		this.img = img;
		this.releasedate = releasedate;
		this.status = status;
	}
	
	public Products( Users user, String pname, String types,
			double oldprice, double currentprice, String description,
			String img, int status) {
		super();
		this.user = user;
		this.pname = pname;
		this.types = types;
		this.oldprice = oldprice;
		this.currentprice = currentprice;
		this.description = description;
		this.img = img;
		this.status = status;
	}
	
	public Products(int id, Users user, String pname, String types,
			double oldprice, double currentprice, String description,
			String img, int status) {
		super();
		this.id = id;
		this.user = user;
		this.pname = pname;
		this.types = types;
		this.oldprice = oldprice;
		this.currentprice = currentprice;
		this.description = description;
		this.img = img;
		this.status = status;
	}

	public Products() {

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

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public double getOldprice() {
		return oldprice;
	}

	public void setOldprice(double oldprice) {
		this.oldprice = oldprice;
	}

	public double getCurrentprice() {
		return currentprice;
	}

	public void setCurrentprice(double currentprice) {
		this.currentprice = currentprice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Date getReleasedate() {
		return releasedate;
	}

	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	// toString

}
