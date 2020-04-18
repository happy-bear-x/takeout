arr = [];
start = 0;
$(function() {
	order = $(".order");
	order.toggle();
	getorder();
	if (start == 0 && arr.length == 0) {
		$("<div class='load'>抱歉，您还未购买任何物品。</div>").appendTo(".mid-main");
	}
});
function getorder() {
	$
			.ajax({
				type : "post",
				url : "OrderGet",
				data : {
					start : start
				},
				dataType : "json",
				success : function(data) {
					arr = data;
					$("#loadlogo").remove();
					$(".mid-main").append(
							" <div class='load' id='loading'>加载中...</div>");
					setTimeout(
							function() {
								$("#loading").remove();
								addorder();
								if (arr.length < 3) {
									$(".mid-main")
											.append(
													" <div class='load'>没有更多了...</div>");
								} else {
									$(".mid-main")
											.append(
													"<div class='load' id='loadlogo'>"
															+ "<a href='javascript:void(0)' onclick='getorder()'>点击加载更多>></a></div>");
								}

							}, 500)
				}
			});
	start += 3;
}

function addorder() {
	for (var i = 0; i < arr.length; i++) {
		neworder = order.clone(true);
		if (arr[i].shoppic != null) {
			neworder.find(".shoppic").attr("src", arr[i].shoppic);
		}
		neworder.find(".shopname").text(arr[i].shopname);
		neworder.find(".shopid").val(arr[i].shop);
		var uaddition= arr[i].uaddition;
		var saddition= arr[i].saddition;
		if(uaddition==null||uaddition==""){
			uaddition="无";
		}
		if(saddition==null||saddition==""){
			saddition="无";
		}
		neworder.find("#usermsg").text("取消原因：" + uaddition);
		neworder.find("#shopmsg").text("商家回应：" + saddition);
		;
		var statecode = arr[i].state;
		var state = neworder.find(".state");
		var judgeent = neworder.find(".judgeent")
		if (statecode == 0) {
			state.text("商家接单中");
			judgeent.text("取消订单");
			judgeent.attr("onclick", "cancel(this)");
		} else if (statecode == 1) {
			state.text("订单配送中");
			judgeent.attr("onclick", "confirmrec(this)");
		} else if (statecode == 2) {
			state.text("待用户评价");
			judgeent.text("订单评价");
			judgeent.attr("onclick", "showjudge(this)");
		} else if (statecode == 3) {
			state.text("订单已完成");
			judgeent.css("color", "#0c0c0c");
			judgeent.text("已评价");
			judgeent.removeAttr("href");
		} else if (statecode == -1) {
			state.text("商家处理中");
			judgeent.text("等待取消");
			neworder.find("#usermsg").css("display", "block");
			judgeent.css("color", "#0c0c0c");
			judgeent.removeAttr("href");
		} else if (statecode == -2) {
			state.text("订单已取消");
			judgeent.text("已取消");
			neworder.find(".ordermsg").css("display", "block");
			judgeent.css("color", "#0c0c0c");
			judgeent.removeAttr("href");
		} else if (statecode == -3) {
			state.text("配送中/商家拒绝取消");
			judgeent.text("确认收货");
			neworder.find(".ordermsg").css("display", "block");
			judgeent.attr("onclick", "confirmrec(this)");
		}
		neworder.find(".foodsline").text(
				arr[i].foodname + "等" + arr[i].total + "件商品");
		neworder.find(".price").text("￥" + arr[i].pay);
		neworder.find(".ordernum").val(arr[i].ordernum);
		neworder.find(".infourl").attr("href","orderinfo.jsp?ordernum="+arr[i].ordernum);
		$(".mid-main").append(neworder);
		neworder.toggle();
	}
}
function showjudge(dom) {
	var parent = $(dom).parents(".orderbox");
	if (typeof (parent.css("display")) == "undefined") {
		parent = $(dom).parents(".judge");
	}
	parent.toggle();
	parent.siblings().toggle();
}

function confirmrec(dom) {
	var order = $(dom).parents(".order");
	var ordernum = order.find(".ordernum");
	var state = order.find(".state");
	var judgeent = order.find(".judgeent");
	$.ajax({
		type : "post",
		url : "ConfirmRec",
		data : {
			ordernum : ordernum.val()
		},
		success : function(data) {
			if (data == "succeed") {
				state.text("待用户评价");
				judgeent.text("订单评价");
				judgeent.attr("onclick", "showjudge(this)")
			} else {
				alert("发生异常");
			}
		},
		error : function() {
			alert("与服务器连接失败！");
		}
	});
}

function score(score) {
	$(score).siblings().attr("src", "/img/shop/score0.png")
	var brother = $(score).prevAll();
	var submit = $(score).parents(".score").nextAll(".submit");
	for (var i = 0; i < brother.length; i++) {
		brother.eq(i).attr("src", "/img/shop/score1.png");
	}
	submit.prevAll(".scorenum").val(brother.length + 1);
	$(score).attr("src", "/img/shop/score1.png");
	submit.removeAttr("disabled");
	submit.css("background", "#ff8000");
}

function subjudge(dom) {
	var order = $(dom).parents(".order");
	var ordernum = order.find(".ordernum");
	var shop = order.find(".shopid");
	var state = order.find(".state");
	var judgeent = order.find(".judgeent");
	var score = order.find(".scorenum");
	var judgment = order.find(".judgment");
	$.ajax({
		type : "post",
		url : "OrderJudge",
		data : {
			shop : shop.val(),
			ordernum : ordernum.val(),
			score : score.val(),
			judgment : judgment.val()
		},
		success : function(data) {
			state.text("已完成");
			judgeent.css("color", "#0c0c0c");
			judgeent.text("已评价");
			judgeent.removeAttr("href");
			judgeent.removeAttr("onclick");
			showjudge(judgment);
		},
		error : function() {
			alert("与服务器连接失败！");
		}
	});
}
function cancel(dom) {
	var order = $(dom).parents(".order");
	var addition = "<textarea id='reason' style='display:block;resize:none;width: 400px;height: 40px;' onclick='this.select()'>忘记使用红包了。</textarea>";
	var back = '<a class="judgeent" href="javascript:void(0)" id="back">返回</a>';
	order.find(".shopline").append(addition);
	order.find(".orderline").append(back);
	var reason = order.find("#reason");
	var back = order.find("#back");
	var ordernum = order.find(".ordernum");
	$(dom).removeAttr("onclick");
	$(dom).text("提交申请");
	$(dom).click(function() {
		var sure = confirm("5分钟内可以直接取消订单！5分钟后需要商家同意，确认取消？");
		if (sure) {
			$.ajax({
				type : "post",
				url : "OrderCancel",
				data : {
					ordernum : ordernum.val(),
					reason : reason.val()
				},
				success : function(data) {
					var judgeent = order.find(".judgeent");
					var state = order.find(".state");
					order.find("#usermsg").val(reason.val());
					order.find("#usermsg").toggle();
					judgeent.removeAttr("href");
					judgeent.removeAttr("onclick");
					judgeent.css("color", "#0c0c0c");
					back.remove();
					reason.remove();
					if (data == "succeed") {
						state.text("订单已取消");
						judgeent.text("已取消");
					} else {
						state.text("商家处理中");
						judgeent.text("等待取消");
					}
				},
				error : function() {
					alert("与服务器连接失败！");
				}
			})
		}
	})
	back.click(function() {
		back.remove();
		reason.remove();
		$(dom).text("取消订单");
		$(dom).attr("onclick", "cancel(this)");
		$(dom).unbind("click");
		return false;
	})
}