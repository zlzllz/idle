package com.idle.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.idle.dao.NoteDao;
import com.idle.dao.ProductsDao;
import com.idle.dao.UsersDao;
import com.idle.entity.Note;
import com.idle.entity.Products;
import com.idle.entity.Users;

/**
 * @author zhangqi
 * @date 2017年5月14日 下午6:51:58
 */

public class NoteDaoImpl extends BaseDaoImpl implements NoteDao {

	UsersDao udao = new UsersDaoImpl();
	ProductsDao pdao = new ProductsDaoImpl();

	@Override
	public List<Note> getAll() {
		List<Note> list = new ArrayList<Note>();
		String sql = "select * from inote";
		try {
			rs = super.executeQuery(sql, null);
			while (rs.next()) {

				Note n = new Note();
				n.setId(rs.getInt("id"));
				Users u = udao.getById(rs.getInt("u_id"));
				n.setUser(u);
				Products p = pdao.getById(rs.getInt("p_id"));
				n.setProducts(p);

				n.setNotedate(rs.getDate("notedate"));
				n.setContent(rs.getString("contentt"));

				list.add(n);//
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int save(Note note) {
		String sql = "insert into inote(u_id,p_id,contentt) values(?,?,?)";
		List<Object> objs = new ArrayList<Object>();
		objs.add(note.getUser().getId());
		objs.add(note.getProducts().getId());
		objs.add(note.getContent());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	@Override
	public int update(Note note) {
		String sql = "update inote set id =?,p_id=?,contentt=? where id=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(note.getUser().getId());
		objs.add(note.getProducts().getId());
		objs.add(note.getContent());
		objs.add(note.getId());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	@Override
	public int delete(Note note) {
		String sql = "delete from inote where id=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(note.getId());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	@Override
	public Note getById(int id) {
		Note n = null;
		String sql = "select * from inote where id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(id);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				n = new Note();
				n.setId(rs.getInt("id"));
				Users u = udao.getById(rs.getInt("u_id"));
				n.setUser(u);
				Products p = pdao.getById(rs.getInt("p_id"));
				n.setProducts(p);
				n.setNotedate(rs.getDate("notedate"));
				n.setContent(rs.getString("contentt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public List<Note> getByP_Id(int id) {
		List<Note> list = new ArrayList<Note>();
		list = new ArrayList<Note>();
		String sql = "select * from inote where p_id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(id);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Note n = new Note();
				n.setId(rs.getInt("id"));
				Users u = udao.getById(rs.getInt("u_id"));
				n.setUser(u);
				Products p = pdao.getById(rs.getInt("p_id"));
				n.setProducts(p);
				n.setNotedate(rs.getDate("notedate"));
				n.setContent(rs.getString("contentt"));
				list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public Note getByContent1(String content) {
		Note n = null;
		String sql = "select * from inote where contentt = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(content);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				 n = new Note();
				n.setId(rs.getInt("id"));
				Users u = udao.getById(rs.getInt("u_id"));
				n.setUser(u);
				Products p = pdao.getById(rs.getInt("p_id"));
				n.setProducts(p);
				n.setNotedate(rs.getDate("notedate"));
				n.setContent(rs.getString("contentt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public List<Note> getByDate(String notedate) {
		List<Note> list = new ArrayList<Note>();
		list = new ArrayList<Note>();
		String sql = "select * from inote where to_char(notedate,'yyyy-mm-dd') = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(notedate);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Note n = new Note();
				n.setId(rs.getInt("id"));
				Users u = udao.getById(rs.getInt("u_id"));
				n.setUser(u);
				Products p = pdao.getById(rs.getInt("p_id"));
				n.setProducts(p);
				n.setNotedate(rs.getDate("notedate"));
				n.setContent(rs.getString("contentt"));
				list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Note> getByU_Id(int id) {
		List<Note> list = new ArrayList<Note>();
		String sql = "select * from inote where u_id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(id);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Note n = new Note();
				n.setId(rs.getInt("id"));
				Users u = udao.getById(rs.getInt("u_id"));
				n.setUser(u);
				Products p = pdao.getById(rs.getInt("p_id"));
				n.setProducts(p);
				n.setNotedate(rs.getDate("notedate"));
				n.setContent(rs.getString("contentt"));
				list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Note> getByContent(String content) {
		List<Note> list = new ArrayList<Note>();
		String sql = "select * from inote where contentt LIKE '%" + content + "%'";
		try {
			rs = super.executeQuery(sql, null);
			while (rs.next()) {
				Note n = new Note();
				n.setId(rs.getInt("id"));
				Users u = udao.getById(rs.getInt("u_id"));
				n.setUser(u);
				Products p = pdao.getById(rs.getInt("p_id"));
				n.setProducts(p);
				n.setNotedate(rs.getDate("notedate"));
				n.setContent(rs.getString("contentt"));
				list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}