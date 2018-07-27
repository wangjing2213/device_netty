package com.dearho.business.dict.controller;


import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import  com.dearho.business.dict.model.DictGroup;
import  com.dearho.business.dict.service.DictGroupService;
import com.dearho.core.AbstractController;
import com.dearho.core.Page;
import com.dearho.core.validate.GroupAdd;
import com.dearho.core.validate.GroupUpdate;
import com.dearho.result.JSONResult;
import com.github.pagehelper.PageInfo;



@RestController
@RequestMapping("${admin.url.prefix}/sys/dictGroup")
public class DictGroupController extends AbstractController{

    @Autowired
    private DictGroupService dictGroupService;

    
    @RequestMapping(value = "/pages")
    public JSONResult searchPages(DictGroup dictGroup,Page page) {
        
    	PageInfo<DictGroup> dictGroupPages = dictGroupService.selectByDictGroup(dictGroup, page);
        return JSONResult.AppSuccessJSONResult(dictGroupPages);
    }
    
    @RequestMapping(value = "/list")
    public JSONResult searchAllList(DictGroup dictGroup) {
    	List<DictGroup> dictPages = dictGroupService.searchDictGroups(dictGroup);
        return JSONResult.AppSuccessJSONResult(dictPages);
    }
    
    
    @RequestMapping(value = "/system/list")
    public JSONResult searchSystemDictGroup(DictGroup dictGroup) {
        if(dictGroup==null) {
        	dictGroup=new DictGroup();
        }
        dictGroup.setIsSystem(1);
    	List<DictGroup> dictPages = dictGroupService.searchDictGroups(dictGroup);
        return JSONResult.AppSuccessJSONResult(dictPages);
    }
    
    
    @RequestMapping(value = "/business/list")
    public JSONResult searchBusinessDictGroup(DictGroup dictGroup,HttpServletRequest request) {
    	if(dictGroup==null) {
        	dictGroup=new DictGroup();
        }
        dictGroup.setIsSystem(0);
        dictGroup.setCompanyId(getAdminUserCompanyId(request));
    	List<DictGroup> dictPages = dictGroupService.searchDictGroups(dictGroup);
        return JSONResult.AppSuccessJSONResult(dictPages);
    }

    @RequestMapping(value = "/view")
    public JSONResult findOne(String id) {
    	if(StringUtils.isEmpty(id)){
    		return JSONResult.AppValidateJSONResult("id不能为空");
    	}
    	DictGroup dictGroup=dictGroupService.selectByKey(id);
    	if(dictGroup!=null){
    		return JSONResult.AppSuccessJSONResult(dictGroup);
    	}else{
    		return JSONResult.AppFailJSONResult("无效ID");
    	}
    }
    
    
    @RequestMapping(value = "/add")
    public JSONResult createDictGroup( @Validated(GroupAdd.class) DictGroup dictGroup, BindingResult errors) {
    	if(errors.hasErrors()){
    		 return JSONResult.AppValidateJSONResult(errors);
    	}
    	int result=dictGroupService.save(dictGroup);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("保存成功");
    	}else{
    		return JSONResult.AppFailJSONResult("保存失败");
    	}
    	
    }

    @RequestMapping(value = "/update")
    public JSONResult updateDictGroup( @Validated(GroupUpdate.class) DictGroup dictGroup, BindingResult errors) {
    	if(errors.hasErrors()){
   		 return JSONResult.AppValidateJSONResult(errors);
    	}
    	int result=dictGroupService.updateAll(dictGroup);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("修改成功");
    	}else{
    		return JSONResult.AppFailJSONResult("修改失败");
    	}
    }

    @RequestMapping(value = "/delete")
    public JSONResult deleteDictGroup(String[] ids) {
    	if(ids==null|| ids.length==0){
    		return JSONResult.AppValidateJSONResult("ids不能为空");
    	}
    	List<String> idsList = Arrays.asList(ids);
    	int result=dictGroupService.deleteByExampleId(idsList);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("删除成功");
    	}else{
    		return JSONResult.AppFailJSONResult("删除失败");
    	}
    }

}