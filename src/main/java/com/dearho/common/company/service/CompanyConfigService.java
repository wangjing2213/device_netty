package com.dearho.common.company.service;


import com.dearho.core.Page;
import com.dearho.core.config.service.IService;
import com.dearho.common.company.model.CompanyConfig;
import com.github.pagehelper.PageInfo;


public interface CompanyConfigService extends IService<CompanyConfig> {

  
    PageInfo<CompanyConfig> selectByCompanyConfig(CompanyConfig companyConfig, Page page);

    
    public CompanyConfig getCompanyConfigByid(String id);
}