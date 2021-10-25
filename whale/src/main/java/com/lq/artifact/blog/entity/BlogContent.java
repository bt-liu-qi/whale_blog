package com.lq.artifact.blog.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (EssayContent)表实体类
 *
 * @author makejava
 * @since 2021-10-22 21:25:38
 */
@Data
@SuppressWarnings("serial")
@TableName("t_blog_content")
public class BlogContent extends Model<BlogContent> {
    //文章id
    @TableId(type = IdType.INPUT)
    private String id;
    //文章内容
    private String content;






    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}

