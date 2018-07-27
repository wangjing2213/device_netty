package com.dearho.business.dict.mapper;

import com.dearho.business.dict.model.DictGroup;
import tk.mybatis.mapper.common.Mapper;

public interface DictGroupMapper extends Mapper<DictGroup> {
	DictGroup getDictGroup(String code);
}