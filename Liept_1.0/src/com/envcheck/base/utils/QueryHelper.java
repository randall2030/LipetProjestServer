package com.envcheck.base.utils;

import com.envcheck.base.bean.Module;

import java.util.ArrayList;
import java.util.List;

public class QueryHelper {
	
	//from子句
	private String fromClause = "";
	//where子句
	private String whereClause = "";
	//order by子句
	private String orderByClause = "";
	
	private List<Object> paramsList;
	
	public static String ORDER_BY_ASC = "ASC";
	public static String ORDER_BY_DESC = "DESC";

	private String joinHQL;

	/**
	 * 构造from 子句
	 * @param clazz 实体类
	 * @param alias 实体类对应的别名
	 */
	public QueryHelper(Class clazz, String alias)
	{
		fromClause = "FROM "+clazz.getSimpleName()+" " + alias;  //"FROM ClassName"
	}

	
	/**
	 * 构造where子句
	 * @param condition 查询条件语句；例如：i.title like ?
	 * @param params 查询条件语句中?对应的查询条件值；例如： %标题%
	 */
	public void addConditions(String condition, Object... params)
	{
		if(whereClause.length() > 1)
		{
			whereClause += " AND "+condition;
		}
		else
		{
			whereClause += " WHERE "+condition;
		}
		
		//设置查询条件值到查询条件值集合中
		if(paramsList == null){
			paramsList = new ArrayList<Object>();
		}

		if(params != null){
			for(Object param: params){
				paramsList.add(param);
			}
		}
	}
	
	public String getQueryCountHql()
	{

		return "SELECT COUNT(*) "+fromClause + whereClause;

	}


	public void insertJoinClause(String str) {
		joinHQL = str;
	}
	
	/**
	 * 构造order by子句
	 * @param property 排序属性，如：i.createTime
	 * @param order 排序顺序，如：DESC 或者 ASC
	 */
	public void addOrderByProperty(String property, String order){
		if (orderByClause.length() > 1) {//非第一个排序属性
			orderByClause += "," + property + " " + order;
		} else {//第一个排序属性
			orderByClause = " ORDER BY " + property + " " + order;
		}
	}

	
	
	public String getQueryListHql() {

		if(joinHQL != null){
			return fromClause + joinHQL + whereClause + orderByClause;
		}

		return fromClause + whereClause + orderByClause;
	}



	public void setWhereClause(String appendCondition){

		if (whereClause.length() != 0) {
			whereClause += appendCondition;
		}else{

			appendCondition = appendCondition.substring(appendCondition.indexOf(' ')+1);
			whereClause += " where "+appendCondition;
		}

	}
	
	public List<Object> getQueryListParameters() {
		return paramsList;
	}

	public static void addBaseConditionForModule(Module module, QueryHelper qh) {

		addBaseConditionForModuleReport(module, qh);

		if(StringUtils.notIsNullAndEmptyString(module.getDangerToCheck())){
			if(!Constant.CONDITION_ALL.equals(module.getDangerToCheck())){
				qh.addConditions("m.dangerToCheck=?", module.getDangerToCheck());
			}
		}

		if(StringUtils.notIsNullAndEmptyString(module.getTempToMove())){
			if(!Constant.CONDITION_ALL.equals(module.getTempToMove())){
				qh.addConditions("m.tempToMove=?", module.getTempToMove());
			}
		}


		if(StringUtils.notIsNullAndEmptyString(module.getMediumStatus())){
			qh.addConditions("m.mediumStatus=?", module.getMediumStatus());
		}


		if(StringUtils.notIsNullAndEmptyString(module.getPicturePath())){
			if("有图".equals(module.getPicturePath())){
				qh.setWhereClause("and m.picturePath is not null");
			}else{  //无图
				qh.setWhereClause("and m.picturePath is null ");
			}
		}


	}

	public static void addBaseConditionForModuleReport(Module module, QueryHelper qh) {

		if(StringUtils.notIsNullAndEmptyString(module.getDevice())){
			qh.addConditions("m.device=?", module.getDevice());
		}

		if(StringUtils.notIsNullAndEmptyString(module.getArea())){
			qh.addConditions("m.area=?", module.getArea());
		}

		if(StringUtils.notIsNullAndEmptyString(module.getLabelNumber())){
			qh.addConditions("m.labelNumber=?", module.getLabelNumber());
		}

		if(StringUtils.notIsNullAndEmptyString(module.getModelType())){
			qh.addConditions("m.modelType=?", module.getModelType());
		}


		if(StringUtils.notIsNullAndEmptyString(module.getDiffToCheck())){
			if(!Constant.CONDITION_ALL.equals(module.getDiffToCheck())){
				qh.addConditions("m.diffToCheck=?", module.getDiffToCheck());
			}
		}

	}

	public static void addBaseConditionForModuleLetCaculate(Module module, QueryHelper qh) {

		qh.addConditions("m.diffToCheck=?", "否");


		if(StringUtils.notIsNullAndEmptyString(module.getDevice())){
			qh.addConditions("m.device=?", module.getDevice());
		}

		if(StringUtils.notIsNullAndEmptyString(module.getArea())){
			qh.addConditions("m.area=?", module.getArea());
		}

		if(StringUtils.notIsNullAndEmptyString(module.getLabelNumber())){
			qh.addConditions("m.labelNumber=?", module.getLabelNumber());
		}

		if(StringUtils.notIsNullAndEmptyString(module.getModelType())){
			qh.addConditions("m.modelType=?", module.getModelType());
		}
	}

	public static void addBaseConditionForBathModityModule(Module module, QueryHelper qh) {

		if(StringUtils.notIsNullAndEmptyString(module.getDevice())){
			qh.addConditions("m.device=?", module.getDevice());
		}

		if(StringUtils.notIsNullAndEmptyString(module.getEquipment())){
			qh.addConditions("m.equipment=?", module.getEquipment());
		}

		if(module.getSizeMM() != 0){
			qh.addConditions("m.sizeMM=?", module.getSizeMM());
		}


		if(StringUtils.notIsNullAndEmptyString(module.getLabelNumber())){
			qh.addConditions("m.labelNumber=?", module.getLabelNumber());
		}

		if(StringUtils.notIsNullAndEmptyString(module.getModelType())){
			qh.addConditions("m.modelType=?", module.getModelType());
		}

		qh.addConditions("m.leak=?", module.isLeak());


	}

}
