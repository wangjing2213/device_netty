package com.dearho.business.dict.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dearho.SpringUtils;
import com.dearho.business.dict.model.Dict;
import com.dearho.business.dict.model.DictGroup;
import com.dearho.business.dict.service.DictGroupService;
import com.dearho.business.dict.service.DictService;
import com.dearho.common.company.service.CompanyRelationService;

import org.apache.commons.lang.StringUtils;




public class DictUtil {
	
    @Autowired
	private static DictService dictService = (DictService) SpringUtils.getBean("dictService");;
	
    @Autowired
    private static DictGroupService dictGroupService = (DictGroupService) SpringUtils.getBean("dictGroupService");

    
	public static List<Dict> getDictsByGroupId(String groupId){
		List<Dict> resultDicts = new ArrayList<Dict>();
		for (Dict dict : dictService.getDicts()) {
			if(dict.getGroupId().equals(groupId)){
				resultDicts.add(dict);
			}
		}
		return resultDicts;
	}
	
	public static List<Dict> getDictsByGroupCode(String groupCode){
		List<Dict> resultDicts = new ArrayList<Dict>();
		String groupId = null;
		for (DictGroup dictGroup : dictGroupService.getDictGroups()) {
			if(dictGroup.getCode().equals(groupCode)){
				groupId = dictGroup.getId();
			}
		}
		for (Dict dict : dictService.getDicts()) {
			if(dict.getGroupId().equals(groupId) && new Integer(1).equals(dict.getIsUsed())){
				resultDicts.add(dict);
			}
		}
		return resultDicts;
	}
	
	public static List<DictVo> getDictVosByGroupCode(String groupCode){
		
		List<DictVo> resultDicts = new ArrayList<DictVo>();
		String groupId = null;
		for (DictGroup dictGroup : dictGroupService.getDictGroups()) {
			if(dictGroup.getCode().equals(groupCode)){
				groupId = dictGroup.getId();
			}
		}
		for (Dict dict : dictService.getDicts()) {
			if(dict.getGroupId().equals(groupId)){
				resultDicts.add(new DictVo(dict));
			}
		}
		return resultDicts;
	}
	
	public static List<Dict> getDictsByGroupCode(String groupCode,String sn){
		
		List<Dict> resultDicts = new ArrayList<Dict>();
		String groupId = null;
		for (DictGroup dictGroup : dictGroupService.getDictGroups()) {
			if(dictGroup.getCode().equals(groupCode)){
				groupId = dictGroup.getId();
			}
		}
		for (Dict dict : dictService.getDicts()) {
			if(dict.getGroupId().equals(groupId) && dict.getCompanySn()!=null && dict.getCompanySn().contains(sn)){
				resultDicts.add(dict);
			}
		}
		return resultDicts;
	}
	
	public static List<Dict> getDictsByGroupCode(String groupCode,Integer companyId){
		if(companyId==null){
			return null;
		}
		
		List<Dict> resultDicts = new ArrayList<Dict>();
		String groupId = null;
		for (DictGroup dictGroup : dictGroupService.getDictGroups()) {
			if(dictGroup.getCode().equals(groupCode)){
				groupId = dictGroup.getId();
			}
		}
		
		for (Dict dict : dictService.getDicts()) {
			
			if(dict.getGroupId().equals(groupId) && dict.getCompanyId()!=null && dict.getCompanyId().equals(companyId)){
				resultDicts.add(dict);
			}
		}
		return resultDicts;
	}
	
	public static List<String> getDictsByGroupCnName(String groupCode){
		
		List<String> resultDicts = new ArrayList<String>();
		String groupId = null;
		for (DictGroup dictGroup : dictGroupService.getDictGroups()) {
			if(dictGroup.getCode().equals(groupCode)){
				groupId = dictGroup.getId();
			}
		}
		for (Dict dict : dictService.getDicts()) {
			if(dict.getGroupId().equals(groupId)){
				resultDicts.add(dict.getCnName());
			}
		}
		return resultDicts;
	}
	
	
	public static Map<String,String> getDictMapByGroupCode(String groupCode){
		
		Map<String,String> resultDictMap = new HashMap<String,String>();
		String groupId = null;
		for (DictGroup dictGroup : dictGroupService.getDictGroups()) {
			if(dictGroup.getCode().equals(groupCode)){
				groupId = dictGroup.getId();
			}
		}
		for (Dict dict : dictService.getDicts()) {
			if(dict.getGroupId().equals(groupId)){
				resultDictMap.put(dict.getCode(), dict.getCnName());
			}
		}
		return resultDictMap;
	}
	public static List<Dict> getDictSelectsByGroupCode(String groupCode,int type){
		
		String groupId = null;
		for (DictGroup dictGroup : dictGroupService.getDictGroups()) {
			if(dictGroup.getCode().equals(groupCode)){
				groupId = dictGroup.getId();
			}
		}
		List<Dict> resultDicts = new ArrayList<Dict>();
		Dict d = new Dict();
		switch (type) {
		case 1:
			d.setCnName("全部");
			resultDicts.add(d);
			break;
		case 2:
			d.setCnName("请选择");
			resultDicts.add(d);
			break;
		default:
			break;
		}
		
		for (Dict dict : dictService.getDicts()) {
			if(dict.getGroupId().equals(groupId)){
				resultDicts.add(dict);
			}
		}
		return resultDicts;
	}
	
	public static List<Dict> getDictSelectsByGroupCode(String groupCode,int type,String sn){
		
		String groupId = null;
		for (DictGroup dictGroup : dictGroupService.getDictGroups()) {
			if(dictGroup.getCode().equals(groupCode)){
				groupId = dictGroup.getId();
			}
		}
		List<Dict> resultDicts = new ArrayList<Dict>();
		Dict d = new Dict();
		switch (type) {
		case 1:
			d.setCnName("全部");
			resultDicts.add(d);
			break;
		case 2:
			d.setCnName("请选择");
			resultDicts.add(d);
			break;
		default:
			break;
		}
		
		for (Dict dict : dictService.getDicts()) {
			if(dict.getGroupId().equals(groupId) && dict.getCompanySn()!=null && dict.getCompanySn().contains(sn)){
				resultDicts.add(dict);
			}
		}
		return resultDicts;
	}
	
	public static Dict getDictById(String id){
		
		for (Dict dict : dictService.getDicts()) {
			if(dict.getId().equals(id)){
				return dict;
			}
		}
		return null;
	}
	
	public static String getCnNameByCode(String groupCode,String dictCode){
		List<Dict> dicts = getDictsByGroupCode(groupCode);
		for (Dict dict : dicts) {
			if(dict.getCode().equals(dictCode)){
				return dict.getCnName();
			}
		}
		return "";
	}

	public static String getCnNameByGroupCodeAndDictId(String groupCode,String dictId){
		if(StringUtils.isEmpty(dictId)){
			return "";
		}
		List<Dict> dicts = getDictsByGroupCode(groupCode);
		for (Dict dict : dicts) {
			if(dict.getId().equals(dictId)){
				return dict.getCnName();
			}
		}
		return "";
	}
	
	public static Dict getDictByCodes(String groupCode,String dictCode){
		
		List<Dict> resultDicts = new ArrayList<Dict>();
		String groupId = null;
		for (DictGroup dictGroup : dictGroupService.getDictGroups()) {
			if(dictGroup.getCode().equals(groupCode)){
				groupId = dictGroup.getId();
			}
		}
		for (Dict dict : dictService.getDicts()) {
			if(dict.getGroupId().equals(groupId)){
				resultDicts.add(dict);
			}
		}
	
		for (Dict dict : resultDicts) {
			if(dict.getCode().equals(dictCode)){
				return dict;
			}
		}
		return null;
	}
	
	public static Map<String,Dict> getDictObjMapByGroupCode(String groupCode){
		
		Map<String,Dict> resultDictMap = new HashMap<String,Dict>();
		String groupId = null;
		for (DictGroup dictGroup : dictGroupService.getDictGroups()) {
			if(dictGroup.getCode().equals(groupCode)){
				groupId = dictGroup.getId();
			}
		}
		for (Dict dict : dictService.getDicts()) {
			if(dict.getGroupId().equals(groupId)){
				resultDictMap.put(dict.getCode(), dict);
			}
		}
		return resultDictMap;
	}
	public static String getRemarkByGroupCode(String groupCode){
		
		for (DictGroup dictGroup : dictGroupService.getDictGroups()) {
			if(dictGroup.getCode().equals(groupCode)){
				return dictGroup.getRemark();
			}
		}
		return "";
	}

}
