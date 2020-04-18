arr = [];
start = 0;
$(function() {
	judge = $(".judge");
	judge.toggle();
	cartlogo = $(".cartlogo");
	cartlogo.click(function() {
		showcart();
	});
	if ($("#numball").text() == 0) {
		bansub();
	}
	$("#min").click(function() {
		showcart();
	});
	$("#cleancart").click(function() {
		$("#cart-title").after("购物车已清空~");
		$(".cart-food").remove();
		$("#numball").text(0);
		bansub();
	});
	getjudge();
})

function showcart() {
	var cart = $(".cart");
	if (cart.css("display") == "none") {
		cart.css("display", "block");
	} else {
		cart.css("display", "none");
	}

}
function bansub() {
	$("#cleancart").remove();
	$("#total").toggle();
	$("#sub").css("background", "#c0c0c0");
	$("#suba").removeAttr("href");
	$.ajax({
		type : "post",
		url : "CleanCart",
		data : {
			shop : getUrlVal("shop")
		},
		error : function(data) {
			location.reload();
		}
	})
}
function getUrlVal(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}
function getjudge() {
	$
			.ajax({
				type : "post",
				url : "JudgeGet",
				data : {
					start : start,
					shop : getUrlVal("shop")
				},
				dataType : "json",
				success : function(data) {
					arr = data;
					$("#loadlogo").remove();
					$(".mid-right").append(
							" <div class='load' id='loading'>加载中...</div>");
					setTimeout(
							function() {
								$("#loading").remove();
								addjudge();
								if (arr.length < 4) {
									$(".mid-right")
											.append(
													" <div class='load'>没有更多了...</div>");
								} else {
									$(".mid-right")
											.append(
													"<div class='load' id='loadlogo'>"
															+ "<a href='javascript:void(0)' onclick='getjudge()'>点击加载更多>></a></div>");
								}

							}, 500)
				},
				error :function(){
					alert("评论获取失败！")
				}
			});
	start += 4;
}
function addjudge() {
	for (var i = 0; i < arr.length; i++) {
		newjudge = judge.clone(true);
		newjudge.find(".user").text(arr[i].nicname);
		var score = newjudge.find(".score");
		var str = "<img src='./img/shop/score0.png'>";
		var str1 = "<img src='./img/shop/score1.png'>";
		var strw='';
		var strr='';
		for (var j = 0; j < arr[i].score; j++) {
			strr = strr+ str1;
		}
		for (var k = 0; k < (5 - arr[i].score); k++) {
			strw =strw+str;
		}
		score.html(strr+strw);
		newjudge.find(".judgment").text(arr[i].judge);
		newjudge.toggle();
		$(".mid-right").append(newjudge);
	}
}