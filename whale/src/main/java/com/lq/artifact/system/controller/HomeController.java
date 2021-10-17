package com.lq.artifact.system.controller;

import com.lq.artifact.essay.entity.Essay;
import com.lq.artifact.essay.service.EssayService;
import com.lq.artifact.essay.service.impl.EssayServiceImpl;
import com.lq.artifact.essay.vo.EssayVO;
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
    private EssayService essayService;

    @RequestMapping("/index")
    public String home(Model model) {
        // 查询导航栏
        final List<NavigationBar> navigationBars = navigationBarService.list();
        final List<EssayVO> articleItems = essayService.listAll();
        model.addAttribute("articleItems", articleItems);
        model.addAttribute("navigationBars", navigationBars);
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
