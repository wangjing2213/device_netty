package com.dearho.core.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.dearho.util.DatabaseContextHolder;
import com.dearho.util.DatabaseType;

@Aspect
@Component
public class DataSourceAspect {

    /**
     * 使用空方法定义切点表达式
     */
    @Pointcut("execution(* com.dearho.*.*.service.**.*(..))")
    public void declareJointPointExpression() {
    }

  
	@Before("declareJointPointExpression()")
    public void setDataSourceKey(JoinPoint point){
        //根据连接点所属的类实例，动态切换数据源
	
        /*if (point.getTarget() instanceof OrdersService
                || point.getTarget() instanceof OrdersServiceImpl) {
            DatabaseContextHolder.setDatabaseType(DatabaseType.business);
        } else {//连接点所属的类实例是（当然，这一步也可以不写，因为defaultTargertDataSource就是该类所用的mytestdb）
            DatabaseContextHolder.setDatabaseType(DatabaseType.common);
        }*/
//		System.out.println("Aspect:"+point.getSignature().getDeclaringTypeName()+(point.getSignature().getDeclaringTypeName().startsWith("com.dearho.business")));
//		if(point.getSignature().getDeclaringTypeName().startsWith("com.dearho.business")){
//			DatabaseContextHolder.setDatabaseType(DatabaseType.business);
//		}else if(point.getSignature().getDeclaringTypeName().startsWith("com.dearho.core.config.service.BusinessService")){
//				DatabaseContextHolder.setDatabaseType(DatabaseType.business);
//		}else{
			DatabaseContextHolder.setDatabaseType(DatabaseType.common);
//		}
    }
}