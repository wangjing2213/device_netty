package com.dearho.common.company.service;


import com.dearho.core.Page;
import com.dearho.core.config.service.IService;

import java.util.List;

import com.dearho.common.company.model.CompanyConfig;
import com.dearho.common.company.model.CompanyRelation;
import com.dearho.common.company.vo.CompanyRelationVO;
import com.dearho.common.user.model.User;
import com.github.pagehelper.PageInfo;


public interface CompanyRelationService extends IService<CompanyRelation> {

  
    PageInfo<CompanyRelation> selectByCompanyRelation(CompanyRelation companyRelation, Page page);
    
    public List<CompanyRelationVO> queryCompanyRelationVOList(User user,Boolean isValid);
    
    public List<CompanyRelation> selectCompanyRelationByUser(CompanyRelation companyRelation, User user);
    
    public CompanyRelation queryCompanyRelationByCode(String code); 
    
    public CompanyRelation getCompanyRelationById(Integer id);
    
    public List<CompanyRelation> getTaxiCompanyList();
}