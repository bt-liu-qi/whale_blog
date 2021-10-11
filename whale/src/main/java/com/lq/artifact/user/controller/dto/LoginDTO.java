package com.lq.artifact.user.controller.dto;

import com.sun.xml.internal.ws.developer.Serialization;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Serialization
@ApiModel("用户登录DTO")
public class LoginDTO {

    @ApiModelProperty(example = "张三",dataType = "String",value = "登录用户名")
    private String username;
    @ApiModelProperty(example = "123456",dataType = "String",value = "登录密码")
    private String password;
    @ApiModelProperty(example = "4E:C2:F8:94:60:DD",dataType = "String",value = "mac地址")
    private String mac;
    @ApiModelProperty(example = "1",dataType = "Integer",value = "mac地址")
    private String source;

}
