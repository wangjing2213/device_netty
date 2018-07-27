package com.dearho.business.menu.controller;


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
import  com.dearho.business.menu.model.UserGroup;
import  com.dearho.business.menu.service.UserGroupService;
import com.github.pagehelper.PageInfo;



@RestController
@RequestMapping("${admin.url.prefix}/sys/userGroup")
public class UserGroupController extends AbstractController{

    @Autowired
    private UserGroupService userGroupService;

    
    @RequestMapping(value = "/list")
    public JSONResult searchList(String userId) {
        
    	List<UserGroup> userGroupList = userGroupService.selectByUserId(userId);
        return JSONResult.AppSuccessJSONResult(userGroupList);
    }
    

    @RequestMapping(value = "/view")
    public JSONResult findOne(String id,HttpServletRequest request) {
    	if(StringUtils.isEmpty(id)){
    		return JSONResult.AppValidateJSONResult("id不能为空");
    	}
    	UserGroup userGroup=userGroupService.selectByKey(id);
    	if(userGroup!=null){
    		return JSONResult.AppSuccessJSONResult(userGroup);
    	}else{
    		return JSONResult.AppFailJSONResult("无效ID");
    	}
    }
    
    
    @RequestMapping(value = "/add")
    public JSONResult createUserGroup( @Validated(GroupAdd.class) UserGroup userGroup, BindingResult errors,HttpServletRequest request) {
    	if(errors.hasErrors()){
    		 return JSONResult.AppValidateJSONResult(errors);
    	}
    	int result=userGroupService.save(userGroup);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("保存成功");
    	}else{
    		return JSONResult.AppFailJSONResult("保存失败");
    	}
    	
    }

    @RequestMapping(value = "/update")
    public JSONResult updateUserGroup( @Validated(GroupUpdate.class) UserGroup userGroup, BindingResult errors,HttpServletRequest request) {
    	if(errors.hasErrors()){
    		return JSONResult.AppValidateJSONResult(errors);
    	}
    	int result=userGroupService.updateAll(userGroup);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("修改成功");
    	}else{
    		return JSONResult.AppFailJSONResult("修改失败");
    	}
    }

    @RequestMapping(value = "/delete")
    public JSONResult deleteUserGroup(String[] ids,HttpServletRequest request) {
    	if(ids==null|| ids.length==0){
    		return JSONResult.AppValidateJSONResult("ids不能为空");
    	}
    	List<String> idsList = Arrays.asList(ids);
    	int result=userGroupService.deleteByExampleId(idsList);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("删除成功");
    	}else{
    		return JSONResult.AppFailJSONResult("删除失败");
    	}
    }

}