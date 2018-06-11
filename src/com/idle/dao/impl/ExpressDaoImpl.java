package com.idle.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.idle.dao.ExpressDao;
import com.idle.entity.Express;

/**
 * @author zhangqi
 * @date 2017年5月14日 下午5:51:58
 */

public class ExpressDaoImpl extends BaseDaoImpl implements ExpressDao {

	@Override
	public List<Express> getAll() {
		List<Express> list = new ArrayList<Express>();
		String sql = "select * from iexpress";
		try {
			rs = super.executeQuery(sql, null);
			while (rs.next()) {
				Express e = new Express();
				e.setId(rs.getInt("id"));
				e.setEname(rs.getString("ename"));
				e.setPerprice(rs.getDouble("perprice"));
				list.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int save(Express express) {
		String sql = "insert into iexpress(ename,perprice) values(?,?)";
		List<Object> objs = new ArrayList<Object>();
		objs.add(express.getEname());
		objs.add(express.getPerprice());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	@Override
	public int update(Express express) {
		String sql = "update iexpress set ename=?,perprice=? where id =?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(express.getEname());
		objs.add(express.getPerprice());
		objs.add(express.getId());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	@Override
	public int delete(Express express) {
		String sql = "delete from iexpress where id=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(express.getId());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	@Override
	public Express getById(int id) {
		Express e = null;
		String sql = "select * from iexpress where id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(id);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				e = new Express();
				e.setId(rs.getInt("id"));
				e.setEname(rs.getString("ename"));
				e.setPerprice(rs.getDouble("perprice"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return e;
	}

	@Override
	public Express getByEname(String ename) {
		Express e = null;
		String sql = "select * from iexpress where ename = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(ename);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				e = new Express();
				e.setId(rs.getInt("id"));
				e.setEname(rs.getString("ename"));
				e.setPerprice(rs.getDouble("perprice"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return e;
	}

	@Override
	public List<Express> getByPerprice(double perprice) {
		List<Express> list = new ArrayList<Express>();
		String sql = "select * from iexpress where perprice = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(perprice);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Express e = new Express();
				e.setId(rs.getInt("id"));
				e.setEname(rs.getString("ename"));
				e.setPerprice(rs.getDouble("perprice"));
				list.add(e);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return list;
	}

}
