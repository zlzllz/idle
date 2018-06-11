package com.idle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.validator.constraints.NotEmpty;

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
import com.idle.entity.Reply;
import com.idle.entity.Users;

public class ReplyServlet extends BaseServlet {
	ReplyBiz rBiz = new ReplyBizImpl();
	NoteBiz nBiz = new NoteBizImpl();
	UsersBiz uBiz = new UsersBizImpl();
	private Object url = null;

	public Object save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int n_id = Integer.parseInt(request.getParameter("n_id"));
		Note note = nBiz.getById(n_id);
		int u_id = Integer.parseInt(request.getParameter("u_id"));
		Users user = uBiz.getById(u_id);
		String replycontent = request.getParameter("replycontent");
		Reply r = new Reply(note, replycontent, user);
		rBiz.save(r);
		url = "/ReplyServlet?tag=getAll";
		return url;
	}

	public Object getAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		List<Reply> list = (List<Reply>) rBiz.getAll();
		request.setAttribute("replys", list);
		url = request.getRequestDispatcher("/ireply/show.jsp");
		return url;
	}

	public Object update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		String replycontent = request.getParameter("replycontent");
		Reply r = new Reply(id, replycontent);
		rBiz.update(r);
		List<Reply> list = (List<Reply>) rBiz.getAll();
		request.setAttribute("replys", list);
		url = request.getRequestDispatcher("/ireply/show.jsp");
		return url;
	}

	public Object delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		Reply r = new Reply();
		r.setId(id);
		rBiz.delete(r);
		List<Reply> list = (List<Reply>) rBiz.getAll();
		request.setAttribute("replys", list);
		url = request.getRequestDispatcher("/ireply/show.jsp");
		return url;
	}

	public Object getByN_id(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String content = request.getParameter("param");
		System.out.println("--------------"+content);
		int id = nBiz.getByContent1(content).getId();
		List<Reply> list = rBiz.getByN_id(id);
		request.setAttribute("replys", list);
		url = request.getRequestDispatcher("/ireply/show.jsp");
		return url;
	}

	public Object getByU_id(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String uname = request.getParameter("param");
		int id = uBiz.getByUsername(uname).getId();
		List<Reply> list = rBiz.getByU_id(id);
		request.setAttribute("replys", list);
		url = request.getRequestDispatcher("/ireply/show.jsp");
		return url;
	}

	public Object getById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("param"));
		List<Reply> list = new ArrayList<Reply>();
		list.add(rBiz.getById(id));
		request.setAttribute("replys", list);
		url = request.getRequestDispatcher("/ireply/show.jsp");
		return url;
	}

	public Object getByReplycontent(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String replycontent = request.getParameter("param");
		List<Reply> list = rBiz.getByReplycontent(replycontent);
		request.setAttribute("replys", list);
		url = request.getRequestDispatcher("/ireply/show.jsp");
		return url;
	}
	
	public Object getByDate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String date = request.getParameter("param");
		List<Reply> list = rBiz.getByDate(date);
		request.setAttribute("replys", list);
		url = request.getRequestDispatcher("/ireply/show.jsp");
		return url;
	}

	public Object getPU(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		String con = nBiz.getById(id).getContent();
		String username = request.getParameter("username");
		url = request.getRequestDispatcher("/ireply/update.jsp?id=" + id
				+ "&username=" + username + "&con=" + con);
		return url;
	}

	public Object getPU2(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int n_id = Integer.parseInt(request.getParameter("nid"));
		String con = request.getParameter("con");
		// 根据留言找到商品，再根据商品找到发布商品的人。
		Users user = nBiz.getById(n_id).getProducts().getUser();
		String puser = user.getUsername();
		int uid = user.getId();
		url = request.getRequestDispatcher("/ireply/add.jsp?nid=" + n_id
				+ "&con=" + con + "&puser=" + puser + "&uid=" + uid);
		return url;
	}
}
