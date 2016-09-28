<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
    <link rel="stylesheet" href="${basePath}/assets/css/colorbox.css" />


    <!-- ace styles -->

    <link rel="stylesheet" href="${basePath}/assets/css/ace.min.css"/>
    <link rel="stylesheet" href="${basePath}/assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="${basePath}/assets/css/ace-skins.min.css"/>

    <!--[if lte IE 8]>
    <link rel="stylesheet" href="${basePath}/assets/css/ace-ie.min.css"/>
    <![endif]-->


    <script src="${basePath}/assets/js/ace-extra.min.js"></script>

    <script type="text/javascript">
        function doSearch(){
            document.getElementById("from-search").submit();
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
                        <a href="${basePath}/view/module_info_listUI.action">查看</a>
                    </li>

                    <li class="active">图片信息</li>
                </ul>
            </div>  <!-- .结束导航栏 -->


            <div class="page-content">     <!-- 右边内容界面的导航栏下的内容主界面-->
                <div id="accordion" class="accordion-style1 panel-group">
                    <div class="well">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                                        <i class="icon-angle-down bigger-110" data-icon-hide="icon-angle-down" data-icon-show="icon-angle-right"></i>
                                        <!-- 标题-->
                                        过滤条件
                                    </a>
                                </h4>
                            </div>

                            <div class="panel-collapse collapse in" id="collapseOne">
                                <div class="panel-body">
                                    <!-- 内容-->
                                    <form class="form-vertical"  id="from-search" role="form" method="post"
                                          action="${basePath}/view/picture_manage_listUI.action?pageNo=1">

                                        <div class="form-group">  <!--  表格的一行-->
                                            <label>标签号：</label>
                                            <s:textfield name="labelNumber" id="labelNumber"/>
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <a href="javascript:doSearch()">
                                                <button class="btn btn-info" type="button">查询</button>
                                            </a>
                                        </div>
                                    </form>
                                </div>
                            </div>

                        </div>

                    </div><!-- /span -->
                </div>

                <div class="well">
                    <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th class="center">
                                <label>
                                    <input type="checkbox" class="ace"/>
                                    <span class="lbl"></span>
                                </label>
                            </th>
                            <th>标签号</th>
                            <th>原始图片</th>
                            <th>标点图片</th>
                            <th>关联密封点数</th>
                            <th></th>
                        </tr>
                        </thead>

                        <tbody class="ace-thumbnails">
                        <s:iterator value="pageResult.items" status="st">
                            <tr>
                                <td class="center">
                                    <label>
                                        <input type="checkbox" name="selectedRow" class="ace"
                                               value="<s:property value='id'/>"/>
                                        <span class="lbl"></span>
                                    </label>
                                </td>
                                <td>
                                    <s:property value="importPictureLabelNumber"/>
                                </td>

                                <td class="hidden-480">
                                    <li>
                                        <a href="${basePath}/images/<s:property value='originalPictureSavePath'/>"  data-rel="colorbox">
                                            <img alt="150x150" height="80" width="80" src="${basePath}/images/<s:property value='originalPictureSavePath'/>"/>
                                        </a>

                                    </li>
                                </td>

                                <td class="hidden-480">
                                    <li>
                                        <a href="${basePath}/images/<s:property value='markPictureSavePath'/>"  data-rel="colorbox">
                                            <img alt="150x150" height="80" width="80" src="${basePath}/images/<s:property value='markPictureSavePath'/>"/>
                                        </a>
                                    </li>
                                </td>

                                <td class="hidden-480 align-center">
                                    <s:property value="containModuleNumber"/>
                                </td>
                                <td>
                                    <div class="visible-md visible-lg hidden-sm hidden-xs btn-group" >
                                        <button class="btn btn-xs btn-info" >
                                                <a style="color:white;" href="${basePath}/view/picture_manage_ViewConnectedModuleUI.action?importPictureHistory.id=<s:property value='id'/>">
                                                    <label class="icon-info">&nbsp; &nbsp;查看关联密封点</label>
                                                </a>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        </s:iterator>
                        </tbody>

                    </table>

                    <form id="form_pageNavigator" action="${basePath}/view/picture_manage_listUI.action">
                        <jsp:include page="/base/pageNavigator.jsp"></jsp:include>
                    </form>

                </div>


            </div>
        </div>

    </div><!-- /.main-content -->
</div><!--结束main-container-inner -->
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


<script src="${basePath}/assets/js/jquery.colorbox-min.js"></script>
<!-- ace scripts -->

<script src="${basePath}/assets/js/ace-elements.min.js"></script>
<script src="${basePath}/assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->

<script type="text/javascript">



    jQuery(function ($) {

        var colorbox_params = {
            reposition:true,
            scalePhotos:true,
            scrolling:false,
            previous:'<i class="icon-arrow-left"></i>',
            next:'<i class="icon-arrow-right"></i>',
            close:'&times;',
            current:'{current} of {total}',
            maxWidth:'100%',
            maxHeight:'100%',
            onOpen:function(){
                document.body.style.overflow = 'hidden';
            },
            onClosed:function(){
                document.body.style.overflow = 'auto';
            },
            onComplete:function(){
                $.colorbox.resize();
            }
        };

        $('.ace-thumbnails [data-rel="colorbox"]').colorbox(colorbox_params);

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
    <script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'>
    </script>
</div>
</body>
</html>


