$(document).ready(function() {
	$("#voucher").change(function() {
		voucher=$("#voucher").find("#voucher:selected").text();
		payprice = $("#price").text() - voucher.match(/\d+/);
		if (payprice < 0) {
			payprice = 0;
		}
		$("#payprice").text(payprice);

	});
	$("#submit").click(function(){
		if($("#account").text()-$("#payprice").text()<0){
			if(confirm("余额不足，点击确定将进入充值页面！")){
				　window.location.href="/parts/user/account.jsp";
			}
			
			return false;
		}
	})
})