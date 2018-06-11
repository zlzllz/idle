package com.idle.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import com.idle.dao.UsersDao;
import com.idle.entity.Users;

/**
 * @author hanyufei
 * @date 2017年5月10日 下午5:34:47
 */

public class UsersDaoImpl extends BaseDaoImpl implements UsersDao{

	@Override
	public List<Users> getAll() {
		List<Users> list = new ArrayList<Users>();
		String sql = "select * from iusers";
		try {
			rs = super.executeQuery(sql, null);
			while (rs.next()) {
				Users u = new Users();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("passwordd"));
				u.setSex(rs.getString("sex"));
				u.setTel(rs.getString("tel"));
				u.setAddress(rs.getString("address"));
				u.setIdnum(rs.getBigDecimal("idnum"));
				u.setCardnum(rs.getBigDecimal("cardnum"));
				u.setGrade(rs.getInt("grade"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int save(Users users) {
		String sql = "insert into iusers(username,passwordd,sex,tel,address,idnum,cardnum,grade) values(?,?,?,?,?,?,?,?)";
		List<Object> objs = new ArrayList<Object>();
		objs.add(users.getUsername());
		String password = DigestUtils.md5Hex(users.getPassword().getBytes());
		objs.add(password);
		objs.add(users.getSex());
		objs.add(users.getTel());
		objs.add(users.getAddress());
		objs.add(users.getIdnum());
		objs.add(users.getCardnum());
		objs.add(users.getGrade());
		num = super.executeUpdate(sql, objs);
		return num;
	}
	
	@Override
	public int saveA(Users users) {
		String sql = "insert into iusers(username,passwordd,grade) values(?,?,1)";
		List<Object> objs = new ArrayList<Object>();
		objs.add(users.getUsername());
		String password = DigestUtils.md5Hex(users.getPassword().getBytes());
		objs.add(password);
		num = super.executeUpdate(sql, objs);
		return num;
	}

	@Override
	public int update(Users users) {
		String sql = "update iusers set username=?,passwordd=?,sex=?,tel=?,address=?,idnum=?,cardnum=?,grade=? where id=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(users.getUsername());
		objs.add(users.getPassword());
		objs.add(users.getSex());
		objs.add(users.getTel());
		objs.add(users.getAddress());
		objs.add(users.getIdnum());
		objs.add(users.getCardnum());
		objs.add(users.getGrade());
		objs.add(users.getId());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	@Override
	public int delete(Users users) {
		String sql = "delete from iusers where id=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(users.getId());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	@Override
	public Users getById(int id) {
		Users u = null;
		String sql = "select * from iusers where id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(id);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				u = new Users();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("passwordd"));
				u.setSex(rs.getString("sex"));
				u.setTel(rs.getString("tel"));
				u.setAddress(rs.getString("address"));
				u.setIdnum(rs.getBigDecimal("idnum"));
				u.setCardnum(rs.getBigDecimal("cardnum"));
				u.setGrade(rs.getInt("grade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public List<Users> getBySex(String sex) {
		List<Users> list = new ArrayList<Users>();
		String sql = "select * from iusers where sex = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(sex);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Users u = new Users();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("passwordd"));
				u.setSex(rs.getString("sex"));
				u.setTel(rs.getString("tel"));
				u.setAddress(rs.getString("address"));
				u.setIdnum(rs.getBigDecimal("idnum"));
				u.setCardnum(rs.getBigDecimal("cardnum"));
				u.setGrade(rs.getInt("grade"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Users getByTel(String tel) {
		Users u = null;
		String sql = "select * from iusers where tel = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(tel);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				u = new Users();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("passwordd"));
				u.setSex(rs.getString("sex"));
				u.setTel(rs.getString("tel"));
				u.setAddress(rs.getString("address"));
				u.setIdnum(rs.getBigDecimal("idnum"));
				u.setCardnum(rs.getBigDecimal("cardnum"));
				u.setGrade(rs.getInt("grade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public List<Users> getByAddress(String address) {
		List<Users> list = new ArrayList<Users>();
		String sql = "select * from iusers where address = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(address);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Users u = new Users();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("passwordd"));
				u.setSex(rs.getString("sex"));
				u.setTel(rs.getString("tel"));
				u.setAddress(rs.getString("address"));
				u.setIdnum(rs.getBigDecimal("idnum"));
				u.setCardnum(rs.getBigDecimal("cardnum"));
				u.setGrade(rs.getInt("grade"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Users getByIdnum(Number idnum) {
		Users u = null;
		String sql = "select * from iusers where idnum = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(idnum);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				u = new Users();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("passwordd"));
				u.setSex(rs.getString("sex"));
				u.setTel(rs.getString("tel"));
				u.setAddress(rs.getString("address"));
				u.setIdnum(rs.getBigDecimal("idnum"));
				u.setCardnum(rs.getBigDecimal("cardnum"));
				u.setGrade(rs.getInt("grade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public Users getByCardnum(Number cardnum) {
		Users u = null;
		String sql = "select * from iusers where cardnum = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(cardnum);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				u = new Users();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("passwordd"));
				u.setSex(rs.getString("sex"));
				u.setTel(rs.getString("tel"));
				u.setAddress(rs.getString("address"));
				u.setIdnum(rs.getBigDecimal("idnum"));
				u.setCardnum(rs.getBigDecimal("cardnum"));
				u.setGrade(rs.getInt("grade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public Users getByUsername(String username) {
		Users u = null;
		String sql = "select * from iusers where username = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(username);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				u = new Users();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("passwordd"));
				u.setSex(rs.getString("sex"));
				u.setTel(rs.getString("tel"));
				u.setAddress(rs.getString("address"));
				u.setIdnum(rs.getBigDecimal("idnum"));
				u.setCardnum(rs.getBigDecimal("cardnum"));
				u.setGrade(rs.getInt("grade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

}
