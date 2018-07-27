package com.dearho.common.company.service.impl;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dearho.common.company.mapper.CompanyRelationMapper;
import com.dearho.common.company.model.CompanyRelation;
import com.dearho.common.company.service.CompanyConfigService;
import com.dearho.common.company.service.CompanyRelationService;
import com.dearho.common.company.vo.CompanyRelationVO;
import com.dearho.common.user.model.User;
import com.dearho.core.config.service.impl.BaseService;
import com.dearho.core.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;


@Service("companyRelationService")
public class CompanyRelationServiceImpl extends BaseService<CompanyRelation> implements CompanyRelationService {
	
	@Autowired
	CompanyRelationMapper companyRelationMapper;
	
	@Autowired
	private CompanyConfigService companyConfigService;
	
    @Override
    public PageInfo<CompanyRelation> selectByCompanyRelation(CompanyRelation companyRelation, Page page) {
        Example example = new Example(CompanyRelation.class);
        Example.Criteria criteria = example.createCriteria();

        if(companyRelation!=null){
        	if (companyRelation.getId() != null) {
                criteria.andEqualTo("id", companyRelation.getId());
            }
        	if (StringUtils.isNotEmpty(companyRelation.getCompanyName())) {
                criteria.andLike("companyName", "%"+companyRelation.getCompanyName()+"%");
            }
        	if (StringUtils.isNotEmpty(companyRelation.getCompanyCode())) {
                criteria.andLike("companyCode", "%"+companyRelation.getCompanyCode()+"%");
            }
        	
        	if (StringUtils.isNotEmpty(companyRelation.getProvince())) {
                criteria.andEqualTo("province", companyRelation.getProvince());
            }
        	if (StringUtils.isNotEmpty(companyRelation.getStatus())) {
                criteria.andEqualTo("status", companyRelation.getStatus());
            }
        	if (companyRelation.getParentId()!=null) {
                criteria.andEqualTo("parentId", companyRelation.getParentId());
            }
        	if (StringUtils.isNotEmpty(companyRelation.getCity())) {
                criteria.andEqualTo("city", companyRelation.getCity());
            }
        	if (StringUtils.isNotEmpty(companyRelation.getTelephone())) {
                criteria.andLike("telephone", "%"+companyRelation.getTelephone()+"%");
            }
        	
        	
        	if(StringUtils.isNotEmpty(companyRelation.getSn())){
        		criteria.andLike("sn", companyRelation.getSn()+"%");
        	}
        }
        
        if(StringUtils.isNotEmpty(page.getPageOrderString())){
        	example.setOrderByClause(page.getPageOrderString());
        }
       
        //分页查询
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        
        List<CompanyRelation> companyRelationList=selectByExample(example);
        PageInfo<CompanyRelation> pageInfo=  new PageInfo<CompanyRelation>(companyRelationList);
       
        return pageInfo;
    }
    
    
    public List<CompanyRelation> selectCompanyRelationByUser(CompanyRelation companyRelation, User user) {
        Example example = new Example(CompanyRelation.class);
        Example.Criteria criteria = example.createCriteria();

        if(companyRelation!=null){
        	if (companyRelation.getId() != null) {
                criteria.andEqualTo("id", companyRelation.getId());
            }
        	
        	
        	if(StringUtils.isNotEmpty(companyRelation.getSn())){
        		criteria.andLike("sn", companyRelation.getSn()+"%");
        	}
        }
        
      
//        example.setOrderByClause("");
        
        List<CompanyRelation> companyRelationList=selectByExample(example);
        return companyRelationList;
    }
    
    
    public List<CompanyRelationVO> queryCompanyRelationVOList(User user,Boolean isValid) {
		List<CompanyRelationVO> voList=new ArrayList<CompanyRelationVO>();

		CompanyRelationVO rootvo=new CompanyRelationVO(getRoot(),null);
		voList.add(rootvo);
		tree(rootvo, user.getCompanySn(),voList);
		
		 Iterator<CompanyRelationVO> it = voList.iterator();  
	     while(it.hasNext()){  
	    	 CompanyRelationVO companyRelationVO = it.next();  
	            if(!companyRelationVO.getSn().contains(user.getCompanySn())){  
	                it.remove();  
	            }
	            if(isValid!=null && isValid){
	            	if(StringUtils.isEmpty(companyRelationVO.getStatus()) || !"1".equals(companyRelationVO.getStatus()) ){
	            		it.remove();  
	            	}
	            }
	      }  
		return voList;
	}

  
   private void tree(CompanyRelationVO parent,String sn,List<CompanyRelationVO> voList){
	   List<CompanyRelation> list=companyRelationMapper.searchChildCompanyBypid(parent.getId());
	   if(list!=null && list.size()>0){
		  for(CompanyRelation cr:list){
			  CompanyRelationVO vo= new CompanyRelationVO(cr,parent.getPrefix());
			  if(cr.getSn().contains(sn)){
				  voList.add(vo);
			  }
			  tree(vo, sn,voList);
		  } 
	   }
   }
   
   
   public CompanyRelation getRoot() {
		List<CompanyRelation> list=companyRelationMapper.getRoot();
		if(list==null|| list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
	}


	@Override
	public CompanyRelation queryCompanyRelationByCode(String code) {
		CompanyRelation c = companyRelationMapper.getCompanyRelationByCode(code);
		return c;
	}


	@Override
	public CompanyRelation getCompanyRelationById(Integer id) {
		CompanyRelation companyRelation= selectByKey(id);
		if(!StringUtils.isEmpty(companyRelation.getCompanyConfigId())){
			companyRelation.setCompanyConfig(companyConfigService.selectByKey(companyRelation.getCompanyConfigId()));
		}
		
		return companyRelation;
	}


	@Override
	public List<CompanyRelation> getTaxiCompanyList() {
		List<CompanyRelation> list = companyRelationMapper.getTaxiCompanyList();
		return list;
	}
	
}
