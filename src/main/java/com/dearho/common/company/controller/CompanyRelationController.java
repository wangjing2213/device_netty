package com.dearho.common.company.controller;


import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dearho.common.company.model.CompanyConfig;
import  com.dearho.common.company.model.CompanyRelation;
import com.dearho.common.company.service.CompanyConfigService;
import  com.dearho.common.company.service.CompanyRelationService;
import com.dearho.common.company.vo.CompanyRelationVO;
import com.dearho.core.AbstractController;
import com.dearho.core.Constants;
import com.dearho.core.Page;
import com.dearho.core.URLModel;
import com.dearho.core.validate.GroupAdd;
import com.dearho.core.validate.GroupUpdate;
import com.dearho.result.JSONResult;
import com.github.pagehelper.PageInfo;



@RestController
@RequestMapping("${admin.url.prefix}/sys/companyRelation")
public class CompanyRelationController extends AbstractController{

    @Autowired
    private CompanyRelationService companyRelationService;
    
    @Autowired
    private CompanyConfigService companyConfigService;

    @URLModel(name=Constants.MODEL_TYPE_PAGE,parent=Constants.MODEL_ID_SYS_COMPANY)
    @RequestMapping(value = "/pages")
    public JSONResult searchPages(CompanyRelation companyRelation,Page page) {
        
    	PageInfo<CompanyRelation> companyRelationPages = companyRelationService.selectByCompanyRelation(companyRelation, page);
        return JSONResult.AppSuccessJSONResult(companyRelationPages);
    }
    
    @URLModel(name=Constants.MODEL_TYPE_VIEW,parent=Constants.MODEL_ID_SYS_COMPANY)
    @RequestMapping(value = "/view")
    public JSONResult findOne(Integer id) {
    	if(id==null){
    		return JSONResult.AppValidateJSONResult("id不能为空");
    	}
    	CompanyRelation companyRelation=companyRelationService.selectByKey(id);
    	if(companyRelation!=null){
    		if(StringUtils.isNotEmpty(companyRelation.getCompanyConfigId())) {
    			CompanyConfig companyConfig=companyConfigService.selectByKey(companyRelation.getCompanyConfigId());
    			companyRelation.setCompanyConfig(companyConfig);
    		}
    		return JSONResult.AppSuccessJSONResult(companyRelation);
    	}else{
    		return JSONResult.AppFailJSONResult("无效ID");
    	}
    }
    
    @URLModel(name=Constants.MODEL_TYPE_ADD,parent=Constants.MODEL_ID_SYS_COMPANY)
    @RequestMapping(value = "/add")
    public JSONResult createCompanyRelation( @Validated(GroupAdd.class) CompanyRelation companyRelation, BindingResult errors,CompanyConfig companyConfig) {
    	if(errors.hasErrors()){
    		 return JSONResult.AppValidateJSONResult(errors);
    	}
    	int result=companyRelationService.save(companyRelation);
    	companyConfigService.save(companyConfig);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("保存成功");
    	}else{
    		return JSONResult.AppFailJSONResult("保存失败");
    	}
    	
    }

    @URLModel(name=Constants.MODEL_TYPE_UPDATE,parent=Constants.MODEL_ID_SYS_COMPANY)
    @RequestMapping(value = "/update")
    public JSONResult updateCompanyRelation( @Validated(GroupUpdate.class) CompanyRelation companyRelation, BindingResult errors,CompanyConfig companyConfig) {
    	if(errors.hasErrors()){
   		 return JSONResult.AppValidateJSONResult(errors);
    	}
    	int result=companyRelationService.updateAll(companyRelation);
    	companyConfigService.save(companyConfig);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("修改成功");
    	}else{
    		return JSONResult.AppFailJSONResult("修改失败");
    	}
    }

    @URLModel(name=Constants.MODEL_TYPE_DELETE,parent=Constants.MODEL_ID_SYS_COMPANY)
    @RequestMapping(value = "/delete")
    public JSONResult deleteCompanyRelation(String[] ids) {
    	if(ids==null|| ids.length==0){
    		return JSONResult.AppValidateJSONResult("ids不能为空");
    	}
    	List<String> idsList = Arrays.asList(ids);
    	int result=companyRelationService.deleteByExampleId(idsList);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("删除成功");
    	}else{
    		return JSONResult.AppFailJSONResult("删除失败");
    	}
    }
    
    
    @RequestMapping(value = "/treelist")
    public JSONResult searchTreeList(HttpServletRequest request) {

    	List<CompanyRelationVO> companyVOList=companyRelationService.queryCompanyRelationVOList(getAdminUser(request),true);
		if(companyVOList!=null && !companyVOList.isEmpty()){
			for(CompanyRelationVO vo:companyVOList){
				vo.setName(vo.getPrefix()+vo.getName());
			}
		}
    
        return JSONResult.AppSuccessJSONResult(companyVOList);
    }
    
    
    @RequestMapping(value = "/list")
    public JSONResult searchList(HttpServletRequest request) {

    	List<CompanyRelation> companyList=companyRelationService.selectCompanyRelationByUser(null, null);
	
    
        return JSONResult.AppSuccessJSONResult(companyList);
    }
    
    
    
    
    
}