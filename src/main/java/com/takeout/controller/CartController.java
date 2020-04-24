package com.takeout.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Cart;
import com.takeout.mapper.CartMapper;
import com.takeout.tool.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CartController{

	@Autowired
	CartMapper cartMapper;

	@RequestMapping(method = RequestMethod.GET,value = "/cart")
	public AjaxJson cart(Integer userId){

		AjaxJson j=new AjaxJson();
		return  j;
	}


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
