package com.dearho.common.car.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "c_car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "vehicle_plate_id")
    private String vehiclePlateId;

    private String vin;

    @Column(name = "model_id")
    private String modelId;

    @Column(name = "creator_id")
    private String creatorId;

    @Column(name = "create_date")
    private Date createDate;

    private Date ts;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "api_id")
    private String apiId;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "company_sn")
    private String companySn;

    @Column(name = "car_type")
    private Integer carType;

    @Column(name = "information_type")
    private Integer informationType;

    @Column(name = "blue_key")
    private String blueKey;

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
     * @return vehicle_plate_id
     */
    public String getVehiclePlateId() {
        return vehiclePlateId;
    }

    /**
     * @param vehiclePlateId
     */
    public void setVehiclePlateId(String vehiclePlateId) {
        this.vehiclePlateId = vehiclePlateId;
    }

    /**
     * @return vin
     */
    public String getVin() {
        return vin;
    }

    /**
     * @param vin
     */
    public void setVin(String vin) {
        this.vin = vin;
    }

    /**
     * @return model_id
     */
    public String getModelId() {
        return modelId;
    }

    /**
     * @param modelId
     */
    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    /**
     * @return creator_id
     */
    public String getCreatorId() {
        return creatorId;
    }

    /**
     * @param creatorId
     */
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return ts
     */
    public Date getTs() {
        return ts;
    }

    /**
     * @param ts
     */
    public void setTs(Date ts) {
        this.ts = ts;
    }

    /**
     * @return customer_id
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @return api_id
     */
    public String getApiId() {
        return apiId;
    }

    /**
     * @param apiId
     */
    public void setApiId(String apiId) {
        this.apiId = apiId;
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
     * @return car_type
     */
    public Integer getCarType() {
        return carType;
    }

    /**
     * @param carType
     */
    public void setCarType(Integer carType) {
        this.carType = carType;
    }

    /**
     * @return information_type
     */
    public Integer getInformationType() {
        return informationType;
    }

    /**
     * @param informationType
     */
    public void setInformationType(Integer informationType) {
        this.informationType = informationType;
    }

    /**
     * @return blue_key
     */
    public String getBlueKey() {
        return blueKey;
    }

    /**
     * @param blueKey
     */
    public void setBlueKey(String blueKey) {
        this.blueKey = blueKey;
    }
}