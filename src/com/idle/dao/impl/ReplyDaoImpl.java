package com.idle.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.idle.dao.NoteDao;
import com.idle.dao.ReplyDao;
import com.idle.dao.UsersDao;
import com.idle.entity.Note;
import com.idle.entity.Reply;
import com.idle.entity.Users;

/**
 * @author lilingzhi
 * @date 2017年5月09日 下午6:24:47
 */

public class ReplyDaoImpl extends BaseDaoImpl implements ReplyDao {
	NoteDao ndao = new NoteDaoImpl();
	UsersDao udao = new UsersDaoImpl();

	@Override
	public List<Reply> getAll() {
		List<Reply> list = new ArrayList<Reply>();
		String sql = "select * from ireply";
		try {
			rs = super.executeQuery(sql, null);
			while (rs.next()) {
				Reply r = new Reply();
				r.setId(rs.getInt("id"));
				Note n = ndao.getById(rs.getInt("n_id"));
				r.setNote(n);
				Users u = udao.getById(rs.getInt("u_id"));
				r.setUser(u);
				r.setReplycontent(rs.getString("replycontent"));
				r.setReplydate(rs.getDate("replydate"));
				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Reply getById(int id) {
		Reply r = null;
		String sql = "select * from ireply where id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(id);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				r = new Reply();
				r.setId(rs.getInt("id"));
				Note n = ndao.getById(rs.getInt("n_id"));
				r.setNote(n);
				Users u = udao.getById(rs.getInt("u_id"));
				r.setUser(u);
				r.setReplycontent(rs.getString("replycontent"));
				r.setReplydate(rs.getDate("replydate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public List<Reply> getByU_id(int id) {
		List<Reply> list = new ArrayList<Reply>();
		String sql = "select * from ireply where u_id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(id);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Reply r = new Reply();
				r.setId(rs.getInt("id"));
				Note n = ndao.getById(rs.getInt("n_id"));
				r.setNote(n);
				Users u = udao.getById(rs.getInt("u_id"));
				r.setUser(u);
				r.setReplycontent(rs.getString("replycontent"));
				r.setReplydate(rs.getDate("replydate"));
				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int save(Reply reply) {
		String sql = "insert into ireply(n_id,replycontent,u_id) values(?,?,?)";
		List<Object> objs = new ArrayList<Object>();
		objs.add(reply.getNote().getId());
		objs.add(reply.getReplycontent());
		objs.add(reply.getUser().getId());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	@Override
	public int update(Reply reply) {
		String sql = "update ireply set replycontent=? where id=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(reply.getReplycontent());
		objs.add(reply.getId());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	@Override
	public int delete(Reply reply) {
		String sql = "delete from ireply where id=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(reply.getId());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	@Override
	public Reply getByReplycontent1(String replycontent) {
		Reply r = null;
		String sql = "select * from ireply where replycontent = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(replycontent);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				r = new Reply();
				r.setId(rs.getInt("id"));
				Note n = ndao.getById(rs.getInt("n_id"));
				r.setNote(n);
				Users u = udao.getById(rs.getInt("u_id"));
				r.setUser(u);
				r.setReplycontent(rs.getString("replycontent"));
				r.setReplydate(rs.getDate("replydate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public List<Reply> getByDate(String date) {
		List<Reply> list = new ArrayList<Reply>();
		String sql = "select * from ireply where to_char(replydate,'yyyy-mm-dd') = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(date);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Reply r = new Reply();
				r.setId(rs.getInt("id"));
				Note n = ndao.getById(rs.getInt("n_id"));
				r.setNote(n);
				Users u = udao.getById(rs.getInt("u_id"));
				r.setUser(u);
				r.setReplycontent(rs.getString("replycontent"));
				r.setReplydate(rs.getDate("replydate"));
				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Reply> getByN_id(int id) {
		List<Reply> list = new ArrayList<Reply>();
		String sql = "select * from ireply where n_id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(id);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Reply r = new Reply();
				r.setId(rs.getInt("id"));
				Note n = ndao.getById(rs.getInt("n_id"));
				r.setNote(n);
				Users u = udao.getById(rs.getInt("u_id"));
				r.setUser(u);
				r.setReplycontent(rs.getString("replycontent"));
				r.setReplydate(rs.getDate("replydate"));
				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Reply> getByReplycontent(String replycontent) {
		List<Reply> list = new ArrayList<Reply>();
		String sql = "select * from ireply where replycontent LIKE '%" + replycontent + "%'";
		try {
			rs = super.executeQuery(sql, null);
			while (rs.next()) {
				Reply r = new Reply();
				r.setId(rs.getInt("id"));
				Note n = ndao.getById(rs.getInt("n_id"));
				r.setNote(n);
				Users u = udao.getById(rs.getInt("u_id"));
				r.setUser(u);
				r.setReplycontent(rs.getString("replycontent"));
				r.setReplydate(rs.getDate("replydate"));
				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
