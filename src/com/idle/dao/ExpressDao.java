package com.idle.dao;

import java.util.List;

import com.idle.entity.Express;

/**
 * @author zhangqi
 * @date 2017年5月10日 下午5:51:58
 */

public interface ExpressDao {
	public List<Express> getAll();

	public int save(Express express);

	public int update(Express express);

	public int delete(Express express);

	public Express getById(int id);

	public Express getByEname(String ename);

	public List<Express> getByPerprice(double perprice);
}
