package com.dearho.common.company.mapper;

import java.util.List;

import com.dearho.common.company.model.CompanyConfig;
import com.dearho.common.company.model.CompanyRelation;

import tk.mybatis.mapper.common.Mapper;

public interface CompanyRelationMapper extends Mapper<CompanyRelation> {
	List<CompanyRelation> getRoot();

	List<CompanyRelation> searchChildCompanyBypid(Integer id);
	CompanyRelation getCompanyRelationByCode(String companyCode);
	
	/**   
	 * @Title: getTaxiCompanyList   
	 * @Description: TODO(获取出租车公司)	add by wangtao   
	 * @param: @return      
	 * @return: List<CompanyRelation>      
	 * @throws   
	 */
	List<CompanyRelation> getTaxiCompanyList();
	
}