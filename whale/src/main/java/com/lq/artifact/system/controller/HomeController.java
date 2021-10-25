package com.lq.artifact.system.controller;

import com.lq.artifact.blog.controller.BlogController;
import com.lq.artifact.blog.entity.Blog;
import com.lq.artifact.blog.entity.BlogContent;
import com.lq.artifact.blog.entity.BlogTag;
import com.lq.artifact.blog.entity.Link;
import com.lq.artifact.blog.service.BlogContentService;
import com.lq.artifact.blog.service.BlogService;
import com.lq.artifact.blog.service.BlogTagService;
import com.lq.artifact.blog.service.LinkService;
import com.lq.artifact.blog.service.impl.BlogContentServiceImpl;
import com.lq.artifact.blog.vo.BlogVO;
import com.lq.artifact.system.entity.NavigationBar;
import com.lq.artifact.system.service.NavigationBarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class HomeController {

    @Resource
    private NavigationBarService navigationBarService;
    @Resource
    private BlogService blogService;
    @Resource
    private BlogTagService blogTagService;
    @Resource
    private LinkService linkService;
    @Resource
    private BlogContentService blogContentService;

    @RequestMapping("/index")
    public String home(Model model) {
        // 查询导航栏
        final List<NavigationBar> navigationBars = navigationBarService.list();
        final List<BlogVO> articleItems = blogService.listAll();
        model.addAttribute("articleItems", articleItems);
        model.addAttribute("navigationBars", navigationBars);
        // 查询标签
        final List<BlogTag> tagList = blogTagService.list();
        model.addAttribute("tagList", tagList);
        // 外链
        final List<Link> linkList = linkService.list();
        model.addAttribute("linkList", linkList);
        return "index";
    }

    @RequestMapping("/article")
    public String article(Model model,@RequestParam String id) {
        // 查询导航栏
        final List<NavigationBar> navigationBars = navigationBarService.list();
        final List<BlogVO> articleItems = blogService.listAll();
        model.addAttribute("articleItems", articleItems);
        model.addAttribute("navigationBars", navigationBars);
        // 查询标签
        final List<BlogTag> tagList = blogTagService.list();
        model.addAttribute("tagList", tagList);
        // 外链
        final List<Link> linkList = linkService.list();
        model.addAttribute("linkList", linkList);
        // 查询网页内容
        final Blog blog = blogService.getById(id);
        model.addAttribute("blog", blog);
        final BlogContent content = blogContentService.getById(blog.getId());
        model.addAttribute("content", content.getContent());
        return "article";
    }
}
