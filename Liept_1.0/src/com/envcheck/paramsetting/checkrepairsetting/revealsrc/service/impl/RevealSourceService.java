package com.envcheck.paramsetting.checkrepairsetting.revealsrc.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.checkrepairsetting.revealsrc.bean.RevealSource;
import com.envcheck.paramsetting.checkrepairsetting.revealsrc.dao.IRevealSourceDao;
import com.envcheck.paramsetting.checkrepairsetting.revealsrc.service.IRevealSourceService;

/**
 * Created by Administrator on 2016/5/7.
 */
public class RevealSourceService extends BaseService<RevealSource> implements IRevealSourceService{
    private IRevealSourceDao revealSourceDao;

    public IRevealSourceDao getRevealSourceDao() {
        return revealSourceDao;
    }

    public void setRevealSourceDao(IRevealSourceDao revealSourceDao) {
        super.setBaseDao(revealSourceDao);
        this.revealSourceDao = revealSourceDao;
    }
}
