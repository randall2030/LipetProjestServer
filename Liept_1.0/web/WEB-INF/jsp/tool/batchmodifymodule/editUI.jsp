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
            <li>批量修改组件</li>
            <li class="active">批量修改</li>
        </ul>
    </div>
        <!-- .结束导航栏 -->


<div class="page-content"> <!-- 右边内容界面的导航栏下的内容主界面-->

<div class="well">
<form role="form" action="${basePath}/tool/batchmodifymodule/batch_modify_module_edit.action">
    <div class="row">
        <div class="col-md-4">
            <div class="form-horizontal">

                <div class="form-group">
                    <label class="control-label col-md-4">装置</label>
                    <div class="col-md-6">
                        <input type="text" name="module.device">
                    </div>
                 </div>

                <div class="form-group">
                    <label class="control-label col-md-4">区域</label>
                    <div class="col-md-6">
                        <input type="text" name="module.area" >
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

                <div class="form-group">
                    <label class="control-label col-md-4">组件类型</label>
                    <div class="col-md-6">
                        <input type="text" name="module.modelType"/>
                    </div>

                </div>

                <div class="form-group">
                    <label class="control-label col-md-4">条形码</label>
                    <div class="col-md-6">
                        <input type="text" name="module.barCode"/>
                    </div>
                </div>

            </div>
        </div>
            <div class="col-md-4">
                <div class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-md-4">法规</label>
                        <div class="col-md-6">
                            <input type="text" name="module.laws"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-4">尺寸（mm）</label>
                        <div class="col-md-6">
                            <input type="text" name="module.sizeMM"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-4">位置描述</label>
                        <div class="col-md-6">
                            <input type="text" name="module.positionDesc"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-4">点X坐标</label>
                        <div class="col-md-6">
                            <input type="text" name="module.imgX"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-4">点Y坐标</label>
                        <div class="col-md-6">
                            <input type="text" name="module.imgY"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-4">热点X坐标</label>
                        <div class="col-md-6">
                            <input type="text" name="module.heatX"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-4">热点Y坐标</label>
                        <div class="col-md-6">
                            <input type="text" name="module.heatY"/>
                        </div>
                    </div>


            </div>
        </div>
        <div class="col-md-4">
            <div class="form-horizontal">
                <div class="form-group">
                    <label class="control-label col-md-4">介质状态</label>
                    <div class="col-md-6">
                        <input type="text" name="module.mediumStatus"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-4">PID图号</label>
                    <div class="col-md-6">
                        <input type="text" name="module.pid"/>
                    </div>
                </div>

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
        </div>

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
    </script>
    <div style="display:none">
    <script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'>
    </script>
    </div>
    </body>
    </html>

