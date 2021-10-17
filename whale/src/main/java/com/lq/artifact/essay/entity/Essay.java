package com.lq.artifact.essay.entity;

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
 * @since 2021-10-17 14:11:07
 */
@Data
@SuppressWarnings("serial")
@TableName("t_essay")
public class Essay extends Model<Essay> {
    //主键
    @TableId(type = IdType.INPUT)
    private Long id;
    //标题
    private String title;
    //分类
    private Long classId;
    //文章内容
    private String content;
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
    //状态
    private String status;
    //文章封面
    private String coverUrl;
    //文章简述
    private String sketch;
    //作者
    private String author;
    //是否开启评论
    private Integer isComment;
    //评论数
    private Integer commentCount;
    //浏览量
    private Long pv;
    //发布时间
    private Date publishTime;



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

