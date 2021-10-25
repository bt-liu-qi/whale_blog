package com.lq.artifact.essay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lq.artifact.essay.dao.EssayContentDao;
import com.lq.artifact.essay.entity.EssayContent;
import com.lq.artifact.essay.service.EssayContentService;
import org.springframework.stereotype.Service;

/**
 * (EssayContent)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:25:38
 */
@Service("essayContentService")
public class EssayContentServiceImpl extends ServiceImpl<EssayContentDao, EssayContent> implements EssayContentService {

}

