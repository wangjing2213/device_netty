package com.dearho.exception;

/**
 * 业务异常，抛出此异常日志不记录
 * @author liusong
 *
 */
public class BusinessException extends DearhoException {
	private static final long serialVersionUID = 1L;

	public BusinessException(){
		
	}
	
	public BusinessException(String msg){
		super(msg);
	}
	
	public BusinessException(Throwable ex){
		super(ex);
	}
	
	public BusinessException(String msg,Throwable ex){
		super(msg,ex);
	}
}
