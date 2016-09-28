package com.envcheck.tool.importpicture.service;

import com.envcheck.base.service.IBaseService;
import com.envcheck.tool.importpicture.bean.ImportPictureHistory;

/**
 * Created by Administrator on 2016/5/6.
 */
public interface IImportPictureHistoryService extends IBaseService<ImportPictureHistory> {
    ImportPictureHistory findPictureHistoryByLabel(String importPictureLabelNumber);
}
