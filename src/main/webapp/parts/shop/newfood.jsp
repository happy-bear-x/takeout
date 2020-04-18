<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
<link rel="stylesheet" href="/css/login_in.css" type="text/css">
<script type="text/javascript" src="/js/time.js"></script>
</head>
<body>
	<%
		if (session.getAttribute("error") != null) {
			out.print("<div id='logfail'>添加失败，请联系管理员。</div>");
		}
		if (session.getAttribute("exist") != null) {
			out.print("<div id='logfail'>该菜品名已存在！</div>");
		}
		if (session.getAttribute("food") != null) {
			out.print("<div id='logfail'>添加成功！</div>");
		}
	%>
	<div class=mian>
		<div class="posit">
			<a href="/" style="float: left;">首页</a>
			<div class="path">>>添加菜品</div>
		</div>
		<hr width="100%">
		<div id=loginbox>
			<div id="main_top">菜品</div>
			<hr width="390px">
			<div id="main_center">
				<form name="form" action="Newfood" method="post"
					onsubmit="return checkfact(form)" enctype="multipart/form-data">
					<p>
						输入菜名：<input type="text" name="name" />
					</p>
					<p>
						输入价格：<input type="number" name="price" value="0">
					</p>
					<p>
						上传图片：<input type="file" name="pic">
					</p>
					<p>
						添加描述：<input type="text" name="des">
					</p>
					<p>
						<button type="button" onclick="javascript:history.go(-1);">取消</button>
						<input type="submit" name="sub" value="添加" />
					</p>
				</form>
			</div>
		</div>
		<%@ include file="/parts/footer"%>
	</div>
</body>
</html>