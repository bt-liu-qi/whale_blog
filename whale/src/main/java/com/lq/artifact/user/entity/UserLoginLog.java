package com.lq.artifact.user.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (UserLoginLog)表实体类
 *
 * @author makejava
 * @since 2021-10-05 00:55:25
 */
@SuppressWarnings("serial")
@Data
public class UserLoginLog extends Model<UserLoginLog> {
    //主键
    private Long id;
    //用户名
    private String userName;
    //密码
    private String password;
    //ip地址
    private Integer loginIp;
    //mac地址
    private String mac;
    //设备号  包含imei oaid
    private String deviceId;
    //设备平台  1 PC 2 手机 3 ipd 
    private Integer devicePlatform;
    //登录时间
    private Date createTime;



}

