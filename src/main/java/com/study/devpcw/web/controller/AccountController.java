package com.study.devpcw.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/account")
public class AccountController {

    @GetMapping("/login")
    public String login() {
        return "account/login";
    }

    @GetMapping("/login-fail")
    public String loginError() {
        return "account/loginFail";
    }

    @GetMapping("/register")
    public String register() {
        return "account/register";
    }
}
