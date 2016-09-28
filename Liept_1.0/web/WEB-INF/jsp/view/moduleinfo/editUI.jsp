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

    <link rel="stylesheet" href="${basePath}/assets/css/font-down-google.css"/>


    <!-- ace styles -->

    <link rel="stylesheet" href="${basePath}/assets/css/ace.min.css"/>
    <link rel="stylesheet" href="${basePath}/assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="${basePath}/assets/css/ace-skins.min.css"/>


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
                        <a href="#">查看</a>
                    </li>
                    <li>组件信息</li>
                    <li class="active">修改</li>
                </ul>
            </div>  <!-- .结束导航栏 -->
            <div class="page-content">     <!-- 右边内容界面的导航栏下的内容主界面-->
                <div class="well">
                    <h5 class="green smaller lighter">组件信息</h5>

                    <form role="form" method="post" action="${basePath}/view/module_info_edit.action">

                        <table  cellspacing="0" cellpadding="0" border = "0">

                            <tr>
                                <td >
                                    <label>装&nbsp;置：&nbsp;</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.device"/>
                                </td>
                                <td>
                                    <label>&nbsp;区&nbsp;域：</label></td>
                                <td>
                                    <s:textfield  type="text" name="module.area" />
                                </td>
                                <td>
                                    <label>&nbsp;设&nbsp;备: &nbsp;</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.equipment" />
                                </td>
                                <td>
                                    <label>&nbsp;标&nbsp;签&nbsp;号：</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.labelNumber"/>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <label>扩&nbsp;展&nbsp;号:</label>
                                </td>
                                <td>
                                    <s:textfield type="text" name="module.extendNumber" />
                                </td>
                                <td>
                                    <label>&nbsp;密封点编码：</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.glandNumber" />
                                </td>
                                <td>
                                    <label>&nbsp;设备号码：</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.equipmentCode" />
                                </td>
                                <td>
                                    <label>&nbsp;主&nbsp;要：</label>
                                </td>
                                <td>
                                    <s:textfield type="text" name="module.mainReference" />
                                </td>

                            </tr>

                            <tr>
                            <td>
                                <label>其&nbsp;次：</label>
                            </td>
                            <td>
                            <s:textfield  type="text" name="module.minorReference" />
                            </td>
                            <td>
                                <label>&nbsp;方&nbsp;向：</label>
                            </td>
                            <td>
                                <s:textfield  type="text" name="module.mainDirection" />
                            </td>
                            <td>
                                <label>&nbsp;距&nbsp;离&nbsp;(m):</label>
                            </td>
                            <td>
                                <s:textfield  type="text" name="module.mainDistance" />
                            </td>
                            <td>
                                <label>&nbsp;层&nbsp;数：&nbsp;</label>
                            </td>
                            <td>
                                <s:textfield  type="text" name="module.floor"/>
                            </td>



                            </tr>

                            <tr>
                                <td>
                                    <label>高&nbsp;度&nbsp;(m)：</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.height"/>
                                </td>
                                <td>
                                    <label>&nbsp;组件类型名称:</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.modelType"/>
                                </td>
                                <td>
                                    <label>&nbsp;尺寸（mm）:</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.sizeMM"/>
                                </td>
                                <td>
                                    <label>&nbsp;介质状态：</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.mediumStatus" />
                                </td>


                            </tr>

                            <tr>
                                <td>
                                    <label>变更管理ID：</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.changeManageID"/>
                                </td>
                                <td>
                                    <label>&nbsp;产品流： </label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.productStream"/>
                                </td>
                                <td>
                                    <label>&nbsp;PID图号： </label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.pid"/>
                                </td>
                                <td>
                                    <label>&nbsp;添加日期：</label>
                                </td>
                                <td>
                                    <s:textfield  type="date" name="module.createTime"/>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <label>替换日期：</label>
                                </td>
                                <td>
                                    <s:textfield  type="date" name="module.modifyTime" />
                                </td>
                                <td>
                                    <label>&nbsp;年运行时间小时：</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.yearRunTime"/>
                                </td>
                                <td>
                                    <label>&nbsp;操作温度/℃：</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.operatorTemperature" />
                                </td>
                                <td>
                                    <label>&nbsp;条形码：</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.barCode"/>
                                </td>

                            </tr>

                            <tr>
                                <td>
                                    <label>生产厂家：</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.productCompany" />
                                </td>
                                <td>
                                    <label>&nbsp;主要介质：</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.mainMedium" />
                                </td>
                                <td>

                                </td>
                                <td>

                                </td>
                                <td>

                                </td>
                                <td>

                                </td>
                                <td>

                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <label>点X坐标：</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.imgX"/>
                                </td>
                                <td>
                                    <label>&nbsp;点Y坐标：</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.imgY"/>
                                </td>
                                <td>
                                    <label>&nbsp;热点X坐标：</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.heatX"/>
                                </td>
                                <td>
                                    <label>&nbsp;热点Y坐标</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.heatY" />
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <label>密封材质：</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.sealMedium"/>
                                </td>
                                <td>
                                    <label>&nbsp;操作压力/MPa：</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.operatorPress"/>
                                </td>
                                <td>
                                    <label>&nbsp;法规信息：</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.laws"/>
                                </td>
                                <td>
                                    <label>&nbsp;难以触及：</label>
                                </td>
                                <td>
                                    <s:radio list="#{'是':'是','否':'否'}" name="module.diffToTouch"/>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <label>难于检测：</label>
                                </td>
                                <td>
                                    <s:radio list="#{'是':'是','否':'否'}" name="module.diffToCheck"/>
                                </td>
                                <td>
                                    <label>&nbsp;难于检测原因：</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.diffToCheckReason"/>
                                </td>
                                <td>
                                    <label>&nbsp;险于检测：</label>
                                </td>
                                <td>
                                    <s:radio list="#{'是':'是','否':'否'}" name="module.dangerToCheck"/>
                                </td>
                                <td>
                                    <label>&nbsp;难于检测原因：</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.dangerToCheckReason"/>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <label>设备负压作业：</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.pressWork"/>
                                </td>
                                <td>
                                    <label>&nbsp;低泄漏组件：</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.leakModule"/>
                                </td>
                                <td>
                                    <label>&nbsp;位于装卸料站储罐区：</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.locationZXZGArea"/>
                                </td>
                                <td>
                                    <label>&nbsp;年排放时间少于300h：</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.yearTime300"/>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <label>是否保温：</label>
                                </td>
                                <td>
                                    <s:textfield  type="text" name="module.warm"/>
                                </td>
                            </tr>

                            <tr>
                                <td colspan="7" ><center><h4 class="green smaller lighter">永久停止服务</h4></center></td>
                            </tr>

                            </table>


                        <div class="form-group">
                            <label>永久删除：</label>
                            <s:textfield  type="text" name="module.foreverToMove"/>
                            <label>永久移除服务时间：</label>
                            <s:textfield  type="text" name="module.foreverToMoveTime"/>
                            <label>永久移除服务原因：</label>
                            <select name="module.foreverToMoveReason">
                                <option value=""><s:property value="module.foreverToMoveTime"/></option>
                                <option>不属于LDAR项目阀门：</option>
                                <option>组件重复：</option>
                                <option>永久停止服务：</option>
                                <option>该组件不应在项目中：</option>
                                <option>焊接组件：</option>
                                <option>组件被拆除：</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label>备注： </label>&nbsp;&nbsp;
                            <textarea style="width:435px;height:60px" name="module.appendDesc"></textarea>
                        </div>


                        <s:hidden name="module.id"></s:hidden>

                        <s:hidden name="module.mainUnit"></s:hidden>
                        <s:hidden name="module.picturePath"></s:hidden>
                        <s:hidden name="module.heightUnit"></s:hidden>


                        <s:hidden name="module.leak"></s:hidden>
                        <s:hidden name="module.hasCheck"></s:hidden>
                        <s:hidden name="module.hasAllocate"></s:hidden>
                        <s:hidden name="module.taskId"></s:hidden>


                        <div class="form-group center">
                            <button class="btn btn-info" type="button" onclick="doSubmit()">
                                <i class="icon-ok bigger-110"></i>
                                Submit
                            </button>
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
<script src="${basePath}/assets/js/jquery.easy-pie-chart.min.js"></script>
<script src="${basePath}/assets/js/jquery.sparkline.min.js"></script>
<script src="${basePath}/assets/js/flot/jquery.flot.min.js"></script>
<script src="${basePath}/assets/js/flot/jquery.flot.pie.min.js"></script>
<script src="${basePath}/assets/js/flot/jquery.flot.resize.min.js"></script>

<!-- ace scripts -->

<script src="${basePath}/assets/js/ace-elements.min.js"></script>
<script src="${basePath}/assets/js/ace.min.js"></script>
<link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
<link rel="stylesheet" href="jqueryui/style.css">
<script>
    $(function () {
        $("#accordion").accordion();
        collapsible: true;
    });
</script>
<div style="display:none">
    <script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'>
    </script>
</div>
</body>
</html>


