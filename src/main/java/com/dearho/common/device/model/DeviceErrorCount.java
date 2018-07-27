package com.dearho.common.device.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "d_device_error_count")
public class DeviceErrorCount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "device_no")
    private String deviceNo;

    @Column(name = "recive_time")
    private Date reciveTime;

    @Column(name = "start_time")
    private Date startTime;

    private String lat;

    private String lng;

    private String address;

    @Column(name = "car_no")
    private String carNo;

    @Column(name = "drop_time")
    private String dropTime;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "company_sn")
    private String companySn;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return device_no
     */
    public String getDeviceNo() {
        return deviceNo;
    }

    /**
     * @param deviceNo
     */
    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    /**
     * @return recive_time
     */
    public Date getReciveTime() {
        return reciveTime;
    }

    /**
     * @param reciveTime
     */
    public void setReciveTime(Date reciveTime) {
        this.reciveTime = reciveTime;
    }

    /**
     * @return start_time
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return lat
     */
    public String getLat() {
        return lat;
    }

    /**
     * @param lat
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * @return lng
     */
    public String getLng() {
        return lng;
    }

    /**
     * @param lng
     */
    public void setLng(String lng) {
        this.lng = lng;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return car_no
     */
    public String getCarNo() {
        return carNo;
    }

    /**
     * @param carNo
     */
    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    /**
     * @return drop_time
     */
    public String getDropTime() {
        return dropTime;
    }

    /**
     * @param dropTime
     */
    public void setDropTime(String dropTime) {
        this.dropTime = dropTime;
    }

    /**
     * @return company_id
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * @return company_sn
     */
    public String getCompanySn() {
        return companySn;
    }

    /**
     * @param companySn
     */
    public void setCompanySn(String companySn) {
        this.companySn = companySn;
    }
}