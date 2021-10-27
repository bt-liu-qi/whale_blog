package com.lq.artifact.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lq.artifact.blog.dao.BlogTagDao;
import com.lq.artifact.blog.entity.BlogTag;
import com.lq.artifact.blog.service.BlogTagService;
import org.springframework.stereotype.Service;

/**
 * (BlogTag)表服务实现类
 *
 * @author makejava
 * @since 2021-10-25 22:48:53
 */
@Service("blogTagService")
public class BlogTagServiceImpl extends ServiceImpl<BlogTagDao, BlogTag> implements BlogTagService {

}

