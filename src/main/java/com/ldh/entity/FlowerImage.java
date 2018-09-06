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
 * 图片
 * </p>
 *
 * @author ldh123
 * @since 2018-09-06
 */
@TableName("flower_image")
public class FlowerImage extends Model<FlowerImage> {

    private static final long serialVersionUID = 1L;

    /**
     * 图片ID（自增）
     */
    @TableId(value = "image_id", type = IdType.AUTO)
    private Long imageId;
    /**
     * 菜单名称
     */
    @TableField("image_url")
    private String imageUrl;
    /**
     * 排序
     */
    private Integer sort;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;


    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
        return this.imageId;
    }

    @Override
    public String toString() {
        return "FlowerImage{" +
        ", imageId=" + imageId +
        ", imageUrl=" + imageUrl +
        ", sort=" + sort +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
