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
 * 花的分类表
 * </p>
 *
 * @author ldh123
 * @since 2018-09-06
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
@TableName("flower_classify")
public class FlowerClassify extends Model<FlowerClassify> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "classify_id", type = IdType.AUTO)
    private Integer classifyId;
    /**
     * 分类名称
     */
    @ApiModelProperty(value="分类名称",name="name",required=true,example="水仙")
    private String name;
    /**
     * 分类级别
     */
    @ApiModelProperty(value="分类级别",name="level",required=true,example="1")
    private Integer level;
    /**
     * 父节点ID
     */
    @TableField("parent_id")
    @ApiModelProperty(value="父节点ID",name="parentId",required=true,example="0")
    private Integer parentId;
    /**
     * 分类状态（-1删除，0停用，1正常）
     */
    @ApiModelProperty(value="分类状态（-1删除，0停用，1正常）",name="status",required=true,example="1")
    private Integer status;
    /**
     * 分类排序
     */
    @ApiModelProperty(value="分类排序",name="sort",required=true,example="1")
    private Integer sort;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;

    @Override
    protected Serializable pkVal() {
        return this.classifyId;
    }
}
