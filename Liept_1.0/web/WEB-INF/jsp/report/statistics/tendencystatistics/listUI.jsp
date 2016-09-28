﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->

		<script src="${basePath}/assets/js/ace-extra.min.js"></script>
		<script src="${basePath}/assets/js/echarts.common.min.js"></script>

		<script type="text/javascript">

			var checkTenencyOption = {
				tooltip : {
					trigger: 'axis'
				},
				legend: {
					data:[]
				},
				toolbox: {
					show : true,
					feature : {
						saveAsImage : {show: true}
					}
				},
				calculable : true,
				xAxis : [
					{
						type : 'category',
						data : []
					}
				],
				yAxis : [
					{
						type : 'value'
					}
				],
				series : [
					{
						name:'1号车间',
						type:'bar',
						data:[80],
					},
				]
			};

			var leakTendencyOption = {
				tooltip : {
					trigger: 'axis'
				},
				legend: {
					data:[]
				},
				toolbox: {
					show : true,
					feature : {
						saveAsImage : {show: true}
					}
				},
				calculable : true,
				xAxis : [
					{
						type : 'category',
						data : []
					}
				],
				yAxis : [
					{
						type : 'value'
					}
				],
				series : [
					{
						name:'1号车间',
						type:'bar',
						data:[80],
					},
				]
			};

			var repairTendencyOption  ={
				tooltip : {
					trigger: 'axis'
				},
				legend: {
					data:[]
				},
				toolbox: {
					show : true,
					feature : {
						saveAsImage : {show: true}
					}
				},
				calculable : true,
				xAxis : [
					{
						type : 'category',
						data : []
					}
				],
				yAxis : [
					{
						type : 'value'
					}
				],
				series : [
					{
						name:'1号车间',
						type:'bar',
						data:[80],
					},
				]
			};

			window.onload = function(){

				var chartForCheckTendency = echarts.init(document.getElementById('checkTenency'));
				var chartForLeakTendency= echarts.init(document.getElementById('leakTendency'));
				var chartForRepairTendency = echarts.init(document.getElementById('repairTendency'));

				loadDataForChart();

				chartForCheckTendency.setOption(checkTenencyOption);
				chartForLeakTendency.setOption(leakTendencyOption);
				chartForRepairTendency.setOption(repairTendencyOption);

			}



			function loadDataForChart(){

				$.ajax({
					url:"${basePath}/report/statistics/tendency_statistics_statisticCheckTendency.action",
					data:{},
					type: "get",
					async: false,
					dataType:"json",
					success: function(data){  //data 为JSON对象

						checkTenencyOption.xAxis[0].data = data.yearNames;
						checkTenencyOption.series = data.deviceToNumberList;
					},
					error: function(data){
						alert("统计发生异常！");
					}
				});

				$.ajax({
					url:"${basePath}/report/statistics/tendency_statistics_statisticLeakTendency.action",
					data:{},
					type: "get",
					async: false,
					dataType:"json",
					success: function(data){  //data 为JSON对象
						leakTendencyOption.xAxis[0].data = data.yearNames;
						leakTendencyOption.series = data.deviceToNumberList;

					},
					error: function(data){
						alert("统计发生异常！");
					}
				});

				$.ajax({
					url:"${basePath}/report/statistics/tendency_statistics_statisticRepairTendency.action",
					data:{},
					type: "get",
					async: false,
					dataType:"json",
					success: function(data){  //data 为JSON对象
						repairTendencyOption.xAxis[0].data = data.yearNames;
						repairTendencyOption.series = data.deviceToNumberList;

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
							<li  class="active">趋势统计</li>
						</ul>
					</div>  <!-- .结束导航栏 -->

					<div class="page-content">     <!-- 右边内容界面的导航栏下的内容主界面-->
						<div class="row">
							<div class="col-md-8 col-md-offset-2">
								<center><h3 class="text-primary">检测趋势图</h3></center>
								<div id="checkTenency" style="height:400px;"></div>
							</div>
						</div>

						<hr>

						<div class="row">
							<div class="col-md-8 col-md-offset-2">
								<center><h3 class="text-primary">泄漏点趋势图</h3></center>
								<div id="leakTendency" style="height:400px;"></div>
							</div>
						</div>

						<hr>

						<div class="row">
							<div class="col-md-8 col-md-offset-2">
								<center><h3 class="text-primary">修复点趋势图</h3></center>
								<div id="repairTendency" style="height:400px;"></div>
							</div>
						</div>
						<hr>

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

		<!-- inline scripts related to this page -->

		<script type="text/javascript">
			jQuery(function ($) {
				<!-- 全选checkbox-->
				$('table th input:checkbox').on('click', function () {
					var that = this;
					$(this).closest('table').find('tr > td:first-child input:checkbox')
							.each(function () {
								this.checked = that.checked;
								$(this).closest('tr').toggleClass('selected');
							});

				});

			})
		</script>
		<div style="display:none">
			<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'>
			</script>
		</div>
	</body>
</html>

