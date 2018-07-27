package com.dearho.business.dict.service;


import java.util.List;

import com.dearho.business.dict.model.DictGroup;
import com.dearho.core.Page;
import com.dearho.core.config.service.BusinessService;
import com.github.pagehelper.PageInfo;


public interface DictGroupService extends BusinessService<DictGroup> {

  
    PageInfo<DictGroup> selectByDictGroup(DictGroup dictGroup, Page page);

	List<DictGroup> getDictGroups();
	
	List<DictGroup> searchDictGroups(DictGroup dictGroup);

	DictGroup getDictGroup(String code);
	
}