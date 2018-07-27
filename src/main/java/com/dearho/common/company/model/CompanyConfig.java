package com.dearho.common.company.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "s_company_config")
public class CompanyConfig {
    @Id
    @GeneratedValue(generator="UUID")
    private String id;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "company_sn")
    private String companySn;

    @Column(name = "sms_type")
    private Integer smsType;

    @Column(name = "sms_is_test")
    private Integer smsIsTest;

    @Column(name = "sms_api_key")
    private String smsApiKey;

    @Column(name = "sms_user_name")
    private String smsUserName;

    @Column(name = "sms_password")
    private String smsPassword;

    @Column(name = "oil_price")
    private BigDecimal oilPrice;

    @Column(name = "offline_oil")
    private BigDecimal offlineOil;

    @Column(name = "electricity_price")
    private BigDecimal electricityPrice;

    @Column(name = "offine_electricity")
    private BigDecimal offineElectricity;

    @Column(name = "return_type")
    private Integer returnType;

    @Column(name = "frozen_amount")
    private BigDecimal frozenAmount;

    @Column(name = "open_door_distance")
    private Integer openDoorDistance;

    @Column(name = "close_door_distance")
    private Integer closeDoorDistance;

    @Column(name = "return_car_distance")
    private Integer returnCarDistance;

    @Column(name = "dot_distance")
    private Integer dotDistance;

    @Column(name = "work_start_time")
    private String workStartTime;

    @Column(name = "work_end_time")
    private String workEndTime;

    @Column(name = "recharge_message")
    private String rechargeMessage;

    @Column(name = "area_code")
    private Integer areaCode;

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
     * @return sms_type
     */
    public Integer getSmsType() {
        return smsType;
    }

    /**
     * @param smsType
     */
    public void setSmsType(Integer smsType) {
        this.smsType = smsType;
    }

    /**
     * @return sms_is_test
     */
    public Integer getSmsIsTest() {
        return smsIsTest;
    }

    /**
     * @param smsIsTest
     */
    public void setSmsIsTest(Integer smsIsTest) {
        this.smsIsTest = smsIsTest;
    }

    /**
     * @return sms_api_key
     */
    public String getSmsApiKey() {
        return smsApiKey;
    }

    /**
     * @param smsApiKey
     */
    public void setSmsApiKey(String smsApiKey) {
        this.smsApiKey = smsApiKey;
    }

    /**
     * @return sms_user_name
     */
    public String getSmsUserName() {
        return smsUserName;
    }

    /**
     * @param smsUserName
     */
    public void setSmsUserName(String smsUserName) {
        this.smsUserName = smsUserName;
    }

    /**
     * @return sms_password
     */
    public String getSmsPassword() {
        return smsPassword;
    }

    /**
     * @param smsPassword
     */
    public void setSmsPassword(String smsPassword) {
        this.smsPassword = smsPassword;
    }

    /**
     * @return oil_price
     */
    public BigDecimal getOilPrice() {
        return oilPrice;
    }

    /**
     * @param oilPrice
     */
    public void setOilPrice(BigDecimal oilPrice) {
        this.oilPrice = oilPrice;
    }

    /**
     * @return offline_oil
     */
    public BigDecimal getOfflineOil() {
        return offlineOil;
    }

    /**
     * @param offlineOil
     */
    public void setOfflineOil(BigDecimal offlineOil) {
        this.offlineOil = offlineOil;
    }

    /**
     * @return electricity_price
     */
    public BigDecimal getElectricityPrice() {
        return electricityPrice;
    }

    /**
     * @param electricityPrice
     */
    public void setElectricityPrice(BigDecimal electricityPrice) {
        this.electricityPrice = electricityPrice;
    }

    /**
     * @return offine_electricity
     */
    public BigDecimal getOffineElectricity() {
        return offineElectricity;
    }

    /**
     * @param offineElectricity
     */
    public void setOffineElectricity(BigDecimal offineElectricity) {
        this.offineElectricity = offineElectricity;
    }

    /**
     * @return return_type
     */
    public Integer getReturnType() {
        return returnType;
    }

    /**
     * @param returnType
     */
    public void setReturnType(Integer returnType) {
        this.returnType = returnType;
    }

    /**
     * @return frozen_amount
     */
    public BigDecimal getFrozenAmount() {
        return frozenAmount;
    }

    /**
     * @param frozenAmount
     */
    public void setFrozenAmount(BigDecimal frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    /**
     * @return open_door_distance
     */
    public Integer getOpenDoorDistance() {
        return openDoorDistance;
    }

    /**
     * @param openDoorDistance
     */
    public void setOpenDoorDistance(Integer openDoorDistance) {
        this.openDoorDistance = openDoorDistance;
    }

    /**
     * @return close_door_distance
     */
    public Integer getCloseDoorDistance() {
        return closeDoorDistance;
    }

    /**
     * @param closeDoorDistance
     */
    public void setCloseDoorDistance(Integer closeDoorDistance) {
        this.closeDoorDistance = closeDoorDistance;
    }

    /**
     * @return return_car_distance
     */
    public Integer getReturnCarDistance() {
        return returnCarDistance;
    }

    /**
     * @param returnCarDistance
     */
    public void setReturnCarDistance(Integer returnCarDistance) {
        this.returnCarDistance = returnCarDistance;
    }

    /**
     * @return dot_distance
     */
    public Integer getDotDistance() {
        return dotDistance;
    }

    /**
     * @param dotDistance
     */
    public void setDotDistance(Integer dotDistance) {
        this.dotDistance = dotDistance;
    }

    /**
     * @return work_start_time
     */
    public String getWorkStartTime() {
        return workStartTime;
    }

    /**
     * @param workStartTime
     */
    public void setWorkStartTime(String workStartTime) {
        this.workStartTime = workStartTime;
    }

    /**
     * @return work_end_time
     */
    public String getWorkEndTime() {
        return workEndTime;
    }

    /**
     * @param workEndTime
     */
    public void setWorkEndTime(String workEndTime) {
        this.workEndTime = workEndTime;
    }

    /**
     * @return recharge_message
     */
    public String getRechargeMessage() {
        return rechargeMessage;
    }

    /**
     * @param rechargeMessage
     */
    public void setRechargeMessage(String rechargeMessage) {
        this.rechargeMessage = rechargeMessage;
    }

    /**
     * @return area_code
     */
    public Integer getAreaCode() {
        return areaCode;
    }

    /**
     * @param areaCode
     */
    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }
}