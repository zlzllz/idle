package com.idle.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.idle.dao.ProductsDao;
import com.idle.dao.UsersDao;
import com.idle.entity.Products;
import com.idle.entity.Users;

/**
 * @author yangluyu
 * @date 2017年5月11日 下午8:51:58
 */

public class ProductsDaoImpl extends BaseDaoImpl implements ProductsDao {
	UsersDao udao = new UsersDaoImpl();

	@Override
	public List<Products> getAll() {
		List<Products> list = new ArrayList<Products>();
		String sql = "select * from iproducts";
		try {
			rs = super.executeQuery(sql, null);
			while (rs.next()) {
				Products p = new Products();
				p.setId(rs.getInt("id"));

				Users u = udao.getById(rs.getInt("u_id"));
				p.setUser(u);

				p.setPname(rs.getString("pname"));
				p.setTypes(rs.getString("typee"));
				p.setOldprice(rs.getDouble("oldprice"));
				p.setCurrentprice(rs.getDouble("currentprice"));
				p.setDescription(rs.getString("description"));
				p.setImg(rs.getString("img"));
				p.setReleasedate(rs.getDate("releasedate"));
				p.setStatus(rs.getInt("status"));

				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int save(Products products) {
		String sql = "insert into iproducts(u_id,pname,typee,oldprice,currentprice,description,img) values(?,?,?,?,?,?,?)";
		List<Object> objs = new ArrayList<Object>();
		objs.add(products.getUser().getId());
		objs.add(products.getPname());
		objs.add(products.getTypes());
		objs.add(products.getOldprice());
		objs.add(products.getCurrentprice());
		objs.add(products.getDescription());
		objs.add(products.getImg());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	@Override
	public int update(Products products) {
		String sql = "update iproducts set u_id =?,pname=?,typee=?,oldprice=?,currentprice=?,description=?,img=?,status=? where id=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(products.getUser().getId());
		objs.add(products.getPname());
		objs.add(products.getTypes());
		objs.add(products.getOldprice());
		objs.add(products.getCurrentprice());
		objs.add(products.getDescription());
		objs.add(products.getImg());
		objs.add(products.getStatus());
		objs.add(products.getId());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	@Override
	public int delete(Products products) {
		String sql = "delete from iproducts where id=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(products.getId());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	@Override
	public Products getById(int id) {
		Products p = null;
		String sql = "select * from iproducts where id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(id);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				p = new Products();
				p.setId(rs.getInt("id"));
				Users u = udao.getById(rs.getInt("u_id"));
				p.setUser(u);
				p.setPname(rs.getString("pname"));
				p.setTypes(rs.getString("typee"));
				p.setOldprice(rs.getDouble("oldprice"));
				p.setCurrentprice(rs.getDouble("currentprice"));
				p.setDescription(rs.getString("description"));
				p.setImg(rs.getString("img"));
				p.setReleasedate(rs.getDate("releasedate"));
				p.setStatus(rs.getInt("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Products> getByU_id(int u_id) {
		List<Products> list = new ArrayList<Products>();
		String sql = "select * from iproducts where u_id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(u_id);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Products p = new Products();
				p.setId(rs.getInt("id"));
				Users u = udao.getById(rs.getInt("u_id"));
				p.setUser(u);
				p.setPname(rs.getString("pname"));
				p.setTypes(rs.getString("typee"));
				p.setOldprice(rs.getDouble("oldprice"));
				p.setCurrentprice(rs.getDouble("currentprice"));
				p.setDescription(rs.getString("description"));
				p.setImg(rs.getString("img"));
				p.setReleasedate(rs.getDate("releasedate"));
				p.setStatus(rs.getInt("status"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public Products getByPname(String pname) {
		Products p = null;
		String sql = "select * from iproducts where pname = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(pname);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				p = new Products();
				p.setId(rs.getInt("id"));
				Users u = udao.getById(rs.getInt("u_id"));
				p.setUser(u);
				p.setPname(rs.getString("pname"));
				p.setTypes(rs.getString("typee"));
				p.setOldprice(rs.getDouble("oldprice"));
				p.setCurrentprice(rs.getDouble("currentprice"));
				p.setDescription(rs.getString("description"));
				p.setImg(rs.getString("img"));
				p.setReleasedate(rs.getDate("releasedate"));
				p.setStatus(rs.getInt("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Products> getByTypes(String types) {
		List<Products> list = new ArrayList<Products>();
		String sql = "select * from iproducts where typee = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(types);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Products p = new Products();
				p.setId(rs.getInt("id"));
				Users u = udao.getById(rs.getInt("u_id"));
				p.setUser(u);
				p.setPname(rs.getString("pname"));
				p.setTypes(rs.getString("typee"));
				p.setOldprice(rs.getDouble("oldprice"));
				p.setCurrentprice(rs.getDouble("currentprice"));
				p.setDescription(rs.getString("description"));
				p.setImg(rs.getString("img"));
				p.setReleasedate(rs.getDate("releasedate"));
				p.setStatus(rs.getInt("status"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Products> getByCurrentprice(double currentprice) {
		List<Products> list = new ArrayList<Products>();
		String sql = "select * from iproducts where currentprice = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(currentprice);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Products p = new Products();
				p.setId(rs.getInt("id"));
				Users u = udao.getById(rs.getInt("u_id"));
				p.setUser(u);
				p.setPname(rs.getString("pname"));
				p.setTypes(rs.getString("typee"));
				p.setOldprice(rs.getDouble("oldprice"));
				p.setCurrentprice(rs.getDouble("currentprice"));
				p.setDescription(rs.getString("description"));
				p.setImg(rs.getString("img"));
				p.setReleasedate(rs.getDate("releasedate"));
				p.setStatus(rs.getInt("status"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Products> getByDescription(String description) {
		List<Products> list = new ArrayList<Products>();
		String sql = "select * from iproducts where description LIKE '%" + description + "%'";
		try {
			rs = super.executeQuery(sql, null);
			while (rs.next()) {
				Products p = new Products();
				p.setId(rs.getInt("id"));
				Users u = udao.getById(rs.getInt("u_id"));
				p.setUser(u);
				p.setPname(rs.getString("pname"));
				p.setTypes(rs.getString("typee"));
				p.setOldprice(rs.getDouble("oldprice"));
				p.setCurrentprice(rs.getDouble("currentprice"));
				p.setDescription(rs.getString("description"));
				p.setImg(rs.getString("img"));
				p.setReleasedate(rs.getDate("releasedate"));
				p.setStatus(rs.getInt("status"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Products> getByReleasedate(String releasedate) {
		List<Products> list = new ArrayList<Products>();
		String sql = "select * from iproducts where to_char(releasedate,'yyyy-mm-dd') = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(releasedate);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Products p = new Products();
				p.setId(rs.getInt("id"));
				Users u = udao.getById(rs.getInt("u_id"));
				p.setUser(u);
				p.setPname(rs.getString("pname"));
				p.setTypes(rs.getString("typee"));
				p.setOldprice(rs.getDouble("oldprice"));
				p.setCurrentprice(rs.getDouble("currentprice"));
				p.setDescription(rs.getString("description"));
				p.setImg(rs.getString("img"));
				p.setReleasedate(rs.getDate("releasedate"));
				p.setStatus(rs.getInt("status"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Products> getByStatus(int status) {
		List<Products> list = new ArrayList<Products>();
		String sql = "select * from iproducts where status = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(status);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Products p = new Products();
				p.setId(rs.getInt("id"));
				Users u = udao.getById(rs.getInt("u_id"));
				p.setUser(u);
				p.setPname(rs.getString("pname"));
				p.setTypes(rs.getString("typee"));
				p.setOldprice(rs.getDouble("oldprice"));
				p.setCurrentprice(rs.getDouble("currentprice"));
				p.setDescription(rs.getString("description"));
				p.setImg(rs.getString("img"));
				p.setReleasedate(rs.getDate("releasedate"));
				p.setStatus(rs.getInt("status"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Products> getByOldPrice(double oldprice) {
		List<Products> list = new ArrayList<Products>();
		String sql = "select * from iproducts where oldprice = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(oldprice);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Products p = new Products();
				p.setId(rs.getInt("id"));
				Users u = udao.getById(rs.getInt("u_id"));
				p.setUser(u);
				p.setPname(rs.getString("pname"));
				p.setTypes(rs.getString("typee"));
				p.setOldprice(rs.getDouble("oldprice"));
				p.setCurrentprice(rs.getDouble("currentprice"));
				p.setDescription(rs.getString("description"));
				p.setImg(rs.getString("img"));
				p.setReleasedate(rs.getDate("releasedate"));
				p.setStatus(rs.getInt("status"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Products> getByDate(String date) {
		List<Products> list = new ArrayList<Products>();
		String sql = "select * from iproducts where to_char(releasedate,'yyyy-mm-dd') = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(date);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Products p = new Products();
				p.setId(rs.getInt("id"));
				Users u = udao.getById(rs.getInt("u_id"));
				p.setUser(u);
				p.setPname(rs.getString("pname"));
				p.setTypes(rs.getString("typee"));
				p.setOldprice(rs.getDouble("oldprice"));
				p.setCurrentprice(rs.getDouble("currentprice"));
				p.setDescription(rs.getString("description"));
				p.setImg(rs.getString("img"));
				p.setReleasedate(rs.getDate("releasedate"));
				p.setStatus(rs.getInt("status"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
