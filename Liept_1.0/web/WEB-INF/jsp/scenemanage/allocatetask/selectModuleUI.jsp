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
    <!--[if IE 7]>
    <link rel="stylesheet" href="${basePath}/assets/css/font-awesome-ie7.min.css"/>
    <![endif]-->

    <!-- page specific plugin styles -->

    <!-- fonts -->

    <link rel="stylesheet" href="${basePath}/assets/css/font-down-google.css"/>

    <!-- ace styles -->

    <link rel="stylesheet" href="${basePath}/assets/css/ace.min.css"/>
    <link rel="stylesheet" href="${basePath}/assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="${basePath}/assets/css/ace-skins.min.css"/>

    <!--[if lte IE 8]>
    <link rel="stylesheet" href="${basePath}/assets/css/ace-ie.min.css"/>
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->

    <script src="${basePath}/assets/js/ace-extra.min.js"></script>

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


        function doSelectedFinish() {
            var formSelectModule = document.getElementById("form-selectModule");
            $("#vvv").append('<img src="${basePath}/images/loading.gif"/>');
            formSelectModule.action = "${basePath}/scenemanage/allocate_task_addModules.action";
            formSelectModule.submit();
        }
        function doSubmit() {
            document.forms[0].submit();
        }

        function doQuicklySelect(){
            var formQuicklySelectModule = document.getElementById("from-quick-select");
            $("#vvv").append('<img src="${basePath}/images/loading.gif"/>');
            formQuicklySelectModule.submit();
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

                    <li>分配任务</li>
                    <li class="active">选择组件</li>
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
                                        过滤条件
                                    </a>
                                </h4>
                            </div>

                            <div class="panel-collapse collapse in" id="collapseOne">
                                <div class="panel-body">
                                    <!-- 内容-->
                                    <form class="form-vertical" id="from-query" role="form" method="post"
                                          action="${basePath}/scenemanage/allocate_task_selectModuleUI.action?pageNo=1">

                                        <div class="form-group center">
                                            <label> 装置：</label>
                                            <select id="deviceList" name="selectCondition.device">
                                                <option value="all">全部</option>
                                            </select>
                                            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                                            <label>区域：</label>
                                            <select id="areaList" name="selectCondition.area">
                                                <option value="all">全部</option>
                                            </select>

                                            <button class="btn btn-info" style="margin-left: 50px;" type="button" onclick="doQuery()">
                                                <i class=" icon-key align-top bigger-125"></i>
                                                查询
                                            </button>

                                            <s:hidden name="task.id"/>
                                          </div>
                                    </form>
                                </div>
                            </div>

                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion"
                                       href="#collapseTwo">
                                        <i class="icon-angle-down bigger-110" data-icon-hide="icon-angle-down"
                                           data-icon-show="icon-angle-right"></i>
                                        快速筛选
                                    </a>
                                </h4>
                            </div>

                            <div class="panel-collapse collapse in" id="collapseTwo">
                                <div class="panel-body">
                                    <!-- 内容-->
                                    <form class="form-vertical" id="from-quick-select" role="form" method="post"
                                          action="${basePath}/scenemanage/allocate_task_doQuicklySelectModules.action">

                                        <div class="form-group center">
                                            <label class="blue">当前筛选条件:
                                            <s:property value="selectCondition.device"/>
                                            <s:property value="selectCondition.area == 'all' ? '' : selectCondition.area "/></label>

                                            &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp;
                                            <label class="red">快速选择前 &nbsp; &nbsp;</label>
                                            <input name="selectCondition.selectNumber">&nbsp; &nbsp;条
                                            <button class="btn btn-info" style="margin-left: 50px;" type="button" onclick="doQuicklySelect()">
                                                <i class=" icon-key align-top bigger-125"></i>
                                                快速选择
                                            </button>
                                        </div>

                                        <s:hidden name="selectCondition.device"/>
                                        <s:hidden name="selectCondition.area"/>
                                        <s:hidden name="task.id"/>
                                    </form>
                                </div>
                            </div>

                        </div>

                    </div><!-- /span -->


                </div>

                <div class="well">
                    <form method="post" id="form-selectModule">
                        <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th class="center">
                                    <label>
                                        <input type="checkbox" class="ace"/>
                                        <span class="lbl"></span>
                                    </label>
                                </th>
                                <th>装置</th>
                                <th>区域</th>
                                <th>设备</th>
                                <th>楼层</th>
                                <th>标签号</th>
                                <th>扩展号</th>
                                <th>组件类型</th>
                                <th>是否泄露</th>
                                <th>尺寸（mm）</th>
                                <th>条形码</th>
                                <th>点X坐标</th>
                                <th>点Y坐标</th>
                                <th>热点X坐标</th>
                                <th>热点Y坐标</th>
                                <th>难于检测</th>
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
                                        <s:property value="device"/>
                                    </td>

                                    <td><s:property value="area"/></td>

                                    <td class="hidden-480"><s:property value="equipment"/></td>
                                    <td class="hidden-480"><s:property value="floor"/></td>

                                    <td><s:property value="labelNumber"/></td>

                                    <td class="hidden-480">
                                        <s:property value="extendNumber"/>
                                    </td>

                                    <td class="hidden-480">
                                        <s:property value="modelType"/>
                                    </td>

                                    <td class="hidden-480">
                                        <s:property value="leak == true?'是':'否'"/>
                                    </td>
                                    <td class="hidden-480">
                                        <s:property value="sizeMM"/>
                                    </td>

                                    <td class="hidden-480">
                                        <s:property value="barCode"/>
                                    </td>

                                    <td class="hidden-480">
                                        <s:property value="imgX"/>
                                    </td>
                                    <td class="hidden-480">
                                        <s:property value="imgY"/>
                                    </td>

                                    <td class="hidden-480">
                                        <s:property value="heatX"/>
                                    </td>

                                    <td class="hidden-480">
                                        <s:property value="heatY"/>
                                    </td>

                                    <td class="hidden-480">
                                        <s:property value="diffToCheck"/>
                                    </td>
                                </tr>
                            </s:iterator>
                            </tbody>
                        </table>
                        <s:hidden name="task.id"/>
                        <center>
                            <div id="vvv" style="margin-left: auto;margin-right: auto;"></div>
                        </center>
                        <div class="form-group center">
                            <button id="btn1" class="btn btn-info" type="button" onclick="doSelectedFinish()">选择完成
                            </button>
                        </div>
                    </form>

                    <form id="form_pageNavigator" action="${basePath}/scenemanage/allocate_task_selectModuleUI.action">
                        <s:hidden name="selectCondition.device"/>
                        <s:hidden name="selectCondition.area"/>
                        <s:hidden name="task.id"/>
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
