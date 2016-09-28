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

    <link rel="stylesheet" href="${basePath}/assets/css/font-down-google.css"/>

    <!-- ace styles -->
    <link rel="stylesheet" href="${basePath}/assets/css/ace.min.css"/>
    <link rel="stylesheet" href="${basePath}/assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="${basePath}/assets/css/ace-skins.min.css"/>
    <!-- ace settings handler -->

    <script src="${basePath}/assets/js/ace-extra.min.js"></script>
    <script src="${basePath}/assets/js/echarts.common.min.js"></script>


    <script type="text/javascript">
        var ppmAllocateOption = {
            tooltip: {
                trigger: 'xAxis',
                axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                    type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            legend: {
                data: ['500≤ppm<1000', '1000≤ppm<2000', '2000≤ppm<5000', '5000≤npm<10000', '10000≤ppm<50000', '50000≤ppm']
            },
            toolbox: {
                feature: {
                    saveAsImage: {show: true}
                }
            },
            grid: {
                left: '1%',
                right: '1',
                bottom: '1%',
                containLabel: true,
            },
            yAxis: {
                type: 'value'
            },
            xAxis: {
                type: 'category',
                data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
            },
            series: [
                {
                    name: '500≤ppm<1000',
                    type: 'bar',
                    stack: '总量',
                    label: {
                        normal: {
                            show: true,
                            position: 'left',
                        }
                    },
                    data: [320, 302, 301, 334, 390, 330, 320]
                },
                {
                    name: '1000≤ppm<2000',
                    type: 'bar',
                    stack: '总量',
                    label: {
                        normal: {
                            show: true,
                            position: 'right'
                        }
                    },
                    data: [120, 132, 101, 134, 90, 230, 210]
                },
                {
                    name: '2000≤ppm<5000',
                    type: 'bar',
                    stack: '总量',
                    label: {
                        normal: {
                            show: true,
                            position: 'left'
                        }
                    },
                    data: [220, 182, 191, 234, 290, 330, 310]
                },
                {
                    name: '5000≤ppm<10000',
                    type: 'bar',
                    stack: '总量',
                    label: {
                        normal: {
                            show: true,
                            position: 'right'
                        }
                    },
                    data: [150, 212, 201, 154, 190, 330, 410]
                },
                {
                    name: '10000≤ppm<50000',
                    type: 'bar',
                    stack: '总量',
                    label: {
                        normal: {
                            show: true,
                            position: 'left'
                        }
                    },
                    data: [820, 832, 901, 934, 1290, 1330, 1320]
                },
                {
                    name: '50000≤ppm',
                    type: 'bar',
                    stack: '总量',
                    label: {
                        normal: {
                            show: true,
                            position: 'right'
                        }
                    },
                    data: [820, 832, 901, 934, 1290, 1330, 1320]
                }
            ]
        };

        var ModuleTypeOption = {
            title: {
                text: '密封点统计(按密封点类型)',
                subtext: '',
                x: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
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
                    name: '密封点',
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


        var DeviceOption = {
            title: {
                text: '密封点分布(按装置)',
            },
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
                    name: '数量',
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

        var LeakPointAllocateOption = {
            title: {
                text: '泄漏点分布',
                subtext: '',
                x: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            toolbox: {
                feature: {
                    saveAsImage: {show: true}
                }
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: ['常规检测', '难于检测']
            },
            series: [
                {
                    name: '密封点',
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

        var LeakAndLeakPercentOption = {
            tooltip: {
                trigger: 'axis'
            },
            toolbox: {
                feature: {
                    saveAsImage: {show: true}
                }
            },
            legend: {
                data: ['泄露点数', '泄漏率']
            },
            xAxis: [
                {
                    type: 'category',
                    data: []
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    name: '泄露点数',
                    min: 0,
                    max: 250,
                    interval: 50,
                    axisLabel: {
                        formatter: '{value} '
                    }
                },
                {
                    type: 'value',
                    name: '泄漏率',
                    min: 0,
                    max: 25,
                    interval: 5,
                    axisLabel: {
                        formatter: '{value} °%'
                    }
                }
            ],
            series: [
                {
                    name: '泄露点数',
                    type: 'bar',
                    data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
                },
                {
                    name: '泄漏率',
                    type: 'bar',
                    yAxisIndex: 1,
                    data: [2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2]
                }
            ]
        };


        window.onload = function () {

            var chartForPPMAllocate = echarts.init(document.getElementById('checkPPMAllocate'));
            var chartForModuleType = echarts.init(document.getElementById('contatin-for-module-type'));
            var chartForDevice = echarts.init(document.getElementById('contatin-for-device'));
            var chartForLeakAndLeakPercent = echarts.init(document.getElementById('leakAndLeakPercentByDevice'));
            var chartForLeakPointAllocate = echarts.init(document.getElementById('leakPointAllocate'));

            loadDataForChart();

            chartForModuleType.setOption(ModuleTypeOption);
            chartForDevice.setOption(DeviceOption);
            chartForPPMAllocate.setOption(ppmAllocateOption);
            chartForLeakAndLeakPercent.setOption(LeakAndLeakPercentOption);
            chartForLeakPointAllocate.setOption(LeakPointAllocateOption);

        }


        function loadDataForChart() {

            $.ajax({
                url: "${basePath}/report/statistics/module_statistics_statisticForModuleType.action",
                data: {},
                type: "get",
                async: false,
                dataType: "json",
                success: function (data) {  //data 为JSON对象
                    ModuleTypeOption.title.text = data.bigTitle;
                    ModuleTypeOption.legend.data = data.titles;   //要的是对象， 不是字符串
                    ModuleTypeOption.series[0].data = data.statisticInfo;

                },
                error: function (data) {
//                    alert("统计发生异常！");
                }
            });

            $.ajax({
                url: "${basePath}/report/statistics/module_statistics_statisticForDevice.action",
                data: {},
                type: "get",
                async: false,
                dataType: "json",
                success: function (data) {  //data 为JSON对象
                    DeviceOption.title.text = data.bigTitle;
                    DeviceOption.xAxis.data = data.titles;   //要的是对象， 不是字符串
                    DeviceOption.series[0].data = data.yHeight;
                    DeviceOption.series[1].data = data.statisticInfo;
                },
                error: function (data) {
//                    alert("统计发生异常！");
                }
            });

            $.ajax({
                url: "${basePath}/report/statistics/check_statistics_statisticForPPMAllocate.action",
                data: {},
                type: "get",
                async: false,
                dataType: "json",
                success: function (data) {  //data 为JSON对象
                    ppmAllocateOption.xAxis.data = data.devceNames;   //要的是对象， 不是字符串
                    ppmAllocateOption.series[0].data = data.ppm500To1000;
                    ppmAllocateOption.series[1].data = data.ppm1000To2000;
                    ppmAllocateOption.series[2].data = data.ppm2000To5000;
                    ppmAllocateOption.series[3].data = data.ppm5000To10000;
                    ppmAllocateOption.series[4].data = data.ppm10000To50000;
                    ppmAllocateOption.series[5].data = data.ppm5000Up;

                },
                error: function (data) {
//                    alert("统计发生异常！");
                }
            });

            $.ajax({
                url: "${basePath}/report/statistics/check_statistics_statisticCheckPointByDevice.action",
                data: {},
                type: "get",
                async: false,
                dataType: "json",
                success: function (data) {  //data 为JSON对象
                    checkPointNumberOption.xAxis.data = data.titles;   //要的是对象， 不是字符串
                    checkPointNumberOption.series[0].data = data.yHeight;
                    checkPointNumberOption.series[1].data = data.statisticInfo;
                },
                error: function (data) {
//                    alert("统计发生异常！");
                }
            });

            $.ajax({
                url: "${basePath}/report/statistics/leak_statistics_statisticLeakPointAllocate.action",
                data: {},
                type: "get",
                async: false,
                dataType: "json",
                success: function (data) {  //data 为JSON对象
                    LeakPointAllocateOption.title.text = data.bigTitle;
                    LeakPointAllocateOption.legend.data = data.titles;   //要的是对象， 不是字符串
                    LeakPointAllocateOption.series[0].data = data.statisticInfo;

                },
                error: function (data) {
//                    alert("统计发生异常！");
                }
            });

            $.ajax({
                url: "${basePath}/report/statistics/leak_statistics_statisticLeakAndLeakPercent.action",
                data: {},
                type: "get",
                async: false,
                dataType: "json",
                success: function (data) {  //data 为JSON对象
                    LeakAndLeakPercentOption.xAxis[0].data = data.titles;
                    LeakAndLeakPercentOption.series[0].data = data.pointNumbers;
                    LeakAndLeakPercentOption.series[1].data = data.percentValues;
                },
                error: function (data) {
//                    alert("统计发生异常！");
                }
            });

        }
    </script>

</head>

<body>

<%@ include file="../parentPage/topNavigation.jsp" %>
<%--<jsp:include page="${basePath}/base/topNavigation.jsp"></jsp:include>--%>

<div class="main-container" id="main-container">

    <script type="text/javascript">
        try {
            ace.settings.check('main-container', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="row">
        <hr>
        <h3 class="center red">${user.companyNameCN} 全场统计图表</h3>
        <hr>

        <div class="well">
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <center>
                    <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>全厂标签数</th>
                            <th>总密封点数</th>
                            <th>常规检测点数</th>
                            <th>难于检测点数</th>
                            <th>当前泄漏点数</th>
                            <th>当前延迟修复点数</th>
                        </tr>
                        </thead>

                        <tbody>

                                <tr>
                                    <td> ${totalInfo.totalLabelNumber}</td>
                                    <td> ${totalInfo.totalModuleNumber}</td>
                                    <td> ${totalInfo.easyCheckModuleNumber}</td>
                                    <td> ${totalInfo.diffCheckModuleNumber}</td>
                                    <td> ${totalInfo.currentLeakNumber}</td>
                                    <td> ${totalInfo.currentDelayRepairNumber}</td>
                                </tr>

                        </tbody>

                    </table>
                </center>

            </div>
        </div>
        </div>



        <div class="well">
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <center>
                    </center>
                    <table id="sample-table" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>装置</th>
                            <th>总检测点数</th>
                            <th>常规检测</th>
                            <th>已检</th>
                            <th>检测完成率</th>
                            <th>泄露点数</th>
                            <th>泄露率</th>
                            <th>修复点数</th>
                            <th>修复率</th>
                            <th>延迟修复点数</th>
                            <th>当前泄露点数</th>
                            <th>当前泄露率</th>
                        </tr>
                        </thead>

                        <tbody>
                        <s:iterator value="totalInfoForDevices" status="st">
                            <tr>
                                <td><s:property value="deviceName"/></td>
                                <td><s:property value="totalCheckNumber"/></td>
                                <td><s:property value="easyCheckNumber"/></td>
                                <td><s:property value="hasCheckNumber"/></td>
                                <td><s:property value="checkPercent"/></td>
                                <td><s:property value="leakNumber"/></td>
                                <td><s:property value="leakPercent"/></td>
                                <td><s:property value="repairNumber"/></td>
                                <td><s:property value="repairPercent"/></td>
                                <td><s:property value="delayRepairNumber"/></td>
                                <td><s:property value="currentLeakNumber"/></td>
                                <td><s:property value="currentLeakPercent"/></td>
                            </tr>
                        </s:iterator>

                        <td><s:property value="totalInfoForGrid.totalName"/></td>
                        <td><s:property value="totalInfoForGrid.totalCheckPoint"/></td>
                        <td><s:property value="totalInfoForGrid.commonCheckPoint"/></td>
                        <td><s:property value="totalInfoForGrid.hasCheckPoint"/></td>
                        <td><s:property value="totalInfoForGrid.checkFinishPercent"/></td>
                        <td><s:property value="totalInfoForGrid.leakNumber"/></td>
                        <td><s:property value="totalInfoForGrid.leakPercent"/></td>
                        <td><s:property value="totalInfoForGrid.repairpoint"/></td>
                        <td><s:property value="totalInfoForGrid.repairPercent"/></td>
                        <td><s:property value="totalInfoForGrid.delayRepairPoint"/></td>
                        <td><s:property value="totalInfoForGrid.currentLeakPoint"/></td>
                        <td><s:property value="totalInfoForGrid.currentLeakPercent"/></td>
                        </tbody>

                    </table>
                </div>
            </div>
        </div>


        <hr>
        <h3 class="center red">${currentPeroid}</h3>
        <hr>

        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <center><h3 class="text-primary">密封点统计(按密封点类型)</h3></center>
                <div id="contatin-for-module-type" style="height:500px;"></div>
            </div>
        </div>

        <hr>

        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <center><h3 class="text-primary">密封点分布(按装置)</h3></center>
                <div id="contatin-for-device" style="height:500px;"></div>
            </div>
        </div>
        <hr>

        <hr>
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <center><h3 class="text-primary">500ppm以上不同VOCs浓度区间监测点分布</h3></center>
                <div id="checkPPMAllocate" style="height:650px;"></div>
            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <center><h3 class="text-primary">泄漏点数和泄漏率统计图-按密封点类型</h3></center>
                <div id="leakPointAllocate" style="height:500px;"></div>
            </div>
        </div>
        <hr>

        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <center><h3 class="text-primary">泄漏点数和泄漏率统计图-按装置</h3></center>
                <div id="leakAndLeakPercentByDevice" style="height:500px;"></div>
            </div>
        </div>
        <hr>
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
</script>

</body>

</html>

