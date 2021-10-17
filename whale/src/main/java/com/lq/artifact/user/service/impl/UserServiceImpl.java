package com.lq.artifact.user.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import com.lq.artifact.common.exception.BizException;
import com.lq.artifact.common.exception.CommonEnum;
import com.lq.artifact.common.redis.UserRedisKey;
import com.lq.artifact.common.utils.RedisUtil;
import com.lq.artifact.user.controller.dto.LoginDTO;
import com.lq.artifact.user.controller.dto.UserRegisterDTO;
import com.lq.artifact.user.controller.vo.UserLoginVO;
import com.lq.artifact.user.dao.UserDao;
import com.lq.artifact.user.entity.User;
import com.lq.artifact.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2021-10-05 00:26:45
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Resource
    private RedisUtil redisUtil;


    @Override
    public UserLoginVO login(LoginDTO user) {
        User userModel = this.baseMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getUserName, user.getUsername())
                .eq(User::getPassword, user.getPassword())
        );
        if (Objects.isNull(userModel)){
            throw new BizException("用户名或密码错误！");
        }
        // 生成token
        UserLoginVO loginVO = new UserLoginVO();
        loginVO.setId(userModel.getId());
        loginVO.setToken(String.valueOf(userModel.getId()));
        redisUtil.set(UserRedisKey.getUserLoginKey(userModel.getId()), JSON.toJSONString(userModel));
        return loginVO;
    }

    @Override
    public boolean save(User entity) {
        entity.setId(IdUtil.getWorkerId(1,100));
        return super.save(entity);
    }

    @Override
    public User register(UserRegisterDTO user) {
        User userModel = this.baseMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getUserName, user.getUserName()));
        if (Objects.nonNull(userModel)){
            throw new BizException(CommonEnum.USER_NAME_IS_EXIST);
        }
        BeanUtil.copyProperties(user,userModel);
        // 保存用户信息
        baseMapper.insert(userModel);
        return userModel;
    }


    @Override
    public User getUserInfo(String uid) {
        final String rUser = (String) redisUtil.get(UserRedisKey.getUserLoginKey(Long.valueOf(uid)));
        final User userInfo = JSON.parseObject(rUser, User.class);
        return userInfo;
    }
}

