package com.envcheck.paramsetting.modelinfosetting.chemical.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.modelinfosetting.chemical.bean.Chemical;
import com.envcheck.paramsetting.modelinfosetting.chemical.dao.IChemicalDao;
import com.envcheck.paramsetting.modelinfosetting.chemical.service.IChemicalService;

/**
 * Created by Administrator on 2016/5/7.
 */
public class ChemicalService extends BaseService<Chemical> implements IChemicalService {
    private IChemicalDao chemicalDao;

    public IChemicalDao getChemicalDao() {
        return chemicalDao;
    }

    public void setChemicalDao(IChemicalDao chemicalDao) {
        super.setBaseDao(chemicalDao);
        this.chemicalDao = chemicalDao;
    }
}
