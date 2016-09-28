package com.envcheck.paramsetting.laws.service;

import com.envcheck.base.service.IBaseService;
import com.envcheck.paramsetting.laws.bean.Law;

import java.util.List;

/**
 * Created by susion on 2016/5/3.
 */
public interface ILawService extends IBaseService<Law>{

    Law getCurrentLaw();

    Law getLawByLawCode(String lawCode);
}
