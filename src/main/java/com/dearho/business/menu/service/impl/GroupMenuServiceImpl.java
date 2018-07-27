package com.dearho.business.menu.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import  com.dearho.business.menu.model.GroupMenu;
import  com.dearho.business.menu.service.GroupMenuService;
import com.dearho.common.user.model.User;
import com.dearho.core.config.service.impl.BaseService;

import tk.mybatis.mapper.entity.Example;


@Service("groupMenuService")
public class GroupMenuServiceImpl extends BaseService<GroupMenu> implements GroupMenuService {

    public List<GroupMenu> selectByGroupId(String groupId) {
    	
    	
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();

        	
        criteria.andEqualTo("groupId", groupId);
        
        
        List<GroupMenu> userList=selectByExample(example);
        return userList;
    }

	@Override
	public int addGroupMenu(String groupId, List<String> menuIds) {
		//删除旧的
		List<GroupMenu> list=selectByGroupId(groupId);
		List<String> deleteIds=new ArrayList<String>();
		if(list!=null && !list.isEmpty()) {
			for(GroupMenu groupMenu:list) {
				deleteIds.add(groupMenu.getId());
			}
		}
		deleteByExampleId(deleteIds);
		//添加新的
		
		for(int i=0;i<menuIds.size();i++) {
			GroupMenu groupMenu=new GroupMenu();
			groupMenu.setMenuId(menuIds.get(i));
			groupMenu.setGroupId(groupId);
			groupMenu.setTs(new Date());
			save(groupMenu);
		}
		
		return 0;
	}
    
}
