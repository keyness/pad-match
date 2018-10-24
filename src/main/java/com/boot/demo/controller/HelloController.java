package com.boot.demo.controller;

import com.boot.demo.service.LocationService;
import java.util.HashMap;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Keyness on 2018/10/16.
 */
@Controller
public class HelloController {

    @Autowired
    private LocationService locationService;

    @RequestMapping("/hello")
    public String toHello(HashMap<String, Object> map){
        map.put("hello","wellcome to html");
        return "/hello";
    }

    @RequestMapping("/toAddLocation")
    public String toAddLocation(){
        return "/addLocation";
    }

    @RequestMapping("/addLocation")
    public String toAddLocation(@Param("xLocation") String xLocation, @Param("yLocation") String yLocation, @Param("item") String item, HashMap<String, String> map){
        map = locationService.create(xLocation, yLocation, item, map);
        return "/result";
    }

}
