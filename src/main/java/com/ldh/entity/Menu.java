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
 * 菜单表
 * </p>
 *
 * @author ldh123
 * @since 2018-09-06
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
@TableName("menu")
public class Menu extends Model<Menu> {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID（自增）
     */
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Long menuId;
    /**
     * 菜单code
     */
    @ApiModelProperty(value="菜单code",name="code",required=true,example="1")
    private String code;
    /**
     * 菜单名称
     */
    @ApiModelProperty(value="菜单名称",name="name",required=true,example="1")
    private String name;
    /**
     * 菜单样式
     */
    @ApiModelProperty(value="菜单样式",name="style",required=true,example="1")
    private String style;
    /**
     * 排序
     */
    @ApiModelProperty(value="排序",name="sort",required=true,example="1")
    private Integer sort;
    /**
     * 状态（-1为删除，0为隐藏）
     */
    @ApiModelProperty(value="状态（-1为删除，0为隐藏）",name="status",required=true,example="1")
    private Integer status;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;

    @Override
    protected Serializable pkVal() {
        return this.menuId;
    }
}
