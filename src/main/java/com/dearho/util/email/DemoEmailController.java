package com.dearho.util.email;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController  
@RequestMapping(value="/email")   
public class DemoEmailController {
	
	 @Resource  
	    private EmailService emailService;  
	      
	    /** 
	     * 测试邮件发送 
	     */  
	    @RequestMapping(value = "/getTestDemoEmail", method = RequestMethod.GET)  
	    public void  getEntityById() throws Exception {  
	        String sendTo = "1447456815@qq.com";  
	        String titel = "测试邮件标题";  
	        String content = "测试邮件内容";  
	        emailService.sendSimpleMail(sendTo, titel, content);  
	        
	    }  

}
