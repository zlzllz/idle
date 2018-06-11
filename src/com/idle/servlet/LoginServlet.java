package com.idle.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.idle.dao.UsersDao;
import com.idle.dao.impl.UsersDaoImpl;
import com.idle.entity.Users;

/**
 * @author lilingzhi
 * @date 2017年5月08日 下午5:30:14
 */

public class LoginServlet extends BaseServlet {
	UsersDao uDao = new UsersDaoImpl();

	// 登录验证
	public Object login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		// 加密
		String pass = request.getParameter("password");
		String password = DigestUtils.md5Hex(pass.getBytes());
		if (check(username, password)) {
			request.getSession().setAttribute("username", username);
			request.getRequestDispatcher("/pages/index.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
		}
		return null;
	}

	// 验证用户是否存在
	private Boolean check(String username, String password) {
		Users user = uDao.getByUsername(username);
		if (user != null) {
			if ((user.getUsername().equals(username))
					&& (user.getPassword().equals(password))) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	// 退出系统
	public Object logOut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("username");
		request.getSession().invalidate();
		return "/login.jsp";
	}
}
