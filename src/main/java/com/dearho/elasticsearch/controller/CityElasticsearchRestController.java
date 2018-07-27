package com.dearho.elasticsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dearho.elasticsearch.domain.DriverLocation;
import com.dearho.elasticsearch.service.DriverLocationService;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 * <p>
 * Created by bysocket on 20/06/2017.
 */
@RestController
public class CityElasticsearchRestController {

    @Autowired
    private DriverLocationService driverLocationService;

    /**
     * 插入 ES 新城市
     *
     * @param driverLocation
     * @return
     */
    @RequestMapping(value = "/api/driverLocation", method = RequestMethod.POST)
    public String createCity(@RequestBody DriverLocation driverLocation) {
        return driverLocationService.saveDriverLocation(driverLocation);
    }

    /**
     * 搜索返回分页结果
     *
     * @param pageNumber 当前页码
     * @param pageSize 每页大小
     * @param searchContent 搜索内容
     * @return
     */
    @RequestMapping(value = "/api/driverLocation/search", method = RequestMethod.GET)
    public List<DriverLocation> searchCity(@RequestParam(value = "pageNumber") Integer pageNumber,
                                                @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                                @RequestParam(value = "searchContent") String searchContent) {
        return driverLocationService.searchDriverLocation(pageNumber, pageSize,searchContent);
    }
    
    

   

 
}
