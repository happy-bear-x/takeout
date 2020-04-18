<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.model.Shop"%>
<%@page import="com.model.Food"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/main.css" type="text/css">
<style>
.findtitle {
	margin:5px 0;
	width: 100%;
	padding-left: 5px;
	font-size: 18px;
	background: #c0c0c0;
	box-sizing: border-box;
}
</style>
<%
	String pagetitle = "搜索结果";
	String name = null;
	List<Map<String, String>> shoplist = new ArrayList();
	List<Map<String, String>> shoplistbyfood = new ArrayList();
	String headpic;
	if (request.getParameter("find") != null) {
		name = request.getParameter("find");
		if (name.equals("")) {
			response.sendRedirect("/");
		}
		shoplist = Shop.findShopByNicName(name, "0");
		shoplistbyfood = Shop.findShopByFoodName(name, "0");
	} else {
		response.sendRedirect("/");
	}
%>
<title><%=name + "-" + pagetitle%></title>
</head>
<body>
	<div class="main">
		<%@ include file="/parts/top"%>
		<div class="mid">
			<%@ include file="/parts/left"%>
			<div class="mid-main">
				<%
					if (shoplist.size() > 0) {
						out.print("<div class='findtitle'>店铺名包含“" + name + "”的店铺:</div>");
						for (Map<String, String> map : shoplist) {
							if (map.get("headpic") != null && !map.get("headpic").equals("")) {
								headpic = map.get("headpic");
							} else {
								headpic = "img/headpic/default.jpg";
							}
				%>
				<a href="shop.jsp?shop=<%=map.get(">
					<div class="shop">
						<img class="shoppic" src="<%=headpic%>">
						<div class="shop-msg" style="margin-left: 5px;">
							<div class="shop-name">
								<%
									out.print(map.get("nicname"));
								%>
							</div>
							<br>人均：70元<br>配送：40-60分钟<br>距离：0.1km
						</div>
					</div>
				</a>
				<%
					}
					} else {
						out.print("<div class='findtitle'>没有“"+name+"”相关店铺搜索结果。</div>");
					}
					if (shoplistbyfood.size() > 0) {
						out.print("<div class='findtitle'>商品包含“" + name + "”的店铺:</div>");
						for (Map<String, String> map : shoplistbyfood) {
							if (map.get("headpic") != null && !map.get("headpic").equals("")) {
								headpic = map.get("headpic");
							} else {
								headpic = "img/headpic/default.jpg";
							}
				%>
				<a href="shop.jsp?shop=<%=map.get(">
					<div class="shop">
						<img class="shoppic" src="<%=headpic%>">
						<div class="shop-msg" style="margin-left: 5px;">
							<div class="shop-name">
								<%
									out.print(map.get("nicname"));
								%>
							</div>
							<br>人均：70元<br>配送：40-60分钟<br>距离：0.1km
						</div>
					</div>
				</a>
				<%
					}
					} else {
						out.print("<div class='findtitle'>没有店铺包含商品“"+name+"”。</div>");
					}
				%>
			</div>
		</div>
		<%@ include file="/parts/footer"%>
	</div>
</body>
</html>