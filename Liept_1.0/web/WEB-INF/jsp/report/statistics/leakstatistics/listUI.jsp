<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	pageContext.setAttribute("basePath", request.getContextPath());
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>LDAR后台管理系统</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<!-- basic styles -->
		<link href="${basePath}/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${basePath}/assets/css/font-awesome.min.css" />
		<!--[if IE 7]>
		  <link rel="stylesheet" href="${basePath}/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

		<!-- page specific plugin styles -->

		<!-- fonts -->

		<link rel="stylesheet" href="${basePath}/assets/css/font-down-google.css"/>

		<!-- ace styles -->

		<link rel="stylesheet" href="${basePath}/assets/css/ace.min.css" />
		<link rel="stylesheet" href="${basePath}/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="${basePath}/assets/css/ace-skins.min.css" />

		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="${basePath}/assets/css/ace-ie.min.css" />
		<![endif]-->
		<script src="${basePath}/assets/js/ace-extra.min.js"></script>
		<script src="${basePath}/assets/js/echarts.common.min.js"></script>


		<script type="text/javascript">
			var LeakAndLeakPercentOption = {
				tooltip: {
					trigger: 'axis'
				},
				toolbox: {
					feature: {
						saveAsImage: {show: true}
					}
				},
				legend: {
					data:['泄露点数','泄漏率']
				},
				xAxis: [
					{
						type : "category",
						data : []
					}
				],
				yAxis: [
					{
						type: 'value',
						name: '泄露点数',
						axisLabel: {
							formatter: '{value} '
						}
					},
					{
						type: 'value',
						name: '泄漏率',
						axisLabel: {
							formatter: '{value} °%'
						}
					}
				],
				series: [
					{
						name:'泄露点数',
						type:'bar',
						data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
					},
					{
						name:'泄漏率',
						type:'bar',
						data:[2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2]
					}
				]
			};

			var RepairAndRepairPercentOption  = {
				tooltip: {
					trigger: 'axis'
				},
				toolbox: {
					feature: {
						saveAsImage: {show: true}
					}
				},
				legend: {
					data:['修复点数','修复率']
				},
				xAxis: [
					{
						type: 'category',
						data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
					}
				],
				yAxis: [
					{
						type: 'value',
						name: '修复点数',
						min: 0,
						max: 250,
						interval: 50,
						axisLabel: {
							formatter: '{value} '
						}
					},
					{
						type: 'value',
						name: '修复率',
						min: 0,
						max: 25,
						interval: 5,
						axisLabel: {
							formatter: '{value} °%'
						}
					}
				],
				series: [
					{
						name:'修复点数',
						type:'bar',
						data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
					},
					{
						name:'修复率',
						type:'line',
						yAxisIndex: 1,
						data:[2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2]
					}
				]
			};


			var LeakPointAllocateOption =  {
				title : {
					text: '泄漏点分布',
					subtext: '',
					x:'center'
				},
				tooltip : {
					trigger: 'item',
					formatter: "{a} <br/>{b} : {c} ({d}%)"
				},
				toolbox: {
					feature: {
						saveAsImage: {show: true}
					}
				},
				legend: {
					orient: 'vertical',
					left: 'left',
					data: ['常规检测','难于检测']
				},
				series : [
					{
						name: '组件',
						type: 'pie',
						radius : '55%',
						center: ['50%', '60%'],
						data:[
							{value:335, name:'常规检测点'},
							{value:310, name:'难于检测点'},
						],
						itemStyle: {
							emphasis: {
								shadowBlur: 10,
								shadowOffsetX: 0,
								shadowColor: 'rgba(0, 0, 0, 0.5)'
							}
						}
					}
				]
			};




			window.onload = function(){

				var chartForLeakAndLeakPercent = echarts.init(document.getElementById('leakAndLeakPercentByDevice'));
				var chartForRepairAndRepairPercent= echarts.init(document.getElementById('repairAndRepairPercentByDevice'));
				var chartForLeakPointAllocate = echarts.init(document.getElementById('leakPointAllocate'));

				loadDataForChart();

				chartForLeakAndLeakPercent.setOption(LeakAndLeakPercentOption);
				chartForRepairAndRepairPercent.setOption(RepairAndRepairPercentOption);
				chartForLeakPointAllocate.setOption(LeakPointAllocateOption);

			}

			function loadDataForChart(){

				$.ajax({
					url:"${basePath}/report/statistics/leak_statistics_statisticLeakAndLeakPercent.action",
					data:{},
					type: "get",
					async: false,
					dataType:"json",
					success: function(data){  //data 为JSON对象
						LeakAndLeakPercentOption.xAxis[0].data = data.titles;
						LeakAndLeakPercentOption.series[0].data = data.pointNumbers;
						LeakAndLeakPercentOption.series[1].data = data.percentValues;
					},
					error: function(data){
						alert("统计发生异常！");
					}
				});

				$.ajax({
					url:"${basePath}/report/statistics/leak_statistics_statisticRepairAndRepairPercent.action",
					data:{},
					type: "get",
					async: false,
					dataType:"json",
					success: function(data){
						RepairAndRepairPercentOption.xAxis[0].data = data.titles;
						RepairAndRepairPercentOption.series[0].data = data.pointNumbers;
						RepairAndRepairPercentOption.series[1].data = data.percentValues;
					},
					error: function(data){
						alert("统计发生异常！");
					}
				});


				$.ajax({
					url:"${basePath}/report/statistics/leak_statistics_statisticLeakPointAllocate.action",
					data:{},
					type: "get",
					async: false,
					dataType:"json",
					success: function(data){  //data 为JSON对象
						LeakPointAllocateOption.legend.data = data.titles;   //要的是对象， 不是字符串
						LeakPointAllocateOption.series[0].data = data.statisticInfo;

					},
					error: function(data){
						alert("统计发生异常！");
					}
				});


			}


		</script>
	</head>

	<body>

	<%@ include file="../../../parentPage/topNavigation.jsp" %>
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>
			
			<div class="main-container-inner">             <!-- 还是最外层-->
				<%@ include file="../../../parentPage/reportLeftListNavigation.jsp" %>

				<div class="main-content">             <!-- 右边内容界面-->
				
					<div class="breadcrumbs" id="breadcrumbs">  <!-- 右边内容界面的导航栏-->
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="#">报告</a>
							</li>
							<li>统计</li>
							<li  class="active">泄露统计</li>
						</ul>
					</div>  <!-- .结束导航栏 -->
					
					<div class="page-content">     <!-- 右边内容界面的导航栏下的内容主界面-->
						<div class="row">
							<div class="col-md-12">
								<center><h3 class="text-primary">泄漏点数和泄漏率统计图-按装置</h3></center>
								<div id="leakAndLeakPercentByDevice" style="height:400px;"></div>
							</div>
						</div>
						<hr>
						<div class="row">
							<div class="col-md-12">
								<center><h3 class="text-primary">修复点数和修复率统计图-按装置</h3></center>
								<div id="repairAndRepairPercentByDevice" style="height:400px;"></div>
							</div>
						</div>
						<hr>
						<div class="row">
							<div class="col-md-8 col-md-offset-2">
								<center><h3 class="text-primary">泄漏点分布</h3></center>
								<div id="leakPointAllocate" style="height:400px;"></div>
							</div>
						</div>
					</div>
					
				</div><!-- /.main-content -->  
			
			</div>
		</div>

		<script type="text/javascript">
			window.jQuery || document.write("<script src='${basePath}/assets/js/jquery-2.0.3.min.js'>" + "<" + "script>");
		</script>


		<script type="text/javascript">
			if ("ontouchend" in document) document.write("<script src='${basePath}/assets/js/jquery.mobile.custom.min.js'>" + "<" + "script>");
		</script>
		<script src="${basePath}/assets/js/bootstrap.min.js"></script>
		<script src="${basePath}/assets/js/typeahead-bs2.min.js"></script>

		<!-- page specific plugin scripts -->

		<!--[if lte IE 8]>
		<script src="${basePath}/assets/js/excanvas.min.js"></script>
		<![endif]-->

		<script src="${basePath}/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
		<script src="${basePath}/assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="${basePath}/assets/js/jquery.slimscroll.min.js"></script>
		<script src="${basePath}/assets/js/jquery.sparkline.min.js"></script>
		<script src="${basePath}/assets/js/flot/jquery.flot.min.js"></script>
		<script src="${basePath}/assets/js/flot/jquery.flot.pie.min.js"></script>
		<script src="${basePath}/assets/js/flot/jquery.flot.resize.min.js"></script>

		<!-- ace scripts -->

		<script src="${basePath}/assets/js/ace-elements.min.js"></script>
		<script src="${basePath}/assets/js/ace.min.js"></script>

		<div style="display:none">
			<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'>
			</script>
		</div>
	</body>
</html>

