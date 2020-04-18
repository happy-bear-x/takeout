<%@page import="com.model.Food"%>
<%@page import="com.model.Order"%>
<%@page import="com.takeout.tool.Tel"%>
<%@page import="java.util.List"%>
<%@page import="com.model.Address"%>
<%@page import="com.model.User"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/main.css" type="text/css">
<link rel="stylesheet" href="/css/userinfo.css" type="text/css">
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/autoheight.js"></script>
<%
	String user = null;
	String pagetitle = "订单详情";
%>
<title><%=pagetitle%></title>
</head>
<body>
	<%
		if ((user = (String) session.getAttribute("user")) != null) {
			String ordernum = request.getParameter("ordernum");
			List<Map<String, String>> list = Order.findOrderListByNum(ordernum);
			String nicname = User.getNicName(list.get(0).get("user"));
			String shopname = User.getNicName(list.get(0).get("shop"));
			String voucher = list.get(0).get("voucher");
			String pay = list.get(0).get("pay");
			String state = list.get(0).get("state");
			String total = list.get(0).get("total");
			String finishtime = list.get(0).get("finishtime");
			String uaddition = list.get(0).get("uaddition");
			String saddition = list.get(0).get("saddition");
			Map<String, String> addr = Address.findAddrById(list.get(0).get("addressid"));
			String tel = addr.get("tel");
			String address = addr.get("area") + addr.get("street") + addr.get("detail");
	%>
	<div class="main">
		<%@ include file="/parts/top"%>
		<div class="mid">
			<%@ include file="/parts/left"%>
			<div class="mid-main">

				<div class="infoline">
					订单号码：<span><%=ordernum%></span>
				</div>
				<div class="infoline">
					商家名称：<span><%=shopname%></span>
				</div>
				<div class="infoline">
					用户昵称：<span><%=user%></span>
				</div>
				<div class="infoline">
					用户手机：<span><%=tel%></span>
				</div>
				<div class="infoline">
					用户地址：<span><%=address%></span>
				</div>
					<%
						for (Map<String, String> map : list) {
								String foodname = Food.getFoodNameById(map.get("foodid"));
					%>
					<div class="infoline" style="color: #0f0fff">
						<span style="margin-left: 50px"><%=foodname%>x<%=map.get("num")%></span>
					</div>
					<%
						}
					%>
				<div class="infoline">
					总计数量：<span><%=total%>样商品</span>
				</div>
				<%
					if (!voucher.equals("0")) {
				%>
				<div class="infoline">
					使用红包：<span><%=voucher%>元</span>
				</div>
				<%
					}
				%>
				<div class="infoline">
					实际支付：<span><%=pay%>元</span>
				</div>
				<%
					if (uaddition != null) {
				%>
				<div class="infoline">
					用户消息：<span><%=uaddition%></span>
				</div>
				<%
					}
				%>
				<%
					if (saddition != null) {
				%>
				<div class="infoline">
					商家消息：<span><%=saddition%>元</span>
				</div>
				<%
					}
				%>
			</div>
		</div>
		<%
			} else {
				response.sendRedirect("/Login");
			}
		%>
		<%@ include file="/parts/footer"%>
		<%@ include file="/parts/user/ball"%>
	</div>
</body>
</html>