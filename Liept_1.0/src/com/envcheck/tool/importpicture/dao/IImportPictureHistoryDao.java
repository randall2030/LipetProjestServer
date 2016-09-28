package com.envcheck.tool.importpicture.dao;

import com.envcheck.base.dao.IBaseDao;
import com.envcheck.tool.importpicture.bean.ImportPictureHistory;

/**
 * Created by Administrator on 2016/5/5.
 */
public interface IImportPictureHistoryDao extends IBaseDao<ImportPictureHistory>  {
    ImportPictureHistory findPictureHistoryByLabel(String importPictureLabelNumber);
}
