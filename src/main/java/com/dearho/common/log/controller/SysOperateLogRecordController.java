package com.dearho.common.log.controller;


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
import  com.dearho.common.log.model.SysOperateLogRecord;
import  com.dearho.common.log.service.SysOperateLogRecordService;
import com.github.pagehelper.PageInfo;



@RestController
@RequestMapping("${admin.url.prefix}/sys/sysOperateLogRecord")
public class SysOperateLogRecordController extends AbstractController{

    @Autowired
    private SysOperateLogRecordService sysOperateLogRecordService;

    
    @RequestMapping(value = "/pages")
    public JSONResult searchPages(SysOperateLogRecord sysOperateLogRecord,Page page) {
        
    	PageInfo<SysOperateLogRecord> sysOperateLogRecordPages = sysOperateLogRecordService.selectBySysOperateLogRecord(sysOperateLogRecord, page);
        return JSONResult.AppSuccessJSONResult(sysOperateLogRecordPages);
    }
    

    @RequestMapping(value = "/view")
    public JSONResult findOne(String id) {
    	if(StringUtils.isEmpty(id)){
    		return JSONResult.AppValidateJSONResult("id不能为空");
    	}
    	SysOperateLogRecord sysOperateLogRecord=sysOperateLogRecordService.selectByKey(id);
    	if(sysOperateLogRecord!=null){
    		return JSONResult.AppSuccessJSONResult(sysOperateLogRecord);
    	}else{
    		return JSONResult.AppFailJSONResult("无效ID");
    	}
    }
    
    
    @RequestMapping(value = "/add")
    public JSONResult createSysOperateLogRecord( @Validated(GroupAdd.class) SysOperateLogRecord sysOperateLogRecord, BindingResult errors) {
    	if(errors.hasErrors()){
    		 return JSONResult.AppValidateJSONResult(errors);
    	}
    	int result=sysOperateLogRecordService.save(sysOperateLogRecord);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("保存成功");
    	}else{
    		return JSONResult.AppFailJSONResult("保存失败");
    	}
    	
    }

    @RequestMapping(value = "/update")
    public JSONResult updateSysOperateLogRecord( @Validated(GroupUpdate.class) SysOperateLogRecord sysOperateLogRecord, BindingResult errors) {
    	if(errors.hasErrors()){
   		 return JSONResult.AppValidateJSONResult(errors);
    	}
    	int result=sysOperateLogRecordService.updateAll(sysOperateLogRecord);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("修改成功");
    	}else{
    		return JSONResult.AppFailJSONResult("修改失败");
    	}
    }

    @RequestMapping(value = "/delete")
    public JSONResult deleteSysOperateLogRecord(String[] ids) {
    	if(ids==null|| ids.length==0){
    		return JSONResult.AppValidateJSONResult("ids不能为空");
    	}
    	List<String> idsList = Arrays.asList(ids);
    	int result=sysOperateLogRecordService.deleteByExampleId(idsList);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("删除成功");
    	}else{
    		return JSONResult.AppFailJSONResult("删除失败");
    	}
    }

}