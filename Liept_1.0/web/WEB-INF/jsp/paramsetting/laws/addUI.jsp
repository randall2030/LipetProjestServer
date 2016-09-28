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
    <meta charset="utf-8"/>
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
    <script src="${basePath}/js/jquery.min.js"></script>

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
        <%@ include file="../../parentPage/paramsettingLeftListNavigation.jsp" %>
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
                        <a href="#">参数设置</a>
                    </li>
                    <li>法规</li>
                    <li class="active">添加</li>
                </ul>
            </div>  <!-- .结束导航栏 -->


            <div class="page-content">     <!-- 右边内容界面的导航栏下的内容主界面-->

                <div class="well">

                    <form role="form" class="center" action="${basePath}/paramsetting/laws_add.action" id="law">
                        <div class="form-group">&nbsp; &nbsp; &nbsp; &nbsp;
                            <label> 法规代码 </label>
                            <input name="law.lawCode" type="text" size="20px"/>
                        </div>

                        <div class="form-group">&nbsp; &nbsp; &nbsp; &nbsp;
                            <label>法规描述 </label>
                            <textarea name="law.lawDesc" cols="" rows="5"></textarea>
                        </div>
                        <div class="form-group">&nbsp;&nbsp;&nbsp;&nbsp;
                            <label style="margin-left: 23px;">备注 </label>&nbsp;&nbsp; &nbsp;
                            <textarea name="law.lawRemark" cols="" rows="5"></textarea>
                        </div>

                        <div class="form-group">&nbsp; &nbsp; &nbsp; &nbsp;
                            <label>当前法规 </label>
                            <input name="law.currentLaw" type="radio" value=true />是
                            <input name="law.currentLaw" type="radio" value=false />否
                        </div>

                        <div class="form-group">
                            <button class="btn btn-info" type="button" onclick="doSubmit()">
                                <i class="icon-ok bigger-110"></i>
                                保存
                            </button>
                        </div>
                    </form>

                </div>
            </div>

        </div>
    </div>
</div><!-- /.main-content -->


<!--</div>
</div>-->
<script type="text/javascript" src="${basePath}/assets/js/jquery-2.1.4.min.js"></script>
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
<div style="display:none">
    <script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'>
    </script>

</div>
</body>
</html>

