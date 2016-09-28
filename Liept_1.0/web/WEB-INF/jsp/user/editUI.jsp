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
                            <span class="blue">创建用户</span>
                        </h1>
                    </div>


                <div  style="margin-top: 40px">

                    <form class="form-horizontal" role="form" action="${basePath}/base/user_edit.action">
                        <div class="form-group">
                            <label class="col-sm-5 control-label no-padding-right red" >用户名:</label>
                            <div class="col-sm-7">
                                <s:textfield  name="user.username"  class="col-xs-5 col-sm-4"></s:textfield>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-5 control-label no-padding-right red" >密码:</label>
                            <div class="col-sm-7">
                                <s:password   name="user.password"  class="col-xs-5 col-sm-4"></s:password>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-5 control-label no-padding-right red" >父公司简称:</label>
                            <div class="col-sm-7">
                                <s:textfield  name="user.parentCompany"  class="col-xs-5 col-sm-4"></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-5 control-label no-padding-right red" >公司简称:</label>
                            <div class="col-sm-7">
                                <s:textfield  name="user.company"  class="col-xs-5 col-sm-4"></s:textfield>

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-5 control-label no-padding-right red" >公司全称:</label>
                            <div class="col-sm-7">
                                <s:textfield  name="user.companyNameCN"  class="col-xs-5 col-sm-4"></s:textfield>
                            </div>
                        </div>
                        <div class="form-group">

                            <label class="col-sm-5 control-label no-padding-right red" >用户状态:</label>
                            <div class="col-sm-7 radio">
                                <s:radio list="#{'true':'可用','false':'禁用'}" name="user.status" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-5 control-label no-padding-right red" >是否对子公司有管理权限:</label>
                            <div class="col-sm-7">&nbsp;
                                <s:radio list="#{'true':'拥有','false':'不拥有'}" name="user.canSelectCompany" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-5 control-label no-padding-right red" >用户权限:</label>
                            <div class="col-sm-7">&nbsp;
                                <s:radio list="#{'true':'可看可修改','false':'只可查看'}" name="user.visitPrivilege" />
                            </div>

                        </div>
                        <div class="form-group center">
                            <button class="btn btn-lg btn-success" style="margin-top: 20px" onclick="doSubmit()">提交</button>
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
