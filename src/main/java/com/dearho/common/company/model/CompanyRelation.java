package com.dearho.common.company.model;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.dearho.core.validate.GroupAdd;
import com.dearho.core.validate.GroupUpdate;

@Table(name = "s_company_relation")
public class CompanyRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "company_code")
    @NotNull(message = "公司code不能为空", groups = {GroupAdd.class,GroupUpdate.class})  
    private String companyCode;

    @Column(name = "company_name")
    @NotNull(message = "公司名称不能为空", groups = {GroupAdd.class,GroupUpdate.class}) 
    private String companyName;

    @Column(name = "legal_person")
    private String legalPerson;

    private String telephone;

    private String address;

    @NotNull(message = "省不能为空", groups = {GroupAdd.class,GroupUpdate.class})
    private String province;

    @NotNull(message = "市不能为空", groups = {GroupAdd.class,GroupUpdate.class})
    private String city;

    
    @Column(name = "parent_id")
    @NotNull(message = "父公司不能为空", groups = {GroupAdd.class,GroupUpdate.class})
    private Integer parentId;

    private String sn;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "creator_id")
    private String creatorId;

    @NotNull(message = "status不能为空", groups = {GroupAdd.class,GroupUpdate.class})
    private String status;

    private String remark;

    @Column(name = "company_config_id")
    private String companyConfigId;

    @Column(name = "img_name")
    private String imgName;
    
    @Column(name = "company_type")
    private String companyType; //2为出租车     add by  wangtao
    //不是数据库表中的字段，需要加此注解
    @Transient
    private CompanyConfig companyConfig;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return company_code
     */
    public String getCompanyCode() {
        return companyCode;
    }

    /**
     * @param companyCode
     */
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    /**
     * @return company_name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return legal_person
     */
    public String getLegalPerson() {
        return legalPerson;
    }

    /**
     * @param legalPerson
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    /**
     * @return telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
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
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return parent_id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * @return sn
     */
    public String getSn() {
        return sn;
    }

    /**
     * @param sn
     */
    public void setSn(String sn) {
        this.sn = sn;
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
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
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
     * @return company_config_id
     */
    public String getCompanyConfigId() {
        return companyConfigId;
    }

    /**
     * @param companyConfigId
     */
    public void setCompanyConfigId(String companyConfigId) {
        this.companyConfigId = companyConfigId;
    }

    /**
     * @return img_name
     */
    public String getImgName() {
        return imgName;
    }

    /**
     * @param imgName
     */
    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public CompanyConfig getCompanyConfig() {
		return companyConfig;
	}

	public void setCompanyConfig(CompanyConfig companyConfig) {
		this.companyConfig = companyConfig;
	}
    
}