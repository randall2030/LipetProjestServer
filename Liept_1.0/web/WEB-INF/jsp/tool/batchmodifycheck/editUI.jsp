<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
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


    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300"/>

    <!-- ace styles -->

    <link rel="stylesheet" href="${basePath}/assets/css/ace.min.css"/>
    <link rel="stylesheet" href="${basePath}/assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="${basePath}/assets/css/ace-skins.min.css"/>


    <!-- ace settings handler -->

    <script src="${basePath}/assets/js/ace-extra.min.js"></script>

    <script type="text/javascript">
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
    <div class="main-container-inner"> <!-- 还是最外层-->
        <%@ include file="../../parentPage/toolLeftListNavigation.jsp" %>

        <div class="main-content"> <!-- 右边内容界面-->
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
                        <a href="#">工具</a>
                    </li>
                    <li>批量修改检测</li>
                    <li class="active">批量修改</li>
                </ul>
            </div>
            <!-- .结束导航栏 -->


            <div class="page-content"> <!-- 右边内容界面的导航栏下的内容主界面-->

                <div class="well">
                    <form role="form" action="${basePath}/tool/batchmodifymodule/batch_modify_check_edit.action">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-horizontal">

                                   <%-- <div class="form-group">
                                        <label class="control-label col-md-4">结束时间</label>
                                        <div class="col-md-6">
                                            <input type="date" name="module.moduleCheck.endTime" style="width: 170px">
                                        </div>
                                    </div>--%>

                                    <div class="form-group">
                                        <label class="control-label col-md-4">装置</label>
                                        <div class="col-md-6">
                                            <input type="text" name="module.device" >
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-4">区域</label>
                                        <div class="col-md-6">
                                            <input type="text" name="module.area"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-4">设备</label>
                                        <div class="col-md-6">
                                            <input type="text" name="module.equipment"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-4">标签号</label>
                                        <div class="col-md-6">
                                            <input type="text" name="module.labelNumber"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-4">扩展号</label>
                                        <div class="col-md-6">
                                            <input type="text" name="module.extendNumber"/>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-horizontal">
                                    <div class="form-group">
                                        <label class="control-label col-md-4">PID图号</label>
                                        <div class="col-md-6">
                                            <input type="text" name="module.pid"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-4">附加描述</label>
                                        <div class="col-md-6">
                                            <input type="text" name="module.appendDesc"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-4">PPM读数</label>
                                        <div class="col-md-6">
                                            <input type="text" name="module.moduleCheck.PPMNumber"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-4">背景值PPM读数</label>
                                        <div class="col-md-6">
                                            <input type="text" name="module.moduleCheck.backgroundPPMNumber"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-4">检测人</label>
                                        <div class="col-md-6">
                                            <input type="text" name="module.moduleCheck.checkPerson"/>
                                        </div>
                                    </div>


                                </div>
                            </div>

                            <div class="col-md-4">
                                <div class="form-horizontal">

                                    <div class="form-group">
                                        <label class="control-label col-md-4">组件类型编号</label>
                                        <div class="col-md-6">
                                            <input type="text" name="module.modelType"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-4">尺寸（mm）</label>
                                        <div class="col-md-6">
                                            <input type="text" name="module.sizeMM"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-4">泄漏源</label>
                                        <div class="col-md-6">
                                            <input type="text" name="module.moduleCheck.leakSource"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-4">泄漏</label>
                                        <div class="col-md-6">
                                            <input type="radio" name="module.moduleCheck.leakCheck" value="true"/>是&nbsp;&nbsp;
                                            <input type="radio" name="module.moduleCheck.leakCheck" value="false"/>否&nbsp;&nbsp;
                                            <input type="radio" name="module.moduleCheck.leakCheck" value="" checked/>不变更
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="control-label col-md-4">难于检测 </label>
                                        <div class="col-md-6">
                                            <input type="radio" name="module.diffToCheck" value="true"/>是&nbsp;&nbsp;
                                            <input type="radio" name="module.diffToCheck" value="false"/>否&nbsp;&nbsp;
                                            <input type="radio" name="module.diffToCheck" value="" checked/>不变更
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-4">延迟修复</label>
                                        <div class="col-md-6">
                                            <input type="radio" name="module.moduleCheck.pushInDelayRepair" value="true"/>是&nbsp;&nbsp;
                                            <input type="radio" name="module.moduleCheck.pushInDelayRepair" value="false"/>否&nbsp;&nbsp;
                                            <input type="radio" name="module.moduleCheck.pushInDelayRepair" value="" checked/>不变更
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <!-- <div class="col-md-4">
                                 <div class="form-horizontal">


                                     <div class="form-group">
                                         <label class="control-label col-md-4">难于检测</label>
                                         <div class="col-md-6">
                                             <input type="radio" name="module.diffToCheck" value="true"/>是&nbsp;&nbsp;
                                             <input type="radio" name="module.diffToCheck" value="false"/>否&nbsp;&nbsp;
                                             <input type="radio" name="module.diffToCheck" value="" checked/>不变更
                                         </div>
                                     </div>

                                     <div class="form-group">
                                         <label class="control-label col-md-4">险于检测</label>
                                         <div class="col-md-6">
                                             <input type="radio" name="module.dangerToCheck" value="true"/>是&nbsp;&nbsp;
                                             <input type="radio" name="module.dangerToCheck" value="false"/>否&nbsp;&nbsp;
                                             <input type="radio" name="module.dangerToCheck" value="" checked />不变更
                                         </div>
                                     </div>

                                     <div class="form-group">
                                         <label class="control-label col-md-4">永久移除</label>
                                         <div class="col-md-6">
                                             <input type="radio" name="module.foreverToMove" value="true"/>是&nbsp;&nbsp;
                                             <input type="radio" name="module.foreverToMove" value="false"/>否&nbsp;&nbsp;
                                             <input type="radio" name="module.foreverToMove" value="" checked/>不变更
                                         </div>
                                     </div>

                                     <div class="form-group">
                                         <label class="control-label col-md-4">暂时移除</label>
                                         <div class="col-md-6">
                                             <input type="radio" name="module.tempToMove" value="true"/>是&nbsp;&nbsp;
                                             <input type="radio" name="module.tempToMove" value="false"/>否&nbsp;&nbsp;
                                             <input type="radio" name="module.tempToMove" value="" checked/>不变更
                                         </div>
                                     </div>

                                 </div>
                             </div>-->
                        </div>
                        <div class="clearfix form-actions">
                            <div class="center">
                                <button class="btn btn-info" type="button" onclick="doSubmit()">
                                    <i class="icon-ok bigger-110"></i>
                                    Submit
                                </button>
                            </div>
                        </div>
                    </form>
                </div><!--墙-->

            </div><!-- 右边内容界面的导航栏下的内容主界面  结束-->

        </div><!-- 内容主界面结束 -->
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
                { label: "social networks", data: 38.7, color: "#68BC31"},
                { label: "search engines", data: 24.5, color: "#2091CF"},
                { label: "ad campaigns", data: 8.2, color: "#AF4E96"},
                { label: "direct traffic", data: 18.6, color: "#DA5430"},
                { label: "other", data: 10, color: "#FEE074"}
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
                if(this.checked) $(this).closest('li').editClass('selected');
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
