package com.idle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.idle.biz.OrderBiz;
import com.idle.biz.ProductsBiz;
import com.idle.biz.UsersBiz;
import com.idle.biz.impl.OrderBizImpl;
import com.idle.biz.impl.ProductsBizImpl;
import com.idle.biz.impl.UsersBizImpl;
import com.idle.entity.Order;
import com.idle.entity.Products;
import com.idle.entity.Users;

/**
 * @author caochenjie
 * @date 2017年5月10日 下午6:51:06
 */

public class OrderServlet extends BaseServlet {

	OrderBiz oBiz = new OrderBizImpl();
	ProductsBiz pBiz = new ProductsBizImpl();
	UsersBiz uBiz = new UsersBizImpl();
	private Object url = null;

	public Object save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String pname = request.getParameter("pname");
		Products product = pBiz.getByPname(pname);
		String username = request.getParameter("username");
		Users user = uBiz.getByUsername(username);
		int method = Integer.parseInt(request.getParameter("method"));
		Order o = new Order(product, user, method);
		oBiz.save(o);
		url = "/OrderServlet?tag=getAll";
		return url;
	}

	public Object getAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		List<Order> list = (List<Order>) oBiz.getAll();
		request.setAttribute("orders", list);
		url = request.getRequestDispatcher("/iorder/show.jsp");
		return url;
	}

	public Object update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		String pname = request.getParameter("pname");
		Products product = pBiz.getByPname(pname);
		String username = request.getParameter("username");
		Users user = uBiz.getByUsername(username);
		int method = Integer.parseInt(request.getParameter("method"));
		Order o = new Order(id, product, user, method);
		oBiz.update(o);
		List<Order> list = (List<Order>) oBiz.getAll();
		request.setAttribute("orders", list);
		url = request.getRequestDispatcher("/iorder/show.jsp");
		return url;
	}

	public Object delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		Order o = new Order();
		o.setId(id);
		oBiz.delete(o);
		List<Order> list = (List<Order>) oBiz.getAll();
		request.setAttribute("orders", list);
		url = request.getRequestDispatcher("/iorder/show.jsp");
		return url;
	}

	public Object getById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("param"));
		List<Order> list = new ArrayList<Order>();
		list.add(oBiz.getById(id));
		request.setAttribute("orders", list);
		url = request.getRequestDispatcher("/iorder/show.jsp");
		return url;
	}

	public Object getByUname(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String username = request.getParameter("param");
		int id = uBiz.getByUsername(username).getId();
		List<Order> list = oBiz.getByU_id(id);
		request.setAttribute("orders", list);
		url = request.getRequestDispatcher("/iorder/show.jsp");
		return url;
	}

	public Object getByP_id(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("param"));
		List<Order> list = oBiz.getByP_id(id);
		request.setAttribute("orders", list);
		url = request.getRequestDispatcher("/iorder/show.jsp");
		return url;
	}

	public Object getByMethod(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int method = Integer.parseInt(request.getParameter("param"));
		List<Order> list = oBiz.getByMethod(method);
		request.setAttribute("orders", list);
		url = request.getRequestDispatcher("/iorder/show.jsp");
		return url;
	}

	public Object getByBegindate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String begindate = request.getParameter("param");
		List<Order> list = oBiz.getByBegindate(begindate);
		request.setAttribute("orders", list);
		url = request.getRequestDispatcher("/iorder/show.jsp");
		return url;
	}

	public Object getByEnddate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String enddate = request.getParameter("param");
		List<Order> list = oBiz.getByEnddate(enddate);
		request.setAttribute("orders", list);
		url = request.getRequestDispatcher("/iorder/show.jsp");
		return url;
	}

	public Object getPU(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		List<Products> ps = pBiz.getAll();
		request.setAttribute("producs", ps);
		List<Users> us = uBiz.getAll();
		request.setAttribute("uses", us);
		url = request.getRequestDispatcher("/iorder/update.jsp");
		return url;
	}

	public Object getPU2(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		List<Products> ps = pBiz.getAll();
		request.setAttribute("producs", ps);
		List<Users> us = uBiz.getAll();
		request.setAttribute("uses", us);
		List<Order> os = oBiz.getAll();
		request.setAttribute("orders", os);
		url = request.getRequestDispatcher("/iorder/add.jsp");
		return url;
	}

	// 前台
	public Object getOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String username = request.getParameter("username");
		int id = uBiz.getByUsername(username).getId();
		List<Order> orders = oBiz.getByU_id(id);
		request.setAttribute("orders", orders);

		List<Products> products = (List<Products>) pBiz.getAll();
		request.setAttribute("products", products);
		url = request.getRequestDispatcher("/app/order.jsp");
		return url;
	}

	public Object updateA(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		Order o = oBiz.getById(id);
		oBiz.updateM(o);

		String username = request.getParameter("username");
		int u_id = uBiz.getByUsername(username).getId();
		List<Order> list = (List<Order>) oBiz.getByU_id(u_id);
		request.setAttribute("orders", list);

		List<Products> products = (List<Products>) pBiz.getAll();
		request.setAttribute("products", products);
		url = request.getRequestDispatcher("/app/order.jsp");
		return url;
	}

	public Object saveA(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("pid"));
		Products product = pBiz.getById(id);

		String username = request.getParameter("username");
		Users user = uBiz.getByUsername(username);

		Order o = new Order(product, user, 0);
		oBiz.save(o);
		url = "/OrderServlet?tag=getOrder&username="+username;
		return url;
	}
}
