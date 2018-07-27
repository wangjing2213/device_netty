package com.dearho.common.company.mapper;

import com.dearho.common.company.model.CompanyConfig;
import tk.mybatis.mapper.common.Mapper;

public interface CompanyConfigMapper extends Mapper<CompanyConfig> {
	
	CompanyConfig getCompanyConfigByid(String id);
	
}