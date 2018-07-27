package com.dearho.common.device.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "c_device_binding")
public class DeviceBinding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "car_id")
    private String carId;

    @Column(name = "device_id")
    private String deviceId;

    @Column(name = "device_no")
    private String deviceNo;

    @Column(name = "bind_type")
    private Integer bindType;

    @Column(name = "bind_date")
    private Date bindDate;

    @Column(name = "bind_user_id")
    private String bindUserId;

    @Column(name = "car_plate_no")
    private String carPlateNo;

    @Column(name = "car_vin")
    private String carVin;

    @Column(name = "car_type")
    private String carType;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "company_sn")
    private String companySn;

    @Column(name = "syn_state")
    private Integer synState;

    @Column(name = "rentModelType")
    private String rentmodeltype;

    @Column(name = "isOnline")
    private String isonline;

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
     * @return car_id
     */
    public String getCarId() {
        return carId;
    }

    /**
     * @param carId
     */
    public void setCarId(String carId) {
        this.carId = carId;
    }

    /**
     * @return device_id
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * @param deviceId
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
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
     * @return bind_type
     */
    public Integer getBindType() {
        return bindType;
    }

    /**
     * @param bindType
     */
    public void setBindType(Integer bindType) {
        this.bindType = bindType;
    }

    /**
     * @return bind_date
     */
    public Date getBindDate() {
        return bindDate;
    }

    /**
     * @param bindDate
     */
    public void setBindDate(Date bindDate) {
        this.bindDate = bindDate;
    }

    /**
     * @return bind_user_id
     */
    public String getBindUserId() {
        return bindUserId;
    }

    /**
     * @param bindUserId
     */
    public void setBindUserId(String bindUserId) {
        this.bindUserId = bindUserId;
    }

    /**
     * @return car_plate_no
     */
    public String getCarPlateNo() {
        return carPlateNo;
    }

    /**
     * @param carPlateNo
     */
    public void setCarPlateNo(String carPlateNo) {
        this.carPlateNo = carPlateNo;
    }

    /**
     * @return car_vin
     */
    public String getCarVin() {
        return carVin;
    }

    /**
     * @param carVin
     */
    public void setCarVin(String carVin) {
        this.carVin = carVin;
    }

    /**
     * @return car_type
     */
    public String getCarType() {
        return carType;
    }

    /**
     * @param carType
     */
    public void setCarType(String carType) {
        this.carType = carType;
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

    /**
     * @return syn_state
     */
    public Integer getSynState() {
        return synState;
    }

    /**
     * @param synState
     */
    public void setSynState(Integer synState) {
        this.synState = synState;
    }

    /**
     * @return rentModelType
     */
    public String getRentmodeltype() {
        return rentmodeltype;
    }

    /**
     * @param rentmodeltype
     */
    public void setRentmodeltype(String rentmodeltype) {
        this.rentmodeltype = rentmodeltype;
    }

    /**
     * @return isOnline
     */
    public String getIsonline() {
        return isonline;
    }

    /**
     * @param isonline
     */
    public void setIsonline(String isonline) {
        this.isonline = isonline;
    }
}