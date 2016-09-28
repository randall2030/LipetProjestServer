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
            <a href="${basePath}/tool/verify_lawUI.action">
                <i class="icon-check"></i>
                <span class="menu-text"> 验证法规 </span>
            </a>
        </li>

        <li>
            <a href="${basePath}/tool/start_new_check_listUI.action">
                <i class="icon-star"></i>
                <span class="menu-text"> 开始新检测周期 </span>
            </a>
        </li>

        <li>
            <a href="${basePath}/tool/import_module_listUI.action">
                <i class="glyphicon-import"></i>
                <span class="menu-text"> 导入密封点 </span>
            </a>
        </li>
        <li>
            <a href="${basePath}/tool/import_picture_listUI.action">
                <i class="glyphicon-import"></i>
                <span class="menu-text"> 导入图片 </span>
            </a>
        </li>
        <li>
            <a href="${basePath}/tool/batch_modify_module_listUI.action">
                <i class="icon-edit"></i>
                <span class="menu-text"> 批量修改 </span>
            </a>
        </li>
    </ul><!-- /.nav-list -->

    <div class="sidebar-collapse" id="sidebar-collapse">
        <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
    </div>

    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'collapsed')
        } catch (e) {
        }
    </script>

</div>
