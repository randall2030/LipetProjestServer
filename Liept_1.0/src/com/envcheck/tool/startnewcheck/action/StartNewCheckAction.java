package com.envcheck.tool.startnewcheck.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.bean.Module;
import com.envcheck.base.bean.ModuleCheck;
import com.envcheck.base.bean.ModuleRepairRecord;
import com.envcheck.base.bean.discharge_check_history.CheckPeriodRecord;
import com.envcheck.base.bean.discharge_check_history.DischargeForPPMRecord;
import com.envcheck.base.bean.discharge_check_history.HistoryModuleCheck;
import com.envcheck.base.bean.discharge_check_history.HistoryModuleRepairRecord;
import com.envcheck.base.utils.FileUtils;
import com.envcheck.base.utils.PageResult;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.base.utils.TaskUtils;
import com.envcheck.tool.startnewcheck.service.ICheckPeroidRecordService;
import com.envcheck.tool.startnewcheck.service.IHistoryModuleCheckService;
import com.envcheck.tool.startnewcheck.service.IHistoryModuleRepairRecordService;
import com.envcheck.view.checkinfo.service.IModuleCheckService;
import com.envcheck.view.moduleinfo.service.IModuleService;
import com.envcheck.view.repairinfo.service.IModuleRepairRecordService;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by susion on 2016/5/11.
 */
public class StartNewCheckAction extends BaseAction{

    private ICheckPeroidRecordService checkPeroidRecordService;
    private IModuleService moduleService;
    private IModuleCheckService moduleCheckService;
    private IModuleRepairRecordService moduleRepairRecordService;
    private IHistoryModuleCheckService historyModuleCheckService;
    private IHistoryModuleRepairRecordService historyModuleRepairRecordService;
    private String checkPeroidName;

    public String listUI(){

        QueryHelper qh = new QueryHelper(CheckPeriodRecord.class, "c");
        pageResult = checkPeroidRecordService.getPageResult(qh,  getPageNo(), getPageSize());

        return "listUI";
    }


    public String startNewCheckPeriod() throws InvocationTargetException, IllegalAccessException {

        if(checkPeroidName != null){


            CheckPeriodRecord name = checkPeroidRecordService.getCheckPeroidRecordByName(checkPeroidName);

            if(name != null){
                 throw  new RuntimeException("检测周期已经存在");
            }

            Date endPeriodTime = new Date();
            CheckPeriodRecord periodRecord = new CheckPeriodRecord();
            periodRecord.setPeriodName(checkPeroidName);
            periodRecord.setPeriodEndTime(endPeriodTime);
            checkPeroidRecordService.save(periodRecord);


            //开始保存数据
            QueryHelper qh = new QueryHelper(Module.class, "m");
            long totalModuleNumber = moduleService.getModuleTotalNumber();

            int pageSize = 100;
            long totalPage = totalModuleNumber / 100 + 1;
            int pageIndex = 0;
            String deleteModuleCheckId = null;
            String deleteModuleRepairRecordId = null;

            while(pageIndex <= totalPage){

                PageResult pageResult = moduleService.getPageResult(qh, pageIndex, pageSize);
                List<Module> modules = pageResult.getItems();

                for(Module module : modules){

                    ModuleCheck moduleCheck = module.getModuleCheck();
                    ModuleRepairRecord moduleRepairRecord = module.getModuleRepairRecord();

                    if(moduleCheck != null){
                        //维护周期排放量计算  -> 得到最近的一个检测值，并将 endPeriodRecord 设置为true
                        Set<DischargeForPPMRecord> dischargeForPPMRecords = module.getDischargeForPPMRecords();
                        DischargeForPPMRecord latestPPMRecord = getLatestPPMRecord(dischargeForPPMRecords);
                        if(latestPPMRecord != null){
                            latestPPMRecord.setCheckTime(endPeriodTime);
                            latestPPMRecord.setEndPeriodRecord(true);
                        }

                        //保存检测数据和维修数据
                        HistoryModuleCheck historyModuleCheck = new HistoryModuleCheck();

                        historyModuleCheck.setEndPeriodTime(endPeriodTime);
                        historyModuleCheck.setModuleId(module.getId());
                        BeanUtils.copyProperties(historyModuleCheck, moduleCheck);

                        historyModuleCheckService.save(historyModuleCheck);
                        deleteModuleCheckId = moduleCheck.getId();
                    }

                    if(moduleRepairRecord != null){
                        HistoryModuleRepairRecord historyModuleRepairRecord = new HistoryModuleRepairRecord();

                        historyModuleRepairRecord.setEndPeriodTime(endPeriodTime);
                        historyModuleRepairRecord.setModuleId(module.getId());
                        BeanUtils.copyProperties(historyModuleRepairRecord, moduleRepairRecord);

                        historyModuleRepairRecordService.save(historyModuleRepairRecord);
                        deleteModuleRepairRecordId = moduleRepairRecord.getId();
                    }


                    //清除module检测状态
                    module.setLeak(false);
                    module.setModuleCheck(null);
                    module.setModuleRepairRecord(null);
                    module.setHasCheck(false);
                    module.setTaskId("-1");
                    module.setHasAllocate(false);
                    moduleService.update(module);

                    if(deleteModuleCheckId != null){
                        moduleCheckService.delete(deleteModuleCheckId);
                    }

                    if(deleteModuleRepairRecordId != null){
                        moduleRepairRecordService.delete(deleteModuleRepairRecordId);
                    }

                    deleteModuleCheckId = null;
                    deleteModuleRepairRecordId = null;
                }

                pageIndex++;
            }

        }

        return  "listUI";
    }

    private DischargeForPPMRecord getLatestPPMRecord(Set<DischargeForPPMRecord> dischargeForPPMRecords) {

        DischargeForPPMRecord result = null;

        if(dischargeForPPMRecords != null){
            for(DischargeForPPMRecord record : dischargeForPPMRecords){
                if(result == null){
                    result = record;
                }

                if(result.getCheckTime().before(record.getCheckTime())){
                    result = record;
                }
            }
        }
        return result;
    }


    public void setCheckPeroidRecordService(ICheckPeroidRecordService checkPeroidRecordService) {
        this.checkPeroidRecordService = checkPeroidRecordService;
    }



    public String getCheckPeroidName() {
        return checkPeroidName;
    }

    public void setCheckPeroidName(String checkPeroidName) {
        this.checkPeroidName = checkPeroidName;
    }

    public void setModuleService(IModuleService moduleService) {
        this.moduleService = moduleService;
    }

    public void setModuleCheckService(IModuleCheckService moduleCheckService) {
        this.moduleCheckService = moduleCheckService;
    }


    public void setModuleRepairRecordService(IModuleRepairRecordService moduleRepairRecordService) {
        this.moduleRepairRecordService = moduleRepairRecordService;
    }


    public void setHistoryModuleCheckService(IHistoryModuleCheckService historyModuleCheckService) {
        this.historyModuleCheckService = historyModuleCheckService;
    }


    public void setHistoryModuleRepairRecordService(IHistoryModuleRepairRecordService historyModuleRepairRecordService) {
        this.historyModuleRepairRecordService = historyModuleRepairRecordService;
    }
}
