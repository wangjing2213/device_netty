package com.dearho.common.sys.mapper;

import java.util.List;

import com.dearho.common.sys.model.Area;

import tk.mybatis.mapper.common.Mapper;

public interface AreaMapper extends Mapper<Area> {
	
	public List<Area> getCityList();
}