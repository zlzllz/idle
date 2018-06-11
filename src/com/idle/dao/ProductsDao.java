package com.idle.dao;

import java.util.List;

import com.idle.entity.Products;

/**
 * @author yangluyu
 * @date 2017年5月11日 下午4:23:58
 */

public interface ProductsDao {

	public List<Products> getAll();

	public int save(Products products);

	public int update(Products products);

	public int delete(Products products);

	public Products getById(int id);

	public List<Products> getByU_id(int id);

	public Products getByPname(String pname);

	public List<Products> getByTypes(String types);

	public List<Products> getByOldPrice(double oldprice);

	public List<Products> getByCurrentprice(double currentprice);

	public List<Products> getByDescription(String description);

	public List<Products> getByReleasedate(String releasedate);

	public List<Products> getByStatus(int status);
	
	public List<Products> getByDate(String date);

}
