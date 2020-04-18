arr = [];
start = 0;
$(function() {
	order = $(".order");
	order.toggle();
	getorder();
	if (start == 0 && arr.length == 0) {
		$("<div class='load'>抱歉，您还没有订单。</div>").appendTo(".mid-main");
	}
});
function getorder() {
	$
			.ajax({
				type : "post",
				url : "ShopOrderGet",
				dataType:"json",
				data : {
					start : start
				},
				success : function(data) {
					arr = data;
					$("#loadlogo").remove();
					$(".mid-main").append(
							" <div class='load' id='loading'>加载中...</div>");
					setTimeout(
							function() {
								$("#loading").remove();
								addorder();
								console.log(arr);
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
	console.log(arr.length);
	for (var i = 0; i < arr.length; i++) {
		neworder = order.clone(true);
		if (arr[i].shoppic != null) {
			neworder.find(".shoppic").attr("src", arr[i].shoppic);
		}
		neworder.find(".shopname").text(arr[i].shopname);
		neworder.find(".shopid").val(arr[i].shop);
		var uaddition = arr[i].uaddition;
		var saddition = arr[i].saddition;
		if (uaddition == null || uaddition == "") {
			uaddition = "无";
		}
		if (saddition == null || saddition == "") {
			saddition = "无";
		}
		neworder.find("#usermsg").text("取消原因：" + uaddition);
		neworder.find("#shopmsg").text("商家回应：" + saddition);
		;
		var statecode = arr[i].state;
		var state = neworder.find(".state");
		var judgeent = neworder.find(".judgeent")
		if (statecode == 0) {
			state.text("商家接单中");
			judgeent.text("确认接单");
			judgeent.attr("onclick", "confRec(this)");
		} else if (statecode == 1) {
			state.text("订单配送中");
			judgeent.text("配送中");
			judgeent.css("color", "#0c0c0c");
			judgeent.removeAttr("href");
		} else if (statecode == 2) {
			state.text("待用户评价");
			judgeent.text("等待用户评价")
			judgeent.removeAttr("href");
			judgeent.css("color", "#0c0c0c");
		} else if (statecode == 3) {
			state.text("订单已完成");
			judgeent.css("color", "#0c0c0c");
			judgeent.text("已评价");
			judgeent.removeAttr("href");
		} else if (statecode == -1) {
			state.text("商家处理中");
			judgeent.text("同意取消");
			neworder.find("#usermsg").css("display", "block");
			judgeent.attr("onclick","cancel(this)");
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

function confRec(dom){
	var order = $(dom).parents(".order");
	var ordernum = order.find(".ordernum");
	var shop = order.find(".shopid");
	var state = order.find(".state");
	var judgeent = order.find(".judgeent");
	$.ajax({
		type : "post",
		url : "ShopConfOrder",
		data : {
			ordernum : ordernum.val()
		},
		success : function(data) {
			if(data=="succeed"){
				state.text("订单配送中");
				judgeent.text("取消订单");
				judgeent.attr("onclick","cancel(this)");
			}else{
				alert("因服务器原因接单失败。")
			}
		}
	})
}
function cancel(dom){
	var order = $(dom).parents(".order");
	var ordernum = order.find(".ordernum");
	var shop = order.find(".shopid");
	var state = order.find(".state");
	var judgeent = order.find(".judgeent");
	$.ajax({
		type : "post",
		url : "ShopCalOrder",
		data : {
			ordernum : ordernum.val()
		},
		success : function(data) {
			if(data=="succeed"){
				state.text("订单已取消");
				judgeent.text("已取消");
				judgeent.removeAttr("onclick");
			}else{
				alert("因服务器原因接单失败。")
			}
		}
	})
}