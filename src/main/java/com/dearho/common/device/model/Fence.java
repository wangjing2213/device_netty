package com.dearho.common.device.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "f_fence")
public class Fence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "fence_name")
    private String fenceName;

    @Column(name = "fence_type")
    private String fenceType;

    private String descl;

    private String shape;

    private String center;

    private Float radius;

    @Column(name = "creator_name")
    private String creatorName;

    private String mode;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "company_sn")
    private String companySn;

    private String vertexes;

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
     * @return descl
     */
    public String getDescl() {
        return descl;
    }

    /**
     * @param descl
     */
    public void setDescl(String descl) {
        this.descl = descl;
    }

    /**
     * @return shape
     */
    public String getShape() {
        return shape;
    }

    /**
     * @param shape
     */
    public void setShape(String shape) {
        this.shape = shape;
    }

    /**
     * @return center
     */
    public String getCenter() {
        return center;
    }

    /**
     * @param center
     */
    public void setCenter(String center) {
        this.center = center;
    }

    /**
     * @return radius
     */
    public Float getRadius() {
        return radius;
    }

    /**
     * @param radius
     */
    public void setRadius(Float radius) {
        this.radius = radius;
    }

    /**
     * @return creator_name
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * @param creatorName
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    /**
     * @return mode
     */
    public String getMode() {
        return mode;
    }

    /**
     * @param mode
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * @return city_name
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * @param cityName
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
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
     * @return vertexes
     */
    public String getVertexes() {
        return vertexes;
    }

    /**
     * @param vertexes
     */
    public void setVertexes(String vertexes) {
        this.vertexes = vertexes;
    }
}