package com.idle.biz.impl;

import java.util.List;

import com.idle.biz.OrderBiz;
import com.idle.dao.OrderDao;
import com.idle.dao.impl.OrderDaoImpl;
import com.idle.entity.Order;

/**
 * @author caochenjie
 * @date 2017年5月07日 下午6:51:06
 */

public class OrderBizImpl implements OrderBiz {
	OrderDao odao = new OrderDaoImpl();

	@Override
	public List<Order> getAll() {
		return odao.getAll();
	}

	@Override
	public int save(Order order) {
		return odao.save(order);
	}

	@Override
	public int update(Order order) {
		return odao.update(order);
	}

	@Override
	public int delete(Order order) {
		return odao.delete(order);
	}

	@Override
	public Order getById(int id) {
		return odao.getById(id);
	}

	@Override
	public List<Order> getByU_id(int id) {
		return odao.getByU_id(id);
	}

	@Override
	public List<Order> getByMethod(int method) {
		return odao.getByMethod(method);
	}

	@Override
	public List<Order> getByBegindate(String begindate) {
		return odao.getByBegindate(begindate);
	}

	@Override
	public List<Order> getByP_id(int id) {
		return odao.getByP_id(id);
	}

	@Override
	public List<Order> getByEnddate(String enddate) {
		return odao.getByEnddate(enddate);
	}

	@Override
	public int updateM(Order o) {
		return odao.updateM(o);
	}

}
