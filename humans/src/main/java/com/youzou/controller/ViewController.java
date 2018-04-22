package com.youzou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 葉蔵 on 2018/4/21.
 */
@Controller
public class ViewController {
    /**
     * 打开后去登陆页面
     * @return
     */
    @RequestMapping("/")
    public String index(){
        return "login";
    }

    /**
     * 未登录去登陆页面
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    /**
     * 跳转到静态页面
     * @param page
     * @return
     */
    @RequestMapping("/pages")
    public String pages(String page){
        return page;
    }
}
