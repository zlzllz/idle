package com.idle.dao;

import java.util.List;

import com.idle.entity.Order;

/**
 * @author caochenjie
 * @date 2017年5月08日 下午6:51:06
 */

public interface OrderDao {
	public List<Order> getAll();

	public int save(Order order);

	public int update(Order order);

	public int delete(Order order);

	public Order getById(int id);

	public List<Order> getByP_id(int id);

	public List<Order> getByU_id(int id);

	public List<Order> getByMethod(int method);

	public List<Order> getByBegindate(String begindate);
	
	public List<Order> getByEnddate(String enddate);

	public int updateM(Order o);

}




