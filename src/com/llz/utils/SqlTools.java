package com.llz.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lilingzhi
 * @date 2017年5月05日 下午2:24:47
 */

public class SqlTools {
	private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static String user = "llz";
	private static String password = "123456";

	private static Connection connection = null;
	private static Statement statement = null;

	public static Connection getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static Statement getState() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statement;
	}

	public static void closeConn() {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void jump(HttpServletRequest request,
			HttpServletResponse response, Object urll) {
		if (urll != null) {
			if (urll instanceof RequestDispatcher) {
				try {
					((RequestDispatcher) urll).forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				try {
					response.sendRedirect(request.getContextPath()
							+ (String) urll);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
