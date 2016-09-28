package com.envcheck.tool.startnewcheck.dao;

import com.envcheck.base.bean.discharge_check_history.CheckPeriodRecord;
import com.envcheck.base.dao.IBaseDao;
import com.envcheck.paramsetting.modelinfosetting.unitmanage.bean.Unit;

import java.util.List;

/**
 * Created by Administrator on 2016/5/5.
 */
public interface ICheckPeroidRecordDao extends IBaseDao<CheckPeriodRecord> {
    CheckPeriodRecord getCheckPeroidRecordByName(String endPeriodName);

    List<String> getAllPeriodName();
}
