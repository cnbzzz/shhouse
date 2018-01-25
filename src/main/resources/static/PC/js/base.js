// JavaScript Document

//推荐
function LoadTJcontent() {
	
		
		var url=DOMAIN + "/house/list";
		var data={
			orderby:"recomindex"
			};
		
		var success = function(data, textStatus, jqXHR){
			//console.log(data);	
			if (data.data != null) {
					FillTJitem(data);
				}else {
					//
				}
			
		};
		$.post(url,data,success,"json");
		
		
	}
	
function FillTJitem(data) {//推荐填充
		
		jsonData = data.data;
        for (v=0;v<jsonData.length && v<4;v++){
			//console.log(data);		
            var row = {
                "iPath":jsonData[v].ipath,
                "hname":jsonData[v].hname,
				"area":GetArea(jsonData[v].area),
				"orieName":jsonData[v].orieName,
				"layoutName":jsonData[v].layoutName,
				"cname":jsonData[v].cname,
				"hlabelNames":GetLabel(jsonData[v].hlabelNames),
				"totalprice":GetTotalprice(jsonData[v].totalprice),
				"icount":jsonData[v].icount,
				"oid":jsonData[v].oid,
				"unitprice":GetUnitprice(jsonData[v].unitprice)
            }
			
            var text=$("#TJitem").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $("#TJList").append(rs);
			rebulidingA ();
        }
		//page
		
		//var pagetext = "&#x6CA1;&#x6709;&#x66F4;&#x591A;";//没有更多
		
       // $("#pagearea").html(pagetext);
		
		//reScrollTop();
		//LoadBDcontent();
	}
//基础
function LoadBDcontent() {
	
		
		var url=DOMAIN + "/house/list";
		var data={
			
			};
		
		var success = function(data, textStatus, jqXHR){
			if (data.data != null) {
					FillBDitem(data);
				}else {
					//
				}
			
		};
		$.post(url,data,success,"json");
		
		
	}
	
function FillBDitem(data) {//基础推荐填充
		
		jsonData = data.data;
        for (v in jsonData){
			//console.log(data);		
            var row = {
                "iPath":jsonData[v].ipath,
                "hname":jsonData[v].hname,
				"area":GetArea(jsonData[v].area),
				"orieName":jsonData[v].orieName,
				"layoutName":jsonData[v].layoutName,
				"cname":jsonData[v].cname,
				"hlabelNames":GetLabel(jsonData[v].hlabelNames),
				"totalprice":GetTotalprice(jsonData[v].totalprice),
				"icount":jsonData[v].icount,
				"unitprice":GetUnitprice(jsonData[v].unitprice),
				"decoName":jsonData[v].decoName,
				"btypename":jsonData[v].btypename,
				"floor":jsonData[v].floor,
				"year":jsonData[v].year,
				"lutypename":jsonData[v].lutypename,
				"anames":jsonData[v].anames,
				"cdate":GetTimeText(jsonData[v].cdate)
            }
			
            var text=$("#BDitem").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $(".search-list").append(rs);
			rebulidingA ();
        }
		
	}
	
	
//--------serach
function LoadSearchList(key) {
		
		var url=DOMAIN + "/house/list";
		var data=datatojson()   //datatojson();//"orderby":"recomindex"
			
		//console.log(data)
		var success = function(data, textStatus, jqXHR){
			//console.log(data);
			if (data.retCode == 1) {
				
					if(key == null){
							//console.log(key == null)
							$(".search-list").html("");
						}
					if(data.data.length > 0){
							FillSCitem(data);
							$(".alert-info").html("加载更多<i class='fa  fa-plus'></i>");
						}else{
							$(".alert-info").text("已经没有了");
						}
					
				}else {
					layer.msg("房源查询出错啦");
				}
			
		};
		$.post (url,data,success,"json");
		
		
	}
	
function FillSCitem(data) {//搜索填充
		
		//console.log(data);
		jsonData = data.data;
        for (v in jsonData){
			//console.log(data);		
            var row = {
                "iPath":jsonData[v].ipath,
                "hname":jsonData[v].hname,
				"area":GetArea(jsonData[v].area),
				"orieName":jsonData[v].orieName,
				"layoutName":jsonData[v].layoutName,
				"cname":jsonData[v].cname,
				"hlabelNames":GetLabel(jsonData[v].hlabelNames),
				"totalprice":GetTotalprice(jsonData[v].totalprice),
				"icount":jsonData[v].icount,
				"unitprice":GetUnitprice(jsonData[v].unitprice),
				"decoName":jsonData[v].decoName,
				"btypename":jsonData[v].btypename,
				"floor":jsonData[v].floor,
				"year":jsonData[v].year,
				"lutypename":jsonData[v].lutypename,
				"anames":jsonData[v].anames,
				"oid":jsonData[v].oid,
				"housefollow":jsonData[v].housefollow,
				"houseseen":jsonData[v].houseseen,
				"cdate":GetTimeText(jsonData[v].cdate)
            }
			
            var text=$("#SCitem").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $(".search-list").append(rs);
			rebulidingA ();
        }
		
	}
//--
function datatojson () {//搜索条件建立
	var jsontext="";
	if (datajsonStr == ""){
			jsontext= 'data={"rent":'+getRentstr()+',"seachstr":"'+getPageSS()+'","orderBy":"'+orderbystr+'","pageNum":'+page+',"pageSize":'+pageSize+'}';
		}else{
			jsontext= 'data={'+datajsonStr+',"rent":'+getRentstr()+',"seachstr":"'+getPageSS()+'","orderBy":"'+orderbystr+'","pageNum":'+page+',"pageSize":'+pageSize+'}';
		}
	//console.log(jsontext);
	//jsontext='data={"hlayoutlist":["1"],"rent":0,"seachstr":"","orderBy":"totalprice","pageNum":1,"pageSize":20}';
	return jsontext;
	}
var rentstr=null;
function getRentstr () {//select downmenu
	if(rentstr == null){
		return getPageCT();
		}else{
		return rentstr;	
		}
	}
//--
function LoadSearchCondition () {//搜索项
	
		var url=DOMAIN + "/house/list/queryItem";
		var data= {};//"orderby":"recomindex"
			
		
		var success = function(data, textStatus, jqXHR){
			if (data.data != null) {
					searchJson = data;
					FillSCondition(data);
					FillPCSCondition(data);
				}else {
					//
				}
			
		};
		$.post(url,data,success,"json");
	
	}

function FillSCondition (data) {
		//console.log(data);
		Fillorie ();
		Fillarea();
		Filllabel();
		$(".abmore").html(moreprintstr);
		Fillqybox1 ();
		checkinmoreDO();
	}
function FillPCSCondition (data) {
		//console.log(data);
		FillPCorie ();
		FillPCarea();
		FillPClabel();
		FillPCqybox2 ();
	}	
//朝向	

var moreprintstr="";
function Fillorie () {
	var str = "<li>&#x671D;&#x5411;</li>";
	var i=0;
	
	jsonData = searchJson.data.orie;
	if(jsonData.length == 0) return;
	
		for (v in jsonData){
			if (i == 0 ){str += '<li>';}
			if(i<2){
					str += '<button type="button" class="btn btn-default btn-xs col-xs-3" data-name="orie" data-value="'+jsonData[v].dictid+'">'+jsonData[v].dictname+'</button>';
					i++;
				}else{
					str += '<button type="button" class="btn btn-default btn-xs col-xs-3" data-name="orie" data-value="'+jsonData[v].dictid+'">'+jsonData[v].dictname+'</button>';
					str += '</li>';
					i=0;	
				}
			}
		if(i > 0){str += '</li>';}
		
		//console.log(str);
		//
		moreprintstr += str;
		//--绑定的之前在首页
	}
function FillPCorie () {
	var str = "";
	
	jsonData = searchJson.data.orie;
	if(jsonData.length == 0) return;
	
		for (v in jsonData){
			str += '<li class="checkbox"><label><input type="checkbox" onclick="sl();" name="orie" data-value="'+jsonData[v].dictid+'">'+jsonData[v].dictname+'</label></li>';
			}
		
		//console.log(str);
		//
		$("#orie").html(str);
		//--绑定的之前在首页
	}
//面积
function Fillarea () {
	var str = "<li>面积</li>";
	str += "<li>";
		str += "<button type='button' class='btn btn-default btn-xs col-xs-3' data-name='area' data-min='0' data-max='50'>50m<sup>2</sup></button>";
		str += "<button type='button' class='btn btn-default btn-xs col-xs-3' data-name='area' data-min='50' data-max='70'>50-70m<sup>2</sup></button>";
		str += "<button type='button' class='btn btn-default btn-xs col-xs-3' data-name='area' data-min='70' data-max='90'>70-90m<sup>2</sup></button>";
	str += "</li>";
	str += "<li>";
		str += "<button type='button' class='btn btn-default btn-xs col-xs-3' data-name='area' data-min='90' data-max='110'>90-110m<sup>2</sup></button>";
		str += "<button type='button' class='btn btn-default btn-xs col-xs-3' data-name='area' data-min='110' data-max='130'>110-130m<sup>2</sup></button>";
		str += "<button type='button' class='btn btn-default btn-xs col-xs-3' data-name='area' data-min='130' data-max='150'>130-150m<sup>2</sup></button>";
	str += "</li>";
	str += "<li>";
		str += "<button type='button' class='btn btn-default btn-xs col-xs-3' data-name='area' data-min='150' data-max='200'>150-200m<sup>2</sup></button>";
		str += "<button type='button' class='btn btn-default btn-xs col-xs-3' data-name='area' data-min='200' data-max='100000'>200m<sup>2</sup>以上</button>";
	str += "</li>";
        moreprintstr += str;                
	}
function FillPCarea () {
	
	}
//标签
function Filllabel () {
	var str = "<li>&#x6807;&#x7B7E;</li>";
	var i=0;
	
	jsonData = searchJson.data.label;
	if(jsonData.length == 0) return;
	
		for (v in jsonData){
			if (i == 0 ){str += '<li>';}
			if(i<2){
					str += '<button type="button" class="btn btn-default btn-xs col-xs-3" data-name="label" data-value="'+jsonData[v].dictid+'">'+jsonData[v].dictname+'</button>';
					i++;
				}else{
					str += '<button type="button" class="btn btn-default btn-xs col-xs-3" data-name="label" data-value="'+jsonData[v].dictid+'">'+jsonData[v].dictname+'</button>';
					str += '</li>';
					i=0;	
				}
			}
		if(i > 0){str += '</li>';}
		
		//console.log(str);
		moreprintstr += str;
	}
function FillPClabel () {
	var str = "";
	
	jsonData = searchJson.data.label;
	if(jsonData.length == 0) return;
	
		for (v in jsonData){
			str += '<li class="checkbox"><label><input onclick="sl()" type="checkbox" data-value="'+jsonData[v].dictid+'">'+jsonData[v].dictname+'</label></li>';
			}
		//console.log(str);
		//
		$("#label").html(str);
	/*$("#label input").click(function () {
		for(v=0;v< $("#label input").length;v++){
			console.log(1111);
			$("#label input")[v].checked = false;
			}
		console.log($(this))
		$(this)[0].checked = true;
	});*/
	
	}
//app区域
function Fillqybox1 () {
	str = "<li onclick='Fillqybox2(1)'>区域</li><li onclick='Fillqybox2(2)'>地铁</li>";
	$(".qybox2 ul").html("");
	$(".qybox3 ul").html("");
	$(".qybox1 ul").html(str);
	}
var qyjsondata;
var qyname;
function Fillqybox2 (str) {
	

	var mstr="";
	if(str == 1) {qyjsondata = searchJson.data.county;qyname="county";}
	if(str == 2) {qyjsondata = searchJson.data.metro;qyname="metro";}
	//console.log(qyjsondata);
	for (v in qyjsondata) {
		mstr += "<li onclick='Fillqybox3("+qyjsondata[v].dictid+")'>"+qyjsondata[v].dictname+"</li>";
		}
	$(".qybox2 ul").html("");
	$(".qybox3 ul").html("");
	$(".qybox2 ul").html(mstr);
	}
function Fillqybox3 (id){
	//console.log(id);
	var mstr="";
	for(v in qyjsondata){
		if (qyjsondata[v].dictid == id) {
			for (m in qyjsondata[v].children) {
				mstr += "<li onclick='Loadqysearch("+qyjsondata[v].children[m].dictid+")'>"+qyjsondata[v].children[m].dictname+"</li>";
				}
			}
		}
	$(".qybox3 ul").html("");
	$(".qybox3 ul").html(mstr);
	}
	
function Loadqysearch (id) {
	floorOC(false)
	navmenubase.css("color","#000000");
	$(".area").css("display","none");
	navmenubase = null;
	datajsonStr = '"'+qyname+'":'+id+'';//表达式
	page = 1;
	LoadSearchList();
	}
	
//pc区域
function FillPCqybox1 () {//pc端菜单
	//str = "<li onclick='Fillqybox2(1)'>区域</li><li onclick='Fillqybox2(2)'>地铁</li>";
	//$(".qybox2 ul").html("");
	//$(".qybox3 ul").html("");
	//$(".qybox1 ul").html(str);
	$("#quitem").html("");
	}
var qyPCjsondata;
var qyPCname = "";
var qyPCid = "";
function FillPCqybox2 (str) {
	var mstr="";
	
	qyPCjsondata = searchJson.data.county;
	qyPCname="county";
	for (v in qyPCjsondata) {
		mstr += "<a href='#'  onclick='FillPCqybox3("+qyPCjsondata[v].dictid+",\""+qyPCname+"\")' data-toggle='tab'>"+qyPCjsondata[v].dictname+"</a>";
		}
	$("#county").html(mstr);
	
	mstr="";
	
	qyPCjsondata = searchJson.data.metro;
	qyPCname="metro";
	for (v in qyPCjsondata) {
		mstr += "<a href='#'  onclick='FillPCqybox3("+qyPCjsondata[v].dictid+",\""+qyPCname+"\")' data-toggle='tab'>"+qyPCjsondata[v].dictname+"</a>";
		}
	$("#metro").html(mstr);
	$("#quitem").html("");
	qyPCname= "";
	//console.log(qyPCjsondata);
	
	}
function FillPCqybox3 (id,pstr){
	//console.log(pstr);
	qyPCname = pstr;
	var mstr="";
	if (pstr == "county") {
			qyPCjsondata = searchJson.data.county;
		}else{
			qyPCjsondata = searchJson.data.metro;
		}
	
	for(v in qyPCjsondata){
		if (qyPCjsondata[v].dictid == id) {
			for (m in qyPCjsondata[v].children) {
				mstr += "<a href='#' onclick='LoadqyPCsearch("+qyPCjsondata[v].children[m].dictid+")'>"+qyPCjsondata[v].children[m].dictname+"</a>";
				}
			}
		}
	$("#quitem").html(mstr);
	}
$(document).ready(function () {
	$("#myTab a").click(function() {
			$("#quitem").html("");
		});							
});
function LoadqyPCsearch (id) {
	qyPCid = id;
	//datajsonStr = '"'+qyPCname+'":'+id+'';//表达式
	page = 1;
	GetPCallselect();
	LoadSearchList();
	}
//---------------HouseDetails
function LoadHouseDetails () {
	
		var url=DOMAIN + "/house/queryHouseDetail";
		var data= {
			"oid":getPageoid(),
			"coid":uk()
			};//"orderby":"recomindex"
			
		
		var success = function(data, textStatus, jqXHR){
			if (data.data != null) {
					FillHDetails(data);
				}else {
					//
				}
			
		};
		$.post(url,data,success,"json");
	
	}

function FillHDetails (data) {
		console.log(data);
		jsonData = data.data;
		var row = {
			"hname":jsonData.hname,
			"totalprice":GetTotalprice(jsonData.totalprice),//
			"layoutName":jsonData.layoutName,//
			"area":GetArea(jsonData.area),//
			"oid":jsonData.oid,//
			"hlabelNames":GetLabel(jsonData.hlabelNames),
			"unitprice":GetUnitprice(jsonData.unitprice),//
			"monthpayment":Getprice(jsonData.houseLoan.monthpayment),//
			"downpayment":GetTotalprice(jsonData.houseLoan.downpayment),//
			"floor":jsonData.floor,
			"decoName":jsonData.decoName,
			"year":jsonData.year,
			"cdate":GetTimeText(jsonData.cdate),
			"orieName":jsonData.orieName,
			"cname":jsonData.cname,//
			"btypename":jsonData.btypename,
			"browse":jsonData.houseHot.browse,//
			"follow":jsonData.houseHot.follow,//
			"seen":jsonData.houseHot.seen,//
			"imgList":GetimgList(jsonData.imageList),//
			"rent":jsonData.rent,//
			"anames":jsonData.anames,//serialnum
			"serialnum":jsonData.serialnum,
			"isFollowHouse":(jsonData.isFollowHouse == 1)?'<button type="button" class="btn btn-primary" onclick="gohousefollow(\''+jsonData.oid+'\','+(jsonData.rent*1 + 1)+')"><i class="fa  fa-heart-o"></i>已关注</button>':'<button type="button" class="btn btn-default" onclick="gohousefollow(\''+jsonData.oid+'\','+(jsonData.rent*1 + 1)+')"><i class="fa  fa-heart-o"></i>未关注</button>',
			"lutypename":jsonData.lutypename
			
		}
		
		var text=$("#detailsBody").text();
		var compiled = _.template(text);
		rs=compiled(row);
		
		$(".details-details").append(rs);
		
		rebulidTab();
		Bulidtitle(jsonData);//标题
		Bulidbd(jsonData);//房屋参数
		Fillvideo(jsonData.imageList);//Bulidvideo(jsonData.oid)
		Bulidparamtable(jsonData.paramList);//功能区面积
		Bulidhlipath(jsonData.hlipath);
		BulidhouseQttable(jsonData.houseQtList);//三项质检
		Bulidimages(jsonData.community);//公共空间图片
		Bulidcomm(jsonData);//小区
		Bulidcharts(jsonData.commPtrendList);//小区成交
		detailmap(jsonData.community.attr,jsonData.community.cname)//地图
		BulidhouseLoan(jsonData);//贷款
		Bulidagent();//经纪人
		rebulidingA ();
		
	}
function rebulidTab () {
	$("#myvideoTab a").click(function() {
		
		var videoClassName = $("#videoTogglePlay").get(0).className;
		//console.log(videoClassName.substr(videoClassName.length-1,1));
		if($(this).attr("href") != "#vr"){
			//$("#dvideo").get(0).pause();
				if(videoClassName.substr(videoClassName.length-1,1) == "y"){
					$("#videoTogglePlay").get(0).click();
				}
			}else{
			//$("#dvideo").get(0).play();
				if(videoClassName.substr(videoClassName.length-1,1) == "p"){
					$("#videoTogglePlay").get(0).click();
				}
			}
		
	})
	}
function Bulidtitle (data) {
	jsonData = data;		
            var row = {
				"hname":jsonData.hname,
				"isFollowHouse":(jsonData.isFollowHouse == 1)?'<button type="button" class="btn btn-primary" onclick="gohousefollow(\''+jsonData.oid+'\','+(jsonData.rent*1 + 1)+')"><i class="fa  fa-heart-o"></i>已关注</button>':'<button type="button" class="btn btn-default" onclick="gohousefollow(\''+jsonData.oid+'\','+(jsonData.rent*1 + 1)+')"><i class="fa  fa-heart-o"></i>未关注</button>'
				
				
            }
			
            var text=$("#Dname").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $(".details-name").append(rs);
	}
function Bulidbd (data) {
	jsonData = data;		
            var row = {
				"unitprice":GetUnitprice(jsonData.unitprice),
				"downpayment":GetTotalprice(jsonData.houseLoan.downpayment),
				"floor":jsonData.floor + "层/"+jsonData.totalfloor + "层",
				"decoName":jsonData.decoName,
				"year":jsonData.year,
				"cdate":GetTimestr(jsonData.cdate),
				"lutypename":jsonData.lutypename,
				"orieName":jsonData.orieName,
				"anames":jsonData.anames,
				"btypename":jsonData.btypename 
            }
			
            var text=$("#DbaseD").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $(".housebasedata").append(rs);
	}
function Bulidcomm(data) {//本地推荐填充
		jsonData = data;		
            var row = {
				"commPropList":Getcommlist(jsonData.commPropList),//
                "rentcount":jsonData.commSale.rentcount,
				"rentedcount":jsonData.commSale.rentedcount,
				"rentedprice":Getprice(jsonData.commSale.rentedprice),
				"salecount":jsonData.commSale.salecount,
				"saledcount":jsonData.commSale.saledcount,
				"saledprice":Getprice(jsonData.commSale.saledprice),
				"cname":jsonData.community.cname,
				"isFollowComm":(jsonData.isFollowComm == 1)?'<button type="button" class="btn btn-primary pull-right"  onclick="gocommfollow(\''+jsonData.community.oid+'\',3)"><i class="fa fa-heart-o"></i>已关注小区</button>':'<button type="button" class="btn btn-default pull-right"  onclick="gocommfollow(\''+jsonData.community.oid+'\',3)"><i class="fa fa-heart-o"></i>未关注小区</button>',
				"oid":jsonData.community.oid
            }
			
            var text=$("#Dxq").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $(".xq").append(rs);
	}
function Bulidcharts (data) {
	data = JsonSort(data,"ymonth")
	
	var monthdata=[];
	var rentcount=[];
	var rentprice=[];
	for (i=0;i<data.length;i++){
		monthdata.push(data[i].ymonth);
		rentcount.push(data[i].dealcount);
		rentprice.push(Getprice(data[i].price));
		}
	var maxrentcount = rentcount.concat();
	var maxrentprice = rentprice.concat();
	//console.log(rentcount);
	//console.log(rentprice);
	
	var myChart = echarts.init(document.getElementById('datachart'));

	var option = {
			title: {
				text: '小区房源'
			},
			tooltip: {},
			legend: {
				data: ['成交套数', '挂牌价格']
			},
			color:['#07b59a','#888888'],
			xAxis: {
				data: monthdata
			},
			yAxis: [{
				type: 'value',
				scale: true,
				name: '成交',
				max: maxrentcount.sort()[maxrentcount.length-1]*1+100,
				min: 0,
				boundaryGap: [0.2, 0.5]
			},{
				type: 'value',
				scale: true,
				name: '价格',
				splitLine:{
					show:false
					},
				max: maxrentprice.sort()[maxrentprice.length-1]*1+10000,
				min: 0,
				boundaryGap: [0.2, 0.5]
			}],
			series: [{
				name: '成交套数',
				type: 'bar',
				data: rentcount
			},{
				name: '挂牌价格',
				type: 'line',
				yAxisIndex: 1,
				data: rentprice
			}],
		};
	//console.log(maxrentcount.sort()[maxrentcount.length-1]*1+50);
	//console.log(maxrentprice.sort()[maxrentprice.length-1]*1+10000);
	myChart.setOption(option);
	}
function Bulidhlipath (url) {
	//console.log(url);
	$("#hlipath").attr("src",url);
	}

function Bulidagent() {//profit
		
		var url=DOMAIN + "/cust/listCustAgent";
		var data={
			"coid":uk()
			};
		
		var success = function(data, textStatus, jqXHR){
			
			if (data.data != null) {
					vpmsguser = data.data[0].shopname;
					Fillagent(data);
				}else {
					//
				}
			
		};
		$.post(url,data,success,"json");
		
		
	}
function Fillagent(data) {//profit填充
		//console.log(data);
		jsonData = data.data;
        for (v in jsonData){
			//console.log(data);		
            var row = {
                "iPath":jsonData[v].ipath != null?jsonData[v].ipath:"img/default.png",
                "shopname":jsonData[v].shopname,
                "oid":jsonData[v].oid,
				"scandate":GetTimestr(jsonData[v].scandate),
				"phonenum":jsonData[v].phonenum
				
            }
			
            var text=$("#agent").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $(".agent").append(rs);
			$(".agentlist").append(rs);
        }
		
	}
function Bulidvideo(id) {//profit
		
		var url=DOMAIN + "/public/queryVideosByGroupId";
		var data={
			"groupId":id
			};
		//console.log(id);
		var success = function(data, textStatus, jqXHR){
			//console.log(data)
			if (data.data != null) {
					Fillvideo(data);
					//$("#dvideo").attr("src","http://nexth.oss-cn-shenzhen.aliyuncs.com/201704/xjYQN6M88B.mp4")
				}else {
					$("#vr img").attr("src","img/roomdefault.jpg")
				}
			
		};
		$.post(url,data,success,"json");
		
		
	}
function Fillvideo(data) {//profit填充
		var jsonDatavd;
		for(v in data) {
			if(data[v].itype == 2){
				jsonDatavd = data[v].ipath;
			}
		}
		//console.log(jsonDatavd)
		if (jsonDatavd == null){$("#vr img").attr("src","img/novideo.jpg");return;}
		//http://shhouse.oss-cn-shanghai.aliyuncs.com/system/vrtest.mp4
		//http://nexth.oss-cn-shenzhen.aliyuncs.com/201704/xjYQN6M88B.mp4
		//http://120.76.53.1/video/xjYQN6M88B.mp4
        var params = {
			container:$("#vr").get(0), //播放器容器Dom对象
			name:"SceneViewer", //播放器名称
			dragDirectionMode:true,
			isGyro:true,
			fullScreenMode:false,//全屏模式 ===>如果是配置了该参数，将忽略width和height的配置，播放器将取当前窗口的尺寸作为播放器的初始尺寸
			scenesArr:[
				{
					sceneId:'housevideo', 
					sceneFilePath:jsonDatavd, 
					sceneType:"Video", 
					initPan:0, 
					initFov:100
				}
			],
			errorCallBack: function (e) {
            	console.log("错误状态：" + e);
			},
			//浏览器不支持全屏回调
			fsCallBack: function (status, playObj) {
				layer.msg("浏览器不支持全屏！");
			}
		};
		initLoad(params);
	}
//-----------??
function LoadBDList() {
		CT = getPageCT();
		
		var url=DOMAIN + BU;
		var data={
			"aoid":"TVE9PQ==",
			"custType":CT
			
			};
		
		var success = function(data, textStatus, jqXHR){
			if (data.data != null) {
					FillBDitem(data);
				}else {
					//
				}
			
		};
		$.get(url,data,success,"json");
		
		
	}
//------------
function LoadFDList() {//follow
		
		var url=DOMAIN + "/user/listAgentFollow";
		var data={
			"aoid":"TVE9PQ==",
			"followtype":getPageCT()
			
			};
		
		var success = function(data, textStatus, jqXHR){
			if (data.data != null) {
					FillBDitem(data);
				}else {
					//
				}
			
		};
		$.get(url,data,success,"json");
		
		
	}
//------------
function LoadHRList() {//house
		
		var url=DOMAIN + "/user/listAgentHouse";
		var data={
			"aoid":"TVE9PQ==",
			"rent":getPageCT()
			
			};
		
		var success = function(data, textStatus, jqXHR){
			if (data.data != null) {
					FillBDitem(data);
				}else {
					//
				}
			
		};
		$.get(url,data,success,"json");
		
		
	}
//---------
function LoadPFList() {//profit
		
		var url=DOMAIN + "/user/listAgentDeal";
		var data={
			"aoid":"TVE9PQ==",
			"rent":getPageCT()
			
			};
		
		var success = function(data, textStatus, jqXHR){
			if (data.data != null) {
					FillPFitem(data);
				}else {
					//
				}
			
		};
		$.get(url,data,success,"json");
		
		
	}
function FillPFitem(data) {//profit填充
		
		jsonData = data.data.houseList;
        for (v in jsonData){
			//console.log(data);		
            var row = {
                "iPath":jsonData[v].ipath,
                "hname":jsonData[v].hname,
				"area":GetArea(jsonData[v].area),
				"orieName":jsonData[v].orieName,
				"layoutName":jsonData[v].layoutName,
				"cname":jsonData[v].cname,
				"hlabelNames":GetLabel(jsonData[v].hlabelNames),
				"totalprice":GetTotalprice(jsonData[v].totalprice),
				"icount":jsonData[v].icount,
				"unitprice":GetUnitprice(jsonData[v].unitprice),
				"cdate":GetTimeText(jsonData[v].cdate)
				
            }
			
            var text=$("#BDitem").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
			$(".mine .acc").html(Getprice(data.data.accuprice));
			$(".mine .sur").html(Getprice(data.data.surprice));
            $("#BDTJList").append(rs);
			rebulidingA ();
        }
		
	}
//-------
function LoadBSList() {//see
		
		var url=DOMAIN + "/user/listAgentBrowse";
		var data={
			"aoid":"TVE9PQ==",
			"rent":getPageCT()
			
			};
		
		var success = function(data, textStatus, jqXHR){
			if (data.data != null) {
					FillBSitem(data);
				}else {
					//
				}
			
		};
		$.get(url,data,success,"json");
		
		
	}
function FillBSitem(data) {//see填充
		
		jsonData = data.data.houseCustList;
        for (v in jsonData){
			//console.log(data);		
            var row = {
                "iPath":jsonData[v].ipath,
                "hname":jsonData[v].hname,
				"area":GetArea(jsonData[v].area),
				"orieName":jsonData[v].orieName,
				"layoutName":jsonData[v].layoutName,
				"cname":jsonData[v].cname,
				"phonenum":jsonData[v].phonenum,
				"custname":jsonData[v].custname,
				"icount":jsonData[v].icount,
				"unitprice":GetUnitprice(jsonData[v].unitprice),
				"cdate":GetTimeText(jsonData[v].cdate)
				
            }
			
            var text=$("#BDitem").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
			$(".mine .all").html(data.data.alltimes);
			$(".mine .week").html(data.data.weektimes);
            $("#BDTJList").append(rs);
			rebulidingA ();
        }
		
	}	
//------
function LoadECOList() {//editcontrast
		
		var url=DOMAIN + "/house/houseCompare";
		var data={
			"oid":"1",
			"otherOid":"2"
			
			};
		
		var success = function(data, textStatus, jqXHR){
			if (data.data != null) {
					FillECOitem(data);
				}else {
					//
				}
			
		};
		$.get(url,data,success,"json");
		
		
	}
function FillECOitem(data) {//editcontrast填充
		jsonData1 = data.data.one;	
		jsonData2 = data.data.otherOne;	
		if(jsonData1 != null){
			var row = {
                "cipath":jsonData1.cipath,
                "hname":jsonData1.hname,
				"area":GetArea(jsonData1.area),
				"orieName":jsonData1.orieName,
				"floor":jsonData1.floor,
				"totalfloor":jsonData1.totalfloor,
				"layoutName":jsonData1.layoutName,
				"lutypename":jsonData1.lutypename,
				"year":jsonData1.year,
				"decoName":jsonData1.decoName,
				"btypename":jsonData1.btypename,
				"anames":jsonData1.anames,
				"cname":jsonData1.cname,
				"clabels":GetLabel(jsonData1.clabels),
				"totalprice":GetTotalprice(jsonData1.totalprice),
				"unitprice":GetUnitprice(jsonData1.unitprice)//--1
            }
			
            var text=$("#BD1item").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $("#BDTJList1").append(rs);
			rebulidingA ();
			}
		if(jsonData2 != null){
			var row = {
				"cipath":jsonData2.cipath,
                "hname":jsonData2.hname,
				"area":GetArea(jsonData2.area),
				"orieName":jsonData2.orieName,
				"floor":jsonData2.floor,
				"totalfloor":jsonData2.totalfloor,
				"layoutName":jsonData2.layoutName,
				"lutypename":jsonData2.lutypename,
				"year":jsonData2.year,
				"decoName":jsonData2.decoName,
				"btypename":jsonData2.btypename,
				"anames":jsonData2.anames,
				"cname":jsonData2.cname,
				"clabels":GetLabel(jsonData2.clabels),
				"totalprice":GetTotalprice(jsonData1.totalprice),
				"unitprice":GetUnitprice(jsonData2.unitprice)//--2
            }
			
            var text=$("#BD2item").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $("#BDTJList2").append(rs);
			rebulidingA ();
			}
            
		
		
	}
//-------
function LoadHSList() {//plan
		
		var url=DOMAIN + "/user/listAgentBooking";
		var data={
			"aoid":"TVE9PQ==",
			"rent":getPageCT()
			};
		
		var success = function(data, textStatus, jqXHR){
			if (data.data != null) {
					FillHSitem(data);
				}else {
					//
				}
			
		};
		$.get(url,data,success,"json");
		
		
	}

function FillHSitem(data) {//plan填充
		jsonData = data.data;
        for (v in jsonData){
			//console.log(data);		
            var row = {
                "cuoid":jsonData[v].cuoid,
                "hname":jsonData[v].hname,
				"area":GetArea(jsonData[v].area),
				"orieName":jsonData[v].orieName,
				"layoutName":jsonData[v].layoutName,
				"cname":jsonData[v].cname,
				"clabels":GetLabel(jsonData[v].clabels),
				"totalprice":GetTotalprice(jsonData[v].totalprice),
				"icount":jsonData[v].icount,
				"custname":jsonData[v].custname,
				"phonenum":jsonData[v].phonenum,
				"unitprice":GetUnitprice(jsonData[v].unitprice),
				"cdate":GetTimeText(jsonData[v].cdate)
            }
			
            var text=$("#BDitem").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $("#BDTJList").append(rs);
			rebulidingA ();
        }
        
		
	}
	
//------
function LoadCUList() {//customer
		
		var url=DOMAIN + "/user/listAgentCust";
		var data={
			"aoid":"TVE9PQ==",
			"custType":getPageCT()
			};
		
		var success = function(data, textStatus, jqXHR){
			if (data.data != null) {
					FillCUitem(data);
				}else {
					//
				}
			
		};
		$.get(url,data,success,"json");
		
		
	}

function FillCUitem(data) {//customer填充
		
		jsonData = data.data;
        for (v in jsonData){
			//console.log(data);		
            var row = {
                "iPath":jsonData[v].ipath,
                "name":jsonData[v].name,
				"phonenum":jsonData[v].phonenum,
				"clabels":GetLabel(jsonData[v].clabels)
				
            }
			
            var text=$("#BDitem").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $("#BDTJList").append(rs);
			rebulidingA ();
        }
		
	}
	
//-----------
function LoadHCList() {//contrast
		//console.log(geth1());
		//console.log(geth2());
		var a="";
		var b="";
		var url=DOMAIN + "/house/queryHouseDetail";
		var data1={
			"oid":geth1()
			};
		
		var success1 = function(data1, textStatus, jqXHR){
			if (data1.data != null && data1.retCode == 1) {
					console.log(data1);
					a = data1;
				}else {
					//
				}
			
		};
		$.post(url,data1,success1,"json");
		var data2={
			"oid":geth2()
			};
		
		var success2 = function(data2, textStatus, jqXHR){
			if (data2.data != null && data2.retCode == 1) {
					console.log(data2);
					b = data2;
					FillHCitem(a,b);
				}else {
					//
				}
			
		};
		$.post(url,data2,success2,"json");
		
		
	}

function FillHCitem(data1,data2) {//contrast填充
		
		jsonData1 = data1.data;	
		jsonData2 = data2.data;	
		//console.log(jsonData1.totalprice);
		//displayQTvalue (jsonData2.houseQtList,"2732d7f4-2336-11e7-9a1f-00163e068506")
            var row = {
                "hlipath1":jsonData1.hlipath,
				"oid1":jsonData1.oid,
                "hname1":jsonData1.hname,
				"area1":GetArea(jsonData1.area),
				"cuoid1":jsonData1.cuoid,
				"cdate1":GetTimeText(jsonData1.cdate),
				"orieName1":jsonData1.orieName,
				"floor1":jsonData1.floor,
				"totalfloor1":jsonData1.totalfloor,
				"layoutName1":jsonData1.layoutName,
				"lutypename1":jsonData1.lutypename,
				"year1":jsonData1.year,
				"decoName1":jsonData1.decoName,
				"btypename1":jsonData1.btypename,
				"anames1":jsonData1.anames,
				"cname1":jsonData1.cname,
				"clabels":GetLabel(jsonData1.clabels),
				"totalprice1":GetTotalprice(jsonData1.totalprice),
				"unitprice1":GetUnitprice(jsonData1.unitprice),//--1
				"igroupoid1":jsonData1.igroupoid,
				"zxdoor1":displayQTvalue (jsonData1.houseQtList,"c234a6a0-21f4-11e7-9a1f-00163e068506"),
				"zxwindow1":displayQTvalue (jsonData1.houseQtList,"c23df7ad-21f4-11e7-9a1f-00163e068506"),
				"zxwall1":displayQTvalue (jsonData1.houseQtList,"c29345d8-21f4-11e7-9a1f-00163e068506"),
				"zxground1":displayQTvalue (jsonData1.houseQtList,"c29a6f29-21f4-11e7-9a1f-00163e068506"),
				"sdqd1":displayQTvalue (jsonData1.houseQtList,"270ff7a0-2336-11e7-9a1f-00163e068506"),
				"sdrd1":displayQTvalue (jsonData1.houseQtList,"2712da92-2336-11e7-9a1f-00163e068506"),
				"sdgs1":displayQTvalue (jsonData1.houseQtList,"1111"),
				"sdps1":displayQTvalue (jsonData1.houseQtList,"271a7146-2336-11e7-9a1f-00163e068506"),
				"sdpy1":displayQTvalue (jsonData1.houseQtList,"271e71e2-2336-11e7-9a1f-00163e068506"),
				"sdls1":displayQTvalue (jsonData1.houseQtList,"272363e7-2336-11e7-9a1f-00163e068506"),
				"jdz1":displayQTvalue (jsonData1.houseQtList,"2727bf05-2336-11e7-9a1f-00163e068506"),
				"jdc1":displayQTvalue (jsonData1.houseQtList,"272b8002-2336-11e7-9a1f-00163e068506"),
				"jdg1":displayQTvalue (jsonData1.houseQtList,"1111"),
				"jdbx1":displayQTvalue (jsonData1.houseQtList,"2732d7f4-2336-11e7-9a1f-00163e068506"),
				"jdds1":displayQTvalue (jsonData1.houseQtList,"2736f3d7-2336-11e7-9a1f-00163e068506"),
				"jdxyj1":displayQTvalue (jsonData1.houseQtList,"273aed3e-2336-11e7-9a1f-00163e068506"),
				"jdkt1":displayQTvalue (jsonData1.houseQtList,"273ec35a-2336-11e7-9a1f-00163e068506"),
				"jdcyyj1":displayQTvalue (jsonData1.houseQtList,"274233dc-2336-11e7-9a1f-00163e068506"),
				"jdmqz1":displayQTvalue (jsonData1.houseQtList,"1111"),
				"jdrsq1":displayQTvalue (jsonData1.houseQtList,"1111"),
				"jdyg1":displayQTvalue (jsonData1.houseQtList,"1111"),
				"jdmt1":displayQTvalue (jsonData1.houseQtList,"275ba3ef-2336-11e7-9a1f-00163e068506"),
				"jdhs1":displayQTvalue (jsonData1.houseQtList,"1111"),
				"livingroom1":displayparam (jsonData1.paramList,"客厅"),
				"restaurant1":displayparam (jsonData1.paramList,"餐厅"),
				"kitchen1":displayparam (jsonData1.paramList,"厨房"),
				"bedroom11":displayparam (jsonData1.paramList,"卧室1"),
				"bedroom21":displayparam (jsonData1.paramList,"卧室2"),
				"bedroom31":displayparam (jsonData1.paramList,"卧室3"),
				"bedroom41":displayparam (jsonData1.paramList,"卧室4"),
				"toilet11":displayparam (jsonData1.paramList,"卫生间1"),
				"toilet21":displayparam (jsonData1.paramList,"卫生间2"),
				"toilet31":displayparam (jsonData1.paramList,"卫生间3"),
				"balcony11":displayparam (jsonData1.paramList,"阳台1"),
				"balcony21":displayparam (jsonData1.paramList,"阳台2"),
				"balcony31":displayparam (jsonData1.paramList,"阳台3"),
				"area11":displayparam (jsonData1.paramList,"建筑产权面积"),
				"area21":displayparam (jsonData1.paramList,"套内产权面积"),
				"area31":displayparam (jsonData1.paramList,"实际使用面积"),
				"height1":displayparam (jsonData1.paramList,"净层高"),
				"commlocation1":displaycommparam (jsonData1.commPropList,"小区位置"),
				"commyear1":displaycommparam (jsonData1.commPropList,"建筑年代"),
				"commbulids1":displaycommparam (jsonData1.commPropList,"楼栋总数"),
				"commfamily1":displaycommparam (jsonData1.commPropList,"住户总数"),
				"commstop1":displaycommparam (jsonData1.commPropList,"停车位"),
				"commcar1":displaycommparam (jsonData1.commPropList,"停车费"),
				"commpark1":displaycommparam (jsonData1.commPropList,"小区绿化"),
				"commmanage1":displaycommparam (jsonData1.commPropList,"小区管理费"),
				"communp1":displaycommparam (jsonData1.commPropList,"小区均价"),
				"commfollow1":displaycommparam (jsonData1.commPropList,"小区关注度"),
				"comma1":"-",
				//----
				"hlipath2":jsonData2.hlipath,
				"oid2":jsonData2.oid,
                "hname2":jsonData2.hname,
				"area2":GetArea(jsonData2.area),
				"cuoid2":jsonData2.cuoid,
				"cdate2":GetTimeText(jsonData2.cdate),
				"orieName2":jsonData2.orieName,
				"floor2":jsonData2.floor,
				"totalfloor2":jsonData2.totalfloor,
				"layoutName2":jsonData2.layoutName,
				"lutypename2":jsonData2.lutypename,
				"year2":jsonData2.year,
				"decoName2":jsonData2.decoName,
				"btypename2":jsonData2.btypename,
				"anames2":jsonData2.anames,
				"cname2":jsonData2.cname,
				"clabels":GetLabel(jsonData2.clabels),
				"totalprice2":GetTotalprice(jsonData2.totalprice),
				"unitprice2":GetUnitprice(jsonData2.unitprice),
				"igroupoid2":jsonData2.igroupoid,
				"zxdoor2":displayQTvalue (jsonData2.houseQtList,"c234a6a0-21f4-11e7-9a1f-00163e068506"),
				"zxwindow2":displayQTvalue (jsonData2.houseQtList,"c23df7ad-21f4-11e7-9a1f-00163e068506"),
				"zxwall2":displayQTvalue (jsonData2.houseQtList,"c29345d8-21f4-11e7-9a1f-00163e068506"),
				"zxground2":displayQTvalue (jsonData2.houseQtList,"c29a6f29-21f4-11e7-9a1f-00163e068506"),
				"sdqd2":displayQTvalue (jsonData2.houseQtList,"270ff7a0-2336-11e7-9a1f-00163e068506"),
				"sdrd2":displayQTvalue (jsonData2.houseQtList,"2712da92-2336-11e7-9a1f-00163e068506"),
				"sdgs2":displayQTvalue (jsonData2.houseQtList,"1111"),
				"sdps2":displayQTvalue (jsonData2.houseQtList,"271a7146-2336-11e7-9a1f-00163e068506"),
				"sdpy2":displayQTvalue (jsonData2.houseQtList,"271e71e2-2336-11e7-9a1f-00163e068506"),
				"sdls2":displayQTvalue (jsonData2.houseQtList,"272363e7-2336-11e7-9a1f-00163e068506"),
				"jdz2":displayQTvalue (jsonData2.houseQtList,"2727bf05-2336-11e7-9a1f-00163e068506"),
				"jdc2":displayQTvalue (jsonData2.houseQtList,"272b8002-2336-11e7-9a1f-00163e068506"),
				"jdg2":displayQTvalue (jsonData2.houseQtList,"1111"),
				"jdbx2":displayQTvalue (jsonData2.houseQtList,"2732d7f4-2336-11e7-9a1f-00163e068506"),
				"jdds2":displayQTvalue (jsonData2.houseQtList,"2736f3d7-2336-11e7-9a1f-00163e068506"),
				"jdxyj2":displayQTvalue (jsonData2.houseQtList,"273aed3e-2336-11e7-9a1f-00163e068506"),
				"jdkt2":displayQTvalue (jsonData2.houseQtList,"273ec35a-2336-11e7-9a1f-00163e068506"),
				"jdcyyj2":displayQTvalue (jsonData2.houseQtList,"274233dc-2336-11e7-9a1f-00163e068506"),
				"jdmqz2":displayQTvalue (jsonData2.houseQtList,"2222"),
				"jdrsq2":displayQTvalue (jsonData2.houseQtList,"2222"),
				"jdyg2":displayQTvalue (jsonData2.houseQtList,"2222"),
				"jdmt2":displayQTvalue (jsonData2.houseQtList,"275ba3ef-2336-11e7-9a1f-00163e068506"),
				"jdhs2":displayQTvalue (jsonData2.houseQtList,"2222"),
				"livingroom2":displayparam (jsonData2.paramList,"客厅"),
				"restaurant2":displayparam (jsonData2.paramList,"餐厅"),
				"kitchen2":displayparam (jsonData2.paramList,"厨房"),
				"bedroom12":displayparam (jsonData2.paramList,"卧室1"),
				"bedroom22":displayparam (jsonData2.paramList,"卧室2"),
				"bedroom32":displayparam (jsonData2.paramList,"卧室3"),
				"bedroom42":displayparam (jsonData2.paramList,"卧室4"),
				"toilet12":displayparam (jsonData2.paramList,"卫生间1"),
				"toilet22":displayparam (jsonData2.paramList,"卫生间2"),
				"toilet32":displayparam (jsonData2.paramList,"卫生间3"),
				"balcony12":displayparam (jsonData2.paramList,"阳台1"),
				"balcony22":displayparam (jsonData2.paramList,"阳台2"),
				"balcony32":displayparam (jsonData2.paramList,"阳台3"),
				"area12":displayparam (jsonData2.paramList,"建筑产权面积"),
				"area22":displayparam (jsonData2.paramList,"套内产权面积"),
				"area32":displayparam (jsonData2.paramList,"实际使用面积"),
				"height2":displayparam (jsonData2.paramList,"净层高"),
				"commlocation2":displaycommparam (jsonData2.commPropList,"小区位置"),
				"commyear2":displaycommparam (jsonData2.commPropList,"建筑年代"),
				"commbulids2":displaycommparam (jsonData2.commPropList,"楼栋总数"),
				"commfamily2":displaycommparam (jsonData2.commPropList,"住户总数"),
				"commstop2":displaycommparam (jsonData2.commPropList,"停车位"),
				"commcar2":displaycommparam (jsonData2.commPropList,"停车费"),
				"commpark2":displaycommparam (jsonData2.commPropList,"小区绿化"),
				"commmanage2":displaycommparam (jsonData2.commPropList,"小区管理费"),
				"communp2":displaycommparam (jsonData2.commPropList,"小区均价"),
				"commfollow2":displaycommparam (jsonData2.commPropList,"小区关注度"),
				"comma2":"-"
            }
			
            var text=$("#BDitem").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $("#BDTJList").append(rs);
       
		
	}
function displayQTvalue(data,id) {
	if(data == null){return ""}
	//console.log(data);
	//console.log(id);
	var QTvalue="";
	for(v in data){
		//console.log(222);
		for(m in data[v].children) {
			//console.log(333);
			if(data[v].children[m].key == id){
				for(c in data[v].children[m].children) {
					if(data[v].children[m].children[c].sclazzname == "品牌") {
						QTvalue += "<h6 class='mpclear'>"
						QTvalue += "<p class='pull-left'>"+data[v].children[m].children[c].sclazzname+"</p>";
						QTvalue += "<p class='pull-right' style='margin-right:10px;'>"+data[v].children[m].children[c].rdesc+"</p>";
						QTvalue += "</h6><br>";
					}else if(data[v].children[m].children[c].sclazzname == "数量") {
						QTvalue += "<h6 class='mpclear'>"
						QTvalue += "<p class='pull-left'>"+data[v].children[m].children[c].sclazzname+"</p>";
						QTvalue += "<p class='pull-right' style='margin-right:10px;'>"+data[v].children[m].children[c].rdesc+"</p>";
						QTvalue += "</h6><br>";
					}else if(data[v].children[m].children[c].sclazzname == "材质") {
						QTvalue += "<h6 class='mpclear'>"
						QTvalue += "<p class='pull-left'>"+data[v].children[m].children[c].sclazzname+"</p>";
						QTvalue += "<p class='pull-right' style='margin-right:10px;'>"+data[v].children[m].children[c].rdesc+"</p>";
						QTvalue += "</h6><br>";
					}else {
						QTvalue += "<h6 class='mpclear'>"
						QTvalue += "<p class='pull-left'>"+data[v].children[m].children[c].sclazzname+"</p>";
						QTvalue += QTdisplay(data[v].children[m].children[c].result,data[v].children[m].children[c].igroupoid);
						QTvalue += "</h6><br>";
					}

					}
				//console.log(QTvalue);
				return QTvalue;
				}
			}
		}
	return "-";
	}
function displayparam(data,id) {
	if(data == null){return ""}
	for (v in data){
		if(data[v].paramname == id){
			return data[v].paramval;
			}
		}
	return "-";
	}
function displaycommparam(data,id) {
	if(data == null){return ""}
	for (v in data){
		if(data[v].kay == id){
			return data[v].val;
			}
		}
	return "-";
	}
//------------
function userlogin() {//login
		//console.log(4444);
		var url=DOMAIN + "/user/userSignIn";
		
		var data={
			"phoneNum":$(".login-page .form-control").eq(0).val(),
			"passwd":$(".login-page .form-control").eq(1).val(),
			"wechatid":getwechatid()
			};
		//console.log(data);
		var success = function(data, textStatus, jqXHR){
			if (data.retCode == 1) {
					//console.log(data)
					//console.log(222)
					bpai("zx",data.data);
					//console.log(uk());
					if(history.length > 1) {
						//history.go(-1);
						location.href="homepage.html";	
						}else{
						location.href="homepage.html";	
						}
					//
				}else {
					layer.msg("账号或者密码错误哦");
				}
			
		};
		$.get(url,data,success,"json");
	}
function usercheck() {
		//console.log(4545)
		var url=DOMAIN + "/user/userSignIn";
		//console.log($(".login-page .form-control").eq(1).val())
		var data={
			"phoneNum":$(".login-page .form-control").eq(0).val(),
			"passwd":$(".login-page .form-control").eq(1).val()
			};
		
		var success = function(data, textStatus, jqXHR){
			if (data.retCode == 1) {
					//console.log(data)
					
					bpai("zx",data.data);
					history.go(-1)
					
					
				}else {
					alert("登录失败！");	
				}
			
		};
		//$.get(url,data,success,"json");
	}

//----我的关注房源小区
function Loadcustfollow (key) {
		var url=DOMAIN + "/cust/custfollow";
		//console.log(uk());
		var data={
			"coid":uk(),
			"followtype":key
			};
		//console.log(key);
		var success = function(data, textStatus, jqXHR){
			//console.log(data);
			if (data.data != "") {
				if(key == 3){
						Fillcustfollowcomm(data);
					}else{
						Fillcustfollow(data);
					}
			}else {
				Fillnodataplan();
				//alert("登录失败！");	
			}
			
		};
		$.post(url,data,success,"json");
	}
function Fillcustfollow (data) {
		jsonData = data.data;
        for (v in jsonData){
			//console.log(data);		
            var row = {
                "iPath":jsonData[v].ipath,
                "hname":jsonData[v].hname,
				"anames":jsonData[v].anames,
				"statName":jsonData[v].statName,
				"cdate":GetTimeText(jsonData[v].cdate),
				"area":GetArea(jsonData[v].area),
				"orieName":jsonData[v].orieName,
				"layoutName":jsonData[v].layoutName,
				"cname":jsonData[v].cname,
				"hlabelNames":GetLabel(jsonData[v].hlabelNames),
				"totalprice":GetTotalprice(jsonData[v].totalprice),
				"icount":jsonData[v].icount,//
				"year":jsonData[v].year,
				"floor":jsonData[v].floor,
				"decoName":jsonData[v].decoName,
				"lutypename":jsonData[v].lutypename,
				"oid":jsonData[v].oid,
				"coid":jsonData[v].coid,
				"btypename":jsonData[v].btypename,
				"housefollow":jsonData[v].housefollow,
				"houseseen":jsonData[v].houseseen,
				"housebrowse":jsonData[v].housebrowse,
				"rent":jsonData[v].rent+1,
				"unitprice":GetUnitprice(jsonData[v].unitprice)
            }
			
            var text=$("#BDitem").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $("#myTabContent").append(rs);
			rebulidingA ();
        }
	}
function Fillcustfollowcomm (data) {
	   //console.log(3)
		jsonData = data.data;
        for (v in jsonData){
			//console.log(data);		
            var row = {
                "ipath":jsonData[v].ipath,
                "cname":jsonData[v].cname,
				"attr":jsonData[v].attr,
				"year":jsonData[v].year,
				"oid":jsonData[v].oid,
				"rentcount":jsonData[v].rentcount,
				"salecount":jsonData[v].salecount,
				"avgprice":Getprice(jsonData[v].avgprice),
				"buildingtypes":jsonData[v].buildingtypes,
				"byear":jsonData[v].byear,
				"cdate":GetTimeText(jsonData[v].cdate)
            }
			
            var text=$("#BDitem").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $("#myTabContent").append(rs);
			rebulidingA ();
        }
	}
//----
function Loadcustplan (key) {
	//console.log("已看");
	var url=DOMAIN + "/cust/custseen";
		//console.log(uk());
		var data={
			"coid":uk(),//bpao("zx"),
			"trantype":key
			};
		
		var success = function(data, textStatus, jqXHR){
			//console.log(data.data);
			if (data.data != "") {
				Fillcustplan(data);	
			}else {
				Fillnodataplan();
				//alert("登录失败！");	
			}
			
		};
		$.post(url,data,success,"json");
	}
function Fillcustplan (data) {
	jsonData = data.data;
        for (v in jsonData){
			//console.log(data);		
            var row = {
                "iPath":jsonData[v].ipath,
                "hname":jsonData[v].hname,
				"anames":jsonData[v].anames,
				"statName":jsonData[v].statName,
				"cdate":GetTimeText(jsonData[v].cdate),
				"area":GetArea(jsonData[v].area),
				"orieName":jsonData[v].orieName,
				"layoutName":jsonData[v].layoutName,
				"cname":jsonData[v].cname,
				"hlabelNames":GetLabel(jsonData[v].hlabelNames),
				"totalprice":GetTotalprice(jsonData[v].totalprice),
				"icount":jsonData[v].icount,//
				"year":jsonData[v].year,
				"floor":jsonData[v].floor,
				"decoName":jsonData[v].decoName,
				"lutypename":jsonData[v].lutypename,
				"oid":jsonData[v].oid,
				"btypename":jsonData[v].btypename,
				"housefollow":jsonData[v].housefollow,
				"houseseen":jsonData[v].houseseen,
				"housebrowse":jsonData[v].housebrowse,
				"unitprice":GetUnitprice(jsonData[v].unitprice)
            }
			
            var text=$("#BDitem").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $("#myTabContent").append(rs);
			rebulidingA ();
        }
	}
//----
function Loadcustbook () {
	//console.log("待看");
	var url=DOMAIN + "/cust/custbooking";
		//console.log(uk());
		var data={
			"coid":uk()//bpao("zx"),
			};
		
		var success = function(data, textStatus, jqXHR){
			//console.log(data.data);
			if (data.data != "") {
				Fillcustbook(data);	
			}else {
				Fillnodataplan();
			}
			
		};
		$.post(url,data,success,"json");
	}
function Fillcustbook (data) {
	jsonData = data.data;
        for (v in jsonData){
			//console.log(data);		
            var row = {
                "iPath":jsonData[v].ipath,
                "hname":jsonData[v].hname,
				"anames":jsonData[v].anames,
				"statName":jsonData[v].statName,
				"cdate":GetTimeText(jsonData[v].cdate),
				"area":GetArea(jsonData[v].area),
				"orieName":jsonData[v].orieName,
				"layoutName":jsonData[v].layoutName,
				"cname":jsonData[v].cname,
				"hlabelNames":GetLabel(jsonData[v].hlabelNames),
				"totalprice":GetTotalprice(jsonData[v].totalprice),
				"icount":jsonData[v].icount,//
				"year":jsonData[v].year,
				"floor":jsonData[v].floor,
				"decoName":jsonData[v].decoName,
				"lutypename":jsonData[v].lutypename,
				"oid":jsonData[v].oid,
				"btypename":jsonData[v].btypename,
				"housefollow":jsonData[v].housefollow,
				"houseseen":jsonData[v].houseseen,
				"housebrowse":jsonData[v].housebrowse,
				"unitprice":GetUnitprice(jsonData[v].unitprice)
            }
			
            var text=$("#BDitem").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $("#myTabContent").append(rs);
			rebulidingA ();
        }
	}
//------	
function Loadcustbuy () {
	//console.log("买家成交");
	var url=DOMAIN + "/cust/buyerdeal";
		//console.log(uk());
		var data={
			"coid":uk()//bpao("zx"),
			};
		
		var success = function(data, textStatus, jqXHR){
			//console.log(data);
			if (data.data != "") {
				Fillcustbuy(data);	
			}else {
				Fillnodataplan();
				//alert("登录失败！");	
			}
			
		};
		$.post(url,data,success,"json");
	}
function Fillcustbuy (data) {
	jsonData = data.data;
        for (v in jsonData){
			//console.log(data);		
            var row = {
                "iPath":jsonData[v].ipath,
                "hname":jsonData[v].hname,
				"anames":jsonData[v].anames,
				"statName":jsonData[v].statName,
				"cdate":GetTimeText(jsonData[v].cdate),
				"area":GetArea(jsonData[v].area),
				"orieName":jsonData[v].orieName,
				"layoutName":jsonData[v].layoutName,
				"cname":jsonData[v].cname,
				"hlabelNames":GetLabel(jsonData[v].hlabelNames),
				"totalprice":GetTotalprice(jsonData[v].totalprice),
				"icount":jsonData[v].icount,//
				"year":jsonData[v].year,
				"floor":jsonData[v].floor,
				"decoName":jsonData[v].decoName,
				"lutypename":jsonData[v].lutypename,
				"oid":jsonData[v].oid,
				"btypename":jsonData[v].btypename,
				"housefollow":jsonData[v].housefollow,
				"houseseen":jsonData[v].houseseen,
				"housebrowse":jsonData[v].housebrowse,
				"unitprice":GetUnitprice(jsonData[v].unitprice)
            }
			
            var text=$("#BDitem").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $("#myTabContent").append(rs);
			rebulidingA ();
        }
	}
//----
function Fillnodataplan () {//nodata
	var row = {
		
	}
	
	var text=$("#nodataitem").text();
	var compiled = _.template(text);
	rs=compiled(row);
	
	$("#myTabContent").append(rs);
	rebulidingA ();
	}
//----
function Loadcustdepute (key) {
		//console.log("出租委托，出售委托");
		var url=DOMAIN + "/cust/custhouse";
		//console.log(uk());
		var data={
			"coid":uk(),//bpao("zx"),
			"trantype":key
			};
		
		var success = function(data, textStatus, jqXHR){
			//console.log(data);
			if (data.data != "") {
				Fillcustdepute(data);	
			}else {
				Fillnodataplan();
				//alert("登录失败！");	
			}
			
		};
		$.post(url,data,success,"json");
	}
function Fillcustdepute (data) {
	jsonData = data.data;
        for (v in jsonData){
			//console.log(data);		
            var row = {
                "iPath":jsonData[v].ipath,
                "hname":jsonData[v].hname,
				"anames":jsonData[v].anames,
				"statName":jsonData[v].statName,
				"cdate":GetTimeText(jsonData[v].cdate),
				"area":GetArea(jsonData[v].area),
				"orieName":jsonData[v].orieName,
				"layoutName":jsonData[v].layoutName,
				"cname":jsonData[v].cname,
				"hlabelNames":GetLabel(jsonData[v].hlabelNames),
				"totalprice":GetTotalprice(jsonData[v].totalprice),
				"icount":jsonData[v].icount,//
				"year":jsonData[v].year,
				"floor":jsonData[v].floor,
				"decoName":jsonData[v].decoName,
				"lutypename":jsonData[v].lutypename,
				"oid":jsonData[v].oid,
				"btypename":jsonData[v].btypename,
				"housefollow":jsonData[v].housefollow,
				"houseseen":jsonData[v].houseseen,
				"housebrowse":jsonData[v].housebrowse,
				"unitprice":GetUnitprice(jsonData[v].unitprice)
            }
			
            var text=$("#BDitem").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $("#myTabContent").append(rs);
			rebulidingA ();
        }
	}
//-----
function LoadoneUser () {
		var url=DOMAIN + "/user/queryAgentByPhonenum";
		var data={
			"phonenum":getuserPhonenum()
			};
		
		var success = function(data, textStatus, jqXHR){
			//console.log(data);
			if (data.retCode != 0) {
				Filloneuser(data);	
			}else {
				
				//alert("登录失败！");	
			}
			
		};
		$.post(url,data,success,"json");			
	}
function Filloneuser (data) {
	jsonData = data.data;
        	
		var row = {
			"name":jsonData.name,
			"ipath":jsonData.ipath,
			"oid":jsonData.oid,
			"phonenum":jsonData.phonenum
		}
		
		var text=$("#oneuser").text();
		var compiled = _.template(text);
		rs=compiled(row);
		
		$(".user").append(rs);
	}
//-----
function  usercheckin (){//待看
	if(uk() == ""){
		location.href="login.html";
		}
	}
//-----
function LoadNECOList(num) {//editcontrast
		//console.log(555)
		var url=DOMAIN + "/house/queryHouseDetail";
		var data={
			"oid":num
			
			};
		
		var success = function(data, textStatus, jqXHR){
			if (data.data != null && data.retCode == 1) {
					//console.log(6666)
					FillNECOitem(data);
				}else {
					//
				}
			
		};
		$.post(url,data,success,"json");
		
		
	}
function FillNECOitem(data) {//editcontrast填充
		jsonData1 = data.data;		
		if(jsonData1 != null){
			var row = {
                "cipath":jsonData1.cipath,
                "hname":jsonData1.hname,
				"area":GetArea(jsonData1.area),
				"orieName":jsonData1.orieName,
				"floor":jsonData1.floor,
				"totalfloor":jsonData1.totalfloor,
				"layoutName":jsonData1.layoutName,
				"lutypename":jsonData1.lutypename,
				"year":jsonData1.year,
				"decoName":jsonData1.decoName,
				"btypename":jsonData1.btypename,
				"anames":jsonData1.anames,
				"cname":jsonData1.cname,
				"oid":jsonData1.oid,
				"clabels":GetLabel(jsonData1.clabels),
				"totalprice":GetTotalprice(jsonData1.totalprice),
				"unitprice":GetUnitprice(jsonData1.unitprice)//--1
            }
			
            var text=$("#BDitem").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $(".editcontrast").append(rs);
		}
		
		if(++loadmti < mt.length){
			//console.log(mt);
			LoadNECOList(mt[loadmti]);
			}   
	}
//-----
function changename () {//ok
		//console.log("修改昵称");
		var url=DOMAIN + "/cust/editCustomer";
		//console.log(uk());
		//console.log($("#myTabContent .form-control").val());
		var jsons = {
			"oid":usjsda.data.oid,//bpao("zx"),
			"name":$("#myTabContent .form-control").val()
			}
		var data={
			"data":JSON.stringify(jsons)
			};
		//console.log(data);
		var success = function(data, textStatus, jqXHR){
			//console.log(data);
			if (data.retCode == 1) {
				layer.msg("修改成功")
				location.reload();	
			}else {
				layer.msg("修改昵称失败了")
				//alert("登录失败！");	
			}
			
		};
		$.post(url,data,success,"json");
	}
function userrepassword () {
		//console.log("重置密码");
		var url=DOMAIN + "/cust/editCustPasswd";
		//console.log($(".login-page .form-control").eq(0).val());
		//console.log($(".login-page .form-control").eq(2).val());
		
		var data={
			"phoneNum":$(".login-page .form-control").eq(0).val(),
			"newPasswd":$(".login-page .form-control").eq(2).val()
			};
		//console.log(data);
		var success = function(data, textStatus, jqXHR){
			//console.log(data);
			if (data.retCode == 1) {
				layer.msg("密码重置成功")	;
			}else {
				layer.msg("密码重置失败")	;
			}
			
		};
		$.post(url,data,success,"json");
	}

function register () {
		//console.log("注册");
		//增加合法判断，验证码，非空，密码一致，点击阅读，手机未修改，密码位数等
		var url=DOMAIN + "/cust/editCustomer";
		//console.log($(".login-page .form-control").eq(3).val());
		//console.log($(".login-page .form-control").eq(2).val());
		//console.log($(".sms .form-control").val());
		var jsons={
			"ipath":"",//bpao("zx"),
			"name":$(".login-page .form-control").eq(2).val(),//bpao("zx"),
			"passwd":$(".login-page .form-control").eq(3).val(),//bpao("zx"),
			"phonenum":$(".sms .form-control").val(),
			"wechatid":getwechatid()
			};
		var data={
			"data":JSON.stringify(jsons)
			};
		//console.log(data);
		var success = function(data, textStatus, jqXHR){
			//console.log(data);
			if (data.retCode == 1) {
				layer.msg("注册成功！");	
				setTimeout(location.href="login.html",3000);	
			}else {
				layer.msg("注册失败！");	
			}
			
		};
		$.post(url,data,success,"json");
	}
//-----
function changepassword() {
		//console.log("修改密码");
		var url=DOMAIN + "/cust/editCustomer";
		//console.log(uk());
		//console.log($(".datalist .form-control").eq(2).val());
		var jsons = {
			"oid":usjsda.data.oid,//bpao("zx"),
			"passwd":$(".datalist .form-control").eq(2).val()
			}
		var data={
			"data":JSON.stringify(jsons)
			};
		//console.log(data);
		var success = function(data, textStatus, jqXHR){
			//console.log(data);
			if (data.retCode == 1) {
				layer.msg("密码修改成功")	
			}else {
				layer.msg("密码修改失败")
				//alert("登录失败！");	
			}
			
		};
		$.post(url,data,success,"json");
	}
function changephone() {
		//console.log("修改手机");
		var url=DOMAIN + "/cust/editCustomer";
		//console.log(uk());
		//console.log($(".datalist .form-control").eq(0).val());
		var jsons = {
			"oid":usjsda.data.oid,//bpao("zx"),
			"phonenum":$(".datalist .form-control").eq(0).val()
			}
		var data={
			"data":JSON.stringify(jsons)
			};
		//console.log(data);
		var success = function(data, textStatus, jqXHR){
			//console.log(data);
			if (data.retCode == 1) {
				layer.msg("手机修改成功");
				$(".mine-title .col-md-4 h5").text($(".datalist .form-control").eq(0).val());
				$(".datalist .form-control").eq(0).val("");
				$(".datalist .form-control").eq(1).val("");
			}else {
				layer.msg("手机修改失败")
				//alert("登录失败！");	
			}
			
		};
		$.post(url,data,success,"json");
	}
function changeheadimg(imgURL) {
		//console.log("修改头像");
		var url=DOMAIN + "/cust/editCustomer";
		//console.log(uk());
		//console.log($(".datalist .form-control").eq(2).val());
		var jsons = {
			"oid":usjsda.data.oid,//bpao("zx"),
			"ipath":imgURL
			}
		var data={
			"data":JSON.stringify(jsons)
			};
		//console.log(data);
		var success = function(data, textStatus, jqXHR){
			//console.log(data);
			if (data.retCode == 1) {
				layer.msg("头像修改成功");
				$(".userhead").attr("src",imgURL);
			}else {
				layer.msg("头像修改失败");
				//alert("登录失败！");	
			}
			
		};
		$.post(url,data,success,"json");
	}
//------
function submithouse (num) {
	//console.log("提交房源");
		var url=DOMAIN + "/cust/editHouseWaitingByCust";
		//console.log(uk());
		var jsons={
			"attr":$(".form-horizontal .form-control").eq(0).val(),
			"callname":$(".form-horizontal .form-control").eq(6).val(),
			"cname":$(".form-horizontal .form-control").eq(1).val(),
			"hnum":$(".form-horizontal .form-control").eq(2).val()+"楼栋"+$(".form-horizontal .form-control").eq(3).val()+"单元"+$(".form-horizontal .form-control").eq(4).val()+"门牌",
			"phonenum":$(".form-horizontal .form-control").eq(7).val(),
			"price":$(".form-horizontal .form-control").eq(5).val(),
			"rent":num
			}
		var data={
			"coid":uk(),//bpao("zx"),
			"data":JSON.stringify(jsons)
			};
			
		//console.log(data);
		var success = function(data, textStatus, jqXHR){
			//console.log(data);
			if (data.retCode == 1) {
				layer.msg("房源提交了，马上联系您");
				$(".form-horizontal .form-control").val("");
			}else {
				layer.msg("房源提交失败");;	
			}
			
		};
		$.post(url,data,success,"json");
	}
//-----
var userfromid="";
function LoadUsertokenmsg() {//用户信息token转id
		var url=DOMAIN + "/cust/oneCust";
		var data={
			"coid":uk()
			};
		//console.log(data);
		var success = function(data, textStatus, jqXHR){
			//console.log(data)
			if (data.retCode == 1 && data.data.length != 0) {
					LoadUsermsg(data.data.oid);
					userfromid=data.data.oid;
				}else{
					layer.msg("请先登录");
				}
			
		};
		$.post(url,data,success,"json");
}
function LoadUsermsg(id) {//以用户未接收方的所有消息集合
		var url=DOMAIN + "/msg/countUnreadMessageByToUserIdGroupByFromUserId";
		var data={
			"toUserId":id
			};
		//console.log(data);
		var success = function(data, textStatus, jqXHR){
			//console.log(data)
			if (data.data.length != 0 && data.retCode == 1) {
					msguserdata=data;
					loadmsguser(data);
				}else {
					//
				}
			
		};
		$.post(url,data,success,"json");
		
		
	}
var vpmsg=0;
var msguserdata="";
var vpmsgipath="";
var vpmsguser="";
function loadmsguser (data) {//经纪人信息

	var url=DOMAIN + "/user/queryAgentByOidNoToken";
		var data={
			"oid":data.data[vpmsg].fromuserid
			};
		//console.log(data);
		var success = function(data, textStatus, jqXHR){
			//console.log(data)
			if (data.data != null && data.retCode == 1) {
					vpmsguser = data.data.name;
					vpmsgipath = data.data.ipath;
					FillmsgList(msguserdata);
				}else {
					//console.log(msguserdata.data.length)
					if(++vpmsg < msguserdata.data.length){
						//console.log(vpmsg)
			        	loadmsguser(msguserdata);
			        }
				}
			
		};
		$.post(url,data,success,"json");
}
function FillmsgList(data) {//消息内容填充
		
		jsonData = data.data;		
        var row = {
			"name":vpmsguser,
			"fromuserid":jsonData[vpmsg].fromuserid,
			"iPath":(vpmsgipath == null || vpmsgipath == "")?"img/default.png":vpmsgipath,
            "unreadcount":jsonData[vpmsg].unreadcount
			
        }
		//console.log(row.iPath)
        var text=$("#BDitem").text();
        var compiled = _.template(text);
        rs=compiled(row);
		
        $("#BDTJList").append(rs);
        if(++vpmsg < msguserdata.data.length){
        	loadmsguser(msguserdata);
        }
	}
//--
function LoadUsertokentoid() {//用户信息token转id,详情页调用
		var url=DOMAIN + "/cust/oneCust";
		var data={
			"coid":uk()
			};
		//console.log(data);
		var success = function(data, textStatus, jqXHR){
			//console.log(data)
			if (data.retCode == 1 && data.data.length != 0 ) {
					userfromid=data.data.oid;
				}
			
		};
		$.post(url,data,success,"json");
}
//----
function LoadAGList() {//经纪人联系列表
		
		var url=DOMAIN + "/cust/listCustAgent";
		var data={
			"coid":uk()
			};
		
		var success = function(data, textStatus, jqXHR){
			
			if (data.data != null) {
					vpmsguser = data.data[0].shopname;
					//console.log(vpmsguser);
					Fillagentlist(data);
				}else {
					//
				}
			
		};
		$.post(url,data,success,"json");
		
		
	}
function Fillagentlist(data) {//经纪人联系列表
		//console.log(data);
		jsonData = data.data;
        for (v in jsonData){
			////console.log(data);		
            var row = {
                "iPath":jsonData[v].ipath,
                "shopname":jsonData[v].shopname,
                "oid":jsonData[v].oid,
				"scandate":GetTimestr(jsonData[v].scandate),
				"phonenum":jsonData[v].phonenum
				
            }
			
            var text=$("#BDitem").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $("#BDTJList").append(rs);
        }
		
	}