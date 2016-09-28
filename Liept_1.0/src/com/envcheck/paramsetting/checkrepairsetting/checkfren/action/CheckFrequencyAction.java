package com.envcheck.paramsetting.checkrepairsetting.checkfren.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.DateEchoUtils;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.checkrepairsetting.checkfren.bean.CheckFrequency;
import com.envcheck.paramsetting.checkrepairsetting.checkfren.service.ICheckFrequencyService;
import org.apache.struts2.ServletActionContext;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/6.
 */
public class CheckFrequencyAction extends BaseAction {
    //封装数据
    private CheckFrequency checkFrequency;
    public CheckFrequency getCheckFrequency() {
        return checkFrequency;
    }
    public void setCheckFrequency(CheckFrequency checkFrequency) {
        this.checkFrequency = checkFrequency;
    }

    //调用业务逻辑方法
    private ICheckFrequencyService checkFrequencyService;

    public ICheckFrequencyService getCheckFrequencyService() {
        return checkFrequencyService;
    }
    public void setCheckFrequencyService(ICheckFrequencyService checkFrequencyService) {
        this.checkFrequencyService = checkFrequencyService;
    }

    /**
     * 列表展示
     */
    public String listUI(){

        try {
            QueryHelper qh = new QueryHelper(CheckFrequency.class, "c");
            //查询
            if(checkFrequency != null && (checkFrequency.getCheckFrequencyNumber() != null || checkFrequency.getCheckFrequencyName() != null))
            {
                //条件查询
                if (checkFrequency.getCheckFrequencyNumber() != null){
                    checkFrequency.setCheckFrequencyNumber(URLDecoder.decode(checkFrequency.getCheckFrequencyNumber(),"utf-8"));
                    qh.addConditions("c.checkFrequencyNumber like ?", "%" + checkFrequency.getCheckFrequencyNumber() + "%");
                }
                if (checkFrequency.getCheckFrequencyName() != null){
                    checkFrequency.setCheckFrequencyName(URLDecoder.decode(checkFrequency.getCheckFrequencyName(),"utf-8"));
                    qh.addConditions("c.checkFrequencyName like ?", "%" + checkFrequency.getCheckFrequencyName() + "%");
                }
            }

            pageResult = checkFrequencyService.getPageResult(qh,  getPageNo(), getPageSize());
            int a = 0;

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

        if(checkFrequency != null){
            checkFrequency.setCreateTime(new Date());
            checkFrequency.setCreatePerson("管理员");
            checkFrequency.setModifyTime(new Date());
            checkFrequency.setModifyPerson("管理员");
            checkFrequencyService.save(checkFrequency);
        }
        return "list";
    }

    /**
     * 删除
     */
    public String delete(){

        if( checkFrequency != null && checkFrequency.getId() != null){
            checkFrequencyService.delete(checkFrequency.getId());
        }

        setPageNo(1);
        return "list";
    }

    /**
     * 进入修改页面
     */
    public String editUI(){
        //处理回显
        if(checkFrequency != null && checkFrequency.getId() != null)
        {
          checkFrequency = checkFrequencyService.findById(checkFrequency.getId());
           //回显时间
            List<Date> list = new ArrayList<>();
            list.add(checkFrequency.getApparatusStartDate());
            list.add(checkFrequency.getAovStartDate());

            DateEchoUtils.dateEcho(list,"dateList");
        }

        return "editUI";
    }


    /**
     * 修改
     * @return
     */
    public String edit(){

        if(checkFrequency != null){

            checkFrequency.setModifyTime(new Date());
            checkFrequency.setModifyPerson("管理员");
            checkFrequencyService.update(checkFrequency);
        }

        return "list";
    }
    /**
     * 批量删除
     */
    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                checkFrequencyService.delete(id);
            }
        }

        return "list";
    }

}
