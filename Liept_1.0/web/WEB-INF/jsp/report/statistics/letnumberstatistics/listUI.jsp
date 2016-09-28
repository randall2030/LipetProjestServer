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

    <script src="${basePath}/assets/js/echarts.common.min.js"></script>

    <script type="text/javascript">

        var LetNumberByModuleTypeOption = {
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} (千克)"
            },
            toolbox: {
                feature: {
                    saveAsImage: {show: true}
                }
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: ['常规检测点', '难于检测点']
            },
            series: [
                {
                    name: '组件',
                    type: 'pie',
                    radius: '55%',
                    center: ['50%', '60%'],
                    data: [
                        {value: 335, name: '常规检测点'},
                        {value: 310, name: '难于检测点'},
                    ],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };

        var LetNumberByDeviceOption = {
            tooltip: {
                trigger: 'axis',
                axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                    type: 'line'        // 默认为直线，可选为：'line' | 'shadow'
                },
                formatter: function (params) {
                    var tar = params[1];
                    return tar.name + '<br/>' + tar.seriesName + ' : ' + tar.value;
                }
            },
            toolbox: {
                feature: {
                    saveAsImage: {show: true}
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: {
                type: 'category',
                splitLine: {show: false},
                data: ['总费用', '房租', '水电费', '交通费', '伙食费', '日用品数']
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    name: '辅助',
                    type: 'bar',
                    stack: '总量',
                    itemStyle: {
                        normal: {
                            barBorderColor: 'rgba(0,0,0,0)',
                            color: 'rgba(0,0,0,0)'
                        },
                        emphasis: {
                            barBorderColor: 'rgba(0,0,0,0)',
                            color: 'rgba(0,0,0,0)'
                        }
                    },
                    data: [0, 0, 0, 0, 0, 0]
                },
                {
                    name: '单位(千克)',
                    type: 'bar',
                    stack: '总量',
                    label: {
                        normal: {
                            show: true,
                            position: 'inside'
                        }
                    },
                    data: [2900, 1200, 300, 200, 900, 300]
                }
            ]
        };

        var LetNumberByMediumStatusOption = {
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} (千克)"
            },
            toolbox: {
                feature: {
                    saveAsImage: {show: true}
                }
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: ['常规检测点', '难于检测点']
            },
            series: [
                {
                    name: '组件',
                    type: 'pie',
                    radius: '55%',
                    center: ['50%', '60%'],
                    data: [
                        {value: 335, name: '常规检测点'},
                        {value: 310, name: '难于检测点'},
                    ],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };


        function doSubmitForDevice() {
             loadDataForChartForDevice();
        }

        function doSubmitForModuleType() {
            loadDataForChartForModuleType();
        }

        function doSubmitForMediumStatus() {
            loadDataForChartForMediumStatus();
        }



        function loadDataForChartForDevice(){
            $.ajax({
                url: "${basePath}/report/statistics/let_number_statistics_statisticForDevice.action",
                data: $('#form-time').serialize(),
                type: "get",
                async: true,
                dataType: "json",
                beforeSend: function () {
                    $("#vvv1").append('<img class="center" src="${basePath}/images/loading.gif"/>');
                },
                success: function (data) {  //data 为JSON对象
                    var chartForLetNumberByDevice = echarts.init(document.getElementById('LetNumberByDevice'));
                    LetNumberByDeviceOption.xAxis.data = data.titles;   //要的是对象， 不是字符串
                    LetNumberByDeviceOption.series[0].data = data.yHeight;
                    LetNumberByDeviceOption.series[1].data = data.statisticInfo;
                    chartForLetNumberByDevice.setOption(LetNumberByDeviceOption);
                    $("#vvv1").children('img').remove();
                },
                error: function (data) {
                    alert("统计发生异常！");
                }
            });
        }

        function loadDataForChartForModuleType(){

            $.ajax({
                url: "${basePath}/report/statistics/let_number_statistics_statisticForModuleType.action",
                data: $('#form-time2').serialize(),
                type: "get",
                async: true,
                dataType: "json",
                beforeSend: function () {
                    $("#vvv2").append('<img class="center" src="${basePath}/images/loading.gif"/>');
                },
                success: function (data) {  //data 为JSON对象
                    var chartLetNumberByModuleType = echarts.init(document.getElementById('LetNumberByModuleType'));
                    LetNumberByModuleTypeOption.legend.data = data.titles;   //要的是对象， 不是字符串
                    LetNumberByModuleTypeOption.series[0].data = data.statisticInfo;
                    chartLetNumberByModuleType.setOption(LetNumberByModuleTypeOption);
                    $("#vvv2").children('img').remove();
                },
                error: function (data) {
                    alert("统计发生异常！");
                }
            });
        }

        function doSubmitForMediumStatus() {
            $.ajax({
                url: "${basePath}/report/statistics/let_number_statistics_statisticForMediumStatus.action",
                data: $('#form-time3').serialize(),
                type: "get",
                async: true,
                dataType: "json",
                beforeSend: function () {
                    $("#vvv3").append('<img class="center" src="${basePath}/images/loading.gif"/>');
                },
                success: function (data) {  //data 为JSON对象
                    var chartLetNumberByMediumStatus = echarts.init(document.getElementById('LetNumberByMediumStatus'));
                    LetNumberByMediumStatusOption.legend.data = data.titles;   //要的是对象， 不是字符串
                    LetNumberByMediumStatusOption.series[0].data = data.statisticInfo;
                    chartLetNumberByMediumStatus.setOption(LetNumberByMediumStatusOption);
                    $("#vvv3").children('img').remove();
                },
                error: function (data) {
                    alert("统计发生异常！");
                }
            });
        }


        function AddDaysForDevice()
        {
            var DaysToAdd = document.getElementById("daysToAddForDevice").value;
            var startTime = document.getElementById("startTimeForDevice").value;
            var newdate = new Date(Date.parse(startTime.replace(/-/g,   "/")));
            var newtimems = newdate.getTime() + (DaysToAdd * 24 * 60 * 60 * 1000);
            newdate.setTime(newtimems);
            document.getElementById("endTimeForDevice").value = newdate.toLocaleString();
        }



        function AddDaysForModuleType()
        {
            var DaysToAdd = document.getElementById("daysToAddForModuleType").value;
            var startTime = document.getElementById("startTimeForModuleType").value;
            var newdate = new Date(Date.parse(startTime.replace(/-/g,   "/")));
            var newtimems = newdate.getTime() + (DaysToAdd * 24 * 60 * 60 * 1000);
            newdate.setTime(newtimems);
            document.getElementById("endTimeForModuleType").value = newdate.toLocaleString();
        }


        function AddDaysForModuleStatus()
        {
            var DaysToAdd = document.getElementById("daysToAddForModuleStatus").value;
            var startTime = document.getElementById("startTimeForModuleStatus").value;
            var newdate = new Date(Date.parse(startTime.replace(/-/g,   "/")));
            var newtimems = newdate.getTime() + (DaysToAdd * 24 * 60 * 60 * 1000);
            newdate.setTime(newtimems);
            document.getElementById("endTimeForModuleStatus").value = newdate.toLocaleString();
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

        <%@ include file="../../../parentPage/reportLeftListNavigation.jsp" %>
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
                    <li>统计</li>
                    <li class="active">排放量统计</li>
                </ul>
            </div>  <!-- .结束导航栏 -->



            <div class="page-content">

                <div class="form-group center">
                    <div id="vvv1"></div>
                </div>

                <form id="form-time" action="${basePath}/report/statistics/let_number_statistics_startCaculateDischarge.action">
                    <div class="form-group center">
                        <label>开始日期: </label> &nbsp;&nbsp;
                        <input id="startTimeForDevice" type="date" style="width: 200px;" name="startTime">
                    </div>
                    <div class="form-group center">
                        <label>输入天数: </label> &nbsp;&nbsp;
                        <input type="text"  id="daysToAddForDevice" style="width: 200px;"  onMouseMove="AddDaysForDevice()">
                    </div>

                    <div class="form-group center">
                        <label>结束日期: </label> &nbsp;&nbsp;
                        <input type="text" id ="endTimeForDevice" style="width: 200px;" name="endTimeStr">
                    </div>


                    <div class="form-group center">
                        <button class="btn btn-info" type="button" onclick="doSubmitForDevice()">
                            <i class="icon-ok bigger-55"></i>
                            开始计算
                        </button>
                    </div>
                </form>

                <div class="row">
                    <div class="col-md-12">
                        <center><h3 class="text-primary">排放量分布-按装置（千克）</h3></center>
                        <div id="LetNumberByDevice" style="height:400px;"></div>
                    </div>
                </div>
                <hr/>

                <div class="form-group center">
                    <div id="vvv2"></div>
                </div>
                <form id="form-time2" action="${basePath}/report/statistics/let_number_statistics_startCaculateDischarge.action">

                    <div class="form-group center">
                        <label>开始日期: </label> &nbsp;&nbsp;
                        <input id="startTimeForModuleType" type="date" style="width: 200px;" name="startTime">
                    </div>
                    <div class="form-group center">
                        <label>输入天数: </label> &nbsp;&nbsp;
                        <input type="text"  id="daysToAddForModuleType" style="width: 200px;"  onMouseMove="AddDaysForModuleType()">
                    </div>

                    <div class="form-group center">
                        <label>结束日期: </label> &nbsp;&nbsp;
                        <input type="text" id ="endTimeForModuleType" style="width: 200px;" name="endTimeStr">
                    </div>


                    <div class="form-group center">
                        <button class="btn btn-info" type="button" onclick="doSubmitForModuleType()">
                            <i class="icon-ok bigger-55"></i>
                            开始计算
                        </button>
                    </div>
                </form>
                <div class="row">
                    <div class="col-md-12">
                        <center><h3 class="text-primary">排放量分布-按密封点类型（千克）</h3></center>
                        <div id="LetNumberByModuleType" style="height:400px;"></div>
                    </div>
                </div>

                <hr/>

                <div class="form-group center">
                    <div id="vvv3"></div>
                </div>
                <form id="form-time3" action="${basePath}/report/statistics/let_number_statistics_startCaculateDischarge.action">

                    <div class="form-group center">
                        <label>开始日期: </label> &nbsp;&nbsp;
                        <input id="startTimeForModuleStatus" type="date" style="width: 200px;" name="startTime">
                    </div>
                    <div class="form-group center">
                        <label>输入天数: </label> &nbsp;&nbsp;
                        <input type="text"  id="daysToAddForModuleStatus" style="width: 200px;"  onMouseMove="AddDaysForModuleStatus()">
                    </div>

                    <div class="form-group center">
                        <label>结束日期: </label> &nbsp;&nbsp;
                        <input type="text" id ="endTimeForModuleStatus" style="width: 200px;" name="endTimeStr">
                    </div>

                    <div class="form-group center">
                        <button class="btn btn-info" type="button" onclick="doSubmitForMediumStatus()">
                            <i class="icon-ok bigger-55"></i>
                            开始计算
                        </button>
                    </div>
                </form>
                <div class="row">
                    <div class="col-md-12">
                        <center><h3 class="text-primary">排放量分布-按物料类型</h3></center>
                        <div id="LetNumberByMediumStatus" style="height:400px;"></div>
                    </div>
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

