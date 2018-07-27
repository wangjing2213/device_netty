package com.dearho.common.sms.controller;


import java.util.Arrays;
import java.util.List;

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
import  com.dearho.common.sms.model.SMSRecord;
import  com.dearho.common.sms.service.SMSRecordService;
import com.github.pagehelper.PageInfo;



@RestController
@RequestMapping("${admin.url.prefix}/sys/sMSRecord")
public class SMSRecordController extends AbstractController{

    @Autowired
    private SMSRecordService sMSRecordService;

    
    @RequestMapping(value = "/pages")
    public JSONResult searchPages(SMSRecord sMSRecord,Page page) {
        
    	PageInfo<SMSRecord> sMSRecordPages = sMSRecordService.selectBySMSRecord(sMSRecord, page);
        return JSONResult.AppSuccessJSONResult(sMSRecordPages);
    }
    

    @RequestMapping(value = "/view")
    public JSONResult findOne(String id) {
    	if(StringUtils.isEmpty(id)){
    		return JSONResult.AppValidateJSONResult("id不能为空");
    	}
    	SMSRecord sMSRecord=sMSRecordService.selectByKey(id);
    	if(sMSRecord!=null){
    		return JSONResult.AppSuccessJSONResult(sMSRecord);
    	}else{
    		return JSONResult.AppFailJSONResult("无效ID");
    	}
    }
    
    
    @RequestMapping(value = "/add")
    public JSONResult createSMSRecord( @Validated(GroupAdd.class) SMSRecord sMSRecord, BindingResult errors) {
    	if(errors.hasErrors()){
    		 return JSONResult.AppValidateJSONResult(errors);
    	}
    	int result=sMSRecordService.save(sMSRecord);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("保存成功");
    	}else{
    		return JSONResult.AppFailJSONResult("保存失败");
    	}
    	
    }

    @RequestMapping(value = "/update")
    public JSONResult updateSMSRecord( @Validated(GroupUpdate.class) SMSRecord sMSRecord, BindingResult errors) {
    	if(errors.hasErrors()){
   		 return JSONResult.AppValidateJSONResult(errors);
    	}
    	int result=sMSRecordService.updateAll(sMSRecord);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("修改成功");
    	}else{
    		return JSONResult.AppFailJSONResult("修改失败");
    	}
    }

    @RequestMapping(value = "/delete")
    public JSONResult deleteSMSRecord(String[] ids) {
    	if(ids==null|| ids.length==0){
    		return JSONResult.AppValidateJSONResult("ids不能为空");
    	}
    	List<String> idsList = Arrays.asList(ids);
    	int result=sMSRecordService.deleteByExampleId(idsList);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("删除成功");
    	}else{
    		return JSONResult.AppFailJSONResult("删除失败");
    	}
    }

}