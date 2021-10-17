package com.lq.artifact.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lq.artifact.system.entity.NavigationBar;
import com.lq.artifact.system.service.NavigationBarService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (NavigationBar)表控制层
 *
 * @author makejava
 * @since 2021-10-16 23:40:32
 */
@RestController
@RequestMapping("navigationBar")
public class NavigationBarController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private NavigationBarService navigationBarService;

    /**
     * 分页查询所有数据
     *
     * @param page          分页对象
     * @param navigationBar 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<NavigationBar> page, NavigationBar navigationBar) {
        return success(this.navigationBarService.page(page, new QueryWrapper<>(navigationBar)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.navigationBarService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param navigationBar 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody NavigationBar navigationBar) {
        return success(this.navigationBarService.save(navigationBar));
    }

    /**
     * 修改数据
     *
     * @param navigationBar 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody NavigationBar navigationBar) {
        return success(this.navigationBarService.updateById(navigationBar));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.navigationBarService.removeByIds(idList));
    }
}

