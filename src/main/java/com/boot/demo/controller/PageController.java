package com.boot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Keyness on 2018/4/11.
 */
@Controller
public class PageController {

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("/")
    public String page() {
        return "system/index";
    }


    /**
     * 跳转
     *
     * @return
     */
    @RequestMapping("/redirect")
    public String page2() {
        return "redirect/redirect";
    }


    /**
     * 视图
     *
     * @return
     */
    @RequestMapping("/model")
    public ModelAndView page3() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "seawater");
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}
