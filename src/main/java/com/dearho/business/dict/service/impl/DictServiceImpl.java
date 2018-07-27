package com.dearho.business.dict.service.impl;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dearho.core.config.service.impl.BaseService;
import com.dearho.core.Page;
import com.dearho.business.dict.mapper.DictMapper;
import  com.dearho.business.dict.model.Dict;
import com.dearho.business.dict.model.DictGroup;
import com.dearho.business.dict.service.DictGroupService;
import  com.dearho.business.dict.service.DictService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;


@Service("dictService")
public class DictServiceImpl extends BaseService<Dict> implements DictService {

	@Autowired
	private DictMapper dictMapper;
	
	@Autowired
	private DictGroupService dictGroupService;
	
    @Override
    public PageInfo<Dict> selectByDict(Dict dict, Page page) {
        Example example = new Example(Dict.class);
        Example.Criteria criteria = example.createCriteria();

        if(dict!=null){
        	if (dict.getId() != null) {
                criteria.andEqualTo("id", dict.getId());
            }
        	if(StringUtils.isNotEmpty(dict.getCnName())){
        		criteria.andLike("cnName", "%"+dict.getCnName()+"%");
        	}
        	if(StringUtils.isNotEmpty(dict.getCode())){
        		criteria.andLike("code", "%"+dict.getCode()+"%");
        	}
        	if(StringUtils.isNotEmpty(dict.getGroupId())){
        		criteria.andEqualTo("groupId", dict.getGroupId());
        	}
        	if(dict.getIsSystem()!=null) {
        		criteria.andEqualTo("isSystem", dict.getIsSystem());
        	}
        	if(dict.getIsUsed()!=null) {
        		criteria.andEqualTo("isUsed", dict.getIsUsed());
        	}
        	
        	if(dict.getCompanyId()!=null){
        		criteria.andEqualTo("companyId", dict.getCompanyId());
        	}
        	if(StringUtils.isNotEmpty(dict.getCompanySn())){
        		criteria.andLike("companySn", dict.getCompanySn()+"%");
        	}
        }
        
        if(StringUtils.isNotEmpty(page.getPageOrderString())){
        	example.setOrderByClause(page.getPageOrderString());
        }
       
        //分页查询
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        
        List<Dict> dictList=selectByExample(example);
        PageInfo<Dict> pageInfo=  new PageInfo<Dict>(dictList);
       
        return pageInfo;
    }

	

	@Override
	public List<Dict> getDicts() {
		Example example = new Example(DictGroup.class);
		return selectByExample(example);
	}



	@Override
	public List<Dict> getDictList(String code) {
		DictGroup dg = dictGroupService.getDictGroup(code);
		List<Dict> list = null;
		if(dg!= null){
			list = dictMapper.getDictList(dg.getId());
		}
		return list;
	}
	
}
