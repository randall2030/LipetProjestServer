<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8"/>
</head>

<div class="navbar navbar-default" id="navbar">

    <script type="text/javascript">
        try {
            ace.settings.check('navbar', 'fixed')
        } catch (e) {
        }
    </script>


    <div class="navbar-container" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <img class="nav-user-photo" src="${basePath}/images/liept_logo.png" alt="susion's Photo" />
                <small>
                    LDAR后台管理系统
                </small>
            </a><!-- /.brand -->
        </div><!-- /.navbar-header -->

        <div class="navbar-header pull-right" role="navigation">

            <ul class="nav ace-nav">

                <li><a href="${basePath}/sys/home_welcomeUI.action">&nbsp &nbsp 欢迎页 &nbsp &nbsp</a></li>
                <li><a href="${basePath}/sys/home_homeUI.action">&nbsp &nbsp 项目首页 &nbsp &nbsp</a></li>
                <li><a href="${basePath}/view/module_info_listUI.action">&nbsp &nbsp 查看 &nbsp &nbsp</a></li>
                <li><a href="${basePath}/scenemanage/allocate_taskUI.action">&nbsp 现场管理 &nbsp</a></li>
                <li><a href="${basePath}/paramsetting/device_type_listUI.action">参数设置</a></li>
                <li><a href="${basePath}/tool/verify_lawUI.action">&nbsp &nbsp 工具 &nbsp &nbsp</a></li>
                <li><a href="${basePath}/report/model_foun_accountUI.action">&nbsp &nbsp 报告 &nbsp &nbsp</a></li>
                <li class="light-blue">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<span class="user-info">
									<small>欢迎光临,</small>
									${user.username}
								</span>

                        <i class="icon-caret-down"></i>
                    </a>

                    <ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                        <li>
                            <a href="${basePath}/sys/login_loginoff.action">
                                <i class="icon-off"></i>
                                退出
                            </a>
                        </li>
                    </ul>
                </li>
            </ul><!-- /.ace-nav -->
        </div><!-- /.navbar-header -->
    </div><!-- /.container -->
</div>