package ${config.servicePackage}.impl;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.dearho.core.config.service.impl.BaseService;
import com.dearho.core.Page;
import  ${config.modelPackage}.${config.domainObjectName};
import  ${config.servicePackage}.${config.domainObjectName}Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;


@Service("${config.domainObjectNameToLowerCase}Service")
public class ${config.domainObjectName}ServiceImpl extends BaseService<${config.domainObjectName}> implements ${config.domainObjectName}Service {

    @Override
    public PageInfo<${config.domainObjectName}> selectBy${config.domainObjectName}(${config.domainObjectName} ${config.domainObjectNameToLowerCase}, Page page) {
        Example example = new Example(${config.domainObjectName}.class);
        Example.Criteria criteria = example.createCriteria();

        if(${config.domainObjectNameToLowerCase}!=null){
        	if (${config.domainObjectNameToLowerCase}.getId() != null) {
                criteria.andEqualTo("id", ${config.domainObjectNameToLowerCase}.getId());
            }
        	
        	if(${config.domainObjectNameToLowerCase}.getCompanyId()!=null){
        		criteria.andEqualTo("companyId", ${config.domainObjectNameToLowerCase}.getCompanyId());
        	}
        	if(StringUtils.isNotEmpty(${config.domainObjectNameToLowerCase}.getCompanySn())){
        		criteria.andLike("companySn", ${config.domainObjectNameToLowerCase}.getCompanySn()+"%");
        	}
        }
        
        if(StringUtils.isNotEmpty(page.getPageOrderString())){
        	example.setOrderByClause(page.getPageOrderString());
        }
       
        //分页查询
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        
        List<${config.domainObjectName}> ${config.domainObjectNameToLowerCase}List=selectByExample(example);
        PageInfo<${config.domainObjectName}> pageInfo=  new PageInfo<${config.domainObjectName}>(${config.domainObjectNameToLowerCase}List);
       
        return pageInfo;
    }
}
