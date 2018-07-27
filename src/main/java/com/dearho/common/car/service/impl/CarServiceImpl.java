package com.dearho.common.car.service.impl;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.dearho.core.config.service.impl.BaseService;
import com.dearho.core.Page;
import  com.dearho.common.car.model.Car;
import  com.dearho.common.car.service.CarService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;


@Service("carService")
public class CarServiceImpl extends BaseService<Car> implements CarService {

    @Override
    public PageInfo<Car> selectByCar(Car car, Page page) {
        Example example = new Example(Car.class);
        Example.Criteria criteria = example.createCriteria();

        if(car!=null){
        	if (car.getId() != null) {
                criteria.andEqualTo("id", car.getId());
            }
        	
        	if(car.getCompanyId()!=null){
        		criteria.andEqualTo("companyId", car.getCompanyId());
        	}
        	if(StringUtils.isNotEmpty(car.getCompanySn())){
        		criteria.andLike("companySn", car.getCompanySn()+"%");
        	}
        }
        
        if(StringUtils.isNotEmpty(page.getPageOrderString())){
        	example.setOrderByClause(page.getPageOrderString());
        }
       
        //分页查询
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        
        List<Car> carList=selectByExample(example);
        PageInfo<Car> pageInfo=  new PageInfo<Car>(carList);
       
        return pageInfo;
    }
}
