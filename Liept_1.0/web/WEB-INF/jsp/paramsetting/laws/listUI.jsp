<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    pageContext.setAttribute("basePath", request.getContextPath());
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>LDAR后台管理系统</title>
    <meta charset="utf-8" />
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
            var formDeviceTypes = document.getElementById("from_law");
            formDeviceTypes.action = "${basePath}/paramsetting/laws_deleteSelected.action";
            formDeviceTypes.submit();
        }
    </script>




</head>

<body>

<%@ include file="../../parentPage/topNavigation.jsp" %>
<div class="main-container" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.check('main-container', 'fixed')
        } catch (e) {
        }
    </script>

    <%-- company_info--%>
    <div class="main-container-inner">             <!-- 还是最外层-->
        <%@ include file="../../parentPage/paramsettingLeftListNavigation.jsp" %>
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
                        <a href="${basePath}/paramsetting/dept_setting_listUI.action">参数设置</a>
                    </li>
                    <li class="active">法规管理</li>
                </ul>
            </div>  <!-- .结束导航栏 -->

            <div class="page-content">     <!-- 右边内容界面的导航栏下的内容主界面-->

                <div class="well">
                    <h5 class="green smaller lighter">法规
                        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp;

                        <a href="${basePath}/paramsetting/laws_addUI.action" style="text-decoration: none;">
                            <button class="btn btn-info" type="button">添加</button>
                        </a>
                        &nbsp; &nbsp; &nbsp;

                        <button class="btn btn-info" type="button" onclick="doDeleteAll()">删除选中</button>
                    </h5>

                    <form id="from_law" method="post">
                        <div style="overflow: scroll;width: 100%">
                    <table  class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th class="center">
                                <label>
                                    <input type="checkbox" class="ace"/>
                                    <span class="lbl"></span>
                                </label>
                            </th>
                            <th>操作</th>
                            <th>法规代码</th>
                            <th>法规描述</th>
                            <th>当前法规</th>
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
                                    <a href="${basePath}/paramsetting/laws_addLawDetailUI.action?law.id=<s:property value='id'/>">
                                        添加法规详情
                                    </a>
                                    <a href="${basePath}/paramsetting/laws_lawDetailListUI.action?law.id=<s:property value='id'/>">
                                        查看法规详情
                                    </a>
                                </td>
                                <td>
                                    <s:property value="lawCode"/>
                                </td>
                                <td><s:property value="lawDesc"/></td>
                                <td><s:property value="currentLaw==true?'是':'否'"/></td>

                                <td>
                                    <div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
                                            <a href="${basePath}/paramsetting/laws_editUI.action?law.id=<s:property value='id'/>">
                                                <i class="icon-edit bigger-120">
                                                </i>
                                            </a>


                                            <a href="${basePath}/paramsetting/laws_delete.action?law.id=<s:property value='id'/>">
                                                <i class="icon-trash bigger-120">
                                                </i>
                                            </a>
                                    </div>
                                </td>
                            </tr>
                        </s:iterator>
                        </tbody>

                    </table>
                        </div>
                    </form>
                    <form id="form_pageNavigator" action="${basePath}/paramsetting/laws_listUI.action">
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

