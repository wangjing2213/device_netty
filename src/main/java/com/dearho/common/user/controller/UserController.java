package com.dearho.common.user.controller;


import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dearho.core.AbstractController;
import com.dearho.core.Page;
import com.dearho.core.validate.GroupAdd;
import com.dearho.core.validate.GroupUpdate;
import com.dearho.redis.RedisUtils;
import com.dearho.result.JSONResult;
import com.dearho.util.property.ConfigProperties;
import  com.dearho.common.user.model.User;
import  com.dearho.common.user.service.UserService;
import com.github.pagehelper.PageInfo;



@RestController
@RequestMapping("${admin.url.prefix}/sys/user")
public class UserController extends AbstractController{
	static Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    
    @Autowired
    private ConfigProperties configProperties;
    
    @Autowired
    private RedisUtils redisUtils;
    
    @RequestMapping(value = "/pages")
    public JSONResult searchPages(User user,Page page,HttpServletRequest request) {
        
    	PageInfo<User> userPages = userService.selectByUser(user, page);
        return JSONResult.AppSuccessJSONResult(userPages);
    }
    

    @RequestMapping(value = "/view")
    public JSONResult findOne(String id,HttpServletRequest request) {
    	if(StringUtils.isEmpty(id)){
    		return JSONResult.AppValidateJSONResult("id不能为空");
    	}
    	User user=userService.selectByKey(id);
    	if(user!=null){
    		return JSONResult.AppSuccessJSONResult(user);
    	}else{
    		return JSONResult.AppFailJSONResult("无效ID");
    	}
    }
    
    
    @RequestMapping(value = "/add")
    public JSONResult createUser( @Validated(GroupAdd.class) User user, BindingResult errors,HttpServletRequest request) {
    	if(errors.hasErrors()){
    		 return JSONResult.AppValidateJSONResult(errors);
    	}
    	int result=userService.save(user);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("保存成功");
    	}else{
    		return JSONResult.AppFailJSONResult("保存失败");
    	}
    	
    }

    @RequestMapping(value = "/update")
    public JSONResult updateUser( @Validated(GroupUpdate.class) User user, BindingResult errors,HttpServletRequest request) {
    	if(errors.hasErrors()){
   		 return JSONResult.AppValidateJSONResult(errors);
    	}
    	int result=userService.updateAll(user);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("修改成功");
    	}else{
    		return JSONResult.AppFailJSONResult("修改失败");
    	}
    }

    @RequestMapping(value = "/delete")
    public JSONResult deleteUser(String[] ids,HttpServletRequest request) {
    	if(ids==null|| ids.length==0){
    		return JSONResult.AppValidateJSONResult("ids不能为空");
    	}
    	List<String> idsList = Arrays.asList(ids);
    	int result=userService.deleteByExampleId(idsList);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("删除成功");
    	}else{
    		return JSONResult.AppFailJSONResult("删除失败");
    	}
    }

}