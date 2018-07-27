package com.dearho.common.sys.model;

import javax.persistence.*;

@Table(name = "s_area")
public class Area {
    @Id
    private String code;

    private String address;

    @Column(name = "parent_code")
    private String parentCode;

    @Column(name = "area_index")
    private Integer areaIndex;

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
     * @return parent_code
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     * @param parentCode
     */
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    /**
     * @return area_index
     */
    public Integer getAreaIndex() {
        return areaIndex;
    }

    /**
     * @param areaIndex
     */
    public void setAreaIndex(Integer areaIndex) {
        this.areaIndex = areaIndex;
    }
}