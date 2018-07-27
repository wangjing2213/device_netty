package com.dearho.common.log.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "s_user_operate_log")
public class SysOperateLogRecord {
    @Id
    @GeneratedValue(generator="UUID")
    private String id;

    @Column(name = "operator_id")
    private String operatorId;

    @Column(name = "operator_name")
    private String operatorName;

    @Column(name = "operate_date")
    private Date operateDate;

    @Column(name = "operate_remark")
    private String operateRemark;

    @Column(name = "record_id")
    private String recordId;

    @Column(name = "model_name")
    private String modelName;

    private String keyword;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "company_sn")
    private String companySn;

    @Column(name = "operate_content")
    private String operateContent;

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
     * @return operator_id
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * @param operatorId
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * @return operator_name
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * @param operatorName
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    /**
     * @return operate_date
     */
    public Date getOperateDate() {
        return operateDate;
    }

    /**
     * @param operateDate
     */
    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    /**
     * @return operate_remark
     */
    public String getOperateRemark() {
        return operateRemark;
    }

    /**
     * @param operateRemark
     */
    public void setOperateRemark(String operateRemark) {
        this.operateRemark = operateRemark;
    }

    /**
     * @return record_id
     */
    public String getRecordId() {
        return recordId;
    }

    /**
     * @param recordId
     */
    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    /**
     * @return model_name
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * @param modelName
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * @return keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @param keyword
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
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
     * @return operate_content
     */
    public String getOperateContent() {
        return operateContent;
    }

    /**
     * @param operateContent
     */
    public void setOperateContent(String operateContent) {
        this.operateContent = operateContent;
    }
}