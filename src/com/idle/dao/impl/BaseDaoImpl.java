package com.idle.dao.impl;

import java.sql.*;
import java.util.List;

import com.idle.dao.BaseDao;
import com.llz.utils.SqlTools;

public class BaseDaoImpl implements BaseDao {

	public Connection con = null;
	public PreparedStatement pstm = null;
	public ResultSet rs = null;
	public int num = -1;

	@Override
	public ResultSet executeQuery(String sql, List<Object> objs) {
		con = SqlTools.getConn();
		try {
			pstm = con.prepareStatement(sql);
			if (objs != null) {
				for (int i = 0; i < objs.size(); i++) {
					pstm.setObject(i + 1, objs.get(i));
				}
			}
			rs = pstm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public int executeUpdate(String sql, List<Object> objs) {
		con = SqlTools.getConn();
		try {
			pstm = con.prepareStatement(sql);
			if (objs != null) {
				for (int i = 0; i < objs.size(); i++) {
					pstm.setObject(i + 1, objs.get(i));
				}
			}
			num = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return num;
	}

}
