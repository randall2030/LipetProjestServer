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
            <a href="${basePath}/view/module_info_listUI.action">
                <i class="icon-info"></i>
                <span class="menu-text"> 密封点信息 </span>
            </a>
        </li>

        <li>
            <a href="${basePath}/view/picture_manage_listUI.action">
                <i class="icon-picture"></i>
                <span class="menu-text"> 图片管理 </span>
            </a>
        </li>
        <li>
            <a href="${basePath}/view/check_info_listUI.action">
                <i class="icon-info"></i>
                <span class="menu-text"> 检测信息 </span>
            </a>
        </li>
        <li>
            <a href="${basePath}/view/leak_info_listUI.action">
                <i class="icon-info"></i>
                <span class="menu-text"> 泄漏信息 </span>
            </a>
        </li>
        <li>
            <a href="${basePath}/view/delay_repair_info_listUI.action">
                <i class="icon-info"></i>
                <span class="menu-text"> 延迟修复信息 </span>
            </a>
        </li>
        <li>
            <a href="${basePath}/view/repair_info_listUI.action">
                <i class="icon-info"></i>
                <span class="menu-text"> 维修信息 </span>
            </a>
        </li>

        <li>
            <a href="${basePath}/view/view_history_check_listUI.action">
                <i class="icon-info"></i>
                <span class="menu-text">查看历史检测信息 </span>
            </a>
        </li>

    </ul><!-- /.nav-list -->

    <div class="sidebar-collapse" id="sidebar-collapse">
        <i class="icon-double-angle-left" data-icon1="icon-double-angle-left"
           data-icon2="icon-double-angle-right"></i>
    </div>

    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'collapsed')
        } catch (e) {
        }
    </script>
</div>

