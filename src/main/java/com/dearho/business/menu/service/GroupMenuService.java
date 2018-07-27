package com.dearho.business.menu.service;


import java.util.List;

import com.dearho.business.menu.model.GroupMenu;
import com.dearho.core.config.service.BusinessService;


public interface GroupMenuService extends BusinessService<GroupMenu> {

  
	 public List<GroupMenu> selectByGroupId(String groupId);

	public int addGroupMenu(String groupId, List<String> menuIds);

}