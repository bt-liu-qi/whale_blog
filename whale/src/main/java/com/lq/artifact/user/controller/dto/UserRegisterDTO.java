package com.lq.artifact.user.controller.dto;

import com.lq.artifact.user.entity.User;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "用户注册DTO")
public class UserRegisterDTO  {
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
    private String nickname;
}
