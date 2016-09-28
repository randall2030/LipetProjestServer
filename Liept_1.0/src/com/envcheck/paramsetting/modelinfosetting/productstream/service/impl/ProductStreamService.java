package com.envcheck.paramsetting.modelinfosetting.productstream.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.modelinfosetting.productstream.bean.ProductStream;
import com.envcheck.paramsetting.modelinfosetting.productstream.dao.IProductStreamDao;
import com.envcheck.paramsetting.modelinfosetting.productstream.service.IProductStreamService;

/**
 * Created by lighter on 2016/5/7.
 */
public class ProductStreamService extends BaseService<ProductStream> implements IProductStreamService {
    private IProductStreamDao productStreamDao;

    public IProductStreamDao getProductStreamDao() {
        return productStreamDao;
    }

    public void setProductStreamDao(IProductStreamDao productStreamDao) {

        super.setBaseDao(productStreamDao);

        this.productStreamDao = productStreamDao;
    }
}
