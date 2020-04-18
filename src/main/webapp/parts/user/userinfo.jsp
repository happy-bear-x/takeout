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
<script type="text/javascript" src="/js/userinfo.js"></script>
<%
	String user = null;
	String pagetitle = "个人资料";
%>
<title><%=pagetitle%></title>
</head>
<body>
	<%
		if ((user = (String) session.getAttribute("user")) != null) {
			Map<String, String> map = User.getUserInfo(user);
			Map<String, String> addr = Address.getShopAddress(user);
			String sex = null;
			String headpic = "/img/headpic/default.jpg";
			String address = "无";
			String tel = "未绑定";
			String birth = "未设置";
			String addrid = "0";
			if (map.get("birth") != null) {
				birth = map.get("birth");
			}
			if (map.get("tel") != null) {
				tel = new Tel(map.get("tel")).safeTel();
			}
			if (addr.get("city") != null) {
				addrid = addr.get("addressid");
				address = addr.get("city") + "/" + addr.get("area") + "/" + addr.get("street") + "/xxx";
			}
			if (map.get("headpic") != null) {
				headpic = map.get("headpic");
			}
			if (map.get("sex").equals("0")) {
				sex = "男";
			} else {
				sex = "女";
			}
	%>
	<div class="main">
		<%@ include file="/parts/top"%>
		<div class="mid">
			<%@ include file="/parts/left"%>
			<form class="mid-main" enctype="multipart/form-data"
				action="UserHeadPic">

				<input type="file" class="newheadpic" id="newheadpic" name="pic">
				<img class="headpic" src=<%=headpic%>>

				<div class="infoline">
					用户帐号：<span class="user"><%=user%></span>
				</div>
				<div class="infoline">
					注册时间：<span class="user"><%=map.get("regtime")%></span>
				</div>
				<div class="infoline">
					手机号码：<span class="tel"><%=tel%></span>
				</div>
				<div class="infoline">
					用户昵称：<span class="nicname"><%=map.get("nicname")%></span>
				</div>
				<div class="infoline">
					用户性别：<span class="sex"><%=sex%></span>
				</div>
				<div class="infoline">
					用户生日：<span class="birth"><%=birth%></span>
				</div>
				<div class="infoline">
					<input type="hidden" value=<%=addrid%> class="addrid">
					店铺地址：<span class="address"><%=address%></span>
				</div>
				<div class="infoline">
					<a href="#" class="changebutton" id="changeinfo">修改资料</a> <a
						href="#" class="changebutton" id="changeheadpic">更换头像</a>
				</div>
			</form>
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