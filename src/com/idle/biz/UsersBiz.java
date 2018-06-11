package com.idle.biz;

import java.util.List;

import com.idle.entity.Users;

/**
 * @author hanyufei
 * @date 2017年5月09日 下午5:34:47
 */

public interface UsersBiz {
	public List<Users> getAll();

	public int save(Users users);// 管理员注册
	
	public int saveA(Users users);// 普通用户注册

	public int update(Users users);

	public int delete(Users users);

	public Users getById(int id);
	
	public Users getByUsername(String username);

	public List<Users> getBySex(String sex);

	public Users getByTel(String tel);

	public List<Users> getByAddress(String address);

	public Users getByIdnum(Number idnum);

	public Users getByCardnum(Number cardnum);
}
