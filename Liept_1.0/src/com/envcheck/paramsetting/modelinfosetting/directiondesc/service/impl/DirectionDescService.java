package com.envcheck.paramsetting.modelinfosetting.directiondesc.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.modelinfosetting.directiondesc.bean.DirectionDesc;
import com.envcheck.paramsetting.modelinfosetting.directiondesc.dao.IDirectionDescDao;
import com.envcheck.paramsetting.modelinfosetting.directiondesc.service.IDirectionDescService;

/**
 * Created by Administrator on 2016/5/7.
 */
public class DirectionDescService extends BaseService<DirectionDesc> implements IDirectionDescService {
    private IDirectionDescDao directionDescDao;

    public IDirectionDescDao getDirectionDescDao() {
        return directionDescDao;
    }

    public void setDirectionDescDao(IDirectionDescDao directionDescDao) {
        super.setBaseDao(directionDescDao);
        this.directionDescDao = directionDescDao;
    }
}
