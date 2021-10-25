package com.lq.artifact.blog.dto;

import com.lq.artifact.blog.entity.Blog;
import lombok.Data;

@Data
public class BlogDTO extends Blog {
    /**
     * 文章内容
     */
    private String content;
}
