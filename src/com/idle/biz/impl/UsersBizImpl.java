package com.idle.biz.impl;

import java.util.List;

import com.idle.biz.UsersBiz;
import com.idle.dao.UsersDao;
import com.idle.dao.impl.UsersDaoImpl;
import com.idle.entity.Users;

public class UsersBizImpl implements UsersBiz{

	UsersDao udao = new UsersDaoImpl();
	
	@Override
	public List<Users> getAll() {
		return udao.getAll();
	}

	@Override
	public int save(Users users) {
		return udao.save(users);
	}

	@Override
	public int update(Users users) {
		return udao.update(users);
	}

	@Override
	public int delete(Users users) {
		return udao.delete(users);
	}

	@Override
	public Users getById(int id) {
		return udao.getById(id);
	}

	@Override
	public List<Users> getBySex(String sex) {
		return udao.getBySex(sex);
	}

	@Override
	public Users getByTel(String tel) {
		return udao.getByTel(tel);
	}

	@Override
	public List<Users> getByAddress(String address) {
		return udao.getByAddress(address);
	}

	@Override
	public Users getByIdnum(Number idnum) {
		return udao.getByIdnum(idnum);
	}

	@Override
	public Users getByCardnum(Number cardnum) {
		return udao.getByCardnum(cardnum);
	}

	@Override
	public Users getByUsername(String username) {
		return udao.getByUsername(username);
	}

	@Override
	public int saveA(Users users) {
		return udao.saveA(users);
	}

}
