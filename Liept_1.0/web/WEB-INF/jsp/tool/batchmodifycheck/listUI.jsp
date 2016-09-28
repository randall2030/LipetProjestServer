﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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


	<link rel="stylesheet" href="${basePath}/assets/css/ace.min.css" />
	<link rel="stylesheet" href="${basePath}/assets/css/ace-rtl.min.css" />
	<link rel="stylesheet" href="${basePath}/assets/css/ace-skins.min.css" />

	<!--[if lte IE 8]>
	<link rel="stylesheet" href="${basePath}/assets/css/ace-ie.min.css" />
	<![endif]-->

	<script src="${basePath}/assets/js/ace-extra.min.js"></script>
	<script src="${basePath}/js/jquery.min.js"></script>

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

	<!--[if lt IE 9]>
	<script src="${basePath}/assets/js/html5shiv.js"></script>
	<script src="${basePath}/assets/js/respond.min.js"></script>
	<![endif]-->

	<script type="text/javascript">

		window.onload = function () {
			$.ajax({
				url: "${basePath}/paramsetting/modelinfosetting/device_manage_findDeviceName.action",
				data: {},
				type: "get",
				async: false,
				dataType: "json",
				success: function (backData) {
					var size = backData.length;
					for (var i = 0; i < size; i++) {
						var deviceName = backData[i];
						if (deviceName != null && deviceName != "") {
							var $option = $("<option>" + deviceName + "</option>");
							$("#deviceList").append($option);
						}
					}
				},
				error: function (data) {
					alert("获取装置类型发生异常");
				}
			});


			$.ajax({
				url: "${basePath}/paramsetting/modelinfosetting/area_manage_findAreaName.action",
				data: {},
				type: "get",
				async: false,
				dataType: "json",
				success: function (backData) {
					var size = backData.length;
					for (var i = 0; i < size; i++) {
						var areaName = backData[i];
						if (areaName != null && areaName != "") {
							var $option = $("<option>" + areaName + "</option>");
							$("#areaList").append($option);
						}
					}
				},
				error: function (data) {
					alert("获取区域类型发生异常");
				}
			});
		}

		function doQuery() {
			document.getElementById("from-query").submit();
		}


	</script>

</head>

<body>

<%@ include file="../../parentPage/topNavigation.jsp" %>

<div class="main-container" id="main-container">
	<script type="text/javascript">
		try{ace.settings.check('main-container' , 'fixed')}catch(e){}
	</script>
	<div class="main-container-inner">             <!-- 还true最外层-->
		<%@ include file="../../parentPage/toolLeftListNavigation.jsp" %>
		<div class="main-content">             <!-- 右边内容界面-->

			<div class="breadcrumbs" id="breadcrumbs">  <!-- 右边内容界面的导航栏-->
				<script type="text/javascript">
					try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
				</script>

				<ul class="breadcrumb">
					<li>
						<i class="icon-home home-icon"></i>
						<a     href="#">工具</a>
					</li>
					<li class="active">批量修改检测</li>
				</ul>
			</div>  <!-- .结束导航栏 -->


			<div class="page-content">     <!-- 右边内容界面的导航栏下的内容主界面-->


				<div class="well">
					<!-- 折叠控件-->
					<div id="accordion" class="accordion-style1 panel-group">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion"
									   href="#collapseOne">
										<i class="icon-angle-down bigger-110" data-icon-hide="icon-angle-down"
										   data-icon-show="icon-angle-right"></i>
										<!-- 标题-->
										过滤条件
									</a>
								</h4>
							</div>

							<div class="panel-collapse collapse in" id="collapseOne">
								<div class="panel-body">
									<!-- 内容-->
									<form class="form-vertical" id="from-query" role="form" method="post"
										  action="${basePath}/tool/batch_modify_check_listUI.action?pageNo=1">

										<div class="form-group center">
											<label> 装置：</label>
											<select id="deviceList" name="module.device">
												<option value="">全部</option>
											</select>
											&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
											<label>区域：</label>
											<select id="areaList" name="module.area">
												<option value="">全部</option>
											</select>
											&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
											<label>标签号：</label>
											<input type="text" name="module.labelNumber" size="15px">
											&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
											<label>组件类型：</label>
											<select name="module.modelType">
												<option value="">全部</option>
												<option>搅拌器（轴封）</option>
												<option>连接件（螺纹连接）</option>
												<option>法兰</option>
												<option>开口阀或开口管线</option>
												<option>泵（轴封）</option>
												<option>泄压设备（安全阀）</option>
												<option>取样连接系统</option>
												<option>阀门</option>
												<option>压缩机（轴封）</option>
												<option>其他</option>
											</select> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
											<label>难于检测：</label>
											<input type="radio" id="#0" name="module.diffToCheck"
												   value="true"><label
												for="#0">是</label>
											<input type="radio" id="#00" name="module.diffToCheck"
												   value="false"><label
												for="#00">否</label>
											<input type="radio" id="#000" name="module.diffToCheck" value="all"
												   checked="checked"><label for="#000">所有</label>
										</div>

										<div class="form-group align-right">
											<button class="btn btn-info" type="button" onclick="doQuery()">
												<i class=" icon-key align-top bigger-125"></i>
												查询
											</button>
											&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
											&nbsp; &nbsp; &nbsp;
										</div>
									</form>
								</div>
							</div>

						</div>

					</div><!-- /span -->


				</div>

				<div class="well">
					<h5 class="green smaller lighter">组件信息
						<%--<button style="margin-right: 20px;float: right;" class="btn btn-info" type="button" onclick="doModifyAll()">批量修改</button>--%>
					</h5>

					<form id="from-device_types"  method="post">
						<table id="sample-table-1" class="table table-striped table-bordered table-hover">
						<thead>
						<tr>
							<th>装置 </th>
							<th>设备</th>
							<th>标签号</th>
							<th>扩展号 </th>
							<th>组件类型</th>
							<th>尺寸(mm)</th>
							<th>PID图号 </th>
							<th>是否泄漏</th>
						</tr>
						</thead>

						<tbody>
						<s:iterator value="pageResult.items" status="st">
						<tr>
							<td>
								<s:property value="device"/>
							</td>

							<td ><s:property value="equipment"/></td>

							<td><s:property value="labelNumber"/></td>

							<td >
								<s:property value="extendNumber"/>
							</td>

							<td >
								<s:property value="modelType"/>
							</td>

							<td>
								<s:property value="sizeMM"/>
							</td>

							<td><s:property value="pid"/></td>

							<td >
								<s:property value="leak=='true'?'是':'否'"/>
							</td>

						</tr>

						</tbody>
						</s:iterator>

						</table>

					</form>


					<form id="form_pageNavigator" action="${basePath}/tool/batch_modify_module_listUI.action">
						<s:hidden name="module.device"/>
						<s:hidden name="module.area"/>
						<s:hidden name="module.modelType"/>
						<s:hidden name="module.diffToCheck"/>
						<s:hidden name="module.labelNumber"/>
						<jsp:include page="/base/pageNavigator.jsp"></jsp:include>
					</form>

				</div>

			</div><!-- /.main-content -->


		</div>
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
