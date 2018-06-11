package com.idle.biz.impl;

import java.util.List;

import com.idle.biz.ProductsBiz;
import com.idle.dao.ProductsDao;
import com.idle.dao.impl.ProductsDaoImpl;
import com.idle.entity.Products;

/**
 * @author yangluyu
 * @date 2017年5月12日 下午3:37:58
 */

public class ProductsBizImpl implements ProductsBiz {

	ProductsDao pdao = new ProductsDaoImpl();

	@Override
	public List<Products> getAll() {
		return pdao.getAll();
	}

	@Override
	public int save(Products products) {
		return pdao.save(products);
	}

	@Override
	public int update(Products products) {
		return pdao.update(products);
	}

	@Override
	public int delete(Products products) {
		return pdao.delete(products);
	}

	@Override
	public Products getById(int id) {
		return pdao.getById(id);
	}

	@Override
	public List<Products> getByU_id(int id) {
		return pdao.getByU_id(id);
	}

	@Override
	public Products getByPname(String pname) {
		return pdao.getByPname(pname);
	}

	@Override
	public List<Products> getByTypes(String types) {
		return pdao.getByTypes(types);
	}

	@Override
	
	public List<Products> getByReleasedate(String releasedate) {
		return pdao.getByReleasedate(releasedate);
	}

	@Override
	public List<Products> getByStatus(int status) {
		return pdao.getByStatus(status);
	}

	@Override
	public List<Products> getByDescription(String description) {
		return pdao.getByDescription(description);
	}

	@Override
	public List<Products> getByOldPrice(double oldprice) {
		return pdao.getByOldPrice(oldprice);	}

	@Override
	public List<Products> getByCurrentprice(double currentprice) {
		return pdao.getByCurrentprice(currentprice);
	}

	@Override
	public List<Products> getByDate(String date) {
		return pdao.getByDate(date);
	}

}
