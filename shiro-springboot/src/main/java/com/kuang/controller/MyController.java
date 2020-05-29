package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 *
 * @author lenovo
 * @date 2020/5/28 13:55
 */
@Controller
public class MyController {
    /**
     * index
     * @param model
     * @return
     */
    @RequestMapping({"/","/index"})
    public String toIndex(Model model){
        model.addAttribute("msg","hello,shiro");
        return "index";
    }

    /**
     * 添加
     * @return
     */
    @RequestMapping("/user/add")
    public String add(){
        return "user/add";
    }

    /**
     * 更新
     * @return
     */
    @RequestMapping("/user/update")
    public String update(){
        return "user/update";
    }
    /**
     * 登陆
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

}
