package com.dearho.common.sms.service.impl;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.dearho.core.config.service.impl.BaseService;
import com.dearho.core.Page;
import  com.dearho.common.sms.model.SMSRecord;
import  com.dearho.common.sms.service.SMSRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;


@Service("sMSRecordService")
public class SMSRecordServiceImpl extends BaseService<SMSRecord> implements SMSRecordService {

    @Override
    public PageInfo<SMSRecord> selectBySMSRecord(SMSRecord sMSRecord, Page page) {
        Example example = new Example(SMSRecord.class);
        Example.Criteria criteria = example.createCriteria();

        if(sMSRecord!=null){
        	if (sMSRecord.getId() != null) {
                criteria.andEqualTo("id", sMSRecord.getId());
            }
        	if (StringUtils.isNotEmpty(sMSRecord.getContent())) {
                criteria.andLike("content", "%"+sMSRecord.getContent()+"%");
            }
        	if (StringUtils.isNotEmpty(sMSRecord.getPhoneNo())) {
                criteria.andLike("phoneNo", "%"+sMSRecord.getPhoneNo()+"%");
            }
        	if (StringUtils.isNotEmpty(sMSRecord.getUserName())) {
                criteria.andLike("userName", "%"+sMSRecord.getUserName()+"%");
            }
        	
        	if(sMSRecord.getCompanyId()!=null){
        		criteria.andEqualTo("companyId", sMSRecord.getCompanyId());
        	}
        	if(StringUtils.isNotEmpty(sMSRecord.getCompanySn())){
        		criteria.andLike("companySn", sMSRecord.getCompanySn()+"%");
        	}
        }
        
        if(StringUtils.isNotEmpty(page.getPageOrderString())){
        	example.setOrderByClause(page.getPageOrderString());
        }
       
        //分页查询
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        
        List<SMSRecord> sMSRecordList=selectByExample(example);
        PageInfo<SMSRecord> pageInfo=  new PageInfo<SMSRecord>(sMSRecordList);
       
        return pageInfo;
    }
}
