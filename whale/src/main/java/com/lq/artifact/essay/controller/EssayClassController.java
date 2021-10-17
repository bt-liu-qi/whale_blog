package com.lq.artifact.essay.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lq.artifact.essay.entity.EssayClass;
import com.lq.artifact.essay.service.EssayClassService;
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
@RequestMapping("essayClass")
public class EssayClassController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private EssayClassService essayClassService;

    /**
     * 分页查询所有数据
     *
     * @param page       分页对象
     * @param essayClass 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<EssayClass> page, EssayClass essayClass) {
        return success(this.essayClassService.page(page, new QueryWrapper<>(essayClass)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.essayClassService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param essayClass 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody EssayClass essayClass) {
        return success(this.essayClassService.save(essayClass));
    }

    /**
     * 修改数据
     *
     * @param essayClass 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody EssayClass essayClass) {
        return success(this.essayClassService.updateById(essayClass));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.essayClassService.removeByIds(idList));
    }
}

