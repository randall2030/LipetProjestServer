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
        <li>
            <a href="${basePath}/paramsetting/device_type_listUI.action">
                <i class="icon-text-width"></i>
                <span class="menu-text"> 装置类型 </span>
            </a>
        </li>
        <li>
            <a href="${basePath}/paramsetting/laws_listUI.action">
                <i class="icon-text-width"></i>
                <span class="menu-text"> 法规管理 </span>
            </a>
        </li>

        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-list"></i>
                <span class="menu-text"> 密封点信息设置 </span>

                <b class="arrow icon-angle-down"></b>
            </a>

            <ul class="submenu">
                <li>
                    <a href="${basePath}/paramsetting/modelinfosetting/device_manage_listUI.action">
                        <i class="icon-double-angle-right"></i>
                        装置管理
                    </a>
                </li>

                <li>
                    <a href="${basePath}/paramsetting/modelinfosetting/area_manage_listUI.action">
                        <i class="icon-double-angle-right"></i>
                        区域管理
                    </a>
                </li>
                <%--<li>--%>
                    <%--<a href="${basePath}/paramsetting/modelinfosetting/equipment_manage_listUI.action">--%>
                        <%--<i class="icon-double-angle-right"></i>--%>
                        <%--设备管理--%>
                    <%--</a>--%>
                <%--</li>--%>

                <%--<li>--%>
                    <%--<a href="${basePath}/paramsetting/modelinfosetting/model_type_listUI.action">--%>
                        <%--<i class="icon-double-angle-right"></i>--%>
                        <%--组件类型--%>
                    <%--</a>--%>
                <%--</li>--%>
            </ul>
        </li>

        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-list"></i>
                <span class="menu-text"> 检测维修设置 </span>

                <b class="arrow icon-angle-down"></b>
            </a>

            <ul class="submenu">
                <%--<li>--%>
                    <%--<a href="${basePath}/paramsetting/checkrepairsetting/check_fren_listUI.action">--%>
                        <%--<i class="icon-double-angle-right"></i>--%>
                        <%--检测频率--%>
                    <%--</a>--%>
                <%--</li>--%>

                <li>
                    <a href="${basePath}/paramsetting/checkrepairsetting/check_apparatus_listUI.action">
                        <i class="icon-double-angle-right"></i>
                        检测仪器
                    </a>
                </li>
                <%--<li>--%>
                    <%--<a href="${basePath}/paramsetting/checkrepairsetting/density_manage_listUI.action">--%>
                        <%--<i class="icon-double-angle-right"></i>--%>
                        <%--标准气理论浓度管理--%>
                    <%--</a>--%>
                <%--</li>--%>
                <%--<li>--%>
                    <%--<a href="${basePath}/paramsetting/checkrepairsetting/standrd_gas_manage_listUI.action">--%>
                        <%--<i class="icon-double-angle-right"></i>--%>
                        <%--标准气管理--%>
                    <%--</a>--%>
                <%--</li>--%>
                <%--<li>--%>
                    <%--<a href="${basePath}/paramsetting/checkrepairsetting/reveal_src_listUI.action">--%>
                        <%--<i class="icon-double-angle-right"></i>--%>
                        <%--泄漏源--%>
                    <%--</a>--%>
                <%--</li>--%>
                <%--<li>--%>
                    <%--<a href="${basePath}/paramsetting/checkrepairsetting/repair_measure_listUI.action">--%>
                        <%--<i class="icon-double-angle-right"></i>--%>
                        <%--维修措施--%>
                    <%--</a>--%>
                <%--</li>--%>
                <li>
                    <a href="${basePath}/paramsetting/checkrepairsetting/min_check_time_listUI.action">
                        <i class="icon-double-angle-right"></i>
                        最小检测时间
                    </a>
                </li>

            </ul>
        </li>

    </ul><!-- /.nav-list -->
    <div class="sidebar-collapse" id="sidebar-collapse">
        <i class="icon-double-angle-left" data-icon1="icon-double-angle-left"
           data-icon2="icon-double-angle-right"></i>
    </div>
</div>
