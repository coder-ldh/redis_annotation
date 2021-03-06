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
 * 用户点赞表
 * </p>
 *
 * @author ldh123
 * @since 2018-09-06
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
@TableName("user_like")
public class UserLike extends Model<UserLike> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("user_id")
    @ApiModelProperty(value="用户ID",name="userId",required=true,example="1")
    private Long userId;
    @ApiModelProperty(value="视频ID",name="flowerVideoId",required=true,example="1")
    @TableField("flower_video_id")
    private Long flowerVideoId;
    /**
     * 状态(-1为删除，0为失效，1为正常)
     */
    @ApiModelProperty(value="状态(-1为删除，0为失效，1为正常)",name="status",required=true,example="1")
    private Integer status;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
