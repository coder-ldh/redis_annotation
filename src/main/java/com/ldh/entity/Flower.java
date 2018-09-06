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
@TableName("flower")
public class Flower extends Model<Flower> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "flower_id", type = IdType.AUTO)
    private Long flowerId;
    /**
     * 创建者
     */
    @TableField("user_id")
    @ApiModelProperty(value="用户ID",name="userId",required=true,example="1")
    private Long userId;
    /**
     * 花的名称
     */
    @ApiModelProperty(value="花的名称",name="name",required=true,example="玫瑰")
    private String name;
    /**
     * 排序
     */
    @ApiModelProperty(value="排序",name="sort",required=true,example="1")
    private Long sort;
    /**
     * 状态(-1为删除，0为失效，1为正常)
     */
    @ApiModelProperty(value="状态(-1为删除，0为失效，1为正常)",name="status",required=true,example="1")
    private Integer status;
    @TableField("update_time")
    private Date updateTime;
    @TableField("create_time")
    private Date createTime;

    @Override
    protected Serializable pkVal() {
        return this.flowerId;
    }
}
