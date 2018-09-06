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
@TableName("label_video")
public class LabelVideo extends Model<LabelVideo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 标签ID
     */
    @TableField("label_id")
    private Long labelId;
    /**
     * 创建者
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 花的视频ID
     */
    @TableField("flower_video_id")
    private Long flowerVideoId;
    /**
     * 状态(-1为删除，0为失效，1为正常)
     */
    private Integer status;
    /**
     * 排序
     */
    private Integer sort;
    @TableField("update_time")
    private Date updateTime;
    @TableField("create_time")
    private Date createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFlowerVideoId() {
        return flowerVideoId;
    }

    public void setFlowerVideoId(Long flowerVideoId) {
        this.flowerVideoId = flowerVideoId;
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
        return this.id;
    }

    @Override
    public String toString() {
        return "LabelVideo{" +
        ", id=" + id +
        ", labelId=" + labelId +
        ", userId=" + userId +
        ", flowerVideoId=" + flowerVideoId +
        ", status=" + status +
        ", sort=" + sort +
        ", updateTime=" + updateTime +
        ", createTime=" + createTime +
        "}";
    }
}
