package com.lq.artifact.user.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lq.artifact.common.exception.BizException;
import com.lq.artifact.common.exception.CommonEnum;
import com.lq.artifact.user.controller.dto.LoginDTO;
import com.lq.artifact.user.controller.dto.UserRegisterDTO;
import com.lq.artifact.user.controller.vo.UserLoginVO;
import com.lq.artifact.user.dao.UserDao;
import com.lq.artifact.user.entity.User;
import com.lq.artifact.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;

import java.util.Objects;

/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2021-10-05 00:26:45
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Override
    public R login(LoginDTO user) {
        User userModel = this.baseMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getUserName, user.getUsername())
                .eq(User::getPassword, user.getPassword())
        );
        if (Objects.isNull(userModel)){
            throw new RuntimeException("用户名或密码错误！");
        }
        // 生成token
        UserLoginVO loginVO = new UserLoginVO();
        loginVO.setId(userModel.getId());
        loginVO.setToken(IdUtil.getSnowflake().nextIdStr());
        return R.ok(loginVO);
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
}

