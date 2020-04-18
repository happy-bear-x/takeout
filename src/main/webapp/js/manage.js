$(document).ready(function() {
	add($("#menu1"));
	var a = $("#add a");
	var i = $("#add img")
	a.attr("href", "javascript:void(0)");
	a.on('mousedown', function() {
		i.animate({
			width : '25px',
			height : '25px',
			marginTop : "3px",
			marginRight : "3px",
		}, 0);
	})
	a.on('mouseup', function() {
		i.animate({
			width : '30px',
			height : '30px',
			marginTop : "0",
			marginRight : "0",
		}, 0);
	})
	i.attr({
		src : "img/shop/revise.jpg",
		alt : "修改",
		onclick : "imgclick(this);"
	});
})
function imgclick(dom) {
	var parent = $(dom).parents(".shop");
	var foodid = parent.find(".foodid").val();
	var shopname = parent.find(".shop-name").text();
	var des = parent.find(".des").text();
	var price = parent.find(".price").text();
	$(".shop").css({
		"display" : "none"
	});
	parent.css({
		"display" : "block"
	});
	$("#revise").css({
		"display" : "block"
	});
	$("input[name='foodid']").val(foodid);
	$("input[name='rename']").val(shopname);
	$("input[name='redes']").val(des);
	$("input[name='reprice']").val(price);
}
function cancel() {
	$(".shop").css({
		"display" : "block"
	});
	$("#revise").css({
		"display" : "none"
	});
}
function add(menu) {
	$(".menu").attr("disabled", false).css({
		"background" : "#ff8000",
		"box-shadow" : "2px 2px 3px #aaaaaa",
		"color" : "none",
		"pointer-events" : "auto"
	});
	$(menu).attr("disabled", true).css({
		"pointer-events" : "none",
		"background" : "#c9c9c9",
		"color" : "#fff",
		"box-shadow" : "none"
	});
	$(".shop").css("display", "none");
	$("#newfood").css("display", "none");
	$("#revise").css("display", "none");
	$("#recategory").css("display", "none");
	if ($(menu).attr("id") == "menu1") {
		$(".shop").css("display", "block");
	} else if ($(menu).attr("id") == "menu2") {
		$("#newfood").css("display", "table");
	} else {
		$("#recategory").css("display", "table");
		alert("该功能暂未开放");
	}
}
