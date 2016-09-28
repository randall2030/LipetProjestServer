package com.envcheck.paramsetting.checkrepairsetting.checkfren.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.checkrepairsetting.checkfren.bean.CheckFrequency;
import com.envcheck.paramsetting.checkrepairsetting.checkfren.dao.ICheckFrequencyDao;
import com.envcheck.paramsetting.checkrepairsetting.checkfren.service.ICheckFrequencyService;

/**
 * Created by Administrator on 2016/5/6.
 */
public class CheckFrequencyService extends BaseService<CheckFrequency> implements ICheckFrequencyService {
    private ICheckFrequencyDao checkFrequencyDao;

    public ICheckFrequencyDao getCheckFrequencyDao() {
        return checkFrequencyDao;
    }

    public void setCheckFrequencyDao(ICheckFrequencyDao checkFrequencyDao) {
        super.setBaseDao(checkFrequencyDao);
        this.checkFrequencyDao = checkFrequencyDao;
    }
}
