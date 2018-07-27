package com.dearho.util.hawkeye.bean;

import java.io.Serializable;

/**
 * Created by acer on 2017/7/12 0012.
 */
public class Entity  implements Serializable {
    /**
     * 车架号 vin
     */
    private String entity_name;
    /**
     * 车牌号
     */
    private String entity_desc;
    /**
     * 车机号
     */
    private String entity_vehicle;

    public String getEntity_name() {
        return entity_name;
    }

    public void setEntity_name(String entity_name) {
        this.entity_name = entity_name;
    }

    public String getEntity_desc() {
        return entity_desc;
    }

    public void setEntity_desc(String entity_desc) {
        this.entity_desc = entity_desc;
    }

    public String getEntity_vehicle() {
        return entity_vehicle;
    }

    public void setEntity_vehicle(String entity_vehicle) {
        this.entity_vehicle = entity_vehicle;
    }
}
