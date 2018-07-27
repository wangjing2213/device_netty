package com.dearho.util.hawkeye.bean;

import java.io.Serializable;

/**
 * Created by acer on 2017/7/12 0012.
 */
public class Track implements Serializable {
    private String coord_type_input;

    public String getCoord_type_input() {
        return coord_type_input;
    }

    public void setCoord_type_input(String coord_type_input) {
        this.coord_type_input = coord_type_input;
    }

    /**
     * 车架号
     */
    private String entity_name;
    /**
     * 纬度
     */
    private Double latitude;
    /**
     * 经度
     */
    private Double longitude;

    private Double offset_lat;
    private Double offset_lng;

    public Double getOffset_lat() {
        return offset_lat;
    }

    public void setOffset_lat(Double offset_lat) {
        this.offset_lat = offset_lat;
    }

    public Double getOffset_lng() {
        return offset_lng;
    }

    public void setOffset_lng(Double offset_lng) {
        this.offset_lng = offset_lng;
    }

    /**
     *方向（0-359度）
     */
    private Integer direction;
    /**
     * 高度（米）
     */
    private Double height;
    /**
     * 时速（千米/时）
     */
    private Double speed;
    /**
     * 楼层
     */
    private String floor;
    /**
     * 定位精度（米）
     */
    private Double radius;
    /**
     * 时间戳
     */
    private Long loc_time;

    public Long getLoc_time() {
        return loc_time;
    }

    public void setLoc_time(Long loc_time) {
        this.loc_time = loc_time;
    }

    /**
     * 当前里程
     */
    private String km;
    private String soc;

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

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }



    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getSoc() {
        return soc;
    }

    public void setSoc(String soc) {
        this.soc = soc;
    }

    public String getEntity_name() {
        return entity_name;
    }

    public void setEntity_name(String entity_name) {
        this.entity_name = entity_name;
    }
}
