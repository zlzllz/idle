package com.idle.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.idle.dao.OrderDao;
import com.idle.dao.ProductsDao;
import com.idle.dao.UsersDao;
import com.idle.entity.Order;
import com.idle.entity.Products;
import com.idle.entity.Users;

/**
 * @author caochenjie
 * @date 2017年5月07日 下午3:51:06
 */

public class OrderDaoImpl extends BaseDaoImpl implements OrderDao {

	ProductsDao pdao = new ProductsDaoImpl();
	UsersDao udao = new UsersDaoImpl();

	@Override
	public List<Order> getAll() {
		List<Order> list = new ArrayList<Order>();
		String sql = "select * from iorder";
		try {
			rs = super.executeQuery(sql, null);
			while (rs.next()) {
				Order o = new Order();
				o.setId(rs.getInt("id"));
				Products p = pdao.getById(rs.getInt("p_id"));
				o.setProduct(p);
				Users u = udao.getById(rs.getInt("u_id"));
				o.setUser(u);
				o.setMethod(rs.getInt("methodd"));
				o.setBegindate(rs.getDate("begindate"));
				o.setEnddate(rs.getDate("enddate"));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Order getById(int id) {
		Order o = null;
		String sql = "select * from iorder where id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(id);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				o = new Order();
				o.setId(rs.getInt("id"));
				Products p = pdao.getById(rs.getInt("p_id"));
				o.setProduct(p);
				Users u = udao.getById(rs.getInt("u_id"));
				o.setUser(u);
				o.setMethod(rs.getInt("methodd"));
				o.setBegindate(rs.getDate("begindate"));
				o.setEnddate(rs.getDate("enddate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return o;
	}

	@Override
	public int save(Order order) {
		String sql = "insert into iorder(p_id,u_id,begindate,methodd) values(?,?,sysdate,?)";
		List<Object> objs = new ArrayList<Object>();
		objs.add(order.getProduct().getId());
		objs.add(order.getUser().getId());
		objs.add(order.getMethod());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	@Override
	public int update(Order order) {
		String sql = "update iorder set p_id =?,u_id=? ,methodd=? where id=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(order.getProduct().getId());
		objs.add(order.getUser().getId());
		objs.add(order.getMethod());
		objs.add(order.getId());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	@Override
	public int delete(Order order) {
		String sql = "delete from iorder where id=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(order.getId());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	@Override
	public List<Order> getByU_id(int u_id) {
		List<Order> list = new ArrayList<Order>();
		String sql = "select * from iorder where u_id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(u_id);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Order o = new Order();
				o.setId(rs.getInt("id"));
				Products p = pdao.getById(rs.getInt("p_id"));
				o.setProduct(p);
				Users u = udao.getById(rs.getInt("u_id"));
				o.setUser(u);
				o.setMethod(rs.getInt("methodd"));
				o.setBegindate(rs.getDate("begindate"));
				o.setEnddate(rs.getDate("enddate"));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Order> getByP_id(int p_id) {
		List<Order> list = new ArrayList<Order>();
		String sql = "select * from iorder where p_id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(p_id);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Order o = new Order();
				o.setId(rs.getInt("id"));
				Products p = pdao.getById(rs.getInt("p_id"));
				o.setProduct(p);
				Users u = udao.getById(rs.getInt("u_id"));
				o.setUser(u);
				o.setMethod(rs.getInt("methodd"));
				o.setBegindate(rs.getDate("begindate"));
				o.setEnddate(rs.getDate("enddate"));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Order> getByMethod(int method) {
		List<Order> list = new ArrayList<Order>();
		String sql = "select * from iorder where methodd = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(method);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Order o = new Order();
				o.setId(rs.getInt("id"));
				Products p = pdao.getById(rs.getInt("p_id"));
				o.setProduct(p);
				Users u = udao.getById(rs.getInt("u_id"));
				o.setUser(u);
				o.setMethod(rs.getInt("methodd"));
				o.setBegindate(rs.getDate("begindate"));
				o.setEnddate(rs.getDate("enddate"));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Order> getByBegindate(String begindate) {
		List<Order> list = new ArrayList<Order>();
		String sql = "select * from iorder where to_char(begindate,'yyyy-mm-dd') = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(begindate);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Order o = new Order();
				o.setId(rs.getInt("id"));
				Products p = pdao.getById(rs.getInt("p_id"));
				o.setProduct(p);
				Users u = udao.getById(rs.getInt("u_id"));
				o.setUser(u);
				o.setMethod(rs.getInt("methodd"));
				o.setBegindate(rs.getDate("begindate"));
				o.setEnddate(rs.getDate("enddate"));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Order> getByEnddate(String enddate) {
		List<Order> list = new ArrayList<Order>();
		String sql = "select * from iorder where to_char(enddate,'yyyy-mm-dd') = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(enddate);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Order o = new Order();
				o.setId(rs.getInt("id"));
				Products p = pdao.getById(rs.getInt("p_id"));
				o.setProduct(p);
				Users u = udao.getById(rs.getInt("u_id"));
				o.setUser(u);
				o.setMethod(rs.getInt("methodd"));
				o.setBegindate(rs.getDate("begindate"));
				o.setEnddate(rs.getDate("enddate"));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int updateM(Order o) {
		String sql = "update iorder set methodd=1 where id=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(o.getProduct().getId());
		num = super.executeUpdate(sql, objs);
		return num;
	}

}
