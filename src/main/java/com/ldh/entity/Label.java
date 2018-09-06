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
 * 标签表
 * </p>
 *
 * @author ldh123
 * @since 2018-09-06
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
@TableName("label")
public class Label extends Model<Label> {

    private static final long serialVersionUID = 1L;

    /**
     * 标签ID
     */
    @TableId(value = "label_id", type = IdType.AUTO)
    private Long labelId;
    /**
     * 创建者
     */
    @ApiModelProperty(value="创建者ID",name="userId",required=true,example="1")
    @TableField("user_id")
    private Long userId;
    /**
     * 标签词
     */
    @ApiModelProperty(value="标签词",name="word",required=true,example="标签词")
    private String word;
    /**
     * 排序
     */
    @ApiModelProperty(value="排序",name="sort",required=true,example="1")
    private Long sort;
    /**
     * 引用数
     */
    @ApiModelProperty(value="引用数",name="count",required=true,example="34")
    private Integer count;
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
        return this.labelId;
    }
}
