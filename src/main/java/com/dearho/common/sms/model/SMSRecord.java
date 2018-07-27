package com.dearho.common.sms.model;

import java.util.Date;

import javax.persistence.*;

@Table(name = "s_sms_record")
public class SMSRecord {

	public static final Integer TYPE_REGISTER=1;//注册
	public static final Integer TYPE_CONFIRM=2;//审核
	public static final Integer TYPE_ORDER=3;//订单
	public static final Integer TYPE_NOTICE=4;//违章通知
	public static final Integer TYPE_CODE=5;//验证码
	public static final Integer TYPE_REFUND=6;//退款
	public static final Integer TYPE_PWD=7;//修改密码
	public static final Integer TYPE_COUPONS=8;//优惠券
	public static final Integer TYPE_CHARGING=9;//充电订单
	public static final Integer TYPE_OFFICIAL=10;//公务车审核
	
	public static final Integer TYPE_OPE_LOGIN=11;//运维登录
	public static final Integer TYPE_OPE_NOTICE=12;//运维通知
	
	public static final Integer TYPE_COMMISSION=13;//代办
	
	public static final Integer TYPE_ADMIN=14;//公务车审核
	
	public static final Integer TYPE_SEND_SMS=15;//手动发放
	
	
	public static String getType(Integer type) {
		if(type==null){
			return null;
		}else if(TYPE_REGISTER.equals(type)){
			return "注册";
		}else if(TYPE_CONFIRM.equals(type)){
			return "会员审核";
		}else if(TYPE_ORDER.equals(type)){
			return "订单";
		}else if(TYPE_NOTICE.equals(type)){
			return "违章通知";
		}else if(TYPE_CODE.equals(type)){
			return "验证码";
		}else if(TYPE_REFUND.equals(type)){
			return "退款";
		}else if(TYPE_PWD.equals(type)){
			return "修改密码";
		}else if(TYPE_COUPONS.equals(type)){
			return "优惠券";
		}else if(TYPE_CHARGING.equals(type)){
			return "充电订单";
		}else if(TYPE_OFFICIAL.equals(type)){
			return "公务车审核";
		}else if(TYPE_ADMIN.equals(type)){
			return "手动发放";
		}else if(TYPE_OPE_LOGIN.equals(type)){
			return "运维登录";
		}else if(TYPE_OPE_NOTICE.equals(type)){
			return "运维通知";
		}else if(TYPE_COMMISSION.equals(type)){
			return "代办";
		}else if(TYPE_SEND_SMS.equals(type)){
			return "手动发放";
		}else{
			return "";
		}
		
	}
	
	
    @Id
    @GeneratedValue(generator="UUID")
    private String id;

    private Integer type;

    private String content;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    private String result;

    private Date ts;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "company_sn")
    private String companySn;

    @Column(name = "phone_no")
    private String phoneNo;

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
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
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
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result
     */
    public void setResult(String result) {
        this.result = result;
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
     * @return phone_no
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * @param phoneNo
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}