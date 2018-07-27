package com.dearho.business.dict.util;

import com.dearho.business.dict.model.Dict;

/**
 * 数据字典封装
* @ClassName: DictVo 
* @Description: TODO
* @author LH
* @date 2017年8月22日 下午2:43:29 
*
 */
public class DictVo {
	
	public DictVo(Dict dict){
		this.code=dict.getCode();
		this.name=dict.getCnName();
	}
	public DictVo(String code,String name){
		this.code=code;
		this.name=name;
	}
	private String code; //编码
	
	private String name; //名称

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
