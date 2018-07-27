package com.dearho.util.face.vo;

import java.util.Map;

import com.dearho.util.JsonTools;

/**
 * 行驶证
* @ClassName: VehicleLicenseVo 
* @Description: TODO
* @author LH
* @date 2017年8月22日 下午4:31:04 
*
 */
public class VehicleLicenseVo {
	
	public VehicleLicenseVo(String str){
		Map<String, String> map = JsonTools.jsonForMap(str);
		this.request_id=map.get("request_id");
		this.type=Integer.parseInt(map.get("type"));
		this.plate_no=map.get("plate_no");
		this.vehicle_type=map.get("vehicle_type");
		this.owner=map.get("owner");
		this.address=map.get("address");
		this.use_character=map.get("use_character");
		this.model=map.get("model");
		this.vin=map.get("vin");
		this.engine_no=map.get("engine_no");
		String register_date_json=map.get("register_date");
		this.register_date=JsonTools.jsonForMap(register_date_json);
		String issue_date_json=map.get("issue_date");
		this.issue_date=JsonTools.jsonForMap(issue_date_json);
		this.side=map.get("side");
		this.issued_by=map.get("issued_by");
	}
	
	private String request_id;
	
	private int type;
	
	private String plate_no;
	
	private String vehicle_type;
	
	private String owner;
	
	private String address;
	
	private String use_character;
	
	private String model;
	
	private String vin;
	
	private String engine_no;
	
	private Map<String,String> register_date;
	
	private Map<String,String> issue_date;
	
	private String side;
	
	private String issued_by;
	
	private int time_used;

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

	public String getPlate_no() {
		return plate_no;
	}

	public void setPlate_no(String plate_no) {
		this.plate_no = plate_no;
	}

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUse_character() {
		return use_character;
	}

	public void setUse_character(String use_character) {
		this.use_character = use_character;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getEngine_no() {
		return engine_no;
	}

	public void setEngine_no(String engine_no) {
		this.engine_no = engine_no;
	}

	public Map<String, String> getRegister_date() {
		return register_date;
	}

	public void setRegister_date(Map<String, String> register_date) {
		this.register_date = register_date;
	}

	public Map<String, String> getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(Map<String, String> issue_date) {
		this.issue_date = issue_date;
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

	public int getTime_used() {
		return time_used;
	}

	public void setTime_used(int time_used) {
		this.time_used = time_used;
	}
}
