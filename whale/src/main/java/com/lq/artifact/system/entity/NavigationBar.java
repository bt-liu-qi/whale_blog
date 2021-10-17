package com.lq.artifact.system.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (NavigationBar)表实体类
 *
 * @author makejava
 * @since 2021-10-16 23:40:32
 */
@Data
@SuppressWarnings("serial")
@TableName("t_navigation_bar")
public class NavigationBar extends Model<NavigationBar> {

    @TableId(type = IdType.AUTO)
    private Integer id;
    //排序
    private Integer sortId;

    private String title;
    //级别
    private Integer level;
    //图标
    private String icon;
    //路由跳转地址
    private String url;
    //url类型 1 内部 2 外链
    private Integer urlType;
    /**
     * css样式
     */
    private String cssClass;
    //是否显示
    private Integer isShow;
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

