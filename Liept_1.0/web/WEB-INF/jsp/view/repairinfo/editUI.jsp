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


    <script src="${basePath}/assets/js/ace-extra.min.js"></script>

    <![endif]-->
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
                        <a href="${basePath}/view/check_process_listUI.action">查看</a>
                    </li>

                    <li>维修信息</li>
                    <li class="active">修改</li>
                </ul>
            </div>  <!-- .结束导航栏 -->


            <div class="page-content">     <!-- 右边内容界面的导航栏下的内容主界面-->

                <div class="well">
                    <form role="form" action="${basePath}/view/repair_info_editUI.action">
                        <div class="form-group center">
                            <label> 部门编号 </label> &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <s:textfield name="dept.deptNumber"/>
                        </div>
                        <div class="form-group center">
                            <label>上级部门 </label> &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                            <s:textfield name="dept.upDept"/>
                        </div>
                        <div class="form-group center">
                            <label> 部门名称 </label> &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <s:textfield name="dept.deptName"/>
                        </div>

                        <div class="clearfix form-actions">
                            <div class="center">
                                <button class="btn btn-info" type="button" onclick="doSubmit()">
                                    <i class="icon-ok bigger-110"></i>
                                    Submit
                                </button>
                            </div>
                        </div>
                        <s:hidden name="check.id"/>
                    </form>

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

            <script src="assets/js/date-time/bootstrap-datepicker.min.js"></script>
            <!-- ace scripts -->

            <script src="${basePath}/assets/js/ace-elements.min.js"></script>
            <script src="${basePath}/assets/js/ace.min.js"></script>

            <!-- inline scripts related to this page -->

            <script type="text/javascript">
                jQuery(function ($) {

                    $('.easy-pie-chart.percentage').each(function () {
                        var $box = $(this).closest('.infobox');
                        var barColor = $(this).data('color') || (!$box.hasClass('infobox-dark') ? $box.css('color') : 'rgba(255,255,255,0.95)');
                        var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)' : '#E2E2E2';
                        var size = parseInt($(this).data('size')) || 50;
                        $(this).easyPieChart({
                            barColor: barColor,
                            trackColor: trackColor,
                            scaleColor: false,
                            lineCap: 'butt',
                            lineWidth: parseInt(size / 10),
                            animate: /msie\s*(8|7|6)/.test(navigator.userAgent.toLowerCase()) ? false : 1000,
                            size: size
                        });
                    })


                    jQuery(function ($) {

                        $('[data-rel=tooltip]').tooltip({container: 'body'});
                        $('[data-rel=popover]').popover({container: 'body'});

                        $('.date-picker').datepicker({autoclose: true}).next().on(ace.click_event, function () {
                            $(this).prev().focus();
                        });
                        $('input[name=date-range-picker]').daterangepicker().prev().on(ace.click_event, function () {
                            $(this).next().focus();
                        });


                    });


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
                <script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript'
                        charset='gb2312'>
                </script>
            </div>
</body>
</html>


