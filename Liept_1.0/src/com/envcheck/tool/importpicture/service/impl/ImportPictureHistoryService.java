package com.envcheck.tool.importpicture.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.tool.importpicture.bean.ImportPictureHistory;
import com.envcheck.tool.importpicture.dao.IImportPictureHistoryDao;
import com.envcheck.tool.importpicture.service.IImportPictureHistoryService;

/**
 * Created by Administrator on 2016/5/6.
 */
public class ImportPictureHistoryService extends BaseService<ImportPictureHistory> implements IImportPictureHistoryService {

    private IImportPictureHistoryDao importPictureHistoryDao;

    public IImportPictureHistoryDao getImportPictureHistoryDao() {
        return importPictureHistoryDao;
    }

    public void setImportPictureHistoryDao(IImportPictureHistoryDao importPictureHistoryDao) {
        super.setBaseDao(importPictureHistoryDao);
        this.importPictureHistoryDao = importPictureHistoryDao;
    }

    @Override
    public ImportPictureHistory findPictureHistoryByLabel(String importPictureLabelNumber) {
        return importPictureHistoryDao.findPictureHistoryByLabel(importPictureLabelNumber);
    }
}
