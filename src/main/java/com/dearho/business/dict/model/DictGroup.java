package com.dearho.business.dict.model;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.dearho.core.validate.GroupAdd;
import com.dearho.core.validate.GroupUpdate;

@Table(name = "s_dict_group")
public class DictGroup {
    @Id
    @GeneratedValue(generator="UUID")
    private String id;

    @NotNull(message = "编码不能为空", groups = {GroupAdd.class,GroupUpdate.class})
    private String code;

    private String remark;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "creator_id")
    private String creatorId;

    @Column(name = "update_time")
    private Date updateTime;

    private Date ts;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "company_sn")
    private String companySn;

    @Column(name = "is_system")
    @NotNull(message = "是否系统参数不能为空", groups = {GroupAdd.class,GroupUpdate.class})
    private Integer isSystem;

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
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
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
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
     * @return is_system
     */
    public Integer getIsSystem() {
        return isSystem;
    }

    /**
     * @param isSystem
     */
    public void setIsSystem(Integer isSystem) {
        this.isSystem = isSystem;
    }
}