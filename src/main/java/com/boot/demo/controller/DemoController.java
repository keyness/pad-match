package com.boot.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Keyness on 2018/2/12.
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/page")
    @ResponseBody
    public String hello(){
        ModelAndView modelAndView = new ModelAndView("page/page");
        modelAndView.addObject("name", "keynesssss");
        return "page/page";
    }

    @RequestMapping("/info")
    public Map<String, String> getInfo(@RequestParam String name){
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        return map;
    }

    @RequestMapping("/list")
    public List<Map<String, String>> getList(){
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = null;
        for(int i = 0; i < 5; i++){
            map = new HashMap<>();
            map.put("name", "keyness"+i);
            list.add(map);
        }
        return list;
    }

}
