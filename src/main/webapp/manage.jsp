<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.model.Shop,java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/css/main.css" rel="stylesheet">
<link href="/css/managebox.css" rel="stylesheet">
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/manage.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理商品</title>
</head>
<%
	String shop = null;
	String pagetitle = "小熊外卖";
	if(session.getAttribute("user")==null||!session.getAttribute("type").equals("1")){
		response.sendRedirect("/");
		return;
	}else{
		shop=(String)session.getAttribute("user");
	}
	if(session.getAttribute("newfooderr")!=null){
		out.print("<script>alert('添加失败！')</script>");
		session.removeAttribute("newfooderr");
	}
	if(session.getAttribute("uperr")!=null){
		out.print("<script>alert('请上传正确格式图片！')</script>");
		session.removeAttribute("uperr");
	}
%>
<body>
	<div class="main">
		<%@ include file="/parts/top"%>
		<div class="mid">
			<%@ include file="/parts/left"%>
			<div class="mid-main">
				<a href="javascript:void(0)">
					<div class="menu" id="menu1" onclick="add(this)">修改商品</div>
				</a> <a href="javascript:void(0)">
					<div class="menu" id="menu2" onclick="add(this)">添加商品</div>
				</a> <a href="javascript:void(0)">
					<div class="menu" id="menu3" onclick="add(this)">修改分类</div>
				</a>
				<hr width="99%">
				<%@ include file="/parts/shop/foods"%>
				<%@ include file="/parts/shop/newfood"%>
				<%@ include file="/parts/shop/revise"%>
				<div id="recategory" style="height:200px;">该功能暂未开放！</div>

			</div>
		</div>
		<%@ include file="/parts/footer"%>
	</div>
</body>
</html>