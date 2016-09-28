package com.envcheck.base.user.bean;

import java.util.Date;

/**
 * Created by susion on 2016/6/15.
 */
public class  User {


    private String id;  //编号
    private String username;  //用户名
    private String password;  //密码
    private String usernameCN;  //简称
    private String parentCompany;  //父公司
    private String company;  //公司名称
    private boolean visitPrivilege; //可看可修改
    private boolean canSelectCompany;  //是否对子公司拥有控制权
    private boolean status;  //用户状态
    private Date createTime; //创建时间
    private String companyNameCN; //公司简称


    public String getUsernameCN() {
        return usernameCN;
    }

    public void setUsernameCN(String usernameCN) {
        this.usernameCN = usernameCN;
    }

    public String getCompanyNameCN() {
        return companyNameCN;
    }

    public void setCompanyNameCN(String companyNameCN) {
        this.companyNameCN = companyNameCN;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public boolean isCanSelectCompany() {
        return canSelectCompany;
    }

    public void setCanSelectCompany(boolean canSelectCompany) {
        this.canSelectCompany = canSelectCompany;
    }

    public boolean isVisitPrivilege() {
        return visitPrivilege;
    }

    public void setVisitPrivilege(boolean visitPrivilege) {
        this.visitPrivilege = visitPrivilege;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getParentCompany() {
        return parentCompany;
    }

    public void setParentCompany(String parentCompany) {
        this.parentCompany = parentCompany;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
