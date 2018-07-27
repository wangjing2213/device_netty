package com.dearho.common.sys.controller;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dearho.common.sys.model.Area;
import com.dearho.common.sys.service.AreaService;
import com.dearho.core.AbstractController;
import com.dearho.result.JSONResult;



@RestController
@RequestMapping("${admin.url.prefix}/sys/area")
public class AreaController extends AbstractController{

    @Autowired
    private AreaService areaService;

    
    @RequestMapping(value = "/list")
    public JSONResult searchPages(String  parentCode) {
    	Area area=new Area();
        if(StringUtils.isEmpty(parentCode)) {
        	area.setParentCode("0");
        }else {
        	area.setParentCode(parentCode);
        }
    	List<Area> areaPages = areaService.selectByArea(area);
        return JSONResult.AppSuccessJSONResult(areaPages);
    }
    

    @RequestMapping(value = "/alllist")
    public JSONResult searchAllList() {
    	Area area=new Area();
        
    	List<Area> areaPages = areaService.selectByArea(area);
        return JSONResult.AppSuccessJSONResult(areaPages);
    }
    
    @RequestMapping(value = "/cityList")
    public JSONResult searchCityList() {
    	List<Area> areaPages = areaService.getCityList();
        return JSONResult.AppSuccessJSONResult(areaPages);
    }
    
   

}