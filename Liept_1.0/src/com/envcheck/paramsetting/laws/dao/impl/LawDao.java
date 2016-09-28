package com.envcheck.paramsetting.laws.dao.impl;

import com.envcheck.base.dao.BaseDao;
import com.envcheck.paramsetting.laws.bean.Law;
import com.envcheck.paramsetting.laws.dao.ILawDao;
import org.hibernate.Query;

/**
 * Created by susion on 2016/5/3.
 */
public class LawDao extends BaseDao<Law> implements ILawDao {

    @Override
    public Law getCurrentLaw() {

        String hql = "FROM Law l where l.currentLaw = true";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);

        return (Law) query.uniqueResult();
    }

    @Override
    public Law getLawByLawCode(String lawCode) {

        String hql = "FROM Law l where l.lawCode = ?";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.setString(0, lawCode);
        return (Law) query.uniqueResult();
    }
}
