package com.dearho.business.menu.service;


import java.util.List;

import com.dearho.business.menu.model.UserGroup;
import com.dearho.core.config.service.BusinessService;


public interface UserGroupService extends BusinessService<UserGroup> {

  
	public List<UserGroup> selectByUserId(String userId);

}