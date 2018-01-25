//辅助方法
//----------------------------------------------------------
var DOMAIN = "http://www.darunjia.cn";//IP
//var DOMAIN = "http://120.76.53.1:9102";//IP
var navmenubase = null;//navmenubasekey
var datajsonStr ="";//public jsonstr
var searchJson; //
var orderbystr = "";//searchorderby
var BU="";//base url
var page=1;//
var pageSize=20;//
var seachstr="";

//-----------------------------------------------------------
document.write("<script src='js/layer/layer.js' charset='utf-8'></script>");
document.write('<script src="js/jquery.o.js" charset="utf-8"></script>')
//搜索无法加载的情况---------
function fillnullcontent () {
	$("#ProductList").empty();
	$("#ProductList").html("&#x60A8;&#x8F93;&#x5165;&#x7684;&#x5173;&#x952E;&#x8BCD;&#x6211;&#x4EEC;&#x627E;&#x4E0D;&#x5230;&#xFF01;&#x8981;&#x4E0D;&#x60A8;&#x6362;&#x4E2A;&#x8BCD;&#x8BD5;&#x8BD5;&#xFF01;&#x6682;&#x65F6;&#x4E0D;&#x652F;&#x6301;&#x591A;&#x8BCD;&#x7EC4;&#x5408;&#xFF0C;&#x60A8;&#x53EF;&#x4EE5;&#x76F4;&#x63A5;&#x8F93;&#x54C1;&#x724C;!");
	}
function fillnullcontentforproduct () {
	$("#ProductList").empty();
	$("#ProductList").html("&#x54CE;&#x5466;&#xFF0C;&#x6211;&#x4EEC;&#x5C45;&#x7136;&#x6CA1;&#x6293;&#x5230;&#x8FD9;&#x4E2A;&#x724C;&#x5B50;&#x7684;&#x6570;&#x636E;&#xFF0C;&#x8981;&#x4E0D;&#x5C31;&#x662F;&#x7F51;&#x7EDC;&#x6709;&#x70B9;&#x95EE;&#x9898;&#xFF0C;&#x53EF;&#x4EE5;&#x518D;&#x8BD5;&#x8BD5;");
	}
function fillnullcontentforfavo () {
	$(".follow").empty();
	$(".follow").html("&#x6CA1;&#x6709;&#x627E;&#x5230;&#x60A8;&#x7684;&#x5173;&#x6CE8;&#x4EA7;&#x54C1;&#xFF0C;&#x60A8;&#x53EF;&#x4EE5;&#x5728;&#x4EA7;&#x54C1;&#x4E2D;&#x70B9;&#x51FB;&#x5173;&#x6CE8;");
	}
function fillnullcontentforbrand () {
	$("#Listbrand").empty();
	$("#Listbrand").html("&#x54CE;&#x5466;&#xFF0C;&#x6682;&#x65F6; &#x6CA1;&#x6709;&#x6570;&#x636E;&#xFF0C;&#x6211;&#x4EEC;&#x6B63;&#x5728;&#x52AA;&#x529B;&#x6293;&#x53D6;");
	}



//辅助方法---------
function GetTimeText(newtime){   var d, s;                  // 声明变量。
	d = new Date();            // 创建 Date 对象。
	cc = (d.getTime() - newtime);
	if (cc >= 1000*60*60*24*30) {
		return ("1&#x4E2A;&#x6708;&#x524D;");
		}
	if (cc >= 1000*60*60*24*15) {
		return ("&#x534A;&#x4E2A;&#x6708;&#x524D;");
		}
	if (cc >= 1000*60*60*24*7) {
		return ("1&#x5468;&#x524D;");
		}
	if (cc >= 1000*60*60*24*4) {
		return ("&#x51E0;&#x5929;&#x524D;");
		}
	if (cc >= 1000*60*60*24*3) {
		return ("3&#x5929;&#x524D;");
		}
	if (cc >= 1000*60*60*24*2) {
		return ("2&#x5929;&#x524D;");
		}
	if (cc >= 1000*60*60*24) {
		return ("1&#x5929;&#x524D;");
		}
	if (cc >= 1000*60*60*12) {
		return ("&#x534A;&#x5929;&#x524D;");
		}
	if (cc >= 1000*60*60*6) {
		return ("&#x51E0;&#x4E2A;&#x5C0F;&#x65F6;&#x524D;");
		}
	if (cc >= 1000*60*60) {
		return ("1&#x4E2A;&#x5C0F;&#x65F6;&#x524D;");
		}
	if (cc >= 1000*60*30) {
		return ("30&#x5206;&#x949F;&#x524D;");
		}
	if (cc >= 1000*60*20) {
		return ("20&#x5206;&#x949F;&#x524D;");
		}
	if (cc >= 1000*60*10) {
		return ("10&#x5206;&#x949F;&#x524D;");
		}
	if (cc < 1000*60*10) {
		return ("&#x521A;&#x521A;")//刚刚
		}
	//d.setTime(newtime);        // 设置时间。   s = "Current setting is ";
	//s = d.getFullYear() + "-";
	//s = (d.getMonth() + 1) + "-";
	//s += d.getDate();
	//return(s);                 // 返回新的设置。}
	}
function GetTimestr(newtime){   var d, s;                  // 声明变量。
	d = new Date();            // 创建 Date 对象。
	
	return d.getFullYear() + "." + d.getMonth() + "." + d.getDate();
	
	}		
function GetallTimestr(newtime){   var d, s;                  // 声明变量。
	d = new Date();            // 创建 Date 对象。
	
	return  "<h2 class='text-center'>" + d.getFullYear() + "." + d.getMonth() + "." + d.getDate()+ " " + d.getHours()+ ":" + d.getMinutes() + "</h2>";
	
	}	
function GetallTimestrxs(newtime){   var d, s;                  // 声明变量。
	d = new Date();            // 创建 Date 对象。
	d.setTime(newtime)
	return  d.getMonth() + "." + d.getDate()+ " " + d.getHours()+ ":" + d.getMinutes();
	
	}	
function GetTotalprice(num) {
	if((num.toString().length) > 10){
		return (num/10000000000).toFixed(0) + "&#x4EBF;";
		}
	return (num/1000000).toFixed(0) + "&#x4E07;";
	}

function GetUnitprice(num) {
	return (num/100).toFixed(0) + "&#x5143;/&#x5E73;";
	}
function Getprice(num) {
	return (num/100).toFixed(0);
	}
function GetArea(num) {
	return num + "m<sup>2</sup>";
	}

function GetLabel(str) {
	if(str == null || str == undefined) {return "";}
	var mtext="";
	var mstr = str.split(",");
	for (m in mstr){
		mtext += "<span class='label label-default b"+(m*1+1)+"'>"+mstr[m]+"</span>";
		}
	return mtext;
	}
function Getcommlist(json) {
	var commstr="";
	for (v=0;v<json.length;v++){
		commstr += '<li class="col-xs-6"><i>'+json[v].kay+'</i>'+json[v].val+'</li>'
		
		}
	return commstr;
	}
//----------------
function Bulidparamtable (json) {
	//console.log(TDstr);
	var TDstr="<thead><tr><th>功能区</th><th>面积m<sup>2</sup></th></tr></thead><tbody>";
	for (v in json) {
		//console.log(TDstr);
		TDstr += "<tr><td>"+json[v].paramname+"</td><td>"+json[v].paramval+"</td></tr>";
		}
		TDstr += "</tbody>";
		//console.log(TDstr);
		
	$("#collapse1 .table").html(TDstr);
	}
	
function BulidhouseQttable (json) {
	for(i=0;i<json.length;i++){
		TDstr = "";
	
		if(json[i].key == 1){
			
			qtjson=json[i].children;
			for (v in qtjson) {
					TDstr +="<table class='table'><thead><tr><th>"+qtjson[v].val+"</th><th></th></tr></thead><tbody>";
				for (m in qtjson[v].children) {
					TDstr += "<tr><td>"+qtjson[v].children[m].sclazzname+"</td><td>"+QTdisplay(qtjson[v].children[m].result,qtjson[v].children[m].igroupoid)+"</td></tr>";
					}
				
				
				TDstr += "</tbody></table>";
				}
				
			$("#collapse2 .panel-body").html(TDstr);	
				
			}
		
		if(json[i].key == 2){
			
			qtjson=json[i].children;
			for (v in qtjson) {
					TDstr +="<table class='table'><thead><tr><th>"+qtjson[v].val+"</th><th></th></tr></thead><tbody>";
				for (m in qtjson[v].children) {
					TDstr += "<tr><td>"+qtjson[v].children[m].sclazzname+"</td><td>"+QTdisplay(qtjson[v].children[m].result,qtjson[v].children[m].igroupoid)+"</td></tr>";
					}
				
				
				TDstr += "</tbody></table>";
				}
				
				
			$("#collapse3 .panel-body").html(TDstr);
			
			}
		
		if(json[i].key == 3){
			
			qtjson=json[i].children;
			for (v in qtjson) {
					TDstr +="<table class='table'><thead><tr><th>"+qtjson[v].val+"</th><th></th></tr></thead><tbody>";
				for (m in qtjson[v].children) {
						if(qtjson[v].children[m].sclazzname == "品牌"){
							TDstr += "<tr><td>"+qtjson[v].children[m].sclazzname+"</td><td class='text-right' style='padding-right:20px;'>"+qtjson[v].children[m].rdesc+"</td></tr>";
						}else if(qtjson[v].children[m].sclazzname == "数量"){
							TDstr += "<tr><td>"+qtjson[v].children[m].sclazzname+"</td><td class='text-right' style='padding-right:20px;'>"+qtjson[v].children[m].result+"</td></tr>";
						}else{
							TDstr += "<tr><td>"+qtjson[v].children[m].sclazzname+"</td><td>"+QTdisplay(qtjson[v].children[m].result,qtjson[v].children[m].igroupoid)+"</td></tr>";
						}
					}
				
				
				TDstr += "</tbody></table>";
				}	
			$("#collapse4 .panel-body").html(TDstr);
			
			}
		}
	
	
	
	}
function QTdisplay (key,num) {
	//console.log(key);
	if(key == 1){
		return "<i class='fa fa-check-square-o pull-right' style='color:#01Ac09;'></i>";
		}else{
		return "<i class='fa fa-exclamation-circle pull-right' style='color:#E50026;' onclick='openimageList(\""+num+"\")'></i>"
		}
	}
function openimageList (num) {
	var url=DOMAIN + "/public/queryImageByGroupId";
		var data= {
			"groupId":num
			};//"orderby":"recomindex"
			
		
		var success = function(data, textStatus, jqXHR){
			if (data.data != null) {
					//console.log(data);
					Fillimges(data);
				}else {
					//
				}
			
		};
		$.post(url,data,success,"json");
	}
function Fillimges(data) {
		jsonData = data.data;
		var imgstr = "";
        for (v in jsonData){
			//console.log(v);	
            imgstr += '<div class="item '+((v == 0)?'active':'')+'"><img alt="'+jsonData[v].iname+'" class="img-responsive" src="'+jsonData[v].ipath+'"></div>'
        }
		$("#layer-photos-demo .carousel-inner").html(imgstr);
		$("#layer-photos-demo").attr("class","");
		//console.log(imgstr);
			w=$(window).width;
		layer.open({
			type: 1,
			title: false,
			closeBtn: 0,
			area: w,
			shade:0.8,
			shadeClose: true,
			content: $('#layer-photos'),
			end:function() {
				$("#layer-photos-demo").attr("class","hidden");
				},
			success:function () {
				$(".layui-layer-content").css("height","100%");
				}
		});
	}
//---
function Bulidimages (json) {
	imgstr = "";
	imgstr += "<div class='item active' onclick='openimageList("+json.igroupoid+")'><img src='"+json.ipath+"' style='width:100%;' alt='First slide'></div>";
		
	$("#collapse5 .panel-body").html(imgstr);
	}
	
function BulidhouseLoan (json) {
	jsonData = json;		
            var row = {
				"monthpayment":Getprice(jsonData.houseLoan.monthpayment),
                "loan":GetTotalprice(jsonData.houseLoan.loan),
				"downpayment":GetTotalprice(jsonData.houseLoan.downpayment),
				"browse":jsonData.houseHot.browse,
				"follow":jsonData.houseHot.follow,
				"seen":jsonData.houseHot.seen
            }
			
            var text=$("#houseLoanItem").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $("#collapse9 .panel-body").append(rs);
	}

function Bulidtitle (str) {
	$(".navbar .col-xs-11 h3").text(str);
	}
//------search str

function Gethouseselect() {
	var mtr='"hlayoutlist":[';
	var p = false;
	//console.log($(".house input"));
	for (v in $(".house input")) {
		//console.log($(".house input")[v]);
		if ($(".house input")[v].checked) {
			if(p) {mtr += ','}
			mtr += '"' + $(".house input")[v].value + '"';
			p = true;
			}
		}
		mtr += ']';
	return mtr;
	}

function Getmoreselect() {
	var morejsonstr = '';
	var p = false;
	var morestr = "";
	//console.log($(".more .btn-info").eq(0).data());
	morestr += '"orilist":['
	for(v in $(".more .btn-info")){
		if($(".more .btn-info").eq(v).attr("class") == "btn btn-info btn-xs col-xs-3" && $(".more .btn-info").eq(v).data("name") == "orie"){
			if(p) {morestr += ','}
			morestr +='"'+$(".more .btn-info").eq(v).data("value")+'"' ;
			p = true;
		}
	}
	morestr += ']';
	if(!p) {morestr = '';}
	morejsonstr += morestr;
	p = false;
	
	var mmax=0;
	var mmin=100000;
	for(v in $(".more .btn-info")){
		if($(".more .btn-info").eq(v).attr("class") == "btn btn-info btn-xs col-xs-3" && $(".more .btn-info").eq(v).data("name") == "area"){
			if($(".more .btn-info").eq(v).data("min")<= mmin) {mmin = $(".more .btn-info").eq(v).data("min")};
			if($(".more .btn-info").eq(v).data("max")>= mmax) {mmax = $(".more .btn-info").eq(v).data("max")};
			p = true;
		}
	}
	morestr = '"startarea":'+mmin+',"endarea":'+mmax+'';
	//console.log(p);
	if(!p) {morestr = '';}else{if (morejsonstr != ""){morejsonstr += ",";}}
	morejsonstr += morestr;
	p = false;
	
	morestr = '"hlabellist":['
	for(v in $(".more .btn-info")){
		if($(".more .btn-info").eq(v).attr("class") == "btn btn-info btn-xs col-xs-3" && $(".more .btn-info").eq(v).data("name") == "label"){
			if(p) {morestr += ','}
			morestr +='"'+$(".more .btn-info").eq(v).data("value")+'"' ;
			p = true;
		}
	}
	morestr += ']';
	if(!p) {morestr = '';}else{if (morejsonstr != ""){morejsonstr += ",";}}
	morejsonstr += morestr;
	p = false;
	
	morejsonstr += ''
	return morejsonstr;
	}
	
function nowdesc (num) {
	//console.log(datajsonStr);
	if(datajsonStr == ""){
		datajsonStr += '"desc":'+ num;
		}else{
			if(datajsonStr.indexOf("desc") != -1) {
					datajsonStr = datajsonStr.substring(0,datajsonStr.indexOf("desc")+6) + num + datajsonStr.substring(datajsonStr.indexOf("desc")+7);
				}else{
					datajsonStr += ',"desc":'+ num;	
				}
		
		}
	LoadSearchList();
	changebottombox();
	}
//---------------
function checkinmoreDO () {//注册more区域事件
	$(".more .btn-default").click(function () {
	//console.log(1)
		//console.log($(this).attr("class"));
		if($(this).attr("class") == "btn btn-default btn-xs col-xs-3") {
			for(v in $(".more .btn-info")){
					if($(".more .btn-info").eq(v).attr("class") == "btn btn-info btn-xs col-xs-3"){
						
						if($(".more .btn-info").eq(v).data("name") == $(this).data("name") && $(this).data("name") != "label"){
							$(".more .btn-info").eq(v).attr("class","btn btn-default btn-xs col-xs-3");
							}
					}
				}
			$(this).attr("class","btn btn-info btn-xs col-xs-3");
		}else{
			$(this).attr("class","btn btn-default btn-xs col-xs-3");
		}
		
	});
	
	$(".more .btn-primary").click(function () {
		floorOC(false)
		navmenubase.css("color","#000000");
		$(".more").css("display","none");
		navmenubase = null;
		datajsonStr = Getmoreselect();
		LoadSearchList();
	});
	}
//--------------
function clearlabel () {
	$(".more .btn-info").attr("class","btn btn-default btn-xs col-xs-3");
}
//--------------
function getUrlParam(name) {
		 var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
		 var r = window.location.search.substr(1).match(reg); //匹配目标参数
		 if (r != null) return unescape(r[2]); return null; //返回参数值
	}
function getPageCT() {
	if(getUrlParam("ct") != null) {return getUrlParam("ct")}else{return 0}//0售1租
	}
function getPageoid() {
	if(getUrlParam("oid") != null) {return getUrlParam("oid")}else{return 0}
	}
function getPageSS() {
	if(getUrlParam("ss") != null) {return getUrlParam("ss")}else{return ""}
	}
function getPageaoid() {
	if(getUrlParam("token") != null) {return getUrlParam("token")}else{return ""}
	}
function getPagecoid() {
	if(getUrlParam("coid") != null) {return getUrlParam("coid")}else{return ""}
	}
function geth1() {
	if(getUrlParam("h1") != null) {return getUrlParam("h1")}else{return ""}
	}
function geth2() {
	if(getUrlParam("h2") != null) {return getUrlParam("h2")}else{return ""}
	}
//---
function barpagechange (obj) {
	if(navmenubase == null) {
		floorOC(true)
		obj.css("color","#1697D3");
		$("."+obj.data('target')).css("display","block");
		navmenubase = obj;
		//console.log(obj)
		}else {
			
			if(navmenubase.data('target') == obj.data('target')) {
				//console.log(2)
				floorOC(false)
				navmenubase.css("color","#000000");
				$("."+navmenubase.data('target')).css("display","none");
				navmenubase = null;
				}else{
					//console.log(3)
				navmenubase.css("color","#000000");
				obj.css("color","#1697D3");	
				$("."+navmenubase.data('target')).css("display","none");
				$("."+obj.data('target')).css("display","block");
				navmenubase = obj;
				}	
		}
	
	}
	
function floorOC(key){
	if(key == true){
		$(".floor").fadeIn("fast");
		}else{
		$(".floor").fadeOut("fast");
		}
	}

function changebottombox () {
	if($(".sort").css("display") == "none") {
		$(".sort").css("display","block");
		}else{
		$(".sort").css("display","none");
		}
	}
//---------------------------------------------------
function gofollow (key,num){
	if($("#collapse7 button").attr("class") == "btn btn-primary btn-block") {
			delfollow(key,num);
		}else{
			addfollow(key,num);	
		}
	}
function addfollow (key,num) {
		if(num == null) {
			num = getPageCT()*1+1;
			}else{
			num = num;
			}
		if(uk()==""){
			layer.msg("请先登录再关注");
			return;
			}
		var url=DOMAIN + "/user/addAgentFollow";
		var data={
			"aoid":uk(),
			"data":'{"follow":"'+key+'","followtype":"'+num+'"}'
			}   //datatojson();//"orderby":"recomindex"
			
		//console.log(data)
		var success = function(data, textStatus, jqXHR){
			//console.log(data)
			if (data.retCode == 1) {
					$("#collapse7 button").attr("class","btn btn-primary btn-block");
					layer.msg("关注成功");
				}else {
					layer.msg("关注失败");
				}
			
		};
		$.post (url,data,success,"json");
	}
function delfollow (key,num) {
		//console.log(key);
		//console.log(num);
		if(num == null) {
			num = getPageCT()*1+1;
			}else{
			num = num;
			}
		if(uk()==""){
			layer.msg("请先登录再取消关注");
			return;
			}
		var url=DOMAIN + "/user/delAgentFollow";
		var data={
			"aoid":uk(),
			"data":'{"follow":"'+key+'","followtype":"'+num+'"}'
			}   //datatojson();//"orderby":"recomindex"
			
		//console.log(data)
		var success = function(data, textStatus, jqXHR){
			//console.log(data)
			if (data.retCode == 1) {
					$("#collapse7 button").attr("class","btn btn-default btn-block");
					layer.msg("取关成功");
					//location.reload();
				}else {
					layer.msg("取关失败");
				}
			
		};
		$.post (url,data,success,"json");
	}
//----us er
function signout () {
	bpai("zx","");
	usjsda= "";
	location.replace(clearsearchstr());
	//ustatus();
	}
function clearsearchstr () {//清空
	str = location.search.substring(1);
	str = str.split("&");
	var ds="";
	for(i=0;i<str.length;i++){
		if(str[i].indexOf("coid") == -1){
			ds += str[i];
			}
		}
	if(ds == ""){
			return location.pathname;
		}else{
			return location.pathname + "?" + ds;	
		}
	}
var usjsda = "";//用户数据
function ustatus () {
	//console.log(uk())
	if(bpao("zx") == "" && getPagecoid() == "") {
		//layer.msg("请重新登录");
		$(".checkin").eq(1).html('<i class="fa fa-user"></i><a class="ha" href="login.html">登录</a><i class="fa  fa-pencil-square-o"></i><a href="login-check.html">注册</a>');	
		return;
		}
	var url=DOMAIN + "/cust/oneCust";
	//console.log(uk());
	var data={
		"aoid":uk()
		};
	
	var success = function(data, textStatus, jqXHR){
		if (data.retCode == 1) {
				//console.log(data)
				//console.log(222)
				$(".checkin").eq(1).html('<i class="fa fa-user"></i><a class="ha" href="#" id="dropdownMenu2" data-toggle="dropdown">'+data.data.name+'</a><ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu2"><li><a href="mine-follow-house.html">我的关注</a></li><li><a href="mine-plan-visit.html">看房日程</a></li><li><a href="mine-depute-sale.html">委托房源</a></li><li><a href="mine-center-name.html">修改资料</a></li><li role="presentation" class="divider"></li><li><a href="#" onclick="signout()"><i class="fa fa-sign-out"></i>退出</a></li></ul>');
				usjsda=data;
				//console.log(usjsda)
				fillonsusertitle(data)
				
				//---重构链接
				$("a").click(function() {//改变
					if(getPagecoid() != "")	{
						if($(this).attr("href").indexOf("?") == -1){
								$(this).attr("href",$(this).attr("href")+"?coid="+ getPagecoid());
							}else{
								$(this).attr("href",$(this).attr("href")+"&coid="+ getPagecoid());
							}
						
						
						}			  
					});
			}else {
				layer.msg("登录状态有问题");
				$(".checkin").eq(1).html('<i class="fa fa-user"></i><a class="ha" href="login.html">登录</a><i class="fa  fa-pencil-square-o"></i><a href="login-check.html">注册</a>');	
			}
		
	};
	$.post(url,data,success,"json");
	}
var mine//个人中心指标
function fillonsusertitle (data) {
	//console.log(11);
	if(!mine){
		return;
		}
	//console.log(12);
	var oustr = "";
	if(data.data.phonenum == undefined){
			oustr = '<h1 class="mpclear col-md-12 col-sm-6 col-xs-6">'+data.data.name+'</h1><h5 class="col-md-12 col-sm-6 col-xs-6">手机未登记</h5>';
		}else{
			oustr = '<h1 class="mpclear col-md-12 col-sm-6 col-xs-6">'+data.data.name+'</h1><h5 class="col-md-12 col-sm-6 col-xs-6">'+data.data.phonenum+'</h5>';
		}
	$(".userhead").attr("src",data.data.ipath);
	$(".mine-title .col-md-4").html(oustr);
	
	}
function uk () {//判断账号
	if(bpao("zx") != "" || getPageaoid() != "") {
		
		if(bpao("zx") != ""){
			return bpao("zx");
			}else{
			return getPageaoid();	
			}
		}else{
			return "";
			}
	
	}
$(document).ready(function () {
	
	//ustatus();
	$(".navbox .col-xs-1").click(function (){
		showAndroidBack();			  
		});
	
	});
//------
function bpai(str1,str2){
	setCookie(str1,str2);//
	}
function bpao(str1){
	return getCookie(str1);
	}
//-----
function showAndroidToast(toast,ct) {
	
	Android.showHouseDetail(toast,ct);
}
function showAndroidBack() {
	
	Android.back();
}
function showAndroidMore() {
	
	Android.more();
}
function showAndroidCall(phonenumber) {
	
	Android.call(phonenumber);
}
function Androidtalktocust(id) {
	
	Android.talkToCust(id);
}
function showAndroidloadUserInfo() {
	
	Android.editUserInfo(JSON.stringify(DjsonData));
}
function showAndroidloadPage(url) {
	
	Android.loadPage(url);
}
function showAndroidfollow() {
	
	Android.follow();
}
//---
var attr;
function openmap() {
	
	layer.open({
		title:"区位配套",
		type: 2,
		content: 'nearmap.html',
		area:['100%','100%'],
		isOutAnim :false
	});
	}
//--
function loadUserInfo (id) {
	location.href="my_customerinfo.html?coid=" + id;
	}
//清理(Z)----------
function clearZ(key) {
	if(key.indexOf("(Z)") != -1) {
		return key.substring(0,key.indexOf("(Z)"))
		}
	return key;
	}
function clearEn(key) {
	if (key == null) {
		return "";
		}
	return "&nbsp;/&nbsp;"+key;
	}
function clearAlias(key) {
	if (key == null) {
		return "";
		}
	return "&nbsp;/&nbsp;"+key;
	}
	
//注册cookies----------
function cookiesin(b_pageid,b_keywords,b_categoryid,b_brandid,b_productid,b_pageno,b_pagesize,b_scrollheight) {
	if(b_pageid!=""){setCookie("c_pageid",b_pageid);};
	if(b_keywords!=""){setCookie("c_keywords",b_keywords);};
	if(b_categoryid!=""){setCookie("c_categoryid",b_categoryid);};
	if(b_brandid!=""){setCookie("c_brandid",b_brandid);};
	if(b_productid!=""){setCookie("c_productid",b_productid);};
	if(b_pageno!=""){setCookie("c_pageno",b_pageno);};
	if(b_pagesize!=""){setCookie("c_pagesize",b_pagesize);};
	if(b_scrollheight!=""){setCookie("c_scrollheight",b_scrollheight);};
	}
	
	

//高亮显示结果----------
function keywordreplace(str){
//var ym="尿裤";//ss是要高亮的区域，div的id值
//$("SearchList").html(ym.replace(/尿/g, "<span style='color:#f00;'>尿</span>"));
var key = $("#search").val().toUpperCase();
/*for (i=0;i<key.length;i++) {
	a = key.substr(i,1);
	if (a!=" " && a!="<" && a!=">"&& a!="="&& a!=":"&& a!=";"&& a!="\'"&& a!="\""){
	str = str.replace(a, "<span style='color:#f00;'>"+a+"</span>");
	}
	
}*/
	if (key!=" " && key!="<" && key!=">"&& key!="="&& key!=":"&& key!=";"&& key!="\'"&& key!="\""){
		str = str.replace(key, "<span style='color:#f00;'>"+key+"</span>");
	}
return str;
}



//json排序----------
function JsonSort(json,key){
    //console.log(json);
    for(var j=1,jl=json.length;j < jl;j++){
        var temp = json[j],
            val  = temp[key],
            i    = j-1;
        while(i >=0 && json[i][key]>val){
            json[i+1] = json[i];
            i = i-1;    
        }
        json[i+1] = temp;

    }
    //console.log(json);
    return json;
}
function JsonSortForUnit(json,key1,key2,key3){
    //console.log(json);
    for(var j=1,jl=json.length;j < jl;j++){
        var temp = json[j],
            val  = (temp[key1]+temp[key2])/temp[key3],
            i    = j-1;
        while(i >=0 && ((json[i][key1]+json[i][key2])/json[i][key3])>val){
            json[i+1] = json[i];
            i = i-1;    
        }
        json[i+1] = temp;

    }
    //console.log(json);
    return json;
}

//滚动条设置
function reScrollTop() {
	if (getCookie("d_page") == getCookie("c_pageid")) {
		$("#"+getCookie('c_pageid')+" .content").scrollTop(getCookie("c_scrollheight"));
		}
	}
