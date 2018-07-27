package ${config.controllerPackage};


import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dearho.core.AbstractController;
import com.dearho.core.Page;
import com.dearho.core.validate.GroupAdd;
import com.dearho.core.validate.GroupUpdate;
import com.dearho.result.JSONResult;
import  ${config.modelPackage}.${config.domainObjectName};
import  ${config.servicePackage}.${config.domainObjectName}Service;
import com.github.pagehelper.PageInfo;



@RestController
@RequestMapping("${r'${admin.url.prefix}'}/sys/${config.domainObjectNameToLowerCase}")
public class ${config.domainObjectName}Controller extends AbstractController{

    @Autowired
    private ${config.domainObjectName}Service ${config.domainObjectNameToLowerCase}Service;

    
    @RequestMapping(value = "/pages")
    public JSONResult searchPages(${config.domainObjectName} ${config.domainObjectNameToLowerCase},Page page,HttpServletRequest request) {
        
    	PageInfo<${config.domainObjectName}> ${config.domainObjectNameToLowerCase}Pages = ${config.domainObjectNameToLowerCase}Service.selectBy${config.domainObjectName}(${config.domainObjectNameToLowerCase}, page);
        return JSONResult.AppSuccessJSONResult(${config.domainObjectNameToLowerCase}Pages);
    }
    

    @RequestMapping(value = "/view")
    public JSONResult findOne(String id,HttpServletRequest request) {
    	if(StringUtils.isEmpty(id)){
    		return JSONResult.AppValidateJSONResult("id不能为空");
    	}
    	${config.domainObjectName} ${config.domainObjectNameToLowerCase}=${config.domainObjectNameToLowerCase}Service.selectByKey(id);
    	if(${config.domainObjectNameToLowerCase}!=null){
    		return JSONResult.AppSuccessJSONResult(${config.domainObjectNameToLowerCase});
    	}else{
    		return JSONResult.AppFailJSONResult("无效ID");
    	}
    }
    
    
    @RequestMapping(value = "/add")
    public JSONResult create${config.domainObjectName}( @Validated(GroupAdd.class) ${config.domainObjectName} ${config.domainObjectNameToLowerCase}, BindingResult errors,HttpServletRequest request) {
    	if(errors.hasErrors()){
    		 return JSONResult.AppValidateJSONResult(errors);
    	}
    	int result=${config.domainObjectNameToLowerCase}Service.save(${config.domainObjectNameToLowerCase});
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("保存成功");
    	}else{
    		return JSONResult.AppFailJSONResult("保存失败");
    	}
    	
    }

    @RequestMapping(value = "/update")
    public JSONResult update${config.domainObjectName}( @Validated(GroupUpdate.class) ${config.domainObjectName} ${config.domainObjectNameToLowerCase}, BindingResult errors,HttpServletRequest request) {
    	if(errors.hasErrors()){
   		 return JSONResult.AppValidateJSONResult(errors);
    	}
    	int result=${config.domainObjectNameToLowerCase}Service.updateAll(${config.domainObjectNameToLowerCase});
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("修改成功");
    	}else{
    		return JSONResult.AppFailJSONResult("修改失败");
    	}
    }

    @RequestMapping(value = "/delete")
    public JSONResult delete${config.domainObjectName}(String[] ids,HttpServletRequest request) {
    	if(ids==null|| ids.length==0){
    		return JSONResult.AppValidateJSONResult("ids不能为空");
    	}
    	List<String> idsList = Arrays.asList(ids);
    	int result=${config.domainObjectNameToLowerCase}Service.deleteByExampleId(idsList);
    	System.out.println(result);
    	if(result>0){
    		return JSONResult.AppSuccessJSONResult("删除成功");
    	}else{
    		return JSONResult.AppFailJSONResult("删除失败");
    	}
    }

}