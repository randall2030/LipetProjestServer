<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
		<!-- basic styles -->
		<link href="${basePath}/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${basePath}/assets/css/font-awesome.min.css" />
		<!--[if IE 7]>
		  <link rel="stylesheet" href="${basePath}/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="${basePath}/css/jquery-ui-1.10.3.custom.min.css" />
		<link rel="stylesheet" href="${basePath}/css/jquery.gritter.css" />
		<!-- fonts -->

		<link rel="stylesheet" href="${basePath}/assets/css/font-down-google.css"/>

		<!-- ace styles -->

		<link rel="stylesheet" href="${basePath}/assets/css/ace.min.css" />
		<link rel="stylesheet" href="${basePath}/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="${basePath}/assets/css/ace-skins.min.css" />


		<!-- inline styles related to this page -->

		<!-- ace settings handler -->


		<script src="${basePath}/assets/js/ace-extra.min.js"></script>
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
								<li class="active">开始新的检测周期</li>
							</ul>
						</div>  <!-- .结束导航栏 -->
						
						
						<div class="page-content">     <!-- 右边内容界面的导航栏下的内容主界面-->


							<div class="well">
								<h5 class="blue smaller lighter">开始新的检测周期：</h5>

									<div class="col-xs-12">
										<ul class="list-unstyled spaced2">
											<li>
												<i class="icon-circle green"></i>
												本操作将保存本次检测的所有数据, 请确保本轮检测已经完成！！
											</li>
											<li>
												<i class="icon-circle green"></i>
												对于检测数据的查看请到： 查看 - > 历史检测数据
											</li>
										</ul>
									</div>


								<center><button class="btn btn-info" id="bootbox-regular">开始新的检测周期</button></center>
							</div>


							<div class="well">
								<form id="from-check-periods"  method="post">
									<table id="sample-table-1" class="table table-striped table-bordered table-hover">
										<thead>
										<tr>
											<th>历史检测周期名称</th>
											<th>周期结束时间</th>
										</tr>
										</thead>

										<tbody>
										<s:iterator value="pageResult.items" status="st">
											<tr>

												<td class="hidden-480">
													<s:property value="periodName"/>
												</td>

												<td class="hidden-480">
													<s:date name="periodEndTime" format="yyyy-MM-dd HH:mm:ss"/></td>
												</td>
											</tr>
										</s:iterator>
										</tbody>
									</table>
								</form>

								<form id="form_pageNavigator" action="${basePath}/tool/start_new_check_listUI.action">
									<jsp:include page="/base/pageNavigator.jsp"></jsp:include>
								</form>

							</div>

							<form method="post" id="start-new-check-period-form"></form>
							<center><div id="vvv" style="margin-left: auto;margin-right: auto;"></div></center>

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

				$("#bootbox-regular").on(ace.click_event, function() {
					bootbox.prompt("请输入本次检测周期的名称", function(result) {
						if (result === null) {

						} else {

							var url = "${basePath}/tool/start_new_check_startNewCheckPeriod.action?checkPeroidName="+result;
							$("#start-new-check-period-form").attr("action",url);
							$("#start-new-check-period-form").submit();

							$("#vvv").append('<img src="${basePath}/images/loading.gif"/>');
						}
					});
				});


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
	</body>
</html>
