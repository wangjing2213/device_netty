package com.dearho.business.dict.service;


import java.util.List;

import com.dearho.business.dict.model.Dict;
import com.dearho.core.Page;
import com.dearho.core.config.service.BusinessService;
import com.github.pagehelper.PageInfo;


public interface DictService extends BusinessService<Dict> {

  
    PageInfo<Dict> selectByDict(Dict dict, Page page);


    List<Dict> getDicts();
    
    List<Dict> getDictList(String code);
}