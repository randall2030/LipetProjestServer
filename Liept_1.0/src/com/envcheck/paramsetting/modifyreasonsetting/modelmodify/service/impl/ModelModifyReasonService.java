package com.envcheck.paramsetting.modifyreasonsetting.modelmodify.service.impl;

import com.envcheck.base.service.impl.BaseService;
import com.envcheck.paramsetting.modifyreasonsetting.modelmodify.bean.ModelModifyReason;
import com.envcheck.paramsetting.modifyreasonsetting.modelmodify.dao.IModelModifyReasonDao;
import com.envcheck.paramsetting.modifyreasonsetting.modelmodify.service.IModelModifyReasonService;

/**
 * Created by Administrator on 2016/5/6.
 */
public class ModelModifyReasonService extends BaseService<ModelModifyReason> implements IModelModifyReasonService {
    private IModelModifyReasonDao modelModifyReasondao;

    public IModelModifyReasonDao getModelModifyReasonDao() {
        return modelModifyReasondao;
    }

    public void setModelModifyReasonDao(IModelModifyReasonDao modelModifyReasondao) {
        super.setBaseDao(modelModifyReasondao);
        this.modelModifyReasondao = modelModifyReasondao;
    }
}
