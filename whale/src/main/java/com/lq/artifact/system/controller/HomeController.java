package com.lq.artifact.system.controller;

import com.lq.artifact.blog.entity.BlogTag;
import com.lq.artifact.blog.service.BlogService;
import com.lq.artifact.blog.service.BlogTagService;
import com.lq.artifact.blog.vo.BlogVO;
import com.lq.artifact.system.entity.NavigationBar;
import com.lq.artifact.system.service.NavigationBarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "index";
    }

    @RequestMapping("/article")
    public String article(Model model) {
        // 查询导航栏
        final List<NavigationBar> navigationBars = navigationBarService.list();
//        for (int i = 0; i < 10; i++) {
//            navigationBars.add(new NavigationBar());
//        }
        model.addAttribute("navigationBars", navigationBars);
        return "article";
    }
}
