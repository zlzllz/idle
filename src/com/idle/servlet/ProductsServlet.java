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
import com.idle.biz.UsersBiz;
import com.idle.biz.impl.NoteBizImpl;
import com.idle.biz.impl.ProductsBizImpl;
import com.idle.biz.impl.UsersBizImpl;
import com.idle.entity.Note;
import com.idle.entity.Products;
import com.idle.entity.Users;

/**
 * @author yangluyu
 * @date 2017年5月17日 下午3:51:58
 */

public class ProductsServlet extends BaseServlet {
	ProductsBiz pBiz = new ProductsBizImpl();
	UsersBiz uBiz = new UsersBizImpl();
	NoteBiz nBiz = new NoteBizImpl();
	private Object url = null;

	public Object getAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		List<Products> list = (List<Products>) pBiz.getAll();
		request.setAttribute("products", list);
		url = request.getRequestDispatcher("/iproduct/show.jsp");
		return url;
	}

	public Object save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		System.out.println("sssssssssssssssssssss");
		Products p = UploadServlet.save(request, response);
		pBiz.save(p);
		url = "/ProductsServlet?tag=getAll";
		return url;

	}

	public Object update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		Products p = UploadServlet.update(request, response);
		pBiz.update(p);
		List<Products> list = (List<Products>) pBiz.getAll();
		request.setAttribute("products", list);
		url = request.getRequestDispatcher("/iproduct/show.jsp");
		return url;
	}

	public Object delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		Products p = new Products();
		p.setId(id);
		pBiz.delete(p);
		List<Products> list = (List<Products>) pBiz.getAll();
		request.setAttribute("products", list);
		url = request.getRequestDispatcher("/iproduct/show.jsp");
		return url;
	}

	public Object getByU_id(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("param"));
		List<Products> list = (List<Products>) pBiz.getAll();
		request.setAttribute("products", list);
		url = request.getRequestDispatcher("/iproduct/show.jsp");
		return url;
	}

	public Object getById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("param"));
		List<Products> list = new ArrayList<Products>();
		list.add(pBiz.getById(id));
		request.setAttribute("products", list);
		url = request.getRequestDispatcher("/iproduct/show.jsp");
		return url;
	}

	public Object getByPname(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String pname = request.getParameter("param");
		List<Products> list = new ArrayList<Products>();
		list.add(pBiz.getByPname(pname));
		request.setAttribute("products", list);
		url = request.getRequestDispatcher("/iproduct/show.jsp");
		return url;
	}

	public Object getByTypes(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String types = request.getParameter("param");
		List<Products> list = pBiz.getByTypes(types);
		request.setAttribute("products", list);
		url = request.getRequestDispatcher("/iproduct/show.jsp");
		return url;
	}

	public Object getByOldPrice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		double oldPrice = Double.parseDouble(request.getParameter("param"));
		List<Products> list = pBiz.getByOldPrice(oldPrice);
		request.setAttribute("products", list);
		url = request.getRequestDispatcher("/iproduct/show.jsp");
		return url;
	}

	public Object getByCurrentprice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		double currentprice = Double.parseDouble(request.getParameter("param"));
		List<Products> list = pBiz.getByCurrentprice(currentprice);
		request.setAttribute("products", list);
		url = request.getRequestDispatcher("/iproduct/show.jsp");
		return url;
	}

	public Object getByDescription(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String description = request.getParameter("param");
		List<Products> list = pBiz.getByDescription(description);
		request.setAttribute("products", list);
		url = request.getRequestDispatcher("/iproduct/show.jsp");
		return url;
	}

	public Object getByReleasedate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String releasedate = request.getParameter("param");
		List<Products> list = pBiz.getByReleasedate(releasedate);
		request.setAttribute("products", list);
		url = request.getRequestDispatcher("/iproduct/show.jsp");
		return url;
	}

	public Object getByStatus(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int status = Integer.parseInt(request.getParameter("param"));
		List<Products> list = pBiz.getByStatus(status);
		request.setAttribute("products", list);
		url = request.getRequestDispatcher("/iproduct/show.jsp");
		return url;
	}

	public Object getU(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		List<Users> list = uBiz.getAll();
		request.setAttribute("uses", list);
		url = request.getRequestDispatcher("/iproduct/update.jsp");
		return url;
	}
	
	public Object getU1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		List<Users> list = uBiz.getAll();
		request.setAttribute("uses", list);
		url = request.getRequestDispatcher("/iproduct/add.jsp");
		return url;
	}

	// 前台
	public Object getAllA(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		request.getSession().setAttribute("abc", "abc");
		List<Products> list = (List<Products>) pBiz.getAll();
		request.setAttribute("products", list);
		url = request.getRequestDispatcher("/app/index.jsp");
		return url;
	}

	public Object toProA(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("pid"));
		Products product = pBiz.getById(id);
		request.setAttribute("product", product);

		List<Note> nList = nBiz.getByP_Id(id);
		request.setAttribute("nList", nList);

		List<Products> list = (List<Products>) pBiz.getAll();
		request.setAttribute("products", list);

		url = request.getRequestDispatcher("/app/product.jsp");
		return url;
	}

	public Object getProA(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String username = request.getParameter("username");
		Users user = uBiz.getByUsername(username);
		List<Products> prods = pBiz.getByU_id(user.getId());
		request.setAttribute("prods", prods);

		List<Products> list = (List<Products>) pBiz.getAll();
		request.setAttribute("products", list);
		url = request.getRequestDispatcher("/app/userpro.jsp");
		return url;
	}

	public Object deleteA(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		Products p = new Products();
		p.setId(id);
		pBiz.delete(p);
		List<Products> list = (List<Products>) pBiz.getAll();
		request.setAttribute("prods", list);
		url = request.getRequestDispatcher("/app/userpro.jsp");
		return url;
	}

	public Object saveA(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		Products p = UploadServlet.save(request, response);
		pBiz.save(p);

		String username = (String) request.getSession()
				.getAttribute("username");
		int uid = uBiz.getByUsername(username).getId();

		List<Products> products = pBiz.getByU_id(uid);
		request.setAttribute("prods", products);
		url = request.getRequestDispatcher("/app/userpro.jsp");
		return url;
	}

	public Object getPart(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String types = request.getParameter("types");
		if (types.equals("yiFu")) {
			types = "衣服";
		} else if (types.equals("shuJi")) {
			types = "书籍";
		} else if (types.equals("shengHuo")) {
			types = "生活用品";
		} else if (types.equals("huaZhuang")) {
			types = "化妆品";
		} else if (types.equals("yunDong")) {
			types = "运动器材";
		} else if (types.equals("dianZi")) {
			types = "电子产品";
		} else {
			types = "箱包";
		}
		List<Products> products = pBiz.getByTypes(types);
		request.setAttribute("products", products);

		List<Products> list = (List<Products>) pBiz.getAll();
		request.setAttribute("prods", list);
		url = request.getRequestDispatcher("/app/allpro.jsp");
		return url;
	}

	public Object toAddPro(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		List<Products> list = (List<Products>) pBiz.getAll();
		request.setAttribute("prods", list);
		url = request.getRequestDispatcher("/app/addpro.jsp");
		return url;
	}

	public Object getByDes(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String description = request.getParameter("param");
		List<Products> list = pBiz.getByDescription(description);
		request.setAttribute("products", list);
		url = request.getRequestDispatcher("/app/allpro.jsp");
		return url;
	}
}
