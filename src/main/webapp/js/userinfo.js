$(function() {
	var headpic = $(".newheadpic")
	$("#changeheadpic").click(function() {
		if ($("#changeheadpic").text() == "取消") {
			location.reload();
		} else {
			headpic.click();
		}
	});
	$("#changeinfo").click(function() {
		if ($("#changeinfo").text() != "保存") {
			toinput(".nicname");
			toinput(".sex");
			toinput(".birth");
			toinput(".tel");
			addr();
			$("#changeinfo").text("保存");
			$("#changeheadpic").text("取消");
		} else if (!infocheck()) {
			return false;
		} else {
			$.ajax({
				type : "post",
				url : "InfoUpdate",
				data : {
					nicname : $(".nicname").val(),
					sex : $(".sex").val(),
					birth : $(".birth").val(),
					tel : $(".tel").val(),
					city : $(".city").val(),
					area : $(".area").val(),
					street : $(".street").val(),
					detail : $(".detail").val(),
					addrid : $(".addrid").val()
				},
				success : function(data) {
					if (data != 'succeed') {
						alert("上传发生错误！");
					}
					location.reload();
				},
				error : function() {
					alert("与服务连接异常！");
				}
			})
		}

	});
	headpic.bind('change', function() {
		var file = $(this).val();
		if (file.length > 0) {
			var formData = new FormData($('.mid-main')[0]);
			$.ajax({
				type : "post",
				url : "UserHeadPic",
				data : formData,
				cache : false,
				processData : false,
				contentType : false,
				success : function(data) {
					if (data == 'succeed') {
						alert("上传成功！");
					} else {
						alert("上传发生错误！");
					}
					location.reload();
				},
				error : function() {
					alert("上传失败");
				}
			})
		}
	});

})
function toinput(str) {
	var val = $(str).text();
	var cclass = $(str).attr("class");
	var $input = $("<input>", {
		val : val,
		type : "text"
	});
	$input.addClass(cclass);
	$(str).replaceWith($input);

}
function addr() {
	var val = $(".address").text();
	var vals = val.split("/");
	var $input = $("<input>", {
		val : vals[0],
		type : "text",
		width : "50px"
	});
	$input.addClass("city");
	var $input1 = $("<input>", {
		val : vals[1],
		type : "text",
		width : "50px"
	});
	$input1.addClass("area");
	var $input2 = $("<input>", {
		val : vals[2],
		type : "text",
		width : "50px"
	});
	$input2.addClass("street");

	var $input3 = $("<input>", {
		val : vals[3],
		type : "text",
		width : "50px"
	});
	$input3.addClass("detail");
	$(".address").replaceWith($input);
	$(".city").after($input1);
	$(".area").after($input2);
	$(".street").after($input3);

}
function infocheck() {
	if ($(".sex").val() != "男" && $(".sex").val() != "女") {
		alert("性别输入错误！");
		return false;
	}
	if($(".city").val()==""){
		alert("请输入城市。");
	}
	if($(".area").val()==""){
		alert("请输入区/县。");
	}
	if($(".street").val()==""){
		alert("请输入街/镇。");
	}
	if($(".detail").val()==""){
		alert("请输入详细地址。");
	}
	var tel = $(".tel").val();
	var reg = /^[1][3,4,5,7,8][0-9]{9}$/;
	if (tel.length == 11 && reg.test(tel)) {
		return true;
	} else {
		alert("手机输入错误！");
		return false;
	}
	
}