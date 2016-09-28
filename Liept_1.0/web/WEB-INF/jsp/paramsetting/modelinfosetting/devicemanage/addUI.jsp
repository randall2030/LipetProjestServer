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

    <link rel="stylesheet" href="${basePath}/assets/css/font-down-google.css" />

    <!-- ace styles -->
    <link rel="stylesheet" href="${basePath}/assets/css/ace.min.css" />
    <link rel="stylesheet" href="${basePath}/assets/css/ace-rtl.min.css" />
    <link rel="stylesheet" href="${basePath}/assets/css/ace-skins.min.css" />


    <!-- ace settings handler -->

    <script src="${basePath}/assets/js/ace-extra.min.js"></script>
    <script src="${basePath}/js/jquery.min.js"></script>

    <script type="text/javascript">
        function doSubmit(){
            document.forms[0].submit();
        }
    </script>
</head>

<body>
<%@ include file="../../../parentPage/topNavigation.jsp" %>

<div class="main-container" id="main-container">
    <script type="text/javascript">
        try{ace.settings.check('main-container' , 'fixed')}catch(e){}
    </script>
    <div class="main-container-inner">             <!-- 还是最外层-->

        <%@ include file="../../../parentPage/paramsettingLeftListNavigation.jsp" %>

        <div class="main-content">             <!-- 右边内容界面-->
            <div class="breadcrumbs" id="breadcrumbs">  <!-- 右边内容界面的导航栏-->
                <script type="text/javascript">
                    try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
                </script>

                <ul class="breadcrumb">
                    <li>
                        <i class="icon-home home-icon"></i>
                        <a href="#">参数设置</a>
                    </li>
                    <li >组件信息设置</li>
                    <li >装置管理</li>
                    <li class="active">添加</li>
                </ul>
            </div>  <!-- .结束导航栏 -->


            <div class="page-content">     <!-- 右边内容界面的导航栏下的内容主界面-->

                <div class="well">
                    <form  role="form" action="${basePath}/paramsetting/modelinfosetting/device_manage_add.action">
                        <div class="form-group center">
                            <label  >装置编号： </label> &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="text" id="deviceNumber" name="deviceInfo.deviceNumber" placeholder="装置编号" />
                        </div>

                        <div class="form-group center">
                            <label  >装置： </label> &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="text" name="deviceInfo.deviceName"/>
                        </div>
                        <div class="form-group center">
                            <label  >装置类别： </label> &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <select name="deviceInfo.deviceType" style="width:170px">
                                <option>炼油</option>
                                <option>化工</option>
                            </select>
                        </div>
                        <div class="form-group center">
                            <label  >套数： </label> &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="text" name="deviceInfo.sequenceNumber"/>
                        </div>
                        <!--查询 部门名称-->
                        <script type="text/javascript">
                            function findDeptName(){
                                var url = "${basePath}/paramsetting/dept_setting_findDeptName.action?time="+new Date().getTime();
                                $.post(url,function(backData){
                                    var obj = JSON.parse(backData);
                                    var array = obj.codeList;
                                    var size = array.length;
                                    //迭代数组
                                    for(var i=0;i<size;i++){
                                        //获取数组中的每个元素
                                        var deptName = array[i].deptName;
                                        //去掉重复元素
                                        if ($("#deptName option:contains('" + deptName + "')").length > 0)
                                            $("#deptName option:contains('" + deptName + "')").remove();
                                        //判断不为空 创建option元素
                                        if (deptName != null && deptName != ""){
                                            var $option = $("<option>"+deptName+"</option>");
                                            //将option元素添加到装置下拉框中
                                            $("#deptName").append( $option );
                                        }
                                    }
                                });
                            }
                        </script>
                        <!--初始化 查询部门名称  装置名称-->
                        <script type="text/javascript">
                            $("#deptName").function(
                                    findDeptName()
                            );
                        </script>

                        <div class="clearfix form-actions">
                            <div class="center">
                                <button class="btn btn-info" type="button" onclick="doSubmit()">
                                    <i class="icon-ok bigger-110"></i>
                                    Submit
                                </button>
                            </div>
                        </div>
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
        <!-- 全选checkbox-->
        $('table th input:checkbox').on('click' , function(){
            var that = this;
            $(this).closest('table').find('tr > td:first-child input:checkbox')
                    .each(function(){
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

