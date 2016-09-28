package com.envcheck.tool.importmodule.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.tool.importmodule.bean.ImportFileHistory;
import com.envcheck.tool.importmodule.dao.IImportFileHistoryDao;
import com.envcheck.tool.importmodule.service.IImportFileHistoryService;

/**
 * Created by Administrator on 2016/5/6.
 */
public class ImportFileHistoryService extends BaseService<ImportFileHistory> implements IImportFileHistoryService {

    private IImportFileHistoryDao importFileHistoryDao;

    public IImportFileHistoryDao getImportFileHistoryDao() {
        return importFileHistoryDao;
    }

    public void setImportFileHistoryDao(IImportFileHistoryDao importFileHistoryDao) {
        super.setBaseDao(importFileHistoryDao);
        this.importFileHistoryDao = importFileHistoryDao;
    }
}
