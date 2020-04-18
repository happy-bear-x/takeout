<%@page import="com.model.Address"%>
<%@page import="com.model.Account"%>
<%@page import="java.util.List"%>
<%@page import="com.model.Voucher"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/main.css" type="text/css">
<link rel="stylesheet" href="css/pay.css" type="text/css">
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/pay.js"></script>
<script type="text/javascript" src="/js/autoheight.js"></script>
<%
	String shop = null;
	String pagetitle = "结算支付";
	String num = null;
	String price = null;
	String user = null;
	String account = null;
	List<Map<String, String>> vouchers = null;
	List<Map<String, String>> address = null;
	if (session.getAttribute("user") != null) {
		user = session.getAttribute("user").toString();
	} else {
		session.setAttribute("login", "no");
		response.sendRedirect("Login");
		return;
	}
	if (session.getAttribute("account") != null) {
		Map<String, String> map = (Map) session.getAttribute("account");
		num = map.get("num");
		price = map.get("price");
		shop = map.get("shop");
		vouchers = Voucher.getAllUsableVoucher(user, price);
		account = "" + Account.getWallet(user);
		address = Address.getAllAddress(user);
	} else {
		response.sendRedirect("/");
		return;
	}
%>
<title><%=pagetitle%></title>
</head>
<body>
	<div class="main">
		<%@ include file="/parts/top"%>
		<div id="paybox">
			<a href="shop.jsp?shop=<%=shop%>">&lt;&lt;返回</a>
			<div id="content">
				总计 <span class="key"><%=num%></span> 件商品，需支付 <span class="key"
					id="price"><%=price%></span> 元
			</div>
			<form id="paymethod" action="PayCheck" method="post">
				<div id="chotitle">请确认支付内容：</div>
				<div class="boxline">
					地址 <select name="addressid" style="width: 80px;">
						<%
							if (address.size() == 0) {
								out.print("<script>if(confirm('没有地址，点击确认添加地址')){window.open('/User');}</script> ");
							} else {
								for (int i=0; i < address.size(); i++) {
									Map<String,String> addressmap=address.get(i);
						%>
						<option value="<%=addressmap.get("addressid") %>"><%=addressmap.get("city")+addressmap.get("area")+addressmap.get("street")+addressmap.get("detail")+" 电话："+addressmap.get("tel") %></option>
						<%
							}
							}
						%>

					</select>
					<a href="/User" target="_Blank">添加地址</a>
				</div>
				<div class="boxline">
					<input type="radio" name="method" checked value="0">我的钱包（余额<span
						id="account"><%=account%></span>元）<a href="">充值</a>
				</div>
				<div class="boxline">
					<input type="radio" name="method" disabled="disabled">支付宝
				</div>
				<div class="boxline">
					<input type="radio" name="method" disabled="disabled">微信
				</div>
				<div class="boxline">
					代金卷 <select name="voucher" style="width: 80px;" id="voucher">
						<option value="0">不使用</option>
						<%
							for (Map<String, String> voucher : vouchers) {
								String condition = "（无门槛）";
								if (!voucher.get("condition").equals("0")) {
									condition = "（满" + voucher.get("condition") + "元可用）";
								}
						%>
						<option value=<%=voucher.get("id")%>><%=voucher.get("worth")%>元<%=condition%>
						</option>
						<%
							}
						%>
					</select>（<%=vouchers.size()%>张可用）
				</div>
				<div class="boxline">
					实际需要支付<span class="key" id="payprice"><%=price%></span>元
				</div>
				<input id="submit" type="submit" value="确认支付">
			</form>
		</div>
		<%@include file="/parts/user/ball"%>
		<%@include file="/parts/footer"%>
	</div>
</body>
</html>