package com.envcheck.paramsetting.modelinfosetting.productcompany.bean;

import com.envcheck.base.bean.MainTainAbout;

/**
 * Created by susion on 2016/5/4.
 */
public class ProductCompany extends MainTainAbout {


    //生产厂家编号、生产厂家全称、生产厂家简称、创建时间、创建人、更新时间、更新人
    private String id;
    private String productCompanyNumber;
    private String productCompanyFullName;
    private String productCompanyShortName;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductCompanyNumber() {
        return productCompanyNumber;
    }

    public void setProductCompanyNumber(String productCompanyNumber) {
        this.productCompanyNumber = productCompanyNumber;
    }

    public String getProductCompanyFullName() {
        return productCompanyFullName;
    }

    public void setProductCompanyFullName(String productCompanyFullName) {
        this.productCompanyFullName = productCompanyFullName;
    }

    public String getProductCompanyShortName() {
        return productCompanyShortName;
    }

    public void setProductCompanyShortName(String productCompanyShortName) {
        this.productCompanyShortName = productCompanyShortName;
    }
}
