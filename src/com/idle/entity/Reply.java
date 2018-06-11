package com.idle.entity;

import java.sql.Date;

/**
 * @author lilingzhi
 * @date 2017年5月05日 下午2:24:47
 */

public class Reply {
	private int id;
	private Note note;
	private String replycontent;
	private Date replydate;
	private Users user;// 回复留言的人,就是发布商品的人

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public String getReplycontent() {
		return replycontent;
	}

	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}

	public Date getReplydate() {
		return replydate;
	}

	public void setReplydate(Date replydate) {
		this.replydate = replydate;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Reply(int id, Note note, String replycontent, Date replydate,
			Users user) {
		super();
		this.id = id;
		this.note = note;
		this.replycontent = replycontent;
		this.replydate = replydate;
		this.user = user;
	}

	public Reply(int id, String replycontent) {
		super();
		this.id = id;
		this.replycontent = replycontent;
	}

	public Reply(Note note, String replycontent, Users user) {
		super();
		this.note = note;
		this.replycontent = replycontent;
		this.user = user;
	}

	public Reply() {
	}

	@Override
	public String toString() {
		return "Reply [id=" + id + ", note=" + note + ", replycontent="
				+ replycontent + ", replydate=" + replydate + ", user=" + user
				+ "]";
	}

}
