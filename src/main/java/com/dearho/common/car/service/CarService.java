package com.dearho.common.car.service;


import com.dearho.core.Page;
import com.dearho.core.config.service.IService;
import com.dearho.common.car.model.Car;
import com.github.pagehelper.PageInfo;


public interface CarService extends IService<Car> {

  
    PageInfo<Car> selectByCar(Car car, Page page);

}