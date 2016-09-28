package com.envcheck.paramsetting.laws.action;

import com.envcheck.base.action.BaseAction;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.paramsetting.laws.bean.*;
import com.envcheck.paramsetting.laws.service.ILawDetailsService;
import com.envcheck.paramsetting.laws.service.ILawService;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by susion on 2016/5/3.
 */
public class LawAction extends BaseAction{
    private Law law;
    private LawDetails lawDetails;
    private String[] moduleType;
    private String[] mediumStatus;

    private final String[]  types = {"搅拌器（轴封）","连接件（螺纹连接）", "法兰", "开口阀或开口管线", "泵（轴封）", "其他", "泄压设备（安全阀）", "取样连接系统", "阀门", "压缩机（轴封）"};
    private final String[]  status = {"气体","轻液", "重液"};

    private ILawService lawService;
    private ILawDetailsService lawDetailsService;
    private List<LawDetailWrapper> wrappers;


    /**
     * 法规列表展示
     */
    public String listUI(){

        try {
            QueryHelper qh = new QueryHelper(Law.class, "l");
            //查询
            if(law != null && (law.getLawCode() != null  )){
                if (law.getLawCode() != null ){
                    law.setLawCode(URLDecoder.decode(law.getLawCode(),"utf-8"));
                    qh.addConditions("l.lawCode like ?", "%" + law.getLawCode() + "%");
                }
            }

            pageResult = lawService.getPageResult(qh,  getPageNo(), getPageSize());
        }catch (Exception e){

        }

        return "listUI";

    }

    public String addUI(){
        return "addUI";
    }


    public String add() throws Exception {

        if(law != null){
            setCurrentLaw();
            lawService.save(law);
        }

        return "list";
    }


    public String addLawDetail(){

        if(lawDetails != null){

            law = lawService.findById(law.getId());
            Set<MediumStatusDesc> mediumStatuss = lawDetails.getMediumStatus();
            Set<ModuleTypeDesc> moduleTypes = lawDetails.getModuleType();


            if(moduleType[0].equals("全部组件类型")){

                for(int i=0; i<types.length; i++){
                    moduleTypes.add(new ModuleTypeDesc(types[i]));
                }

            }else{
                for(int i = 0; i< this.moduleType.length; i++){
                    moduleTypes.add(new ModuleTypeDesc(moduleType[i]));
                }

            }

            if(mediumStatus[0].equals("全部介质状态")){

                for(int i=0; i<status.length; i++){
                    mediumStatuss.add(new MediumStatusDesc(status[i]));
                }

            }else{
                for(int i = 0; i< this.mediumStatus.length; i++){
                    mediumStatuss.add(new MediumStatusDesc(mediumStatus[i]));
                }

            }

            law.getLawDetails().add(lawDetails);

            lawService.update(law);
        }

        return "list";
    }

    public String addLawDetailUI(){

        if(law != null){
            law = lawService.findById(law.getId());
        }

        return "addLawDetailUI";
    }

    public String lawDetailListUI(){

        if(law != null){
            law = lawService.findById(law.getId());

            Set<LawDetails> details = law.getLawDetails();
            wrappers = new ArrayList<>();

            LawDetailWrapper wrapper;
            for(LawDetails detail : details){
                wrapper = new LawDetailWrapper();
                String detalName = "";

                for(ModuleTypeDesc typeDesc : detail.getModuleType()){
                    detalName += typeDesc.getModuleType()+"/";
                }

                detalName += "---";
                for(MediumStatusDesc statusDesc : detail.getMediumStatus()){
                    detalName += statusDesc.getMediumStatus()+"/";
                }


                wrapper.setLawDetailId(detail.getId());
                wrapper.setDetailName(detalName);
                wrapper.setPpmLeakThreshold(detail.getPpmLeakThreshold());
                wrapper.setPpmCheckFren(detail.getCheckFre());
                wrapper.setAovCheckFren(detail.getAOV());
                wrapper.setDpmLeakThreshold(detail.getDPM());
                wrappers.add(wrapper);

            }

        }

        return "lawDetailListUI";
    }

    public String  deleteLawDetail(){

        if(law != null && lawDetails != null){

            law = lawService.findById(law.getId());
            Set<LawDetails> details = law.getLawDetails();
            LawDetails needRemove = null;
            for(LawDetails detail : details){

                if(detail.getId().equals(lawDetails.getId())){
                    needRemove = detail;
                }
            }

            if(needRemove != null){
                details.remove(needRemove);
            }

            lawService.update(law);

        }


        return "list";
    }


    /**
     * 批量删除
     */
    public String deleteSelected(){

        if(selectedRow != null){
            for(String id: selectedRow){
                lawService.delete(id);
            }
        }

        return "list";
    }

    /**
     * 删除
     */
    public String delete(){

        if( law != null && law.getId() != null){
            lawService.delete(law.getId());
        }

        setPageNo(1);
        return "list";
    }

    /**
     * 进入修改页面
     */
    public String editUI(){
        //处理回显
        if(law != null && law.getId() != null)
        {
            law = lawService.findById(law.getId());
        }
        return "editUI";
    }


    /**
     * 修改
     */
    public String edit(){

        if(law != null){
            setCurrentLaw();
            lawService.update(law);
        }
        return "list";
    }

    private void setCurrentLaw() {

        if(law.isCurrentLaw()){  //该法规为当前法规， 则其他法规全部直否， 保证当前法规的唯一性

            List<Law> laws = lawService.getAll();
            for(Law l : laws){
                l.setCurrentLaw(false);
                lawService.update(l);
            }

            law = lawService.findById(law.getId());
            law.setCurrentLaw(true);
        }
    }


    public String[] getModuleType() {
        return moduleType;
    }

    public void setModuleType(String[] moduleType) {
        this.moduleType = moduleType;
    }

    public String[] getMediumStatus() {
        return mediumStatus;
    }

    public void setMediumStatus(String[] mediumStatus) {
        this.mediumStatus = mediumStatus;
    }

    public Law getLaw() {
        return law;
    }
    public void setLaw(Law law) {
        this.law = law;
    }
    public ILawService getLawService() {
        return lawService;
    }
    public void setLawService(ILawService lawService) {
        this.lawService = lawService;
    }
    public LawDetails getLawDetails() {
        return lawDetails;
    }
    public void setLawDetails(LawDetails lawDetails) {
        this.lawDetails = lawDetails;
    }
    public ILawDetailsService getLawDetailsService() {
        return lawDetailsService;
    }
    public void setLawDetailsService(ILawDetailsService lawDetailsService) {
        this.lawDetailsService = lawDetailsService;
    }

    public List<LawDetailWrapper> getWrappers() {
        return wrappers;
    }

    public void setWrappers(List<LawDetailWrapper> wrappers) {
        this.wrappers = wrappers;
    }
}
