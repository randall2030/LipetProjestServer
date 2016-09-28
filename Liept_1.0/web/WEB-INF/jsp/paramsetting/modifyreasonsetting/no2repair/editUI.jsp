<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    pageContext.setAttribute("basePath", request.getContextPath());
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>LDAR后台管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- basic styles -->
    <link href="${basePath}/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="${basePath}/assets/css/font-awesome.min.css" />


    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />

    <!-- ace styles -->

    <link rel="stylesheet" href="${basePath}/assets/css/ace.min.css" />
    <link rel="stylesheet" href="${basePath}/assets/css/ace-rtl.min.css" />
    <link rel="stylesheet" href="${basePath}/assets/css/ace-skins.min.css" />


    <!-- ace settings handler -->

    <script src="${basePath}/assets/js/ace-extra.min.js"></script>

    <script type="text/javascript">
        function doSubmit(){
            document.forms[0].submit();
        }
    </script>
</head>

<body>
<div class="navbar navbar-default" id="navbar">
    <script type="text/javascript">
        try{ace.settings.check('navbar' , 'fixed')}catch(e){}
    </script>

    <div class="navbar-container" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    <i class="icon-leaf"></i>
                    LDAR后台管理系统
                </small>
            </a><!-- /.brand -->
        </div><!-- /.navbar-header -->

        <div class="navbar-header pull-right" role="navigation">


            <ul class="nav ace-nav">
                <li><a href="${basePath}/sys/home_homeUI.action">&nbsp &nbsp 首页 &nbsp &nbsp</a></li>
                <li><a href="${basePath}/view/check_process_listUI.action">&nbsp &nbsp 查看 &nbsp &nbsp</a></li>
                <li><a href="${basePath}/scenemanage/allocate_taskUI.action">&nbsp 现场管理 &nbsp</a></li>
                <li><a href="${basePath}/paramsetting/device_type_listUI.action">参数设置</a></li>
                <li><a href="${basePath}/tool/verify_lawUI.action">&nbsp &nbsp 工具 &nbsp &nbsp</a></li>
                <li><a href="${basePath}/report/model_foun_accountUI.action">&nbsp &nbsp 报告 &nbsp &nbsp</a></li>
                <li><a href="${basePath}/securesetting/user_operateUI.action">安全性设置</a></li>
                <li><a href="${basePath}/sysmanage/sys_userUI.action">系统管理</a></li>
                <li class="light-blue">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        <img class="nav-user-photo" src="${basePath}/assets/avatars/user.jpg" alt="susion's Photo"/>
								<span class="user-info">
									<small>欢迎光临,</small>
									susion
								</span>

                        <i class="icon-caret-down"></i>
                    </a>

                    <ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                        <li>
                            <a href="#">
                                <i class="icon-user"></i>
                                修改密码
                            </a>
                        </li>

                        <li class="divider"></li>

                        <li>
                            <a href="#">
                                <i class="icon-off"></i>
                                退出
                            </a>
                        </li>
                    </ul>
                </li>
            </ul><!-- /.ace-nav -->
        </div><!-- /.navbar-header -->
    </div><!-- /.container -->
</div>

<div class="main-container" id="main-container">
    <script type="text/javascript">
        try{ace.settings.check('main-container' , 'fixed')}catch(e){}
    </script>
    <div class="main-container-inner">             <!-- 还是最外层-->

        <div class="sidebar" id="sidebar">
            <script type="text/javascript">
                try {
                    ace.settings.check('sidebar', 'fixed')
                } catch (e) {
                }
            </script>

            <ul class="nav nav-list">
                <li >
                    <a href="${basePath}/paramsetting/device_type_listUI.action">
                        <i class="icon-text-width"></i>
                        <span class="menu-text"> 装置类型 </span>
                    </a>
                </li>
                <li>
                    <a href="${basePath}/paramsetting/laws_listUI.action">
                        <i class="icon-text-width"></i>
                        <span class="menu-text"> 法规管理 </span>
                    </a>
                </li>

                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-list"></i>
                        <span class="menu-text"> 组件信息设置 </span>

                        <b class="arrow icon-angle-down"></b>
                    </a>

                    <ul class="submenu">
                        <li>
                            <a href="${basePath}/paramsetting/modelinfosetting/device_manage_listUI.action">
                                <i class="icon-double-angle-right"></i>
                                装置管理
                            </a>
                        </li>

                        <li>
                            <a href="${basePath}/paramsetting/modelinfosetting/area_manage_listUI.action">
                                <i class="icon-double-angle-right"></i>
                                区域管理
                            </a>
                        </li>
                        <li>
                            <a href="${basePath}/paramsetting/modelinfosetting/equipment_manage_listUI.action">
                                <i class="icon-double-angle-right"></i>
                                设备管理
                            </a>
                        </li>
                        <li>
                            <a href="${basePath}/paramsetting/modelinfosetting/unit_manage_listUI.action">
                                <i class="icon-double-angle-right"></i>
                                单位管理
                            </a>
                        </li>
                        <li>
                            <a href="${basePath}/paramsetting/modelinfosetting/direction_desc_listUI.action">
                                <i class="icon-double-angle-right"></i>
                                描述方位
                            </a>
                        </li>
                        <li>
                            <a href="${basePath}/paramsetting/modelinfosetting/caculate_type_listUI.action">
                                <i class="icon-double-angle-right"></i>
                                计算类别
                            </a>
                        </li>
                        <li>
                            <a href="${basePath}/paramsetting/modelinfosetting/model_tyoe_listUI.action">
                                <i class="icon-double-angle-right"></i>
                                组件类型
                            </a>
                        </li>
                        <li>
                            <a href="${basePath}/paramsetting/modelinfosetting/model_sub_type_listUI.action">
                                <i class="icon-double-angle-right"></i>
                                组件子类型
                            </a>
                        </li>
                        <li>
                            <a href="${basePath}/paramsetting/modelinfosetting/product_company_listUI.action">
                                <i class="icon-double-angle-right"></i>
                                生产厂家
                            </a>
                        </li>
                        <li>
                            <a href="${basePath}/paramsetting/modelinfosetting/mediun_status_listUI.action">
                                <i class="icon-double-angle-right"></i>
                                介质状态
                            </a>
                        </li>
                        <li>
                            <a href="${basePath}/paramsetting/modelinfosetting/chemical_listUI.action">
                                <i class="icon-double-angle-right"></i>
                                化学品
                            </a>
                        </li>
                        <li>
                            <a href="${basePath}/paramsetting/modelinfosetting/product_stream_listUI.action">
                                <i class="icon-double-angle-right"></i>
                                产品流
                            </a>
                        </li>
                    </ul>
                </li>

                <li>

                    <a href="#" class="dropdown-toggle">
                        <i class="icon-list"></i>
                        <span class="menu-text"> 检测维修设置 </span>

                        <b class="arrow icon-angle-down"></b>
                    </a>

                    <ul class="submenu">
                        <li>
                            <a href="${basePath}/paramsetting/checkrepairsetting/check_fren_listUI.action">
                                <i class="icon-double-angle-right"></i>
                                检测频率
                            </a>
                        </li>

                        <li>
                            <a href="${basePath}/paramsetting/checkrepairsetting/check_apparatus_listUI.action">
                                <i class="icon-double-angle-right"></i>
                                检测仪器
                            </a>
                        </li>
                        <li>
                            <a href="${basePath}/paramsetting/checkrepairsetting/density_manage_listUI.action">
                                <i class="icon-double-angle-right"></i>
                                标准气理论浓度管理
                            </a>
                        </li>
                        <li>
                            <a href="${basePath}/paramsetting/checkrepairsetting/standrd_gas_manage_listUI.action">
                                <i class="icon-double-angle-right"></i>
                                标准气管理
                            </a>
                        </li>
                        <li>
                            <a href="${basePath}/paramsetting/checkrepairsetting/reveal_src_listUI.action">
                                <i class="icon-double-angle-right"></i>
                                泄漏源
                            </a>
                        </li>
                        <li>
                            <a href="${basePath}/paramsetting/checkrepairsetting/repair_measure_listUI.action">
                                <i class="icon-double-angle-right"></i>
                                维修措施
                            </a>
                        </li>
                        <li>
                            <a href="${basePath}/paramsetting/checkrepairsetting/min_check_time_listUI.action">
                                <i class="icon-double-angle-right"></i>
                                最小检测时间
                            </a>
                        </li>
                    </ul>
                </li>

                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-list"></i>
                        <span class="menu-text"> 更改原因设置 </span>

                        <b class="arrow icon-angle-down"></b>
                    </a>

                    <ul class="submenu">
                        <li class="active">
                            <a href="${basePath}/paramsetting/modifyreasonsetting/model_modify_listUI.action">
                                <i class="icon-double-angle-right"></i>
                                组件更改原因
                            </a>
                        </li>

                        <li>
                            <a href="${basePath}/paramsetting/modifyreasonsetting/diff_2_check_listUI.action">
                                <i class="icon-double-angle-right"></i>
                                难于检测原因
                            </a>
                        </li>
                        <li>
                            <a href="${basePath}/paramsetting/modifyreasonsetting/danger_2_check_listUI.action">
                                <i class="icon-double-angle-right"></i>
                                险于检测原因
                            </a>
                        </li>
                        <li>
                            <a href="${basePath}/paramsetting/modifyreasonsetting/temp_2_move_listUI.action">
                                <i class="icon-double-angle-right"></i>
                                暂时移除原因
                            </a>
                        </li>
                        <li>
                            <a href="${basePath}/paramsetting/modifyreasonsetting/forever_2_move_listUI.action">
                                <i class="icon-double-angle-right"></i>
                                永久移除原因
                            </a>
                        </li>
                        <li>
                            <a href="${basePath}/paramsetting/modifyreasonsetting/delay_2_repair_listUI.action">
                                <i class="icon-double-angle-right"></i>
                                延迟维修原因
                            </a>
                        </li>
                        <li>
                            <a href="${basePath}/paramsetting/modifyreasonsetting/no_2_repair_listUI.action">
                                <i class="icon-double-angle-right"></i>
                                无需维修原因
                            </a>
                        </li>
                        <li>
                            <a href="${basePath}/paramsetting/modifyreasonsetting/input_code_by_manu_listUI.action">
                                <i class="icon-double-angle-right"></i>
                                手动输入条形码原因
                            </a>
                        </li>
                        </li>
                    </ul>
                </li>

            </ul><!-- /.nav-list -->

        </div>

        <div class="main-content">             <!-- 右边内容界面-->
            <div class="breadcrumbs" id="breadcrumbs">  <!-- 右边内容界面的导航栏-->
                <script type="text/javascript">
                    try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
                </script>

                <ul class="breadcrumb">
                    <li>
                        <i class="icon-home home-icon"></i>
                        <a href="${basePath}/paramsetting/dept_setting_listUI.action">参数设置</a>
                    </li>
                    <li >无需维修原因</li>
                    <li class="active">编辑</li>
                </ul>
            </div>  <!-- .结束导航栏 -->


            <div class="page-content">     <!-- 右边内容界面的导航栏下的内容主界面-->

                <div class="well">
                    <form  role="form" action="${basePath}/paramsetting/modifyreasonsetting/no_2_repair_edit.action">
                        <div class="form-group center">
                            <label  > 无需维修原因编号 </label> &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <s:textfield name="noNeedRepairReason.noNeedRepairReasonNumber"/>
                        </div>

                        <div class="form-group center">
                            <label  > 无需维修原因名称 </label> &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <s:textfield name="noNeedRepairReason.noNeedRepairReasonName"/>
                        </div>

                        <div class="clearfix form-actions">
                            <div class="center">
                                <button class="btn btn-info" type="button" onclick="doSubmit()">
                                    <i class="icon-ok bigger-110"></i>
                                    Submit
                                </button>
                            </div>
                        </div>
                        <s:hidden name="noNeedRepairReason.id"/>
                        <s:hidden name="noNeedRepairReason.createPerson"/>
                        <s:hidden name="noNeedRepairReason.createTime"/>
                    </form>

                </div>
            </div>
        </div><!-- /.main-content -->

    </div>
</div>






<script type="text/javascript">
    window.jQuery || document.write("<script src='${basePath}/assets/js/jquery-2.0.3.min.js'>"+"<"+"script>");
</script>


<script type="text/javascript">
    if("ontouchend" in document) document.write("<script src='${basePath}/assets/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
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
    jQuery(function($) {
        $('.easy-pie-chart.percentage').each(function(){
            var $box = $(this).closest('.infobox');
            var barColor = $(this).data('color') || (!$box.hasClass('infobox-dark') ? $box.css('color') : 'rgba(255,255,255,0.95)');
            var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)' : '#E2E2E2';
            var size = parseInt($(this).data('size')) || 50;
            $(this).easyPieChart({
                barColor: barColor,
                trackColor: trackColor,
                scaleColor: false,
                lineCap: 'butt',
                lineWidth: parseInt(size/10),
                animate: /msie\s*(8|7|6)/.test(navigator.userAgent.toLowerCase()) ? false : 1000,
                size: size
            });
        })

        <!-- 全选checkbox-->
        $('table th input:checkbox').on('click' , function(){
            var that = this;
            $(this).closest('table').find('tr > td:first-child input:checkbox')
                    .each(function(){
                        this.checked = that.checked;
                        $(this).closest('tr').toggleClass('selected');
                    });

        });


        $('.sparkline').each(function(){
            var $box = $(this).closest('.infobox');
            var barColor = !$box.hasClass('infobox-dark') ? $box.css('color') : '#FFF';
            $(this).sparkline('html', {tagValuesAttribute:'data-values', type: 'bar', barColor: barColor , chartRangeMin:$(this).data('min') || 0} );
        });




        var placeholder = $('#piechart-placeholder').css({'width':'90%' , 'min-height':'150px'});
        var data = [
            { label: "social networks",  data: 38.7, color: "#68BC31"},
            { label: "search engines",  data: 24.5, color: "#2091CF"},
            { label: "ad campaigns",  data: 8.2, color: "#AF4E96"},
            { label: "direct traffic",  data: 18.6, color: "#DA5430"},
            { label: "other",  data: 10, color: "#FEE074"}
        ]
        function drawPieChart(placeholder, data, position) {
            $.plot(placeholder, data, {
                series: {
                    pie: {
                        show: true,
                        tilt:0.8,
                        highlight: {
                            opacity: 0.25
                        },
                        stroke: {
                            color: '#fff',
                            width: 2
                        },
                        startAngle: 2
                    }
                },
                legend: {
                    show: true,
                    position: position || "ne",
                    labelBoxBorderColor: null,
                    margin:[-30,15]
                }
                ,
                grid: {
                    hoverable: true,
                    clickable: true
                }
            })
        }
        drawPieChart(placeholder, data);

        /**
         we saved the drawing function and the data to redraw with different position later when switching to RTL mode dynamically
         so that's not needed actually.
         */
        placeholder.data('chart', data);
        placeholder.data('draw', drawPieChart);



        var $tooltip = $("<div class='tooltip top in'><div class='tooltip-inner'></div></div>").hide().appendTo('body');
        var previousPoint = null;

        placeholder.on('plothover', function (event, pos, item) {
            if(item) {
                if (previousPoint != item.seriesIndex) {
                    previousPoint = item.seriesIndex;
                    var tip = item.series['label'] + " : " + item.series['percent']+'%';
                    $tooltip.show().children(0).text(tip);
                }
                $tooltip.css({top:pos.pageY + 10, left:pos.pageX + 10});
            } else {
                $tooltip.hide();
                previousPoint = null;
            }

        });






        var d1 = [];
        for (var i = 0; i < Math.PI * 2; i += 0.5) {
            d1.push([i, Math.sin(i)]);
        }

        var d2 = [];
        for (var i = 0; i < Math.PI * 2; i += 0.5) {
            d2.push([i, Math.cos(i)]);
        }

        var d3 = [];
        for (var i = 0; i < Math.PI * 2; i += 0.2) {
            d3.push([i, Math.tan(i)]);
        }


        var sales_charts = $('#sales-charts').css({'width':'100%' , 'height':'220px'});
        $.plot("#sales-charts", [
            { label: "Domains", data: d1 },
            { label: "Hosting", data: d2 },
            { label: "Services", data: d3 }
        ], {
            hoverable: true,
            shadowSize: 0,
            series: {
                lines: { show: true },
                points: { show: true }
            },
            xaxis: {
                tickLength: 0
            },
            yaxis: {
                ticks: 10,
                min: -2,
                max: 2,
                tickDecimals: 3
            },
            grid: {
                backgroundColor: { colors: [ "#fff", "#fff" ] },
                borderWidth: 1,
                borderColor:'#555'
            }
        });


        $('#recent-box [data-rel="tooltip"]').tooltip({placement: tooltip_placement});
        function tooltip_placement(context, source) {
            var $source = $(source);
            var $parent = $source.closest('.tab-content')
            var off1 = $parent.offset();
            var w1 = $parent.width();

            var off2 = $source.offset();
            var w2 = $source.width();

            if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
            return 'left';
        }


        $('.dialogs,.comments').slimScroll({
            height: '300px'
        });


        //Android's default browser somehow is confused when tapping on label which will lead to dragging the task
        //so disable dragging when clicking on label
        var agent = navigator.userAgent.toLowerCase();
        if("ontouchstart" in document && /applewebkit/.test(agent) && /android/.test(agent))
            $('#tasks').on('touchstart', function(e){
                var li = $(e.target).closest('#tasks li');
                if(li.length == 0)return;
                var label = li.find('label.inline').get(0);
                if(label == e.target || $.contains(label, e.target)) e.stopImmediatePropagation() ;
            });

        $('#tasks').sortable({
                    opacity:0.8,
                    revert:true,
                    forceHelperSize:true,
                    placeholder: 'draggable-placeholder',
                    forcePlaceholderSize:true,
                    tolerance:'pointer',
                    stop: function( event, ui ) {//just for Chrome!!!! so that dropdowns on items don't appear below other items after being moved
                        $(ui.item).css('z-index', 'auto');
                    }
                }
        );
        $('#tasks').disableSelection();
        $('#tasks input:checkbox').removeAttr('checked').on('click', function(){
            if(this.checked) $(this).closest('li').addClass('selected');
            else $(this).closest('li').removeClass('selected');
        });


    })
</script>
<div style="display:none">
    <script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'>
    </script>
</div>
</body>
</html>

