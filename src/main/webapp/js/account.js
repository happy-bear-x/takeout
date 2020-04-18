$(function() {
	$("#topup").click(function() {
		showtopup();
	});
	$('#confirm').click(function() {
		$.ajax({
			type : "post",
			url : "/AccountTopUp",
			data : {
				money : $("#money").val()
			},
			success : function(data) {
				if (data == "succeed") {
					location.reload();
				} else {
					alert("遇到错误！");
				}
			},
			error : function() {
				alert("与服务器连接失败！");
			}
		})
		return;
	})

})
function showtopup(){
	$(".hide").toggle();
}