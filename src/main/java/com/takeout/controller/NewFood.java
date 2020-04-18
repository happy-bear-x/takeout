package com.takeout.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.takeout.tool.HtmlFilterRequest;
import com.takeout.tool.PicTool;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.model.Food;

@WebServlet("/NewFood")
public class NewFood extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
	final public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

	public NewFood() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HtmlFilterRequest filterRequest=new HtmlFilterRequest(request);
		// 上传图片需要SmartUpload，并设置保存路径。
		HttpSession hs = filterRequest.getSession();
		String abspath = config.getServletContext().getRealPath("/") + "img" + java.io.File.separator;
		String dir = "foods";
		SmartUpload su = new SmartUpload();
		//限制上传文件类型
		su.setAllowedFilesList("jpg,png,jpeg");
		su.initialize(config, request, response);
		try {
			su.upload();
		} catch (Exception e) {
			request.getSession().setAttribute("uperr", "uperr");
			response.sendRedirect("manage.jsp");
			return;
		}
		//获取前端数据，并调用服务类方法保存至数据库
		String shop = (String) hs.getAttribute("user");
		String name = su.getRequest().getParameter("name");
		String price = su.getRequest().getParameter("price");
		String des = su.getRequest().getParameter("des");
		String picturepath = PicTool.renamePic(su, abspath, dir);
		if (name.equals(" ")&&Food.newFood(shop, name, price, picturepath, des)) {
			hs.setAttribute("food", "succeed");
		} else {
			hs.setAttribute("newfooderr", "error");
		}
		response.sendRedirect("manage.jsp");
	}
}
