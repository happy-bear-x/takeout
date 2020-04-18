<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.model.*,java.sql.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/main.css" type="text/css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/autoheight.js"></script>
<%
	String shop = null;
	String pagetitle = "小熊外卖";
%>
<title><%=pagetitle %></title>
</head>
<body>
	<%
		if (request.getParameter("shop") != null) {
			shop = request.getParameter("shop");
			pagetitle = Shop.getNicName(shop);
		}
	%>
	<div class="main">
		<%@ include file="/parts/top"%>
		<div class="mid">
			<%@ include file="/parts/left" %>
			<div class="mid-main">
				<%
					ResultSet rs = Shop.selectAll();
					String headpic = null;
					while (rs.next()) {
						if (rs.getString("headpic") != null&&!rs.getString("headpic").equals("")) {
							headpic = "./"+rs.getString("headpic");
						}else{
							headpic="./img/headpic/default.jpg";
						}
				%>
				<a href="shop.jsp?shop=<%=rs.getString(">
					<div class="shop">
						<img class="shoppic" src="<%=headpic%>">
						<div class="shop-msg" style="margin-left:5px;">
							<div class="shop-name">
								<%
									out.print(rs.getString("nicname"));
								%>
							</div>
							<br>人均：70元<br>配送：40-60分钟<br>距离：0.1km
						</div>
					</div>
				</a>
				<%
					}
				%>
			</div>
		</div>
		<%@ include file="/parts/footer"%>
	</div>
	<%@ include file="/parts/user/ball"%>
</body>
</html>