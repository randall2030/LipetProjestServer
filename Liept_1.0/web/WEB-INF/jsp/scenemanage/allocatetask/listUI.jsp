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

        function doSearch(){
            document.getElementById("from-search").submit();
        }


        function onDeleteTask(id){
            bootbox.confirm("确定删除这个任务?", function(result) {
                if(result) {
                    var formDeletetask = document.getElementById("form_deleteTask");
                    formDeletetask.action = "${basePath}/scenemanage/allocate_task_delete.action?task.id="+id;
                    formDeletetask.submit();
                }
            });
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

    <div class="main-container-inner">             <!-- 还是最外层-->

        <%@ include file="../../parentPage/scenemanageLeftListNavigation.jsp" %>

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
                        <a href="${basePath}/scenemanage/allocate_task_listUI.action">现场管理</a>
                    </li>

                    <li class="active">分配任务</li>
                </ul>

            </div>  <!-- .结束导航栏 -->

            <div class="page-content">     <!-- 右边内容界面的导航栏下的内容主界面-->
                <div class="well">

                    <div id="accordion" class="accordion-style1 panel-group">
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
                                          action="${basePath}/scenemanage/allocate_task_listUI.action?pageNo=1">
                                        <div class="form-group">
                                            <label > 检测类型:</label>
                                            <select style="width:110px;height:24px" name="task.checkType" id="checkType">
                                                <option value="全部">全部</option>
                                                <option>常规检测</option>
                                                <option>泄露复检</option>
                                                <option>目视检测</option>
                                            </select>
                                            <a style="margin-left: 50px;" href="javascript:doSearch()">
                                                <button class="btn btn-info" type="button">查询</button>
                                            </a>
                                        </div>
                                    </form>
                                </div>
                            </div>

                        </div>
                    </div>

                </div>

                <div class="well">
                    <h5 class="green smaller lighter">分配任务
                        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        &nbsp;&nbsp; &nbsp;

                        <a href="${basePath}/scenemanage/allocate_task_addUI.action">
                            <button class="btn btn-info" type="button">添加</button>
                        </a>
                    </h5>

                    <div style="overflow: scroll;width: 100%">
                    <table id="sample-table-1" class="table table-striped table-bordered table-hover" style="width:1500px;">
                        <thead>
                        <tr>
                            <th style="font-size:10px"></th>
                            <th style="font-size:10px">任务名称</th>
                            <th style="font-size:10px">已检测</th>
                            <th style="font-size:10px">未检测</th>
                            <th style="font-size:10px">泄露/未修复</th>
                            <th style="font-size:10px">合计</th>
                            <th style="font-size:10px">检测类型</th>
                            <th style="font-size:10px">开始日期</th>
                            <th style="font-size:10px">是否结束</th>
                            <th style="font-size:10px">创建人</th>
                            <th style="font-size:10px">创建时间</th>
                            <th></th>
                        </tr>
                        </thead>

                        <tbody>
                        <s:iterator value="pageResult.items" status="st">
                            <tr>
                                <td>
                                    <a href="${basePath}/scenemanage/allocate_task_selectModuleUI.action?task.id=<s:property value='id'/>" style="text-decoration: none">
                                        <button class="btn btn-primary btn-xs">添加密封点</button>
                                    </a>
                                </td>
                                <td><s:property value="taskName"/></td>
                                <td><s:property value="hasCheck"/></td>
                                <td><s:property value="noCheck"/></td>
                                <td><s:property value="leak"/></td>
                                <td><s:property value="total"/></td>
                                <td><s:property value="checkType"/></td>
                                <td><s:date name="startTime" format="yyyy-MM-dd HH:mm:ss"/> </td>
                                <td><s:property value="stop==true?'是':'否'"/></td>
                                <td class="hidden-480">
                                    <s:property value="createPerson"/>
                                </td>
                                <td><s:date name="createTime" format="yyyy-MM-dd HH:mm:ss"/> </td>
                                <td>
                                    <div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
                                        <button class="btn btn-danger btn-xs" id="bootbox-confirm" onclick="onDeleteTask('<s:property value="id"/>')">删除任务</button>
                                    </div>
                                </td>
                            </tr>
                        </s:iterator>
                        </tbody>

                    </table>

                    </div>
                    <form id="form_pageNavigator" action="${basePath}/scenemanage/allocate_task_listUI.action">
                        <jsp:include page="/base/pageNavigator.jsp"></jsp:include>
                    </form>

                    <form id="form_deleteTask" method="post"></form>

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
