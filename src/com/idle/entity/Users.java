package com.idle.entity;

/**
 * @author hanyufei
 * @date 2017年5月09日 下午7:34:47
 */

public class Users {
	private int id;
	private String username;
	private String password;
	private String sex;
	private String tel;
	private String address;
	private Number idnum;
	private Number cardnum;
	private int grade;

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password="
				+ password + ", sex=" + sex + ", tel=" + tel + ", address="
				+ address + ", idnum=" + idnum + ", cardnum=" + cardnum
				+ ", grade=" + grade + "]";
	}

	public Users() {
	}

	public Users(String username, String password, String sex, String tel,
			String address, Long idnum, Long cardnum) {
		super();
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.tel = tel;
		this.address = address;
		this.idnum = idnum;
		this.cardnum = cardnum;
	}

	// 新增
	public Users(String username, String password, String sex,
			String tel, String address, Long idnum, Long cardnum, int grade) {
		super();
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.tel = tel;
		this.address = address;
		this.idnum = idnum;
		this.cardnum = cardnum;
		this.grade = grade;
	}
	
	// 更新
	public Users(int id, String username, String password, String sex,
			String tel, String address, Long idnum, Long cardnum, int grade) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.tel = tel;
		this.address = address;
		this.idnum = idnum;
		this.cardnum = cardnum;
		this.grade = grade;
	}

	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Number getIdnum() {
		return idnum;
	}

	public void setIdnum(Number idnum) {
		this.idnum = idnum;
	}

	public Number getCardnum() {
		return cardnum;
	}

	public void setCardnum(Number cardnum) {
		this.cardnum = cardnum;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

}
