
package com.dearho.elasticsearch.service;

import com.dearho.elasticsearch.domain.DriverLocation;

import java.util.List;

/**
 * 城市 ES 业务接口类
 *
 */
public interface DriverLocationService {

    /**
     * 新增 ES 城市信息
     *
     * @param DriverLocation
     * @return
     */
    String saveDriverLocation(DriverLocation DriverLocation);

    /**
     * 搜索词搜索，分页返回城市信息
     *
     * @param pageNumber 当前页码
     * @param pageSize 每页大小
     * @param searchContent 搜索内容
     * @return
     */
    List<DriverLocation> searchDriverLocation(Integer pageNumber, Integer pageSize, String searchContent);
    
    ;

   
}