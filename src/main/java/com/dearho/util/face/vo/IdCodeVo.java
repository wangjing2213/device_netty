package com.dearho.util.face.vo;

import java.util.Map;

import com.dearho.util.JsonTools;

/**
 * IdCodeVo
 * @author LH
 * 2017年7月13日 12:43:13
 */
public class IdCodeVo {
	
	public IdCodeVo(String str){
		Map<String, String> map = JsonTools.jsonForMap(str);
		this.request_id = map.get("request_id");
		this.time_used = Float.valueOf(map.get("time_used"));
		this.side = map.get("side");
		if("front".equals(side)){
			this.name=map.get("name");
			this.address=map.get("address");
			String birthday_json = map.get("birthday");
			this.birthday=JsonTools.jsonForMap(birthday_json);
			this.gender=map.get("gender");
			this.id_card_number=map.get("id_card_number");
			this.race=map.get("race");
			String head_rect_json = map.get("head_rect");
			this.head_rect=JsonTools.jsonForMap(head_rect_json);
		}else if("back".equals(side)){
			this.issued_by=map.get("issued_by");
			this.valid_date=map.get("valid_date");
		}
		if(map.get("legality")!=null){
			this.legality=JsonTools.jsonForMap(map.get("legality"));
		}
	}
	private String request_id;
	
	private Float time_used;
	
	private String address;
	
	private Map<String,String> birthday;
	
	private String gender;
	
	private String id_card_number;
	
	private String name;
	
	private String race;
	
	private String side;
	
	private String issued_by;
	
	private String valid_date;
	
	private Map<String,String> head_rect;
	
	private Map<String,String> legality;

	public String getRequest_id() {
		return request_id;
	}

	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}

	public Float getTime_used() {
		return time_used;
	}

	public void setTime_used(Float time_used) {
		this.time_used = time_used;
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

	public String getId_card_number() {
		return id_card_number;
	}

	public void setId_card_number(String id_card_number) {
		this.id_card_number = id_card_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getIssued_by() {
		return issued_by;
	}

	public void setIssued_by(String issued_by) {
		this.issued_by = issued_by;
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

	public Map<String, String> getLegality() {
		return legality;
	}

	public void setLegality(Map<String, String> legality) {
		this.legality = legality;
	}
}
