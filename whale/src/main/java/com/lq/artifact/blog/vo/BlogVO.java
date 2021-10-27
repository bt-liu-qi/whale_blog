package com.lq.artifact.blog.vo;

import com.lq.artifact.blog.entity.Blog;
import lombok.Data;

@Data
public class BlogVO extends Blog {

    /**
     * 分类名称
     */
    private String className;

    /**
     * 文章内容
     */
    private String content;
}
