package com.lq.artifact.blog.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lq.artifact.blog.entity.Blog;
import com.lq.artifact.blog.entity.BlogSort;
import com.lq.artifact.blog.entity.BlogContent;
import com.lq.artifact.blog.service.BlogService;
import com.lq.artifact.blog.service.BlogSortService;
import com.lq.artifact.blog.service.EssayContentService;
import com.lq.artifact.blog.vo.BlogVO;
import com.lq.artifact.common.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * (Blog)表控制层
 *
 * @author makejava
 * @since 2021-10-25 22:28:42
 */
@Slf4j
@RestController
@RequestMapping("blog")
public class BlogController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private BlogService blogService;

    @Resource
    private BlogSortService blogSortService;
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
    public R selectAll(Page<Blog> page, Blog essay) {
        final Page<Blog> essayPage = this.blogService.page(page, new QueryWrapper<>(essay));
        List<BlogVO> blogVOList = new ArrayList<>();
        essayPage.getRecords().stream().forEach(data -> {
            BlogSort classDo = blogSortService.getById(data.getClassId());
            BlogContent content = essayContentService.getById(data.getId());
            if (Objects.isNull(content)){
                content = new BlogContent();
            }
            BlogVO blogVO = new BlogVO();
            BeanUtils.copyProperties(data, blogVO);
            blogVO.setClassName(classDo.getName());
            blogVO.setContent(content.getContent());
            blogVOList.add(blogVO);
        });
        Page objectPage = new Page();
        objectPage.setCurrent(essayPage.getCurrent());
        objectPage.setRecords(blogVOList);
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
        return success(this.blogService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param blog 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Blog blog) {
        return success(this.blogService.save(blog));
    }

    /**
     * 修改数据
     *
     * @param blog 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Blog blog) {
        return success(this.blogService.updateById(blog));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.blogService.removeByIds(idList));
    }
}

