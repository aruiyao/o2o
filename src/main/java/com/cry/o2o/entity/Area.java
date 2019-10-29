/**
 * 
 */
package com.cry.o2o.entity;

import java.util.Date;

/**
 * 区域
 * 
 * @author CRY
 *
 */
public class Area {
    /**区域id*/
    private Integer areaId;

    /**区域名称*/
    private String areaName;

    /**区域权重*/
    private Integer priority;

    /**创建时间*/
    private Date createTime;

    /**更新时间*/
    private Date lastEditTime;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Area [areaId=");
        builder.append(areaId);
        builder.append(", areaName=");
        builder.append(areaName);
        builder.append(", priority=");
        builder.append(priority);
        builder.append(", createTime=");
        builder.append(createTime);
        builder.append(", lastEditTime=");
        builder.append(lastEditTime);
        builder.append("]");
        return builder.toString();
    }

}
