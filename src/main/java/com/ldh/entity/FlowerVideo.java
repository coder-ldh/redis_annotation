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
 * 视频文件表
 * </p>
 *
 * @author ldh123
 * @since 2018-09-06
 */
@TableName("flower_video")
public class FlowerVideo extends Model<FlowerVideo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "video_id", type = IdType.AUTO)
    private Long videoId;
    /**
     * 路径
     */
    private String url;
    /**
     * 用户ID
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 状态(-1为删除，0为失效，1为正常)
     */
    private Integer status;
    /**
     * 点赞量
     */
    private Integer like;
    @TableField("update_time")
    private Date updateTime;
    @TableField("create_time")
    private Date createTime;


    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
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
        return this.videoId;
    }

    @Override
    public String toString() {
        return "FlowerVideo{" +
        ", videoId=" + videoId +
        ", url=" + url +
        ", userId=" + userId +
        ", status=" + status +
        ", like=" + like +
        ", updateTime=" + updateTime +
        ", createTime=" + createTime +
        "}";
    }
}
