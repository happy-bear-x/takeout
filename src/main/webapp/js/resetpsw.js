function check() {
	var user = $(".user").val();
	var psw=$(".psw").val();
	var tel = $(".tel").val();
	var reg = /^[1][3,4,5,7,8][0-9]{9}$/;
	if (user == "") {
		alert("请输入帐号！");
		return false;
	}
	if (psw == "") {
		alert("请输入密码！");
		return false;
	}else if(psw.length<6){
		alert("密码长度小于6位");
		return false;
	}
	if(psw!=$(".psw1").val()){
		alert("两次密码不一致");
		return false;
	}
	
	if (tel.length == 11 && reg.test(tel)) {
		return true;
	} else {
		alert("手机输入错误！");
		return false;
	}
}
$(function() {
	$("#reset").click(function() {
		if (check()) {
			$.ajax({
				type : "post",
				url : "ReSetPsw",
				data : {
					user : $(".user").val(),
					tel : $(".tel").val(),
					psw : $(".psw").val()
				},
				success : function(data) {
					console.log(data);
					if (data == "succeed") {
						if(confirm("重置成功，点击确定进行登录。")){
							　window.location.href="/Login";
						}
					} else {
						alert("重置失败，请检查输入信息是否正确。");
					}
				},
				error : function() {
					alert("与服务器连接失败！");
				}
			})
		}
	})
})