package com.idle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.idle.biz.ExpressBiz;
import com.idle.biz.impl.ExpressBizImpl;
import com.idle.entity.Express;

/**
 * @author zhangqi
 * @date 2017年5月14日 下午3:51:58
 */

public class ExpressServlet extends BaseServlet {
	ExpressBiz eBiz = new ExpressBizImpl();
	private Object url = null;

	public Object save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String ename = request.getParameter("ename");
		double perprice = Double.parseDouble(request.getParameter("perprice"));
		Express e = new Express(ename, perprice);
		eBiz.save(e);
		url = "/ExpressServlet?tag=getAll";
		return url;
	}

	public Object getAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		List<Express> list = (List<Express>) eBiz.getAll();
		request.setAttribute("expresss", list);
		url = request.getRequestDispatcher("/iexpress/show.jsp");
		return url;
	}

	public Object update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		String ename = request.getParameter("ename");
		double perprice = Double.parseDouble(request.getParameter("perprice"));
		Express e = new Express(id, ename, perprice);
		eBiz.update(e);
		List<Express> list = (List<Express>) eBiz.getAll();
		request.setAttribute("expresss", list);
		url = request.getRequestDispatcher("/iexpress/show.jsp");
		return url;
	}

	public Object delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		Express u = new Express();
		u.setId(id);
		eBiz.delete(u);
		List<Express> list = (List<Express>) eBiz.getAll();
		request.setAttribute("expresss", list);
		url = request.getRequestDispatcher("/iexpress/show.jsp");
		return url;
	}

	public Object getById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("param"));
		List<Express> list = new ArrayList<Express>();
		list.add(eBiz.getById(id));
		request.setAttribute("expresss", list);
		url = request.getRequestDispatcher("/iexpress/show.jsp");
		return url;
	}
	
	public Object getByEname(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String ename = request.getParameter("param");
		List<Express> list = new ArrayList<Express>();
		list.add(eBiz.getByEname(ename));
		request.setAttribute("expresss", list);
		url = request.getRequestDispatcher("/iexpress/show.jsp");
		return url;
	}
	
	public Object getByPerprice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		double perprice = Double.parseDouble(request.getParameter("param"));
		List<Express> list = eBiz.getByPerprice(perprice);
		request.setAttribute("expresss", list);
		url = request.getRequestDispatcher("/iexpress/show.jsp");
		return url;
	}
}
