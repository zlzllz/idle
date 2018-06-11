package com.idle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.idle.biz.NoteBiz;
import com.idle.biz.ProductsBiz;
import com.idle.biz.ReplyBiz;
import com.idle.biz.UsersBiz;
import com.idle.biz.impl.NoteBizImpl;
import com.idle.biz.impl.ProductsBizImpl;
import com.idle.biz.impl.ReplyBizImpl;
import com.idle.biz.impl.UsersBizImpl;
import com.idle.entity.Note;
import com.idle.entity.Products;
import com.idle.entity.Users;

/**
 * @author zhangqi
 * @date 2017年5月12日 下午5:37:58
 */

public class NoteServlet extends BaseServlet {
	NoteBiz nBiz = new NoteBizImpl();
	UsersBiz uBiz = new UsersBizImpl();
	ProductsBiz pBiz = new ProductsBizImpl();
	private Object url = null;

	public Object save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String username = request.getParameter("username");
		Users user = uBiz.getByUsername(username);
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		Products product = pBiz.getById(p_id);
		String content = request.getParameter("content");
		Note n = new Note(user, product, content);
		nBiz.save(n);
		url = "/NoteServlet?tag=getAll";
		return url;
	}

	public Object getAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		List<Note> list = (List<Note>) nBiz.getAll();
		request.setAttribute("notes", list);
		url = request.getRequestDispatcher("/inote/show.jsp");
		return url;
	}

	public Object update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		Users user = uBiz.getByUsername(username);
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		Products product = pBiz.getById(p_id);
		String content = request.getParameter("content");
		Note n = new Note(id, user, product, content);
		nBiz.update(n);
		List<Note> list = (List<Note>) nBiz.getAll();
		request.setAttribute("notes", list);
		url = request.getRequestDispatcher("/inote/show.jsp");
		return url;
	}

	public Object delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		Note n = new Note();
		n.setId(id);
		nBiz.delete(n);
		List<Note> list = (List<Note>) nBiz.getAll();
		request.setAttribute("notes", list);
		url = request.getRequestDispatcher("/inote/show.jsp");
		return url;
	}

	public Object getById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("param"));
		List<Note> list = new ArrayList<Note>();
		list.add(nBiz.getById(id));
		request.setAttribute("notes", list);
		url = request.getRequestDispatcher("/inote/show.jsp");
		return url;
	}

	public Object getByU_id(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String uname = request.getParameter("param");
		List<Note> list = nBiz.getByU_Id(uBiz.getByUsername(uname).getId());
		request.setAttribute("notes", list);
		url = request.getRequestDispatcher("/inote/show.jsp");
		return url;
	}

	public Object getByPname(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String pname = request.getParameter("param");
		
		List<Note> list = nBiz.getByP_Id(pBiz.getByPname(pname).getId());
		request.setAttribute("notes", list);
		url = request.getRequestDispatcher("/inote/show.jsp");
		return url;
	}

	public Object getByDate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String notedate = request.getParameter("param");
		List<Note> list = nBiz.getByDate(notedate);
		request.setAttribute("notes", list);
		url = request.getRequestDispatcher("/inote/show.jsp");
		return url;
	}

	public Object getByContent(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String content = request.getParameter("param");
		List<Note> list = nBiz.getByContent(content);
		request.setAttribute("notes", list);
		url = request.getRequestDispatcher("/inote/show.jsp");
		return url;
	}

	public Object getU(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		String pname = pBiz.getById(pid).getPname();
		List<Users> us = uBiz.getAll();
		request.setAttribute("uses", us);
		url = request.getRequestDispatcher("/inote/update.jsp?id="+id+"&pname=" + pname);
		return url;
	}

	public Object getPU2(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String pname = request.getParameter("pname");
		int pid = Integer.parseInt(request.getParameter("pid"));
		List<Users> us = uBiz.getAll();
		request.setAttribute("uses", us);
		url = request.getRequestDispatcher("/inote/add.jsp?pname=" + pname
				+ "&pid=" + pid);
		return url;
	}
	
	// 前台
	public Object saveA(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String username = request.getParameter("username");
		Users user = uBiz.getByUsername(username);
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		Products product = pBiz.getById(p_id);
		String content = request.getParameter("content");
		Note n = new Note(user, product, content);
		nBiz.save(n);
		url = "/ProductsServlet?tag=toProA&pid=" + p_id;
		return url;
	}
}
