package ${config.servicePackage};


import com.dearho.core.Page;
import ${config.serviceBaseInterfancePackage};
import ${config.modelPackage}.${config.domainObjectName};
import com.github.pagehelper.PageInfo;


public interface ${config.domainObjectName}Service extends ${config.serviceBaseInterfance}<${config.domainObjectName}> {

  
    PageInfo<${config.domainObjectName}> selectBy${config.domainObjectName}(${config.domainObjectName} ${config.domainObjectNameToLowerCase}, Page page);

}