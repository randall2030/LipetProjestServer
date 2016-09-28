package com.envcheck.base.company.dao.impl;

import com.envcheck.base.company.bean.Company;
import com.envcheck.base.company.dao.ICompanyDao;
import com.envcheck.base.dao.BaseDao;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by susion on 2016/6/26.
 */
public class CompanyDao  extends BaseDao<Company> implements ICompanyDao{

    @Override
    public List<String> getParentSimpleNameList() {
        return getStringResultList("parentCompanySimpleName");
    }

    private List<String> getStringResultList(String name) {
        String hql = "SELECT c."+name+" FROM Company c";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List<String> getCompanySimpleNameList() {
        return getStringResultList("companySimpleName");
    }

    @Override
    public List<String> getCompanyCNNameList() {
        return getStringResultList("companyName");
    }

    @Override
    public String getSimpleNameByCompanyNameCn(String companyNameCn) {

        String hql = "SELECT c.companySimpleName FROM Company c where c.companyName=?";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.setString(0, companyNameCn);

        return (String) query.uniqueResult();
    }
}
