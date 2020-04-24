package com.takeout.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Account;
import com.model.Food;
import com.model.Order;
import com.model.Shop;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController{
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String start="0";
		Map<String, String> shopinfo;
		String foodname;
		HttpSession session=request.getSession();
		String user=(String) session.getAttribute("user");
		if (request.getParameter("start")!=null) {
			start=request.getParameter("start");
		}
		List<Map<String, String>> orderlist= Order.getAllOrder(user,start);
		for (int i = 0; i < orderlist.size(); i++) {
			shopinfo=Shop.getOneShop(orderlist.get(i).get("shop"));
			foodname=Food.getFoodNameById(orderlist.get(i).get("foodid"));
			orderlist.get(i).put("shopname", shopinfo.get("nicname"));
			orderlist.get(i).put("shoppic", shopinfo.get("headpic"));
			orderlist.get(i).put("foodname", foodname);
		}
		
	}
	/*
	确认收货
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ordernum=request.getParameter("ordernum");
		if(Order.changeRecOrder(ordernum)){
			Map<String, String> map=Order.findOrderByNum(ordernum);
			Account.earn(map.get("shop"), map.get("pay"));
			response.getWriter().print("succeed");
		}
	}*/


	/*
	订单取消
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long time = 5 * 60 * 1000;// 5分钟
		String now = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date().getTime() - time);
		String ordernum = request.getParameter("ordernum");
		String reason = request.getParameter("reason");
		Order.userReason(ordernum, reason);
		if (ordernum.compareTo(now) > 0) {
			Map<String, String> map = Order.findOrderByNum(ordernum);
			Account.earn(map.get("user"), map.get("pay"));
			Order.finishCancelOrder(ordernum);
			response.getWriter().print("succeed");
		} else {
			Order.cancelOrder(ordernum);
			response.getWriter().print("wait");
		}
	}*/

	/*
	订单改为配送状态
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ordernum=request.getParameter("ordernum");
		if(Order.changeTakingOrder(ordernum)){
			response.getWriter().print("succeed");
		}
	}*/

	/*
	订单评论
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<String> list=new ArrayList<>();
		String ordernum=request.getParameter("ordernum");
		String user=(String) request.getSession().getAttribute("user");
		list.add(ordernum);
		list.add(user);
		list.add(request.getParameter("shop"));
		list.add(request.getParameter("score"));
		list.add(request.getParameter("judgment"));
		JSONArray jsonArray=new JSONArray();
		jsonArray.addAll(list);
		String orvalues=jsonArray.toString();
		String values=orvalues.substring(1, orvalues.length()-1);
		if (Judgment.newJudge(values)) {
			Order.finishOrder(ordernum);
		}
	}*/
}
