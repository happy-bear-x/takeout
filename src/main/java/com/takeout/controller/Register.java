package com.takeout.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.takeout.tool.PicTool;
import com.jspsmart.upload.SmartUpload;
import com.model.User;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//包含图片上传，所以需要使用SmartUpload组件
		SmartUpload su = new SmartUpload();
		String headpic = null;
		ServletConfig config=this.getServletConfig();
		String abspath = config.getServletContext().getRealPath("/") + "img" + java.io.File.separator;
		String dir = "headpic";
		//设置可上传的文件后缀
		su.setAllowedFilesList("jpg,png,jpeg");
		su.initialize(config, request, response);
		try {
			su.upload();
		} catch (Exception e) {
			//用户上传错误格式文件，向前端发送错误，并跳转到注册页面。
			request.getSession().setAttribute("uperr", "uperr");
			response.sendRedirect("./register.jsp");
			return;
		}
		HttpSession hs = request.getSession();
		List<String> list = new ArrayList<>();
		//获取前端发送的数据
		String name = su.getRequest().getParameter("username");
		String password = su.getRequest().getParameter("password");
		String repassword = su.getRequest().getParameter("repassword");
		if (password.equals(repassword)) {
			headpic = PicTool.renamePic(su, abspath, dir);
			list.add(name);
			list.add(password);
			list.add(su.getRequest().getParameter("birth"));
			list.add(headpic);
			list.add(su.getRequest().getParameter("type"));
			list.add(su.getRequest().getParameter("sex"));
			list.add(su.getRequest().getParameter("nicname"));
			//判断用户是否存在，若不存在，则保存到数据，若存在则返回页面并给出提示已存在。
			if (!User.isexist(name)) {
				if (User.insert(list)) {
					response.getWriter().write("用户“"+name+"”注册成功！3s后跳转到登录页面。");
					response.setHeader("refresh", "3;url=Login");
				} else {
					hs.setAttribute("error", "error");
					request.getRequestDispatcher("register.jsp").forward(request, response);
				}
			} else {
				hs.setAttribute("exist", name);
				response.sendRedirect("register.jsp");

			}
		}
	}
}
