<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	pageContext.setAttribute("basePath", request.getContextPath()+"/") ;
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

		<link rel="stylesheet" href="${basePath}/assets/css/font-down-google.css"/>

		<link rel="stylesheet" href="${basePath}/assets/css/ace.min.css" />
		<link rel="stylesheet" href="${basePath}/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="${basePath}/assets/css/ace-skins.min.css" />

		<script src="${basePath}/assets/js/echarts.common.min.js"></script>

		<script type="text/javascript">

			var DiffOrEasyOption =  {
				title : {
					text: '密封点统计(是否难于检测)',
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
						name: '密封点',
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


			var ModuleTypeOption = {
				title : {
					text: '密封点统计(按密封点类型)',
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
							left: 'right',
							data: ['常规检测点','难于检测点']
				},
				series : [
					{
						name: '密封点',
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


			var DeviceOption = {
				title: {
					text: '密封点分布(按装置)',
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


			window.onload=function(){

				var chartForDiffOrEasy = echarts.init(document.getElementById('contatin-for-diff-or-easy'));
				var chartForModuleType = echarts.init(document.getElementById('contatin-for-module-type'));
				var chartForDevice = echarts.init(document.getElementById('contatin-for-device'));

				loadDataForChart();

				chartForDiffOrEasy.setOption(DiffOrEasyOption);
				chartForModuleType.setOption(ModuleTypeOption);
				chartForDevice.setOption(DeviceOption);

			}


			function loadDataForChart(){

				$.ajax({
					url:"${basePath}/report/statistics/module_statistics_statisticForDiffOrEasy.action",
					data:{},
					type: "get",
					async: false,
					dataType:"json",
					success: function(data){  //data 为JSON对象
						DiffOrEasyOption.legend.data = data.titles;   //要的是对象， 不是字符串
						DiffOrEasyOption.series[0].data = data.statisticInfo;

					},
					error: function(data){
						alert("统计发生异常！");
					}
				});

				$.ajax({
					url:"${basePath}/report/statistics/module_statistics_statisticForModuleType.action",
					data:{},
					type: "get",
					async: false,
					dataType:"json",
					success: function(data){  //data 为JSON对象
						ModuleTypeOption.legend.data = data.titles;   //要的是对象， 不是字符串
						ModuleTypeOption.series[0].data = data.statisticInfo;

					},
					error: function(data){
						alert("统计发生异常！");
					}
				});

				$.ajax({
					url:"${basePath}/report/statistics/module_statistics_statisticForDevice.action",
					data:{},
					type: "get",
					async: false,
					dataType:"json",
					success: function(data){  //data 为JSON对象
						DeviceOption.xAxis.data = data.titles;   //要的是对象， 不是字符串
						DeviceOption.series[0].data = data.yHeight;
						DeviceOption.series[1].data = data.statisticInfo;
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
					<div class="page-content">     <!-- 右边内容界面的导航栏下的内容主界面-->
						<div class="row">
							<div class="col-md-5">
								<center><h3 class="text-primary">密封点统计(是否难于检测)</h3></center>
								<div id="contatin-for-diff-or-easy" style="height:500px;"></div>
							</div>
							<div class="col-md-7">
								<center><h3 class="text-primary">密封点统计(按密封点类型)</h3></center>
								<div id="contatin-for-module-type" style="height:500px;"></div>
							</div>
						</div>
						<hr>
						<div class="row">
							<div class="col-md-8 col-md-offset-2">
								<center><h3 class="text-primary">密封点分布(按装置)</h3></center>
								<div id="contatin-for-device" style="height:400px;"></div>
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
		<script>

		</script>
		<div style="display:none">
			<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'>
			</script>

		</div>
	</body>
</html>

