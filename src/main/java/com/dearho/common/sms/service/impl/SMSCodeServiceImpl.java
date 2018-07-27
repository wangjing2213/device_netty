package com.dearho.common.sms.service.impl;


import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dearho.core.config.service.impl.BaseService;
import com.dearho.core.Page;
import com.dearho.common.sms.mapper.SMSCodeMapper;
import  com.dearho.common.sms.model.SMSCode;
import  com.dearho.common.sms.service.SMSCodeService;
import com.dearho.util.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;


@Service("sMSCodeService")
public class SMSCodeServiceImpl extends BaseService<SMSCode> implements SMSCodeService {

	@Autowired
	private SMSCodeMapper sMSCodeMapper;
	
    @Override
    public PageInfo<SMSCode> selectBySMSCode(SMSCode sMSCode, Page page) {
        Example example = new Example(SMSCode.class);
        Example.Criteria criteria = example.createCriteria();

        if(sMSCode!=null){
        	if (sMSCode.getId() != null) {
                criteria.andEqualTo("id", sMSCode.getId());
            }
        	
        	if(sMSCode.getCompanyId()!=null){
        		criteria.andEqualTo("companyId", sMSCode.getCompanyId());
        	}
        	if(StringUtils.isNotEmpty(sMSCode.getCompanySn())){
        		criteria.andLike("companySn", sMSCode.getCompanySn()+"%");
        	}
        }
        
        if(StringUtils.isNotEmpty(page.getPageOrderString())){
        	example.setOrderByClause(page.getPageOrderString());
        }
       
        //分页查询
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        
        List<SMSCode> sMSCodeList=selectByExample(example);
        PageInfo<SMSCode> pageInfo=  new PageInfo<SMSCode>(sMSCodeList);
       
        return pageInfo;
    }

	@Override
	public SMSCode getLatestSMSCode(SMSCode smsCode, Integer validMinute,
			String sn) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("phoneNo", smsCode.getPhoneNo());
		map.put("channel", smsCode.getChannel());
		map.put("type", smsCode.getType());
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MINUTE, -validMinute);
		map.put("ts", DateUtil.getChar19DateString(calendar.getTime()));
		
		List<SMSCode> list = sMSCodeMapper.getLatestSMSCode(map);
		if(list!=null && !list.isEmpty()){
			return list.get(0);
		}else{
			return null;
		}
	}
}
