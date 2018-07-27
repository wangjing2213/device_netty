package com.dearho.kafka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/test")
public class CollectController {

	 protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	    @Autowired
	    private KafkaTemplate<String, String> kafkaTemplate;

	    @RequestMapping(value = "/send", method = RequestMethod.GET)
	    public String sendKafka(HttpServletRequest request, HttpServletResponse response) {
	        try {
	            String message = request.getParameter("message");
	            logger.info("kafka的消息={}", message);
	            kafkaTemplate.send("test",  message);//第一个参数就是topic
	            logger.info("发送kafka成功.");
	            return "发送kafka成功";
	        } catch (Exception e) {
	            logger.error("发送kafka失败", e);
	            return "发送kafka失败";
	        }
	    }
}
