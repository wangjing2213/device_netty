package com.dearho.common.sys.service.impl;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dearho.core.config.service.impl.BaseService;
import com.dearho.core.Page;
import com.dearho.common.sys.mapper.AreaMapper;
import  com.dearho.common.sys.model.Area;
import  com.dearho.common.sys.service.AreaService;
import com.dearho.common.user.model.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;


@Service("areaService")
public class AreaServiceImpl extends BaseService<Area> implements AreaService {

	@Autowired
	private AreaMapper areaMapper;
	
    public List<Area> selectByArea(Area area) {
    	
    	
        Example example = new Example(Area.class);
        Example.Criteria criteria = example.createCriteria();

        if(area!=null){
        	if (StringUtils.isNotEmpty(area.getCode())) {
                criteria.andEqualTo("code", area.getCode());
            }
        	if(StringUtils.isNotEmpty(area.getParentCode())){
        		criteria.andEqualTo("parentCode",area.getParentCode());
        	}
        }
        
        List<Area> areaList=selectByExample(example);
        return areaList;
    }

	@Override
	public List<Area> getCityList() {
		// TODO Auto-generated method stub
		List<Area> list = areaMapper.getCityList();
		return list;
	}
}
