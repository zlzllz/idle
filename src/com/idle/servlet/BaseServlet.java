package com.idle.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.llz.utils.SqlTools;

/**
 * @author lilingzhi
 * @date 2017年5月06日 下午2:24:47
 */

public abstract class BaseServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Object url = null;
		String tag = request.getParameter("tag");
		System.out.println(tag + "-----------" + new Date());
		Class clazzClass = this.getClass();
		try {
			Method method = clazzClass.getDeclaredMethod(tag,
					HttpServletRequest.class, HttpServletResponse.class);
			url = method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
			// url = "/zmin/error.jsp";
		}
		SqlTools.jump(request, response, url);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.doGet(request, response);
	}

}
