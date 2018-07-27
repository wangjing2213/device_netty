package com.dearho.common.device.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "d_device_command_record")
public class DeviceCommandRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "device_no")
    private String deviceNo;

    @Column(name = "request_time")
    private Date requestTime;

    private String type;

    @Column(name = "feedback_mark")
    private String feedbackMark;

    @Column(name = "response_time")
    private Date responseTime;

    @Column(name = "command_id")
    private String commandId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "ins_id")
    private String insId;

    @Column(name = "device_id")
    private String deviceId;

    @Column(name = "car_id")
    private String carId;

    @Column(name = "car_no")
    private String carNo;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "company_sn")
    private String companySn;

    private String content;

    @Column(name = "feedback_content")
    private String feedbackContent;

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
     * @return device_no
     */
    public String getDeviceNo() {
        return deviceNo;
    }

    /**
     * @param deviceNo
     */
    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    /**
     * @return request_time
     */
    public Date getRequestTime() {
        return requestTime;
    }

    
    /**
     * @param requestTime
     */
    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return feedback_mark
     */
    public String getFeedbackMark() {
        return feedbackMark;
    }

    /**
     * @param feedbackMark
     */
    public void setFeedbackMark(String feedbackMark) {
        this.feedbackMark = feedbackMark;
    }

    /**
     * @return response_time
     */
    public Date getResponseTime() {
        return responseTime;
    }

    /**
     * @param responseTime
     */
    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    /**
     * @return command_id
     */
    public String getCommandId() {
        return commandId;
    }

    /**
     * @param commandId
     */
    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    /**
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return ins_id
     */
    public String getInsId() {
        return insId;
    }

    /**
     * @param insId
     */
    public void setInsId(String insId) {
        this.insId = insId;
    }

    /**
     * @return device_id
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * @param deviceId
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * @return car_id
     */
    public String getCarId() {
        return carId;
    }

    /**
     * @param carId
     */
    public void setCarId(String carId) {
        this.carId = carId;
    }

    /**
     * @return car_no
     */
    public String getCarNo() {
        return carNo;
    }

    /**
     * @param carNo
     */
    public void setCarNo(String carNo) {
        this.carNo = carNo;
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
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return feedback_content
     */
    public String getFeedbackContent() {
        return feedbackContent;
    }

    /**
     * @param feedbackContent
     */
    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }
}