package com.dearho.elasticsearch.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 *司机位置
 * <p>
 * 
 */
@Document(indexName = "driverlocation", type = "city")
public class DriverLocation implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String name;

    /**
     * 纬度
     */
    private Double latitude ;

    /**
     * 经度
     */
    private Double longitude;

    /**
     * 时间戳
     */
    private Date ts;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Date getTs() {
		return ts;
	}

	public void setTs(Date ts) {
		this.ts = ts;
	}
    
    
    
    
}
