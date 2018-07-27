package com.dearho.common.company.controller;


import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dearho.core.AbstractController;
import com.dearho.core.Constants;
import com.dearho.core.Page;
import com.dearho.core.URLModel;
import com.dearho.core.validate.GroupAdd;
import com.dearho.core.validate.GroupUpdate;
import com.dearho.result.JSONResult;
import com.dearho.business.menu.model.Menu;
import  com.dearho.common.company.model.CompanyConfig;
import  com.dearho.common.company.service.CompanyConfigService;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;



@RestController
@RequestMapping("${admin.url.prefix}/sys/companyConfig")
public class CompanyConfigController extends AbstractController {

    @Autowired
    private CompanyConfigService companyConfigService;

    @URLModel(name=Constants.MODEL_TYPE_PAGE,parent=Constants.MODEL_ID_SYS_COMPANY_CONFIG)
    @RequestMapping(value = "/pages")
    public JSONResult searchPages(CompanyConfig companyConfig,Page page) {
        
    	PageInfo<CompanyConfig> companyConfigPages = companyConfigService.selectByCompanyConfig(companyConfig, page);
        return JSONResult.AppSuccessJSONResult(companyConfigPages);
    }
    
    @URLModel(name=Constants.MODEL_TYPE_VIEW,parent=Constants.MODEL_ID_SYS_COMPANY_CONFIG)
    @RequestMapping(value = "/view")
    public JSONResult findOne(String id) {
    	if(StringUtils.isEmpty(id)){
    		return JSONResult.AppValidateJSONResult("id不能为空");
    	}
    	CompanyConfig companyConfig=companyConfigService.selectByKey(id);
    	if(companyConfig!=null){
    		return JSONResult.AppSuccessJSONResult(companyConfig);
    	}else{
    		return JSONResult.AppFailJSONResult("无效ID");
    	}
    }
    
    
    @URLModel(name=Constants.MODEL_TYPE_ADD,parent=Constants.MODEL_ID_SYS_COMPANY_CONFIG)
    @RequestMapping(value = "/add")
    public JSONResult createCompanyConfig( @Validated(GroupAdd.class) CompanyConfig companyConfig, BindingResult errors) {
    	if(errors.hasErrors()){
    		 return JSONResult.AppValidateJSONResult(errors);
    	}
    	int result=companyConfigService.save(companyConfig);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("保存成功");
    	}else{
    		return JSONResult.AppFailJSONResult("保存失败");
    	}
    	
    }

    @URLModel(name=Constants.MODEL_TYPE_UPDATE,parent=Constants.MODEL_ID_SYS_COMPANY_CONFIG)
    @RequestMapping(value = "/update")
    public JSONResult updateCompanyConfig( @Validated(GroupUpdate.class) CompanyConfig companyConfig, BindingResult errors) {
    	if(errors.hasErrors()){
   		 return JSONResult.AppValidateJSONResult(errors);
    	}
    	int result=companyConfigService.updateAll(companyConfig);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("修改成功");
    	}else{
    		return JSONResult.AppFailJSONResult("修改失败");
    	}
    }

    @URLModel(name=Constants.MODEL_TYPE_DELETE,parent=Constants.MODEL_ID_SYS_COMPANY_CONFIG)
    @RequestMapping(value = "/delete")
    public JSONResult deleteCompanyConfig(String[] ids) {
    	if(ids==null|| ids.length==0){
    		return JSONResult.AppValidateJSONResult("ids不能为空");
    	}
    	List<String> idsList = Arrays.asList(ids);
    	int result=companyConfigService.deleteByExampleId(idsList);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("删除成功");
    	}else{
    		return JSONResult.AppFailJSONResult("删除失败");
    	}
    }
    
    
  
    
    
    

}