package com.dearho.common.company.vo;

import com.dearho.common.company.model.CompanyRelation;

public class CompanyRelationVO {

	private Integer id;
	private String name;
	private String prefix;
	private String sn;
	private String province;
	private String city;
	private String status;
	
	public CompanyRelationVO(){
		super();
	}
	public CompanyRelationVO(CompanyRelation companyRelation,String prefix){
		super();
		this.id=companyRelation.getId();
		this.name=companyRelation.getCompanyName();
		this.sn=companyRelation.getSn();
		this.province=companyRelation.getProvince();
		this.city=companyRelation.getCity();
		this.status=companyRelation.getStatus();
		if(prefix!=null){
			this.prefix=prefix+"---";
		}else{
			this.prefix="";
		}
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	

	
	
}
