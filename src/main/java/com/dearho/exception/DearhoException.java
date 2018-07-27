package com.dearho.exception;

/**
 * 自定义异常基类
 * @author sjg
 * @version 1.0.1 2013-10-9
 *
 */
public class DearhoException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public DearhoException(){
		
	}
	
	public DearhoException(String msg){
		super(msg);
	}
	
	public DearhoException(Throwable ex){
		super(ex);
	}
	
	public DearhoException(String msg, Throwable ex){
		super(msg,ex);
	}
	
}
