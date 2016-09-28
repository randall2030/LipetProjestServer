<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="S" uri="/struts-tags" %>
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
    <link rel="stylesheet" href="${basePath}/assets/css/jquery-ui-1.10.3.custom.min.css" />
    <link rel="stylesheet" href="${basePath}/assets/css/jquery.gritter.css" />
    <!-- ace styles -->

    <link rel="stylesheet" href="${basePath}/assets/css/chosen.css" />

    <link rel="stylesheet" href="${basePath}/assets/css/bootstrap-timepicker.css" />
    <link rel="stylesheet" href="${basePath}/assets/css/daterangepicker.css" />
    <link rel="stylesheet" href="${basePath}/assets/css/colorpicker.css" />
    <link rel="stylesheet" href="${basePath}/assets/css/ace.min.css" />
    <link rel="stylesheet" href="${basePath}/assets/css/ace-rtl.min.css" />
    <link rel="stylesheet" href="${basePath}/assets/css/ace-skins.min.css" />


    <!-- ace settings handler -->
    <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
    <script src="${basePath}/js/jquery.min.js"></script>

    <script src="${basePath}/assets/js/date-time/bootstrap-datepicker.min.js"></script>
    <script src="${basePath}/assets/js/ace-elements.min.js"></script>
    <script src="${basePath}/assets/js/ace.min.js"></script>
    <script src="${basePath}/assets/js/ace-extra.min.js"></script>
    <script src="${basePath}/assets/js/bootstrap.min.js"></script>
    <script src="${basePath}/assets/js/typeahead-bs2.min.js"></script>

    <script type="text/javascript">
        function doSubmit(){
            document.forms[0].submit();
        }
    </script>
</head>

<body>

    <%@ include file="../../parentPage/topNavigation.jsp" %>

<div class="main-container" id="main-container">
    <script type="text/javascript">
        try{ace.settings.check('main-container' , 'fixed')}catch(e){}
    </script>
    <div class="main-container-inner">             <!-- 还是最外层-->

        <%@ include file="../../parentPage/viewLeftListNavigation.jsp" %>

        <div class="main-content">             <!-- 右边内容界面-->
            <div class="breadcrumbs" id="breadcrumbs">  <!-- 右边内容界面的导航栏-->
                <script type="text/javascript">
                    try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
                </script>

                <ul class="breadcrumb">
                    <li>
                        <i class="icon-home home-icon"></i>
                        <a href="#">查看</a>
                    </li>
                    <li >组件信息</li>
                    <li class="active">添加</li>
                </ul>
            </div>  <!-- .结束导航栏 -->
            <div class="page-content">     <!-- 右边内容界面的导航栏下的内容主界面-->
                <div class="well">
                    <h5 class="green smaller lighter">组件信息</h5>

                    <form  role="form" action="${basePath}/view/module_info_add.action">
                        <div class="form-group">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <label>装置：</label>
                            <select name="module.device" id="device">
                                <option value=""><s:property value="module.device"></option>
                            </select>
                            <label>区域:</label>
                            <select name="module.area" id="area">
                                <option value=""><s:property value="module.area"></option>
                            </select>
                            <label>设备：</label>
                            <input type="text"   name="module.equipment" size="17">
                            <label>标签号：</label>
                            <input type="text"   name="module.labelNumber" size="17">
                            <label>扩展号</label>
                            <input type="text"   name="module.extendNumber" size="17">
                        </div>

                        <div class="form-group">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <label>密封点编码</label>
                            <input type="text"   name="module.glandNumber" size="17">
                            <label>设备号码</label>
                            <input type="text"   name="module.equipmentCode" size="17">
                        </div>
                        <div class="form-group">
                            <h6 class="green smaller lighter">&nbsp;&nbsp;&nbsp;位置描述</h6>
                        </div>
                        <div class="form-group">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <label>主要：</label>
                            <input type="text"   name="module.mainReference" size="6">
                            <label>其次：</label>
                            <input type="text"   name="module.minorReference" size="6">
                            <label>方向</label>
                            <input type="text"   name="module.mainDirection" size="6">
                            &nbsp;&nbsp;
                            <label>距离</label>
                            <input type="text"  name="module.mainDistance" size="6">米
                            &nbsp;&nbsp;
                            <input type="text" name="module.floor" size="6">
                            <label>层</label>
                            &nbsp;&nbsp;
                            <label>高度</label>
                            <input type="text" name="module.height" size="6">米
                        </div>

                        <div class="form-group">
                            <h6 class="green smaller lighter">&nbsp;&nbsp;&nbsp;&nbsp;	附加条件</h6>
                        </div>
                        <div class="form-group">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <label>组件类型名称</label>
                            <input type="text" name="module.modelType" size="6">
                            <label>尺寸（mm）</label>
                            <input type="text" name="module.sizeMM"  >
                        </div>
                        <div class="form-group">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <label>介质状态</label>
                            <input type="text" name="module.mediumStatus" size="6">
                            <label>变更管理ID </label>
                            <input type="text" name="module.changeManageID"  >
                            <label>产品流 </label>
                            <input type="text" name="module.productStream"  >
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <label>PID图号 </label>
                            <input type="text" name="module.pid" size="22px">
                        </div>

                        <div class="form-group">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <label>添加日期</label>
                            <input type="date" name="module.createTime"/>
                            <label>替换日期</label>
                            <input type="date" name="module.modifyTime"/>
                            <label>年运行时间小时</label>
                            <input type="text" name="module.yearRunTime"  >
                            <label>操作温度/℃</label>
                            <input type="text" name="module.operatorTemperature"   size="12px">
                        </div>

                        <div class="form-group">
                            <label>条形码</label>
                            <input type="text" name="module.barCode"  >
                            <label>生产厂家</label>
                            <input type="text" name="module.productCompany"  size="22px">
                            <label>主要介质</label>
                            <input type="text" name="module.mainMedium"  size="22px">
                        </div>

                        <div class="form-group">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <label>点X坐标</label>
                            <input type="text" name="module.imgX"/>
                            <label>点Y坐标</label>
                            <input type="text" name="module.imgY"/>
                            <label>热点X坐标</label>
                            <input type="text" name="module.heatX"  >
                            <label>热点Y坐标</label>
                            <input type="text" name="module.heatY" size="14px">
                        </div>

                        <div class="form-group">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <label>密封材质</label>
                            <input type="text" name="module.sealMedium" >
                            <label>操作压力/MPa</label>
                            <input type="text" name="module.operatorPress"></br>
                        </div>

                        <div class="form-group">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <label>法规信息</label>
                            <input type="text" name="module.laws"><br/>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="checkbox" name="module.diffToTouch" value="true">难以触及
                            <input type="checkbox"  name="module.diffToCheck" value="true">难于检测
                            <label>难于检测原因</label>
                            <input type="text" name="module.diffToCheckReason">
                            &nbsp;&nbsp;
                            <input type="checkbox" name="module.dangerToCheck" value="true">险于检测
                            <label>难于检测原因</label>
                            <input type="text" name="module.dangerToCheckReason">
                        </div>
                        <div class="form-group">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="checkbox" name="module.pressWork" value="true" >设备负压作业&nbsp;&nbsp;
                            <input type="checkbox" name="module.leakModule" value="true">低泄漏组件&nbsp;&nbsp;
                            <input type="checkbox" name="module.locationZXZGArea" value="true">位于装卸料站储罐区&nbsp;&nbsp;
                            <input type="checkbox" name="module.yearTime300" value="true">年排放时间少于300h&nbsp;&nbsp;
                            <input type="checkbox" name="module.warm" value="true">是否保温&nbsp;&nbsp;
                        </div>

                        <div class="form-group">
                            <h6 class="green smaller lighter">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;永久停止服务</h6>
                        </div>


                        <div class="form-group">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="checkbox"name="module.foreverToMove" value="true">永久删除&nbsp;&nbsp;
                            永久移除服务时间
                            <input type="date" name="module.foreverToMoveTime">&nbsp;&nbsp;
                            永久移除服务原因
                            <select name="module.foreverToMoveReason">
                                <option value="">请选择</option>
                                <option>不属于LDAR项目阀门</option>
                                <option>组件重复</option>
                                <option>永久停止服务</option>
                                <option>该组件不应在项目中</option>
                                <option>焊接组件</option>
                                <option>组件被拆除</option>
                            </select>
                        </div>

                        <div class="form-group">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <label>备注 </label>
                            <textarea style="width:435px;height:60px" name="module.appendDesc"></textarea>
                        </div>


                        <div class="form-group center">
                            <button class="btn btn-info" type="button" onclick="doSubmit()">
                                <i class="icon-ok bigger-110"></i>
                                Submit
                            </button>
                        </div>

                    </form>


                </div>

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

<script type="text/javascript">


</script>
<script type="text/javascript">
</script>

<link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
<script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
<link rel="stylesheet" href="jqueryui/style.css">
<script>
    $(function() {
        $( "#accordion" ).accordion();
        collapsible: true;
    });
</script>
<div style="display:none">
    <script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'>
    </script>
</div>
</body>
</html>


