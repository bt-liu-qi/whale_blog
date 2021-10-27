package com.lq.artifact.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lq.artifact.blog.entity.BlogSort;
import com.lq.artifact.blog.service.BlogSortService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 文章分类(EssayClass)表控制层
 *
 * @author makejava
 * @since 2021-10-17 15:02:48
 */
@RestController
@RequestMapping("blog/sort")
public class BlogSortController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private BlogSortService blogSortService;

    /**
     * 分页查询所有数据
     *
     * @param page       分页对象
     * @param blogSort 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<BlogSort> page, BlogSort blogSort) {
        return success(this.blogSortService.page(page, new QueryWrapper<>(blogSort)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.blogSortService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param blogSort 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody BlogSort blogSort) {
        return success(this.blogSortService.save(blogSort));
    }

    /**
     * 修改数据
     *
     * @param blogSort 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody BlogSort blogSort) {
        return success(this.blogSortService.updateById(blogSort));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.blogSortService.removeByIds(idList));
    }
}

