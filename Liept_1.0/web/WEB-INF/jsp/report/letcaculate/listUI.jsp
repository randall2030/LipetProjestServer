<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

        function doSubmit() {
            document.getElementById("form-letcaculate").submit();
        }

        function doSubmit2() {
            document.getElementById("form-letcaculate-device").submit();
        }

        function doSubmit3() {
            document.getElementById("form-letcaculate-medium-status").submit();
        }


        function AddDaysForModule()
        {
            var DaysToAdd = document.getElementById("daysToAddForModule").value;
            var startTime = document.getElementById("startTimeForModule").value;
            var newdate = new Date(Date.parse(startTime.replace(/-/g,   "/")));
            var newtimems = newdate.getTime() + (DaysToAdd * 24 * 60 * 60 * 1000);
            newdate.setTime(newtimems);
            document.getElementById("endTimeForModule").value = newdate.toLocaleString();
        }



        function AddDaysForBig()
        {
            var DaysToAdd = document.getElementById("daysToAddForBig").value;
            var startTime = document.getElementById("startTimeForBig").value;
            var newdate = new Date(Date.parse(startTime.replace(/-/g,   "/")));
            var newtimems = newdate.getTime() + (DaysToAdd * 24 * 60 * 60 * 1000);
            newdate.setTime(newtimems);
            document.getElementById("endTimeForBig").value = newdate.toLocaleString();
        }


        function AddDaysForMinusLetNumber()
        {
            var DaysToAdd = document.getElementById("daysToAddForMinusLetNumber").value;
            var startTime = document.getElementById("startTimeForMinusLetNumber").value;
            var newdate = new Date(Date.parse(startTime.replace(/-/g,   "/")));
            var newtimems = newdate.getTime() + (DaysToAdd * 24 * 60 * 60 * 1000);
            newdate.setTime(newtimems);
            document.getElementById("endTimeForMinusLetNumber").value = newdate.toLocaleString();
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

        <%@ include file="../../parentPage/reportLeftListNavigation.jsp" %>
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
                        <a href="#">报告</a>
                    </li>
                    <li class="active">排放计算</li>
                </ul>
            </div>  <!-- .结束导航栏 -->


            <div class="page-content">     <!-- 右边内容界面的导航栏下的内容主界面-->

                    <h5 class="blue smaller lighter">注意事项：</h5>
                    <div class="col-xs-12">
                        <ul class="list-unstyled">
                            <li>
                                <i class="icon-circle green"></i>
                                导出报告前， 请勿忘记选择开始和结束时间！！
                            </li>
                        </ul>
                    </div>

                <form id="form-letcaculate"
                      action="${basePath}/report/report/let_caculate_exportLetCaculate.action">
                    <div class="form-group center">
                        <label>开始日期: </label> &nbsp;&nbsp;
                        <input id="startTimeForModule" type="date" style="width: 200px;" name="startTime">
                    </div>
                    <div class="form-group center">
                        <label>输入天数: </label> &nbsp;&nbsp;
                        <input type="text"  id="daysToAddForModule" style="width: 200px;"  onMouseMove="AddDaysForModule()">
                    </div>

                    <div class="form-group center">
                        <label>结束日期: </label> &nbsp;&nbsp;
                        <input type="text" id ="endTimeForModule" style="width: 200px;" name="endTimeStr">
                    </div>


                    <div class="form-group center">
                        <label> 装置：</label>
                        <select id="deviceList" name="module.device">
                            <option value="">全部</option>
                        </select>
                    </div>

                    <div class="form-group center">
                        <label> 区域：</label>
                        <select id="areaList" name="module.area">
                            <option value="">全部</option>
                        </select>
                    </div>

                    <div class="form-group center">
                        <label>标签号：</label>
                        <input type="text" name="module.labelNumber" size="15px">
                    </div>

                    <div class="form-group center">
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

                    <div class="form-group center">
                        <button class="btn btn-info" type="button" id="btn1" onclick="doSubmit()">
                            <i class="icon-ok bigger-55"></i>
                            导出密封点排放详细报告
                        </button>
                    </div>
                </form>


                <hr/>

                <form id="form-letcaculate-device"
                      action="${basePath}/report/report/let_caculate_exportLetCaculateForDevice.action">
                    <div class="form-group center">
                        <label>开始日期: </label> &nbsp;&nbsp;
                        <input type="date" id="startTimeForBig" style="width: 200px;" name="startTime">
                    </div>
                    <div class="form-group center">
                        <label>输入天数: </label> &nbsp;&nbsp;
                        <input type="text"  id="daysToAddForBig" style="width: 200px;"  onMouseMove="AddDaysForBig()">
                    </div>
                    <div class="form-group center">
                        <label>结束日期: </label> &nbsp;&nbsp;
                        <input type="text" id="endTimeForBig" style="width: 200px;" name="endTimeStr">
                    </div>

                    <div class="form-group center">
                        <button class="btn btn-info" type="button" id="btnt" onclick="doSubmit2()">
                            <i class="icon-ok bigger-55"></i>
                            导出装置/密封点类型系统报告
                        </button>
                    </div>
                </form>


                <hr/>
                <form id="form-letcaculate-medium-status"
                      action="${basePath}/report/report/let_caculate_exportMinusLetReport.action">
                    <div class="form-group center">
                        <label>开始日期: </label> &nbsp;&nbsp;
                        <input type="date" id="startTimeForMinusLetNumber" style="width: 200px;" name="startTime">
                    </div>

                    <div class="form-group center">
                        <label>输入天数: </label> &nbsp;&nbsp;
                        <input type="text"  id="daysToAddForMinusLetNumber" style="width: 200px;"  onMouseMove="AddDaysForMinusLetNumber()">
                    </div>

                    <div class="form-group center">
                        <label>结束日期: </label> &nbsp;&nbsp;
                        <input type="text" id="endTimeForMinusLetNumber" style="width: 200px;" name="endTimeStr">
                    </div>

                    <div class="form-group center">
                        <button class="btn btn-info" type="button" id="btnt2" onclick="doSubmit3()">
                            <i class="icon-ok bigger-55"></i>
                            导出减排量报告
                        </button>
                    </div>
                </form>


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

