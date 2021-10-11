package com.lq.artifact.user.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lq.artifact.user.controller.dto.LoginDTO;
import com.lq.artifact.user.controller.dto.UserRegisterDTO;
import com.lq.artifact.user.entity.User;

/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2021-10-05 00:26:45
 */
public interface UserService extends IService<User> {

    /**
     * 用户等
     * @param user 用户信息
     * @return
     */
    R login(LoginDTO user);


    /**
     * 用户注册
     * @param userRegisterDTO
     * @return
     */
    User register(UserRegisterDTO userRegisterDTO);

}

