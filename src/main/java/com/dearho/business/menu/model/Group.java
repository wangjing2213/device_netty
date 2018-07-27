package com.dearho.business.menu.model;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.dearho.core.validate.GroupAdd;
import com.dearho.core.validate.GroupUpdate;

@Table(name = "s_group")
public class Group {
    @Id
    @GeneratedValue(generator="UUID")
    @Column(name = "group_id")
    private String id;

    @NotNull(message = "角色名称不能为空", groups = {GroupAdd.class,GroupUpdate.class})  
    @Column(name = "group_name")
    private String groupName;

   
    @Column(name = "group_remark")
    private String groupRemark;

    @Column(name = "group_creator_id")
    private String groupCreatorId;

    @Column(name = "group_create_time")
    private Date groupCreateTime;

    private Date ts;

//    @NotNull(message = "所属公司不能为空", groups = {GroupAdd.class,GroupUpdate.class})  
    @Column(name = "company_id")
    private Integer companyId;

//    @NotNull(message = "所属公司不能为空", groups = {GroupAdd.class,GroupUpdate.class})  
    @Column(name = "company_sn")
    private String companySn;

   

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
     * @return group_name
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * @param groupName
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * @return group_remark
     */
    public String getGroupRemark() {
        return groupRemark;
    }

    /**
     * @param groupRemark
     */
    public void setGroupRemark(String groupRemark) {
        this.groupRemark = groupRemark;
    }

    /**
     * @return group_creator_id
     */
    public String getGroupCreatorId() {
        return groupCreatorId;
    }

    /**
     * @param groupCreatorId
     */
    public void setGroupCreatorId(String groupCreatorId) {
        this.groupCreatorId = groupCreatorId;
    }

    /**
     * @return group_create_time
     */
    public Date getGroupCreateTime() {
        return groupCreateTime;
    }

    /**
     * @param groupCreateTime
     */
    public void setGroupCreateTime(Date groupCreateTime) {
        this.groupCreateTime = groupCreateTime;
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
}