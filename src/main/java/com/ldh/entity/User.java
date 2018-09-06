package com.ldh.entity;

import io.swagger.annotations.ApiModel;
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
    private Long userId;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮件
     */
    private String email;
    /**
     * 出生日期
     */
    private Date birthday;
    /**
     * 性别（1为男，2为女）
     */
    private Integer sex;
    /**
     * 状态（-1为删除）
     */
    private Integer status;
    /**
     * 手机号码
     */
    private String phone;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;
    @Override
    protected Serializable pkVal() {
        return this.userId;
    }
}