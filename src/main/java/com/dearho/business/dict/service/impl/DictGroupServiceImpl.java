package com.dearho.business.dict.service.impl;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dearho.core.config.service.impl.BaseService;
import com.dearho.core.Page;
import com.dearho.business.dict.mapper.DictGroupMapper;
import  com.dearho.business.dict.model.DictGroup;
import  com.dearho.business.dict.service.DictGroupService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;


@Service("dictGroupService")
public class DictGroupServiceImpl extends BaseService<DictGroup> implements DictGroupService {
	
	@Autowired
	private DictGroupMapper dictGroupMapper;
    @Override
    public PageInfo<DictGroup> selectByDictGroup(DictGroup dictGroup, Page page) {
        Example example = new Example(DictGroup.class);
        Example.Criteria criteria = example.createCriteria();

        if(dictGroup!=null){
        	if (StringUtils.isNotEmpty(dictGroup.getId())) {
                criteria.andEqualTo("id", dictGroup.getId());
            }
        	if (StringUtils.isNotEmpty(dictGroup.getCode())) {
        		criteria.andLike("code", "%"+dictGroup.getCode()+"%");
            }
        	if (StringUtils.isNotEmpty(dictGroup.getRemark())) {
        		criteria.andLike("remark", "%"+dictGroup.getRemark()+"%");
            }
        	if(dictGroup.getIsSystem()!=null){
        		criteria.andEqualTo("isSystem", dictGroup.getIsSystem());
        	}
        	if(dictGroup.getCompanyId()!=null){
        		criteria.andEqualTo("companyId", dictGroup.getCompanyId());
        	}
        	if(StringUtils.isNotEmpty(dictGroup.getCompanySn())){
        		criteria.andLike("companySn", dictGroup.getCompanySn()+"%");
        	}
        }
        
        if(StringUtils.isNotEmpty(page.getPageOrderString())){
        	example.setOrderByClause(page.getPageOrderString());
        }
       
        //分页查询
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        
        List<DictGroup> dictGroupList=selectByExample(example);
        PageInfo<DictGroup> pageInfo=  new PageInfo<DictGroup>(dictGroupList);
       
        return pageInfo;
    }

    @Override
	public List<DictGroup> getDictGroups() {
		Example example = new Example(DictGroup.class);
		return selectByExample(example);
	}
	
	
	public List<DictGroup> searchDictGroups(DictGroup dictGroup) {
		Example example = new Example(DictGroup.class);
		Example.Criteria criteria = example.createCriteria();

	        if(dictGroup!=null){
	        	if (StringUtils.isNotEmpty(dictGroup.getId())) {
	                criteria.andEqualTo("id", dictGroup.getId());
	            }
	        	if (StringUtils.isNotEmpty(dictGroup.getCode())) {
	        		criteria.andLike("code", "%"+dictGroup.getCode()+"%");
	            }
	        	if (StringUtils.isNotEmpty(dictGroup.getRemark())) {
	        		criteria.andLike("remark", "%"+dictGroup.getRemark()+"%");
	            }
	        	if(dictGroup.getIsSystem()!=null){
	        		criteria.andEqualTo("isSystem", dictGroup.getIsSystem());
	        	}
	        	if(dictGroup.getCompanyId()!=null){
	        		criteria.andEqualTo("companyId", dictGroup.getCompanyId());
	        	}
	        	if(StringUtils.isNotEmpty(dictGroup.getCompanySn())){
	        		criteria.andLike("companySn", dictGroup.getCompanySn()+"%");
	        	}
	        }
		return selectByExample(example);
	}

	@Override
	public DictGroup getDictGroup(String code) {
		DictGroup d = dictGroupMapper.getDictGroup(code);
		return d;
	}
}
