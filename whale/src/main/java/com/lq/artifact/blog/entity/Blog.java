package com.lq.artifact.blog.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (Essay)表实体类
 *
 * @author makejava
 * @since 2021-10-22 21:24:24
 */
@Data
@SuppressWarnings("serial")
@TableName("t_blog")
public class Blog extends Model<Blog> {
    //主键
    @TableId(type = IdType.INPUT)
    private String id;
    //标题
    private String title;
    //状态
    private Integer status;
    //封面
    private String coverUrl;
    //简介
    private String sketch;
    //文章作者
    private String author;
    //是否开启评论
    private Integer isComment;
    //评论数
    private Integer commentCount;
    //浏览量
    private Long pv;
    //发布时间
    private Date publishTime;
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
    //分类
    private Integer sortId;





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

