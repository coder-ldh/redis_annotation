package com.ldh.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ldh123
 * @since 2018-09-06
 */
@TableName("flower")
public class Flower extends Model<Flower> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "flower_id", type = IdType.AUTO)
    private Long flowerId;
    /**
     * 创建者
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 花的名称
     */
    private String name;
    /**
     * 排序
     */
    private Long sort;
    /**
     * 状态(-1为删除，0为失效，1为正常)
     */
    private Integer status;
    @TableField("update_time")
    private Date updateTime;
    @TableField("create_time")
    private Date createTime;


    public Long getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(Long flowerId) {
        this.flowerId = flowerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.flowerId;
    }

    @Override
    public String toString() {
        return "Flower{" +
        ", flowerId=" + flowerId +
        ", userId=" + userId +
        ", name=" + name +
        ", sort=" + sort +
        ", status=" + status +
        ", updateTime=" + updateTime +
        ", createTime=" + createTime +
        "}";
    }
}
