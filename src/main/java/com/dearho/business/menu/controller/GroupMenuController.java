package com.dearho.business.menu.controller;


import java.util.Arrays;
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
import  com.dearho.business.menu.model.GroupMenu;
import  com.dearho.business.menu.service.GroupMenuService;
import com.github.pagehelper.PageInfo;



@RestController
@RequestMapping("${admin.url.prefix}/sys/groupMenu")
public class GroupMenuController {

    @Autowired
    private GroupMenuService groupMenuService;

    
    @RequestMapping(value = "/list")
    public JSONResult searchList(String groupId) {
        
    	List<GroupMenu> groupMenuList = groupMenuService.selectByGroupId(groupId);
        return JSONResult.AppSuccessJSONResult(groupMenuList);
    }
    


    @RequestMapping(value = "/add")
    public JSONResult addGroupMenu(String groupId,String[] menuIds) {
    	if(StringUtils.isEmpty(groupId)){
    		return JSONResult.AppValidateJSONResult("groupId不能为空");
    	}
    	
    	if(menuIds==null|| menuIds.length==0){
    		return JSONResult.AppValidateJSONResult("menuIds不能为空");
    	}
    	
    	List<String> idsList = Arrays.asList(menuIds);
    	int result=groupMenuService.addGroupMenu(groupId,idsList);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("删除成功");
    	}else{
    		return JSONResult.AppFailJSONResult("删除失败");
    	}
    }

}