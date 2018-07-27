package com.dearho.common.sms.controller;


import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dearho.core.AbstractController;
import com.dearho.core.Page;
import com.dearho.core.validate.GroupAdd;
import com.dearho.core.validate.GroupUpdate;
import com.dearho.result.JSONResult;
import  com.dearho.common.sms.model.SMSCode;
import  com.dearho.common.sms.service.SMSCodeService;
import com.github.pagehelper.PageInfo;



@RestController
@RequestMapping("${admin.url.prefix}/sys/sMSCode")
public class SMSCodeController extends AbstractController{

    @Autowired
    private SMSCodeService sMSCodeService;

    
    @RequestMapping(value = "/pages")
    public JSONResult searchPages(SMSCode sMSCode,Page page,HttpServletRequest request) {
        
    	PageInfo<SMSCode> sMSCodePages = sMSCodeService.selectBySMSCode(sMSCode, page);
        return JSONResult.AppSuccessJSONResult(sMSCodePages);
    }
    

    @RequestMapping(value = "/view")
    public JSONResult findOne(String id,HttpServletRequest request) {
    	if(StringUtils.isEmpty(id)){
    		return JSONResult.AppValidateJSONResult("id不能为空");
    	}
    	SMSCode sMSCode=sMSCodeService.selectByKey(id);
    	if(sMSCode!=null){
    		return JSONResult.AppSuccessJSONResult(sMSCode);
    	}else{
    		return JSONResult.AppFailJSONResult("无效ID");
    	}
    }
    
    
    @RequestMapping(value = "/add")
    public JSONResult createSMSCode( @Validated(GroupAdd.class) SMSCode sMSCode, BindingResult errors,HttpServletRequest request) {
    	if(errors.hasErrors()){
    		 return JSONResult.AppValidateJSONResult(errors);
    	}
    	int result=sMSCodeService.save(sMSCode);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("保存成功");
    	}else{
    		return JSONResult.AppFailJSONResult("保存失败");
    	}
    	
    }

    @RequestMapping(value = "/update")
    public JSONResult updateSMSCode( @Validated(GroupUpdate.class) SMSCode sMSCode, BindingResult errors,HttpServletRequest request) {
    	if(errors.hasErrors()){
   		 return JSONResult.AppValidateJSONResult(errors);
    	}
    	int result=sMSCodeService.updateAll(sMSCode);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("修改成功");
    	}else{
    		return JSONResult.AppFailJSONResult("修改失败");
    	}
    }

    @RequestMapping(value = "/delete")
    public JSONResult deleteSMSCode(String[] ids,HttpServletRequest request) {
    	if(ids==null|| ids.length==0){
    		return JSONResult.AppValidateJSONResult("ids不能为空");
    	}
    	List<String> idsList = Arrays.asList(ids);
    	int result=sMSCodeService.deleteByExampleId(idsList);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("删除成功");
    	}else{
    		return JSONResult.AppFailJSONResult("删除失败");
    	}
    }

}