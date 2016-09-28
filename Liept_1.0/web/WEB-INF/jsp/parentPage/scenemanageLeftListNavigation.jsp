<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8"/>
</head>

<div class="sidebar" id="sidebar">
    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'fixed')
        } catch (e) {
        }
    </script>

    <ul class="nav nav-list">
        <li>
            <a href="${basePath}/scenemanage/allocate_task_listUI.action">
                <i class="icon-tasks"></i>
                <span class="menu-text"> 分配任务 </span>
            </a>
        </li>

        <li>
            <a href="${basePath}/scenemanage/calibrate_listUI.action">
                <i class="icon-edit"></i>
                <span class="menu-text"> 校准管理 </span>
            </a>
        </li>
        <li>
            <a href="${basePath}/scenemanage/weather_param_listUI.action">
                <i class="icon-cloud"></i>
                <span class="menu-text"> 气象五参数 </span>
            </a>
        </li>
        <%--<li>--%>
            <%--<a href="${basePath}/scenemanage/temp_remove_module_listUI.action">--%>
                <%--<i class="icon-move"></i>--%>
                <%--<span class="menu-text"> 暂时移除组件 </span>--%>
            <%--</a>--%>
        <%--</li>--%>

    </ul><!-- /.nav-list -->
    <div class="sidebar-collapse" id="sidebar-collapse">
        <i class="icon-double-angle-left" data-icon1="icon-double-angle-left"
           data-icon2="icon-double-angle-right"></i>
    </div>
</div>
