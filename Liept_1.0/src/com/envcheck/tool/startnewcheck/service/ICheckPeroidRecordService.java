package com.envcheck.tool.startnewcheck.service;


import com.envcheck.base.bean.Module;
import com.envcheck.base.bean.discharge_check_history.CheckPeriodRecord;
import com.envcheck.base.service.IBaseService;
import com.envcheck.base.utils.PageResult;
import com.envcheck.report.statistics.letnumberstatistics.bean.ModuleInfoFroDischarge;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/5.
 */
public interface ICheckPeroidRecordService extends IBaseService<CheckPeriodRecord> {

    CheckPeriodRecord getCheckPeroidRecordByName(String endPeriodName);

    List<String> getAllPeriodName();
}
