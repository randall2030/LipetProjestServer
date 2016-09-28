package com.envcheck.paramsetting.laws.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.laws.bean.Law;
import com.envcheck.paramsetting.laws.dao.ILawDao;
import com.envcheck.paramsetting.laws.service.ILawService;

import java.util.List;

/**
 * Created by susion on 2016/5/3.
 */
public class LawService  extends BaseService<Law> implements ILawService {

    private ILawDao lawDao;

    public void setLawDao(ILawDao lawDao) {
        super.setBaseDao(lawDao);
        this.lawDao = lawDao;
    }

    @Override
    public Law getCurrentLaw() {
        return lawDao.getCurrentLaw();
    }

    @Override
    public Law getLawByLawCode(String lawCode) {
        return lawDao.getLawByLawCode(lawCode);
    }
}
