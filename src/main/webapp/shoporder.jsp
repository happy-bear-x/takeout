<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/shoporder.js"></script>
<link rel="stylesheet" href="/css/main.css">
<link rel="stylesheet" href="/css/order.css">
<%
	String pagetitle = "商家订单";
	if (session.getAttribute("type") == null) {
		response.sendRedirect("/Login");
	}
%>
<style>
#footer {
	position: relative;
}
</style>
<title>订单</title>
</head>
<body>
	<div class="main">
		<%@ include file="/parts/top"%>
		<div class="mid">
			<%@ include file="/parts/left"%>
			<div class="mid-main">
				<div class="order">
					<input type="hidden" class="shopid"> <input type="hidden"
						name="ordernum" class="ordernum">
					<div class="orderbox">
						<div class="shopline">
							<div>
								<a class="infourl"><img class="shoppic" src="/img/headpic/default.jpg"></a>
							</div>
							<div class="shopname">小熊餐馆</div>
							<div class="state" style="float: right; margin-right: 10px;">订单已完成</div>
							<div class="foodsline">招牌炒饭等两件商品</div>
							<div class="ordermsg" id="usermsg">点错了</div>
							<div class="ordermsg" id="shopmsg">以发货</div>
						</div>
						<div class="orderline">
							<span class="price">￥30</span> <a class="judgeent"
								href="javascript:void(0)">取消订单</a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<%@ include file="/parts/footer"%>
	</div>
</body>
</html>