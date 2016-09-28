package com.envcheck.login.action;

import com.envcheck.base.dynamic_change_datasource.DataSourceConstant;
import com.envcheck.base.dynamic_change_datasource.DataSourceContextHolder;
import com.envcheck.base.dynamic_change_datasource.UserContextHolder;
import com.envcheck.base.user.bean.User;
import com.envcheck.base.user.service.IUserService;
import com.envcheck.base.utils.Constant;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.base.utils.StringUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by susion on 2016/5/9.
 */
public class LoginAction extends ActionSupport {

    private User user;
    private IUserService userService;
    private String loginResult;
    private String childPlatformName;
    private Set<String> companys;

    public String login(){


        if(user != null){
            String userName = user.getUsername();
            String password = user.getPassword();

            if(userName != null && password != null) {

                DataSourceContextHolder.setDataSourceName(DataSourceConstant.datasourceMap.get(Constant.PEAK_COMPANY));

                QueryHelper helper = new QueryHelper(User.class, "u");
                helper.addConditions("u.username=?", userName);
                helper.addConditions("u.password=?", password);
                user = userService.findUserByNameAndPassword(helper);

                if (user != null) {

                    if (Constant.PEAK_COMPANY.equals(user.getParentCompany()) && user.isCanSelectCompany() && user.isStatus()) {

                        companys = new HashSet<>();

                        List<User> users = userService.getAll();

                        if (users != null) {
                            for (User user : users) {

                                if(user.getParentCompany() != null && !user.getParentCompany().trim().equals("") && !user.getParentCompany().equals(Constant.PEAK_COMPANY)){
                                    companys.add(user.getCompanyNameCN());
                                }else if(!user.getParentCompany().equals(Constant.PEAK_COMPANY)){
                                    companys.add(user.getCompanyNameCN());
                                }

                            }
                        }

                        HttpSession session = ServletActionContext.getRequest().getSession();
                        session.setAttribute("user", user);  //在request的filter中做切换数据库的处理

                        return "middlePagerUI";
                    }


                    if (user.getParentCompany() != null && !user.getParentCompany().trim().equals("") && user.isCanSelectCompany() && user.isStatus()) {

                        companys = new HashSet<>();

                        List<User> users = userService.findUserByParentCompany(user.getParentCompany());

                        if (users != null) {
                            for (User user : users) {
                                companys.add(user.getCompanyNameCN());
                            }
                        }

                        HttpSession session = ServletActionContext.getRequest().getSession();
                        session.setAttribute("user", user);  //在request的filter中做切换数据库的处理

                        return "middlePagerUI";
                    }

                    if (user.isStatus()) {

                        //把user放到session中
                        HttpSession session = ServletActionContext.getRequest().getSession();
                        session.setAttribute("user", user);  //在request的filter中做切换数据库的处理
                        return "welcomeUI";
                    } else {
                        loginResult = "用户不可用";
                    }


                }else{
                    loginResult="请输入正确的用户名或密码";
                }
            }
        }


        //存到域中 传给jsp
        ServletActionContext.getRequest().setAttribute("loginResult",loginResult);

        return "loginUI";
    }

    public String entryChildPlatform(){

        if(childPlatformName != null){
            User user = userService.findUserByCompanyNameCn(childPlatformName);  //随便找到一个满足条件的user

            if(user == null){  //其实user是不可能为null的
                return "middlePagerUI";
            }

            HttpSession session = ServletActionContext.getRequest().getSession();
            session.setAttribute("user", user);  //在request的filter中做切换数据库的处理
        }

        return "welcomeUI";
    }

    public String entryParentDatabase(){

        if(user != null){
            if(Constant.PEEK_USERNAME.equals(user.getUsername())){
                user = userService.findUserByName(user.getUsername());
                HttpSession session = ServletActionContext.getRequest().getSession();
                session.setAttribute("user", user);  //在request的filter中做切换数据库的处理
            }else{
                throw new RuntimeException("非顶级账号！");
            }
        }

        return "welcomeUI";
    }


    public String loginUI(){
        return "loginUI";
    }

    public String loginoff(){
        //注销用户
        ServletActionContext.getContext().getSession().put("user", null);
        return "loginUI";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public String getLoginResult() {
        return loginResult;
    }

    public void setLoginResult(String loginResult) {
        this.loginResult = loginResult;
    }

    public Set<String> getCompanys() {
        return companys;
    }

    public void setCompanys(Set<String> companys) {
        this.companys = companys;
    }

    public String getChildPlatformName() {
        return childPlatformName;
    }

    public void setChildPlatformName(String childPlatformName) {
        this.childPlatformName = childPlatformName;
    }
}
