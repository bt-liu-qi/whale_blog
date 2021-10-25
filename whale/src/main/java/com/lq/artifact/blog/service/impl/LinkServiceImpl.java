package com.lq.artifact.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lq.artifact.blog.dao.LinkDao;
import com.lq.artifact.blog.entity.Link;
import com.lq.artifact.blog.service.LinkService;
import org.springframework.stereotype.Service;

/**
 * 网站外链(Link)表服务实现类
 *
 * @author makejava
 * @since 2021-10-25 23:08:29
 */
@Service
public class LinkServiceImpl extends ServiceImpl<LinkDao, Link> implements LinkService {

}

