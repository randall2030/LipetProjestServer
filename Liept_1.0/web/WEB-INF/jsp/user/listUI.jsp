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
                        <span class="blue">用户列表</span>
                    </h1>
                </div>


                <div style="margin-top: 40px">

                    <form  method="post">
                        <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th class="center">
                                    <label>
                                        <input type="checkbox" class="ace"/>
                                        <span class="lbl"></span>
                                    </label>
                                </th>
                                <th>用户名</th>
                                <th>公司全称</th>
                                <th>父公司简称</th>
                                <th>公司简称</th>
                                <th>访问权限</th>
                                <th>是否有管理子公司权限</th>
                                <th>用户状态</th>
                                <th>创建时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>

                            <tbody>
                            <s:iterator value="pageResult.items" status="st">
                                <tr>
                                    <td class="center">
                                        <label>
                                            <input type="checkbox" name="selectedRow" id="selectALL" class="ace"
                                                   value="<s:property value='id'/>"/>
                                            <span class="lbl"></span>
                                        </label>
                                    </td>

                                    <td>
                                        <s:property value="username"/>
                                    </td>

                                    <td><s:property value="companyNameCN"/></td>

                                    <td><s:property value="parentCompany"/></td>

                                    <td><s:property value="company"/></td>

                                    <td>
                                        <s:if test="visitPrivilege == true">可查看可修改</s:if>
                                        <s:else> 只可查看</s:else>
                                    </td>

                                    <td>
                                        <s:if test="canSelectCompany == true">拥有</s:if>
                                        <s:else> 不拥有</s:else>
                                    </td>
                                    <td>
                                        <s:if test="status == true">可用</s:if>
                                        <s:else> 禁用</s:else>
                                    </td>

                                    <td >
                                        <s:date name="createTime" format="yyyy-MM-dd HH:mm:ss"/>
                                    </td>

                                    <td>
                                        <div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
                                            <a href="${basePath}/base/user_editUI.action?user.id=<s:property value='id'/>">
                                                <i class="icon-edit bigger-120"></i>
                                            </a>
                                            <a href="${basePath}/base/user_delete.action?user.id=<s:property value='id'/>">
                                                <i class="icon-trash bigger-120"></i>
                                            </a>

                                        </div>
                                    </td>
                                </tr>
                            </s:iterator>
                            </tbody>

                        </table>
                    </form>


                    <form id="form_pageNavigator" action="${basePath}/base/user_listUI.action">
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
