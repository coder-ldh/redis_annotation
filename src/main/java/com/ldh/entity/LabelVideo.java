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
 * 
 * </p>
 *
 * @author ldh123
 * @since 2018-09-06
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
@TableName("label_video")
public class LabelVideo extends Model<LabelVideo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 标签ID
     */
    @ApiModelProperty(value="标签ID",name="labelId",required=true,example="1")
    @TableField("label_id")
    private Long labelId;
    /**
     * 创建者
     */
    @ApiModelProperty(value="创建者ID",name="userId",required=true,example="1")
    @TableField("user_id")
    private Long userId;
    /**
     * 花的视频ID
     */
    @ApiModelProperty(value="花的视频ID",name="flowerVideoId",required=true,example="1")
    @TableField("flower_video_id")
    private Long flowerVideoId;
    /**
     * 状态(-1为删除，0为失效，1为正常)
     */
    @ApiModelProperty(value="状态(-1为删除，0为失效，1为正常)",name="status",required=true,example="1")
    private Integer status;
    /**
     * 排序
     */
    @ApiModelProperty(value="排序",name="sort",required=true,example="1")
    private Integer sort;
    @TableField("update_time")
    private Date updateTime;
    @TableField("create_time")
    private Date createTime;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
