package com.lq.artifact.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lq.artifact.blog.dto.BlogDTO;
import com.lq.artifact.blog.entity.Blog;
import com.lq.artifact.blog.vo.BlogVO;

import java.util.List;

/**
 * (Blog)表服务接口
 *
 * @author makejava
 * @since 2021-10-25 22:28:42
 */
public interface BlogService extends IService<Blog> {
    List<BlogVO> listAll();

    /**
     * 更新文章
     * @param essayDTO
     */
    int updateContent(BlogDTO essayDTO);


    int saveEssay(BlogDTO essayDTO);
}

