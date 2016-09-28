package com.envcheck.paramsetting.modelinfosetting.modelsubtype.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.modelinfosetting.modelsubtype.bean.ModelSubType;
import com.envcheck.paramsetting.modelinfosetting.modelsubtype.dao.IModelSubTypeDao;
import com.envcheck.paramsetting.modelinfosetting.modelsubtype.service.IModelSubTypeService;

/**
 * Created by Administrator on 2016/5/7.
 */
public class ModelSubTypeService extends BaseService<ModelSubType> implements IModelSubTypeService {
    private IModelSubTypeDao modelSubTypeDao;

    public IModelSubTypeDao getModelSubTypeDao() {
        return modelSubTypeDao;
    }

    public void setModelSubTypeDao(IModelSubTypeDao modelSubTypeDao) {
        super.setBaseDao(modelSubTypeDao);
        this.modelSubTypeDao = modelSubTypeDao;
    }
}
