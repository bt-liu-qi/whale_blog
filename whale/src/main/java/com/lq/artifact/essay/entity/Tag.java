package com.lq.artifact.essay.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (Tag)表实体类
 *
 * @author makejava
 * @since 2021-10-25 21:09:30
 */
@Data
@TableName("t_tag")
@SuppressWarnings("serial")
public class Tag extends Model<Tag> {
    //主键
    @TableId(type = IdType.AUTO)
    private Integer id;
    //标签名称
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

