<%@ page contentType="text/html; charset=UTF-8" language="java" %>
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

    <!-- fonts -->

    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300"/>

    <!-- ace styles -->

    <link rel="stylesheet" href="${basePath}/assets/css/ace.min.css"/>
    <link rel="stylesheet" href="${basePath}/assets/css/ace-rtl.min.css"/>

    <script type="text/javascript">
        function doSubmit() {
            document.forms[0].submit();
        }
    </script>

</head>

<body >
<div class="main-container">
    <div class="main-content">
        <div class="row">
            <div class="col-xs-10">
                <div class="center">
                    <h1>
                        <i class="icon-leaf green"></i>
                        <span class="red">LDAR</span>
                        <span class="blue">后台管理系统</span>
                    </h1>
                    <h1>
                        <span class="blue">公司列表</span>
                    </h1>
                </div>


                <div style="margin-top: 40px">
                    <form  method="post">
                        <div style="overflow:scroll;width: 100%;">
                        <table id="sample-table-1" class="table table-striped table-bordered table-hover" style="width: 1500px;">
                            <thead>
                            <tr>
                                <th>公司名称</th>
                                <th>公司简称</th>
                                <th>父公司名称</th>
                                <th>父公司简称</th>
                                <th>公司创建时间</th>
                                <th>公司注册资产</th>
                                <th>公司行业代码</th>
                                <th>公司地址</th>
                                <th>公司法人代表</th>
                                <th>公司法人代表电话</th>
                                <th>LDAR检测开始时间</th>
                                <th>检测点数</th>
                                <th></th>
                            </tr>
                            </thead>

                            <tbody>
                            <s:iterator value="pageResult.items" status="st">
                                <tr>
                                    <td>
                                        <s:property value="companyName"/>
                                    </td>

                                    <td><s:property value="companySimpleName"/></td>

                                    <td><s:property value="parentCompany"/></td>

                                    <td><s:property value="parentCompanySimpleName"/></td>
                                    <td >
                                        <s:date name="buildDate" format="yyyy-MM-dd HH:mm:ss"/>
                                    </td>
                                    <td><s:property value="registerAsset"/></td>
                                    <td><s:property value="industryCode"/></td>
                                    <td><s:property value="companyAddress"/></td>
                                    <td><s:property value="lawRepresent"/></td>
                                    <td><s:property value="lawRepresentPhone"/></td>

                                    <td >
                                        <s:date name="ldarStartTime" format="yyyy-MM-dd HH:mm:ss"/>
                                    </td>
                                    <td><s:property value="checkPoint"/></td>



                                    <td>
                                        <div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
                                            <a href="${basePath}/base/company_editUI.action?company.id=<s:property value='id'/>">
                                                <i class="icon-edit bigger-120"></i>
                                            </a>
                                            <a href="${basePath}/base/company_delete.action?company.id=<s:property value='id'/>">
                                                <i class="icon-trash bigger-120"></i>
                                            </a>
                                        </div>
                                    </td>
                                </tr>
                            </s:iterator>
                            </tbody>

                        </table>

                        </div>
                    </form>


                    <form id="form_pageNavigator" action="${basePath}/base/company_listUI.action">
                        <jsp:include page="/base/pageNavigator.jsp"></jsp:include>
                    </form>

                </div>
            </div>
        </div>


    </div><!-- /.row -->
</div>
</div><!-- /.main-container -->

<!-- basic scripts -->

<!--[if !IE]> -->

<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>

<!-- <![endif]-->

<!--[if IE]>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<![endif]-->

<!--[if !IE]> -->

<script type="text/javascript">
    window.jQuery || document.write("<script src='${basePath}/assets/js/jquery-2.0.3.min.js'>" + "<" + "/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
    window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>" + "<" + "/script>");
</script>
<![endif]-->

<script type="text/javascript">
    if ("ontouchend" in document) document.write("<script src='${basePath}/assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
</script>

<!-- inline scripts related to this page -->

<div style="display:none">
    <script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script>
</div>
</body>
</html>
