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
 * @date 2017年5月08日 下午7:36:14
 */

public class LoginServletA extends BaseServlet {
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
			// request.getRequestDispatcher("/app/index.jsp").forward(request, response);
			return "/ProductsServlet?tag=getAllA";
		} else {
			request.getRequestDispatcher("/app/login.jsp").forward(request,
					response);
		}
		return null;
	}

	// 注册验证
	public Object register(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		String password = DigestUtils.md5Hex(pass.getBytes());
		if (username != "" && pass != "") {
			if (check1(username)) {
				request.setAttribute("remindname", "该用户名已存在！");
				request.getRequestDispatcher("/app/reg.jsp").forward(
						request, response);
			} else {
				int num = add(username, password);
				if (num == 1) {
					// 记录当前登录的用户名
					request.getSession().setAttribute("username", username);
					request.getRequestDispatcher("/app/login.jsp").forward(
							request, response);
				} else {
					request.getRequestDispatcher("/app/reg.jsp").forward(
							request, response);
				}
			}
		} else {
			if (username == null) {
				request.setAttribute("remindname", "请输入用户名！");
				request.getRequestDispatcher("/zmin/register.jsp").forward(
						request, response);
			}
			if (password == null) {
				request.setAttribute("remindpass0", "请输入密码！");
				request.getRequestDispatcher("/zmin/register.jsp").forward(
						request, response);
			}
			request.getRequestDispatcher("/zmin/register.jsp").forward(request,
					response);
		}
		return null;
	}

	// 验证用户是否存在
	private Boolean check(String username, String password) {
		Users user = uDao.getByUsername(username);
		int grade = user.getGrade();// 0--管理员，1--普通用户
		if (user != null && grade == 1) {
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

	private Boolean check1(String username) {
		Users user = uDao.getByUsername(username);
		if (user != null) {
			if (user.getUsername().equals(username)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	// 用户注册到数据库
	public int add(String username, String password) {
		return uDao.saveA(new Users(username, password));
	}

	// 退出系统
	public Object logOut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("username");
		request.getSession().invalidate();
		return "/ProductsServlet?tag=getAllA";
	}

}
