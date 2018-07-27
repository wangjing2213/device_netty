package com.dearho.business.dict.controller;


import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import  com.dearho.business.dict.model.Dict;
import com.dearho.business.dict.model.DictGroup;
import com.dearho.business.dict.service.DictGroupService;
import  com.dearho.business.dict.service.DictService;
import com.dearho.common.user.model.User;
import com.dearho.core.AbstractController;
import com.dearho.core.Page;
import com.dearho.core.converter.FuncEnum;
import com.dearho.core.validate.GroupAdd;
import com.dearho.core.validate.GroupUpdate;
import com.dearho.result.JSONResult;
import com.github.pagehelper.PageInfo;



@RestController
@RequestMapping("${admin.url.prefix}/sys/dict")
public class DictController extends AbstractController {

    @Autowired
    private DictService dictService;
    
    @Autowired
    private DictGroupService dictGroupService;

    @RequestMapping(value = "/pathEnum")
    public JSONResult enumT(@RequestParam("pathEnum") FuncEnum pathEnum) {
    	
    	System.out.println(pathEnum);
        return JSONResult.AppSuccessJSONResult("ok");
    }
    
    
    @RequestMapping(value = "/system/pages")
    public JSONResult searchSystemages(Dict dict,Page page) {
        if(dict==null) {
        	dict=new Dict();
        }
        dict.setIsSystem(1);
    	PageInfo<Dict> dictPages = dictService.selectByDict(dict, page);
        return JSONResult.AppSuccessJSONResult(dictPages);
    }
    
    
    @RequestMapping(value = "/business/pages")
    public JSONResult searchBusinessPages(Dict dict,Page page) {
        
    	if(dict==null) {
        	dict=new Dict();
        }
        dict.setIsSystem(0);
    	PageInfo<Dict> dictPages = dictService.selectByDict(dict, page);
        return JSONResult.AppSuccessJSONResult(dictPages);
    }
    
    
    
    @RequestMapping(value = "/pages")
    public JSONResult searchPages(Dict dict,Page page) {
        
    	PageInfo<Dict> dictPages = dictService.selectByDict(dict, page);
        return JSONResult.AppSuccessJSONResult(dictPages);
    }
    

    @RequestMapping(value = "/view")
    public JSONResult findOne(String id) {
    	if(StringUtils.isEmpty(id)){
    		return JSONResult.AppValidateJSONResult("id不能为空");
    	}
    	Dict dict=dictService.selectByKey(id);
    	if(dict!=null){
    		return JSONResult.AppSuccessJSONResult(dict);
    	}else{
    		return JSONResult.AppFailJSONResult("无效ID");
    	}
    }
    
    
    @RequestMapping(value = "/add")
    public JSONResult createDict( @Validated(GroupAdd.class) Dict dict, BindingResult errors,HttpServletRequest request) {
    	if(errors.hasErrors()){
    		 return JSONResult.AppValidateJSONResult(errors);
    	}
    	DictGroup dictGroup=dictGroupService.selectByKey(dict.getGroupId());
    	dict.setIsSystem(dictGroup.getIsSystem());
    	if(dictGroup.getIsSystem()!=null && new Integer(1).equals(dictGroup.getIsSystem())) {
    		User user=getAdminUser(request);
    		dict.setCompanyId(user.getCompanyId());
    		dict.setCompanySn(user.getCompanySn());
    	}
    	int result=dictService.save(dict);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("保存成功");
    	}else{
    		return JSONResult.AppFailJSONResult("保存失败");
    	}
    	
    }

    @RequestMapping(value = "/update")
    public JSONResult updateDict( @Validated(GroupUpdate.class) Dict dict, BindingResult errors) {
    	if(errors.hasErrors()){
   		 return JSONResult.AppValidateJSONResult(errors);
    	}
    	int result=dictService.updateAll(dict);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("修改成功");
    	}else{
    		return JSONResult.AppFailJSONResult("修改失败");
    	}
    }

    @RequestMapping(value = "/delete")
    public JSONResult deleteDict(String[] ids) {
    	if(ids==null|| ids.length==0){
    		return JSONResult.AppValidateJSONResult("ids不能为空");
    	}
    	List<String> idsList = Arrays.asList(ids);
    	int result=dictService.deleteByExampleId(idsList);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("删除成功");
    	}else{
    		return JSONResult.AppFailJSONResult("删除失败");
    	}
    }
    
    
    @RequestMapping(value = "/system/list")
    public JSONResult searchSystemDictGroup(String code) {
        if(StringUtils.isEmpty(code)) {
        	return JSONResult.AppFailJSONResult("参数为空");
        }
    	List<Dict> dictList = dictService.getDictList(code);
        return JSONResult.AppSuccessJSONResult(dictList);
    }

}