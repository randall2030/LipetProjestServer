<%@ taglib prefix="s" uri="/struts-tags" %>
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

    <link rel="stylesheet" href="${basePath}/assets/css/font-down-google.css"/>

    <link rel="stylesheet" href="${basePath}/assets/css/ace.min.css"/>
    <link rel="stylesheet" href="${basePath}/assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="${basePath}/assets/css/ace-skins.min.css"/>

    <!--[if lte IE 8]>
    <link rel="stylesheet" href="${basePath}/assets/css/ace-ie.min.css"/>
    <![endif]-->


    <script src="${basePath}/assets/js/ace-extra.min.js"></script>

    <link rel="stylesheet" href="../assets/css/datepicker.css"/>

    <!--[if lt IE 9]>
    <script src="${basePath}/assets/js/html5shiv.js"></script>
    <script src="${basePath}/assets/js/respond.min.js"></script>
    <![endif]-->

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

                    <li>检测信息</li>
                    <li class="active">修改</li>
                </ul>
            </div>  <!-- .结束导航栏 -->


            <div class="page-content">     <!-- 右边内容界面的导航栏下的内容主界面-->

                <div class="well">

                    <form method="post" action="${basePath}/view/check_info_edit.action?editCheckInfo.moduleCheckId=<s:property value='moduleCheck.id'/>">

                        <div class="form-group">
                            <label class="green">常规检测数据</label>
                            <div>
                                <div>
                                    开始时间:&nbsp;&nbsp;&nbsp;<input type="text" name="editCheckInfo.startTime" value="<s:date name="moduleCheck.startTime" format="yyyy-MM-dd HH:mm:ss"/>">
                                    结束时间:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="editCheckInfo.endTime" value="<s:date name="moduleCheck.endTime" format="yyyy-MM-dd HH:mm:ss"/>">
                                    检测人: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <input  type="text" name="editCheckInfo.checkPerson" value="<s:property value="moduleCheck.checkPerson"/>" /><br>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="green">仪器数据</label>
                            <div>
                                <div>
                                    检测仪器:&nbsp;&nbsp;&nbsp; <input  type="text" name="editCheckInfo.checkEquipment" value="<s:property value="moduleCheck.checkEquipment"/>" />
                                    净PPM读数:&nbsp;&nbsp; <input  type="text" name="editCheckInfo.PPMNumber" value="<s:property value="moduleCheck.PPMNumber"/>" />
                                    检测背景值:&nbsp;&nbsp; <input  type="text" name="editCheckInfo.backgroundPPMNumber" value="<s:property value="moduleCheck.backgroundPPMNumber"/>" />
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="green">泄露信息</label>
                            <div>
                                <div>
                                    是否泄露:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:radio list="#{'true':'是','false':'否'}" name="editIsLeak" />
                                    泄露源:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:textfield name="moduleCheck.leakSource"/>
                                </div>
                            </div>
                        </div>

                        <button class="btn btn-info" type="button" onclick="doSubmit()">
                            <i class="icon-ok bigger-55"></i>
                            保存修改
                        </button>

                        <s:hidden name="editPageNo"/>

                    </form>

                </div>

            </div>
        </div>

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

    })
</script>
<div style="display:none">
    <script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'>
    </script>
</div>
</body>
</html>


