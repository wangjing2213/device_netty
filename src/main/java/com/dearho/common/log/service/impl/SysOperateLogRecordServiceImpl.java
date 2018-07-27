package com.dearho.common.log.service.impl;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.dearho.core.config.service.impl.BaseService;
import com.dearho.core.Page;
import  com.dearho.common.log.model.SysOperateLogRecord;
import  com.dearho.common.log.service.SysOperateLogRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;


@Service("sysOperateLogRecordService")
public class SysOperateLogRecordServiceImpl extends BaseService<SysOperateLogRecord> implements SysOperateLogRecordService {

    @Override
    public PageInfo<SysOperateLogRecord> selectBySysOperateLogRecord(SysOperateLogRecord sysOperateLogRecord, Page page) {
        Example example = new Example(SysOperateLogRecord.class);
        Example.Criteria criteria = example.createCriteria();

        if(sysOperateLogRecord!=null){
        	if (sysOperateLogRecord.getId() != null) {
                criteria.andEqualTo("id", sysOperateLogRecord.getId());
            }
        	if (StringUtils.isNotEmpty(sysOperateLogRecord.getKeyword())) {
                criteria.andLike("keyword", "%"+sysOperateLogRecord.getKeyword()+"%");
            }
        	if (StringUtils.isNotEmpty(sysOperateLogRecord.getOperatorName())) {
                criteria.andLike("operatorName", "%"+sysOperateLogRecord.getOperatorName()+"%");
            }
        	if (StringUtils.isNotEmpty(sysOperateLogRecord.getModelName())) {
                criteria.andLike("modelName", "%"+sysOperateLogRecord.getModelName()+"%");
            }
        	if (StringUtils.isNotEmpty(sysOperateLogRecord.getRecordId())) {
                criteria.andLike("recordId", "%"+sysOperateLogRecord.getRecordId()+"%");
            }
        	if(sysOperateLogRecord.getCompanyId()!=null){
        		criteria.andEqualTo("companyId", sysOperateLogRecord.getCompanyId());
        	}
        	if(StringUtils.isNotEmpty(sysOperateLogRecord.getCompanySn())){
        		criteria.andLike("companySn", sysOperateLogRecord.getCompanySn()+"%");
        	}
        }
        
        if(StringUtils.isNotEmpty(page.getPageOrderString())){
        	example.setOrderByClause(page.getPageOrderString());
        }
       
        //分页查询
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        
        List<SysOperateLogRecord> sysOperateLogRecordList=selectByExample(example);
        PageInfo<SysOperateLogRecord> pageInfo=  new PageInfo<SysOperateLogRecord>(sysOperateLogRecordList);
       
        return pageInfo;
    }
}
