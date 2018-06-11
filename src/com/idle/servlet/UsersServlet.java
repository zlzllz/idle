package com.idle.servlet;

import java.io.IOException; 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.idle.biz.ProductsBiz;
import com.idle.biz.ReplyBiz;
import com.idle.biz.UsersBiz;
import com.idle.biz.impl.ProductsBizImpl;
import com.idle.biz.impl.ReplyBizImpl;
import com.idle.biz.impl.UsersBizImpl;
import com.idle.entity.Products;
import com.idle.entity.Reply;
import com.idle.entity.Users;

/**
 * @author hanyufei
 * @date 2017年5月09日 下午3:34:47
 */

public class UsersServlet extends BaseServlet {
	ProductsBiz pBiz = new ProductsBizImpl();
	UsersBiz uBiz = new UsersBizImpl();
	private Object url = null;
	
	public Object save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String username= request.getParameter("username");
		String pass= request.getParameter("password");
		String password = DigestUtils.md5Hex(pass.getBytes());
		String sex= request.getParameter("sex");
		String tel= request.getParameter("tel");
		String address= request.getParameter("address");
		long idnum= Long.parseLong(request.getParameter("idnum"));
		long cardnum= Long.parseLong(request.getParameter("cardnum"));
		int grade= Integer.parseInt(request.getParameter("grade"));
		Users u = new Users(username,password,sex,tel,address,idnum,cardnum,grade);
		uBiz.save(u);
		url = "/UserServlet?tag=getAll";
		return url;
	}

	public Object getAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		List<Users> list = (List<Users>) uBiz.getAll();
		request.setAttribute("users", list);
		url = request.getRequestDispatcher("/iuser/show.jsp");
		return url;
	}

	public Object update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		String username= request.getParameter("username");
		String pass= request.getParameter("password");
		String password = DigestUtils.md5Hex(pass.getBytes());
		String sex= request.getParameter("sex");
		String tel= request.getParameter("tel");
		String address= request.getParameter("address");
		long idnum= Long.parseLong(request.getParameter("idnum"));
		long cardnum= Long.parseLong(request.getParameter("cardnum"));
		int grade= Integer.parseInt(request.getParameter("grade"));
		Users u = new Users(id, username,password,sex,tel,address,idnum,cardnum,grade);
		uBiz.update(u);
		List<Users> list = (List<Users>) uBiz.getAll();
		request.setAttribute("users", list);
		url = request.getRequestDispatcher("/iuser/show.jsp");
		return url;
	}

	public Object delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		Users u = new Users();
		u.setId(id);
		uBiz.delete(u);
		List<Users> list = (List<Users>) uBiz.getAll();
		request.setAttribute("users", list);
		url = request.getRequestDispatcher("/iuser/show.jsp");
		return url;
	} 
	
	public Object getById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("param"));
		List<Users> list = new ArrayList<Users>();
		list.add(uBiz.getById(id));
		request.setAttribute("users", list);
		url = request.getRequestDispatcher("/iuser/show.jsp");
		return url;
	}
	
	public Object getByUsername(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String username = request.getParameter("param");
		List<Users> list = new ArrayList<Users>();
		list.add(uBiz.getByUsername(username));
		request.setAttribute("users", list);
		url = request.getRequestDispatcher("/iuser/show.jsp");
		return url;
	}
	
	public Object getBySex(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String sex = request.getParameter("param");
		List<Users> list = uBiz.getBySex(sex);
		request.setAttribute("users", list);
		url = request.getRequestDispatcher("/iuser/show.jsp");
		return url;
	}
	
	public Object getByTel(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String tel = request.getParameter("param");
		List<Users> list = new ArrayList<Users>();
		list.add(uBiz.getByTel(tel));
		request.setAttribute("users", list);
		url = request.getRequestDispatcher("/iuser/show.jsp");
		return url;
	}
	
	public Object getByAddress(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String address = request.getParameter("param");
		List<Users> list = uBiz.getByAddress(address);
		request.setAttribute("users", list);
		url = request.getRequestDispatcher("/iuser/show.jsp");
		return url;
	}
	
	public Object getByIdnum(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		long idnum = Long.parseLong(request.getParameter("param"));
		List<Users> list = new ArrayList<Users>();
		list.add(uBiz.getByIdnum(idnum));
		request.setAttribute("users", list);
		url = request.getRequestDispatcher("/iuser/show.jsp");
		return url;
	}
	
	public Object getByCardnum(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		long cardnum = Long.parseLong(request.getParameter("param"));
		List<Users> list = new ArrayList<Users>();
		list.add(uBiz.getByCardnum(cardnum));
		request.setAttribute("users", list);
		url = request.getRequestDispatcher("/iuser/show.jsp");
		return url;
	}
	
	// 前台
	public Object getUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String username = request.getParameter("username");
		Users user = uBiz.getByUsername(username);
		request.setAttribute("user", user);
		
		List<Products> list = (List<Products>) pBiz.getAll();
		request.setAttribute("products", list);
		
		url = request.getRequestDispatcher("/app/userinfo.jsp");
		return url;
	}
	
	public Object updateA(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		String username= request.getParameter("username");
		String pass= request.getParameter("password");
		String password = DigestUtils.md5Hex(pass.getBytes());
		String sex= request.getParameter("sex");
		String tel= request.getParameter("tel");
		String address= request.getParameter("address");
		long idnum= Long.parseLong(request.getParameter("idnum"));
		long cardnum= Long.parseLong(request.getParameter("cardnum"));
		int grade= Integer.parseInt(request.getParameter("grade"));
		Users u = new Users(id, username,password,sex,tel,address,idnum,cardnum,grade);
		uBiz.update(u);
		Users user = uBiz.getById(id);
		request.setAttribute("user", user);
		url = request.getRequestDispatcher("/app/userinfo.jsp");
		return url;
	}
}
