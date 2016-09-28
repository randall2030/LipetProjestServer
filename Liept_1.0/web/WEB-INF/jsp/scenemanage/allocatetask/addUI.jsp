<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    pageContext.setAttribute("basePath", request.getContextPath());
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>LDAR后台管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <!-- basic styles -->
    <link href="${basePath}/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${basePath}/assets/css/font-awesome.min.css"/>


    <link rel="stylesheet" href="${basePath}/assets/css/font-down-google.css"/>

    <!-- ace styles -->

    <link rel="stylesheet" href="${basePath}/assets/css/ace.min.css"/>
    <link rel="stylesheet" href="${basePath}/assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="${basePath}/assets/css/ace-skins.min.css"/>


    <!-- ace settings handler -->

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
        function doSubmit() {
            document.forms[0].submit();
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
                    <li class="active">添加</li>
                </ul>
            </div>  <!-- .结束导航栏 -->


            <div class="page-content">     <!-- 右边内容界面的导航栏下的内容主界面-->

                <div class="well">

                    <form role="form" action="${basePath}/scenemanage/allocate_task_add.action">

                        <div class="text-info" style="color: green;font-size: 20px">分配任务</div>
                        <div class="row">

                            <div class="form-group center">
                                    <label class="control-label">检测类型</label>
                                    <select id="sel1" style="width: 200px;" name="task.checkType">
                                        <option>常规检测</option>
                                        <option>目视检测</option>
                                        <option>泄露复检</option>
                                    </select>
                            </div>

                            <div class="form-group center">
                                <label class="control-label" style="padding-right: 0px">开始日期</label>
                                <input type="date" style="width: 200px;" name="task.startTime">
                            </div>
                            <div class="form-group center">
                                <label class="control-label" style="padding-right: 0px">任务名称</label>
                                <input type="text" style="width: 350px;" name="task.taskName">
                            </div>
                        </div>

                        <div class="clearfix form-actions">
                            <div class="center">
                                <button class="btn btn-info" type="button" onclick="doSubmit()">
                                    <i class="icon-ok bigger-55"></i>
                                    保存
                                </button>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="${basePath}/scenemanage/allocate_task_listUI.action">
                                    <button class="btn btn-info" type="button">
                                        <i class="icon-ok bigger-55"></i>
                                        退出
                                    </button>
                                </a>
                            </div>
                        </div>
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
    $(document).ready(function () {
        /*var $Sel1 = $("#sel2 option:first");
         $Sel1.click(function () {
         $("#sel3").css("disabled","disabled");
         $("#sel4").css("disabled","disabled");
         })*/
        $("#sel2")[0].selectedIndex = 0;
        $("#sel3").attr("disabled", "disabled").css("background", "#E0EEE0");
        $("#sel4").attr("disabled", "disabled").css("background", "#E0EEE0");
        $("#sel2").change(function () {
            var s = $(this).val();
            for (var i = 0; i < s; i++) {
                if (i == 2) {
                    $("#sel3").attr("disabled", false).css("background", "#ffffff");
                    $("#sel4").attr("disabled", false).css("background", "#ffffff");
                }
                if (i == 1) {
                    $("#sel3").attr("disabled", false).css("background", "#ffffff");
                    $("#sel4").attr("disabled", "disabled").css("background", "#E0EEE0");
                }
                if (i == 0) {
                    $("#sel3").attr("disabled", "disabled").css("background", "#E0EEE0");
                    $("#sel4").attr("disabled", "disabled").css("background", "#E0EEE0");
                }
            }
            ;
        })


    })
</script>
<div style="display:none">
    <script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'>
    </script>
</div>
</body>
</html>

