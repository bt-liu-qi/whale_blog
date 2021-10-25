package com.lq.artifact.essay.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (EssayContent)表实体类
 *
 * @author makejava
 * @since 2021-10-22 21:25:38
 */
@SuppressWarnings("serial")
@TableName("t_essay_content")
public class EssayContent extends Model<EssayContent> {
    //文章id
    @TableId(type = IdType.INPUT)
    private Long id;
    //文章内容
    private String content;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

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

