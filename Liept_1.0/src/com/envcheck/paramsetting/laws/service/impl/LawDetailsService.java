package com.envcheck.paramsetting.laws.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.laws.bean.LawDetails;
import com.envcheck.paramsetting.laws.dao.ILawDetailsDao;
import com.envcheck.paramsetting.laws.service.ILawDetailsService;

/**
 * Created by Administrator on 2016/6/3.
 */
public class LawDetailsService extends BaseService<LawDetails> implements ILawDetailsService{

    private ILawDetailsDao lawDetailsDao;

    public ILawDetailsDao getLawDetailsDao() {
        return lawDetailsDao;
    }
    public void setLawDetailsDao(ILawDetailsDao lawDetailsDao) {
        super.setBaseDao(lawDetailsDao);
        this.lawDetailsDao = lawDetailsDao;
    }
}
