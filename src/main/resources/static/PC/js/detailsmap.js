//baidumap ready
document.write("<script type='text/javascript' src='http://api.map.baidu.com/api?v=2.0&ak=vM0zMIg0ECGcuVm5BuXH2P8LGt6gAjFv'></script>");
//-----
var map="";
var point="";
var myGeo="";
var local="";
var mapBounds="";
var imgurl="";
var oldobj="";
var myIconde;
var urla="";
var urlo="";
var allpois
$(document).ready(function() {
	
});
function Lsearch (lsstr) {
	//console.log(map.getBounds())
	if(lsstr == 1) {
		key=["地铁站","公交站"]
		imgurl="url('img/bus.png') no-repeat";
		url="img/bus.png";
		urla="img/busactive.png";
		}
	if(lsstr == 2) {
		key=["小学","幼儿园","中学"]
		imgurl="url('img/school.png') no-repeat";
		url="img/school.png";
		urla="img/schoolactive.png";
		}
	if(lsstr == 3) {
		key=["医院","卫生所"]
		imgurl="url('img/hospital.png') no-repeat";
		url="img/hospital.png";
		urla="img/hospitalactive.png";
		}
	if(lsstr == 4) {
		key=["餐饮","咖啡厅","酒吧"]
		imgurl="url('img/cafe.png') no-repeat";
		url="img/cafe.png";
		urla="img/cafeactive.png";
		}
	if(lsstr == 5) {
		key=["银行","ATM"]
		imgurl="url('img/bank.png') no-repeat";
		url="img/bank.png";
		urla="img/bankactive.png";
		}
	if(lsstr == 6) {
		key=["购物","便利店"]
		imgurl="url('img/mall.png') no-repeat";
		url="img/mall.png";
		urla="img/mallactive.png";
		}
	if(lsstr == 7) {
		key=["加油站","高速路"]
		imgurl="url('img/danger.png') no-repeat";
		url="img/danger.png";
		urla="img/dangeractive.png";
		}
	oldobj = "";
	local.searchNearby(key,mapBounds,1000);
	myIconde = new BMap.Icon(url, new BMap.Size(50,57));
	}
function detailmap(addr,city) {
	map = new BMap.Map("dmap");
	point = new BMap.Point(116.331398,39.897445);
	map.centerAndZoom(point,16);   
	
	
	myGeo = new BMap.Geocoder();
	myGeo.getPoint(addr, function(point){
		//console.log(point)
		if (point) {
			//console.log(222)
			var myIcon = new BMap.Icon("img/home.png", new BMap.Size(50,57));
			map.centerAndZoom(point, 16);
			map.addOverlay(new BMap.Marker(point,{icon:myIcon}));
			//mapBounds = map.getBounds();
			map.panBy(-300,0)
			mapBounds = point;
			//----
			
			//console.log(map.getBounds())
			local = new BMap.LocalSearch(map, {
				renderOptions:{map: map,panel:"result-content",autoViewport:false},
				onSearchComplete:function(results){
					
					//console.log(local.getResults());
					},
				onResultsHtmlSet:function(container) {
					$("#result-content li>span").css("background",imgurl);
					$("#result-content li>span").css("width","50px")
					$("#result-content li>span").css("height","57px")
					$("#result-content div").css("border","0px #fff solid")
					//console.log(container);
					},
				onInfoHtmlSet:function(poi) {
					//console.log(poi);
					//map.closeInfoWindow();
					for(i=0;i<allpois.length;i++){
						allpois[i].marker.setIcon(new BMap.Icon(url, new BMap.Size(50,57)));
						allpois[i].marker.setOffset(new BMap.Size(0,-25));
						}
					if(oldobj != "") {
						oldobj.marker.setIcon(new BMap.Icon(url, new BMap.Size(50,57)));
						//console.log(url)
						}
					poi.marker.setIcon(new BMap.Icon(urla, new BMap.Size(50,57)));
					oldobj = poi;
					
					},
				onMarkersSet:function(pois) {
					//console.log(pois[1].marker.setIcon(icon:myIcon));
					//pois[1].marker.setIcon(myIcon)
					//console.log(myIconde)
					allpois = pois;
					for(i=0;i<pois.length;i++){
						pois[i].marker.setIcon(new BMap.Icon(url, new BMap.Size(50,57)));
						allpois[i].marker.setOffset(new BMap.Size(0,-25));
						}
						//console.log(url);
					}
			});
			
			//var pStart = new BMap.Point(116.274625,39.961627);
			//var pEnd = new BMap.Point(116.367474,39.988609);
			//var bs = new BMap.Bounds(pStart,pEnd);   //自己规定范围
			//local.searchInBounds("学校",mapBounds);
			
			/*var options = {
				onSearchComplete: function(results){
					// 判断状态是否正确
					if (local.getStatus() == BMAP_STATUS_SUCCESS){
						var s = [];
						for (var i = 0; i < results.getCurrentNumPois(); i ++){
							s.push(results.getPoi(i).title + ", " + results.getPoi(i).address);
						}
						document.getElementById("r-result").innerHTML = s.join("<br/>");
					}
				}
			};
			var local = new BMap.LocalSearch(map, options);*/
			
			Lsearch(1);
			
		}else{
			layer.msg("您选择地址没有解析到结果!");
		}
	}, city);
	
	//console.log(map.getBounds())
	}