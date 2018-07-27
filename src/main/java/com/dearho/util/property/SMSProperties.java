package com.dearho.util.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "sms", ignoreUnknownFields = false)
@PropertySource("classpath:config/sms_message.properties")
@Component
public class SMSProperties {
	
	private String subscriber_login;
	private String subscriber_register;					
	private String subscriber_information_check_success;
	private String subscriber_information_check_fail;	
	private String subscriber_change_password_success;
	private String subscriebr_change_new_phone;			
	private String subscriebr_change_old_phone;			
	private String subscriber_change_phone_success;
	
	private String car_information_check_success;
	private String car_information_check_fail;
	
	
	
	public String getSubscriber_login() {
		return subscriber_login;
	}
	public void setSubscriber_login(String subscriber_login) {
		this.subscriber_login = subscriber_login;
	}
	public String getSubscriber_register() {
		return subscriber_register;
	}
	public void setSubscriber_register(String subscriber_register) {
		this.subscriber_register = subscriber_register;
	}
	public String getSubscriber_information_check_success() {
		return subscriber_information_check_success;
	}
	public void setSubscriber_information_check_success(
			String subscriber_information_check_success) {
		this.subscriber_information_check_success = subscriber_information_check_success;
	}
	public String getSubscriber_information_check_fail() {
		return subscriber_information_check_fail;
	}
	public void setSubscriber_information_check_fail(
			String subscriber_information_check_fail) {
		this.subscriber_information_check_fail = subscriber_information_check_fail;
	}
	public String getSubscriber_change_password_success() {
		return subscriber_change_password_success;
	}
	public void setSubscriber_change_password_success(
			String subscriber_change_password_success) {
		this.subscriber_change_password_success = subscriber_change_password_success;
	}
	public String getSubscriebr_change_new_phone() {
		return subscriebr_change_new_phone;
	}
	public void setSubscriebr_change_new_phone(String subscriebr_change_new_phone) {
		this.subscriebr_change_new_phone = subscriebr_change_new_phone;
	}
	public String getSubscriebr_change_old_phone() {
		return subscriebr_change_old_phone;
	}
	public void setSubscriebr_change_old_phone(String subscriebr_change_old_phone) {
		this.subscriebr_change_old_phone = subscriebr_change_old_phone;
	}
	public String getSubscriber_change_phone_success() {
		return subscriber_change_phone_success;
	}
	public void setSubscriber_change_phone_success(
			String subscriber_change_phone_success) {
		this.subscriber_change_phone_success = subscriber_change_phone_success;
	}
	public String getCar_information_check_success() {
		return car_information_check_success;
	}
	public void setCar_information_check_success(
			String car_information_check_success) {
		this.car_information_check_success = car_information_check_success;
	}
	public String getCar_information_check_fail() {
		return car_information_check_fail;
	}
	public void setCar_information_check_fail(String car_information_check_fail) {
		this.car_information_check_fail = car_information_check_fail;
	}		

	
}
