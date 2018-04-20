package com.youzou.controller;

import com.youzou.domain.Guest;
import com.youzou.service.GusetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 葉蔵 on 2018/4/19.
 */
@Controller
public class IndexController {
    @Autowired
    private GusetService gusetService;
    @RequestMapping("/")
    public String index(){
        return "login";
    }

    @RequestMapping("/login.do")
    public String login(Guest guest, Model model){
        Guest guest1=gusetService.login(guest);
        return "hello";
    }
}
