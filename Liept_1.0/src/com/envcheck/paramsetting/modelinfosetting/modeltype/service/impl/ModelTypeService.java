package com.envcheck.paramsetting.modelinfosetting.modeltype.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.modelinfosetting.modeltype.bean.ModelType;
import com.envcheck.paramsetting.modelinfosetting.modeltype.dao.IModelTypeDao;
import com.envcheck.paramsetting.modelinfosetting.modeltype.service.IModelTypeService;

/**
 * Created by Administrator on 2016/5/7.
 */
public class ModelTypeService extends BaseService<ModelType> implements IModelTypeService{
    private IModelTypeDao modelTypeDao;

    public IModelTypeDao getModelTypeDao() {
        return modelTypeDao;
    }

    public void setModelTypeDao(IModelTypeDao modelTypeDao) {
        super.setBaseDao(modelTypeDao);
        this.modelTypeDao = modelTypeDao;
    }
}
