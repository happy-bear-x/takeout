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
<script type="text/javascript" src="/js/autoheight.js"></script>
<script type="text/javascript" src="/js/account.js"></script>
<%
	String user = null;
	String pagetitle = "个人账户";
%>
<title><%=pagetitle%></title>
<style>
#money {
	margin:10px 5px;
	width: 150px;
	height: 30px;
	box-sizing: border-box;
	border-radius: 10px 10px 10px 10px;
}

.hide {
	display:none;
	position: fixed;
	margin: 0 auto;
	background:#fff;
	width:250px;
	height:100px;
	border: solid 1px #00f;
}

.account {
	text-align: center;
	width: 300px;
	border: solid 1px #ff8000;
	background: #ffc000;
	border-radius: 20px;
	margin: 5px 150px;
	padding-left: 20px;
	width: 300px;
}

.voucher {
	width: 300px;
	border: solid 1px #ff8000;
	background: #ff9000;
	border-radius: 20px;
	margin: 5px 150px;
	padding-left: 20px;
}

.infoline {
	margin-left: 0;
}
</style>
</head>
<body>
	<div class="main">
		<%
			if (session.getAttribute("user") != null) {
				user = (String) session.getAttribute("user");
				double wallet = Account.getWallet(user);
				List<Map<String, String>> list = Voucher.getAllUsableVoucher(user,"1000");
		%>
		<%@ include file="/parts/top"%>
		<div class="mid">
			<%@ include file="/parts/left"%>
			<div class="mid-main">
				<div class="account">
					<div class="infoline">
						账户余额：<span class="wallet"><%=wallet%>元</span>
					</div>
					<div class="hide">
						充值<input type="number" id="money" value="50">元 
						<a href="#" class="changebutton" onclick="showtopup();">取消</a>
						<a href="#"	class="changebutton" id="confirm">确认充值</a>
							 
							
					</div>
					<div class="infoline">
						<a href="#" class="changebutton" id="topup">充值</a>
					</div>
				</div>
				<%
					for (Map<String, String> voucher : list) {
							String condition = "（无门槛）";
							if (!voucher.get("condition").equals("0")) {
								condition = "（满" + voucher.get("condition") + "元可用）";
							}
							String endtime = voucher.get("endtime").substring(0, voucher.get("endtime").length() - 5);
				%>
				<div class="voucher">
					<div class="infoline">
						代金卷：<span class="user"><%=voucher.get("worth")%>元<%=condition%></span>
					</div>
					<div class="infoline">
						到期时间：<span class="user"><%=endtime%></span>
					</div>
				</div>
				<%
					}
				%>
			</div>
		</div>
		<%
			} else {
				response.sendRedirect("/Login");
			}
		%>
		<%@ include file="/parts/footer"%>
	</div>
</body>
</html>