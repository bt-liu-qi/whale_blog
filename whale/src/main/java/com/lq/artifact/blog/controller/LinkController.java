package com.lq.artifact.blog.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lq.artifact.blog.entity.Link;
import com.lq.artifact.blog.service.LinkService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 网站外链(Link)表控制层
 *
 * @author makejava
 * @since 2021-10-25 23:08:29
 */
@RestController
@RequestMapping("link")
public class LinkController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private LinkService linkService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param link 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Link> page, Link link) {
        return success(this.linkService.page(page, new QueryWrapper<>(link)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.linkService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param link 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Link link) {
        return success(this.linkService.save(link));
    }

    /**
     * 修改数据
     *
     * @param link 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Link link) {
        return success(this.linkService.updateById(link));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.linkService.removeByIds(idList));
    }
}

