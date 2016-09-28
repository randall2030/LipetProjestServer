package com.envcheck.base.dao;

import com.envcheck.base.utils.PageResult;
import com.envcheck.base.utils.QueryHelper;

import java.util.List;

/**
 * Created by susion on 2016/5/3.
 */

public interface IBaseDao<T> {
    //class Phone

    //保存对象
    void save(T t);

    T findById(String id);

    List<T> getAll();

    void delete(String id);

    void update(T t);

    //使用QueryHelper改进查询
    public List<T> getAll(QueryHelper qh);

    //分页查询
    public PageResult getPageResult(QueryHelper qh, int pageNo, int pageSize);


}
