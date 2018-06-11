package com.idle.biz.impl;

import java.util.List;

import com.idle.biz.ExpressBiz;
import com.idle.dao.ExpressDao;
import com.idle.dao.impl.ExpressDaoImpl;
import com.idle.entity.Express;

/**
 * @author zhangqi
 * @date 2017年5月06日 下午6:51:58
 */

public class ExpressBizImpl implements ExpressBiz{

	ExpressDao edao = new ExpressDaoImpl();
	
	@Override
	public List<Express> getAll() {
		return edao.getAll();
	}

	@Override
	public int save(Express express) {
		return edao.save(express);
	}

	@Override
	public int update(Express express) {
		return edao.update(express);
	}

	@Override
	public int delete(Express express) {
		// TODOd Auto-generated method stub
		return edao.delete(express);
	}

	@Override
	public Express getById(int id) {
		return edao.getById(id);
	}

	@Override
	public Express getByEname(String ename) {
		return edao.getByEname(ename);
	}

	@Override
	public List<Express> getByPerprice(double perprice) {
		return edao.getByPerprice(perprice);
	}

}
