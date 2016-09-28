package com.envcheck.base.user.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.company.service.ICompanyService;
import com.envcheck.base.company.service.impl.CompanyService;
import com.envcheck.base.user.bean.User;
import com.envcheck.base.user.service.IUserService;
import com.envcheck.base.utils.QueryHelper;

import java.util.Date;

/**
 * Created by susion on 2016/6/15.
 */
public class UserAction  extends BaseAction{

    private IUserService userService;
    private ICompanyService companyService;
    private User user;

    public String listUI(){
        try {

            QueryHelper qh = new QueryHelper(User.class, "u");  //d是表的别名

            //根据前面的过滤条件来确定
            if(user != null && user.getCompanyNameCN() != null)
            {

            }

            pageResult = userService.getPageResult(qh,  getPageNo(), getPageSize());

        }catch (Exception e){

        }

        return "listUI";

    }

    public String addUI(){
        return "addUI";
    }

    public String add(){

        if(user != null){
            user.setCreateTime(new Date());
            String companyNameCn = user.getCompanyNameCN();
            String companySimpleName = companyService.getSimpleNameByCompanyNameCn(companyNameCn);
            user.setCompany(companySimpleName);
            userService.save(user);
        }

        return "list";
    }

    public String delete(){
        if( user != null && user.getId() != null){
            String id = user.getId();
            userService.delete(id);
        }
        setPageNo(1);
        return "list";
    }

    public String edit(){

        if(user != null){
            userService.update(user);
        }

        return "list";
    }


    public String editUI(){
        //处理回显
        if(user != null && user.getId() != null) {
            user = userService.findById(user.getId());
        }

        return "editUI";
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public void setUserService(IUserService userService) {
        this.userService = userService;
    }


    public void setCompanyService(ICompanyService companyService) {
        this.companyService = companyService;
    }
}
