package com.envcheck.base.company.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.company.bean.Company;
import com.envcheck.base.company.service.ICompanyService;
import com.envcheck.base.utils.QueryHelper;
import com.google.gson.Gson;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by susion on 2016/6/26.
 */
public class CompanyAction extends BaseAction {

    private ICompanyService companyService;
    private Company company;


    public String listUI(){
        try {

            QueryHelper qh = new QueryHelper(Company.class, "c");
            pageResult = companyService.getPageResult(qh,  getPageNo(), getPageSize());

        }catch (Exception e){

        }

        return "listUI";

    }

    public void getParentSimpleNameList() throws IOException {

        List<String> parentSimpleNameList;
        parentSimpleNameList = companyService.getParentSimpleNameList();

        returnListJson(parentSimpleNameList);

    }

    public void getCompanySimpleNameList() throws IOException{

        List<String> companySimList;
        companySimList = companyService.getCompanySimpleNameList();
        returnListJson(companySimList);
    }

    public void getCompanyCnNameList() throws IOException{

        List<String> companySimList;
        companySimList = companyService.getCompanyCNNameList();
        returnListJson(companySimList);
    }

    private void returnListJson(List<String> companySimList) throws IOException {
        Gson gson = new Gson();
        String jsonStr = gson.toJson(companySimList);
        PrintWriter writer = ServletActionContext.getResponse().getWriter();
        writer.write(jsonStr);
        writer.close();
    }

    public String addUI(){
        return "addUI";
    }

    public String add(){

        if(company != null){
            companyService.save(company);
        }

        return "list";
    }

    public String editUI(){

        if(company != null){

            company = companyService.findById(company.getId());
        }

        return "editUI";
    }

    public String edit(){

        if(company != null){
            companyService.update(company);
        }

        return "list";
    }

    public String delete(){

        if(company != null){
            companyService.delete(company.getId());
        }
        return "list";
    }



    public ICompanyService getCompanyService() {
        return companyService;
    }

    public void setCompanyService(ICompanyService companyService) {
        this.companyService = companyService;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
