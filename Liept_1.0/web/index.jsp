<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    //跳转到登录页面  访问loginUI.action
    String basePath = request.getContextPath();
    String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+basePath+"/sys/login_loginUI.action";
    response.sendRedirect(path);
%>