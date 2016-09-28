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
                    <li class="active">添加法规详情</li>
                </ul>
            </div>  <!-- .结束导航栏 -->


            <div class="page-content">     <!-- 右边内容界面的导航栏下的内容主界面-->
                <div class="well">

                    <form action="${basePath}/paramsetting/laws_addLawDetail.action">

                        <div class="form-group">
                            <h4 class="blue">包含组件类型</h4>
                            <div class="checkbox">
                                <label>
                                    <input name="moduleType" type="checkbox" value="全部组件类型" class="ace"/>
                                    <span class="lbl">全部组件类型</span>
                                </label>
                            </div>

                            <div class="checkbox">
                            <label>
                                <input name="moduleType" type="checkbox" value="搅拌器（轴封）" class="ace"/>
                                <span class="lbl">搅拌器（轴封）</span>
                            </label>

                            <label>
                                <input name="moduleType" type="checkbox" value="连接件（螺纹连接）" class="ace"/>
                                <span class="lbl">连接件（螺纹连接）</span>
                            </label>
                            <label>
                                <input name="moduleType" type="checkbox" value="法兰" class="ace"/>
                                <span class="lbl">法兰</span>
                            </label>
                            <label>
                                <input name="moduleType" type="checkbox" value="开口阀或开口管线" class="ace"/>
                                <span class="lbl">开口阀或开口管线</span>
                            </label>
                            <label>
                                <input name="moduleType" type="checkbox" value="泵（轴封）" class="ace"/>
                                <span class="lbl">泵（轴封）</span>
                            </label>
                            <label>
                                <input name="moduleType" type="checkbox" value="其他" class="ace"/>
                                <span class="lbl">其他</span>
                            </label>
                            <label>
                                <input name="moduleType" type="checkbox" value="泄压设备（安全阀）" class="ace"/>
                                <span class="lbl">泄压设备（安全阀）</span>
                            </label>
                            <label>
                                <input name="moduleType" type="checkbox" value="取样连接系统" class="ace"/>
                                <span class="lbl">取样连接系统</span>
                            </label>
                            <label>
                                <input name="moduleType" type="checkbox" value="阀门" class="ace"/>
                                <span class="lbl">阀门</span>
                            </label>
                            <label>
                                <input name="moduleType" type="checkbox" value="压缩机（轴封）" class="ace"/>
                                <span class="lbl">压缩机（轴封）</span>
                            </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <h4 class="blue">包含介质状态</h4>
                            <div class="checkbox">
                                <label>
                                    <input name="mediumStatus" type="checkbox" value="全部介质状态" class="ace"/>
                                    <span class="lbl">全部介质状态</span>
                                </label>
                            </div>

                            <div class="checkbox">
                                <label>
                                    <input name="mediumStatus" type="checkbox" value="气体" class="ace"/>
                                    <span class="lbl">气体</span>
                                </label>

                                <label>
                                    <input name="mediumStatus" type="checkbox" value="轻液" class="ace"/>
                                    <span class="lbl">轻液</span>
                                </label>
                                <label>
                                    <input name="mediumStatus" type="checkbox" value="重液" class="ace"/>
                                    <span class="lbl">重液</span>
                                </label>
                            </div>
                        </div>


                        <h4 class="blue">检测阈值</h4>
                        <div class="form-group">
                            <label class="green">常规检测 PPM</label>

                            <div>
                                <label>PPM泄露阈值</label>&nbsp;&nbsp;&nbsp;<input type="text" name="lawDetails.ppmLeakThreshold">&nbsp;&nbsp;
                                <label>首次尝试修复时间(天)</label>&nbsp;&nbsp;&nbsp;<input type="text" name="lawDetails.PPMFirstRepairTime">&nbsp;&nbsp;
                                <label>最终尝试修复时间(天)</label>&nbsp;&nbsp;&nbsp;<input type="text" name="lawDetails.PPMFinalRepairTime">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="green">AOV</label>

                            <div>
                                <label>DPM</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="lawDetails.DPM">&nbsp;&nbsp;
                                <label>首次尝试修复时间(天)</label>&nbsp;&nbsp;&nbsp;<input type="text" name="lawDetails.DPMFirstRepairTime">&nbsp;&nbsp;
                                <label>最终尝试修复时间(天)</label>&nbsp;&nbsp;&nbsp;<input type="text" name="lawDetails.DPMFinalRepairTime">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="green">常规检测频率</label>
                            <div>
                                <select style="width: 200px;" name="lawDetails.checkFre">
                                    <option>每周巡检</option>
                                    <option>月度检测</option>
                                    <option>季度检测</option>
                                    <option>半年度检测</option>
                                    <option>年度检测</option>
                                    <option>两年检测</option>
                                    <option>豁免</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="green">AOV检测频率</label>
                            <div>
                                <select style="width: 200px;" name="lawDetails.AOV">
                                    <option>每周巡检</option>
                                    <option>月度检测</option>
                                    <option>季度检测</option>
                                    <option>半年度检测</option>
                                    <option>年度检测</option>
                                    <option>两年检测</option>
                                    <option>豁免</option>
                                </select>
                            </div>
                        </div>

                        <s:hidden name="law.id"></s:hidden>

                        <div class="center">
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

