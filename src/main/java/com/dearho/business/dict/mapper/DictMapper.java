package com.dearho.business.dict.mapper;

import java.util.List;

import com.dearho.business.dict.model.Dict;

import tk.mybatis.mapper.common.Mapper;

public interface DictMapper extends Mapper<Dict> {
	
	public List<Dict> getDictList(String code);
}