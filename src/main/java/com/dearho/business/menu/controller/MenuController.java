package com.dearho.business.menu.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.AbstractHandlerMethodMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

import  com.dearho.business.menu.model.Menu;
import  com.dearho.business.menu.service.MenuService;
import com.dearho.core.Constants;
import com.dearho.core.Page;
import com.dearho.core.URLModel;
import com.dearho.core.validate.GroupAdd;
import com.dearho.core.validate.GroupUpdate;
import com.dearho.result.JSONResult;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;



@RestController
@RequestMapping("${admin.url.prefix}/sys/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    
    @RequestMapping(value = "/pages")
    public JSONResult searchPages(Menu menu,Page page) {
        
    	PageInfo<Menu> menuPages = menuService.selectByMenu(menu, page);
        return JSONResult.AppSuccessJSONResult(menuPages);
    }
    
    
    @RequestMapping(value = "/list")
    public JSONResult searchList(Menu menu) {
    	Example example = new Example(Menu.class);
     
    	List<Menu> menuList = menuService.selectByExample(example);
        return JSONResult.AppSuccessJSONResult(menuList);
    }

    @RequestMapping(value = "/view")
    public JSONResult findOne(Integer id) {
    	if(id==null){
    		return JSONResult.AppValidateJSONResult("id不能为空");
    	}
    	Menu menu=menuService.selectByKey(id);
    	if(menu!=null){
    		return JSONResult.AppSuccessJSONResult(menu);
    	}else{
    		return JSONResult.AppFailJSONResult("无效ID");
    	}
    }
    
    
    @RequestMapping(value = "/add")
    public JSONResult createMenu( @Validated(GroupAdd.class) Menu menu, BindingResult errors) {
    	if(errors.hasErrors()){
    		 return JSONResult.AppValidateJSONResult(errors);
    	}
    	int result=menuService.save(menu);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("保存成功");
    	}else{
    		return JSONResult.AppFailJSONResult("保存失败");
    	}
    	
    }

    @RequestMapping(value = "/update")
    public JSONResult updateMenu( @Validated(GroupUpdate.class) Menu menu, BindingResult errors) {
    	if(errors.hasErrors()){
   		 return JSONResult.AppValidateJSONResult(errors);
    	}
    	int result=menuService.updateAll(menu);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("修改成功");
    	}else{
    		return JSONResult.AppFailJSONResult("修改失败");
    	}
    }

    @RequestMapping(value = "/delete")
    public JSONResult deleteMenu(Integer[] ids) {
    	if(ids==null|| ids.length==0){
    		return JSONResult.AppValidateJSONResult("ids不能为空");
    	}
    	List<Integer> idsList = Arrays.asList(ids);
    	
    	int result=menuService.deleteByIntegerExampleId(idsList);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("删除成功");
    	}else{
    		return JSONResult.AppFailJSONResult("删除失败");
    	}
    }

    
    
    @Autowired  
    ApplicationContext applicationContext;
    
    @RequestMapping(value = "/init")
    public JSONResult getAllRequestMappingInfo() {  
        AbstractHandlerMethodMapping<RequestMappingInfo> objHandlerMethodMapping = (AbstractHandlerMethodMapping<RequestMappingInfo>)applicationContext.getBean("requestMappingHandlerMapping");  
        Map<RequestMappingInfo, HandlerMethod> mapRet = objHandlerMethodMapping.getHandlerMethods();
        
        //删除旧菜单
        List<String> menuIdList=new ArrayList<String>();
        List<Menu> menuList=  menuService.selectByMenu(null);
        for(Menu menu:menuList){
        	menuIdList.add(menu.getId().toString());
        }
        if(!menuIdList.isEmpty()){
        	menuService.deleteByExampleId(menuIdList);
        }
        
        Menu root=new Menu();
      
        root.setMenuName("根");
        root.setMenuPid(-1);
        root.setMenuType("M");
        root.setTs(new Date());
        menuService.save(root);
        
        //初始化主菜单
        int index=1;
        Map<String,Integer> menuMap=new HashMap<String,Integer>();
        for(String menuName:Constants.mainMenu){
        	Menu menu=new Menu();
        	menu.setMenuName(menuName);
        	menu.setMenuOrder(index++);
        	menu.setMenuPid(root.getId());
        	menu.setMenuType("M");
        	menu.setTs(new Date());
        	menuService.save(menu);
        	
        	menuMap.put(menuName, menu.getId());
        }
        
        
        	//其他的
        List<String> urlList = new ArrayList<String>();
        for (RequestMappingInfo info : mapRet.keySet()){
            //获取url的Set集合，一个方法可能对应多个url
//        	Set<String> patterns = info.getPatternsCondition().getPatterns();
//            for (String url : patterns){
//                urlList.add(url);
//            }
        	
        	//不管有几个只取第一个
        	String  currentUrl=null;
        	Set<String> patterns = info.getPatternsCondition().getPatterns();
	        for (String url : patterns){
	        	currentUrl=url;
	        	break;
	         }
            
            
            HandlerMethod handlerMethod = mapRet.get(info);
            URLModel  permission = handlerMethod.getMethod().getAnnotation(URLModel.class);
            if (permission != null ){
                System.out.println(permission.toString());
                Menu searchMenu=new Menu();
                searchMenu.setMenuUrl(currentUrl);
//                List<Menu> list=menuService.selectByMenu(searchMenu);
                
                	Menu menu=new Menu();
                	menu.setMenuName(permission.name());
                	menu.setMenuPid(menuMap.get(permission.parent()));
                	menu.setMenuType("F");
                	menu.setMenuUrl(currentUrl);
                	menu.setTs(new Date());
                	menuService.save(menu);
            }
            
        }
        return JSONResult.AppSuccessJSONResult("初始化成功");
    }  
}