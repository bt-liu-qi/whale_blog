package com.lq.artifact.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lq.artifact.system.dao.NavigationBarDao;
import com.lq.artifact.system.entity.NavigationBar;
import com.lq.artifact.system.service.NavigationBarService;
import org.springframework.stereotype.Service;

/**
 * (NavigationBar)表服务实现类
 *
 * @author makejava
 * @since 2021-10-16 23:40:33
 */
@Service("navigationBarService")
public class NavigationBarServiceImpl extends ServiceImpl<NavigationBarDao, NavigationBar> implements NavigationBarService {

}

