package com.dearho.business.menu.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.dearho.core.validate.GroupAdd;
import com.dearho.core.validate.GroupUpdate;

@Table(name = "s_user_group")
public class UserGroup {
    @Id
    @GeneratedValue(generator="UUID")
    private String id;

    @NotNull(message = "用户ID不能为空", groups = {GroupAdd.class,GroupUpdate.class})
    @Column(name = "user_id")
    private String userId;

    @NotNull(message = "角色ID不能为空", groups = {GroupAdd.class,GroupUpdate.class})
    @Column(name = "group_id")
    private String groupId;
    
    @Column(name = "order_index")
    private Integer orderIndex;

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
     * @return group_id
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * @param groupId
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

	public Integer getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}
    
    
}