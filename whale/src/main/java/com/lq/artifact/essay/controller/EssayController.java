package com.lq.artifact.essay.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lq.artifact.essay.entity.Essay;
import com.lq.artifact.essay.service.EssayService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Essay)表控制层
 *
 * @author makejava
 * @since 2021-10-17 14:11:06
 */
@RestController
@RequestMapping("essay")
public class EssayController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private EssayService essayService;

    /**
     * 分页查询所有数据
     *
     * @param page  分页对象
     * @param essay 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Essay> page, Essay essay) {
        return success(this.essayService.page(page, new QueryWrapper<>(essay)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.essayService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param essay 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Essay essay) {
        return success(this.essayService.save(essay));
    }

    /**
     * 修改数据
     *
     * @param essay 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Essay essay) {
        return success(this.essayService.updateById(essay));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.essayService.removeByIds(idList));
    }
}

