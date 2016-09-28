package com.envcheck.paramsetting.modelinfosetting.caculatetype.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.modelinfosetting.caculatetype.bean.CaculateType;
import com.envcheck.paramsetting.modelinfosetting.caculatetype.dao.ICaculateTypeDao;
import com.envcheck.paramsetting.modelinfosetting.caculatetype.service.ICaculateTypeService;

/**
 * Created by Administrator on 2016/5/7.
 */
public class CaculateTypeService extends BaseService<CaculateType> implements ICaculateTypeService{

    private ICaculateTypeDao caculateTypeDao;
    public ICaculateTypeDao getCaculateTypeDao() {
        return caculateTypeDao;
    }
    public void setCaculateTypeDao(ICaculateTypeDao caculateTypeDao) {
        super.setBaseDao(caculateTypeDao);
        this.caculateTypeDao = caculateTypeDao;
    }
}
