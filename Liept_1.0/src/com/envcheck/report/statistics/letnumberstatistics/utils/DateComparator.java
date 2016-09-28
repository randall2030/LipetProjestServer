package com.envcheck.report.statistics.letnumberstatistics.utils;

import com.envcheck.base.bean.discharge_check_history.DischargeForPPMRecord;

import java.util.Comparator;
import java.util.Date;


/**
 * Created by susion on 2016/6/22.
 */
public class DateComparator implements Comparator{


    @Override
    public int compare(Object o1, Object o2) {

        DischargeForPPMRecord record1 = (DischargeForPPMRecord) o1;
        DischargeForPPMRecord record2 = (DischargeForPPMRecord) o2;

        if(record1.getCheckTime().before(record2.getCheckTime())){
            return -1;
        }

        if (record1.getCheckTime().after(record2.getCheckTime())){
            return 1;
        }

        return 0;
    }
}
