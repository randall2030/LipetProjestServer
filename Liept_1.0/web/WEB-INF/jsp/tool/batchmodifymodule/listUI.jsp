<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    pageContext.setAttribute("basePath", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>LDAR后台管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <!-- basic styles -->
    <link href="${basePath}/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${basePath}/assets/css/font-awesome.min.css"/>



    <link rel="stylesheet" href="${basePath}/assets/css/font-down-google.css"/>
	<link rel="stylesheet" href="${basePath}/css/jquery-ui-1.10.3.custom.min.css" />
	<link rel="stylesheet" href="${basePath}/css/jquery.gritter.css" />

    <!-- ace styles -->
    <link rel="stylesheet" href="${basePath}/assets/css/ace.min.css"/>
    <link rel="stylesheet" href="${basePath}/assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="${basePath}/assets/css/ace-skins.min.css"/>

    <!--[if lte IE 8]>
    <link rel="stylesheet" href="${basePath}/assets/css/ace-ie.min.css"/>
    <![endif]-->

    <script src="${basePath}/assets/js/ace-extra.min.js"></script>
    <script src="${basePath}/js/jquery.min.js"></script>

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
					<li class="active">批量修改</li>
				</ul>
			</div>  <!-- .结束导航栏 -->


			<div class="page-content">     <!-- 右边内容界面的导航栏下的内容主界面-->


				<div class="well">
					<!-- 折叠控件-->
					<div id="accordion2" class="accordion-style1 panel-group">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion"
									   href="#collapseOne">
										<i class="icon-angle-down bigger-110" data-icon-hide="icon-angle-down"
										   data-icon-show="icon-angle-right"></i>
										<!-- 标题-->
										批量修改
									</a>
								</h4>
							</div>

							<div class="panel-collapse collapse in" id="collapseOne2">
								<div class="panel-body">
									<h5 class="blue smaller lighter">修改前，请先查询出要修改的组件！！</h5>
									<button class="btn btn-info" style="margin-left: 200px" id="modify_device">批量修改装置</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<button class="btn btn-info" id="modify_sizeMM">批量修改尺寸</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<button class="btn btn-info" id="modify_PIDNumber">批量修改PID图号</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<button class="btn btn-info" id="modify_module_type">批量修改密封点类型</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<button class="btn btn-info" id="modify_equipment">批量修改设备</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

								</div>
							</div>

						</div>

					</div><!-- /span -->


				</div>

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
										  action="${basePath}/tool/batch_modify_module_listUI.action?pageNo=1">

										<div class="form-group center">
											<label> 装置：</label>
											<select id="deviceList" name="module.device">
												<option value="">全部</option>
											</select>
											&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
											<label>设备：</label>
											<input type="text" name="module.equipment" size="15px">
											&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
											<label>标签号：</label>
											<input type="text" name="module.labelNumber" size="15px">
											&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
											<label>尺寸：</label>
											<input type="text" name="module.sizeMM" size="15px">
											&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
											<label>密封点类型：</label>
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
										</div>

										<div class="form-group align-right">
											<label>是否泄漏：</label>
											<input type="radio" id="#0" name="module.leak"
												   value="true"><label
												for="#0">是</label>
											<input type="radio" id="#00" name="module.leak"
												   value="false" checked="true"><label
												for="#00">否</label>


											&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
											<button class="btn btn-info" type="button" onclick="doQuery()">
												<i class=" icon-key align-top bigger-125"></i>
												查询
											</button>
											&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
											&nbsp; &nbsp; &nbsp;
										</div>

									</form>

									<form id="form-modify" role="form" method="post">
										<s:hidden name="module.device"/>
										<s:hidden name="module.equipment"/>
										<s:hidden name="module.labelNumber"/>
										<s:hidden name="module.sizeMM"/>
										<s:hidden name="module.modelType"/>
										<s:hidden name="module.leak"/>
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
								<th>密封点类型</th>
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
                                    <s:if test="leak == true">是</s:if>
                                    <s:else>否</s:else>
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


<script src="${basePath}/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="${basePath}/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="${basePath}/assets/js/bootbox.min.js"></script>
<script src="${basePath}/assets/js/jquery.slimscroll.min.js"></script>

<script src="${basePath}/assets/js/jquery.gritter.min.js"></script>
<script src="${basePath}/assets/js/spin.min.js"></script>
<!-- ace scripts -->

<script src="${basePath}/assets/js/ace-elements.min.js"></script>
<script src="${basePath}/assets/js/ace.min.js"></script>


<!-- inline scripts related to this page -->

<script type="text/javascript">
	jQuery(function ($) {

		$("#modify_device").on(ace.click_event, function() {
			bootbox.prompt("请输入装置名称(请遵守规范)", function(result) {
				if (result == null) {

				} else {
					var url = "${basePath}/tool/batch_modify_module_modifyDevice.action?modifyDevice="+result;
					$("#form-modify").attr("action",url);
					$("#form-modify").submit();

				}
			});
		});



		$("#modify_sizeMM").on(ace.click_event, function() {
			bootbox.prompt("请输入尺寸大小", function(result) {
				if (result == null) {

				} else {

					var url = "${basePath}/tool/batch_modify_module_modifySizeMM.action?modifySizeMM="+result;
					$("#form-modify").attr("action",url);
					$("#form-modify").submit();
				}
			});
		});


		$("#modify_PIDNumber").on(ace.click_event, function() {
			bootbox.prompt("请输入PID图号", function(result) {
				if (result == null) {

				} else {

					var url = "${basePath}/tool/batch_modify_module_modifyPIDNumber.action?modifyPIDNumber="+result;
					$("#form-modify").attr("action",url);
					$("#form-modify").submit();

				}
			});
		});


		$("#modify_module_type").on(ace.click_event, function() {
			bootbox.prompt("请输入密封点类型(请遵守规范！！！)", function(result) {
				if (result == null) {

				} else {

					var url = "${basePath}/tool/batch_modify_module_modifyModuleType.action?modifyModuleType="+result;
					$("#form-modify").attr("action",url);
					$("#form-modify").submit();

				}
			});
		});


		$("#modify_equipment").on(ace.click_event, function() {
			bootbox.prompt("请输入设备名称", function(result) {
				if (result == null) {

				} else {

					var url = "${basePath}/tool/batch_modify_module_modifyEquipment.action?modifyEquipment="+result;
					$("#form-modify").attr("action",url);
					$("#form-modify").submit();

				}
			});
		});



	})
</script>
</body>
</html>
