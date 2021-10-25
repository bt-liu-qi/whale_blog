package com.lq.artifact.essay.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lq.artifact.common.exception.BizException;
import com.lq.artifact.essay.dto.EssayDTO;
import com.lq.artifact.essay.entity.Essay;
import com.lq.artifact.essay.entity.EssayClass;
import com.lq.artifact.essay.entity.EssayContent;
import com.lq.artifact.essay.service.EssayClassService;
import com.lq.artifact.essay.service.EssayContentService;
import com.lq.artifact.essay.service.EssayService;
import com.lq.artifact.essay.vo.EssayVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * (Essay)表控制层
 *
 * @author makejava
 * @since 2021-10-17 14:11:06
 */
@Slf4j
@RestController
@RequestMapping("essay")
@Api("文章管理")
public class EssayController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private EssayService essayService;
    @Resource
    private EssayClassService essayClassService;
    @Resource
    private EssayContentService essayContentService;

    @PostMapping("/upload")
    @ResponseBody
    public R upload(@RequestParam("file") List<MultipartFile> file) {
        List<String> fileUrl =new ArrayList<>();
        if (file.isEmpty()) {
            throw new BizException("文件上传失败");
        }
        String filePath = "D:\\IdeaProjects\\whale_blog\\whale\\target\\classes\\static\\file\\";
        for (MultipartFile multipartFile : file) {
            String fileName = multipartFile.getOriginalFilename();
            File dest = new File(filePath + fileName);
            try {
                multipartFile.transferTo(dest);
                log.info("上传成功");
                fileUrl.add("/uploads/file/" + fileName);
            } catch (IOException e) {
                log.error(e.toString(), e);
            }
        }
        return success(fileUrl);
    }




    /**
     * 分页查询所有数据
     *
     * @param page  分页对象
     * @param essay 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Essay> page, Essay essay) {
        final Page<Essay> essayPage = this.essayService.page(page, new QueryWrapper<>(essay));
        List<EssayVO> essayVOList = new ArrayList<>();
        essayPage.getRecords().stream().forEach(data -> {
            EssayClass classDo = essayClassService.getById(data.getClassId());
            EssayContent content = essayContentService.getById(data.getId());
            if (Objects.isNull(content)){
                content = new EssayContent();
            }
            EssayVO essayVO = new EssayVO();
            BeanUtils.copyProperties(data,essayVO);
            essayVO.setClassName(classDo.getName());
            essayVO.setContent(content.getContent());
            essayVOList.add(essayVO);
        });
        Page objectPage = new Page();
        objectPage.setCurrent(essayPage.getCurrent());
        objectPage.setRecords(essayVOList);
        objectPage.setPages(essayPage.getPages());
        objectPage.setSize(essayPage.getSize());
        objectPage.setTotal(essayPage.getTotal());
        return success(objectPage);
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
    public R insert(@RequestBody EssayDTO essay) {
        return success(this.essayService.saveEssay(essay));
    }

    /**
     * 修改数据
     *
     * @param essay 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody EssayDTO essay) {
        return success(this.essayService.updateContent(essay));
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

