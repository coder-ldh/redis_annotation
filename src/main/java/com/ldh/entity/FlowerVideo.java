package com.ldh.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 视频文件表
 * </p>
 *
 * @author ldh123
 * @since 2018-09-06
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
@TableName("flower_video")
public class FlowerVideo extends Model<FlowerVideo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "video_id", type = IdType.AUTO)
    private Long videoId;
    /**
     * 路径
     */
    @ApiModelProperty(value="路径",name="url",required=true,example="http://www.qiniuyun.com/img/asdsad.jpg")
    private String url;
    /**
     * 用户ID
     */
    @ApiModelProperty(value="用户ID",name="userId",required=true,example="1")
    @TableField("user_id")
    private Long userId;
    /**
     * 状态(-1为删除，0为失效，1为正常)
     */
    @ApiModelProperty(value="状态(-1为删除，0为失效，1为正常)",name="status",required=true,example="1")
    private Integer status;
    /**
     * 点赞量
     */
    @ApiModelProperty(value="点赞量",name="like",required=true,example="232")
    private Integer like;
    @TableField("update_time")
    private Date updateTime;
    @TableField("create_time")
    private Date createTime;

    @Override
    protected Serializable pkVal() {
        return this.videoId;
    }
}
