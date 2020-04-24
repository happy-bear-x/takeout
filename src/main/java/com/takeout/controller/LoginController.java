package com.takeout.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Servlet implementation class AddCart
 */
@Controller
@RequestMapping("/login")
public class LoginController{

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		//判断前端是否有传来user，以处理用户直接访问本Servlet
		if (session.getAttribute("user") != null) {
			response.sendRedirect("/");
			return;
		}
		//判断验证码是否输入以及是否正确
		if (request.getParameter("check") != null) {
			if (request.getParameter("check").equals(session.getAttribute("yzm"))) {
				//验证码通过，判断帐号密码是否正确
				if (request.getParameter("username") != null && request.getParameter("password") != null) {
					String user = request.getParameter("username");
					String password = request.getParameter("password");
					Map<String,String> map;
					session.setAttribute("password", password);
					if (!(map = User.login(user, password)).isEmpty()) {
						//登录成功，设置用户session信息
						session.setAttribute("user", user);
						session.setAttribute("nicname", map.get("nicname"));
						session.setAttribute("type", map.get("type"));
						session.setAttribute("headpic", map.get("headpic"));
						//判断用户是否选择七天免登陆，若选择，则将部分信息放入cookie中
						if (request.getParameter("autologin")!=null) {
							Cookie cookie=new Cookie("user", user);
							cookie.setMaxAge(60*60*24*7);
							response.addCookie(cookie);
						}
						session.removeAttribute("yzm");
						response.sendRedirect("/");
						return;
					} else {
						session.setAttribute("fail", "fail");
					}
				}
			} else {
				session.setAttribute("check", "error");
			}
		}

		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 退出登录
		request.getSession().invalidate();
		Cookie[] cookies=request.getCookies();
		if (cookies!=null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("user")) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
		response.sendRedirect("/");
	}
}
