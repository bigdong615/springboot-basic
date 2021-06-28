package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/user/login")

    public String login(@RequestParam("username") String username, Model model, HttpSession httpSession) {

        if ((username.equals("rock"))) {
            httpSession.setAttribute("loginUser", username);
            return "starter";
        } else {
            model.addAttribute("msg", "用户名错误！");
            return "index";
        }
    }
}
