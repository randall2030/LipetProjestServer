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

        function doDetails() {

            var minSize = $("#minSize").val();
            var maxSize = $("#maxSize").val();
            var minCheckTime = $("#minCheckTime").val();

            var index = $("#size-range-table tr").length - 1;  //最开始为1

            $("#size-range-table").append("<tr>"
                    + "<td><label>" + minSize + "</label> <" + "s:" + "hidden name='sizeRanges[" + index + "].minSize' value='" + minSize + "'/> </td>"
                    + "<td><label>" + maxSize + "</label> <" + "s:" + "hidden  name='sizeRanges[" + index + "].maxSzie' value='" + maxSize + "'/> </td>"
                    + "<td><label>" + minCheckTime + "</label> <" + "s:" + "hidden name='sizeRanges[" + index + "].minCheckTime' value='" + minCheckTime + "'/> </td>"
                    + "</tr>");

        }


    </script>

    <script type="text/javascript">
        $("#moduleType").function(
                findModuleType()
        );

        function findModuleType() {
            var url = "${basePath}/paramsetting/modelinfosetting/model_type_findModelType.action?time=" + new Date().getTime();
            $.post(url, function (backData) {
                var obj = JSON.parse(backData);
                var array = obj.codeList;
                var size = array.length;
                //迭代数组
                for (var i = 0; i < size; i++) {
                    //获取数组中的每个元素
                    var moduleType = array[i].modelTypeName;
                    //去掉重复元素
                    if ($("#moduleType option:contains('" + moduleType + "')").length > 0)
                        $("#moduleType option:contains('" + moduleType + "')").remove();
                    //判断不为空 创建option元素
                    if (moduleType != null && moduleType != "") {
                        var $option = $("<option>" + moduleType + "</option>");
                        //将option元素添加到装置下拉框中
                        $("#moduleType").append($option);
                    }
                }
            });
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
        <%@ include file="../../../parentPage/paramsettingLeftListNavigation.jsp" %>

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
                    <li>检测维修设置</li>
                    <li>最小检测时间</li>
                    <li class="active">添加</li>
                </ul>
            </div>  <!-- .结束导航栏 -->


            <div class="page-content">     <!-- 右边内容界面的导航栏下的内容主界面-->

                <div class="well">
                    <form role="form" id="minCheckTime-form" method="post"
                          action="${basePath}/paramsetting/checkrepairsetting/min_check_time_add.action">
                        <div class="row">
                            <div class="col-md-5 col-md-offset-4">
                                <div class="form-horizontal">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" style="padding-right: 0px">组件类型 </label>
                                        <div class="col-md-6">
                                            <select id="moduleType" name="minCheckTime.moduleType" style="width:170px">
                                                <option>所有组件类型</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-4 control-label" style="padding-right: 0px"> 是否使用 </label>
                                        <div class="col-md-6">&nbsp;
                                            <input type="radio" name="minCheckTime.execute" value=true
                                                   checked="checked"/>是
                                            &nbsp;&nbsp;
                                            <input type="radio" name="minCheckTime.execute" value=false/>否
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <hr>
                            <input type="button" id="addID" class="btn btn-primary" value="添加"
                                   style="margin-bottom:20px;margin-right: 120px;float: right;;">
                            <table id="size-range-table" class="table table-striped table-bordered table-hover">
                                <tr>
                                    <th>尺寸最小值</th>
                                    <th>尺寸最大值</th>
                                    <th>最小检测时间</th>
                                    <th>操作</th>
                                </tr>
                                <tbody id="tbd">
                                </tbody>
                            </table>

                            <div class="clearfix form-actions">
                                <div class="center">
                                    <button class="btn btn-info" type="button" onclick="doSubmit()">
                                        <i class="icon-ok bigger-110"></i>
                                        Submit
                                    </button>

                                </div>
                            </div>
                        </div>


                    </form>


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
<script src="${basePath}/assets/js/flot/jquery.flot.resize.min.js"></script>


<!-- ace scripts -->

<script src="${basePath}/assets/js/ace-elements.min.js"></script>
<script src="${basePath}/assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->

<script type="text/javascript">

    $(document).ready(function () {


        $("#addID").click(function () {

            var Tr = $("<tr></tr>");
            var Td1 = $("<td><input type='text' name='minSize'></td>");
            var Td2 = $("<td><input type='text' name='maxSize'></td>");
            var Td3 = $("<td><input type='text' name='mminCheckTime'></td>");
            var Td4 = $("<td></td>");
            var Del = $("<input id='del' type='button' class='btn btn-primary btn-xs' value='删除'>");


            Del.click(function () {
                Tr.remove();
            });
            Td4.append(Del);
            Tr.append(Td1);
            Tr.append(Td2);
            Tr.append(Td3);
            Tr.append(Td4);
            if ($("table input").val() != "") {
                $("#tbd").append(Tr);
            } else {
                return;
            }
        })
    })


</script>
<div style="display:none">
    <script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'>
    </script>
</div>
</body>
</html>

