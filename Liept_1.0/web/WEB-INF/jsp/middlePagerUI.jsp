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
<div class="main-container">
    <div class="main-content">
        <div class="row">
            <div class="col-sm-12">
                <div class="login-container">
                    <div class="center">
                        <h1>
                            <i class="icon-leaf green"></i>
                            <span class="red">LDAR</span>
                            <span class="blue">后台管理系统</span>
                        </h1>
                    </div>
                </div>

                <div class="center">
                    <a href="${basePath}/sys/login_entryParentDatabase.action?user.username=${user.username}">
                    <button class="btn btn-lg btn-success" style="margin-top: 70px">设置检测相关信息</button>
                    </a>
                </div>

                <div class="hr hr-15" style="margin-top: 60px"></div>

                <div class="center" style="margin-top: 70px">
                    <h1>
                        <span class="red">进入数据管理平台</span>
                    </h1>
                </div>

                <div class="center">
                    <form action="${basePath}/sys/login_entryChildPlatform.action" method="post">
                        <select class="center" style="width:200px; margin-top: 20px" name="childPlatformName" >
                            <s:iterator value="companys"  id="number">
                                <option ><s:property value='number'/></option>
                            </s:iterator>
                        </select>
                        <s:hidden name="user.id"></s:hidden>
                    </form>

                </div>

                <div class="center">
                    <button class="btn btn-lg btn-success" style="margin-top: 20px" onclick="doSubmit()">进入</button>
                </div>

                <s:if test="user.parentCompany == 'liept' && user.canSelectCompany == true && user.status == true">

                <div class="center">
                    <a href="${basePath}/base/user_addUI.action">
                        <button class="btn btn-lg btn-success" style="margin-top: 20px; margin-right: 20px">创建用户</button>
                    </a>

                    <a href="${basePath}/base/user_listUI.action">
                        <button class="btn btn-lg btn-success" style="margin-top: 20px; margin-right: 20px">管理用户</button>
                    </a>

                    <a href="${basePath}/base/company_addUI.action">
                        <button class="btn btn-lg btn-success" style="margin-top: 20px; margin-right: 20px">登记公司信息</button>
                    </a>
                    <a href="${basePath}/base/company_listUI.action">
                        <button class="btn btn-lg btn-success" style="margin-top: 20px">公司管理</button>
                    </a>
                </div>

                </s:if>
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
