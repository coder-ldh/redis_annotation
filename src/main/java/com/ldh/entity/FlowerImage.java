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
 * 图片
 * </p>
 *
 * @author ldh123
 * @since 2018-09-06
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
@TableName("flower_image")
public class FlowerImage extends Model<FlowerImage> {

    private static final long serialVersionUID = 1L;

    /**
     * 图片ID（自增）
     */
    @TableId(value = "image_id", type = IdType.AUTO)
    private Long imageId;
    /**
     * 图片URL
     */
    @TableField("image_url")
    @ApiModelProperty(value="图片URL",name="imageUrl",required=true,example="http://www.qiniuyun.com/img/asdsad.jpg")
    private String imageUrl;
    /**
     * 排序
     */
    @ApiModelProperty(value="排序",name="sort",required=true,example="1")
    private Integer sort;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;

    @Override
    protected Serializable pkVal() {
        return this.imageId;
    }
}
