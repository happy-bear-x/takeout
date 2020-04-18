package com.takeout.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Cart;

/**
 * Servlet implementation class AddCart
 */
@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 首先判断用户是否登录
		HttpSession hs = request.getSession();
		if (hs.getAttribute("user") != null) {
			String user = (String) hs.getAttribute("user");
			if (request.getParameter("id") != null) {
				String foodid = request.getParameter("id");
				String shopname = request.getParameter("name");
				if (Cart.insertFood(foodid, user, shopname)) {
				}
				response.sendRedirect("shop.jsp?shop=" + shopname);
				return;
			}
			response.sendRedirect("");
			return;
		} else {
			hs.setAttribute("login", "n");
			response.sendRedirect("Login");
		}
	}

}
