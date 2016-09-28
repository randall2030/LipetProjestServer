package com.envcheck.view.repairinfo.bean;

import java.util.Date;

/**
 * Created by susion on 2016/7/9.
 */
public class RepairInfo {

    private String markPictureSavePath;

    private Date checkDate;
    private String device;
    private String area;
    private String equipment;
    private String labelNumber;
    private int extendNumber;
    private String locationDesc;
    private int cleanPPMValue;
    private int leakThreshold;
    private String delayRepair;
    private boolean leak;
    private String moduleType;
    private int sizeMM;
    private String leakSource;
    private String checkPerson;
    private int repairNumber;

    private boolean hasRepair;
    private Date firstRepeateDate;
    private int firstRepeateValue;
    private Date endRepeateDate;
    private int endRepeateValue;
    private boolean repairResult;


}
