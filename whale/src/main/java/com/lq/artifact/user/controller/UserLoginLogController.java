package com.lq.artifact.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lq.artifact.user.entity.UserLoginLog;
import com.lq.artifact.user.service.UserLoginLogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (UserLoginLog)表控制层
 *
 * @author makejava
 * @since 2021-10-05 00:55:25
 */
@RestController
@RequestMapping("userLoginLog")
public class UserLoginLogController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private UserLoginLogService userLoginLogService;

    /**
     * 分页查询所有数据
     *
     * @param page         分页对象
     * @param userLoginLog 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<UserLoginLog> page, UserLoginLog userLoginLog) {
        return success(this.userLoginLogService.page(page, new QueryWrapper<>(userLoginLog)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.userLoginLogService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param userLoginLog 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody UserLoginLog userLoginLog) {
        return success(this.userLoginLogService.save(userLoginLog));
    }

    /**
     * 修改数据
     *
     * @param userLoginLog 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody UserLoginLog userLoginLog) {
        return success(this.userLoginLogService.updateById(userLoginLog));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.userLoginLogService.removeByIds(idList));
    }
}

