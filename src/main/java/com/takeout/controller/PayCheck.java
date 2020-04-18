package com.takeout.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Account;
import com.model.Cart;
import com.model.Order;
import com.model.Voucher;

/**
 * Servlet implementation class PayCheck
 */
@WebServlet("/PayCheck")
public class PayCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PayCheck() {
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
		HttpSession session = request.getSession();
		String user = null;
		String shop = null;
		String voucherid = null;
		String voucher = null;
		double pay = 0;
		String foodid = null;
		String addressid = null;
		// num为单件商品的数量
		String num = null;
		// 订单商品总数量
		String total = null;
		if (session.getAttribute("user") == null) {
			response.sendRedirect("/");
			return;
		} else {
			voucherid = request.getParameter("voucher");
			addressid = request.getParameter("addressid");
			user = (String) session.getAttribute("user");
			if (session.getAttribute("account")==null) {
				response.sendRedirect("/");
				return;
			}
			Map<String, String> cart = (Map) session.getAttribute("account");
			session.removeAttribute("account");
			shop = cart.get("shop");
			pay = Double.parseDouble(cart.get("price"));
			// 购物车中的num指所有商品数量
			total = cart.get("num");

		}

		// 防止用户通过审查元素绕过前端钱包检测
		if (Account.getWallet(user) < pay) {
			response.sendRedirect("error.html");
			return;
		}
		if (!voucherid.equals("0")) {

			if ((voucher = Voucher.getWorth(voucherid, user)) != null) {
				pay -= Double.parseDouble(voucher);
				if (pay < 0) {
					pay = 0;
				}
			}
		}
		String ordernum = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		for (Map<String, String> one : Cart.getUserCart(user, shop)) {

			foodid = one.get("foodid");
			num = one.get("num");
			System.out.println(foodid + num);
			if (!Order.newOrder(ordernum, user, shop, foodid, num, pay, total, addressid)) {
				Order.delOrder(ordernum);
				response.sendRedirect("error.html");
				return;
			}
		}
		if (voucher != null) {
			Order.useVoucher(ordernum, voucher);
			Voucher.spend(voucherid);
		}
		Cart.cleanCart(user, shop);
		Account.spend(user, pay);
		response.sendRedirect("order.jsp");

	}

}
