package com.envcheck.view.picturemanage.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.bean.Module;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.base.utils.StringUtils;
import com.envcheck.tool.importpicture.bean.ImportPictureHistory;
import com.envcheck.tool.importpicture.service.IImportPictureHistoryService;
import com.envcheck.view.moduleinfo.service.IModuleService;

/**
 * Created by susion on 2016/5/11.
 */
public class PictureManageAction  extends BaseAction{

    private IImportPictureHistoryService importPictureHistoryService;
    private ImportPictureHistory importPictureHistory;
    private IModuleService moduleService;
    private String labelNumber;

    public String listUI(){

        QueryHelper qh = new QueryHelper(ImportPictureHistory.class, "i");  //d是表的别名

        if(StringUtils.notIsNullAndEmptyString(labelNumber)){
            qh.addConditions("i.importPictureLabelNumber=?", labelNumber);
        }

        pageResult = importPictureHistoryService.getPageResult(qh,  getPageNo(), 10);


        return "listUI";
    }

    public String ViewConnectedModuleUI(){

        if(importPictureHistory != null){
            importPictureHistory = importPictureHistoryService.findById(importPictureHistory.getId());
        }

        QueryHelper qh = new QueryHelper(Module.class, "m");
        qh.addConditions("m.labelNumber = ?",  importPictureHistory.getImportPictureLabelNumber());

        pageResult = moduleService.getPageResult(qh,  getPageNo(), 20);

        return "ViewConnectedModuleUI";
    }



    public void setImportPictureHistoryService(IImportPictureHistoryService importPictureHistoryService) {
        this.importPictureHistoryService = importPictureHistoryService;
    }


    public void setModuleService(IModuleService moduleService) {
        this.moduleService =  moduleService;
    }

    public ImportPictureHistory getImportPictureHistory() {
        return importPictureHistory;
    }

    public void setImportPictureHistory(ImportPictureHistory importPictureHistory) {
        this.importPictureHistory = importPictureHistory;
    }

    public String getLabelNumber() {
        return labelNumber;
    }

    public void setLabelNumber(String labelNumber) {
        this.labelNumber = labelNumber;
    }
}
