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

                    <form class="form-horizontal" role="form" action="${basePath}/base/company_edit.action">
                        <div class="form-group">
                            <label class="col-sm-2 control-label no-padding-right red" >公司名称:</label>
                            <div class="col-sm-4">
                                <s:textfield type="text"  name="company.companyName"  />
                            </div>

                            <label class="col-sm-2 control-label no-padding-right red" >公司简称:</label>
                            <div class="col-sm-4">
                                <s:textfield  type="text" name="company.companySimpleName"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label no-padding-right red" >父公司:</label>
                            <div class="col-sm-4">
                                <s:textfield  type="password" name="company.parentCompany" />
                            </div>

                            <label class="col-sm-2 control-label no-padding-right red" >父公司简称:</label>
                            <div class="col-sm-4">
                                <s:textfield  type="text"  name="company.parentCompanySimpleName"  />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label no-padding-right red" >公司创建时间:</label>
                            <div class="col-sm-4">
                                <s:textfield name="company.buildDate" >
                                    <s:param name="value"><s:date name="company.buildDate" format="yyyy-MM-dd"/></s:param>
                                </s:textfield>
                            </div>

                            <label class="col-sm-2 control-label no-padding-right red" >公司注册资产:</label>
                            <div class="col-sm-4">
                                <s:textfield  type="text"  name="company.registerAsset" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label no-padding-right red" >行业代码:</label>
                            <div class="col-sm-4">
                                <s:textfield  type="text"  name="company.industryCode" />
                            </div>

                            <label class="col-sm-2 control-label no-padding-right red" >公司地址:</label>
                            <div class="col-sm-4">
                                <s:textfield  type="text"  name="company.companyAddress" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label no-padding-right red" >法人代表:</label>
                            <div class="col-sm-4">
                                <s:textfield  type="text"  name="company.lawRepresent" />
                            </div>

                            <label class="col-sm-2 control-label no-padding-right red" >法人代表电话:</label>
                            <div class="col-sm-4">
                                <s:textfield  type="text"  name="company.lawRepresentPhone" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label no-padding-right red" >安保负责人:</label>
                            <div class="col-sm-4">
                                <s:textfield  type="text"  name="company.environmentPerson" />
                            </div>

                            <label class="col-sm-2 control-label no-padding-right red" >安保负责人电话:</label>
                            <div class="col-sm-4">
                                <s:textfield  type="text"  name="company.environmentPersonPhone" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label no-padding-right red" >LDAR检测开始时间:</label>
                            <div class="col-sm-4">
                                <div class="col-sm-4">
                                    <s:textfield name="company.ldarStartTime" >
                                        <s:param name="value"><s:date name="company.ldarStartTime" format="yyyy-MM-dd"/></s:param>
                                    </s:textfield>
                                </div>
                            </div>

                            <label class="col-sm-2 control-label no-padding-right red" >检测点数:</label>
                            <div class="col-sm-4">
                                <s:textfield  type="text"  name="company.checkPoint" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label no-padding-right red" >生成主要材料:</label>
                            <div class="col-sm-4">
                                <s:textarea name="company.mainMaterial" />
                            </div>

                            <label class="col-sm-2 control-label no-padding-right red" >生产中间材料:</label>
                            <div class="col-sm-4">
                                <s:textarea name="company.middleMaterial" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label no-padding-right red" >主要产品:</label>
                            <div class="col-sm-4">
                                <s:textarea name="company.mainProduct" />
                            </div>

                            <label class="col-sm-2 control-label no-padding-right red" >备注:</label>
                            <div class="col-sm-4">
                                <s:textarea  name="company.note" />
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
