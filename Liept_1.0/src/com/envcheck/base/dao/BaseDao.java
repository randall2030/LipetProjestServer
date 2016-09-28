package com.envcheck.base.dao;

import com.envcheck.base.utils.PageResult;
import com.envcheck.base.utils.QueryHelper;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by susion on 2016/5/3.
 */
    public class BaseDao<T>  implements IBaseDao<T> {

    private String clazzName;
    Class<T> clazz;

    protected SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public BaseDao(){
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<T>) pt.getActualTypeArguments()[0];
        clazzName = clazz.getSimpleName();
    }

    @Override
    public void delete(String id) {
        sessionFactory.getCurrentSession().delete(findById(id));
    }

    @Override
    public T findById(String id) {
        T t = (T) sessionFactory.getCurrentSession().get(clazz, id);
        return  t;

    }

    @Override
    public List<T> getAll() {
        List list = sessionFactory.getCurrentSession().createQuery("from " + clazzName).list();
        return  list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void save(T t) {
        sessionFactory.getCurrentSession().save(t);
    }

    @Override
    public void update(T t) {
        sessionFactory.getCurrentSession().update(t);
    }

    public List<T> getAll(QueryHelper qh){
        if(qh == null)
        {
            return null;
        }

        Query query = sessionFactory.getCurrentSession().createQuery(qh.getQueryListHql());
        List<Object> list = qh.getQueryListParameters();

        if(list != null)
        {
            for(int i=0; i<list.size(); i++)
            {
                query.setParameter(i, list.get(i));
            }
        }
        List list1 = query.list();
        return  list1;
    }

    public PageResult getPageResult(QueryHelper qh, int pageNo, int pageSize)
    {
        if(qh == null) {
            return null;
        }

        Query query = null;


        String name = clazz.getName();

        query = sessionFactory.getCurrentSession().createQuery(qh.getQueryListHql());

        List<Object> list = qh.getQueryListParameters();

        if(list != null)
        {
            for(int i=0; i<list.size(); i++)
            {
                query.setParameter(i, list.get(i));
            }
        }

        if(pageNo < 1)
            pageNo = 1;


        query.setFirstResult((pageNo-1)*pageSize);//设置数据起始索引号
        query.setMaxResults(pageSize);
        List<T> items = query.list();


        //查询总记录
        Query queryCount = sessionFactory.getCurrentSession().createQuery(qh.getQueryCountHql());
        if(list != null){
            for(int i = 0; i < list.size(); i++){
                queryCount.setParameter(i, list.get(i));
            }
        }

        long totalCount = (Long)queryCount.uniqueResult();

        return new PageResult(totalCount, pageNo, pageSize, items);
    }


}
