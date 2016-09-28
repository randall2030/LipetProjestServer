<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	pageContext.setAttribute("basePath", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>LDAR后台管理系统</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<style type="text/css">
		a:link,a:visited{
			text-decoration:none;  /*超链接无下划线*/
		}
		a:hover{
			text-decoration:underline;  /*鼠标放上去有下划线*/
		}
	</style>
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

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

	<!--[if lt IE 9]>
	<script src="${basePath}/assets/js/html5shiv.js"></script>
	<script src="${basePath}/assets/js/respond.min.js"></script>

	<script type="text/javascript">
		function importModuleFromExcel(){
			document.getElementById("from-importfile").submit();
		}
	</script>
	<![endif]-->
</head>

<body>

<%@ include file="../../parentPage/topNavigation.jsp" %>
<div class="main-container" id="main-container">
	<script type="text/javascript">
		try{ace.settings.check('main-container' , 'fixed')}catch(e){}
	</script>
	<div class="main-container-inner">             <!-- 还是最外层-->

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
					<li class="active">导入组件</li>
				</ul>
			</div>  <!-- .结束导航栏 -->

			<div class="page-content">     <!-- 右边内容界面的导航栏下的内容主界面-->

				<div class="well">
					<!--折叠控件 -->
					<div id="accordion" class="accordion-style1 panel-group">

						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
										<i class="icon-angle-down bigger-110" data-icon-hide="icon-angle-down" data-icon-show="icon-angle-right"></i>
										<!-- 标题-->
										导入组件
									</a>
								</h4>
							</div>

							<div class="panel-collapse collapse in" id="collapseOne">
								<div class="panel-body">
									<!-- 内容-->
									<form class="form-vertical"  id="from-importfile" role="form" method="post"
										  enctype="multipart/form-data"
										  action="${basePath}/tool/import_module_importModuleFromExcel.action">

											<div class="form-group">  <!--  表格的一行-->
												&nbsp; &nbsp; &nbsp; &nbsp;
												<input type="file" name="importModuleExcelFile"/>
												<h5>&nbsp;</h5>
												<button id="btn1" class="btn" onclick="importModuleFromExcel()">
													<i class="icon-cloud-upload"></i>
													上传文件并导入
												</button>
											</div>
									</form>
								</div>

							</div>
						</div>
					</div>

				</div><!-- /span -->
				<div id="vvv" style="padding-left: 350px">
				</div>
				<div class="well">
					<h5 class="green smaller lighter">组件批量操作历史记录
						&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
						&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
						&nbsp; &nbsp; &nbsp;
						&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
						&nbsp; &nbsp; &nbsp;
						&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
						&nbsp; &nbsp; &nbsp;
						&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
						&nbsp; &nbsp; &nbsp;


					</h5>

					<table id="sample-table-1" class="table table-striped table-bordered table-hover">
						<thead>
						<tr>
							<th class="center">
								<label>
									<input type="checkbox" class="ace"/>
									<span class="lbl"></span>
								</label>
							</th>
							<th>导入文件名</th>
							<th>新增数据量</th>
							<th>修改数据量 </th>
							<th>丢弃数据量</th>
							<th>创建时间</th>
							<th>创建人</th>
						</tr>
						</thead>

						<tbody>
						<s:iterator value="pageResult.items" status="st">
							<tr>
								<td class="center">
									<label>
										<input type="checkbox" name="selectedRow" class="ace"
											   value="<s:property value='id'/>"/>
										<span class="lbl"></span>
									</label>
								</td>

								<td>
									<s:property value="importFileName"/>
								</td>

								<td><s:property value="newDataNumber"/></td>

								<td class="hidden-480"><s:property value="modifyDataNumber"/></td>

								<td><s:property value="discardDataNumber"/></td>

								<td class="hidden-480">
									<s:property value="createTime"/>
								</td>

								<td class="hidden-480">
									<s:property value="createPerson"/>
								</td>
							</tr>
						</s:iterator>
						</tbody>

					</table>

					<form id="form_pageNavigator" action="${basePath}/tool/import_module_listUI.action">
						<jsp:include page="/base/pageNavigator.jsp"></jsp:include>
					</form>

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
<script src="${basePath}/assets/js/jquery.easy-pie-chart.min.js"></script>
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
	$(document).ready(function () {
		$("#btn1").click(function () {
			$("#vvv").append('<img src="${basePath}/images/loading.gif"/>');
		})
	})
</script>
<div style="display:none">
	<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'>
	</script>
</div>
</body>
</html>
