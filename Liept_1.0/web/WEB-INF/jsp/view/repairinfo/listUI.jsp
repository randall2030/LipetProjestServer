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

    <!-- 查看图片 -->
    <link rel="stylesheet" href="${basePath}/assets/css/colorbox.css"/>

    <link rel="stylesheet" href="${basePath}/assets/css/ace.min.css"/>
    <link rel="stylesheet" href="${basePath}/assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="${basePath}/assets/css/ace-skins.min.css"/>


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

        function doQuery() {
            document.getElementById("from-query").submit();
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

        <%@ include file="../../parentPage/viewLeftListNavigation.jsp" %>

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
                        <a href="${basePath}/view/module_info_listUI.action">查看</a>
                    </li>

                    <li class="active">维修信息</li>
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
                                          action="${basePath}/view/repair_info_listUI.action?pageNo=1">

                                        <%@ include file="../../parentPage/moduleSelectCondition.jsp" %>

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
                    <h5 class="blue smaller lighter">维修信息
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

                    <div style="overflow: scroll">
                        <table id="sample-table-1" class="table table-striped table-bordered table-hover"
                               style="width: 2500px;">
                            <thead>
                            <tr>
                                <th class="center">
                                    <label>
                                        <input type="checkbox" class="ace"/>
                                        <span class="lbl"></span>
                                    </label>
                                </th>
                                <th>查看图片</th>
                                <th>标签号</th>
                                <th>扩展号</th>
                                <th>装置</th>
                                <th>区域</th>
                                <th>设备</th>
                                <th>位置描述</th>
                                <th>净PPM读数</th>
                                <th>泄漏阈值</th>
                                <th>泄漏</th>
                                <th>密封点类型</th>
                                <th>尺寸(mm)</th>
                                <th>泄漏源</th>
                                <th>检测人</th>
                                <th>检测仪器</th>
                                <th>是否维修</th>
                                <th>是否延迟修复</th>
                                <th>首次复测日期</th>
                                <th>首次复测值</th>
                                <th>最终复测日期</th>
                                <th>最终复测值</th>
                                <th>是否修复</th>
                                <th>检测时间</th>
                                <%--<th></th>--%>
                            </tr>
                            </thead>
                            <tbody class="ace-thumbnails">
                            <s:iterator value="leakInfos" status="st">
                                <tr>
                                    <td class="center">
                                        <label>
                                            <input type="checkbox" name="selectedRow" class="ace"
                                                   value="<s:property value='id'/>"/>
                                            <span class="lbl"></span>
                                        </label>
                                    </td>

                                    <td>
                                        <a href="${basePath}/<s:property value='markPictureSavePath'/>"
                                           data-rel="colorbox">
                                            <i class="icon-picture"></i>
                                        </a>
                                    </td>

                                    <td class="hidden-480">
                                        <s:property value="labelNumber"/>
                                    </td>

                                    <td class="hidden-480">
                                        <s:property value="extendNumber + 1"/>
                                    </td>

                                    <td><s:property value="device"/></td>

                                    <td class="hidden-480"><s:property value="area"/></td>

                                    <td><s:property value="equipment"/></td>

                                    <td class="hidden-480">
                                        <s:property value="locationDesc"/>
                                    </td>

                                    <td class="hidden-480">
                                        <s:property value="cleanPPMValue"/>
                                    </td>

                                    <td class="hidden-480">
                                        <s:property value="leakThreshold"/>
                                    </td>
                                    <td class="hidden-480">
                                        <s:property value="leak == true ? '是' : '否'"/>
                                    </td>

                                    <td class="hidden-480">
                                        <s:property value="moduleType"/>
                                    </td>
                                    <td class="hidden-480">
                                        <s:property value="sizeMM"/>
                                    </td>

                                    <td class="hidden-480">
                                        <s:property value="leakSource"/>
                                    </td>
                                    <td class="hidden-480">
                                        <s:property value="checkPerson"/>
                                    </td>

                                    <td class="hidden-480">
                                        <s:property value="checkEquipment"/>
                                    </td>
                                    <td class="hidden-480">
                                        <s:property value="hasRepair == true ? '是' : '否'"/>
                                    </td>
                                    <td class="hidden-480">
                                        <s:property value="tempRepair == true ? '是' : '否'"/>
                                    </td>
                                    <td class="hidden-480">
                                        <s:property value="firstRepeateDate"/>
                                    </td>

                                    <td class="hidden-480">
                                        <s:property value="firstRepeateValue"/>
                                    </td>
                                    <td class="hidden-480">
                                        <s:property value="endRepeateDate"/>
                                    </td>

                                    <td class="hidden-480">
                                        <s:property value="endRepeateValue"/>
                                    </td>

                                    <td class="hidden-480">
                                        <s:property value="repairResult == true ? '修复' : '未修复'"/>
                                    </td>

                                    <td>
                                        <s:property value="checkDate"/>
                                    </td>

                                    <%--<td>--%>
                                        <%--<div class="visible-md visible-lg hidden-sm hidden-xs btn-group">--%>
                                            <%--<a href="${basePath}/view/leak_info_editUI.action?deviceType.id=<s:property value='id'/>">--%>
                                                <%--<i class="icon-edit bigger-120"></i>--%>
                                            <%--</a>--%>
                                            <%--<a href="${basePath}/view/leak_info_delete.action?deviceType.id=<s:property value='id'/>">--%>
                                                <%--<i class="icon-trash bigger-120"></i>--%>
                                            <%--</a>--%>
                                        <%--</div>--%>
                                    <%--</td>--%>
                                </tr>
                            </s:iterator>
                            </tbody>

                        </table>
                    </div>
                    <form id="form_pageNavigator" action="${basePath}/view/repair_info_listUI.action">
                        <s:hidden name="module.device"/>
                        <s:hidden name="module.area"/>
                        <s:hidden name="module.modelType"/>
                        <s:hidden name="module.diffToCheck"/>
                        <s:hidden name="module.dangerToCheck"/>
                        <s:hidden name="module.tempToMove"/>
                        <jsp:include page="/base/pageNavigator.jsp"></jsp:include>
                    </form>

                </div>
            </div>

        </div><!-- /.main-content -->
    </div><!--结束main-container-inner -->
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

<script src="assets/js/date-time/bootstrap-datepicker.min.js"></script>
<!-- ace scripts -->
<script src="${basePath}/assets/js/jquery.colorbox-min.js"></script>
<script src="${basePath}/assets/js/ace-elements.min.js"></script>
<script src="${basePath}/assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->

<script type="text/javascript">
    jQuery(function ($) {

        var colorbox_params = {
            reposition: true,
            scalePhotos: true,
            scrolling: false,
            previous: '<i class="icon-arrow-left"></i>',
            next: '<i class="icon-arrow-right"></i>',
            close: '&times;',
            current: '{current} of {total}',
            maxWidth: '100%',
            maxHeight: '100%',
            onOpen: function () {
                document.body.style.overflow = 'hidden';
            },
            onClosed: function () {
                document.body.style.overflow = 'auto';
            },
            onComplete: function () {
                $.colorbox.resize();
            }
        };

        $('.ace-thumbnails [data-rel="colorbox"]').colorbox(colorbox_params);

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


