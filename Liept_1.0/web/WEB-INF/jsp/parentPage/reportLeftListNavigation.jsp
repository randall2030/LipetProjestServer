<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8"/>
</head>

<div class="sidebar" id="sidebar">
    <script type="text/javascript">
        try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
    </script>

    <ul class="nav nav-list">
        <li >
            <a href="${basePath}/report/model_foun_accountUI.action">
                <i class="icon-file-text"></i>
                <span class="menu-text"> 密封点基础台账报告 </span>
            </a>
        </li>

        <li >
            <a href="${basePath}/report/check_history_listUI.action">
                <i class="icon-file-text"></i>
                <span class="menu-text"> 检测历史报告 </span>
            </a>
        </li>

        <li>
            <a href="${basePath}/report/leak_history_listUI.action">
                <i class="icon-file-text"></i>
                <span class="menu-text"> 泄露历史报告 </span>
            </a>
        </li>
        <li>
            <a href="${basePath}/report/repair_table_listUI.action">
                <i class="icon-file-text"></i>
                <span class="menu-text"> 维修工单 </span>
            </a>
        </li>
        <li>
            <a href="${basePath}/report/module_picture_account_listUI.action">
                <i class="icon-file-text"></i>
                <span class="menu-text"> 密封点图片台账 </span>
            </a>
        </li>
        <li>
            <a href="${basePath}/report/let_caculate_listUI.action">
                <i class="icon-file-text"></i>
                <span class="menu-text"> 排放计算 </span>
            </a>
        </li>
        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-list"></i>
                <span class="menu-text"> 统计 </span>

                <b class="arrow icon-angle-down"></b>
            </a>

            <ul class="submenu">
                <li>
                    <a href="${basePath}/report/statistics/module_statistics_listUI.action">
                        <i class="icon-double-angle-right"></i>
                        密封点统计
                    </a>
                </li>

                <li>
                    <a href="${basePath}/report/statistics/check_statistics_listUI.action">
                        <i class="icon-double-angle-right"></i>
                        检测统计
                    </a>
                </li>
                <li>
                    <a href="${basePath}/report/statistics/leak_statistics_listUI.action">
                        <i class="icon-double-angle-right"></i>
                        泄露统计
                    </a>
                </li>
                <li>
                    <a href="${basePath}/report/statistics/module_check_table_listUI.action">
                        <i class="icon-double-angle-right"></i>
                        密封点检测统计表
                    </a>
                </li>
                <li>
                    <a href="${basePath}/report/statistics/tendency_statistics_listUI.action">
                        <i class="icon-double-angle-right"></i>
                        趋势统计
                    </a>
                </li>
                <li>
                    <a href="${basePath}/report/statistics/let_number_statistics_listUI.action">
                        <i class="icon-double-angle-right"></i>
                        排放量统计
                    </a>
                </li>
            </ul>
        </li>
    </ul><!-- /.nav-list -->

    <div class="sidebar-collapse" id="sidebar-collapse">
        <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
    </div>

    <script type="text/javascript">
        try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
    </script>
</div>