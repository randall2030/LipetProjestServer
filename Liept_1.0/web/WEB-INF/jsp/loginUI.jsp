<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    pageContext.setAttribute("basePath", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户登录</title>
    <link rel="shortcut icon" href="http://115.29.244.99:1234/user/favicon.ico">
    <link href="../assets/KF/bootstrap.min.css" rel="stylesheet">
    <link href="../assets/KF/font-awesome.min.css" rel="stylesheet">
    <link href="../assets/KF/animate.min.css" rel="stylesheet">
    <link href="../assets/KF/style.min.css" rel="stylesheet">
    <style>
        .aa{width:0;height:0;position:fixed;left:50%;rigth:50%;top:50%;bottom:50%;}
        .aaa{width:600px;height:320px;margin-left:-200px; margin-top:-180px;}
    </style>
    <script type="text/javascript">
        function doSubmit() {
            document.forms[0].submit();
        }
    </script>

</head>
<body style="background-size:100%; background-image:url(${basePath}/images/loginBackground.png)">
<div class="aa">
    <div class="middle-box text-center loginscreen  animated fadeInDown">

        <div class="aaa">

            <form method="post" action="${basePath}/sys/login_login.action">
                <div class="form-group">
                    <input type="text" class="form-control"  name="user.username" placeholder="用户名">
                </div>

                <div class="form-group">
                    <input type="password" class="form-control" name="user.password" placeholder="密码">
                </div>

                <button class="btn btn-primary block full-width m-b" type="submit" onclick="doSubmit()">登 录</button>

            </form>
        </div>
    </div>
</div>


<script src="../assets/KF/jquery.min.js"></script>
<script src="../assets/KF/bootstrap.min.js"></script>
<script type="text/javascript" src="../assets/KF/stats" charset="UTF-8"></script>

</body></html>