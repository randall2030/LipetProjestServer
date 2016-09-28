package com.envcheck.paramsetting.modelinfosetting.productcompany.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.modelinfosetting.productcompany.bean.ProductCompany;
import com.envcheck.paramsetting.modelinfosetting.productcompany.service.IProductCompanyService;

import java.net.URLDecoder;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/7.
 */
public class ProductCompanyAction extends BaseAction {
    //封装数据
    private ProductCompany productCompany;
    public ProductCompany getProductCompany() {
        return productCompany;
    }
    public void setProductCompany(ProductCompany productCompany) {
        this.productCompany = productCompany;
    }

    //调用业务逻辑方法
    private IProductCompanyService productCompanyService;

    public IProductCompanyService getProductCompanyService() {
        return productCompanyService;
    }

    public void setProductCompanyService(IProductCompanyService productCompanyService) {
        this.productCompanyService = productCompanyService;
    }

    /**
     * 列表展示
     */
    public String listUI(){

        try {
            QueryHelper qh = new QueryHelper(ProductCompany.class, "c");
            //查询
            if(productCompany != null && (productCompany.getProductCompanyNumber() != null || productCompany.getProductCompanyFullName()!=null )){
                //查询条件
                if (productCompany.getProductCompanyNumber() != null){
                    productCompany.setProductCompanyNumber(URLDecoder.decode(productCompany.getProductCompanyNumber(),"utf-8"));
                     qh.addConditions("c.productCompanyNumber like ?", "%" + productCompany.getProductCompanyNumber() + "%");
                }
                if (productCompany.getProductCompanyFullName()!=null){
                    productCompany.setProductCompanyFullName(URLDecoder.decode(productCompany.getProductCompanyFullName(),"utf-8"));
                    qh.addConditions("c.productCompanyFullName like ?", "%" + productCompany.getProductCompanyFullName() + "%");
                }
            }

            pageResult = productCompanyService.getPageResult(qh,  getPageNo(), getPageSize());
            int a = 0;

        }catch (Exception e){

        }

        return "listUI";

    }

    /**
     * 添加
     */
    public String addUI(){
        return "addUI";
    }

    public String add(){

        if(productCompany != null){
            productCompany.setCreateTime(new Date());
            productCompany.setCreatePerson("haha");
            productCompany.setModifyTime(new Date());
            productCompany.setModifyPerson("haha");
            productCompanyService.save(productCompany);
        }
        return "list";
    }

    /**
     * 删除
     */
    public String delete(){

        if( productCompany != null && productCompany.getId() != null){
            productCompanyService.delete(productCompany.getId());
        }

        setPageNo(1);
        return "list";
    }

    /**
     * 进入修改页面
     */
    public String editUI(){
        //处理回显
        if(productCompany != null && productCompany.getId() != null)
        {
          productCompany = productCompanyService.findById(productCompany.getId());

        }

        return "editUI";
    }


    /**
     * 修改
     * @return
     */
    public String edit(){

        if(productCompany != null){
            productCompany.setCreateTime(productCompany.getCreateTime());
            productCompany.setCreatePerson(productCompany.getCreatePerson());
            productCompany.setModifyTime(new Date());
            productCompany.setModifyPerson("haha");
            productCompanyService.update(productCompany);
        }

        return "list";
    }
    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                productCompanyService.delete(id);
            }
        }

        return "list";
    }

}
