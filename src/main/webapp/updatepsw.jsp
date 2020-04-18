<%@page import="com.model.Voucher"%>
<%@page import="com.model.Account"%>
<%@page import="java.util.List"%>
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
<script type="text/javascript" src="/js/updatepsw.js"></script>
<script type="text/javascript" src="/js/autoheight.js"></script>
<%
	String user = null;
	String pagetitle = "个人账户";
%>
<title><%=pagetitle%></title>
<style>

.account {
	text-align: center;
	width: 300px;
	background: #AEEEEE;
	border-radius: 20px;
	margin: 5px 150px;
	padding-left: 10px;
	width: 300px;
}

.infoline {
	margin-left: 0;
}
</style>
</head>
<body>
	<div class="main">
		<%@ include file="/parts/top"%>
		<div class="mid">
			<%@ include file="/parts/left"%>
			<div class="mid-main">
				<div class="account" >
					<div class="infoline">
						用户帐号：<input type="text" class="user">
					</div>
					<div class="infoline">
						当前密码：<input type="password" class="oldpsw">
					</div>
					<div class="infoline">
						新的密码：<input type="password" class="newpsw">
					</div>
					<div class="infoline">
						重复密码：<input type="password" class="newpsw1">
					</div>
					<div class="infoline">
					<a href="#" class="changebutton" id="reset">确认修改</a>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="/parts/footer"%>
	</div>
</body>
</html>