package com.envcheck.paramsetting.modelinfosetting.productcompany.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.modelinfosetting.productcompany.bean.ProductCompany;
import com.envcheck.paramsetting.modelinfosetting.productcompany.dao.IProductCompanyDao;
import com.envcheck.paramsetting.modelinfosetting.productcompany.service.IProductCompanyService;

/**
 * Created by Administrator on 2016/5/7.
 */
public class ProductCompanyService extends BaseService<ProductCompany> implements IProductCompanyService {
    private IProductCompanyDao productCompanyDao;

    public IProductCompanyDao getProductCompanyDao() {
        return productCompanyDao;
    }

    public void setProductCompanyDao(IProductCompanyDao productCompanyDao) {

        super.setBaseDao(productCompanyDao); //记住！！！！

        this.productCompanyDao = productCompanyDao;
    }
}
