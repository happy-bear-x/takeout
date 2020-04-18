$(function() {
	user = document.getElementById('user');
	psw = document.getElementById('password');
	if (localStorage.getItem('user') != null) {
		document.getElementById("remmber").checked = true;
		user.value = localStorage.getItem('user');
		psw.value = localStorage.getItem('psw');
	}
})
function checkfact(form) {
	if (form.username.value == "") {
		alert("请输入账号");
		return false;
	}
	if(form.username.value.length>16){
		alert("用户名长度过长！");
	}
	
	
	if (form.password.value == "") {
		alert("请输入密码");
		return false;
	} else {
		if (form.password.value.length<6) {
			alert("密码长度少于6位！");
			return false;
		}
		if (form.password.value != form.repassword.value) {
			alert("两次密码输入不一致，请重新输入");
			return false;
		}
	}
	if (form.age.value == "") {
		alert("请输入年龄");
		return false;
	}

}
function logincheck(form) {
	if (document.getElementById("remmber").checked) {
		localStorage.setItem('user', user.value)
		localStorage.setItem('psw', psw.value)
	} else {
		localStorage.removeItem('user');
		localStorage.removeItem('psw');
	}
	if (form.username.value == "") {
		alert("请输入账号");
		return false;
	}
	if (form.password.value.length <6) {
		alert("请输入正确密码长度！");
		return false;
	}
}
function reload() {
	document.getElementById("yzm").src = "Yzm?" + Math.random();
}
