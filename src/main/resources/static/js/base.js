// JavaScript Document

//推荐
function LoadTJcontent() {
	
		
		var url=DOMAIN + "/house/list";
		var data={
			orderby:"recomindex"
			};
		
		var success = function(data, textStatus, jqXHR){
			//console.log(data);	
			if (data.data != null && data.retCode == 1) {
					FillTJitem(data);
				}else {
					//
				}
			
		};
		$.post(url,data,success,"json");
		
		
	}
	
function FillTJitem(data) {//推荐填充
		
		jsonData = data.data;
        for (v=0;v<jsonData.length && v<2;v++){
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
        }
	}
//本地
function LoadBDcontent(str) {
	
		//console.log(str)
		var url=DOMAIN + "/house/listByAgentLocal";
		var data={
				"data":'['+str+']'
			};
		
		var success = function(data, textStatus, jqXHR){
			//console.log(data);	
			if (data.data != null && data.retCode == 1) {
					FillBENDIitem(data);
				}else {
					//
				}
			
		};
		$.post(url,data,success,"json");
		
		
	}
function FillBENDIitem(data) {//本地推荐填充
		
		jsonData = data.data;
        for (v=0;v<jsonData.length && v<2;v++){
			////console.log(data);		
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
				"rent":jsonData[v].rent,
				"unitprice":GetUnitprice(jsonData[v].unitprice),
				"cdate":GetTimeText(jsonData[v].cdate)
            }
			
            var text=$("#BDitem").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $("#BDTJList").append(rs);
        }
		
	}		
function FillBDitem(data) {//基础数据填充
		
		jsonData = data.data;
        for (v=0;v<jsonData.length;v++){
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
				"statName":jsonData[v].statName,
				"rent":jsonData[v].rent,
				"unitprice":GetUnitprice(jsonData[v].unitprice),
				"cdate":GetTimeText(jsonData[v].cdate)
            }
			
            var text=$("#BDitem").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $("#BDTJList").append(rs);
        }
		
	}
function FillvBDitem(data) {//小区基础数据填充
		
		jsonData = data.data;
        for (v=0;v<jsonData.length && v<2;v++){
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
				"rent":jsonData[v].rent,
				"unitprice":GetUnitprice(jsonData[v].unitprice),
				"cdate":GetTimeText(jsonData[v].cdate)
            }
			
            var text=$("#BDvitem").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $("#BDTJList").append(rs);
        }
		
	}	

//------serach
function LoadSearchList(key) {
		if(key == null){
			$("#SerchList").html("");
			page = 1;
			
			}
		var url=DOMAIN + "/house/list";
		var data= datatojson();//"orderby":"recomindex"
			
		var success = function(data, textStatus, jqXHR){
			if (data.retCode == 1) {
					
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
		$.post(url,data,success,"json");
		
		
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
				"oid":jsonData[v].oid,
				"ct":getPageCT(),
				"unitprice":GetUnitprice(jsonData[v].unitprice)
            }
			
            var text=$("#SCitem").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $("#SerchList").append(rs);
        }
		
	}
//搜索条件建立
function datatojson () {
	var jsontext="";
	if (datajsonStr == ""){
			jsontext= 'data={"rent":'+getRentstr()+',"seachstr":"'+searchstr+'","orderBy":"'+orderbystr+'","pageNum":'+page+',"pageSize":'+pageSize+'}';
		}else{
			jsontext= 'data={'+datajsonStr+',"rent":'+getRentstr()+',"seachstr":"'+searchstr+'","orderBy":"'+orderbystr+'","pageNum":'+page+',"pageSize":'+pageSize+'}';
		}
	//console.log(jsontext);
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
function LoadSearchCondition () {
	
		var url=DOMAIN + "/house/list/queryItem";
		var data= {};//"orderby":"recomindex"
			
		
		var success = function(data, textStatus, jqXHR){
			if (data.data != null && data.retCode == 1) {
					FillSCondition(data);
				}else {
					//
				}
			
		};
		$.post(url,data,success,"json");
	
	}

function FillSCondition (data) {
		//console.log(data);
		searchJson = data;
		Fillorie ();
		Fillarea();
		Filllabel();
		$(".abmore").html(moreprintstr);
		Fillqybox1 ();
		checkinmoreDO();
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
//area
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
//label
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
//区域
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
	LoadSearchList();
	}
//---------------HouseDetails
function LoadHouseDetails () {
	
		var url=DOMAIN + "/house/queryHouseDetail";
		var data= {
			"aoid":uk(),
			"oid":getPageoid()
			};//"orderby":"recomindex"
			
		
		var success = function(data, textStatus, jqXHR){
			if (data.data != null && data.retCode == 1) {
					FillHDetails(data);
				}else {
					//
				}
			
		};
		$.post(url,data,success,"json");
	
	}

function FillHDetails (data) {
		//console.log(data);
		jsonData = data.data;
		var row = {
			"hname":jsonData.hname,
			"totalprice":GetTotalprice(jsonData.totalprice),
			"layoutName":jsonData.layoutName,
			"area":GetArea(jsonData.area),
			"oid":jsonData.oid,
			"hlabelNames":GetLabel(jsonData.hlabelNames),
			"unitprice":GetUnitprice(jsonData.unitprice),
			"monthpayment":jsonData.houseLoan.monthpayment,
			"downpayment":GetTotalprice(jsonData.houseLoan.downpayment),
			"floor":jsonData.floor,
			"totalfloor":jsonData.totalfloor,
			"decoName":jsonData.decoName,
			"year":jsonData.year,
			"cdate":GetTimestr(jsonData.cdate),
			"orieName":jsonData.orieName,
			"anames":jsonData.anames,
			"btypename":jsonData.btypename,
			"serialnum":jsonData.serialnum,
			"lutypename":jsonData.lutypename
			
		}
		
		var text=$("#detailsBody").text();
		var compiled = _.template(text);
		rs=compiled(row);
		
		$(".details").append(rs);
		Bulidparamtable(jsonData.paramList);//基础数据
		Bulidhlipath(jsonData.hlipath);//户型图
		BulidhouseQttable(jsonData.houseQtList);//质检
		Bulidimages(jsonData.community);//图片组
		Bulidcomm(jsonData);//小区
		Bulidcharts(jsonData.commPtrendList);//小区成交
		BulidhouseLoan(jsonData);//贷款
		Bulidtitle(jsonData.cname + " " + jsonData.layoutName);//标题
	}
	
function Bulidcomm(data) {//本地推荐填充
		
		jsonData = data;		
            var row = {
				"commPropList":Getcommlist(jsonData.commPropList),
                "rentcount":jsonData.commSale.rentcount,
				"rentedcount":jsonData.commSale.rentedcount,
				"hname":jsonData.commSale.rentedprice,
				"rentedprice":Getprice(jsonData.commSale.rentcount),
				"salecount":jsonData.commSale.salecount,
				"saledcount":jsonData.commSale.saledcount,
				"attr":jsonData.community.attr,
				"isFollowComm":(jsonData.isFollowComm == 1)?'<button type="button" class="btn btn-primary btn-block"  onclick="gofollow('+jsonData.community.oid+',3)"><i class="fa fa-heart-o"></i>关注小区</button>':'<button type="button" class="btn btn-default  btn-block"  onclick="gofollow('+jsonData.community.oid+',3)"><i class="fa fa-heart-o"></i>关注小区</button>',
				"saledprice":GetTotalprice(jsonData.commSale.saledprice)
            }
			
            var text=$("#CommItem").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $("#collapse7 .panel-body").append(rs);
			attr = jsonData.community.attr;
	}
function Bulidcharts (data) {
	data = JsonSort(data,"ymonth")
	//console.log(data);
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
	//console.log(myChart)
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
//-----------
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
			"aoid":uk(),
			"followtype":getPageCT()
			
			};
		
		var success = function(data, textStatus, jqXHR){
			if (data.data != null && data.retCode == 1) {
				//console.log(data)
				if(getPageCT() != 3){
					FillBDitem(data);
					}else{
					FillvBDitem(data);	
					}
					
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
			"aoid":uk(),
			"rent":getPageCT()
			
			};
		
		var success = function(data, textStatus, jqXHR){
			if (data.data != null && data.retCode == 1) {
					//console.log(data)
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
			"aoid":uk(),
			"rent":getPageCT()
			
			};
		
		var success = function(data, textStatus, jqXHR){
			if (data.data != null && data.retCode == 1) {
					//console.log(data);
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
				"statName":jsonData[v].statName,
				"oid":jsonData[v].oid,
				"unitprice":GetUnitprice(jsonData[v].unitprice),
				"cdate":GetTimeText(jsonData[v].cdate)
				
            }
			
            var text=$("#BDitem").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
			$(".mine .acc").html(Getprice(data.data.accuprice));
			$(".mine .sur").html(Getprice(data.data.surprice));
            $("#BDTJList").append(rs);
        }
		
	}
//-------
function LoadBSList() {//see
		
		var url=DOMAIN + "/user/listAgentBrowse";
		var data={
			"aoid":uk(),
			"rent":getPageCT()
			
			};
		
		var success = function(data, textStatus, jqXHR){
			if (data.data != null && data.retCode == 1) {
					//console.log(data);
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
				"statName":jsonData[v].statName,
				"serialnum":jsonData[v].serialnum,
				"icount":jsonData[v].icount,
				"oid":jsonData[v].oid,
				"unitprice":GetUnitprice(jsonData[v].unitprice),
				"cdate":GetTimeText(jsonData[v].cdate)
				
            }
			
            var text=$("#BDitem").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
			$(".mine .all").html(data.data.alltimes);
			$(".mine .week").html(data.data.weektimes);
            $("#BDTJList").append(rs);
        }
		
	}	
//------
function LoadECOList(num) {//editcontrast
		
		var url=DOMAIN + "/house/houseCompare";
		var data={
			"oid":"1",
			"otherOid":"2"
			
			};
		
		var success = function(data, textStatus, jqXHR){
			if (data.data != null && data.retCode == 1) {
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
            
	}
function LoadNECOList(num) {//editcontrast
		//console.log(num)
		var url=DOMAIN + "/house/queryHouseDetail";
		var data={
			"oid":num
			
			};
		//console.log(data)
		var success = function(data, textStatus, jqXHR){
			//console.log(data)
			if (data.data != null && data.retCode == 1) {
					//console.log(data)
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
		//console.log(mt[loadmti])
		if(++loadmti < mt.length){
			//console.log(mt[loadmti])
			//console.log(mt);
			LoadNECOList(mt[loadmti]);
			}   
	}
//-------
function LoadHSList() {//plan
		
		var url=DOMAIN + "/user/listAgentBooking";
		var data={
			"aoid":uk(),
			"rent":getPageCT()
			};
		
		var success = function(data, textStatus, jqXHR){
			if (data.data != null && data.retCode == 1) {
					//console.log(data)
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
                "bookingtime":GetallTimestr(jsonData[v].bookingtime),
                "hname":jsonData[v].hname,
				"area":GetArea(jsonData[v].area),
				"orieName":jsonData[v].orieName,
				"layoutName":jsonData[v].layoutName,
				"cname":jsonData[v].cname,
				"clabels":GetLabel(jsonData[v].clabels),
				"totalprice":GetTotalprice(jsonData[v].totalprice),
				"icount":jsonData[v].icount,
				"serialnum":jsonData[v].serialnum,
				"statName":jsonData[v].statName,
				"custname":jsonData[v].custname,
				"phonenum":jsonData[v].phonenum,
				"custid":jsonData[v].custid,
				"unitprice":GetUnitprice(jsonData[v].unitprice),
				"cdate":GetTimeText(jsonData[v].cdate)
            }
			
            var text=$("#BDitem").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $("#BDTJList").append(rs);
        }
        
		
	}
	
//------cust
function LoadCUList() {//customer
		var url=DOMAIN + "/user/listAgentCust";
		var data={
			"aoid":uk(),
			"custType":getPageCT()
			};
		console.log(data);
		var success = function(data, textStatus, jqXHR){
			if (data.data != null && data.retCode == 1) {
					console.log(data)
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
				"oid":jsonData[v].oid,
				"clabels":GetLabel(jsonData[v].clabels)
				
            }
			
            var text=$("#BDitem").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $("#BDTJList").append(rs);
        }
		
	}
function LoadCustomerList() {//customerinfo
		var url=DOMAIN + "/cust/oneCustNoToken";
		var data={
			"coid":getPagecoid()
			};
		//console.log(data);
		var success = function(data, textStatus, jqXHR){
			if (data.data != null && data.retCode == 1) {
					//console.log(data)
					FillCustomeritem(data);
				}else {
					//
				}
			
		};
		$.get(url,data,success,"json");
		
		
	}
var DjsonData;
function FillCustomeritem(data) {//customer填充
		
		jsonData = data.data;
		//console.log(jsonData);		
		var row = {
			"iPath":jsonData.ipath,
			"name":jsonData.name,
			"phonenum":jsonData.phonenum,
			"oid":jsonData.oid,
			"custlabels":GetLabel(jsonData.custlabels)
		}
		
		var text=$("#customeritem").text();
		var compiled = _.template(text);
		rs=compiled(row);
		
		//console.log(JSON.stringify(jsonData));
		//console.log(jsonData);
		$(".mine").append(rs);
		
       	DjsonData = jsonData;
		DjsonData.custlabels = DjsonData.custlabels.split(",")
		//console.log(DjsonData);
		
		LoadCustomerbooking(data.token) ;
	}
function LoadCustomerbooking(id) {//customerinfo
		var url=DOMAIN + "/cust/custseen";
		var data={
			"coid":id
			};
		//console.log(data);
		var success = function(data, textStatus, jqXHR){
			if (data.data != null && data.retCode == 1) {
					//console.log(data)
					FillCustomerbooking(data);
				}else {
					//
				}
			
		};
		$.get(url,data,success,"json");
		
		
	}

function FillCustomerbooking(data) {//customer填充
		
		jsonData = data.data;
        for (v in jsonData){
			//console.log(data);		
            var row = {
				"cdate":jsonData[v].cdate,
                "iPath":jsonData[v].ipath,
                "hname":jsonData[v].hname,
				"layoutName":jsonData[v].layoutName,
				"area":jsonData[v].area,
				"orieName":jsonData[v].orieName,
				"cname":jsonData[v].cname,
				"totalprice":jsonData[v].totalprice,
				"unitprice":jsonData[v].unitprice,
				"oid":jsonData[v].oid,
				"clabels":GetLabel(jsonData[v].clabels)
				
            }
			
            var text=$("#BDitem").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $("#BDTJList").append(rs);
        }
	}
//-----------
/*function LoadHCList() {//contrast
		console.log(geth1());
		console.log(geth2());
		var url=DOMAIN + "/house/houseCompare";
		var data={
			"oid":geth1(),
			"otherOid":geth2()
			};
		
		var success = function(data, textStatus, jqXHR){
			if (data.data != null && data.retCode == 1) {
					console.log(data);
					FillHCitem(data);
				}else {
					//
				}
			
		};
		$.get(url,data,success,"json");
		
		
	}

function FillHCitem(data) {//contrast填充
		
		jsonData1 = data.data.one;	
		jsonData2 = data.data.otherOne;	
		
            var row = {
                "cipath1":jsonData1.cipath,
				"oid1":jsonData1.oid,
                "hname1":jsonData1.hname,
				"area1":GetArea(jsonData1.area),
				"cuoid1":jsonData1.cuoid,
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
				"cipath2":jsonData2.cipath,
				"oid2":jsonData2.oid,
                "hname2":jsonData2.hname,
				"area2":GetArea(jsonData2.area),
				"cuoid2":jsonData2.cuoid,
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
				"igroupoid2":jsonData2.igroupoid//--2
            }
			
            var text=$("#BDitem").text();
            var compiled = _.template(text);
            rs=compiled(row);
			
            $("#BDTJList").append(rs);
       
		
	}
*/
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
					//console.log(data1);
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
					//console.log(data2);
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
                "cipath1":jsonData1.cipath,
				"oid1":jsonData1.oid,
                "hname1":jsonData1.hname,
				"area1":GetArea(jsonData1.area),
				"cuoid1":jsonData1.cuoid,
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
				"zxground1":displayQTvalue (jsonData1.houseQtList,"1111"),
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
				"jdds1":displayQTvalue (jsonData1.houseQtList,"1111"),
				"jdxyj1":displayQTvalue (jsonData1.houseQtList,"1111"),
				"jdkt1":displayQTvalue (jsonData1.houseQtList,"1111"),
				"jdcyyj1":displayQTvalue (jsonData1.houseQtList,"1111"),
				"jdmqz1":displayQTvalue (jsonData1.houseQtList,"1111"),
				"jdrsq1":displayQTvalue (jsonData1.houseQtList,"1111"),
				"jdyg1":displayQTvalue (jsonData1.houseQtList,"1111"),
				"jdmt1":displayQTvalue (jsonData1.houseQtList,"1111"),
				"jdhs1":displayQTvalue (jsonData1.houseQtList,"1111"),
				"livingroom1":displayparam (jsonData1.paramList,"客厅"),
				"restaurant1":displayparam (jsonData1.paramList,"餐厅"),
				"kitchen1":displayparam (jsonData1.paramList,"厨房"),
				"bedroom1":displayparam (jsonData1.paramList,"卧室"),
				"bedroom2":displayparam (jsonData1.paramList,"1111"),
				"bedroom3":displayparam (jsonData1.paramList,"1111"),
				"bedroom4":displayparam (jsonData1.paramList,"1111"),
				"toilet11":displayparam (jsonData1.paramList,"卫生间"),
				"toilet21":displayparam (jsonData1.paramList,"1111"),
				"toilet31":displayparam (jsonData1.paramList,"1111"),
				"balcony11":displayparam (jsonData1.paramList,"阳台"),
				"balcony21":displayparam (jsonData1.paramList,"1111"),
				"balcony31":displayparam (jsonData1.paramList,"1111"),
				"area11":displayparam (jsonData1.paramList,"建筑产权面积"),
				"area21":displayparam (jsonData1.paramList,"套内产权面积"),
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
				"cipath2":jsonData2.cipath,
				"oid2":jsonData2.oid,
                "hname2":jsonData2.hname,
				"area2":GetArea(jsonData2.area),
				"cuoid2":jsonData2.cuoid,
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
				"zxground2":displayQTvalue (jsonData2.houseQtList,"1111"),
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
				"jdds2":displayQTvalue (jsonData2.houseQtList,"1111"),
				"jdxyj2":displayQTvalue (jsonData2.houseQtList,"1111"),
				"jdkt2":displayQTvalue (jsonData2.houseQtList,"1111"),
				"jdcyyj2":displayQTvalue (jsonData2.houseQtList,"2222"),
				"jdmqz2":displayQTvalue (jsonData2.houseQtList,"2222"),
				"jdrsq2":displayQTvalue (jsonData2.houseQtList,"2222"),
				"jdyg2":displayQTvalue (jsonData2.houseQtList,"2222"),
				"jdmt2":displayQTvalue (jsonData2.houseQtList,"2222"),
				"jdhs2":displayQTvalue (jsonData2.houseQtList,"2222"),
				"livingroom2":displayparam (jsonData2.paramList,"客厅"),
				"restaurant2":displayparam (jsonData2.paramList,"餐厅"),
				"kitchen2":displayparam (jsonData2.paramList,"厨房"),
				"bedroom2":displayparam (jsonData2.paramList,"卧室"),
				"bedroom2":displayparam (jsonData2.paramList,"2222"),
				"bedroom3":displayparam (jsonData2.paramList,"2222"),
				"bedroom4":displayparam (jsonData2.paramList,"2222"),
				"toilet12":displayparam (jsonData2.paramList,"卫生间"),
				"toilet22":displayparam (jsonData2.paramList,"2222"),
				"toilet32":displayparam (jsonData2.paramList,"2222"),
				"balcony12":displayparam (jsonData2.paramList,"阳台"),
				"balcony22":displayparam (jsonData2.paramList,"2222"),
				"balcony32":displayparam (jsonData2.paramList,"2222"),
				"area12":displayparam (jsonData2.paramList,"建筑产权面积"),
				"area22":displayparam (jsonData2.paramList,"套内产权面积"),
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
					QTvalue += "<h6 class='mpclear'>"
					QTvalue += data[v].children[m].children[c].sclazzname;
					QTvalue += QTdisplay(data[v].children[m].children[c].result,data[v].children[m].children[c].igroupoid);
					QTvalue += "</h6><br>";
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
//-----
function LoadUsermsg() {//customerinfo
		var url=DOMAIN + "/msg/countUnreadMessageByToUserIdGroupByFromUserId";
		var data={
			"toUserId":getPageoid()
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
function loadmsguser (data) {

	var url=DOMAIN + "/cust/oneCustNoToken";
		var data={
			"coid":data.data[vpmsg].fromuserid
			};
		//console.log(data);
		var success = function(data, textStatus, jqXHR){
			//console.log(data)
			if (data.data != null && data.retCode == 1) {
					vpmsguser = data.data.name;
					vpmsgipath = data.data.ipath;
					FillmsgList(msguserdata);
				}else {
					////console.log(msguserdata.data.length)
					if(++vpmsg < msguserdata.data.length){
						//console.log(vpmsg)
			        	loadmsguser(msguserdata);
			        }
				}
			
		};
		$.post(url,data,success,"json");
}
function FillmsgList(data) {//customer填充
		
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