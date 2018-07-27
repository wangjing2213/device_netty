package com.dearho.business.menu.controller;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dearho.core.Page;
import com.dearho.core.validate.GroupAdd;
import com.dearho.core.validate.GroupUpdate;
import com.dearho.result.JSONResult;
import  com.dearho.business.menu.model.Group;
import com.dearho.business.menu.model.Menu;
import  com.dearho.business.menu.service.GroupService;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;



@RestController
@RequestMapping("${admin.url.prefix}/sys/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    
    @RequestMapping(value = "/pages")
    public JSONResult searchPages(Group group,Page page) {
        
    	PageInfo<Group> groupPages = groupService.selectByGroup(group, page);
        return JSONResult.AppSuccessJSONResult(groupPages);
    }
    
    
    @RequestMapping(value = "/list")
    public JSONResult searchList() {
    	Example example = new Example(Group.class);
    	List<Group> groupList = groupService.selectByExample(example);
        return JSONResult.AppSuccessJSONResult(groupList);
    }
    

    @RequestMapping(value = "/view")
    public JSONResult findOne(String id) {
    	if(StringUtils.isEmpty(id)){
    		return JSONResult.AppValidateJSONResult("id不能为空");
    	}
    	Group group=groupService.selectByKey(id);
    	if(group!=null){
    		return JSONResult.AppSuccessJSONResult(group);
    	}else{
    		return JSONResult.AppFailJSONResult("无效ID");
    	}
    }
    
    
    @RequestMapping(value = "/add")
    public JSONResult createGroup( @Validated(GroupAdd.class) Group group, BindingResult errors) {
    	if(errors.hasErrors()){
    		 return JSONResult.AppValidateJSONResult(errors);
    	}
    	group.setGroupCreateTime(new Date());
    	group.setTs(new Date());
    	int result=groupService.save(group);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("保存成功");
    	}else{
    		return JSONResult.AppFailJSONResult("保存失败");
    	}
    	
    }

    @RequestMapping(value = "/update")
    public JSONResult updateGroup( @Validated(GroupUpdate.class) Group group, BindingResult errors) {
    	if(errors.hasErrors()){
   		 return JSONResult.AppValidateJSONResult(errors);
    	}
    	group.setTs(new Date());
    	int result=groupService.updateAll(group);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("修改成功");
    	}else{
    		return JSONResult.AppFailJSONResult("修改失败");
    	}
    }

    @RequestMapping(value = "/delete")
    public JSONResult deleteGroup(String[] ids) {
    	if(ids==null|| ids.length==0){
    		return JSONResult.AppValidateJSONResult("ids不能为空");
    	}
    	List<String> idsList = Arrays.asList(ids);
    	int result=groupService.deleteByExampleId(idsList);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("删除成功");
    	}else{
    		return JSONResult.AppFailJSONResult("删除失败");
    	}
    }

}