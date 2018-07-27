package com.dearho.common.sys.service;


import com.dearho.core.Page;
import com.dearho.core.config.service.IService;

import java.util.List;

import com.dearho.common.sys.model.Area;
import com.github.pagehelper.PageInfo;


public interface AreaService extends IService<Area> {

  
	 public List<Area> selectByArea(Area area) ;

	 /**   
	 * @Title: getCityList   
	 * @Description: TODO(获取城市列表)	 add by  wangtao   
	 * @param: @return      
	 * @return: List<Area>      
	 * @throws   
	 */
	public List<Area> getCityList();
}