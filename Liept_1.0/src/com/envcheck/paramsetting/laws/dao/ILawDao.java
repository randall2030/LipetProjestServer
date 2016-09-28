package com.envcheck.paramsetting.laws.dao;

import com.envcheck.base.dao.IBaseDao;
import com.envcheck.paramsetting.laws.bean.Law;

import java.util.List;

/**
 * Created by susion on 2016/5/3.
 */
public interface ILawDao extends IBaseDao<Law> {

    Law getCurrentLaw();

    Law getLawByLawCode(String lawCode);
}
