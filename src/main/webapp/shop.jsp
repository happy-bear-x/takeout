<%@page import="com.model.Shop"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/main.css" type="text/css">
<link rel="stylesheet" href="css/shop.css" type="text/css">
<script type="text/javascript" src=js/jquery.js></script>
<script type="text/javascript" src=js/shop.js></script>
<script type="text/javascript" src="js/autoheight.js"></script>
<%
	String shop = null;
	String pagetitle = "小熊外卖";
%>
<title><%=pagetitle%></title>
</head>
<body>
	<%
		if (request.getParameter("shop") != null) {
			shop = request.getParameter("shop");
			if ((pagetitle = Shop.getNicName(shop)) == null) {
				request.getRequestDispatcher("./error.jsp").forward(request, response);
			}
		} else {
			response.sendRedirect("./");
			return;
		}
	%>
	<div class="main">
		<%@ include file="/parts/top"%>

		<div class="mid">
			<%@ include file="/parts/left"%>
			<div class="mid-main">
				<%@ include file="/parts/shop/foods"%>
			</div>
			<%@ include file="/parts/right.jsp" %>
		</div>
		<%@ include file="/parts/user/ball"%>
		<%@ include file="/parts/user/cart"%>
		<%@ include file="/parts/footer"%>

	</div>
</body>
</html>