package com.envcheck.tool.importpicture.dao.impl;

import com.envcheck.base.dao.BaseDao;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.tool.importpicture.bean.ImportPictureHistory;
import com.envcheck.tool.importpicture.dao.IImportPictureHistoryDao;
import org.hibernate.Query;

/**
 * Created by Administrator on 2016/5/5.
 */
public class ImportPictureHistoryDao extends BaseDao<ImportPictureHistory> implements IImportPictureHistoryDao {


    @Override
    public ImportPictureHistory findPictureHistoryByLabel(String importPictureLabelNumber) {

        QueryHelper helper = new QueryHelper(ImportPictureHistory.class, "i");
        helper.addConditions("i.importPictureLabelNumber=?", importPictureLabelNumber);

        Query query = sessionFactory.getCurrentSession().createQuery(helper.getQueryListHql());

        query.setParameter(0, helper.getQueryListParameters().get(0));

        return (ImportPictureHistory) query.uniqueResult();

    }
}
