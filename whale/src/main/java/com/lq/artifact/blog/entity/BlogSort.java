package com.lq.artifact.blog.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章分类(EssayClass)表实体类
 *
 * @author makejava
 * @since 2021-10-17 15:02:48
 */
@Data
@SuppressWarnings("serial")
@TableName("t_blog_sort")
public class BlogSort extends Model<BlogSort> {

    @TableId(type = IdType.AUTO)
    private Integer id;
    //分类名称
    private String name;
    //创建人
    private Long createUserId;
    //修改时间
    private Date updateTime;
    //创建时间
    private Date createTime;
    //更新人
    private Long updateUserId;
    //删除
    private Integer isDel;




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

