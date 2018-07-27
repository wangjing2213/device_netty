package com.dearho.core.config.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * 通用接口
 */
@Service
public interface BusinessService<T> {

    T selectByKey(Object key);

    int save(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);
    
    int deleteByExampleId(List<String> idsList);
    
     int deleteByIntegerExampleId(List<Integer> idsList) ;

    Map<String,T> selectAllToMap();
    //TODO 其他...
}
