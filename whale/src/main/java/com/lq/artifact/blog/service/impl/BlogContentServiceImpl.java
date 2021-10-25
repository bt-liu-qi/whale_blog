package com.lq.artifact.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lq.artifact.blog.dao.BlogContentDao;
import com.lq.artifact.blog.entity.BlogContent;
import com.lq.artifact.blog.service.EssayContentService;
import org.springframework.stereotype.Service;

/**
 * (EssayContent)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:25:38
 */
@Service
public class BlogContentServiceImpl extends ServiceImpl<BlogContentDao, BlogContent> implements EssayContentService {

}

