package com.dearho.common.company.service.impl;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dearho.core.config.service.impl.BaseService;
import com.dearho.core.Page;
import com.dearho.common.company.mapper.CompanyConfigMapper;
import  com.dearho.common.company.model.CompanyConfig;
import  com.dearho.common.company.service.CompanyConfigService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;


@Service("companyConfigService")
public class CompanyConfigServiceImpl extends BaseService<CompanyConfig> implements CompanyConfigService {

	@Autowired
	private CompanyConfigMapper companyConfigMapper;
	
    @Override
    public PageInfo<CompanyConfig> selectByCompanyConfig(CompanyConfig companyConfig, Page page) {
        Example example = new Example(CompanyConfig.class);
        Example.Criteria criteria = example.createCriteria();

        if(companyConfig!=null){
        	if (companyConfig.getId() != null) {
                criteria.andEqualTo("id", companyConfig.getId());
            }
        	
        	if(companyConfig.getCompanyId()!=null){
        		criteria.andEqualTo("companyId", companyConfig.getCompanyId());
        	}
        	if(StringUtils.isNotEmpty(companyConfig.getCompanySn())){
        		criteria.andLike("companySn", companyConfig.getCompanySn()+"%");
        	}
        }
        
        if(StringUtils.isNotEmpty(page.getPageOrderString())){
        	example.setOrderByClause(page.getPageOrderString());
        }
       
        //分页查询
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        
        List<CompanyConfig> companyConfigList=selectByExample(example);
        PageInfo<CompanyConfig> pageInfo=  new PageInfo<CompanyConfig>(companyConfigList);
       
        return pageInfo;
    }

	@Override
	public CompanyConfig getCompanyConfigByid(String id) {
		CompanyConfig cc = companyConfigMapper.getCompanyConfigByid(id);
		return cc;
	}
}
