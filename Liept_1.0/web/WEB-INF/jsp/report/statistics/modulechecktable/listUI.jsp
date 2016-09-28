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

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->

		<script src="${basePath}/assets/js/ace-extra.min.js"></script>

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		<script src="${basePath}/assets/js/html5shiv.js"></script>
		<script src="${basePath}/assets/js/respond.min.js"></script>
		<![endif]-->
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
							<li  class="active">组件检测统计表</li>
						</ul>
					</div>  <!-- .结束导航栏 -->
					
					
					<div class="page-content">     <!-- 右边内容界面的导航栏下的内容主界面-->
						<div id="accordion" class="accordion-style1 panel-group">
							<div class="well">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
												<i class="icon-angle-down bigger-110" data-icon-hide="icon-angle-down" data-icon-show="icon-angle-right"></i>
												<!-- 标题-->
												过滤条件
											</a>
										</h4>
									</div>

									<div class="panel-collapse collapse in" id="collapseOne">
										<div class="panel-body">
											<!-- 内容-->
											<form class="form-vertical"  id="from-search" role="form" method="post"
												  action="${basePath}/report/statistics/module_check_table_listUI.action?pageNo=1">
												<div class="row">
													<div class="col-md-4">
														<div class="form-horizontal">
															<div class="form-group">
																<label class="control-label col-md-4">开始时间</label>
																<div class="col-md-6">
																	<input type="date">
																</div>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-horizontal">
															<div class="form-group">
																<label class="control-label col-md-4">结束时间</label>
																<div class="col-md-6">
																	<input type="date">
																</div>
															</div>
														</div>
													</div>
													<div class="col-md-4" style="padding-right: 0px">
														<button class="btn btn-info" type="button">导出</button>
													</div>
												</div>

											</form>
										</div>
									</div>
								</div>
							</div>

						</div><!-- /span -->
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

