package com.lq.artifact.essay.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lq.artifact.essay.entity.EssayContent;
import com.lq.artifact.essay.service.EssayContentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (EssayContent)表控制层
 *
 * @author makejava
 * @since 2021-10-22 21:25:37
 */
@RestController
@RequestMapping("essayContent")
public class EssayContentController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private EssayContentService essayContentService;

    /**
     * 分页查询所有数据
     *
     * @param page         分页对象
     * @param essayContent 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<EssayContent> page, EssayContent essayContent) {
        return success(this.essayContentService.page(page, new QueryWrapper<>(essayContent)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.essayContentService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param essayContent 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody EssayContent essayContent) {
        return success(this.essayContentService.save(essayContent));
    }

    /**
     * 修改数据
     *
     * @param essayContent 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody EssayContent essayContent) {
        return success(this.essayContentService.updateById(essayContent));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.essayContentService.removeByIds(idList));
    }
}

