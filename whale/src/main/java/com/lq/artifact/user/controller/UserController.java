package com.lq.artifact.user.controller;


import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lq.artifact.user.controller.dto.LoginDTO;
import com.lq.artifact.user.controller.dto.UserRegisterDTO;
import com.lq.artifact.user.entity.User;
import com.lq.artifact.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 用户表(User)表控制层
 *
 * @author makejava
 * @since 2021-10-05 00:26:45
 */
@Slf4j
@RestController
@RequestMapping("user")
@Api(value = "用户管理")
public class UserController extends ApiController {


    @Resource
    private Snowflake snowflake;
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param user 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<User> page, User user) {
        return success(this.userService.page(page, new QueryWrapper<>(user)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.userService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody User user) {
        return success(this.userService.save(user));
    }

    /**
     * 修改数据
     *
     * @param user 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody User user) {
        return success(this.userService.updateById(user));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.userService.removeByIds(idList));
    }

    /**
     * 用户登录
     *
     * @param loginDTO
     * @return
     */
    @ApiOperation(value = "用户登陆", notes = "")
    @ApiResponse(responseCode = "2000")
    @PostMapping("login")
    public R login(LoginDTO loginDTO) {
        return success(this.userService.login(loginDTO));
    }


    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "用户登陆", notes = "")
    @ApiResponse(responseCode = "2000")
    @PostMapping("register")
    public R register(@RequestBody UserRegisterDTO user) {
        return success(this.userService.register(user));
    }


    /**
     * 生成Id
     * @return
     */
    @ApiOperation(value = "生成Id", notes = "")
    @ApiResponse(responseCode = "2000")
    @PostMapping("generate/id")
    public R generateId() {
        String idStr = snowflake.nextIdStr();
        log.info("【生成分布式id】 id：{}",idStr);
        int a = 10 / 0;
        return success(idStr);
    }


}

