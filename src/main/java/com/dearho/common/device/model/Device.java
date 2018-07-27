package com.dearho.common.device.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "d_device")
public class Device {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "set_no")
    private String setNo;

    @Column(name = "set_name")
    private String setName;

    @Column(name = "set_type")
    private String setType;

    @Column(name = "sim_id")
    private String simId;

    @Column(name = "update_firmware")
    private Integer updateFirmware;

    @Column(name = "firmware_version")
    private String firmwareVersion;

    @Column(name = "set_state")
    private String setState;

    @Column(name = "online_date")
    private Date onlineDate;

    @Column(name = "product_date")
    private Date productDate;

    @Column(name = "creator_id")
    private String creatorId;

    @Column(name = "create_date")
    private Date createDate;

    private Date ts;

    private String remark;

    @Column(name = "api_id")
    private String apiId;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "company_sn")
    private String companySn;

    /**
     * @return ID
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
     * @return set_no
     */
    public String getSetNo() {
        return setNo;
    }

    /**
     * @param setNo
     */
    public void setSetNo(String setNo) {
        this.setNo = setNo;
    }

    /**
     * @return set_name
     */
    public String getSetName() {
        return setName;
    }

    /**
     * @param setName
     */
    public void setSetName(String setName) {
        this.setName = setName;
    }

    /**
     * @return set_type
     */
    public String getSetType() {
        return setType;
    }

    /**
     * @param setType
     */
    public void setSetType(String setType) {
        this.setType = setType;
    }

    /**
     * @return sim_id
     */
    public String getSimId() {
        return simId;
    }

    /**
     * @param simId
     */
    public void setSimId(String simId) {
        this.simId = simId;
    }

    /**
     * @return update_firmware
     */
    public Integer getUpdateFirmware() {
        return updateFirmware;
    }

    /**
     * @param updateFirmware
     */
    public void setUpdateFirmware(Integer updateFirmware) {
        this.updateFirmware = updateFirmware;
    }

    /**
     * @return firmware_version
     */
    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    /**
     * @param firmwareVersion
     */
    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    /**
     * @return set_state
     */
    public String getSetState() {
        return setState;
    }

    /**
     * @param setState
     */
    public void setSetState(String setState) {
        this.setState = setState;
    }

    /**
     * @return online_date
     */
    public Date getOnlineDate() {
        return onlineDate;
    }

    /**
     * @param onlineDate
     */
    public void setOnlineDate(Date onlineDate) {
        this.onlineDate = onlineDate;
    }

    /**
     * @return product_date
     */
    public Date getProductDate() {
        return productDate;
    }

    /**
     * @param productDate
     */
    public void setProductDate(Date productDate) {
        this.productDate = productDate;
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
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
}