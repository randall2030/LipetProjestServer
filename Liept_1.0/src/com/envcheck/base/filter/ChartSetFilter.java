package com.envcheck.base.filter;

import com.envcheck.base.dynamic_change_datasource.DataSourceConstant;
import com.envcheck.base.dynamic_change_datasource.DataSourceContextHolder;
import com.envcheck.base.dynamic_change_datasource.UserContextHolder;
import com.envcheck.base.user.bean.User;
import com.envcheck.base.utils.Constant;
import com.opensymphony.xwork2.ActionContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Created by susion on 2016/5/16.
 */
public class ChartSetFilter implements  Filter{


    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");


        //处理用户
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String requestUrl = request.getRequestURI();

        if(user != null){
            String mapKey = Constant.DATABASE_PRIFIX + Constant.DIVIDE_CHAR;
            if(user.getParentCompany() != null && !user.getParentCompany().trim().equals("")){
                mapKey =  mapKey+user.getParentCompany()+Constant.DIVIDE_CHAR+user.getCompany();
            }else {
                mapKey = mapKey + user.getCompany();
            }

            DataSourceContextHolder.setDataSourceName(DataSourceConstant.datasourceMap.get(mapKey));
            UserContextHolder.setCurrentUser(user);
        }/*else{
            if(!requestUrl.contains("login_loginUI.action") && !requestUrl.contains("index.jsp")
                    && !requestUrl.contains("login_login.action")){
                throw  new RuntimeException("用户未登录");
            }
        }*/

        chain.doFilter(request, response);  //放行

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

}
