package com.envcheck.paramsetting.checkrepairsetting.minchecktime.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.dynamic_change_datasource.DataSourceConstant;
import com.envcheck.base.dynamic_change_datasource.DataSourceContextHolder;
import com.envcheck.base.dynamic_change_datasource.UserContextHolder;
import com.envcheck.base.utils.Constant;
import com.envcheck.base.utils.JsonUtils;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.checkrepairsetting.densitymanage.bean.StandGasTheoryCon;
import com.envcheck.paramsetting.checkrepairsetting.densitymanage.service.IStandGasTheoryConService;
import com.envcheck.paramsetting.checkrepairsetting.minchecktime.bean.MinCheckTime;
import com.envcheck.paramsetting.checkrepairsetting.minchecktime.bean.SizeRange;
import com.envcheck.paramsetting.checkrepairsetting.minchecktime.service.IMinCheckTimeService;
import com.opensymphony.xwork2.ModelDriven;

import java.net.URLDecoder;
import java.util.*;

/**
 * Created by Administrator on 2016/5/6.
 */
public class MinCheckTimeAction extends BaseAction{

    private IMinCheckTimeService minCheckTimeService;
    private MinCheckTime minCheckTime;


    private String[] minSize;
    private String[] maxSize;
    private String[] mminCheckTime;

    public String listUI(){
        try {
            QueryHelper qh = new QueryHelper(MinCheckTime.class, "m");


            pageResult = minCheckTimeService.getPageResult(qh,  getPageNo(), getPageSize());

        }catch (Exception e){

        }
        return "listUI";
    }

    /**
     * 添加
     */
    public String addUI(){
        return "addUI";
    }

    public String add(){

        if(minCheckTime != null){

            int sizeRangeSize = minSize.length;
            Set<SizeRange> sizeRangeSet = new HashSet<>();

            for(int i=0; i<sizeRangeSize; i++){
                sizeRangeSet.add(new SizeRange(minSize[i], maxSize[i], Integer.valueOf(mminCheckTime[i])));
            }

            minCheckTime.setSizeRanges(sizeRangeSet);
            minCheckTime.setCreateTime(new Date());
            //minCheckTime.setCreatePerson(Constant.currentUser.getUsername());
            minCheckTime.setCreatePerson(UserContextHolder.getCurrentUser().getUsername());
            minCheckTimeService.save(minCheckTime);

        }

        return "list";
    }

    /**
     * 删除
     */
    public String delete(){

        if( minCheckTime != null && minCheckTime.getId() != null){
            minCheckTimeService.delete(minCheckTime.getId());
        }

        setPageNo(1);
        return "list";
    }

    public String editUI(){
        //处理回显
        if(minCheckTime != null && minCheckTime.getId() != null)
        {
            minCheckTime =  minCheckTimeService.findById(minCheckTime.getId());
            minCheckTime.getSizeRanges();
        }

        return "editUI";
    }


    public String edit(){

        if(minCheckTime != null){
            minCheckTimeService.update(minCheckTime);
        }

        return "list";
    }
    /**
     * 批量删除
     */
    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                minCheckTimeService.delete(id);
            }
        }

        return "list";
    }


    public void setMinCheckTimeService(IMinCheckTimeService minCheckTimeService) {
        this.minCheckTimeService = minCheckTimeService;
    }

    public void setMinCheckTime(MinCheckTime minCheckTime) {
        this.minCheckTime = minCheckTime;
    }

    public IMinCheckTimeService getMinCheckTimeService() {
        return minCheckTimeService;
    }

    public MinCheckTime getMinCheckTime() {
        return minCheckTime;
    }

    public String[] getMinSize() {
        return minSize;
    }

    public void setMinSize(String[] minSize) {
        this.minSize = minSize;
    }

    public String[] getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(String[] maxSize) {
        this.maxSize = maxSize;
    }

    public String[] getMminCheckTime() {
        return mminCheckTime;
    }

    public void setMminCheckTime(String[] mminCheckTime) {
        this.mminCheckTime = mminCheckTime;
    }
}
