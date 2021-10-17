package com.lq.artifact.user.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户表(User)表实体类
 *
 * @author makejava
 * @since 2021-10-05 00:26:45
 */
@Data
@SuppressWarnings("serial")
@TableName("t_user")
public class User extends Model<User> {
    //主键
    @TableId(type = IdType.INPUT)
    private Long id;
    //用户名
    private String userName;
    //密码
    private String password;
    //电子邮箱
    private String email;
    //头像
    private String avatar;
    //出生日期
    private Date birthdate;
    //性别
    private Integer sex;
    //状态
    private Integer status;
    //标签【，】分割
    private String tags;
    //加盐秘钥
    private String secretKey;
    //最后登录时间
    private Date lastLoginTime;
    //昵称
    private String nickName;
    //创建人
    private Long createUserId;
    //更新时间
    private Date updateTime;
    //创建时间
    private Date createTime;
    //修改人
    private Long updateUserId;
    //是否逻辑删除 1 是 0 否
    @TableLogic
    private Integer isDel;


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}

