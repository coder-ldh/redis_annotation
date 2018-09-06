package com.ldh.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author ldh123
 * @since 2018-09-06
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
@ApiModel(value="user entity",description="user")
@TableName("user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID（自增）
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    @ApiModelProperty(value="用户ID（自增）",name="userId",hidden = true)
    private Long userId;
    /**
     * 用户名称
     */
    @ApiModelProperty(value="用户名称",name="name",required=true,example="Tom")
    private String name;
    /**
     * 密码
     */
    @ApiModelProperty(value="密码",name="password",example="123456")
    private String password;
    /**
     * 邮件
     */
    @ApiModelProperty(value="邮件",name="email",example="123456@qq.com")
    private String email;
    /**
     * 出生日期
     */
    @ApiModelProperty(value="出生日期",name="birthday")
    private Date birthday;
    /**
     * 性别（1为男，2为女）
     */
    @ApiModelProperty(value="性别（1为男，2为女）",name="sex",example="1")
    private Integer sex;
    /**
     * 状态（-1为删除）
     */
    @ApiModelProperty(value="状态（-1为删除）",name="status",example="1")
    private Integer status;
    /**
     * 手机号码
     */
    @ApiModelProperty(value="手机号码",name="phone",example="13477712166")
    private String phone;
    @TableField("create_time")
    @ApiModelProperty(value="createTime",name="createTime",hidden = true)
    private Date createTime;
    @TableField("update_time")
    @ApiModelProperty(value="updateTime",name="updateTime",hidden = true)
    private Date updateTime;
    @Override
    protected Serializable pkVal() {
        return this.userId;
    }
}