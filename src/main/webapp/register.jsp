<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
<link rel="stylesheet" href="css/main.css" type="text/css">
<link rel="stylesheet" href="css/form.css" type="text/css">
<script type="text/javascript" src="js/check.js"></script>
<script type="text/javascript" src="js/autoheight.js"></script>
</head>
<body>

	<div class="main">
		<%
			if (session.getAttribute("error") != null) {
				out.print("<div id='logfail'>注册失败！</div>");
				session.removeAttribute("error");
			}
			if (session.getAttribute("exist") != null) {
				out.print("<div id='logfail'>该用户名已存在！</div>");
				session.removeAttribute("exist");
			}
			if (session.getAttribute("uperr") != null) {
				out.print("<div id='logfail'>上传错误！</div>");
				session.removeAttribute("uperr");
			}
		%>
		<div class="posit">
			<a href="index.jsp" style="float: left;">首页</a>
			<div class="path">>>注册</div>
		</div>
		<div id="loginbox">
			<div id="main_top">注册</div>
			<hr width="390px">
			<div id="main_center">
				<form name="form" action="./Register" method="post"
					onsubmit="return checkfact(form)" enctype="multipart/form-data">
					<p>
						输入账号：<input type="text" name="username" />
					</p>
					<p>
						输入密码：<input type="password" name="password" />
					</p>
					<p>
						确认密码：<input type="password" name="repassword" />
					</p>
					<p>
						输入昵称：<input type="text" name="nicname" value="外卖用户">
					</p>
					<p>
						注册类型：<input type="radio" name="type" value="0" checked="checked" />用户
						<input type="radio" name="type" value="1" />商家
					</p>
					<p>
						上传头像：<input type="file" name="pic">
					</p>
					<p>
						输入性别：<input type="radio" name="sex" value="0" checked="checked" />男&nbsp;&nbsp;
						<input type="radio" name="sex" value="1" />女
					</p>

					<p>
						<input type="button" style="width: 10em"
							onclick="javascript:history.go(-1);" value="取消"> <input
							type="submit" style="width: 10em" name="sub" value="注册" />
					</p>
					<div id="state">
						使用即为同意<a href="">《用户服务协议》</a>和<a href="">《隐私政策》</a>
					</div>
				</form>
			</div>
		</div>
		<%@ include file="/parts/footer"%>
	</div>
</body>
</html>