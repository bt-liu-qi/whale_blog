package com.lq.artifact.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lq.artifact.user.dao.UserLoginLogDao;
import com.lq.artifact.user.entity.UserLoginLog;
import com.lq.artifact.user.service.UserLoginLogService;
import org.springframework.stereotype.Service;

/**
 * (UserLoginLog)表服务实现类
 *
 * @author makejava
 * @since 2021-10-05 00:55:25
 */
@Service("userLoginLogService")
public class UserLoginLogServiceImpl extends ServiceImpl<UserLoginLogDao, UserLoginLog> implements UserLoginLogService {

}

