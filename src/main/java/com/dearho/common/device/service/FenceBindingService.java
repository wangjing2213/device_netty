package com.dearho.common.device.service;


import com.dearho.core.Page;
import com.dearho.core.config.service.IService;
import com.dearho.common.device.model.FenceBinding;
import com.github.pagehelper.PageInfo;


public interface FenceBindingService extends IService<FenceBinding> {

  
    PageInfo<FenceBinding> selectByFenceBinding(FenceBinding fenceBinding, Page page);

}