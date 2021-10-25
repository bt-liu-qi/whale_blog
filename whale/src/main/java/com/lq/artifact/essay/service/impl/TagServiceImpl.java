package com.lq.artifact.essay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lq.artifact.essay.dao.TagDao;
import com.lq.artifact.essay.entity.Tag;
import com.lq.artifact.essay.service.TagService;
import org.springframework.stereotype.Service;

/**
 * (Tag)表服务实现类
 *
 * @author makejava
 * @since 2021-10-25 21:09:32
 */
@Service("tagService")
public class TagServiceImpl extends ServiceImpl<TagDao, Tag> implements TagService {

}

