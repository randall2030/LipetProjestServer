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

<body class="login-layout">
<div class="main-container" >
    <div class="main-content">
        <div class="row">
            <div class="col-xs-12">
                <div class="center">
                    <h1>
                        <i class="icon-leaf green"></i>
                        <span class="red">LDAR</span>
                        <span class="blue">后台管理系统</span>
                    </h1>
                    <h1>
                        <span class="blue">登记公司信息</span>
                    </h1>
                </div>


                <div  style="margin-top: 40px">

                    <form class="form-horizontal" role="form" action="${basePath}/base/company_add.action">
                        <div class="form-group">
                            <label class="col-sm-2 control-label no-padding-right red" >公司名称:</label>
                            <div class="col-sm-4">
                                <input type="text"  name="company.companyName" placeholder="公司名称不可重复"  />
                            </div>

                            <label class="col-sm-2 control-label no-padding-right red" >公司简称:</label>
                            <div class="col-sm-4">
                                <input type="text"  name="company.companySimpleName" placeholder="公司简称不可重复"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label no-padding-right red" >父公司:</label>
                            <div class="col-sm-4">
                                <input type="text" name="company.parentCompany" />
                            </div>

                            <label class="col-sm-2 control-label no-padding-right red" >父公司简称:</label>
                            <div class="col-sm-4">
                                <input type="text"  name="company.parentCompanySimpleName" placeholder="公司简称不可重复" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label no-padding-right red" >公司创建时间:</label>
                            <div class="col-sm-4">
                                <input type="date" name="company.buildDate"/>
                            </div>
                        </div>

                        <div class="form-group center">
                            <button class="btn btn-lg btn-success" style="margin-top: 20px" onclick="doSubmit()">创建公司</button>
                        </div>
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
