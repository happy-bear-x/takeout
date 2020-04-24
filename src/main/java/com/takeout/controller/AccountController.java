package com.takeout.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/account")
public class AccountController{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/parts/user/account.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	/*支付
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

	}*/

}
