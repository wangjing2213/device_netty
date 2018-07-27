package com.dearho.redis;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dearho.common.user.model.User;
import com.dearho.result.JSONResult;  
  

  
@RestController  
@RequestMapping("/redis")  
public class RedisCacheController {  
      
    @Autowired  
    private RedisUtils redisUtil;  
  
    @RequestMapping("/test")  
    public JSONResult getSessionId() {  
        redisUtil.set("123", "测试");  
        System.out.println("进入了方法");  
        String string = redisUtil.get("123").toString();
        System.out.println(string);
        return JSONResult.AppJSONResult(JSONResult.APP_RESULT_CODE_LOGIN,"");  
    }  
      
    @RequestMapping("/student")  
    public User getStudent() {  
        User user = new User();  
        user.setId(UUID.randomUUID().toString());  
      
        user.setName("张三");  
        redisUtil.set("001", user);  
        return (User) redisUtil.get("001");  
    }  
      
}