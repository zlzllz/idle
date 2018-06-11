package com.idle.dao;

import java.sql.ResultSet;
import java.util.List;

public interface BaseDao {
	public ResultSet executeQuery(String sql, List<Object> objs);

	public int executeUpdate(String sql, List<Object> objs);

}
