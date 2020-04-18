<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<link rel="stylesheet" href="css/main.css" type="text/css">
<link rel="stylesheet" href="css/form.css" type="text/css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/check.js"></script>
<script type="text/javascript" src="js/autoheight.js"></script>
</head>

<body>
	<div class="main">
		<%
			String name = "";
			String psw = "";
			if (session.getAttribute("fail") != null) {
				out.print("<div id='logfail'>登录失败，请检查帐号和密码！</div>");
				session.removeAttribute("fail");
			}
			if (session.getAttribute("check") != null) {
				out.print("<div id='logfail'>请输入正确的验证码！</div>");
				session.removeAttribute("check");
			}
			if (session.getAttribute("login") != null) {
				out.print("<div id='logfail'>您还未登录，请先登录。</div>");
				session.removeAttribute("login");
			}
			if (request.getParameter("username") != null && request.getParameter("password") != null) {
				name = request.getParameter("username");
				psw = request.getParameter("password");
			}
		%>
		<div class="posit">
			<a href="index.jsp" style="float: left;">首页</a>
			<div class="path">>>登录</div>
		</div>
		<div id="loginbox">
			<div id="main_top">帐号登录</div>
			<hr width="390px">
			<div id="main_center">
				<form name="form" action="/Login" method="post"
					onsubmit="return logincheck(form)">
					<table align="center">
						<tr>
							<td><input class="login" id="user" type="text"
								name="username" placeholder="帐号" value="<%=name%>">
						</tr>
						<tr>
							<td><input class="login" id="password" type="password"
								name="password" placeholder="密码" value="<%=psw%>">
						</tr>
						<tr>
							<td><input class="double" type="text" name="check"
								placeholder="输入验证码">
							<td><a href="javascript:void(0)" onclick="reload()"><img
									id="yzm" class="double" alt="验证码" src="Yzm" title="看不清？点击刷新。"></a>
						</tr>
						<tr>
							<td><div class="chebox">
									<input type="checkbox" id="remmber" value="y">记住密码
								</div></td>
							<td><div class="chebox">
									<input type="checkbox" name="autologin" value="y">七天免登陆
								</div></td>

						</tr>
						<tr>
							<td><input class="double" type="submit" value="登录">
							<td><a href="register.jsp"><input class="double"
                                                              type="button" value="注册"></a></td>
						</tr>
					</table>
				</form>
			</div>

			<div id="main_bottom" align="center">
				<a href="resetpsw.jsp">忘记密码</a>
			</div>
			<div id="state">
				使用即为同意<a href="">《用户服务协议》</a>和<a href="">《隐私政策》</a>
			</div>
		</div>
		<%@ include file="/parts/footer"%>
	</div>

</body>
</html>