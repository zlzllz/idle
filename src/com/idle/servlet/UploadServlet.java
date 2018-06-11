package com.idle.servlet;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.idle.biz.ProductsBiz;
import com.idle.biz.UsersBiz;
import com.idle.biz.impl.ProductsBizImpl;
import com.idle.biz.impl.UsersBizImpl;
import com.idle.entity.Products;
import com.idle.entity.Users;

/**
 * @author lilingzhi
 * @date 2017年5月10日 下午7:24:04
 */

public class UploadServlet  {
	
	public static Products save( HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Products p = new Products();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		UsersBiz uBiz = new UsersBizImpl();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");// 解决文件名称乱码
		
		if(upload.isMultipartContent(request)){
			try {
				List<FileItem> list = (List) upload.parseRequest(request);
				for(FileItem fileItem : list){
					if(fileItem.isFormField()){
						String key = fileItem.getFieldName();
						String value = fileItem.getString("utf-8");
						if(key.equals("pname")){
							p.setPname(value);
						}else if(key.equals("types")){
							p.setTypes(value);
						}else if(key.equals("oldprice")){
							p.setOldprice(Double.parseDouble(value));
						}else if(key.equals("currentprice")){
							p.setCurrentprice(Double.parseDouble(value));
						}else if(key.equals("description")){
							p.setDescription(value);
						}else if(key.equals("users")){
							Users user = uBiz.getByUsername(value);
							p.setUser(user);
						}else{
							System.out.println(key+"======="+value);
						}
					}else{
						String name = fileItem.getName();
						SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmssSS");
						String time = format.format(new Date());
						String tag = time + name;
						String path = request.getServletContext().getRealPath("/pictures");
						File file = new File(path,tag);
						p.setImg(tag);
						fileItem.write(file);
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}else{
			System.out.println("没有上传文件");
		}
		return p;
	}
	
	public static Products update( HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		Products p = new Products();
		ProductsBiz pBiz = new ProductsBizImpl();
		UsersBiz uBiz = new UsersBizImpl();
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");// 解决文件名称乱码
		
		if(upload.isMultipartContent(request)){
			try {
				List<FileItem> list = (List) upload.parseRequest(request);
				for(FileItem fileItem : list){
					if(fileItem.isFormField()){
						String key = fileItem.getFieldName();
						String value = fileItem.getString("utf-8");
						if(key.equals("id")){
							p = pBiz.getById(Integer.parseInt(value));
						}else if(key.equals("pname")){
							p.setPname(value);
						}else if(key.equals("types")){
							p.setTypes(value);
						}else if(key.equals("oldprice")){
							p.setOldprice(Double.parseDouble(value));
						}else if(key.equals("currentprice")){
							p.setCurrentprice(Double.parseDouble(value));
						}else if(key.equals("description")){
							p.setDescription(value);
						}else if(key.equals("status")){
							p.setStatus(Integer.parseInt(value));
						}else{
							Users user = uBiz.getByUsername(value);
							p.setUser(user);
						}
					}else{
						String name = fileItem.getName();
						SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmssSS");
						String time = format.format(new Date());
						String tag = time + name;
						String path = request.getServletContext().getRealPath("/pictures");
						File file = new File(path,tag);
						p.setImg(tag);
						fileItem.write(file);
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}else{
			System.out.println("没有上传文件");
		}
		return p;
	}

}
   