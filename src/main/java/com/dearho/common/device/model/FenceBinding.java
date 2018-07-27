package com.dearho.common.device.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "f_fence_binding")
public class FenceBinding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "device_no")
    private String deviceNo;

    @Column(name = "fence_id")
    private String fenceId;

    @Column(name = "fence_type")
    private String fenceType;

    @Column(name = "is_used")
    private String isUsed;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "device_binding_id")
    private String deviceBindingId;

    @Column(name = "car_no")
    private String carNo;

    @Column(name = "fence_name")
    private String fenceName;

    @Column(name = "car_vin")
    private String carVin;

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
     * @return fence_id
     */
    public String getFenceId() {
        return fenceId;
    }

    /**
     * @param fenceId
     */
    public void setFenceId(String fenceId) {
        this.fenceId = fenceId;
    }

    /**
     * @return fence_type
     */
    public String getFenceType() {
        return fenceType;
    }

    /**
     * @param fenceType
     */
    public void setFenceType(String fenceType) {
        this.fenceType = fenceType;
    }

    /**
     * @return is_used
     */
    public String getIsUsed() {
        return isUsed;
    }

    /**
     * @param isUsed
     */
    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return device_binding_id
     */
    public String getDeviceBindingId() {
        return deviceBindingId;
    }

    /**
     * @param deviceBindingId
     */
    public void setDeviceBindingId(String deviceBindingId) {
        this.deviceBindingId = deviceBindingId;
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
     * @return fence_name
     */
    public String getFenceName() {
        return fenceName;
    }

    /**
     * @param fenceName
     */
    public void setFenceName(String fenceName) {
        this.fenceName = fenceName;
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