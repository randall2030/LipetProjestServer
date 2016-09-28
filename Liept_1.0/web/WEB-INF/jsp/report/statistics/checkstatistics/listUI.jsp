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


		<link rel="stylesheet" href="${basePath}/assets/css/font-down-google.css"/>

		<!-- ace styles -->

		<link rel="stylesheet" href="${basePath}/assets/css/ace.min.css" />
		<link rel="stylesheet" href="${basePath}/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="${basePath}/assets/css/ace-skins.min.css" />

		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="${basePath}/assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->

		<script src="${basePath}/assets/js/ace-extra.min.js"></script>


		<script src="${basePath}/assets/js/echarts.common.min.js"></script>

		<script type="text/javascript">

			var ppmAllocateOption = {

				tooltip : {
					trigger: 'xAxis',
					axisPointer : {            // 坐标轴指示器，坐标轴触发有效
						type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
					}
				},
				toolbox: {
					feature: {
						saveAsImage: {show: true}
					}
				},
				legend: {
					data: ['500≤ppm<1000', '1000≤ppm<2000','2000≤ppm<5000','5000≤ppm<10000','10000≤ppm<50000','50000≤ppm']
				},
				grid: {
					left: '3%',
					right: '4%',
					bottom: '3%',
					containLabel: true
				},
				yAxis:  {
					type: 'value'
				},
				xAxis: {
					type: 'category',
					data: ['周一','周二','周三','周四','周五','周六','周日']
				},
				series: [
					{
						name: '500≤ppm<1000',
						type: 'bar',
						stack: '总量',
						label: {
							normal: {
								show: true,
								position: 'insideRight'
							}
						},
						data: [320, 302, 301, 334, 390, 330, 320]
					},
					{
						name: '1000≤ppm<2000',
						type: 'bar',
						stack: '总量',
						label: {
							normal: {
								show: true,
								position: 'insideRight'
							}
						},
						data: [120, 132, 101, 134, 90, 230, 210]
					},
					{
						name: '2000≤ppm<5000',
						type: 'bar',
						stack: '总量',
						label: {
							normal: {
								show: true,
								position: 'insideRight'
							}
						},
						data: [220, 182, 191, 234, 290, 330, 310]
					},
					{
						name: '5000≤ppm<10000',
						type: 'bar',
						stack: '总量',
						label: {
							normal: {
								show: true,
								position: 'insideRight'
							}
						},
						data: [150, 212, 201, 154, 190, 330, 410]
					},
					{
						name: '10000≤ppm<50000',
						type: 'bar',
						stack: '总量',
						label: {
							normal: {
								show: true,
								position: 'insideRight'
							}
						},
						data: [820, 832, 901, 934, 1290, 1330, 1320]
					},
					{
						name: '50000≤ppm',
						type: 'bar',
						stack: '总量',
						label: {
							normal: {
								show: true,
								position: 'insideRight'
							}
						},
						data: [820, 832, 901, 934, 1290, 1330, 1320]
					}
				]
			};

			var checkPointNumberOption = {
				title: {
					text: '检测点数(按装置)',
				},
				tooltip : {
					trigger: 'axis',
					axisPointer : {            // 坐标轴指示器，坐标轴触发有效
						type : 'line'        // 默认为直线，可选为：'line' | 'shadow'
					},
					formatter: function (params) {
						var tar = params[1];
						return tar.name + '<br/>' + tar.seriesName + ' : ' + tar.value;
					}
				},
				toolbox: {
					feature: {
						saveAsImage: {show: true}
					}
				},
				grid: {
					left: '3%',
					right: '4%',
					bottom: '3%',
					containLabel: true
				},
				xAxis: {
					type : 'category',
					splitLine: {show:false},
					data : ['总费用','房租','水电费','交通费','伙食费','日用品数']
				},
				yAxis: {
					type : 'value'
				},
				series: [
					{
						name: '辅助',
						type: 'bar',
						stack:  '总量',
						itemStyle: {
							normal: {
								barBorderColor: 'rgba(0,0,0,0)',
								color: 'rgba(0,0,0,0)'
							},
							emphasis: {
								barBorderColor: 'rgba(0,0,0,0)',
								color: 'rgba(0,0,0,0)'
							}
						},
						data: [0, 0, 0, 0, 0, 0]
					},
					{
						name: '数量',
						type: 'bar',
						stack: '总量',
						label: {
							normal: {
								show: true,
								position: 'inside'
							}
						},
						data:[2900, 1200, 300, 200, 900, 300]
					}
				]
			};


			window.onload = function(){

				var chartForPPMAllocate = echarts.init(document.getElementById('checkPPMAllocate'));
				var chartForCheckPoint = echarts.init(document.getElementById('checkNumberByDevice'));

				loadDataForChart();

				chartForPPMAllocate.setOption(ppmAllocateOption);
				chartForCheckPoint.setOption(checkPointNumberOption);

			}

			function loadDataForChart(){
				$.ajax({
					url:"${basePath}/report/statistics/check_statistics_statisticForPPMAllocate.action",
					data:{},
					type: "get",
					async: false,
					dataType:"json",
					success: function(data){  //data 为JSON对象
						ppmAllocateOption.xAxis.data = data.devceNames;   //要的是对象， 不是字符串
						ppmAllocateOption.series[0].data = data.ppm500To1000;
						ppmAllocateOption.series[1].data = data.ppm1000To2000;
						ppmAllocateOption.series[2].data = data.ppm2000To5000;
						ppmAllocateOption.series[3].data = data.ppm5000To10000;
						ppmAllocateOption.series[4].data = data.ppm10000To50000;
						ppmAllocateOption.series[5].data = data.ppm5000Up;

					},
					error: function(data){
						alert("统计发生异常！");
					}
				});

				$.ajax({
					url:"${basePath}/report/statistics/check_statistics_statisticCheckPointByDevice.action",
					data:{},
					type: "get",
					async: false,
					dataType:"json",
					success: function(data){  //data 为JSON对象
						checkPointNumberOption.xAxis.data = data.titles;   //要的是对象， 不是字符串
						checkPointNumberOption.series[0].data = data.yHeight;
						checkPointNumberOption.series[1].data = data.statisticInfo;
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
							<li  class="active">检测统计</li>
						</ul>
					</div>  <!-- .结束导航栏 -->

					<div class="page-content">     <!-- 右边内容界面的导航栏下的内容主界面-->
						<div class="row">
							<div class="col-md-8 col-md-offset-2">
								<center><h3 class="text-primary">检测点数-按装置</h3></center>
								<div id="checkNumberByDevice" style="height:400px;"></div>
							</div>
						</div>
						<hr>
						<div class="row">
							<div class="col-md-8 col-md-offset-2">
								<center><h3 class="text-primary">500ppm以上不同VOCs浓度区间监测点分布</h3></center>
								<div id="checkPPMAllocate" style="height:500px; width:800px"></div>
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

		<!- ace scripts -->

		<script src="${basePath}/assets/js/ace-elements.min.js"></script>
		<script src="${basePath}/assets/js/ace.min.js"></script>


		<div style="display:none">
			<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'>
			</script>
		</div>
	</body>
</html>

