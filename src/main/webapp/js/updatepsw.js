function check() {
	var user = $(".user").val();
	if (user == "") {
		alert("请输入帐号！");
		return false;
	}
	var newpsw = $(".newpsw").val();
	if (newpsw == "") {
		alert("请输入密码！");
		return false;
	}else if(newpsw.length<6){
		alert("密码长度小于6位");
		return false;
	}
	if(newpsw!=$(".newpsw1").val()){
		alert("两次密码不一致");
		return false;
	}
	return true;
}
$(function() {
	$("#reset").click(function() {
		if (check()) {
			$.ajax({
				type : "post",
				url : "UpdatePsw",
				data : {
					user : $(".user").val(),
					oldpsw : $(".oldpsw").val(),
					newpsw : $(".newpsw").val()
				},
				success : function(data) {
					console.log(data);
					if (data == "succeed") {
						if(confirm("修改成功，点击确定进行登录。")){
							　window.location.href="/Login";
						}
					} else {
						alert("修改失败，请检查输入信息是否正确。");
					}
				},
				error : function() {
					alert("与服务器连接失败！");
				}
			})
		}
	})
})