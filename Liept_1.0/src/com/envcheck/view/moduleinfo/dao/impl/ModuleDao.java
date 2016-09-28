package com.envcheck.view.moduleinfo.dao.impl;

import com.envcheck.base.bean.Module;
import com.envcheck.base.bean.PPMRangeBean;
import com.envcheck.base.dao.BaseDao;
import com.envcheck.base.utils.Constant;
import com.envcheck.base.utils.PageResult;
import com.envcheck.base.utils.QueryHelper;
import com.envcheck.report.statistics.letnumberstatistics.bean.ModuleInfoFroDischarge;
import com.envcheck.view.moduleinfo.dao.IModuleDao;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by Administrator on 2016/5/5.
 */
public class ModuleDao extends BaseDao<Module> implements IModuleDao {



    @Override
    public Module getARepresentModule() {
        String hql = "FROM Module m";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.setFirstResult(0);
        query.setMaxResults(1);
        return (Module) query.uniqueResult();
    }


    @Override
    public Module findByLabelAndExtendNumber(String labelNumber, int extendNumber) {

        QueryHelper helper = new QueryHelper(Module.class, "m");
        helper.addConditions("m.labelNumber = ?", labelNumber);
        helper.addConditions("m.extendNumber = ?", extendNumber);

        Query query = sessionFactory.getCurrentSession().createQuery(helper.getQueryListHql());

        query.setParameter(0, helper.getQueryListParameters().get(0));
        query.setParameter(1, helper.getQueryListParameters().get(1));


        return (Module) query.uniqueResult();
    }

    @Override
    public List<Module> getAllByLabelNumber(String importPictureLabelNumber) {

        QueryHelper helper = new QueryHelper(Module.class, "m");
        helper.addConditions("m.labelNumber = ?", importPictureLabelNumber);
        Query query = sessionFactory.getCurrentSession().createQuery(helper.getQueryListHql());
        query.setParameter(0, helper.getQueryListParameters().get(0));
        return query.list();
    }

    @Override
    public PageResult getModuleNotBelongToTask(String taskId, int pageNo, int pageSize) {


        String sql = "SELECT * FROM module m where m.has_check <> TRUE and m.task_id is null";
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(sql);


        sqlQuery.setFirstResult((pageNo-1)*pageSize);//设置数据起始索引号
        sqlQuery.setMaxResults(pageSize);
        List<Module> items = sqlQuery.list();

        String sqlCount = "SELECT COUNT(*) FROM module m where m.has_check <> TRUE and m.task_id is null";
        SQLQuery sqlCountQuery = sessionFactory.getCurrentSession().createSQLQuery(sqlCount);
        BigInteger totalCount = (BigInteger) sqlCountQuery.uniqueResult();


        return new PageResult(totalCount.intValue(), pageNo, pageSize, items);
    }

    @Override
    public long getModuleTotalNumber() {
        QueryHelper helper = new QueryHelper(Module.class, "m");
        Query query = sessionFactory.getCurrentSession().createQuery(helper.getQueryCountHql());
        return (Long) query.uniqueResult();

    }

    @Override
    public void clearModuleWithTaskConnection(String taskId) {

        String hql = "UPDATE Module m SET m.hasAllocate=?, m.taskId=? WHERE m.taskId= ?";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.setBoolean(0, false);
        query.setString(1, "-1");
        query.setString(2, taskId);
        query.executeUpdate();
    }

    @Override
    public long getDiffCheckModuleNumber() {

        String hql = "SELECT count(*) FROM Module m WHERE m.diffToCheck=?";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.setString(0, "是");
        return (long) query.uniqueResult();
    }

    @Override
    public long getEasyCheckModuleNumber() {

        String hql = "SELECT count(*) FROM Module m WHERE m.diffToCheck=?";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.setString(0, "否");

        return (long) query.uniqueResult();
    }

    @Override
    public long getEasyCheckModuleNumberForDevice(String deviceName) {
        String hql = "SELECT count(*) FROM Module m WHERE m.diffToCheck=? and m.device= ?";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.setString(0, "否");
        query.setString(1, deviceName);

        return (long) query.uniqueResult();
    }


    @Override
    public long getcheckModuleNumberForDevice(String deviceName) {
        String hql = "SELECT count(*) FROM Module m WHERE m.hasCheck=? and m.device= ?";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.setBoolean(0, true);
        query.setString(1, deviceName);

        return (long) query.uniqueResult();
    }

    @Override
    public long getModuleRepairNumberForDeivce(String deviceName) {
        String hql = "SELECT count(*) FROM Module m WHERE m.moduleRepairRecord.repairResult=? and m.device= ?";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.setBoolean(0, true);
        query.setString(1, deviceName);

        return (long) query.uniqueResult();
    }

    @Override
    public double getDelayRepairNumberForDevice(String deviceName) {
        String hql = "SELECT count(*) FROM Module m WHERE m.leak=? and  m.moduleRepairRecord is not null and  m.moduleRepairRecord.repairResult = ? and m.device= ?";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.setBoolean(0, true);
        query.setBoolean(1, false);
        query.setString(2, deviceName);

        return (long) query.uniqueResult();
    }

    @Override
    public List<Module> getHasRepairModule() {

        String hql = "FROM Module m WHERE m.leak=? and  m.moduleRepairRecord is not null and  m.moduleRepairRecord.repairResult = ?";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.setBoolean(0, true);
        query.setBoolean(1, true);

        return query.list();
    }

    @Override
    public List<Long> getModuleNumberByModuleType() {

        List<Long> resultList = new ArrayList<>();

        for(int i=0; i< Constant.MODULE_TYPE.length; i++){
            String hql = "SELECT count(*) FROM Module m WHERE m.modelType=?";
            Query query = getSessionFactory().getCurrentSession().createQuery(hql);
            query.setString(0, Constant.MODULE_TYPE[i]);
            resultList.add((Long) query.uniqueResult());
        }

        return resultList;
    }

    @Override
    public List<Long> getLeakModuleNumberByModuleType() {
        List<Long> resultList = new ArrayList<>();

        for(int i=0; i< Constant.MODULE_TYPE.length; i++){
            String hql = "SELECT count(*) FROM Module m WHERE m.modelType=? and m.leak=?";
            Query query = getSessionFactory().getCurrentSession().createQuery(hql);
            query.setString(0, Constant.MODULE_TYPE[i]);
            query.setBoolean(1, true);
            resultList.add((Long) query.uniqueResult());
        }

        return resultList;
    }


    @Override
    public Map<String, Long> getModuleNumberByDevice() {

        Map<String, Long> resultMap = new HashMap<>();
        String hql = "SELECT new map(m.device as deviceName, count(*) as deviceNumber) FROM Module m GROUP BY m.device";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);

        List<Map>  list = query.list();  //List中又有一个List

        for(Map tempMap : list){
            resultMap.put((String)tempMap.get("deviceName"), (Long)tempMap.get("deviceNumber"));
        }

        return resultMap;

    }


    @Override
    public List<ModuleInfoFroDischarge> getALLModuleInfoForDischargeByDeiveName(String deviceName) {
        return  getResultListForDisCharge("m.device=?", deviceName);
    }

    @Override
    public List<ModuleInfoFroDischarge> getALLModuleInfoForDischargeByModuleType(String moduleType) {
        return  getResultListForDisCharge("m.modelType=?", moduleType);
    }

    @Override
    public List<ModuleInfoFroDischarge> getALLModuleInfoForDischargeByMediumStatus(String mediumStatus) {
        return  getResultListForDisCharge("m.mediumStatus=?", mediumStatus);
    }


    private List<ModuleInfoFroDischarge> getResultListForDisCharge(String condition, String param) {

        List<ModuleInfoFroDischarge> resultList = new ArrayList<>();
        QueryHelper helper = new QueryHelper(Module.class, "m");
        helper.addConditions(condition, param);
        helper.addConditions("m.diffToCheck=?", "否");
        helper.setWhereClause(" and size(m.dischargeForPPMRecords) > 0");

        List<Module> modules = getAll(helper);

        ModuleInfoFroDischarge moduleInfoFroDischarge;
        for(Module module : modules){
            moduleInfoFroDischarge = new ModuleInfoFroDischarge(module.getModelType(), module.getDischargeForPPMRecords(),
                    module.getDevice(), module.getYearRunTime(), module.getDiffToCheck(), module.getMediumStatus());
            resultList.add(moduleInfoFroDischarge);
        }
        return resultList;
    }


    @Override
    public Map<String, Long> getCheckModuleNumberByDeviceAndTime(Date startTime, Date endTime) {

        Map<String, Long> resultMap = new HashMap<>();
        String hql = "SELECT new map(m.device as deviceName, count(*) as deviceNumber) FROM Module m where m.moduleCheck.startTime between ? and ? GROUP BY m.device";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.setDate(0, startTime);
        query.setDate(1, endTime);

        List<Map>  list = query.list();  //List中又有一个List

        for(Map tempMap : list){
            resultMap.put((String)tempMap.get("deviceName"), (Long)tempMap.get("deviceNumber"));
        }

        return resultMap;
    }

    @Override
    public Map<String, Long> getLeakModuleNumberByDeviceAndTime(Date startTime, Date endTime) {

        String hql = "SELECT new map(m.device as deviceName, count(*) as deviceNumber) FROM Module m where m.leak=? and m.moduleCheck.startTime between ? and ? GROUP BY m.device";
        return  getResultMapByHQLForTendency(hql, startTime, endTime);

    }

    @Override
    public Map<String, Long> getRepairModuleNumberByDeviceAndTime(Date startTime, Date endTime) {

        String hql = "SELECT new map(m.device as deviceName, count(*) as deviceNumber) FROM Module m where m.moduleRepairRecord.repairResult=? and m.moduleCheck.startTime between ? and ? GROUP BY m.device";
        return  getResultMapByHQLForTendency(hql, startTime, endTime);
    }



    private Map<String,Long> getResultMapByHQLForTendency(String hql, Date startTime, Date endTime) {

        Map<String, Long> resultMap = new HashMap<>();

        Query query = getSessionFactory().getCurrentSession().createQuery(hql);

        query.setBoolean(0, true);
        query.setDate(1, startTime);
        query.setDate(2, endTime);

        List<Map>  list = query.list();  //List中又有一个List

        for(Map tempMap : list){
            resultMap.put((String)tempMap.get("deviceName"), (Long)tempMap.get("deviceNumber"));
        }

        return  resultMap;
    }

    @Override
    public Map<String, Long> getCheckModuleNumberByDevice() {
        String hql = "SELECT new map(m.device as deviceName, count(*) as deviceNumber) FROM Module m where m.hasCheck=? GROUP BY m.device";
        return getResultMapByHQL(hql);
    }

    @Override
    public Map<String, Long> getModuleLeakNumberByDevice() {

        String hql = "SELECT new map(m.device as deviceName, count(*) as deviceNumber) FROM Module m where m.leak=? GROUP BY m.device";
        return  getResultMapByHQL(hql);
    }

    @Override
    public Map<String, Long> getModuleRepairNumberByDevice() {
        String hql = "SELECT new map(m.device as deviceName, count(*) as deviceNumber) FROM Module m where m.moduleRepairRecord.repairResult=? GROUP BY m.device";
        return  getResultMapByHQL(hql);
    }

    @Override
    public long getTotalModuleByDevice(String name) {
        String hql = "SELECT count(*) FROM Module m where m.device=?";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.setString(0, name);
        return (long) query.uniqueResult();
    }


    @Override
    public long getTotalLeakModuleByDevice(String name) {
        String hql = "SELECT count(*) FROM Module m where m.device=? and m.leak=?";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.setString(0, name);
        query.setBoolean(1, true);
        return (long) query.uniqueResult();
    }


    @Override
    public long getTotalLeakNumber() {
        String hql = "SELECT count(*) FROM Module m where m.leak=?";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.setBoolean(0, true);
        return (long) query.uniqueResult();
    }

    @Override
    public long getTotalLabelNumber() {
        String hql = "SELECT count(DISTINCT m.labelNumber) FROM Module m";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        return (long) query.uniqueResult();
    }


    @Override
    public List<String> getAllMediumStatus() {
        String hql = "SELECT DISTINCT m.mediumStatus FROM Module m";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        return query.list();
    }



    @Override
    public long getDelayRepairNumber() {
        String hql = "SELECT count(*) FROM Module m where m.leak=? and m.hasCheck = ? and m.moduleRepairRecord.repairResult = ? and m.moduleRepairRecord is not null";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.setBoolean(0, true);
        query.setBoolean(1, true);
        query.setBoolean(2, false);
        return (long) query.uniqueResult();
    }


    private Map<String,Long> getResultMapByHQL(String hql) {

        Map<String, Long> resultMap = new HashMap<>();
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.setBoolean(0, true);

        List<Map>  list = query.list();

        for(Map tempMap : list){
            resultMap.put((String)tempMap.get("deviceName"), (Long)tempMap.get("deviceNumber"));
        }
        return resultMap;

    }



    @Override
    public List<Long> getPPMAllocateByDeviceName(String deviceName) {

        List<Long> ppmAllocateList = new ArrayList<>();

        for(PPMRangeBean range : Constant.ppmRanges){

            if(!range.isToptop){
                String hql = "SELECT count(*) from Module m where m.device = ? and m.moduleCheck.PPMNumber between ? and ?";
                Query query = getSessionFactory().getCurrentSession().createQuery(hql);
                query.setString(0, deviceName);
                query.setInteger(1, range.bottomVaule);
                query.setInteger(2, range.topValue);
                ppmAllocateList.add((Long) query.uniqueResult());
            }else{

                String hql = "SELECT count(*) from Module m where m.device = ? and  ? < m.moduleCheck.PPMNumber";
                Query query = getSessionFactory().getCurrentSession().createQuery(hql);
                query.setString(0, deviceName);
                query.setInteger(1, range.topValue);
                ppmAllocateList.add((Long) query.uniqueResult());
            }
        }

        return ppmAllocateList;
    }

}
