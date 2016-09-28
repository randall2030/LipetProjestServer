<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    pageContext.setAttribute("basePath", request.getContextPath());
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>LDAR后台管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <!-- basic styles -->
    <link href="${basePath}/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${basePath}/assets/css/font-awesome.min.css"/>

    <link rel="stylesheet" href="${basePath}/assets/css/font-down-google.css"/>
    <%--<link rel="stylesheet" href="${basePath}/assets/css/navbar-fixed-top.css"/>--%>


    <!-- ace styles -->

    <link rel="stylesheet" href="${basePath}/assets/css/ace.min.css"/>
    <link rel="stylesheet" href="${basePath}/assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="${basePath}/assets/css/ace-skins.min.css"/>


    <!-- ace settings handler -->

    <script src="${basePath}/assets/js/ace-extra.min.js"></script>

    <script type="text/javascript">
        function doSearch(){
            document.getElementById("from-search").submit();
        }
        function doDeleteAll(){
            var formDeviceTypes = document.getElementById("from-standrd_gas_manage");
            formDeviceTypes.action = "${basePath}/paramsetting/checkrepairsetting/standrd_gas_manage_deleteSelected.action";
            formDeviceTypes.submit();
        }
    </script>

</head>

<body>

<%@ include file="../../../parentPage/topNavigation.jsp" %>
<div class="main-container" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.check('main-container', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="main-container-inner">             <!-- 还是最外层-->
        <%@ include file="../../../parentPage/paramsettingLeftListNavigation.jsp" %>
        <div class="main-content">             <!-- 右边内容界面-->
            <div class="breadcrumbs" id="breadcrumbs">  <!-- 右边内容界面的导航栏-->
                <script type="text/javascript">
                    try {
                        ace.settings.check('breadcrumbs', 'fixed')
                    } catch (e) {
                    }
                </script>

                <ul class="breadcrumb">
                    <li>
                        <i class="icon-home home-icon"></i>
                        <a href="${basePath}/WEB-INF/jsp/paramsetting/paramsettingUI.jsp">参数设置</a>
                    </li>
                    <li>检测维修设置</li>
                    <li class="active">标准气管理</li>
                </ul>
            </div>  <!-- .结束导航栏 -->


            <div class="page-content">     <!-- 右边内容界面的导航栏下的内容主界面-->
                <div class="well">
                    <h5 class="green smaller lighter">过滤条件</h5>
                    <form class="form-vertical"  id="from-search" role="form" method="post" enctype="multipart/form-data"
                          action="${basePath}/paramsetting/checkrepairsetting/standrd_gas_manage_listUI.action?pageNo=1">

                        <div class="form-group">  <!--  表格的一行-->
                            <label >标准气编号:</label>
                            <s:textfield name="standGas.standGasNumber" id="standGasNumber"/>
                            &nbsp &nbsp &nbsp &nbsp
                            <label >公司编号:</label>
                            <s:textfield name="standGas.companyNumber" id="companyNumber"/>
                            &nbsp &nbsp &nbsp &nbsp
                            <label >停用:</label>
                            <s:textfield name="standGas.stopuUse" id="stopuUse"/>
                            &nbsp &nbsp &nbsp &nbsp
                            <a href="javascript:doSearch()">
                                <button class="btn btn-info" type="button">查询</button>
                            </a>
                        </div>
                    </form>

                </div>

                <div class="well">
                    <h5 class="green smaller lighter">标准气管理
                        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        <a href="${basePath}/paramsetting/checkrepairsetting/standrd_gas_manage_addUI.action">
                            <button class="btn btn-info" type="button">添加</button>
                        </a>
                        &nbsp; &nbsp; &nbsp;

                        <button class="btn btn-info" type="button" onclick="doDeleteAll()">删除选中</button>
                    </h5>
                    <form id="from-standrd_gas_manage"  method="post">

                    <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th class="center">
                                <label>
                                    <input type="checkbox" class="ace"/>
                                    <span class="lbl"></span>
                                </label>
                            </th>
                            <th>标准气编号</th>
                            <th>公司编号</th>
                            <th>标准气名称</th>
                            <th>标准其实际浓度</th>
                            <th>有效日期</th>
                            <th>停用</th>
                            <th>停用日期</th>
                            <th>标准气理论浓度</th>

                            <th></th>
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
                                    <s:property value="standGasNumber"/>
                                </td>

                                <td><s:property value="companyNumber"/></td>

                                <td class="hidden-480"><s:property value="standGasName"/></td>

                                <td><s:property value="actualDensity"/></td>

                                <td class="hidden-480">
                                    <s:date name="validTime" format="yyyy-MM-dd"/>
                                </td>

                                <td class="hidden-480">
                                    <s:property value="stopuUse==true?'是':'否'"/>
                                </td>

                                <td class="hidden-480">
                                    <s:date name="stopTime" format="yyyy-MM-dd"/>
                                </td>

                                <td class="hidden-480">
                                    <s:property value="theoryDensity"/>
                                </td>
                                <td>
                                    <div class="visible-md visible-lg hidden-sm hidden-xs btn-group">

                                        <button class="btn btn-xs btn-info">
                                            <a href="${basePath}/paramsetting/checkrepairsetting/standrd_gas_manage_editUI.action?standGas.id=<s:property value='id'/>">
                                                <i class="icon-edit bigger-120"></i>
                                            </a>
                                        </button>

                                        <button class="btn btn-xs btn-danger">
                                            <a href="${basePath}/paramsetting/checkrepairsetting/standrd_gas_manage_delete.action?standGas.id=<s:property value='id'/>">
                                                <i class="icon-trash bigger-120"></i>
                                            </a>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        </s:iterator>
                        </tbody>
                    </form>
                    </table>
                    <form id="form_pageNavigator" action="${basePath}/paramsetting/checkrepairsetting/standrd_gas_manage_listUI.action">
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
<div style="display:none">
    <script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'>
    </script>
</div>
</body>
</html>

