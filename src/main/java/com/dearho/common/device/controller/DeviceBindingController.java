package com.dearho.common.device.controller;


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
import  com.dearho.common.device.model.DeviceBinding;
import  com.dearho.common.device.service.DeviceBindingService;
import com.github.pagehelper.PageInfo;



@RestController
@RequestMapping("${admin.url.prefix}/sys/deviceBinding")
public class DeviceBindingController extends AbstractController{

    @Autowired
    private DeviceBindingService deviceBindingService;

    
    @RequestMapping(value = "/pages")
    public JSONResult searchPages(DeviceBinding deviceBinding,Page page,HttpServletRequest request) {
        
    	PageInfo<DeviceBinding> deviceBindingPages = deviceBindingService.selectByDeviceBinding(deviceBinding, page);
        return JSONResult.AppSuccessJSONResult(deviceBindingPages);
    }
    

    @RequestMapping(value = "/view")
    public JSONResult findOne(String id,HttpServletRequest request) {
    	if(StringUtils.isEmpty(id)){
    		return JSONResult.AppValidateJSONResult("id不能为空");
    	}
    	DeviceBinding deviceBinding=deviceBindingService.selectByKey(id);
    	if(deviceBinding!=null){
    		return JSONResult.AppSuccessJSONResult(deviceBinding);
    	}else{
    		return JSONResult.AppFailJSONResult("无效ID");
    	}
    }
    
    
    @RequestMapping(value = "/add")
    public JSONResult createDeviceBinding( @Validated(GroupAdd.class) DeviceBinding deviceBinding, BindingResult errors,HttpServletRequest request) {
    	if(errors.hasErrors()){
    		 return JSONResult.AppValidateJSONResult(errors);
    	}
    	int result=deviceBindingService.save(deviceBinding);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("保存成功");
    	}else{
    		return JSONResult.AppFailJSONResult("保存失败");
    	}
    	
    }

    @RequestMapping(value = "/update")
    public JSONResult updateDeviceBinding( @Validated(GroupUpdate.class) DeviceBinding deviceBinding, BindingResult errors,HttpServletRequest request) {
    	if(errors.hasErrors()){
   		 return JSONResult.AppValidateJSONResult(errors);
    	}
    	int result=deviceBindingService.updateAll(deviceBinding);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("修改成功");
    	}else{
    		return JSONResult.AppFailJSONResult("修改失败");
    	}
    }

    @RequestMapping(value = "/delete")
    public JSONResult deleteDeviceBinding(String[] ids,HttpServletRequest request) {
    	if(ids==null|| ids.length==0){
    		return JSONResult.AppValidateJSONResult("ids不能为空");
    	}
    	List<String> idsList = Arrays.asList(ids);
    	int result=deviceBindingService.deleteByExampleId(idsList);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("删除成功");
    	}else{
    		return JSONResult.AppFailJSONResult("删除失败");
    	}
    }

}