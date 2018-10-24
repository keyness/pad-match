package com.boot.demo.controller;

import com.boot.demo.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Keyness on 2018/4/10.
 */
@RestController
public class HomeController {

    @RequestMapping("/home")
    public String home(){
        User user = new User();
        System.out.println(user.getName());
        System.out.println(user.getAge());
        return "home";
    }

}
