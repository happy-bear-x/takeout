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
<script type="text/javascript" src="/js/resetpsw.js"></script>
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
	padding-left: 20px;
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
					<span style="color:#f00;">*当前仅能通过手机号码重置密码！</span>
					<div class="infoline">
						用户帐号：<input type="text" class="user">
					</div>
					<div class="infoline">
						手机号码：<input type="text" class="tel">
					</div>
					<div class="infoline">
						新的密码：<input type="password" class="psw">
					</div>
					<div class="infoline">
						重复密码：<input type="password" class="psw1">
					</div>
					<div class="infoline">
					<a href="#" class="changebutton" id="reset">重置密码</a>
					<a href="./Login" class="changebutton" >前往登录</a>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="/parts/footer"%>
	</div>
</body>
</html>