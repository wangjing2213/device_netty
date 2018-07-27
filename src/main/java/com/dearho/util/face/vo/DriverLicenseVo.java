package com.dearho.util.face.vo;

import java.util.Map;

import com.dearho.util.JsonTools;


/**
 * 驾驶证
* @ClassName: DriverLicenseVo 
* @Description: TODO
* @author LH
* @date 2017年8月22日 下午4:30:48 
*
 */
public class DriverLicenseVo {
	public DriverLicenseVo(String str){
		System.out.println(str);
		str= str.replaceAll("\"class\"", "\"classs\"");
		Map<String, String> map = JsonTools.jsonForMap(str);
		this.request_id = map.get("request_id");
		this.type= Integer.parseInt(map.get("type"));
		this.address= map.get("address");
		this.name= map.get("name");
		String birthday_json = map.get("birthday");
		this.birthday=JsonTools.jsonForMap(birthday_json);
		this.gender= map.get("gender");
		this.license_number=map.get("license_number");
		this.classs=map.get("classs");
		this.side=map.get("side");
		this.nationality=map.get("nationality");
		this.issued_by=map.get("issued_by");
		
		String  issue_date_json= map.get("issue_date");
		this.issue_date=JsonTools.jsonForMap(issue_date_json);
		
		String  valid_from_json= map.get("valid_from");
		if(valid_from_json!=null){
			this.valid_from=JsonTools.jsonForMap(valid_from_json);	
		}
		this.valid_for=map.get("valid_for");
		this.valid_date=map.get("valid_date");
	}
	private String request_id;
	
	private int type;
	
	private String address;
	
	private Map<String,String> birthday;
	
	private String gender;
	
	private String license_number;
	
	private String name;
	
	private String classs;
	
	private String side;
	
	private String nationality;
	
	private String issued_by;
	
	private Map<String,String> issue_date;
	
	private Map<String,String> valid_from;
	
	private String valid_for;
	
	private String valid_date;
	
	private Map<String,String> head_rect;
	
	private String time_used;

	public String getRequest_id() {
		return request_id;
	}

	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Map<String, String> getBirthday() {
		return birthday;
	}

	public void setBirthday(Map<String, String> birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLicense_number() {
		return license_number;
	}

	public void setLicense_number(String license_number) {
		this.license_number = license_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClasss() {
		return classs;
	}

	public void setClasss(String classs) {
		this.classs = classs;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getIssued_by() {
		return issued_by;
	}

	public void setIssued_by(String issued_by) {
		this.issued_by = issued_by;
	}

	public Map<String, String> getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(Map<String, String> issue_date) {
		this.issue_date = issue_date;
	}

	public Map<String, String> getValid_from() {
		return valid_from;
	}

	public void setValid_from(Map<String, String> valid_from) {
		this.valid_from = valid_from;
	}

	public String getValid_for() {
		return valid_for;
	}

	public void setValid_for(String valid_for) {
		this.valid_for = valid_for;
	}

	public String getValid_date() {
		return valid_date;
	}

	public void setValid_date(String valid_date) {
		this.valid_date = valid_date;
	}

	public Map<String, String> getHead_rect() {
		return head_rect;
	}

	public void setHead_rect(Map<String, String> head_rect) {
		this.head_rect = head_rect;
	}

	public String getTime_used() {
		return time_used;
	}

	public void setTime_used(String time_used) {
		this.time_used = time_used;
	}
	
	
}
