package com.envcheck.base.service;

import com.envcheck.base.utils.PageResult;
import com.envcheck.base.utils.QueryHelper;

import java.util.List;

/**
 * Created by susion on 2016/5/3.
 */
public interface IBaseService<T> {

    void save(T entity);

    T findById(String id);

    List<T> getAll();

    void update(T entity);

    void delete(String id);

    List<T> getAll(QueryHelper qh);
    //分页查询
    public PageResult getPageResult(QueryHelper qh, int pageNo, int pageSize);


}
