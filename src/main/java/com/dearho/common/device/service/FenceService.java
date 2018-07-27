package com.dearho.common.device.service;


import com.dearho.core.Page;
import com.dearho.core.config.service.IService;
import com.dearho.common.device.model.Fence;
import com.github.pagehelper.PageInfo;


public interface FenceService extends IService<Fence> {

  
    PageInfo<Fence> selectByFence(Fence fence, Page page);

}