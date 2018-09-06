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
 * 花的分类表
 * </p>
 *
 * @author ldh123
 * @since 2018-09-06
 */
@TableName("flower_classify")
public class FlowerClassify extends Model<FlowerClassify> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "classify_id", type = IdType.AUTO)
    private Integer classifyId;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 分类级别
     */
    private Integer level;
    /**
     * 父节点ID
     */
    @TableField("parent_id")
    private Integer parentId;
    /**
     * 分类状态（-1删除，0停用，1正常）
     */
    private Integer status;
    /**
     * 分类排序
     */
    private Integer sort;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;


    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.classifyId;
    }

    @Override
    public String toString() {
        return "FlowerClassify{" +
        ", classifyId=" + classifyId +
        ", name=" + name +
        ", level=" + level +
        ", parentId=" + parentId +
        ", status=" + status +
        ", sort=" + sort +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
